package com.fiddich.test.keundol.test8;

import java.util.*;

public class BOJ3687 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        long[] dp = new long[101];
        Arrays.fill(dp, Long.MAX_VALUE);

        dp[2] = 1;
        dp[3] = 7;
        dp[4] = 4;
        dp[5] = 2;
        dp[6] = 6;
        dp[7] = 8;
        dp[8] = 10;

        int[] add = {1, 7, 4, 2, 0, 8};

        for(int i = 9; i <= 100; i++) {
            for(int j = 2; j <= 7; j++) {
                long val = dp[i-j] * 10 + add[j-2];
                dp[i] = Math.min(dp[i], val);
            }
        }

        while(t-- != 0) {
            int n = sc.nextInt();
            System.out.println(dp[n] + " " + max(n));
        }
    }

    static String max(int n) {
        StringBuilder sb = new StringBuilder();
        if(n % 2 == 1) {
            sb.append(7);
            n -= 3;
        }

        for(int i = 0; i < n/2; i++) {
            sb.append(1);
        }

        return sb.toString();
    }
}


