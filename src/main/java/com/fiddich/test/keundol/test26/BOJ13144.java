package com.fiddich.test.keundol.test26;

import java.util.*;
import java.io.*;

public class BOJ13144 {

    static int n;
    static int[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        a = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[100004];
        Arrays.fill(dp, n);

        long ret = 0;
        for(int i = n-1; i >= 0; i--) {
            ret += dp[a[i]] - i;
            dp[a[i]] = i;
        }

        System.out.println(ret);
    }
}
