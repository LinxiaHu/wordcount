package com.hd.algorithms;

import java.util.LinkedList;

/**
 * @author Chunyun
 * ���������������ʾ��������ÿ��������һ����λ������������ŵģ�Ҳ���Ǹ�λ��������β������д������������������Ͳ�
 * ��������ʽ���ؽ��
 */
public class PartialSum {
	
	/*����һ����װ�࣬���ڴ�ź����λ
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
			l1 = padList(l1, len2 - len1);//���
		}else {
			l2 = padList(l2, len1 - len2);//���
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
	 * @param l Ҫ��������
	 * @param padding Ҫ������Ŀ
	 * @return ԭ��������
	 */
	private LinkedList<Integer> padList(LinkedList<Integer> l, int padding) {
		for(int i = 0; i < padding; i++){
			l.add(0, 0);//�����������ǰ������
		}
		return l;
	}
	
	
	
	
}

