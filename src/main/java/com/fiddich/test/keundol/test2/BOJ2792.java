package com.fiddich.test.keundol.test2;

import java.util.*;

public class BOJ2792 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[m];
        for(int i = 0; i < m; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);

        int l = 1;
        int r = a[m-1];

        int ret = Integer.MAX_VALUE;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(isValid(mid, a, n)) {
                ret = Math.min(ret, mid);
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }

        System.out.println(ret);
    }

    static boolean isValid(int mid, int[] a, int n) {
        int cnt = 0;
        for(int i : a) {
            cnt += i / mid;
            if(i % mid != 0) {
                cnt++;
            }
        }
        return cnt <= n;
    }
}
