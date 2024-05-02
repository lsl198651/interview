package thread.threadSafe;public class MyThread extends Thread{
	static int ticket=0;
	static final Object obj=new Object();
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
		}}
	}
}
