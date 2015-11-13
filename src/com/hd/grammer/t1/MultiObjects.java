package com.hd.grammer.t1;

import java.util.Random;
import com.hd.pojos.*;
public class MultiObjects {

	/**
	 * @param args 
	 */
	static class A{
		 void get(){
			 //�õ����Ǳ��̵߳�ʵ��
		 	Persion tmp = Persion.getThreadInstance();
			Integer tmpAge = tmp.getData();
			System.out.println("A Get data from "+Thread.currentThread().getName()+":"+tmpAge);
		}
	}
	
   static class B{
		 void get(){
		 	Persion tmp = Persion.getThreadInstance();//�˴��Ǳ��̵߳ڶ��εõ�ʵ������ÿ���߳�ֻ��һ��ʵ��������ȡ�õľ���run()�����е��ѳ�ʼ����ʵ��
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
 					Persion.getThreadInstance().setData(data);//�˴��Ǳ��̵߳�һ�εõ�ʵ�������ҽ����ʼ��
 					new A().get();
 					new B().get();
 				}
 			}).start();
		}
	}
}


