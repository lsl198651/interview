package com.shilong.ThreadLocal;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThreadPool {
	public static void main(String[] args) throws InterruptedException {
//		ExecutorService executorService = Executors.newCachedThreadPool();
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		executorService.submit(new MyRunnable());
		Thread.sleep(1000);
		executorService.submit(new MyRunnable());
		executorService.submit(new MyRunnable());
		executorService.submit(new MyRunnable());
		executorService.submit(new MyRunnable());
		executorService.submit(new MyRunnable());
		executorService.submit(new MyRunnable());

		executorService.shutdown();

	}
}
