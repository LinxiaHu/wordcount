package com.hd.algorithms;


/**
 * @author Chunyun
 * ����2�������Ķ����ƴ���ͬλ�ĸ���
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
		int k = m ^ n;//�������
        int a = 1;
        int b = 0;
        int count = 0;
        String str = Integer.toBinaryString(k);//��k�Ķ����ƴ�
//        System.out.println(str);
        int len = str.length();//�����ƴ��ĳ���
        for(int i = 0; i < len; i++){
            b = a & k;//��λ����ÿһλ�ϵ������Ƿ���1
            if(b > 0){
                count++;
            }
            a <<= 1;
        }
        return count;
	}
}
