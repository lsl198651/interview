import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] array = new int[n];
		int i = 0;
		int MOD =(int)(10e9+7);

		while (i < n) { // 注意 while 处理多个 case
			array[i] = in.nextInt();
			i++;
		}
		long factorss = factorFacters(array);
		long factorssResult=factorss % MOD;
		System.out.println(factorssResult);
	}

	public static long factorFacters(int[] arr){
		int produce=1;
		for(int i=0;i<arr.length;i++){
			produce*=factral(arr[i]);
		}
		long factorCount=countFactor(produce);
		return  factorCount;
	}

	public static int factral(int n){
		if(n==0||n==1){
			return 1;
		}
		int result=1;
		for(int i=2;i<=n;i++){
			result*=i;
		}
		return result;
	}


	public static long countFactor(int num) {
		long count = 0;
		for (int i = 1; i <= num; i++) {
			if (num % i == 0) {
				count++;
			}
		}
		return count;
	}
}