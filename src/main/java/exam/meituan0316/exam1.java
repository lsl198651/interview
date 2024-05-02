package exam.meituan0316;
import java.util.Scanner;

public class exam1  {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// 读取菜品总数
		int n = scanner.nextInt();
		// TODO 注意输入范围
		long total = 0;

		// 计算菜品总价格
		for (int i = 0; i < n; i++) {
			total += scanner.nextInt();
		}

		// 读取满减价格和红包价格
		int x = scanner.nextInt();
		int y = scanner.nextInt();

		// 应用满减
		if (total >= x) {
			total -= x;
		}

		// 应用红包
		total -= y;

		// 输出最终应付的钱数，不允许出现负数
		System.out.println(Math.max(0, total));
	}
}
