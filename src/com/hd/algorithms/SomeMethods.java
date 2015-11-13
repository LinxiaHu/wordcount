package com.hd.algorithms;

import java.util.HashMap;


/**
 * @author Chunyun
 *
 */
public class SomeMethods {
	
	/**
	 * @param a ����һ���������������������飬�ҳ��ܺ�������������
	 * @return  �����ܺ�
	 */
	public static int getMaxSum(int[] a){
		int maxsum = 0;
		int sum = 0;
		for(int i = 0; i < a.length; i++){
			sum += a[i];
			if(maxsum < sum){
				maxsum = sum;
			}else if(sum < 0) {//ֻҪĳ��ʱ�̵ĺ�С��0���Ͷ�ȥ��ǰ�ĺ�
				sum = 0;
			}
		}
		return maxsum;
	}
	
	/**
	 * @param book �����б����б���ÿ�����ʵ�Ƶ��
	 * @return table ���ʼ���Ƶ����hashmap
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
