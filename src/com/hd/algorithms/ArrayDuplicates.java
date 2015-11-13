package com.hd.algorithms;

import java.util.BitSet;


/**
 * @author Chunyun
 * 给定一个数组，包含1到N的整数，N最大是32000，数组可能含有重复的值，且N的取值是不定的，
 * 内存只有4KB，打印所有重复的值
 */
public class ArrayDuplicates {
	
	public static void checkDuplicates(int[] array){
//		final int N = 32000;
		BitSet bs = new BitSet();//默认大小是64
		
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
