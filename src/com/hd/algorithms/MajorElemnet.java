package com.hd.algorithms;

import java.util.Stack;



/**
 * @author Chunyun
 * ����һ�����飬�ҵ���Ԫ�أ���ʱ�临�Ӷ���O(n),���ҵ�Ԫ�س��ִ���������������һ����Ǹ�Ԫ��
 */
public class MajorElemnet {
	
	/**
	 * @param test ���Ե�����
	 * @param result �����Ľ��
	 * @return
	 * �������Ľ���Ƿ������Ԫ�صĶ���
	 */
	public static boolean checkData(int[] test, int result){
		int times = 0;
		for(int i = 0; i < test.length; i++){
			if(test[i] == result){
				times++;
			}
		}
		if(times > test.length >> 1){
			return true;
		}else{
			return false;
		}
	}
	
	public static int major(int[] target){
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0; i < target.length; i++){
			if(stack.size() == 0){
				stack.push(target[i]);
				continue;
			}
			if(stack.peek() == target[i]){
				stack.push(target[i]);
			}else{
				if(stack.size() != 0){
					stack.pop();
				}
			}
		}
		if(checkData(target, stack.peek())){
			return stack.peek();
		}else {
			return Integer.MIN_VALUE;
		}
		
	}
		
	public static int major2(int[] target){
		int result = target[0];
		int times = 1;
		for(int i = 1; i < target.length; i++){
			if(times == 0){//��ʾ���¿�ʼ�������
				result = target[i];
				times = 1;
			}else if(target[i] == result){
				times++;//ע�������times������ʵ�ĳ��ִ�������ʵ�ĳ��ִ���Ҫ�������Ȼ���ж�
			}else{
				times--;
			}		
		}
		if(checkData(target, result)){
			return result;
		}else{
			return Integer.MIN_VALUE;
		}
		
	}
	
	public static void main(String[] args) {
		int[] test = {1,2,3,2,2,1,2};
//		System.out.println(major(test));
		System.out.println(major2(test));
	}
}
