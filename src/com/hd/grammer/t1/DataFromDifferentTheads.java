package com.hd.grammer.t1;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class DataFromDifferentTheads {

	/**
	 * @param args
	 */
	//相当于ThreadLocal的功能
	private static Map<Thread, Integer> map = new HashMap<Thread,Integer>();
 	public static void main(String[] args) {
 		for (int i = 0; i < 10; i++) {
 			new Thread(new Runnable() {
 				
 				@Override
 				public void run() {
 					Integer data = new Random().nextInt();
 					System.out.println(Thread.currentThread().getName()+" put data:"+data);
 					map.put(Thread.currentThread(), data);
 					new A().get();
 					new B().get();
 				}
 			}).start();
		}
		
	}
 	
   static class A{
 		 void get(){
 			Integer data = map.get(Thread.currentThread());
 			System.out.println("A Get data from "+Thread.currentThread().getName()+":"+data);
 		}
 	}
 	
   static class B{
 		 void get(){
 			Integer data = map.get(Thread.currentThread());
 			System.out.println("B Get data from "+Thread.currentThread().getName()+":"+data);
 		}
 	}

}
