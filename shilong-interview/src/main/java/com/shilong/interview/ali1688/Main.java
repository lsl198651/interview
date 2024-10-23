package com.shilong.interview.ali1688;

import java.util.Stack;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// 创建扫描器读取输入
		Scanner sc = new Scanner(System.in);

		// 读取输入字符串
		String s = sc.next();

		// 输出解码结果
		System.out.println(decodeString(s));

		sc.close();
	}

	// 解码函数，使用栈实现
	public static String decodeString(String s) {
		Stack<Integer> countStack = new Stack<>();
		Stack<StringBuilder> resultStack = new Stack<>();
		StringBuilder current = new StringBuilder();
		int k = 0;

		// 遍历输入字符串
		for (char ch : s.toCharArray()) {
			if (Character.isDigit(ch)) {
				// 数字，构建重复次数
				k = k * 10 + (ch - '0');
			} else if (ch == '[') {
				// 遇到 '[' 时，存储当前的数字和字符串
				countStack.push(k);
				resultStack.push(current);
				current = new StringBuilder();
				k = 0;
			} else if (ch == ']') {
				// 遇到 ']' 时，弹出并构建重复字符串
				int repeatTimes = countStack.pop();
				StringBuilder temp = resultStack.pop();
				for (int i = 0; i < repeatTimes; i++) {
					temp.append(current);
				}
				current = temp;
			} else {
				// 普通字符，直接加入到当前的结果中
				current.append(ch);
			}
		}

		// 返回解码后的结果
		return current.toString();
	}
}

