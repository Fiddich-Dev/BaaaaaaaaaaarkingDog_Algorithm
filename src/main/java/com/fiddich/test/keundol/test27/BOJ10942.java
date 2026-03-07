package com.fiddich.test.keundol.test27;

import java.util.*;
import java.io.*;

public class BOJ10942 {

    static int n, m;
    static int[] a;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        a = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        makeTable();

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            sb.append(dp[s][e]).append("\n");
        }

        System.out.println(sb);

    }

    static void makeTable() {
        dp = new int[n][n];
        for(int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 1; j <= n; j++) {
                int l = i - j;
                int r = i + j;
                if(l < 0 || r >= n || a[l] != a[r]) {
                    break;
                }
                if(a[l] == a[r]) {
                    dp[l][r] = 1;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= n; j++) {
                int l = i - 1 - j;
                int r = i + j;
                if(l < 0 || r >= n || a[l] != a[r]) {
                    break;
                }
                if(a[l] == a[r]) {
                    dp[l][r] = 1;
                }
            }
        }
    }
}
