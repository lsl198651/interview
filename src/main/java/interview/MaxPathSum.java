package interview;import java.util.Scanner;

public class MaxPathSum {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int[][] grid = new int[n][m];

		// 输入矩阵
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				grid[i][j] = scanner.nextInt();
			}
		}

		// 初始化dp数组
		int[][][] dp = new int[n + m - 1][n][m];
		dp[0][0][0] = grid[0][0];

		// 填充dp数组
		for (int k = 1; k < n + m - 1; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (i + j != k) continue; // 确保k等于i+j
					dp[k][i][j] = Integer.MIN_VALUE;
					// 上一状态的最大和 + 当前的格子值
					if (i > 0 && j > 0) dp[k][i][j] = Math.max(dp[k][i][j], dp[k-1][i-1][j] + grid[i][j]);
					if (i > 0 && j < m - 1) dp[k][i][j] = Math.max(dp[k][i][j], dp[k-1][i-1][j+1] + grid[i][j]);
					if (i < n - 1 && j > 0) dp[k][i][j] = Math.max(dp[k][i][j], dp[k-1][i+1][j-1] + grid[i][j]);
					if (i < n - 1 && j < m - 1) dp[k][i][j] = Math.max(dp[k][i][j], dp[k-1][i+1][j+1] + grid[i][j]);
				}
			}
		}

		// 找出最大和
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (i + j == n + m - 2) {
					maxSum = Math.max(maxSum, dp[n + m - 2][i][j]);
				}
			}
		}

		System.out.println(maxSum);
	}
}

