package thread.waitAndNotify;public class Foodie extends Thread{
	@Override
	public void run() {
		while(true){
			synchronized (thread.waitAndNotify.Desk.lock){
				if(thread.waitAndNotify.Desk.count==0){
					break;
				}else {
					if(thread.waitAndNotify.Desk.foodflag==0){
						try {
							thread.waitAndNotify.Desk.lock.wait();
						} catch (InterruptedException e) {
							throw new RuntimeException(e);
						}

					}else {
						thread.waitAndNotify.Desk.count--;
						System.out.println("吃货正在吃第"+ thread.waitAndNotify.Desk.count+"份食物");
						thread.waitAndNotify.Desk.lock.notifyAll();

						thread.waitAndNotify.Desk.foodflag=0;

					}
				}
			}
		}
	}
}
