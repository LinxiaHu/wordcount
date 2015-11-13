package com.hd.algorithms;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;


/**
 * @author Chunyun
 * ʹ��2������ʵ��һ��ջ
 * @param <T>
 */
public class MyStack<T> {
	
	Queue<T> q1, q2;
	public MyStack(){
		q1 = new LinkedBlockingQueue<T>();
		q2 = new LinkedBlockingQueue<T>();
	}
	
	public void push(T value){
		q1.add(value);
	}
	
	public T pop(){
		if(q1.isEmpty() && q2.isEmpty()){
			try {
				throw new Exception("ջ�ѿգ�");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//��ֹ���
		if (q1.size() == 1) {
			return q1.poll();
		}//��q1��ֻ��һ��Ԫ��ʱ���ܳ�ջ
		
		while(!q2.isEmpty()){
			q1.add(q2.poll());
		}//���q2�ǿգ���Ҫ������Ԫ�ؼӵ�q1��
		while(q1.size() > 1){
			q2.add(q1.poll());
		}//��q1��Ԫ�ش���1�����򽫶���ķ���q2��
		return q1.poll();//��q1��ֻ��һ��Ԫ��ʱ���ܳ�ջ
	}
	
	public static void main(String[] args) {
		MyStack<Integer> stack = new MyStack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
//		System.out.println(stack.pop());
//		System.out.println(stack.pop());
	}
}
