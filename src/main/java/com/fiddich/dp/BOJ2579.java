package com.fiddich.dp;

import java.util.*;

public class BOJ2579 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int[][] dp = new int[n+1][3];

        dp[1][0] = 0;
        dp[1][1] = a[0];
        dp[1][2] = -987654321;
        for(int i = 2; i <= n; i++) {
            dp[i][0] = Math.max(dp[i-1][1], dp[i-1][2]);

            dp[i][1] = Math.max(dp[i-2][1], dp[i-2][2]) + a[i-1];

            dp[i][2] = dp[i-1][1] + a[i-1];
        }

        int ret = Math.max(dp[n][1], dp[n][2]);

        System.out.println(ret);
    }
}
