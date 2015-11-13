package com.hd.algorithms;

/**
 * @author Chunyun 给定一个整形数组，有一个数字出现3次，其他出现2次，找出出现3次的，时间复杂度nlogn,空间复杂度1
 */
public class Rep {
	public static void main(String[] args) {
		int[] test = { 88, 459, 5262, 88, 89, 89, 459, 5262, 71, 38, 38, 71, 71 };
		System.out.println(findRep(test));
	}

	private static int findRep(int[] test) {
		int res = 0;
		int len = test.length;
		if (len < 3) {
			return 0;
		}
		for (int i = 0; i < len; i++) {
			res ^= test[i];
		}
		return res;
	}
}
