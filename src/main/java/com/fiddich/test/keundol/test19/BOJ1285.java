package com.fiddich.test.keundol.test19;

import java.util.*;

public class BOJ1285 {

    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n];
        for(int i = 0; i < n; i++) {
            String s = sc.next();
            for(int j = 0; j < n; j++) {
                if(s.charAt(j) == 'T') {
                    a[i] |= (1 << j);
                }
            }
        }

        int ret = Integer.MAX_VALUE;
        for(int i = 0; i < (1 << n); i++) {
            for(int j = 0; j < n; j++) {
                if((i & (1 << j)) != 0) {
                    a[j] = ~a[j];
                }
            }

            int mn = calc();
            ret = Math.min(ret, mn);

            for(int j = 0; j < n; j++) {
                if((i & (1 << j)) != 0) {
                    a[j] = ~a[j];
                }
            }
        }

        System.out.println(ret);
    }

    // t가 나오는 최소 개수
    static int calc() {
        int ret = 0;

        for(int i = 0; i < n; i++) {
            int cnt = 0;
            for(int j = 0; j < n; j++) {
                if((a[j] & (1 << i)) != 0) {
                    cnt++;
                }
            }

            cnt = Math.min(cnt, n-cnt);
            ret += cnt;
        }

        return ret;
    }

}
