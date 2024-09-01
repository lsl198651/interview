import java.util.Scanner;

import java.util.Scanner;

import java.util.Scanner;

import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[][] A = new int[2][n];

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < n; j++) {
				A[i][j] = scanner.nextInt();
			}
		}
		scanner.close();

		// dp1和dp2初始化为大于实际可能的值
		long[] dp1 = new long[n];
		long[] dp2 = new long[n];

		// 初始化最后一列的成本
		dp1[n - 1] = A[1][n - 1];
		dp2[n - 1] = A[1][n - 1];

		// 逆向递推，计算每一列的最优成本
		for (int j = n - 2; j >= 0; j--) {
			// 玩家1选择路径最大化策略
			dp1[j] = Math.max(A[0][j] + dp1[j + 1], A[1][j] + dp2[j + 1]);

			// 玩家2选择路径最小化策略
			dp2[j] = Math.min(A[1][j] + dp2[j + 1], A[0][j] + dp1[j + 1]);
		}

		// 从起点(1,1)开始的最优路径成本
		long result =A[0][0]+ dp1[0];

		System.out.println(result);
	}
}
