package com.fiddich.test.keundol.test18;

import java.util.*;

public class BOJ14627 {

    static int n, m;
    static int[] a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n];
        int r = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            r = Math.max(r, a[i]);
        }

        int v = 0;
        int l = 1;

        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(isValid(mid)) {
                v = Math.max(v, mid);
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }

        long sum = 0;
        for(int i = 0; i < n; i++) {
            sum += a[i];
        }

        long ret = sum - (long) m*v;
        System.out.println(ret);
    }

    static boolean isValid(int mid) {
        long sum = 0;
        for(int i = 0; i < n; i++) {
            sum += a[i] / mid;
        }

        if(sum >= m) {
            return true;
        }
        return false;
    }
}
