package com.shilong.thread.waitAndNotify2;

import java.util.concurrent.ArrayBlockingQueue;

public class ThreadDemo {
	public static void main(String[] args){
		ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(1);
		Cook cook = new Cook(arrayBlockingQueue);
		Foodie foodie = new Foodie(arrayBlockingQueue);
		cook.start();
		foodie.start();

	}
}
