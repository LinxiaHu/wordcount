package com.hd.grammer.t1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SubandMainConditition {

	/**
	 * @param args
	 */
	static class Business{
		private Lock lock = new ReentrantLock();//此时无需再使用synchronized来修饰sub()和main()了
		Condition condition = lock.newCondition(); 
    	boolean bShouleGo = false;
		public void main(int time) {
			lock.lock();
			while (bShouleGo) {
				try {
//					this.wait();
					condition.await();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					lock.unlock();
				}
			}
			for(int i=0; i<20; i++){
				System.out.println("主线程第"+time+"次循环的第"+i+"次");
			}
			bShouleGo = true;
//			this.notify();
			condition.signal();
		}
		public void sub(int time) {
			lock.lock();
			while (!bShouleGo) {
				try {
//					this.wait();
					condition.await();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					lock.unlock();
				}
			}
			for(int i=0; i<20; i++){
				System.out.println("子线程第"+time+"次循环的第"+i+"次");
			}
			bShouleGo = false;
//			this.notify();
			condition.signal();
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
