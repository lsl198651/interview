package thread.hreadMethod3;


import jdk.nashorn.internal.ir.CallNode;

public class ThreadDemo {
	public static void main(String[] args){
		MyThread1 t1 = new MyThread1();
		MyThread2 t2 = new MyThread2();

		t1.setName("tiangou");
t2.setName("nvshen");
//shou hu xian cheng
t1.setDaemon(true);

t1.start();
t2.start();
	}
}
