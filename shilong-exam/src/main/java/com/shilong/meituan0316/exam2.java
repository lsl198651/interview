package com.shilong.meituan0316;
import java.util.Scanner;

public class exam2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.next();
		int small = 0;
		int big = 0;
		int length = s.length();
		for (char p : s.toCharArray()) {
			if (p >= 'a' && p <= 'z') {
				small++;
			} else {
				big++;
			}
		}
		int min_ans = Math.min(small, big);
		if (small == length || big == length) {
			System.out.println(0);
			return;
		} else {
			if (s.charAt(0) >= 'a' && s.charAt(0) <= 'z') {
				System.out.println(min_ans);
			} else {
				min_ans = Math.min(min_ans, length - small - 1);
				System.out.println(min_ans);
			}
		}
	}
}

