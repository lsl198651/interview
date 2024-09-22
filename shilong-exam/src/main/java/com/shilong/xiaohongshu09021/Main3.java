package com.shilong.xiaohongshu09021;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// 读取测试用例数量
		int T = scanner.nextInt();

		for (int t = 0; t < T; t++) {
			// 读取每个测试用例中的 n 和 m
			int n = scanner.nextInt(); // 收藏夹数量
			int m = scanner.nextInt(); // 总的用户数量

			// 用于存储每个收藏夹的用户的MCN机构编号集合
			Set<String>[] collections = new HashSet[n];

			// 读取每个收藏夹的内容
			for (int i = 0; i < n; i++) {
				int userCount = scanner.nextInt(); // 当前收藏夹中的用户数量
				collections[i] = new HashSet<>();

				// 读取每个用户的MCN机构编号
				for (int j = 0; j < userCount; j++) {
					String mcnId = scanner.next();
					collections[i].add(mcnId);
				}
			}

			// 判断是否存在两个收藏夹没有交集
			boolean found = false;
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					// 检查收藏夹 i 和 j 是否没有交集
					Set<String> set1 = collections[i];
					Set<String> set2 = collections[j];

					// 判断两个集合是否有交集
					boolean hasIntersection = false;
					for (String mcnId : set1) {
						if (set2.contains(mcnId)) {
							hasIntersection = true;
							break;
						}
					}

					if (!hasIntersection) {
						System.out.println("YES");
						System.out.println((i + 1) + " " + (j + 1));
						found = true;
						break;
					}
				}
				if (found) break;
			}

			if (!found) {
				System.out.println("NO");
			}
		}

		scanner.close();
	}
}

