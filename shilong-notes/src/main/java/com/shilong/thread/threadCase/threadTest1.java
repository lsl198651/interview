package com.shilong.thread.threadCase;public class threadTest1 {
	public static void main(String[] args){
//		第一种多线程启动方法
//		没有返回值
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
