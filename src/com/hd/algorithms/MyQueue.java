package com.hd.algorithms;

import java.util.Stack;


/**
 * @author Chunyun
 * 使用2个栈实现一个队列
 * @param <T>
 */
public class MyQueue<T> {
	
	Stack<T> s1, s2;
	MyQueue(){
		s1 = new Stack<T>();
		s2 = new Stack<T>();
	}
	
	public void add(T value){
		s1.push(value);
	}
	
	public T poll(){
		while(s1.size() > 0){
			s2.push(s1.pop());
		}//将s1中的元素弹入s2中
		while(s2.size() < 1){
			try {
				throw new Exception("队列已空！");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//防止溢出
		
		return s2.pop();
	}
	
	public T peek(){
		while(s1.size() > 0){
			s2.push(s1.pop());
		}//若是查看，也要将s1中的元素弹入s2中
		while(s2.size() < 1){
			try {
				throw new Exception("队列已空,无法查看！");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//防止溢出
		
		return s2.peek();
	}
	
	public int size(){
		return s1.size() + s2.size();
	}
	
	public static void main(String[] args) {
		MyQueue<Integer> queue = new MyQueue<Integer>();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.peek());
		System.out.println(queue.peek());
		System.out.println(queue.peek());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
	}
	
}
