package com.hd.grammer.t1;

/**
 * @author Chunyun
 * �������֤��volatile�����ܴ���ͬ����volatile�ܱ�֤���̲߳���ʱ�����Ŀɼ���
 * ����ͨ�������ܱ�֤��һ�㣻���ǣ�volatile����ͨ����һ����Java�ڴ�ģ����ͨ���ڱ���
 * �޸ĺ���ֵͬ�������ڴ棬�ڱ�����ȡǰ�����ڴ�ˢ�±���ֵ�����������ڴ���Ϊ��ý��ķ�ʽ��
 * ʵ�ֿɼ��ԣ��������ǣ�volatile�������Թ���֤����ֵ������ͬ�������ڴ棬�Լ�ÿ��ʹ��ǰ
 * ���������ڴ�ˢ�£���ˣ�volatile�ܱ�֤���̲߳���ʱ�����Ŀɼ��ԣ�����ͨ�������ܱ�֤��һ
 * ��
 */
public class VolatileTest {
	
	public static volatile int race = 0;
	public static void increase(){
		race++;
	}
	
	private static final int THREADS_COUNT = 20;
	
	public static void main(String[] args) {
		Thread[] threads = new Thread[THREADS_COUNT];
		for(int i = 0; i < THREADS_COUNT; i++){
			threads[i] = new Thread(new Runnable() {
				
				@Override
				public void run() {
					for(int i = 0; i < 10000; i++){
						increase();
					}
				}
			});
			threads[i].start();
		}
		while(Thread.activeCount() > 1){//�粻�����ѭ���жϣ��������race���С
			Thread.yield();
		}
		
		System.out.println(race);
		
	}
}
