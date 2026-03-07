package com.fiddich.test.solveac.class3;

import java.util.*;

public class BOJ17626 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[n+1];
        Arrays.fill(dp, 987654321);
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            int cur = 1;
            while(i - cur*cur >= 0) {
                dp[i] = Math.min(dp[i], dp[i- cur*cur] + 1);
                cur++;
            }
        }

        System.out.println(dp[n]);
    }
}
