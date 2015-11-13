package com.hd.algorithms;

import java.util.Scanner;

import org.aspectj.org.eclipse.jdt.core.dom.ThisExpression;


public class ExamOf3602 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			fenjie(n);
		}

	}

	public static void fenjie(int n) {
		for (int i = 2; i <= n; i++) {
			if (i == n) {
				System.out.print(i);
				return;
			}
			if (n > i && (n % i == 0)) {
				System.out.print(i + "*");
				fenjie(n / i);
				break;
			}
		}
	}
	
	public static void parse(int n){
		String[] data = {"0", "1",""};
	}

}
