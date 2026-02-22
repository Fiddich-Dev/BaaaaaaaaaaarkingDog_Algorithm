package com.fiddich.greedy;

import java.util.*;

public class BOJ1026 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        Arrays.sort(a);
        Arrays.sort(b);
        int ret = 0;
        for(int i = 0; i < n; i++) {
            ret += a[i] * b[n-1-i];
        }

        System.out.println(ret);
    }
}
