package com.hd.threads;

import java.util.Random;

public class ThreadLocalTest {

	/**
	 * @param args
	 */
	static ThreadLocal<Integer> mapofThread = new ThreadLocal<Integer>();
	public static void main(String[] args) {
 		for (int i = 0; i < 2; i++) {
 			new Thread(new Runnable() {
 				
 				@Override
 				public void run() {
 					Integer data = new Random().nextInt();
 					System.out.println(Thread.currentThread().getName()+" put data:"+data);
 					mapofThread.set(data);
 					new A().get();
 					new B().get();
 				}
 			}).start();
		}
		
	}
	 	
	   static class A{
	 		 void get(){
	 			Integer data = mapofThread.get();
	 			System.out.println("A Get data from "+Thread.currentThread().getName()+":"+data);
	 		}
	 	}
	 	
	   static class B{
	 		 void get(){
	 			Integer data = mapofThread.get();
	 			System.out.println("B Get data from "+Thread.currentThread().getName()+":"+data);
	 		}
	 	}

	}
