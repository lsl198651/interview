package com.shilong.thread.threadSafe2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class MyThread extends Thread{
	static int ticket=0;
	 static Lock lock=new ReentrantLock();

	@Override
	public void run() {
		while(true){
//			synchronized (MyThread.class){
			lock.lock();
			try {
				if(ticket==50){

					break;
				}else {

						Thread.sleep(10);

					ticket++;
					System.out.println(Thread.currentThread().getName()+"正在卖第"+ticket+"张票");
				}

//			}
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}finally{
				lock.unlock();
			}
		}
	}
}
