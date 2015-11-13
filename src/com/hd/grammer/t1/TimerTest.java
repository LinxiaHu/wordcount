package com.hd.grammer.t1;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("pooooooooooooooo");
			}
		},1000,3000);

	}

}
