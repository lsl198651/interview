package com.shilong.xiaohongshu09021;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// 读取人数 n
		int n = scanner.nextInt();
		int[] power = new int[n];
		int totalPower = 0;

		// 读取每个人的战斗力
		for (int i = 0; i < n; i++) {
			power[i] = scanner.nextInt();
			totalPower += power[i];
		}

		// 背包容量的最大值
		int target = totalPower / 2;

		// 动态规划数组，表示容量 j 时能够达到的最大战斗力值
		int[] dp = new int[target + 1];

		// 进行动态规划
		for (int i = 0; i < n; i++) {
			for (int j = target; j >= power[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j - power[i]] + power[i]);
			}
		}

		// 总战斗力 - 2 * 最接近一半的战斗力
		int result = totalPower - 2 * dp[target];

		// 输出最小的绝对值
		System.out.println(result);

		scanner.close();
	}
}

