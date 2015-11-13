package com.hd.algorithms;


/**
 * @author Chunyun
 * 计算2个整数的二进制串不同位的个数
*/
public class CountOfNumDiff {
	
	public static void main(String[] args) {
		int a1 = 1999;
		int a2 = 2299;
		int a3 = 1;
		int a4 = 3;
		int c1 = countBitDiff(a1, a2);
		System.out.println(c1);
	}
	
	public static int countBitDiff(int m, int n) {
		int k = m ^ n;//求其异或
        int a = 1;
        int b = 0;
        int count = 0;
        String str = Integer.toBinaryString(k);//求k的二进制串
//        System.out.println(str);
        int len = str.length();//二进制串的长度
        for(int i = 0; i < len; i++){
            b = a & k;//按位与检测每一位上的数字是否是1
            if(b > 0){
                count++;
            }
            a <<= 1;
        }
        return count;
	}
}
