package com.hd.grammer.t1;

/**
 * @author Chunyun
 * -Xss2M
 * 创建线程导致内存溢出，系统剩余内存（os限制）减去Xmx(最大堆内存)，减去MaxPermSize(最大方法区内存),
 * 程序计数器消耗内存很少，可以忽略，如果虚拟机进程本身的消耗内存不计，剩下的内存就由虚拟机栈和本地方法栈瓜分；
 * 每个线程分配到的栈越大，可以建立的线程数越少，建立线程时就容易把剩下的内存用完；所以多线程下内存不够时产生
 * OOM，单线程时产生SOF
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
