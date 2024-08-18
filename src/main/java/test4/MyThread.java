package test4;


import java.util.Random;

public class MyThread extends Thread{
	static  final double MIN=0.01;
	static  double money=100;
	static int count =3;

	@Override
	public void run() {

			synchronized (MyThread.class){
				double price = 0;
				if(count==0){
					System.out.println(getName()+"no red package");
				}else {
					if(count==1){
						count--;
						System.out.println(getName()+"get redpacg"+money);
					}else {

						double bounds=money-(count-1)*MIN;
//						Random random=new Random();
//						price = random.nextDouble(bounds);
						if(price <MIN){
							price =MIN;
						}


					}
				}
				money=money-price;
				count--;
				System.out.println(getName()+"get redpacg"+0.01);
			}

	}
}
