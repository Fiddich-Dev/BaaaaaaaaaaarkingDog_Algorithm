package com.fiddich;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] a = new double[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextDouble();
        }

        double ret = -1;
        double[] dp = new double[n];
        dp[0] = a[0];
        for(int i = 1; i < n; i++) {
            dp[i] = Math.max(a[i], dp[i-1] * a[i]);
            ret = Math.max(ret, dp[i]);
        }

        System.out.println(String.format("%.3f", ret));

    }

}
