package com.shilong.meituan0921;

import java.util.Scanner;

public class mian2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();

		while (T-- > 0) {
			long n = scanner.nextLong();
			int operations = 0;
			long currentRed = 1;

			while (currentRed < n) {
				currentRed *= 2;
				operations++;
			}

			System.out.println(operations);
		}

		scanner.close();
	}
}

