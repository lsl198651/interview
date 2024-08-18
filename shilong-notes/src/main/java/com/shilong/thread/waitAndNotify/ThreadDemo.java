package thread.waitAndNotify;


import thread.threadSafe2.MyThread;

public class ThreadDemo {
	public static void main(String[] args){
		Cook cook = new Cook();
		Foodie foodide = new Foodie();
		cook.setName("厨师");
		foodide.setName("吃货");

		cook.start();
		foodide.start();

	}
}
