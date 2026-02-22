package com.fiddich.test.keundol.test13;

import java.util.*;

public class BOJ2343 {

    static int n, m;
    static int[] a;
    static int ret = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n];

        int l = 0;
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            l = Math.max(l, a[i]);
        }

        int r = 1_000_000_000;
        lowerBound(l, r);

        System.out.println(ret);
    }

    static boolean isValid(int mid) { // mid는 블루레이의 크기
        int cnt = 0; // 필요한 블루레이 개수
        int sum = 0;
        for(int i = 0; i < n; i++) {
            if(sum + a[i] > mid) {
                cnt++;
                sum = a[i];
            }
            else {
                sum += a[i];
            }
        }
        cnt++;

        return cnt <= m;
    }

    static void lowerBound(int l, int r) {
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
    }
}
