package com.fiddich.test.keundol.test19;

import java.util.*;

public class BOJ7795 {

    static int n, m;
    static int[] a, b;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- != 0) {
            n = sc.nextInt();
            m = sc.nextInt();
            a = new int[n];
            b = new int[m];
            for(int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            for(int j = 0; j < m; j++) {
                b[j] = sc.nextInt();
            }

            Arrays.sort(b);

            int cnt = 0;
            for(int i = 0; i < n; i++) {
                cnt += lowerBound(a[i]);
            }

            System.out.println(cnt);

        }
    }

    static int lowerBound(int target) {
        int l = 0;
        int r = b.length;
        while(l < r) {
            int mid = l + (r - l) / 2;
            if(b[mid] >= target) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }
        return r;
    }
}
