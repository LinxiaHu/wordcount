package com.hd.algorithms;


/**
 * @author Chunyun
 * ����n�Ľ׳�ĩβ0�ĸ���
 */
public class ZeroNumberOfFactorial {
	public static int NumberOfFactorial(int n){//ֻҪ����ÿ�����к���������5�ĸ����������0�ĸ���
		int count = 0;//���ڼ���ĩβ0�ĸ���
		if(n < 0) return -1;
		for(int i = 5; n / i > 0; i *= 5){//����1��n��5�ı����м�����25�ı����м�����125�ı����м���...
			count += n / i;//n / i   ��ʾi�ı����ĸ���
		}//ע�ⲻ��Ҫ��ȥ�ظ��ģ���Ϊ�ظ���������������5�����ӣ���125=5*5*5����Ҫ����3��
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(ZeroNumberOfFactorial.NumberOfFactorial(105));
	}
}
