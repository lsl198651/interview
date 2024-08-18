package thread.threadCase;public class MyThread extends  Thread{
	@Override
	public void run() {
		System.out.println(getName()+":MyThread2.run()");
	}
}
