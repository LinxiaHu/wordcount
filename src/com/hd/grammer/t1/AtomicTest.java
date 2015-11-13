package com.hd.grammer.t1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

public class AtomicTest {
	private static final int MAX_THREADS = 3;
	private static final int TASK_COUNT = 3;
	private static final int TARGET_COUNT = 1_000_000;

	private AtomicInteger acount = new AtomicInteger(0);// 用于测试的原子共享整形
	private int count = 0;// 用于测试的普通共享整形

	protected synchronized int inc() {
		return count++;
	}

	protected synchronized int getCount() {
		return count;
	}

	public class SyncThead implements Runnable {
		protected String name;
		protected long starttime;
		AtomicTest out;// 外部类的引用

		public SyncThead(AtomicTest o, long starttime) {
			this.out = o;
			this.starttime = starttime;
		}

		@Override
		public void run() {
			int v = out.inc();
			while (v < TARGET_COUNT) {
				v = out.inc();
			}
			long endtime = System.currentTimeMillis();
			System.out.println("SyncThead spend:" + (endtime - this.starttime)
					+ "ms" + " v=" + v);

		}
	}

	public class AtomicThead implements Runnable {
		protected String name;
		protected long starttime;
		AtomicTest out;// 外部类的引用

		public AtomicThead(long stattime) {
			this.starttime = stattime;
		}

		@Override
		public void run() {
			int v = acount.incrementAndGet();
			while (v < TARGET_COUNT) {
				v = acount.incrementAndGet();
			}
			long endtime = System.currentTimeMillis();
			System.out.println("AtomicTest spend:" + (endtime - this.starttime)
					+ "ms" + " v=" + v);
		}
	}

	@Test
	public void atomicTest() throws InterruptedException {
		ExecutorService exe = Executors.newFixedThreadPool(MAX_THREADS);
		long starttime = System.currentTimeMillis();
		AtomicThead atomic = new AtomicThead(starttime);
		for (int i = 0; i < TASK_COUNT; i++) {
			exe.submit(atomic);
		}
		Thread.sleep(1000);
	}

	@Test
	public void synTest() throws InterruptedException {
		ExecutorService exe = Executors.newFixedThreadPool(MAX_THREADS);
		long starttime = System.currentTimeMillis();
		SyncThead syn = new SyncThead(this, starttime);
		for (int i = 0; i < TASK_COUNT; i++) {
			exe.submit(syn);
		}
		Thread.sleep(1000);
	}

}
