package com.shilong.thread.hreadMethod3;public class MyThread1  extends Thread{

	@Override
	public void run() {
		for (int  i=0;i<20;i++)
			System.out.println(getName()+":MyThread1.run()"+i);
	}
}
