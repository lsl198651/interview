package com.shilong.jingdong0831;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		scanner.close();

		char[] chars = s.toCharArray();
		int n = chars.length;

		// 从最后一位开始尝试进位
		for (int i = n - 1; i >= 0; i--) {
			if (chars[i] < 'z') {
				chars[i]++;
				for (int j = i + 1; j < n; j++) {
					chars[j] = 'a';
				}
				System.out.println(new String(chars));
				return;
			}
		}

		// 如果遍历完所有字符还无法进位，则说明没有下一个字典序的字符串
		System.out.println("-1");
	}
}
