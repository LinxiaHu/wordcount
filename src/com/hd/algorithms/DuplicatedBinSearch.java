package com.hd.algorithms;

/**
 * @author Chunyun
 * 
 *         二分查找，查找target，在区间[start，end]之间 有重复元素，返回最后一个下标 其他情况返回-1
 */

public class DuplicatedBinSearch {
	public static void main(String[] args) {
		int[] test = { 0, 0, 1, 2, 3, 4, 5, 5, 6, 6, 6, 7, 8, 9 };
		int length = test.length;
		int start = 0, end = 13;
		int index = dupBinSearch(test, length, 0, start, end);
		System.out.println(index);
	}

	static int dupBinSearch(int[] arr, int len, int target, int start, int end) {
		if (start <= end) {
			int mid = (start + end) >> 2;
			int val = arr[mid];
			if (target < val) {
				return dupBinSearch(arr, len, target, start, mid - 1);
			} else if (target > val) {
				return dupBinSearch(arr, len, target, mid + 1, end);
			} else {
				if (mid + 1 < len && arr[mid + 1] == arr[mid]) {
					return dupBinSearch(arr, len, target, mid + 1, end);
				}
				return mid;
			}
		} else {
			return -1;
		}
	}
}
