package com.fiddich.test.keundol.test27;

import java.util.*;
import java.io.*;

public class BOJ9184 {

    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        dp = new int[104][104][104];
        for(int i = 0; i < 104; i++) {
            for(int j = 0; j < 104; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        while(true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

//            System.out.println(a + " : " + b + " : " + c);

            if(a == -1 && b == -1 && c == -1) {
                break;
            }

            System.out.println("w(" + a + ", " + b + ", " + c + ") = " +  go(a+50, b+50, c+50));
        }
    }

    static int go(int a, int b, int c) {
        if(a <= 50 || b <= 50 || c <= 50) {
            return 1;
        }

        if(dp[a][b][c] != -1) {
            return dp[a][b][c];
        }

        if(a > 70 || b > 70 || c > 70) {
            return dp[a][b][c] = go(70, 70, 70);
        }

        if(a < b && b < c) {
            return dp[a][b][c] = go(a, b, c-1) + go(a, b-1, c-1) - go(a, b-1, c);
        }

        return dp[a][b][c] = go(a-1, b, c) + go(a-1, b-1, c) + go(a-1, b, c-1) - go(a-1, b-1, c-1);
    }
}
