package com.hd.grammer.t1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class QueueSubandMain {

	/**
	 * @param args
	 */
	static class Business{//使用容量为1的阻塞队列来实现同步
		BlockingQueue<Integer> q1 = new ArrayBlockingQueue<Integer>(1);
		BlockingQueue<Integer> q2 = new ArrayBlockingQueue<Integer>(1);
		{
			try {
				q2.put(1);//先将q2放满，这样由于在main()中先执行q1.take()所以子线程必须先执行
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void main(int time) {
			try {
				q1.take();//若第一次想先执行main()则队列会被阻塞，所以子线程先运行
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int i=0; i<20; i++){
				System.out.println("主线程第"+time+"次循环的第"+i+"次");
			}
			try {
				q2.put(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public  void sub(int time) {
			try {
				q2.take();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int i=0; i<10; i++){
				System.out.println("子线程第"+time+"次循环的第"+i+"次");
			}
			try {
				q1.put(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
	    final Business b1 = new Business();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<50; i++){
					b1.sub(i);
				}
				
			}
		}).start();
		
		for(int j=0; j<50; j++){
			b1.main(j);
		}
	}
}
