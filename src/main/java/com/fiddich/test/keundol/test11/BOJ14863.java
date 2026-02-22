package com.fiddich.test.keundol.test11;

import java.util.*;
import java.io.*;

public class BOJ14863 {

    static int n, k;
    static Info[] a;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        a = new Info[n+1];
        dp = new int[n+1][k+1];
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int t1 = Integer.parseInt(st.nextToken());
            int m1 = Integer.parseInt(st.nextToken());
            int t2 = Integer.parseInt(st.nextToken());
            int m2 = Integer.parseInt(st.nextToken());
            a[i] = new Info(t1, m1, t2, m2);
        }

        dp[1][a[1].t1] = Math.max(dp[1][a[1].t1], a[1].m1);
        dp[1][a[1].t2] = Math.max(dp[1][a[1].t2], a[1].m2);

        for(int i = 2; i <= n; i++) {
            int t1 = a[i].t1;
            int m1 = a[i].m1;
            int t2 = a[i].t2;
            int m2 = a[i].m2;

            for(int j = 0; j <= k; j++) {
                if(j - t1 >= 0 && dp[i-1][j - t1] != 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j - t1] + m1);
                }
                if(j - t2 >= 0 && dp[i-1][j - t2] != 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j - t2] + m2);
                }
            }
        }

        int ret = 0;
        for(int i = 0; i <= k; i++) {
            ret = Math.max(ret, dp[n][i]);
        }

        System.out.println(ret);
    }


    // dp[i][j] = i 번쨰까지 j의 시간으로 가는 최댓값

    static class Info {
        int t1;
        int m1;
        int t2;
        int m2;

        public Info(int t1, int m1, int t2, int m2) {
            this.t1 = t1;
            this.m1 = m1;
            this.t2 = t2;
            this.m2 = m2;
        }
    }
}
