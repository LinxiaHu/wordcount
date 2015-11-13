package com.hd.algorithms;

import java.util.Stack;



/**
 * @author Chunyun
 * 给定一个数组，找到主元素，且时间复杂度是O(n),即找到元素出现次数超过数组总数一半的那个元素
 */
public class MajorElemnet {
	
	/**
	 * @param test 测试的数组
	 * @param result 产生的结果
	 * @return
	 * 检查产生的结果是否符合主元素的定义
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
			if(times == 0){//表示重新开始计算次数
				result = target[i];
				times = 1;
			}else if(target[i] == result){
				times++;//注意这里的times不是真实的出现次数，真实的出现次数要另外遍历然后判断
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
