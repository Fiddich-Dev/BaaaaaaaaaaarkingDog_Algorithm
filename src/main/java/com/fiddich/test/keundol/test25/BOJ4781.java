package com.fiddich.test.keundol.test25;

import java.util.*;

public class BOJ4781 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int n = sc.nextInt();
            int m = (int) (sc.nextDouble() * 100 + 0.5);

            if(n == 0 && m == 0) {
                break;
            }

            int[] k = new int[n+1];
            int[] p = new int[n+1];

            for(int i = 1; i <= n; i++) {
                k[i] = sc.nextInt();
                p[i] = (int) (sc.nextDouble() * 100 + 0.5);
            }

            int[] dp = new int[m+1];
            for(int i = 1; i <= n; i++) {
                for(int j = p[i]; j <= m; j++) {
                    dp[j] = Math.max(dp[j], dp[j-p[i]] + k[i]);
                }
            }

            System.out.println(dp[m]);
        }
    }
}

// dp[n][m] = n번째까지 고려했을때 m의 돈으로 얻는 최대 칼로리
// dp[n][m] = dp[n-1][m-p[n]] + a[n]
