package com.hd.hdfs;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.util.Progressable;

public class FileCopy {
	public static void main(String[] args) {
		String localSrc = args[0];
		String dst = args[1];
		FileSystem fs;
		InputStream in;
		OutputStream out;
		Configuration conf;
		try {
			in = new BufferedInputStream(new FileInputStream(localSrc));
			conf = new Configuration();
			fs = FileSystem.get(URI.create(dst), conf);
			out = fs.create(new Path(dst), new Progressable() {
				@Override
				public void progress() {
					System.out.println(".");
				}
			});
		IOUtils.copyBytes(in, out, 4096, true);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
