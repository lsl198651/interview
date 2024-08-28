package com.shilong.dewu0828;import java.util.Scanner;

import java.util.Scanner;

import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// 读取输入的两个字符串
		String start = scanner.next();
		String end = scanner.next();

		int totalMoves = 0; // 总的最少拨动次数

		// 遍历每一位
		for (int i = 0; i < 4; i++) {
			int startDigit = start.charAt(i) - '0'; // 当前起始状态的数字
			int endDigit = end.charAt(i) - '0';     // 目标状态的数字

			// 计算向下拨动次数
			int moves = (startDigit - endDigit + 10) % 10;

			// 累加拨动次数
			totalMoves += moves;
		}

		// 输出最少拨动次数
		System.out.println(totalMoves);
	}
}
