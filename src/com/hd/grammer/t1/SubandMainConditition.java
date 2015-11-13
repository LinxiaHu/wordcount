package com.hd.grammer.t1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SubandMainConditition {

	/**
	 * @param args
	 */
	static class Business{
		private Lock lock = new ReentrantLock();//��ʱ������ʹ��synchronized������sub()��main()��
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
				System.out.println("���̵߳�"+time+"��ѭ���ĵ�"+i+"��");
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
				System.out.println("���̵߳�"+time+"��ѭ���ĵ�"+i+"��");
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
