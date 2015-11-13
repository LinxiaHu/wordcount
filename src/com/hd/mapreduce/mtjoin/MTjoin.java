package com.hd.mapreduce.mtjoin;

import java.io.IOException;
import java.util.Iterator;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class MTjoin {
	
	public static int time = 0;
	
	public static void main(String[] args) {
		String[] otherArgs;
		Configuration conf = new Configuration();
		conf.set("mapred.job.tracker", "localhost:9001");
		String[] ioArgs = new String[] {"mtjoin_in", "mtjoin_out"};
		try {
			otherArgs = new GenericOptionsParser(conf, ioArgs).getRemainingArgs();
			if(otherArgs.length != 2){
				System.err.println("Usage: Data Sort <in> <out>");
				System.exit(-2);
			}
			
			Job job = new Job(conf);
			
			job.setJarByClass(MTjoin.class);
			
			job.setMapperClass(Map.class);
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
		
		@Override
		protected void map(Object key, Text value, Context context) throws IOException, InterruptedException {
			String line = value.toString();
			String relationType = new String();
			if(line.contains("factoryname") == true || line.contains("addressed") == true){
				return;
			}
			
			StringTokenizer iter = new StringTokenizer(line);
			String mapkey = new String();
			String mapvalue = new String();
			int i = 0;//to reconize table 1 or table 2
			
			while(iter.hasMoreTokens()){
				String token = iter.nextToken();
				if(token.charAt(0) >= '0' && token.charAt(0) <= '9'){
					mapkey = token;//confirm it is table 2(addressnum and addressdetial)
					if(i > 0){
						relationType = "1";
					}else {
						relationType = "2";
					}
					continue;
				}
				
				mapvalue += token + " ";//store the name of factory's name
				i++;
			}
			context.write(new Text(mapkey), new Text(relationType + "+" + mapvalue));
		}
	}
	
	public static class Reduce extends Reducer<Text, Text, Text, Text>{
		@Override
		protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
			
			if(time == 0){
				context.write(new Text("factoryname"), new Text("addressname"));
				time++;
			}
			
			int factorynum = 0;
			String[] factory = new String[10];
			int addressnum = 0;
			String[] address = new String[10];
			Iterator ite = values.iterator();
			while(ite.hasNext()){
				String record = ite.next().toString();
				int len = record.length();
				int i = 2;
				if(0 == len){
					continue;
				}
				
				char relationType = record.charAt(0);
				if('1' == relationType){
					factory[factorynum] = record.substring(i);
					factorynum++;
				}
				
				if('2' == relationType){
					address[addressnum] = record.substring(i);
					addressnum++;
				}
				
			}
			
			if(0 != factorynum && 0 != addressnum){
				for(int m = 0; m < factorynum; m++){
					for(int n = 0; n < addressnum; n++){
						context.write(new Text(factory[m]), new Text(address[n]));
					}
				}
			}
		}
	}
}
