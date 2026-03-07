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

        double[] result = new double[n];
        double temp = 1;
        for(int i = 0; i < n; i++) {
            temp *= a[i];
            if(temp >= a[i]) {
                result[i] = temp;
            }
            else {
                result[i] = a[i];
                temp = a[i];
            }
        }

        double ret = 0;
        for(int i = 0; i < n; i++) {
            ret = Math.max(ret, result[i]);
        }

        System.out.printf("%.3f", ret);
    }
}
