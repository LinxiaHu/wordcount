package com.hd.algorithms;

/**
 * @author Chunyun
 * 求一个矩阵中最大的2*2矩阵(元素和最大)的和。
 *如:
 *1 2 0 3 4
 *2 3 4 5 1
 *1 1 5 3 0
 *中最大的是:
 *4 5
 *5 3
 *和为17
 */
import java.util.Scanner;

public class MaxDupMatrix {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		String[] arr = s.split(";");
		int row = arr.length;
		String[] sub = arr[0].split(" ");
		int col = sub.length;
		int[][] matrix = new int[row][col];
		for (int i = 0; i < row; i++) {
			String[] sa = arr[i].split(" ");
			for (int j = 0; j < col; j++) {
				matrix[i][j] = Integer.parseInt(sa[j]);
			}
		}

		int[] result = new int[(row - 1) * (col - 1)];
		for (int i = 0; i < result.length; i++) {
			int r = i / (col - 1);
			int c = i % (col - 1);
			result[i] = matrix[r][c] + matrix[r][c + 1] + matrix[r + 1][c]
					+ matrix[r + 1][c + 1];
		}

		int jieguo = Integer.MIN_VALUE;
		for (int a : result) {
			if (a > jieguo) {
				jieguo = a;
			}
		}
		System.out.println(jieguo);
		scanner.close();
	}

}
