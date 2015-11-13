package com.hd.grammer.t1;

public class OnlyTest {
	private int a;

	public static void main(String[] args) {

		// int a = 0x1f112233;
		// byte b = (byte)a;
		// System.out.println(b);//51，即0x33，说明截取了最低的一个字节，是小端序
		String str = "good";
		System.out.println(str.hashCode());
		String str1 = "good";
		System.out.println(str1.hashCode());
		String str2 = new String("good");
		System.out.println(str2.hashCode());
		System.out.println(str == str1);// true
		System.out.println(str == str2);// false
		System.out.println(str.equals(str1));// true
		System.out.println(str.equals(str2));// true
												// 对于equals相等的2个对象，其hascode一定相等

		System.out
				.println("——————————————————————————————————————————————————————");

		String s1 = "欧洲杯";
		String s2 = new String("欧洲杯");
		System.out.println(s1 == s2);// false
		String s3 = s2.intern();
		System.out.println(s1 == s3);// true
		System.out.println(s2 == s3);// false

		System.out
				.println("——————————————————————————————————————————————————————");

		String s4 = new StringBuilder("a").append("va").toString();
		System.out.println(s4.intern() == s4);// true

		String s5 = new StringBuilder("").append("java").toString();
		System.out.println(s5.intern() == s5);// false

		System.out
				.println("——————————————————————————————————————————————————————");

		String s6 = new String("sy");
		String s7 = s6.intern();
		System.out.println(s7 == s6);// false,说明利用s6在常量池中添加“sy”后，s6本身还在堆中

		System.out
				.println("——————————————————————————————————————————————————————");
		new OnlyTest().test1();// 0
		new OnlyTest().binaryTest();
		new OnlyTest().undetLineTest();
		System.out
				.println("——————————————————————————————————————————————————————");

		new OnlyTest().arrayTest();
		System.out
				.println("——————————————————————————————————————————————————————");
	}

	void test1() {
		int a = 1;// 局部变量必须要初始化
		System.out.println(this.a);
		int b = 3;

	}

	void binaryTest() {
		int a = 0b0100;// 二进制表示
		System.out.println(a);
	}

	void undetLineTest() {
		long l = 100_000_000L;// 允许使用下划线，增加源代码可读性
		int binary = 0b0001_0100_0010;
		System.out.println(l);
		System.out.println(binary);
	}

	void arrayTest() {
		Object[] objarry = new Object[3];
		objarry[1] = new Object[4];// 只有Object类型的才可以这样直接再指定元素的类型，如果是int等确定的类型不可以直接赋值别的类型
		Object[] objarry1 = (Object[]) objarry[1];
		objarry1[1] = new Integer[4];
		Integer[] intarry = (Integer[]) objarry1[1];
		for (int i = 0; i < intarry.length; i++) {
			intarry[i] = i * 3 + 1;
		}
		System.out.println(intarry[1]);// 4
		System.out
				.println(((Integer[]) (Object[]) ((Object[]) objarry[1])[1])[1]);// 4
	}
}
