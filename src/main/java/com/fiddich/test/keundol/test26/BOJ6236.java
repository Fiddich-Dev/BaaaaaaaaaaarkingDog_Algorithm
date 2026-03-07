package com.fiddich.test.keundol.test26;

import java.util.*;

public class BOJ6236 {

    static int n, m;
    static int[] a;
    static int ret = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n];

        int l = 0;
        int r = 0;

        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            l = Math.max(l, a[i]);
            r += a[i];
        }



        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(isValid(mid)) {
                ret = Math.min(ret, mid);
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }

        System.out.println(ret);
    }

    static boolean isValid(int mid) {
        int cnt = 0;
        int cur = 0;
        for(int i = 0; i < n; i++) {
            if(cur < a[i]) {
                cur = mid;
                cur -= a[i];
                cnt++;
            }
            else {
                cur -= a[i];
            }
        }

        if(cnt <= m) {
            return true;
        }
        return false;
    }
}
