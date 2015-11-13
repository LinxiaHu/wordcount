package com.hd.hdfs.list;

import java.io.IOException;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FileUtil;
import org.apache.hadoop.fs.Path;


public class List {
	public static void main(String[] args) {
		String uri = args[0];
		Configuration conf = new Configuration();
		try {
			FileSystem fs = FileSystem.get(URI.create(uri), conf);
			Path[] paths = new Path[args.length];
			for(int i = 0; i < paths.length; i++){
				paths[i] = new Path(args[i]);
				FileStatus[] status = fs.listStatus(paths);
				Path[] listPaths = FileUtil.stat2Paths(status);
				for(Path path : listPaths){
					System.out.println(path);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
