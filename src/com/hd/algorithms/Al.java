package com.hd.algorithms;

import java.util.Random;

/**
 * @author Chunyun
 * ֻ��random�࣬ʵ�������ӡ900��1-1000����Ȼ�������Ҳ����ظ�
 */

public class Al {
	public static void myRam(){
		Random ram = new Random();
//		int[] table = new int[1001];//int��hash������ӳ�������
		boolean[] btable = new boolean[1001];//bool��hash������ӳ�������
//		System.out.println(btable[100]);//Ĭ�ϳ�ʼ��Ϊfalse
//		System.out.println(table[100]);//Ĭ�ϳ�ʼ��Ϊ0
		int count = 0;//��¼900����
		int tar;
		while(count < 901){
			tar = ram.nextInt(1001);
			if (btable[tar]) {
				continue;//���ظ���ֱ�ӽ�����һ��ѭ��
			}
//			table[tar]++;//���������Ѿ������ˣ���ֹ�ظ�
			btable[tar] = true;//���������Ѿ������ˣ���ֹ�ظ�
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
