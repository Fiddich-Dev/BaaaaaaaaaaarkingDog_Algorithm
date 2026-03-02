package com.fiddich.test.keundol.test22;

import java.util.*;

public class BOJ2240 {

    static int t, w;
    static int[] a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        w = sc.nextInt();
        a = new int[t+1];
        for(int i = 1; i <= t; i++) {
            a[i] = sc.nextInt() - 1;
        }

        int[][][] dp = new int[t+1][w+1][2];

        for(int i = 0; i <= t; i++) {
            for(int j = 0; j <= w; j++) {
                for(int k = 0; k < 2; k++) {
                    dp[i][j][k] = -987654321;
                }
            }
        }


        dp[0][0][0] = 0;

        for(int i = 1; i <= t; i++) {
            for(int j = 0; j <= w; j++) {
                for(int k = 0; k < 2; k++) {
                    if(a[i] == k) {
                        dp[i][j][k] = dp[i - 1][j][k] + 1;
                        if (j - 1 >= 0) {
                            dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - 1][k ^ 1] + 1);
                        }
                    }
                    else {
                        dp[i][j][k] = dp[i - 1][j][k];
                        if (j - 1 >= 0) {
                            dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - 1][k ^ 1]);
                        }
                    }
                }
            }
        }

        int ret = 0;
        for(int i = 0; i <= w; i++) {
            ret = Math.max(ret, dp[t][i][0]);
            ret = Math.max(ret, dp[t][i][1]);
        }

        System.out.println(ret);

//        System.out.println(Math.max(dp[t][w][0], dp[t][w][1]));
    }
}
// dp[n][m][k] = n초에 m번 움직여서 k에 있을때 받는 자두의 최대개수
// dp[n][m][1] = dp[n-1][m][1] + 1, dp[n-1][m-1][0] + 1
