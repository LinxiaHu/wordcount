package com.hd.algorithms;


public class Permutation {
	
	public boolean permutation (String s, String t){//判断2个单词是不是变位词，如dog和god
		if (s.length() != t.length()) {
			return false;
		}
		
		int[] letters = new int[256];//进行简单的hash映射
		char[] s_array = s.toCharArray();
		for(char c : s_array){
			letters[c]++;
		}
		
		for(int i = 0; i < t.length(); i++){
			char c = t.charAt(i);
			if(--letters[c] < 0){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Permutation per = new Permutation();
		boolean mark = per.permutation("latter", "etatlr");
		if(mark){
			System.out.println("是变位词");
		}else {
			System.out.println("不是变位词");
		}
	}
	
}
