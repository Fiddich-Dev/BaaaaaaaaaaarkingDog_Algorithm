package com.fiddich.test.keundol.test8;

import java.util.*;

public class BOJ2294 {

    static int n, k;
    static int[] a;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        a = new int[n];
        dp = new int[100004];

        Arrays.fill(dp, 987654321);

        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            dp[a[i]] = 1;
        }



        for(int i = 0; i < n; i++) {
            int value = a[i];
            for(int j = value; j <= k; j++) {
                dp[j] = Math.min(dp[j], dp[j-value] + 1);
            }
        }

        if(dp[k] == 987654321) {
            System.out.println(-1);
            return;
        }
        System.out.println(dp[k]);
    }
}

// dp[n] = n원을 만들수 있는 최소 동전 수
// dp[n] = min(dp[n-1], dp[n-3], dp[n-12]) + 1

