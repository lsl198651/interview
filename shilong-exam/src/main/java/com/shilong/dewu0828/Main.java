package com.shilong.dewu0828;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();  // 关卡数
		int[] redScores = new int[n];  // 小红的分数
		int[] purpleScores = new int[n];  // 小紫的分数

		for (int i = 0; i < n; i++) {
			redScores[i] = scanner.nextInt();
		}
		for (int i = 0; i < n; i++) {
			purpleScores[i] = scanner.nextInt();
		}

		// 用于存储每种状态的最早出现位置
		Map<Long, Integer> stateMap = new HashMap<>();
		stateMap.put(0L, -1); // 初始状态，未进行任何操作时

		long sumDiff = 0;  // 累计的增量差值
		int maxLen = 0;  // 最大的关卡数

		for (int i = 1; i < n; i++) {
			// 计算当前关卡的增量
			int redDelta = redScores[i] - redScores[i - 1];
			int purpleDelta = purpleScores[i] - purpleScores[i - 1];

			// 更新累计增量差值
			sumDiff += redDelta - purpleDelta;

			// 检查此状态是否已存在
			if (stateMap.containsKey(sumDiff)) {
				// 计算从之前记录的状态到当前的子数组长度
				int previousIndex = stateMap.get(sumDiff);
				maxLen = Math.max(maxLen, i - previousIndex);
			} else {
				// 记录此状态首次出现的位置
				stateMap.put(sumDiff, i);
			}
		}

		// 输出最长的关卡数
		System.out.println(maxLen + 1);  // 注意要加上第一关
	}
}


