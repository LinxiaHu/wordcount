package com.hd.algorithms;

public class ZipTheString {
	public static void main(String[] args) {
		String test = "aabcccdefffffg";
		System.out.println(zipTheString(test));
	}

	static String zipTheString(String s) {
		char[] temp = s.toCharArray();
		int len = temp.length;
		int count = 1;
		int k = 0;
		for (k = 1; k < len - 1; k++) {
			count = 1;
			while ((temp[k - 1] == temp[k]) && k < len - 1) {
				temp[k - 1] = '0';
				k++;
				count++;

			}
			if (count > 1) {
				temp[k - 1] = temp[k];
				temp[k] = (char) (count + '0');
			}
		}
		for (int i = 0, j = 0; i < len && j < len;) {
			while (temp[i] != '0' && i < len) {
				i++;
			}
			while (temp[j] == '0' && j < len) {
				j++;
			}
			swap(temp, i, j);
		}
		return temp.toString();
	}

	private static void swap(char[] temp, int i, int j) {
		char t = temp[i];
		temp[i] = temp[j];
		temp[j] = t;
	}

}
