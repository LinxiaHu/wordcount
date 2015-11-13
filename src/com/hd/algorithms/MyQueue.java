package com.hd.algorithms;

import java.util.Stack;


/**
 * @author Chunyun
 * ʹ��2��ջʵ��һ������
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
		}//��s1�е�Ԫ�ص���s2��
		while(s2.size() < 1){
			try {
				throw new Exception("�����ѿգ�");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//��ֹ���
		
		return s2.pop();
	}
	
	public T peek(){
		while(s1.size() > 0){
			s2.push(s1.pop());
		}//���ǲ鿴��ҲҪ��s1�е�Ԫ�ص���s2��
		while(s2.size() < 1){
			try {
				throw new Exception("�����ѿ�,�޷��鿴��");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//��ֹ���
		
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
