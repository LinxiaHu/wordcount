package com.hd.algorithms;

import java.util.Scanner;


/**
 * @author Chunyun
 * 数列求和，每一行的输入m,n：m是首项，以后每一项都是前一项的平方根，n表示前n项的和，结果保留2位小数
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
			String my = String.format("%.2f", res);//结果保留2位小数
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
