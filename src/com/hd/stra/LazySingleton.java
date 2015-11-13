package com.hd.stra;


/**
 * @author Chunyun
 * ʵ�ֵ����࣬����Ҫ�����ӳټ��أ���Ҫ�����߳�ͬ��
 */
public class LazySingleton {
	
	private LazySingleton(){
		System.out.println("LazySingleton is creating...");//���ڲ��Ե����Ƿ��Ѿ�������
	}
	
	/**
	 * ʹ���ڲ�����е�����LazySingleton������ʱ���ڲ��಻�ᱻ���أ���ʵ���Ľ���
	 * ���������ʱ���еģ��������̰߳�ȫ��
	 * �����л��ĵ��������ɿ��Ա����������ʵ����ʹ��ʱ��Ҫע��
	 */
	private static class SingletHolder{
		private static LazySingleton instance = new LazySingleton();
	}
	
	public static LazySingleton getInstance(){
		return SingletHolder.instance;
	}
	
	//�÷���ֻ���ڲ����Ƿ�ʵ�����ӳټ���
	public static void test(){
		System.out.println("�����˵�����ķ�����");
	}
	
	public void using(){
		System.out.println("����ʹ�õ����࣡");
	}
	
	public static void main(String[] args) {
		LazySingleton.test();
		LazySingleton ls = LazySingleton.getInstance();
		ls.using();
	}
}
