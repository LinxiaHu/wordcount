package com.hd.algorithms;

import java.util.Random;

/**
 * @author Chunyun
 * 只用random类，实现随机打印900个1-1000的自然数，并且不能重复
 */

public class Al {
	public static void myRam(){
		Random ram = new Random();
//		int[] table = new int[1001];//int型hash表用于映射随机数
		boolean[] btable = new boolean[1001];//bool型hash表用于映射随机数
//		System.out.println(btable[100]);//默认初始化为false
//		System.out.println(table[100]);//默认初始化为0
		int count = 0;//记录900个数
		int tar;
		while(count < 901){
			tar = ram.nextInt(1001);
			if (btable[tar]) {
				continue;//若重复则直接进行下一次循环
			}
//			table[tar]++;//表明该数已经产生了，防止重复
			btable[tar] = true;//表明该数已经产生了，防止重复
			count++;
			if (count < 901) {
				System.out.println(tar);
			}
			if(count < 901){
				System.out.println("[" + count + "]");
			}
		}
		
	}
	
	public static void main(String[] args) {
		Al.myRam();
	}
}
