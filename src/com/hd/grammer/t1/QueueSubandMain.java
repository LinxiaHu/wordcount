package com.hd.grammer.t1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class QueueSubandMain {

	/**
	 * @param args
	 */
	static class Business{//ʹ������Ϊ1������������ʵ��ͬ��
		BlockingQueue<Integer> q1 = new ArrayBlockingQueue<Integer>(1);
		BlockingQueue<Integer> q2 = new ArrayBlockingQueue<Integer>(1);
		{
			try {
				q2.put(1);//�Ƚ�q2����������������main()����ִ��q1.take()�������̱߳�����ִ��
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void main(int time) {
			try {
				q1.take();//����һ������ִ��main()����лᱻ�������������߳�������
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int i=0; i<20; i++){
				System.out.println("���̵߳�"+time+"��ѭ���ĵ�"+i+"��");
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
				System.out.println("���̵߳�"+time+"��ѭ���ĵ�"+i+"��");
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
