package com.hd.algorithms;

import java.util.ArrayList;

/**
 * @author Chunyun ��һ�����ϵ������Ӽ�
 */
public class SubSets {

	public static ArrayList<ArrayList<Integer>> getSubSets(
			ArrayList<Integer> set) {
		ArrayList<ArrayList<Integer>> allSubs = new ArrayList<ArrayList<Integer>>();
		int max = 1 << set.size();// �ö�����λ����ʾĳ��Ԫ�أ�1��ʾ���Ԫ�س��֣�0��ʾ�����֣�����maxλ����¼
		for (int k = 0; k < max; k++) {// k=0��ʾ�ռ���k=1��ʾ��һ��Ԫ��ʱ����ϣ�k=2��ʾ��2��Ԫ��ʱ����ϣ�ֱ��ȫ��Ԫ�ص����
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
			if ((k & 1) == 1) {// �����ǶԴ�������������������ƴ���1�ĸ���
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
