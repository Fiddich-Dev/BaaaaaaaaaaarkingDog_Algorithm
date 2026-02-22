package com.fiddich.test.keundol.test12;

import java.util.*;

public class BOJ2293 {

    static int n, k;
    static int[] a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        a = new int[n+1];
        for(int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }

        int[][] dp = new int[n+1][k+1];
        dp[0][0] = 1;
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= k; j++) {
                dp[i][j] = dp[i-1][j];
                if(j - a[i] >= 0) {
                    dp[i][j] += dp[i][j-a[i]];
                }
            }
        }

        System.out.println(dp[n][k]);
    }
    // dp[i][j] = i번째 동전까지 사용해서 j원을 만들수 있는 경우의 수

}
