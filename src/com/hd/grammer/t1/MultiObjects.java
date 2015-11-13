package com.hd.grammer.t1;

import java.util.Random;
import com.hd.pojos.*;
public class MultiObjects {

	/**
	 * @param args 
	 */
	static class A{
		 void get(){
			 //拿到的是本线程的实例
		 	Persion tmp = Persion.getThreadInstance();
			Integer tmpAge = tmp.getData();
			System.out.println("A Get data from "+Thread.currentThread().getName()+":"+tmpAge);
		}
	}
	
   static class B{
		 void get(){
		 	Persion tmp = Persion.getThreadInstance();//此处是本线程第二次得到实例，但每个线程只有一个实例，所以取得的就是run()代码中的已初始化的实例
			Integer tmpAge = tmp.getData();
			System.out.println("B Get data from "+Thread.currentThread().getName()+":"+tmpAge);
		}
	}
	public static void main(String[] args) {
		
		for (int i = 0; i < 3; i++) {
 			new Thread(new Runnable() {
 				
 				@Override
 				public void run() {
 					Integer data = new Random().nextInt();
 					System.out.println(Thread.currentThread().getName()+" put data:"+data);
 					Persion.getThreadInstance().setData(data);//此处是本线程第一次得到实例，并且将其初始化
 					new A().get();
 					new B().get();
 				}
 			}).start();
		}
	}
}


