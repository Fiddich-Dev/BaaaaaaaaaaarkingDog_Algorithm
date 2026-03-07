package com.fiddich.test.keundol.test8;

import java.util.*;

public class BOJ1509 {

    static String s;
    static int n;
    static int[][] isPalind;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.next();
        n = s.length();
        makeIsPalind();

        // dp[i] : i번째 문자까지의 최소 분할 수
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                if(isPalind[j][i] == 1) {
                    if(j == 0) {
                        dp[i] = 1;
                    }
                    else {
                        dp[i] = Math.min(dp[i], dp[j-1] + 1);
                    }
                }
            }
        }

        System.out.println(dp[n-1]);
    }

    static void makeIsPalind() {
        isPalind = new int[n][n];

        for(int i = 0; i < n; i++) {
            isPalind[i][i] = 1;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 1; j <= n; j++) {
                int l = i - j;
                int r = i + j;
                if(l < 0 || r >= n || s.charAt(l) != s.charAt(r)) {
                    break;
                }
                isPalind[l][r] = 1;
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 1; j <= n; j++) {
                int l = i - j + 1;
                int r = i + j;
                if(l < 0 || r >= n || s.charAt(l) != s.charAt(r)) {
                    break;
                }
                isPalind[l][r] = 1;
            }
        }
    }
}
