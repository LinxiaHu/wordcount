package com.hd.grammer.t1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 Callable<String> mytask = new Callable<String>() {
			@Override
			public String call() throws Exception {
				System.out.println("开始睡眠");
				Thread.sleep(1000);
				System.out.println("睡眠结束");
				return "时间是："+System.currentTimeMillis()/1000;
			    
			}
		};
		FutureTask<String> ft = new FutureTask<String>(mytask);
		Thread thread = new Thread(ft);
		thread.start();
		try {
			System.out.println("取到的结果是："+ft.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("-----------------------------------------");
		FutureTask<String> ft2 = new FutureTask<>(mytask);
		ExecutorService service = Executors.newSingleThreadExecutor();
		service.submit(ft2);
		try {
			System.out.println("另一种方法得到的结果是："+ft2.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
