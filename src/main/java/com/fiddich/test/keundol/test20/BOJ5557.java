package com.fiddich.test.keundol.test20;

import java.util.*;

public class BOJ5557 {

    static int n;
    static int[] a;
    static long[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n+1];
        for(int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }

        dp = new long[n][21];
        dp[1][a[1]] = 1;
        for(int i = 2; i <= n-1; i++) {
            for(int j = 0; j <= 20; j++) {
                if (j - a[i] >= 0) {
                    dp[i][j] += dp[i - 1][j - a[i]];
                }
                if (j + a[i] <= 20) {
                    dp[i][j] += dp[i - 1][j + a[i]];
                }
            }
        }

        System.out.println(dp[n-1][a[n]]);
    }
}
