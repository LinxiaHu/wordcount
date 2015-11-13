package com.hd.grammer.t1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockQueue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final BlockingQueue queue = new ArrayBlockingQueue(3);
		for(int i=0;i<3;i++){
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					while(true){
						try {
							Thread.sleep((long) (Math.random()*1000));
							System.out.println(Thread.currentThread().getName()+"׼����������");
							queue.put(1);
							System.out.println(Thread.currentThread().getName()+"�Ѿ��������ݣ�Ŀǰ��"+queue.size()+"������");
							
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					
				}
			}).start();
		}
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(100);
						System.out.println(Thread.currentThread().getName()+"׼��ȡ����");
						queue.take();
						System.out.println(Thread.currentThread().getName()+"�Ѿ�ȡ��һ�����ݣ���ʣ"+queue.size()+"������");
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

}
