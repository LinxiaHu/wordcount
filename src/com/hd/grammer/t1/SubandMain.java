package com.hd.grammer.t1;
public class SubandMain {

	/**
	 * 
	 * @param args
	 * 
	 */
	static class Business{
    	boolean bShouleGo = false;
		public synchronized void main(int time) {
			while (bShouleGo) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			for(int i=0; i<20; i++){
				System.out.println("主线程第"+time+"次循环的第"+i+"次");
			}
			bShouleGo = true;
			this.notify();
			
		}
		public synchronized void sub(int time) {
			while (!bShouleGo) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			for(int i=0; i<10; i++){
				System.out.println("子线程第"+time+"次循环的第"+i+"次");
			}
			bShouleGo = false;
			this.notify();
		}
	}
	public static void main(String[] args) {
	    final Business b1 = new Business();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<50; i++){
					b1.sub(i);
				}
				
			}
		}).start();
		
		for(int j=0; j<50; j++){
			b1.main(j);
		}
	}
}
