package com.fiddich.dp;

import java.util.*;

public class BOJ1149 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][3];
        for(int i =0 ; i < n; i++) {
            for(int j = 0; j < 3; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        int[][] dp = new int[n+1][3];
        dp[1][0] = a[0][0];
        dp[1][1] = a[0][1];
        dp[1][2] = a[0][2];
        for(int i = 2; i <= n; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + a[i-1][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + a[i-1][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + a[i-1][2];
        }

        int ret = Math.min(dp[n][0], dp[n][1]);
        ret = Math.min(ret, dp[n][2]);

        System.out.println(ret);
    }
}
