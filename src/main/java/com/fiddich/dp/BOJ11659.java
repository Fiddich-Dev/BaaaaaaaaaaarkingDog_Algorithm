package com.fiddich.dp;

import java.util.*;

public class BOJ11659 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int[] psum = new int[n+1];
        int sum = 0;
        for(int i = 1; i <= n; i++) {
            sum += a[i-1];
            psum[i] = sum;
        }

        for(int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            System.out.println(psum[e] - psum[s-1]);
        }
    }
}
