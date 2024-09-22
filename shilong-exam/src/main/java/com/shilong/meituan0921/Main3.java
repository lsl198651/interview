package com.shilong.meituan0921;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main3 {
	private static int[][] frequency; // 用于存储每个字符在每个位置的频次
	private static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 字符串长度
			int q = Integer.parseInt(st.nextToken()); // 操作次数

			char[] s = br.readLine().toCharArray();
			frequency = new int[n][26]; // 记录每个位置上各个字母的频次

			// 初始化频率数组
			for (int i = 0; i < n; i++) {
				frequency[i][s[i] - 'a']++;
			}

			for (int i = 0; i < q; i++) {
				st = new StringTokenizer(br.readLine());
				int op = Integer.parseInt(st.nextToken());

				if (op == 1) {
					// 修改操作
					int idx = Integer.parseInt(st.nextToken()) - 1;
					char p = st.nextToken().charAt(0);
					update(s, idx, p);
				} else if (op == 2) {
					// 查询操作
					int l = Integer.parseInt(st.nextToken()) - 1;
					int r = Integer.parseInt(st.nextToken()) - 1;
					int result = query(l, r);
					System.out.println(result);
				}
			}
		}
	}

	// 更新操作
	private static void update(char[] s, int idx, char newChar) {
		if (s[idx] == newChar) {
			return; // 如果相同则不需要更新
		}
		// 减去旧字符的频次
		frequency[idx][s[idx] - 'a']--;
		// 加上新字符的频次
		frequency[idx][newChar - 'a']++;
		// 更新字符串
		s[idx] = newChar;
	}

	// 查询操作
	private static int query(int l, int r) {
		int[] totalFrequency = new int[26];

		// 计算区间 [l, r] 中每个字符的总频次
		for (int i = l; i <= r; i++) {
			for (int j = 0; j < 26; j++) {
				totalFrequency[j] += frequency[i][j];
			}
		}

		// 找到最高频次的字符
		int maxFreq = 0;
		int totalChars = r - l + 1;
		for (int j = 0; j < 26; j++) {
			maxFreq = Math.max(maxFreq, totalFrequency[j]);
		}

		// 返回需要改变的最小单位时间
		return totalChars - maxFreq;
	}
}
