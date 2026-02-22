package com.fiddich.test.keundol.test10;

import java.util.*;

public class BOJ4811 {

    static long[][] dp = new long[34][34];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i <= 30; i++) {
            dp[i][0] = 1;
        }
        for(int i = 1; i <= 30; i++) {
            for(int j = 1; j <= i; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        while(true) {
            int n = sc.nextInt();
            if(n == 0) {
                break;
            }

            System.out.println(dp[n][n]);
        }
    }
}

// dp[i][j] = 한개짜리 i개와 반개짜리 j개로 만들수 있는 경우의 수
// dp[i][j] = 한개짜리가 있으면 dp[i-1][j] + 반개짜리가 있으면 dp[i][j-1]

