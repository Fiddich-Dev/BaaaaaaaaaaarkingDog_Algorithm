package com.fiddich.test.keundol.test7;

import java.util.*;

public class BOJ2670 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] a = new double[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextDouble();
        }

        double ret = 0;
        for(int i = 0; i < n; i++) {
            double cur = 1;
            for(int j = i; j < n; j++) {
                cur *= a[j];
                ret = Math.max(ret, cur);
            }
        }

        System.out.println(String.format("%.3f", ret));
    }
}
