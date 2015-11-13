package com.hd.algorithms;

import java.util.Arrays;

public class SortOfJava {
	
	public static void TestOfSort(){
		int a[] = {2,3,2,-1,9,77,21,31,19};
		Arrays.sort(a);//�Ԏ��Ŀ������򣬏�С��������
		for(int c : a){
			System.out.println(c);
		}
		System.out.println(Arrays.binarySearch(a, 19));//���ֲ��ң��������������Ĳ��ܵ���
	}
	
	public static boolean getBit(int num, int i){
		return ((num & (1 << i)) != 0);//���num�ĵ�iλ������0���ʾ��iλ��0��������1
	}
	
	public static int setBit(int num, int i){
		return num | (1 << i);//��num�ĵ�iΪ��Ϊ1
	}
	
	public static int clearBit(int num, int i){
		int mask = ~(1 << i);//��num�ĵ�iΪ����
		return num & mask;
	}
	
	public static void main(String[] args) {
//		SortOfJava.TestOfSort();
		System.out.println(SortOfJava.getBit(10, 2));//00001010 & 00000100
	}
}
