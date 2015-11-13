package com.hd.stra;


/**
 * @author Chunyun
 * 实现单例类，并且要加入延迟加载，还要保持线程同步
 */
public class LazySingleton {
	
	private LazySingleton(){
		System.out.println("LazySingleton is creating...");//用于测试单例是否已经被加载
	}
	
	/**
	 * 使用内部类持有单例，LazySingleton被加载时，内部类不会被加载，且实例的建立
	 * 是在类加载时进行的，所以是线程安全的
	 * 但序列化的单例类依旧可以被创建出多个实例，使用时需要注意
	 */
	private static class SingletHolder{
		private static LazySingleton instance = new LazySingleton();
	}
	
	public static LazySingleton getInstance(){
		return SingletHolder.instance;
	}
	
	//该方法只用于测试是否实现了延迟加载
	public static void test(){
		System.out.println("调用了单例类的方法！");
	}
	
	public void using(){
		System.out.println("正在使用单例类！");
	}
	
	public static void main(String[] args) {
		LazySingleton.test();
		LazySingleton ls = LazySingleton.getInstance();
		ls.using();
	}
}
