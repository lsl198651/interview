package com.shilong.shunfeng0829;import java.util.Scanner;

import java.util.Scanner;

public class Main2 {
	private static int count = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int[] houseValues = new int[n];
		for (int i = 0; i < n; i++) {
			houseValues[i] = scanner.nextInt();
		}

		boolean[] used = new boolean[n];
		countArrangementWays(houseValues, used, 0, n);

		System.out.println(count);

		scanner.close();
	}

	private static void countArrangementWays(int[] houseValues, boolean[] used, int index, int n) {
		if (index == n) {
			count++;
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!used[i] && (index == 0 || houseValues[index - 1] % houseValues[i] == 0 || houseValues[i] % houseValues[index - 1] == 0)) {
				used[i] = true;
				countArrangementWays(houseValues, used, index + 1, n);
				used[i] = false;
			}
		}
	}
}

