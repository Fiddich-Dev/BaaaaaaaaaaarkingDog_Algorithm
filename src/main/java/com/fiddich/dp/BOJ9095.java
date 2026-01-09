package com.fiddich.dp;

import java.util.*;

public class BOJ9095 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] dp = new int[11];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i < 11; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        while(t-- != 0) {
            int n = sc.nextInt();
            System.out.println(dp[n]);
        }
    }
}

// 테아블 : dp[num] = 1, 2, 3으로 만들수 있는 num의 가지수
// 점화식 : dp[num] = dp[num - 1] + dp[num - 2] + dp[num - 3]
// 초기화 : dp[0] = 1 dp[1] = 1 dp[2] = 2