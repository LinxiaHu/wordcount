package com.hd.grammer.t1;

public class ThreadT1 {
	public static void main(String[] args) {
		new Thread(new Runnable() {
			
			@Override
			public void run(){
				System.out.println("From Runnable");
			}
		}){
			@Override
			public void run(){//覆盖了父类的run()，那么不会再去调用target，即不会再去执行传入的runnable中的代码
				System.out.println("From SubClass");
			}
		}.start();
	}
	
}
