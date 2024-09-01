package com.shilong.thread.hreadMethod.hreadMethod2;public class ThreadDemo {
	public static void main(String[] args){
		MyRunnable myRunnable=new MyRunnable();
		Thread t1=new Thread(myRunnable);
		Thread t2=new Thread(myRunnable);
		t1.setName("thread1");
		t2.setName("thread2");

t1.setPriority(1);
t2.setPriority(10);

		t1.start();
		t2.start();

	}
}
