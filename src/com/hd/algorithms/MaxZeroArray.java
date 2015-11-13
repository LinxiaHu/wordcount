package com.hd.algorithms;

import java.util.ArrayList;
import java.util.Scanner;

public class MaxZeroArray {

	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(-3);
		list.add(-2);
		list.add(-1);
		list.add(7);
//		while (scanner.hasNext()) {
//			int num = scanner.nextInt();
//			list.add(num);
//		}

		int sum = 0;
		int length = list.size();
		int numOfZero = 0;
		int max = 0;
		int left = 0;
		int right = 0;

		for (int i = 0; i < length; i++) {
			sum = list.get(i);

			int rightCurr = 0;
			for (int j = i + 1; j < length; j++) {
				sum += list.get(j);
				if (sum == 0) {
					numOfZero = j - i;
					rightCurr = j;
				}
			}

			if (numOfZero > max) {
				max = numOfZero;
				left = i;
				right = rightCurr;
			}

		}

		for (int i = left; i <= right; i++) {
			System.out.print(list.get(i) + " ");
		}

//		scanner.close();
	}
}
