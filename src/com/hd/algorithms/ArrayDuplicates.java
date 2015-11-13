package com.hd.algorithms;

import java.util.BitSet;


/**
 * @author Chunyun
 * ����һ�����飬����1��N��������N�����32000��������ܺ����ظ���ֵ����N��ȡֵ�ǲ����ģ�
 * �ڴ�ֻ��4KB����ӡ�����ظ���ֵ
 */
public class ArrayDuplicates {
	
	public static void checkDuplicates(int[] array){
//		final int N = 32000;
		BitSet bs = new BitSet();//Ĭ�ϴ�С��64
		
		for(int i = 0; i < array.length; i++){
			int num = array[i];
			if(bs.get(num)) System.out.println(num);
			bs.set(num);
		}
	}
	
	public static void main(String[] args) {
		int[] testData = {1,2,2,3,3,3,3,3,4,5,9,11,11,11,12,13,14,15,17,18,17,19,17,21,29,21};
		ArrayDuplicates.checkDuplicates(testData);
	}
}
