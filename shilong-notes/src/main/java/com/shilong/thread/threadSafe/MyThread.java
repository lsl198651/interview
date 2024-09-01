package com.shilong.thread.threadSafe;public class MyThread extends Thread{
	static final Object obj=new Object();
	static int ticket=0;

	@Override
	public void run() {

		while(ticket<50){
			synchronized (obj){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}



			ticket++;
			System.out.println(getName()+"is saleing no."+ticket+" ticket");
		}
		}
	}
}
