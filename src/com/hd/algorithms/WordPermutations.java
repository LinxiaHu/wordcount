package com.hd.algorithms;

import java.util.ArrayList;
import java.util.List;



/**
 * @author Chunyun
 * 确定某字符串的所有排列组合 
 */

public class WordPermutations {
	
	public static List<String> getPerms(String str){
		if (str == null) {
			return null;
		}
		List<String> permutations = new ArrayList<String>();
		if (str.length() == 0) {//最后一个单词传入，并被分割成2部分后，remainder==''，所以length==0
			permutations.add("");
			return permutations;
		}
		
		char first = str.charAt(0);//取出待插入的字符
		String remainder = str.substring(1);
		List<String> words = getPerms(remainder);//递归
		for(String word : words){
			for(int j = 0; j <= word.length(); j++){
				String s = insertCharAt(word, first, j);//将第一个取出的字符依次插入剩余的字符串中
				permutations.add(s);
			}
		}
		return permutations;
	}

	private static String insertCharAt(String word, char first, int i) {
		String start = word.substring(0, i);
		String end = word.substring(i);
		return start + first + end;
	}
	
	public static void main(String[] args) {
		String t1 = "hadoop";
		List<String> per = new ArrayList<String>();
		per = WordPermutations.getPerms(t1);
		for(String s : per){
			System.out.println(s);
		}
		
		
//		String t2 = "a";
//		String t20 = t2.substring(1);
//		System.out.println(t20.length());//0
//		System.out.println(WordPermutations.insertCharAt("", 'a', 0));//a
		
	}
}
