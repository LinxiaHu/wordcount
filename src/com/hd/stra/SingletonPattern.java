package com.hd.stra;

public class SingletonPattern {
	private static final SingletonPattern singleton = new SingletonPattern();
	private SingletonPattern(){
		
	}
	public synchronized static SingletonPattern getInstance(){
		return singleton;//»ñÈ¡µ¥Àý
	}
	public static void main(String[] args) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(Thread.currentThread().getName());
				System.out.println(SingletonPattern.getInstance());
			}
		}).start();
		
		
		new Thread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						System.out.println(Thread.currentThread().getName());
						System.out.println(SingletonPattern.getInstance());
					}
				}).start();
	}
}
