package com.shilong.others;

import java.util.Arrays;
import java.util.Scanner;

public class StringReplacement{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		scanner.nextLine();
		char[] favs = scanner.nextLine().replaceAll(" ", "").toCharArray();
		char[] str = scanner.nextLine().toCharArray();
		int[] left = new int[n];
		int[] right = new int[n];
		Arrays.fill(left, Integer.MAX_VALUE);
		Arrays.fill(right, Integer.MAX_VALUE);

		int lastFavIndex = -1;
		for (int i = 0; i < n; i++) {
			if (isFav(str[i], favs)) {
				lastFavIndex = i;
			}
			if (lastFavIndex != -1) {
				left[i] = i - lastFavIndex;
			}
		}

		lastFavIndex = -1;
		for (int i = n - 1; i >= 0; i--) {
			if (isFav(str[i], favs)) {
				lastFavIndex = i;
			}
			if (lastFavIndex != -1) {
				right[i] = lastFavIndex - i;
			}
		}

		for (int i = 0; i < n; i++) {
			if (!isFav(str[i], favs)) {
				str[i] = left[i] <= right[i] ? str[i - left[i]] : str[i + right[i]];
			}
		}

		System.out.println(new String(str));
	}

	private static boolean isFav(char c, char[] favs) {
		for (char fav : favs) {
			if (c == fav) {
				return true;
			}
		}
		return false;
	}
}