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
		ExecutorService threadPool = Executors.newSingleThreadExecutor();//即使这个单一的线程运行过程中消失，线程池也会再创造一个新的线程
//		ExecutorService threadPool = Executors.newCachedThreadPool();
		for(int i=0; i<10; i++){
			final int task = i;
			threadPool.execute(new Runnable() {
				@Override
				public void run() {
					for(int j=0; j<10; j++){
						System.out.println(Thread.currentThread().getName()+"正在执行第"+task+"个任务的第"+j+"次循环");
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
