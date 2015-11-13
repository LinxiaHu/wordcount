package com.hd.grammer.t1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Chunyun ����������������ͣ��
 */
public class StopTheWorldTest {
	public static class MyThread extends Thread {
		Map map = new HashMap();

		@Override
		public void run() {
			while (true) {
				if (map.size() * 512 / 1024 / 1024 >= 400) {// ��ֹ�ڴ����
					map.clear();//���ʹ��ǿ���ý�������Ա�GC����
					System.out.println("clean the map");
				}
				byte[] b1;
				for (int i = 0; i < 100; i++) {
					b1 = new byte[512];
					map.put(System.nanoTime(), b1);
				}
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static class PrintThread extends Thread {
		public static final long starttime = System.currentTimeMillis();

		@Override
		public void run() {
			while (true) {
				long t = System.currentTimeMillis() - starttime;
				System.out.println(t / 1000 + "." + t % 1000);
				try {
					Thread.sleep(100);// ÿ��0.1���ӡһ��ʱ������������߳�������ʼ���㣩
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		PrintThread t2 = new PrintThread();
		t1.start();
		t2.start();
	}

}
