package com.hd.algorithms;

import java.util.Scanner;


/**
 * @author Chunyun
 * ����С��1000�������,����Щ����û���ظ�
 */
public class MyBitSet {
	
	private static final int BITSPERWORD = 32;
	private static final int SHIFT = 5;
	private static final int MASK =  0x1F;
	private static final int N = 10000000;//һǧ��
	private static final int[] data = new int[1 + N / BITSPERWORD];
	
	public static void setbit(int i){
		data[i >> SHIFT] |= (1 << (i & MASK));//i >> SHIFT��ʾȷ��ĳ����λ���ĸ�32bit��������
											  //1 << (i & MASK)��ʾ��һ��32bit�Ŀռ����λ���䣬�����0-31
	}
	
	public static void clearbit(int i){
		data[i >> SHIFT] &= ~(1 << (i & MASK));
	}
	
	public static int testbit(int i){
		return data[i >> SHIFT] & (1 << (i & MASK));
	}
	
	public static void main(String[] args) {
		for(int i = 0; i < N; i++){
			clearbit(i);
		}
		
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			if(sc.nextInt() > N) continue;
			if(sc.nextInt() == 0){
				sc.close();
				break;
			}
			setbit(sc.nextInt());
		}
		
		for(int i = 0; i < N; i++){
			if(testbit(i) > 0){
				System.out.println(i);
			}
		}
	}
	
}
