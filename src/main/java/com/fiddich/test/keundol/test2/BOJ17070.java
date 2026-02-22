package com.fiddich.test.keundol.test2;

import java.util.*;

public class BOJ17070 {

    static int n;
    // 0 : 오른쪽, 1 : 대각, 2: 아래
    static int[][][] dp;
    static int[][] a; // 0만 갈 수 있음


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n][n];
        dp = new int[n+1][n+1][3];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        dp[1][2][0] = 1;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(a[i-1][j-1] == 1) {
                    continue;
                }
                dp[i][j][0] += dp[i][j-1][0] + dp[i][j-1][1];
                if(i-2 >= 0 && a[i-2][j-1] == 0 && j-2 >= 0 && a[i-1][j-2] == 0) {
                    dp[i][j][1] += dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
                }
                dp[i][j][2] += dp[i-1][j][1] + dp[i-1][j][2];
            }
        }


        int ret = dp[n][n][0] + dp[n][n][1] + dp[n][n][2];
        System.out.println(ret);
    }
}
