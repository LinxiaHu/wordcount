package com.hd.mapreduce.sort;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class Sort {
	
	public static class Map extends Mapper<Object, Text, IntWritable, IntWritable>{
		private static IntWritable data = new IntWritable();
		@Override
		protected void map(Object key, Text value,Context context) throws IOException, InterruptedException {
			String line = value.toString();
			data.set(Integer.parseInt(line));
			context.write(data, new IntWritable(1));
		}
	}
	
	public static class Reduce extends Reducer<IntWritable, IntWritable, IntWritable, IntWritable>{
		
		private static IntWritable linenum = new IntWritable(1);
		@Override
		protected void reduce(IntWritable key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
			for(IntWritable val : values){
				context.write(linenum, key);
				linenum = new IntWritable(linenum.get() + 1);
			}
		}
	}
	
	
	public static void main(String[] args) {
		String[] otherArgs;
		Configuration conf = new Configuration();
		conf.set("mapred.job.tracker", "localhost:9001");
		String[] ioArgs = new String[] {"sort_in", "sort_out"};
		try {
			otherArgs = new GenericOptionsParser(conf, ioArgs).getRemainingArgs();
			if(otherArgs.length != 2){
				System.err.println("Usage: Data Sort <in> <out>");
				System.exit(-2);
			}
			
			Job job = new Job(conf);
			
			job.setJarByClass(Sort.class);
			
			job.setMapperClass(Map.class);
			job.setReducerClass(Reduce.class);
			
			job.setOutputKeyClass(IntWritable.class);
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
}
