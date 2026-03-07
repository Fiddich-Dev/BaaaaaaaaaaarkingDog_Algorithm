package com.fiddich.test.keundol.test27;

import java.util.*;

public class BOJ24416 {

    static int ret1, ret2;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[n+1];
        Arrays.fill(dp, -1);

        fib1(n);
        fib2(n);

        System.out.println(ret1 + " " + ret2);
    }

    static int fib1(int n) {
        if(n == 1 || n == 2) {
            ret1++;
            return 1;
        }
        return fib1(n-1) + fib1(n-2);
    }

    static void fib2(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 1;

        for(int i = 3; i <= n; i++) {
            ret2++;
            dp[i] = dp[i-1] + dp[i-2];
        }
    }
}
