package com.hd.grammer.t1;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class CallableAndFuture {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService pool = Executors.newSingleThreadExecutor();
		Future<String> future = pool.submit(new Callable<String>() {
			@Override 
			public String call() throws Exception {
				Thread.sleep(1000);
				return "��������Ľ����";
			}
		});
		try {
			System.out.println("�õ��Ľ���ǣ�"+future.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ExecutorService pool2 = Executors.newFixedThreadPool(10);
		//ʹ���̳߳��е��߳�����������ĸ����������get()
		CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(pool2);
		for(int i=0; i<10; i++){
			final int seq = i;
			completionService.submit(new Callable<Integer>() {
				@Override 
				public Integer call() throws Exception {
					try {
						Thread.sleep(new Random().nextInt(5000));
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return seq;
				}
			});
			
		}
		for(int i=0; i<10; i++){
			try {
				System.out.println(completionService.take().get());//��ȡÿ������Ľ��
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
