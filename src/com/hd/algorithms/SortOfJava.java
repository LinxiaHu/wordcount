package com.hd.algorithms;

import java.util.Arrays;

public class SortOfJava {
	
	public static void TestOfSort(){
		int a[] = {2,3,2,-1,9,77,21,31,19};
		Arrays.sort(a);//自帶的快速排序，從小到大排序
		for(int c : a){
			System.out.println(c);
		}
		System.out.println(Arrays.binarySearch(a, 19));//二分查找，数组必须是有序的才能调用
	}
	
	public static boolean getBit(int num, int i){
		return ((num & (1 << i)) != 0);//检测num的第i位，等于0则表示第i位是0，否则是1
	}
	
	public static int setBit(int num, int i){
		return num | (1 << i);//将num的第i为设为1
	}
	
	public static int clearBit(int num, int i){
		int mask = ~(1 << i);//将num的第i为清零
		return num & mask;
	}
	
	public static void main(String[] args) {
//		SortOfJava.TestOfSort();
		System.out.println(SortOfJava.getBit(10, 2));//00001010 & 00000100
	}
}
