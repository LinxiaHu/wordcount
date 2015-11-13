package com.hd.grammer.t1;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Download {

	public static void main(String[] args) {
		String path = "http://localhost:8080/AndroidServer/QQIntl2.11.exe";
		new Download().download(path,3);
	}

	private void download(String path,int threadsizes) {
		try {
			URL url = new URL(path);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(5000);
			conn.setRequestMethod("GET");
			if(conn.getResponseCode()==200){
				int length = conn.getContentLength();
				File file = new File(getName(path));
				RandomAccessFile raf = new RandomAccessFile(file,"rwd");
				raf.setLength(length);
				raf.close();
				int block = length/threadsizes==0?(length/threadsizes):(length/threadsizes+1);
				for(int i=0;i<threadsizes;i++){
					new DownloadThread(i,block,url,file).start();
				}
				
				
			}else {
				System.out.println("����ʧ�ܣ�");
			}
			
			
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
/**
 * ��ȡ·�����ļ���
 * 
 */
	private String getName(String path) {
		return path.substring(path.lastIndexOf("/")+1);
	}
	public class DownloadThread extends Thread{
		private int id;
		private int block;
		private URL url;
		private File file;
		public DownloadThread(int id, int block, URL url, File file) {
			super();
			this.id = id;
			this.block = block;
			this.url = url;
			this.file = file;
		}
		public void run(){
			int start = id*block;
			int end = (id+1)*block-1;
			try {
				RandomAccessFile raf = new RandomAccessFile(file, "rwd");
				try {
					raf.seek(start);
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					conn.setConnectTimeout(5000);
					conn.setRequestMethod("GET");
					conn.setRequestProperty("Range","bytes="+start+"-"+end);
					if(conn.getResponseCode()==206){
						InputStream in = conn.getInputStream();
						BufferedInputStream bs = new BufferedInputStream(in);
						byte[] bytes = new byte[1024];
						int len =-1;
						while((len=bs.read(bytes))!=-1){
							raf.write(bytes,0,len);
						}
						raf.close();
						bs.close();
						in.close();
					}
					System.out.println("��"+id+"���߳�������أ�");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
