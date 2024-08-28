package com.shilong.dewu0828;

import java.util.Scanner;

public class Main1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		String brackets = scanner.next();
		scanner.close();

		int openCount = 0; // 用于记录未匹配的左括号数量
		int validLength = 0; // 记录最长合法前缀的长度

		for (int index = 0; index < n; index++) {
			char currentChar = brackets.charAt(index);
			if (currentChar == '(') {
				openCount++; // 当前字符为左括号，增加计数
			} else {
				openCount--; // 当前字符为右括号，减少计数
			}

			if (openCount == 0) {
				validLength = index + 1; // 平衡状态下更新合法前缀长度
			} else if (openCount < 0) {
				break; // 出现多余的右括号，直接终止
			}
		}

		System.out.println(validLength);
	}
}
