package thread.threadCase;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class threadTest3 {public static void main(String[] args) throws ExecutionException, InterruptedException {
	MyCallabel mc = new MyCallabel();
	FutureTask<Integer> integerFutureTask = new FutureTask<>(mc);

	Thread t1 = new Thread(integerFutureTask);
	t1.start();

	Integer i = integerFutureTask.get();
	System.out.println(i);


}
}
