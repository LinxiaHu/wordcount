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
			public void run(){//�����˸����run()����ô������ȥ����target����������ȥִ�д����runnable�еĴ���
				System.out.println("From SubClass");
			}
		}.start();
	}
	
}
