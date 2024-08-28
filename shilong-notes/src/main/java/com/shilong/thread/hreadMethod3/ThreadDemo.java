package thread.hreadMethod3;




public class ThreadDemo {
	public static void main(String[] args){
		thread.hreadMethod3.MyThread1 t1 = new thread.hreadMethod3.MyThread1();
		thread.hreadMethod3.MyThread2 t2 = new thread.hreadMethod3.MyThread2();

		t1.setName("tiangou");
t2.setName("nvshen");
//shou hu xian cheng
t1.setDaemon(true);

t1.start();
t2.start();
	}
}
