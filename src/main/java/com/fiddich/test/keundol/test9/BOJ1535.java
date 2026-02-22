package com.fiddich.test.keundol.test9;

import java.util.*;

public class BOJ1535 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] cost = new int[n];
        int[] gift = new int[n];
        int[][] dp = new int[24][104];
        for(int i = 0; i < n; i++) {
            cost[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++) {
            gift[i] = sc.nextInt();
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= 99; j++) {
                dp[i][j] = dp[i-1][j];
                if(j - cost[i-1] >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-cost[i-1]] + gift[i-1]);
                }
            }
        }

        System.out.println(dp[n][99]);
    }
}

// dp[n][m] = n까지 고려했을때 m의 체력으로 얻을 수 있는 최대 기쁨
// dp[i][j] = dp[i-1][j] dp[i-1][j-cost[i]] + gift[i]
