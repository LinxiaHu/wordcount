package com.hd.mapreduce.maxtemp;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.lib.MultipleTextOutputFormat;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class PartitionByStationUsingMultipleOutputs {

	static class StationMapper extends Mapper<LongWritable, Text, Text, Text>{
		
		private NcdcRecordParser parser = new NcdcRecordParser();
		
		@Override
		protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
			
			parser.parse(value);
			
			context.write(new Text(parser.getStationId()), value);
		}
	}
	
	static class StationReducer extends Reducer<Text, Text, NullWritable, Text>{
		
		@Override
		protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
			
			Iterator itr = values.iterator();
			while(itr.hasNext()){
				context.write(NullWritable.get(), (Text) itr.next());
			}
		}
	}
	
	static class StationNameMultipleTextOutputFormat extends MultipleTextOutputFormat<NullWritable, Text>{
		
		private NcdcRecordParser parser = new NcdcRecordParser();
		
		@Override
		protected String generateFileNameForKeyValue(NullWritable key, Text value, String name) {
			parser.parse(value);
			return parser.getStationId();
		}
	}
	
	
	public static void main(String[] args) {
		
		String[] otherArgs;
		Configuration conf = new Configuration();
		conf.set("mapred.job.tracker", "localhost:9001");
		String[] ioArgs = new String[] {"stationid_in", "stationid_out"};
		try {
			otherArgs = new GenericOptionsParser(conf, ioArgs).getRemainingArgs();
			if(otherArgs.length != 2){
				System.err.println("Usage: Data Sort <in> <out>");
				System.exit(-2);
			}
			
			Job job = new Job(conf);
//			JobConf job1 = new JobConf(PartitionByStationUsingMultipleOutputs.class);
			job.setJarByClass(PartitionByStationUsingMultipleOutputs.class);
			
			job.setMapperClass(StationMapper.class);
			job.setReducerClass(StationReducer.class);
			
			job.setOutputKeyClass(NullWritable.class);
			job.setOutputValueClass(Text.class);
//			job.setOutputFormatClass(StationNameMultipleTextOutputFormat.class);
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
