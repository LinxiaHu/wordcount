package com.hd.grammer.t1;


/**
 * @author Chunyun �﷨������
 */
public class JustForTest {

	public static void main(String[] args) {
		// new JustForTest();// �������ӱ����� ��ȷ�Ĵ���1һ����2֮ǰ�������ɫ��3������������п���
		Test1 t1 = new Test1();
		t1.test1();
	}

	private String id = "123";
	private String dept;

	// ������������������������������������ �������ӱ�����
	static {
		System.out.println("1");// ����ؾͻ����
	}
	{
		System.out.println("2");// ������ʵ����new�Ż����
	}

	public JustForTest() {
		System.err.println("3");// ������ʵ����new�Ż����
	}

	// ������������������������������������

	static class Test1 {
		private String name;
		private int age;

		public void test1() {
			 System.out.println(new JustForTest().id);
		}
	}

}
