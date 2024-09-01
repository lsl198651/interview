package com.shilong.xiaohngshu0901;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int[] categories = new int[n];
		int[] movable = new int[n];

		for (int i = 0; i < n; i++) {
			categories[i] = scanner.nextInt();
		}

		for (int i = 0; i < n; i++) {
			movable[i] = scanner.nextInt();
		}

		int[][] dp = new int[n][2]; // dp[i][j]表示前i个物品中，第i个物品是否移动到第j类别时的最小不美观程度

		// 初始化dp数组
		dp[0][0] = categories[0] == 1 ? 0 : movable[0];
		dp[0][1] = categories[0] == 2 ? 0 : movable[0];

		for (int i = 1; i < n; i++) {
			dp[i][0] = Math.min(dp[i - 1][0] + (categories[i] == 1 ? 0 : movable[i]), dp[i - 1][1] + (categories[i] == 1 ? 1 : 0));
			dp[i][1] = Math.min(dp[i - 1][0] + (categories[i] == 2 ? 1 : 0), dp[i - 1][1] + (categories[i] == 2 ? 0 : movable[i]));

			// 考虑相邻物品类别不同的情况
			if (categories[i] != categories[i - 1]) {
				dp[i][0]++;
				dp[i][1]++;
			}
		}

		int minBeauty = Math.min(dp[n - 1][0], dp[n - 1][1]);
		System.out.println(minBeauty);

		scanner.close();
	}
}