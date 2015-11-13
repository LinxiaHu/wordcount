package com.hd.grammer.t1;

public class JoinTest {

	static class ThreadTesterA implements Runnable {

		private int counter;

		@Override
		public void run() {
			while (counter <= 10) {
				System.out.println("Counter = " + counter + " ");
				counter++;
			}
			System.out.println();
		}
	}

	static class ThreadTesterB implements Runnable {

		private int i;

		@Override
		public void run() {
			while (i <= 10) {
				System.out.println("i = " + i + " ");
				i++;
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new ThreadTesterA());
		Thread t2 = new Thread(new ThreadTesterB());
		t1.start();
//		try {
//			t1.join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		} // wait t1 to be finished
		t2.start();
		try {
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} // in this program, this may be removed
	}

}
