package com.hd.algorithms;

import java.util.Scanner;

public class GuShen {
	private static long mark = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			long n = sc.nextLong();
			printRes(n);
		}
	}

	private static void printRes(long n) {
		if (n == 1) {
			System.out.println(1);
		} else if (n == 2) {
			System.out.println(2);
		} else if (n == 3) {
			System.out.println(1);
		} else {
			long res = n - 3;
			long temp = 0;
			for (long i = 3; temp < res; i++) {
				temp += i;
				GuShen.mark++;
			}
			if((temp - 1) == res){
				System.out.println(temp - GuShen.mark - 1 + 1);
			}else if(temp == res){
				System.out.println(temp - GuShen.mark + 1);
			}else{
				long gap = temp - res;
				System.out.println(temp - gap - GuShen.mark + 1 );
			}
			

		}
	}
}
