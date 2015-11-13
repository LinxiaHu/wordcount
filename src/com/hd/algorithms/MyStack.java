package com.hd.algorithms;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;


/**
 * @author Chunyun
 * 使用2个队列实现一个栈
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
				throw new Exception("栈已空！");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//防止溢出
		if (q1.size() == 1) {
			return q1.poll();
		}//当q1中只有一个元素时才能出栈
		
		while(!q2.isEmpty()){
			q1.add(q2.poll());
		}//如果q2非空，则要把所有元素加到q1中
		while(q1.size() > 1){
			q2.add(q1.poll());
		}//若q1的元素大于1个，则将多余的放入q2中
		return q1.poll();//当q1中只有一个元素时才能出栈
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
