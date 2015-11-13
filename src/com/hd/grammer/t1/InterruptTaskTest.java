package com.hd.grammer.t1;

public class InterruptTaskTest {
	public static void main(String[] args) throws Exception {
		// �����񽻸�һ���߳�ִ��
		Thread t = new Thread(new ATask());
		t.start();
		// ����һ��ʱ���ж��߳�
		Thread.sleep(1000);//�����߳���ͣ
		t.interrupt();//�����ж��ź�
		System.out.println("****************************");
		System.out.println("Interrupted Thread!");
		System.out.println("****************************");
	}

	static class ATask implements Runnable {

		private double d = 0.0;

		public void run() {
			// �������Ƿ����ж�
			while (!Thread.interrupted()) {
				System.out.println("I am running!");
				for (int i = 0; i < 900000; i++) {
					d = d + (Math.PI + Math.E) / d;
				}
			}

			System.out.println("ATask.run() interrupted!");
		}
	}
}
