
package com.hd.grammer.t1;

/**
 * @author Chunyun
 * ���ü����㷨��ȱ��--�޷�����ѭ������
 */
public class ReferenceCountinGC {
	
	public Object instance = null;
	private static final int _1MB = 1024 * 1024;
	/**
	 * �����Ա����Ψһ��������ռ���ڴ棬�Ա���GC��־���ܿ�����Ƿ񱻻��չ�
	 */
	private byte[] bigSize = new byte[2 * _1MB];
	
	public static void testGC(){
		ReferenceCountinGC objA = new ReferenceCountinGC();
		ReferenceCountinGC objB = new ReferenceCountinGC();
		//ѭ������
		objA.instance = objB;
		objB.instance = objA;
		
		objA = null;
		objB = null;
		
		System.gc();//�����Ƿ��ܰѻ��գ��������ʾ�õĲ������ü����㷨
	}
	
	public static void main(String[] args) {
		testGC();
	}
}
