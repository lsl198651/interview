package com.shilong.xiaohongshu09021;

import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// 读取 n 和 m
		int n = scanner.nextInt(); // 座位数量 n
		int m = scanner.nextInt(); // 学生数量 m
		int[] a = new int[m]; // 学生喜欢的座位

		// 读取每个学生喜欢的座位编号
		for (int i = 0; i < m; i++) {
			a[i] = scanner.nextInt();
		}

		// 最小距离和及其对应的最优位置
		long minDistanceSum = Long.MAX_VALUE;
		int bestPosition = 1;

		// 遍历每一个可能的座位 j
		for (int j = 1; j <= n; j++) {
			long currentDistanceSum = 0;

			// 计算所有学生到座位 j 的距离和
			for (int i = 0; i < m; i++) {
				int distance1 = Math.abs(j - a[i]); // 直接距离
				int distance2 = n - Math.abs(j - a[i]); // 环形距离
				currentDistanceSum += Math.min(distance1, distance2);
			}

			// 更新最优位置
			if (currentDistanceSum < minDistanceSum) {
				minDistanceSum = currentDistanceSum;
				bestPosition = j;
			}
		}

		// 输出最优位置
		System.out.println(bestPosition);

		scanner.close();
	}
}

