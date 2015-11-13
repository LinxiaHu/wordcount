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
							System.out.println(Thread.currentThread().getName()+"准备放入数据");
							queue.put(1);
							System.out.println(Thread.currentThread().getName()+"已经放入数据，目前有"+queue.size()+"个数据");
							
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
						System.out.println(Thread.currentThread().getName()+"准备取数据");
						queue.take();
						System.out.println(Thread.currentThread().getName()+"已经取走一个数据，还剩"+queue.size()+"个数据");
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

}
