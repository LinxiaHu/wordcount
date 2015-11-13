
package com.hd.grammer.t1;

/**
 * @author Chunyun
 * 引用计数算法的缺点--无法回收循环引用
 */
public class ReferenceCountinGC {
	
	public Object instance = null;
	private static final int _1MB = 1024 * 1024;
	/**
	 * 这个成员变量唯一的意义是占用内存，以便在GC日志中能看清楚是否被回收过
	 */
	private byte[] bigSize = new byte[2 * _1MB];
	
	public static void testGC(){
		ReferenceCountinGC objA = new ReferenceCountinGC();
		ReferenceCountinGC objB = new ReferenceCountinGC();
		//循环引用
		objA.instance = objB;
		objB.instance = objA;
		
		objA = null;
		objB = null;
		
		System.gc();//测试是否能把回收，若能则表示用的不是引用计数算法
	}
	
	public static void main(String[] args) {
		testGC();
	}
}
