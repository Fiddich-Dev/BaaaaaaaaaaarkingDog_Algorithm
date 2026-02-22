package com.fiddich.test.keundol.test4;

import java.util.*;

public class BOJ1940 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);

        int l = 0;
        int r = n-1;

        int cnt = 0;
        while(l < r) {
            int sum = a[l] + a[r];
            if(sum < m) {
                l++;
            }
            else if(sum > m) {
                r--;
            }
            else {
                cnt++;
                l++;
            }
        }

        System.out.println(cnt);

//        int cnt = 0;
//        for(int i = 0; i < n; i++) {
//            for(int j = i+1; j < n; j++) {
//                if(a[i] + a[j] == m) {
//                    cnt++;
//                }
//            }
//        }
//
//        System.out.println(cnt);
    }

}
