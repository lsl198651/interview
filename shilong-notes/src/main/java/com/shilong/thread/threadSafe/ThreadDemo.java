package com.shilong.thread.threadSafe;public class ThreadDemo {
	public static void main(String[] args){
		MyThread t1=new MyThread();
		MyThread t2=new MyThread();
		MyThread t3=new MyThread();
		t1.setName("thread1");
		t2.setName("thread2");
		t3.setName("thread3");
		t1.start();
		t2.start();
		t3.start();


	}
}
