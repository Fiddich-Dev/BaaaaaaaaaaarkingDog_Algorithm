package com.fiddich.dp;

import java.util.*;

public class BOJ1463 {

    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[n+1];

        dp[1] = 0;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + 1;
            if(i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            if(i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        System.out.println(dp[n]);

    }

}
// dp[num] = num에서 1까지 가는 최소 연산수
// dp[num] = min(dp[num-1], dp[num / 2], dp[num / 3]) + 1