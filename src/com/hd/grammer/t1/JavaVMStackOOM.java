package com.hd.grammer.t1;

/**
 * @author Chunyun
 * -Xss2M
 * �����̵߳����ڴ������ϵͳʣ���ڴ棨os���ƣ���ȥXmx(�����ڴ�)����ȥMaxPermSize(��󷽷����ڴ�),
 * ��������������ڴ���٣����Ժ��ԣ������������̱���������ڴ治�ƣ�ʣ�µ��ڴ���������ջ�ͱ��ط���ջ�Ϸ֣�
 * ÿ���̷߳��䵽��ջԽ�󣬿��Խ������߳���Խ�٣������߳�ʱ�����װ�ʣ�µ��ڴ����ꣻ���Զ��߳����ڴ治��ʱ����
 * OOM�����߳�ʱ����SOF
 */
public class JavaVMStackOOM {
	
	private void dontStop(){
		while(true){
			
		}
	}
	
	public void stackLeakByThread(){
		while(true){
			Thread thread = new Thread(new Runnable() {
				
				@Override
				public void run() {
					dontStop();
				}
			});
			thread.start();
		}
	}
	
	public static void main(String[] args) {
		JavaVMStackOOM oom = new JavaVMStackOOM();
		oom.stackLeakByThread();//Exception in thread "main" java.lang.OutOfMemoryError: 
								//unable to create new native thread
								//at java.lang.Thread.start0(Native Method)
								//at java.lang.Thread.start(Thread.java:713)
								//at com.hd.grammer.t1.JavaVMStackOOM.stackLeakByThread(JavaVMStackOOM.java:27)
								//at com.hd.grammer.t1.JavaVMStackOOM.main(JavaVMStackOOM.java:33)

	}
}
