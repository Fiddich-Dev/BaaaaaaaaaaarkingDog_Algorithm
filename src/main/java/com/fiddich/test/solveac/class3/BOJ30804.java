package com.fiddich.test.solveac.class3;

import java.util.*;

public class BOJ30804 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int[] cnt = new int[10];
        int total = 0;
        int l = 0;
        int ret = 0;

        for(int i = 0; i < n; i++) {
            cnt[a[i]]++;
            if(cnt[a[i]] == 1) {
                total++;
            }

            while(total > 2) {
                cnt[a[l]]--;
                if(cnt[a[l]] == 0) {
                    total--;
                }
                l++;
            }

            ret = Math.max(ret, i - l + 1);
        }

         System.out.println(ret);
    }
}
