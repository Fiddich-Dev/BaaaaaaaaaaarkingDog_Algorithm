package com.fiddich.test.keundol.test1;

import java.util.*;

public class BOJ12865 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] dp = new int[n+1][k+1];
        int[] w = new int[n];
        int[] v = new int[n];
        for(int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }

        for(int i = 1; i <= n; i++) { // idx
            for(int j = 1; j <= k; j++) { // w
                // 현재 물건을 안담을떄
                dp[i][j] = dp[i-1][j];
                // 담을 수 있을때
                if(j >= w[i-1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - w[i-1]] + v[i-1]);
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}
// dp[idx][w] = idx 까지 고려했을떄 w 만큼 담을 수 있는 최대 가치
// dp[idx][w] = 현재 물건을 담을 수 있을떄 v[idx] + dp[idx][w - w[idx]], dp[idx-1][w]
// w[idx] v[idx]
