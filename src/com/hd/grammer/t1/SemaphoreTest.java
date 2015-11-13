package com.hd.grammer.t1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		final Semaphore sp = new Semaphore(3);
		for(int i=0; i<10; i++){
		Runnable runnable =	new Runnable() {
				public void run() {
					try {
						sp.acquire();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("�߳�"+Thread.currentThread().getName()+"���룬��ǰ�Ѿ���"+(3-sp.availablePermits())+"����");
					try {
						Thread.sleep((long) (Math.random()*10000));
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("�߳�"+Thread.currentThread().getName()+"�����뿪");
					sp.release();
					System.out.println("�߳�"+Thread.currentThread().getName()+"�Ѿ��뿪,��ǰ��"+(3-sp.availablePermits())+"����");
				}
		};
		service.execute(runnable);
	}
}
}
