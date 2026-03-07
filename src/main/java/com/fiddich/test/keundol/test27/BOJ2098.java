package com.fiddich.test.keundol.test27;

import java.util.*;

public class BOJ2098 {

    static int n;
    static int[][] a;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        dp = new int[n][1 << n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(go(0, 1));

    }

    static int go(int cur, int visited) {
        if(visited == (1 << n) - 1) {
            if(a[cur][0] == 0) {
                return 987654321;
            }
            return a[cur][0];
        }

        if(dp[cur][visited] != -1) {
            return dp[cur][visited];
        }

        dp[cur][visited] = 987654321;
        for(int next = 0; next < n; next++) {
            if((visited & (1 << next)) == 0 && a[cur][next] != 0) {
                dp[cur][visited] = Math.min(dp[cur][visited], go(next, visited | (1 << next)) + a[cur][next]);
            }
        }

        return dp[cur][visited];
    }
}
