package thread.threadCase;public class threadTest2 {
	public static void main(String[] args){
//		第二种多线程启动方法
		//		没有返回值

		MyRun myRun=new MyRun();
		Thread t1=new Thread(myRun);
		Thread t2=new Thread(myRun);
		Thread t3=new Thread(myRun);
		t1.setName("thread1");
		t2.setName("thread2");
		t3.setName("thread3");
		t1.start();
		t2.start();
		t3.start();

	}
}
