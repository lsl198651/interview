package com.shilong.thread.waitAndNotify2;

import java.util.concurrent.ArrayBlockingQueue;

public class Cook extends Thread{
	ArrayBlockingQueue<String> queue;

	public Cook(ArrayBlockingQueue<String> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		while(true){
			try {
				queue.put("食材");
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			System.out.println("厨师做好了食材");
		}
	}
}
