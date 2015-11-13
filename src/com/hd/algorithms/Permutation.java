package com.hd.algorithms;


public class Permutation {
	
	public boolean permutation (String s, String t){//�ж�2�������ǲ��Ǳ�λ�ʣ���dog��god
		if (s.length() != t.length()) {
			return false;
		}
		
		int[] letters = new int[256];//���м򵥵�hashӳ��
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
			System.out.println("�Ǳ�λ��");
		}else {
			System.out.println("���Ǳ�λ��");
		}
	}
	
}
