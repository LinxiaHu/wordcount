package com.hd.algorithms;



public class Test {
	
	public static void main(String[] args) {
		byte b = (byte)128;
		System.out.println(b);//-128,���
		
		int a = 1;
		int len = 1;//ע�ⲻҪ��0��ʼ
		while(a > 0){
			a <<= 1;//���ڲ��Ի�����int��16λ��32λ����64λ��
			len++;
		}
		System.out.println("�˻�����Ŀǰ���뻷����int�ĳ����ǣ�" + len);
		
		long l = 1;
		long llen = 1;
		while(l > 0){
			l <<= 1;
			llen++;
		}
		System.out.println("�˻�����Ŀǰ���뻷����long�ĳ����ǣ�" + llen);
	}
}
