package com.hd.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mogujie1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList<Integer>();
		int len = 0;
		while (sc.hasNext()) {
			int total = sc.nextInt();
			// System.out.println(total);
			int temp = sc.nextInt();// 第一个数
			total--;
			// System.out.println(temp);
//			int len = 0;// 最大间隔
			int mylen = 0;
			int k = 0;

			while (total > 0) {
				int next = sc.nextInt();
				total--;
				mylen = next - temp;
				list.add(mylen);
				if (len < mylen) {
					len = mylen;
				}
				temp = next;
			}
//			System.out.println(len);
		}
		for(int i = 0; i < list.size(); i++){
			int temp = list.get(i);
			int next = list.get(i + 1);
			int max = temp + next;
			if(max > len ){
				len = max;
			}
		}
		System.out.println(len);
     
	}
}
