package thread.waitAndNotify;

public class Cook extends Thread{
	@Override
	public void run() {
	while(true){
		synchronized (thread.waitAndNotify.Desk.lock){
			if(thread.waitAndNotify.Desk.count==0){
				break;
			}else {
				if(thread.waitAndNotify.Desk.foodflag==1){
					try {
						thread.waitAndNotify.Desk.lock.wait();
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
				}else {
					System.out.println("厨师正在做第"+ thread.waitAndNotify.Desk.count+"份食物");
					thread.waitAndNotify.Desk.foodflag=1;
					thread.waitAndNotify.Desk.lock.notifyAll();
				}
			}
		}
	}}
}
