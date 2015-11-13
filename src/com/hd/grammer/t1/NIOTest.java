package com.hd.grammer.t1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOTest {
	
	public static void main(String[] args) {
		int num = 1000000;
		try {
			FileOutputStream fos = new FileOutputStream(new File("d:/nio_test_data.txt"));
			FileChannel fc = fos.getChannel();
			ByteBuffer bb = ByteBuffer.allocate(num * 4);
			for(int i = 0; i < num; i++){
				bb.put(int2byte(i));
			}
			bb.flip();
			fc.write(bb);
			fc.close();
			
			FileInputStream fis = new FileInputStream(new File("d:/nio_test_data.txt"));
			FileChannel fci = fis.getChannel();
			ByteBuffer bbi = ByteBuffer.allocate(num * 4);
			fci.read(bbi);
			fci.close();
			
			bbi.flip();
			while(bbi.hasRemaining()){
				byte2int(bbi.get(), bbi.get(), bbi.get(), bbi.get());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}


	private static int byte2int(byte b, byte c, byte d, byte e) {
		return ((b & 0xff) << 24) | ((c & 0xff) << 16) | ((d & 0xff) << 8) | (e & 0xff);
	}


	private static byte[] int2byte(int i) {
		byte[] b = new byte[4];
		b[3] = (byte)(i & 0xff);
		b[2] = (byte)((i >> 8) & 0xff);
		b[1] = (byte)((i >> 16) & 0xff);
		b[0] = (byte)((i >> 24));
		return b;
	}
}
