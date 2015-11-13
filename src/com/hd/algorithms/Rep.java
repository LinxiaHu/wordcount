package com.hd.algorithms;

/**
 * @author Chunyun ����һ���������飬��һ�����ֳ���3�Σ���������2�Σ��ҳ�����3�εģ�ʱ�临�Ӷ�nlogn,�ռ临�Ӷ�1
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
