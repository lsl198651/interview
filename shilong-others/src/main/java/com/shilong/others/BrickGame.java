package com.shilong.others;

import java.util.Scanner;

public class BrickGame {
  static int maxn = 310;
  static int[][] dp = new int[maxn][maxn];
  static int[] color = new int[maxn];
  static int[] sum = new int[maxn];
  static int n, a, b, c;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    n = scanner.nextInt();
    a = scanner.nextInt();
    b = scanner.nextInt();
    c = scanner.nextInt();

    for (int i = 1; i <= n; i++) {
      color[i] = scanner.nextInt();
      sum[i] = sum[i - 1];
      if (color[i] == color[i - 1]) {
        sum[i]++;
      }
    }

    for (int len = 2; len <= n; len++) {
      for (int l = 1; l + len - 1 <= n; l++) {
        int r = l + len - 1;
        dp[l][r] = Math.max(dp[l + 1][r] + a, dp[l][r - 1] + a);
        for (int k = l + 1; k <= r; k++) {
          if (color[k] != color[l]) {
            continue;
          }
          int w = a * (sum[k - 1] - sum[l]);
          if (k - 1 - l >= 1) {
            w += b;
          }
          if (k - 1 - l >= 2) {
            w += c - b;
          }
          dp[l][r] = Math.max(dp[l][r], dp[l + 1][k - 1] + w + dp[k + 1][r]);
        }
      }
    }
    System.out.println(dp[1][n]);
  }
}
