package com.hd.grammer.t1;

/**
 * @author Chunyun VM²ÎÊý£º -verbose:gc -Xms20m -Xmx20m -Xmn10m -XX:+PrintGCDetails
 *         -XX:SurvivoRatio=8 -XX:MaxTenuringThreshold=15
 */
public class GC {
	private static final int _1MB = 1024 * 1024;

	public static void testTenuringThreashole() {
		byte[] allocation1, allocation2, allocation3, allocation4;
		allocation1 = new byte[_1MB / 4];
		allocation2 = new byte[_1MB / 4];
		allocation3 = new byte[_1MB * 4];
		allocation4 = new byte[_1MB * 4];
		allocation4 = null;
		allocation4 = new byte[_1MB * 4];
	}
	
	public static void testTenuringThreashole2(){
		byte[] allocation1, allocation2, allocation3, allocation4;
		allocation1 = new byte[_1MB / 9];
		allocation2 = new byte[_1MB * 4];
		allocation3 = new byte[_1MB * 4];
		allocation3 = null;
		allocation3 = new byte[_1MB * 4];
	}

	public static void main(String[] args) {
//		GC.testTenuringThreashole();
		GC.testTenuringThreashole2();
	}
}
