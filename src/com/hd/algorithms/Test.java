package com.hd.algorithms;



public class Test {
	
	public static void main(String[] args) {
		byte b = (byte)128;
		System.out.println(b);//-128,溢出
		
		int a = 1;
		int len = 1;//注意不要从0开始
		while(a > 0){
			a <<= 1;//用于测试机器上int是16位，32位还是64位等
			len++;
		}
		System.out.println("此机器上目前编译环境下int的长度是：" + len);
		
		long l = 1;
		long llen = 1;
		while(l > 0){
			l <<= 1;
			llen++;
		}
		System.out.println("此机器上目前编译环境下long的长度是：" + llen);
	}
}
