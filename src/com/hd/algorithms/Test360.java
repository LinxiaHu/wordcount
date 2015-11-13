package com.hd.algorithms;

import java.util.Scanner;


/**
 * @author Chunyun
 * ������ͣ�ÿһ�е�����m,n��m������Ժ�ÿһ���ǰһ���ƽ������n��ʾǰn��ĺͣ��������2λС��
 */
public class Test360 {
	public static void main(String[] args) {
		int m, n;
		int result;
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextInt()) {
			m = scanner.nextInt();
			n = scanner.nextInt();
			double res = calc(m, n);
			String my = String.format("%.2f", res);//�������2λС��
			System.out.println(my);
		}
	}

	private static double calc(int m, int n) {
		double res = 0.00f;
		double tmp = m;
		for (int i = 0; i < n; i++) {
			res += tmp;
			tmp = Math.sqrt(tmp);
		}
		return res;
	}
}
