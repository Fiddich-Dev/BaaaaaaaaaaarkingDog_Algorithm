package com.fiddich.test.keundol.test8;

import java.util.*;

public class BOJ2294 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }


        Arrays.sort(a);

        int[][] dp = new int[n+1][k+1];
        for(int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], 987654321);
            dp[i][0] = 0;
        }


        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= k; j++) {
                // 이번꺼 안쓸때
                dp[i][j] = dp[i-1][j];

                // 이번꺼 쓸때
                if(j - a[i-1] >= 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - a[i - 1]] + 1);
                }
            }
        }

//        for(int i = 0; i <= k; i++) {
//            System.out.print(dp[n][i] + " ");
//        }
        if(dp[n][k] == 987654321) {
            System.out.println(-1);
            return;
        }
        System.out.println(dp[n][k]);
    }
}



