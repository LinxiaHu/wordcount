package com.hd.mapreduce.score;

import java.io.IOException;
import java.util.Iterator;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class Score {
	
	public static void main(String[] args) {
		String[] otherArgs;
		Configuration conf = new Configuration();
		conf.set("mapred.job.tracker", "localhost:9001");
		String[] ioArgs = new String[] {"score_in", "score_out"};
		try {
			otherArgs = new GenericOptionsParser(conf, ioArgs).getRemainingArgs();
			if(otherArgs.length != 2){
				System.err.println("Usage: Data Sort <in> <out>");
				System.exit(-2);
			}
			
			Job job = new Job(conf);
			
			job.setJarByClass(Score.class);
			
			job.setMapperClass(Map.class);
			job.setReducerClass(Reduce.class);
			
			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(IntWritable.class);
			
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
	
	public static class Map extends Mapper<LongWritable, Text, Text, IntWritable>{
		@Override
		protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
			
			String line = value.toString();
			StringTokenizer tokenArticle = new StringTokenizer(line, "\n");
			
			while(tokenArticle.hasMoreElements()){
				StringTokenizer tokenLine = new StringTokenizer(tokenArticle.nextToken());
				String namestr = tokenLine.nextToken();
				String scorestr = tokenLine.nextToken();
				Text name = new Text(namestr);
				int scoretint = Integer.parseInt(scorestr);
				context.write(name, new IntWritable(scoretint));
			}
		}
	}
	
	public static class Reduce extends Reducer<Text, IntWritable, Text, IntWritable>{
		@Override
		protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
			
			int sum = 0;
			int count = 0;
			Iterator<IntWritable> iter = values.iterator();
			while(iter.hasNext()){
				sum += iter.next().get();
				count++;
			}
			
			int average = sum / count;
			
			context.write(key, new IntWritable(average));
			
		}
	}
}
