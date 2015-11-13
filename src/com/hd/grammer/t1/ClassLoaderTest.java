package com.hd.grammer.t1;

public class ClassLoaderTest {
	
	static class Test{
		private int a;
		private int b;
		/**
		 * @return the a
		 */
		public int getA() {
			return a;
		}
		/**
		 * @param a the a to set
		 */
		public void setA(int a) {
			this.a = a;
		}
		/**
		 * @return the b
		 */
		public int getB() {
			return b;
		}
		/**
		 * @param b the b to set
		 */
		public void setB(int b) {
			this.b = b;
		}
		
	}
	
	/**
	 * @param args
	 * 测试类加载器的层次结构
	 */
	public static void main(String[] args) {
		ClassLoader cl = Test.class.getClassLoader();
		while(cl != null){
			System.out.println(cl);
			cl = cl.getParent();
		}
		System.out.println(cl);
	}

}
