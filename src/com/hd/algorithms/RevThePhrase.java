package com.hd.algorithms;

public class RevThePhrase {
	public static void main(String[] args) {
		String test = "hi welcome to mogujie";
		System.out.println(reverseString(test));
		String[] array = { "hi", "hello", "china" };
		System.out.println(array[0]);
		System.out.println(array.length);//3
		System.out.println(array[1].length());//5
	}

	public static String reverseString(String s) {
		if (s == null)
			return null;
		String[] a = s.split(" ");
		StringBuffer sb = new StringBuffer();
		for (int i = a.length - 1; i >= 0; i--) {
			sb.append(a[i] + " ");
		}
		return sb.toString().trim();
	}
}
