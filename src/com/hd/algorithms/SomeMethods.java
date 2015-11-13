package com.hd.algorithms;

import java.util.HashMap;


/**
 * @author Chunyun
 *
 */
public class SomeMethods {
	
	/**
	 * @param a 传入一个有正数负数的整型数组，找出总和最大的连续数列
	 * @return  返回总和
	 */
	public static int getMaxSum(int[] a){
		int maxsum = 0;
		int sum = 0;
		for(int i = 0; i < a.length; i++){
			sum += a[i];
			if(maxsum < sum){
				maxsum = sum;
			}else if(sum < 0) {//只要某个时刻的和小于0，就丢去当前的和
				sum = 0;
			}
		}
		return maxsum;
	}
	
	/**
	 * @param book 单词列表，求列表中每个单词的频数
	 * @return table 单词及其频数的hashmap
	 */
	public static HashMap<String, Integer> setupDictionary(String[] book){
		HashMap<String, Integer> table = new HashMap<String, Integer>();
		for(String word : book){
			word = word.toLowerCase();
			if (word.trim() != "") {
				if(!table.containsKey(word)){
					table.put(word, 0);
				}
				table.put(word, table.get(word) + 1);
			}
		}
		return table;
	}
	
}
