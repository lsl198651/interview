package thread.waitAndNotify;public class Foodie extends Thread{
	@Override
	public void run() {
		while(true){
			synchronized (Desk.lock){
				if(Desk.count==0){
					break;
				}else {
					if(Desk.foodflag==0){
						try {
							Desk.lock.wait();
						} catch (InterruptedException e) {
							throw new RuntimeException(e);
						}

					}else {
						Desk.count--;
						System.out.println("吃货正在吃第"+Desk.count+"份食物");
						Desk.lock.notifyAll();

						Desk.foodflag=0;

					}
				}
			}
		}
	}
}
