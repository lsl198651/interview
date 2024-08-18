package thread.waitAndNotify;

public class Cook extends Thread{
	@Override
	public void run() {
	while(true){
		synchronized (Desk.lock){
			if(Desk.count==0){
				break;
			}else {
				if(Desk.foodflag==1){
					try {
						Desk.lock.wait();
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
				}else {
					System.out.println("厨师正在做第"+Desk.count+"份食物");
					Desk.foodflag=1;
					Desk.lock.notifyAll();
				}
			}
		}
	}}
}
