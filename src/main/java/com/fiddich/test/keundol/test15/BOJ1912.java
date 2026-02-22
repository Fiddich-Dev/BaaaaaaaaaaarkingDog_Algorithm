package com.fiddich.test.keundol.test15;

import java.util.*;

public class BOJ1912 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n+1];
        for(int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }

        int[] dp = new int[n+1];
        dp[0] = -987654321;
        for(int i = 1; i <= n; i++) {
            dp[i] = Math.max(a[i], dp[i-1] + a[i]);
        }

        int ret = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++) {
            ret = Math.max(ret, dp[i]);
        }

        System.out.println(ret);
    }
}
