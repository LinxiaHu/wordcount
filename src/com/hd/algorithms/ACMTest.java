package com.hd.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ACMTest {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//���ڶ�ȡ�ļ�
		String line = null;
		try {
			while((line = br.readLine()) != null){
//				int numofline = Integer.parseInt(line);//��ȡ��һ�У�Ҳ�����ַ�������
				if(line.length() == 1) continue;
				System.out.println(findTheCode(line));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static char findTheCode(String s) {
		
		char res = 'a';
		StringBuilder sb = new StringBuilder(s);
		int len = s.length();
		Integer[] flag = new Integer[len + 10];
		for(int i = 0; i < len; i++){
			flag[sb.charAt(i)]++; 
		}
		for(int i = 0; i < len; i++){
			if(flag[i] == 1){
				res = sb.charAt(i);
			}
		}
		return res;
	}
}
