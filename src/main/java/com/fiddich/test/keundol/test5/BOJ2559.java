package com.fiddich.test.keundol.test5;

import java.util.*;

public class BOJ2559 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        int[] psum = new int[n+1];
        int sum = 0;
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            sum += a[i];
            psum[i+1] = sum;
        }

        int ret = Integer.MIN_VALUE;
        for(int i = k; i <= n; i++) {
            int temp = psum[i] - psum[i-k];
            ret = Math.max(ret, temp);
        }

        System.out.println(ret);
    }
}
