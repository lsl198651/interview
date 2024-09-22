package com.shilong.meituan0921;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt(); // 读取测试数据组数

		while (T-- > 0) {
			long n = scanner.nextLong(); // 读取每个测试数据的n

			// 使用另一种方法：将数组尽量分为3的倍数的段
			long result = (n + 2) / 3; // 等价于求ceil(n / 3)
			System.out.println(result);
		}

		scanner.close();
	}
}
