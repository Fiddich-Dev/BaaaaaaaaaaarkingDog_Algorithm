package com.fiddich.greedy;

import java.util.*;

public class BOJ11047 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);

        int ret = 0;
        for(int i = n-1; i >= 0; i--) {
            int value = a[i];
            ret += k / value;
            k = k % value;
        }

        System.out.println(ret);
    }
}
