package com.hd.algorithms;

import java.util.Scanner;

public class ExamOf360 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		// System.out.println(count);
		int numOfline = 4;
		while (sc.hasNext()) {

			int zhengzhi = sc.nextInt();
			// System.out.println(zhengzhi);
			numOfline--;
			int yingyu = sc.nextInt();
			// System.out.println(yingyu);
			numOfline--;
			int shuxue = sc.nextInt();
			// System.out.println(shuxue);
			numOfline--;
			int zhuanye = sc.nextInt();
			// System.out.println(zhuanye);
			numOfline--;
			int total = zhengzhi + yingyu + shuxue + zhuanye;
			if ((yingyu < 60 || zhengzhi < 60) || (shuxue < 90 || zhuanye < 90)
					|| total < 310) {
				System.out.println("Fail");
			}else if (total >= 350) {
				System.out.println("Gongfei");
			}else if (total >= 310 && total < 350) {
				System.out.println("Zifei");
			}

		}
	}
}
