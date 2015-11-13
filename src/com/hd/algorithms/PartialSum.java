package com.hd.algorithms;

import java.util.LinkedList;

/**
 * @author Chunyun
 * 给定两个用链表表示的整数，每个结点包含一个数位，如果是正向存放的，也就是个位排在链表尾部，编写函数对这两个整数求和并
 * 用链表形式返回结果
 */
public class PartialSum {
	
	/*这是一个包装类，用于存放和与进位
	 *
	 */
	public static class Wrapped{
		public LinkedList<Integer> sum = null;
		public int carry = 0;
	}
	
	public LinkedList<Integer> addList(LinkedList<Integer> l1, LinkedList<Integer> l2){
		int len1 = l1.size();
		int len2 = l2.size();
		if (len1 < len2) {
			l1 = padList(l1, len2 - len1);//填充
		}else {
			l2 = padList(l2, len1 - len2);//填充
		}
		Wrapped sum = addListHelper(l1, l2);
		if (sum.carry == 0) {
			return sum.sum;
		}else {
			LinkedList<Integer> result = insertBefore(sum.sum, sum.carry);
			return result;
		}
		
	}

	private LinkedList<Integer> insertBefore(LinkedList<Integer> sum, int carry) {
		if (sum != null) {
			sum.addLast(carry);
		}
		return null;
	}

	private Wrapped addListHelper(LinkedList<Integer> l1, LinkedList<Integer> l2) {
		if (l1 == null && l2 == null) {
			Wrapped sum = new Wrapped();
			return sum;
		}
	
		return null;
	}

	/**
	 * @param l 要填充的链表
	 * @param padding 要填充的数目
	 * @return 原来的链表
	 */
	private LinkedList<Integer> padList(LinkedList<Integer> l, int padding) {
		for(int i = 0; i < padding; i++){
			l.add(0, 0);//完成在链表最前面的填充
		}
		return l;
	}
	
	
	
	
}

