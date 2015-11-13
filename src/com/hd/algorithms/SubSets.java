package com.hd.algorithms;

import java.util.ArrayList;

/**
 * @author Chunyun 求一个集合的所有子集
 */
public class SubSets {

	public static ArrayList<ArrayList<Integer>> getSubSets(
			ArrayList<Integer> set) {
		ArrayList<ArrayList<Integer>> allSubs = new ArrayList<ArrayList<Integer>>();
		int max = 1 << set.size();// 用二进制位来表示某个元素，1表示这个元素出现，0表示不出现，共需max位来记录
		for (int k = 0; k < max; k++) {// k=0表示空集，k=1表示有一个元素时的组合，k=2表示有2个元素时的组合，直到全部元素的组合
			ArrayList<Integer> subset = convertIntToSet(k, set);
			allSubs.add(subset);
		}
		return allSubs;
	}

	private static ArrayList<Integer> convertIntToSet(int x,
			ArrayList<Integer> set) {
		ArrayList<Integer> subset = new ArrayList<Integer>();
		int index = 0;
		for (int k = x; k > 0; k >>= 1) {
			if ((k & 1) == 1) {// 本质是对传进来的整数求其二进制串中1的个数
				subset.add(set.get(index));
			}
			index++;
		}
		return subset;
	}

	public static void main(String[] args) {
		ArrayList<Integer> testSet = new ArrayList<Integer>(4);
		testSet.add(0);
		testSet.add(1);
		testSet.add(2);
		testSet.add(3);
		ArrayList<ArrayList<Integer>> subsets;
		subsets = SubSets.getSubSets(testSet);
		for (ArrayList<Integer> sub : subsets) {
			System.out.println(sub);
		}
	}
}
