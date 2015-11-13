package com.hd.grammer.t1;

public class MinorGC {
	private static final int _1MB = 1024 * 1024;

	public static void testAllocation() {
		byte[] allocation1, allocation2, allocation3, allocation4;//引用变量存在于虚拟机栈中
		allocation1 = new byte[2 * _1MB];//new byte[]存在于堆中
		allocation2 = new byte[2 * _1MB];
		allocation3 = new byte[2 * _1MB];
		allocation4 = new byte[4 * _1MB];
	}

	public static void main(String[] args) {
		MinorGC.testAllocation();
	}

}
