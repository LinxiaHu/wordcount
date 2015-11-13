package com.hd.algorithms;


/**
 * @author Chunyun
 * 计算n的阶乘末尾0的个数
 */
public class ZeroNumberOfFactorial {
	public static int NumberOfFactorial(int n){//只要计算每个数中含有质因数5的个数即可求出0的个数
		int count = 0;//用于计算末尾0的个数
		if(n < 0) return -1;
		for(int i = 5; n / i > 0; i *= 5){//计算1到n中5的倍数有几个，25的倍数有几个，125的倍数有几个...
			count += n / i;//n / i   表示i的倍数的个数
		}//注意不需要减去重复的，因为重复的数本身包含多个5的因子，如125=5*5*5，就要计算3次
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(ZeroNumberOfFactorial.NumberOfFactorial(105));
	}
}
