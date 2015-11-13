package com.hd.grammer.t1;

class Sync {
	
	public static void main(String[] args) {
		final OutPuter outputer = new OutPuter();
		new Thread(new Runnable() {
			public void run() {
				while(true){
					try {
						Thread.sleep(100);
						outputer.output("zhangsan");
						System.out.println();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(100);
						outputer.output1("lisi");
						System.out.println();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(100);
						OutPuter.output2("wangwu");
						System.out.println();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		}).start();
	}
	
	
	
	public static class OutPuter {
		public void output(String name){
			synchronized (OutPuter.class) {
				for(int i = 0; i<name.length(); i++){
					System.out.print(name.charAt(i));
				}
				System.out.println();
			}
		}
		
		public void output1(String name) {
			synchronized (OutPuter.class) {
				for(int i = 0; i<name.length(); i++){
					System.out.print(name.charAt(i));
				}
				System.out.println();
			}
		}
		
		public static void output2(String name) {
			synchronized (OutPuter.class) {
				for(int i = 0; i<name.length(); i++) {
					System.out.print(name.charAt(i));
				}
				System.out.println();
			}
		}
	}
}
