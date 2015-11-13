package com.hd.grammer.t1;

public class OnlyTest {
	private int a;

	public static void main(String[] args) {

		// int a = 0x1f112233;
		// byte b = (byte)a;
		// System.out.println(b);//51����0x33��˵����ȡ����͵�һ���ֽڣ���С����
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
												// ����equals��ȵ�2��������hascodeһ�����

		System.out
				.println("������������������������������������������������������������������������������������������������������������");

		String s1 = "ŷ�ޱ�";
		String s2 = new String("ŷ�ޱ�");
		System.out.println(s1 == s2);// false
		String s3 = s2.intern();
		System.out.println(s1 == s3);// true
		System.out.println(s2 == s3);// false

		System.out
				.println("������������������������������������������������������������������������������������������������������������");

		String s4 = new StringBuilder("a").append("va").toString();
		System.out.println(s4.intern() == s4);// true

		String s5 = new StringBuilder("").append("java").toString();
		System.out.println(s5.intern() == s5);// false

		System.out
				.println("������������������������������������������������������������������������������������������������������������");

		String s6 = new String("sy");
		String s7 = s6.intern();
		System.out.println(s7 == s6);// false,˵������s6�ڳ���������ӡ�sy����s6�����ڶ���

		System.out
				.println("������������������������������������������������������������������������������������������������������������");
		new OnlyTest().test1();// 0
		new OnlyTest().binaryTest();
		new OnlyTest().undetLineTest();
		System.out
				.println("������������������������������������������������������������������������������������������������������������");

		new OnlyTest().arrayTest();
		System.out
				.println("������������������������������������������������������������������������������������������������������������");
	}

	void test1() {
		int a = 1;// �ֲ���������Ҫ��ʼ��
		System.out.println(this.a);
		int b = 3;

	}

	void binaryTest() {
		int a = 0b0100;// �����Ʊ�ʾ
		System.out.println(a);
	}

	void undetLineTest() {
		long l = 100_000_000L;// ����ʹ���»��ߣ�����Դ����ɶ���
		int binary = 0b0001_0100_0010;
		System.out.println(l);
		System.out.println(binary);
	}

	void arrayTest() {
		Object[] objarry = new Object[3];
		objarry[1] = new Object[4];// ֻ��Object���͵Ĳſ�������ֱ����ָ��Ԫ�ص����ͣ������int��ȷ�������Ͳ�����ֱ�Ӹ�ֵ�������
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
