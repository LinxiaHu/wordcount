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
				System.out.println("��ʼ˯��");
				Thread.sleep(1000);
				System.out.println("˯�߽���");
				return "ʱ���ǣ�"+System.currentTimeMillis()/1000;
			    
			}
		};
		FutureTask<String> ft = new FutureTask<String>(mytask);
		Thread thread = new Thread(ft);
		thread.start();
		try {
			System.out.println("ȡ���Ľ���ǣ�"+ft.get());
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
			System.out.println("��һ�ַ����õ��Ľ���ǣ�"+ft2.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
