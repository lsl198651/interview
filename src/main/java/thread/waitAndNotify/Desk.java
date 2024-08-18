package thread.waitAndNotify;

import java.util.concurrent.locks.ReentrantLock;

public class Desk {
	public static int count=0;
	public static Object lock=new ReentrantLock();
	public static int foodflag=0;
}
