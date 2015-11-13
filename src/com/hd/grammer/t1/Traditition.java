package com.hd.grammer.t1;

public class Traditition {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i = 0;
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName());
				}
			}
		});
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName());
			i++;
			if (i==10) {
				t1.start();
			}
		}
	}
}
