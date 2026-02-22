package com.fiddich.test.keundol.test8;

import java.util.*;

public class BOJ1509 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = s.length();
        s = " " + s;

        boolean[][] isPalin = new boolean[n+1][n+1];

        for(int i = 1; i <= n; i++) {
            isPalin[i][i] = true;
        }

        for(int i = 1; i <= n; i++) {
            if(s.charAt(i) == s.charAt(i+1)) {
                isPalin[i][i+1] = true;
            }
        }

        for(int len = 3; len <= n; len++) {
            for(int start = 1; start <= n - len + 1; start++) {
                int end = start + len - 1;
            }
        }

        int[] dp = new int[n+1];
        Arrays.fill(dp, 987654321);
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                if(isPalin[j][i]) {
                    dp[i] = Math.min(dp[i], dp[j-1] + 1);
                }
            }
        }
    }

}
