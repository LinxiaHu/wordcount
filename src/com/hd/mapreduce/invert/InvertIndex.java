package com.hd.mapreduce.invert;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class InvertIndex {
	
	public static void main(String[] args) {
		String[] otherArgs;
		Configuration conf = new Configuration();
		conf.set("mapred.job.tracker", "localhost:9001");
		String[] ioArgs = new String[] {"invert_in", "invert_out"};
		try {
			otherArgs = new GenericOptionsParser(conf, ioArgs).getRemainingArgs();
			if(otherArgs.length != 2){
				System.err.println("Usage: Data Sort <in> <out>");
				System.exit(-2);
			}
			
			Job job = new Job(conf);
			
			job.setJarByClass(InvertIndex.class);
			
			job.setMapperClass(Map.class);
			job.setCombinerClass(Combine.class);
			job.setReducerClass(Reduce.class);
			
			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(Text.class);
			
			FileInputFormat.addInputPath(job, new Path(otherArgs[0]));
			FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));
			
			System.exit(job.waitForCompletion(true) ? 0 : 1);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static class Map extends Mapper<Object, Text, Text, Text>{
		
		private Text keyInfo = new Text();
		private Text valueInfo = new Text();
		private FileSplit split;
		
		@Override
		protected void map(Object key, Text value, Context context) throws IOException, InterruptedException {
			
			split = (FileSplit) context.getInputSplit();
			StringTokenizer itr = new StringTokenizer(value.toString());
			while(itr.hasMoreTokens()){
				int splitIndex = split.getPath().toString().indexOf("file");
				keyInfo.set(itr.nextToken() + ":" +split.getPath().toString().substring(splitIndex));
				valueInfo.set("1");
				context.write(keyInfo, valueInfo);
			}
		}
	}
	
	public static class Combine extends Reducer<Text, Text, Text, Text>{
		
		private Text info = new Text();
		
		@Override
		protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
			
			int sum = 0;
			for(Text value : values){
				
				sum += Integer.parseInt(value.toString());
			}
			
			int splitIndex = key.toString().indexOf(":");
			info.set(key.toString().substring(splitIndex + 1) + ":" + sum);//the new value is the url and wordcount(sum)
			key.set(key.toString().substring(0, splitIndex));//the new key is the keyword
			context.write(key, info);
		}
	}
	
	public static class Reduce extends Reducer<Text, Text, Text, Text>{
		
		private Text result = new Text();
		
		@Override
		protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
			
			String fileList = new String();
			for(Text value : values){
				fileList += value.toString() + ";";
			}
			
			result.set(fileList);
			context.write(key, result);
		}
	}
	
	
}
