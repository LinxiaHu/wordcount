package com.hd.grammer.t1;


/**
 * @author Chunyun 语法测试类
 */
public class JustForTest {

	public static void main(String[] args) {
		// new JustForTest();// 恒生电子笔试题 正确的答案是1一定在2之前输出，红色的3在哪里输出都有可能
		Test1 t1 = new Test1();
		t1.test1();
	}

	private String id = "123";
	private String dept;

	// ！！！！！！！！！！！！！！！！！！ 恒生电子笔试题
	static {
		System.out.println("1");// 类加载就会输出
	}
	{
		System.out.println("2");// 必须有实例被new才会输出
	}

	public JustForTest() {
		System.err.println("3");// 必须有实例被new才会输出
	}

	// ！！！！！！！！！！！！！！！！！！

	static class Test1 {
		private String name;
		private int age;

		public void test1() {
			 System.out.println(new JustForTest().id);
		}
	}

}
