package com.fiddich.test.softwaremaestro.test2;

import java.util.*;

public class BOJ11054 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[n-1-i] = a[i];
        }

        int[] cnt1 = new int[n];
        int[] cnt2 = new int[n];
        Arrays.fill(cnt1, 1);
        Arrays.fill(cnt2, 1);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(a[i] > a[j]) {
                    cnt1[i] = Math.max(cnt1[i], cnt1[j] + 1);
                }
                if(b[i] > b[j]) {
                    cnt2[i] = Math.max(cnt2[i], cnt2[j] + 1);
                }
            }
        }

        int ret = -1;
        for(int i = 0; i < n; i++) {
            ret = Math.max(ret, cnt1[i] + cnt2[n-1-i] - 1);
        }

        System.out.println(ret);
    }
}
