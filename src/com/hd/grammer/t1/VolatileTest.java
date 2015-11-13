package com.hd.grammer.t1;

/**
 * @author Chunyun
 * 这个程序证明volatile并不能带来同步，volatile能保证多线程操作时变量的可见性
 * 而普通变量不能保证这一点；但是，volatile和普通变量一样，Java内存模型是通过在变量
 * 修改后将新值同步回主内存，在变量读取前从主内存刷新变量值这种依赖主内存作为传媒介的方式来
 * 实现可见性；但区别是：volatile的特殊性规则保证了新值能立即同步到主内存，以及每次使用前
 * 立即从主内存刷新，因此，volatile能保证多线程操作时变量的可见性，而普通变量则不能保证这一
 * 点
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
		while(Thread.activeCount() > 1){//如不加这个循环判断，则输出的race会更小
			Thread.yield();
		}
		
		System.out.println(race);
		
	}
}
