package com.shilong.thread.hreadMethod;
public class MyThread extends Thread{
	@Override
	public void run() {
		System.out.println("myThread is:"+getName());
	}
}
