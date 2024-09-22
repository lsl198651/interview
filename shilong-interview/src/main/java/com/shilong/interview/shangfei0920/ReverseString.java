package com.shilong.interview.shangfei0920;


public class ReverseString {

	// 方法用于反转字符串
	public static void reverseString(char[] str) {
		int start = 0;              // 左指针
		int end = str.length - 1;   // 右指针
		char temp;                  // 临时变量用于交换字符

		// 使用双指针法，交换左右两边的字符
		while (start < end) {
			// 交换字符
			temp = str[start];
			str[start] = str[end];
			str[end] = temp;

			// 移动指针
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		// 示例字符串
		char[] str = "hello".toCharArray();

		// 调用反转字符串的方法
		reverseString(str);

		// 输出反转后的字符串
		System.out.println("Reversed string: " + new String(str));
	}
}
