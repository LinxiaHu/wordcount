package com.hd.algorithms;

import java.util.Scanner;


/**
 * @author Chunyun
 * 查找小于1000万的整数,且这些数字没有重复
 */
public class MyBitSet {
	
	private static final int BITSPERWORD = 32;
	private static final int SHIFT = 5;
	private static final int MASK =  0x1F;
	private static final int N = 10000000;//一千万
	private static final int[] data = new int[1 + N / BITSPERWORD];
	
	public static void setbit(int i){
		data[i >> SHIFT] |= (1 << (i & MASK));//i >> SHIFT表示确定某个数位于哪个32bit的整数中
											  //1 << (i & MASK)表示将一个32bit的空间进行位分配，结果是0-31
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
