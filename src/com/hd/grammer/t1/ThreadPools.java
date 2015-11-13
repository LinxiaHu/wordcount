package com.hd.grammer.t1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPools {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		ExecutorService threadPool = Executors.newFixedThreadPool(3);
		ExecutorService threadPool = Executors.newSingleThreadExecutor();//��ʹ�����һ���߳����й�������ʧ���̳߳�Ҳ���ٴ���һ���µ��߳�
//		ExecutorService threadPool = Executors.newCachedThreadPool();
		for(int i=0; i<10; i++){
			final int task = i;
			threadPool.execute(new Runnable() {
				@Override
				public void run() {
					for(int j=0; j<10; j++){
						System.out.println(Thread.currentThread().getName()+"����ִ�е�"+task+"������ĵ�"+j+"��ѭ��");
					}
				}
			});
		}
		threadPool.shutdown();
		Executors.newScheduledThreadPool(3).scheduleAtFixedRate(new Runnable() {
			
			@Override
			public void run() {
				
				System.out.println("Boobingggggggggggg");
			}
		}, 6, 2, TimeUnit.SECONDS);
	}

}
