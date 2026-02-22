package com.fiddich.test.keundol.test9;

import java.util.*;

public class BOJ2565 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Pair[] a = new Pair[n];
        for(int i = 0; i < n; i++) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            a[i] = new Pair(num1, num2);
        }

        Arrays.sort(a, (p1, p2) -> {
           return p1.s - p2.s;
        });

        int[] lis = new int[n];
        int len = 0;
        for(int i = 0; i < n; i++) {
            int pos = lowerBound(lis, len, a[i].e);
            if(pos == len) {
                len++;
            }
            lis[pos] = a[i].e;
        }

        System.out.println(n - len);
    }

    static int lowerBound(int[] lis, int len, int target) {
        int l = 0;
        int r = len;
        while(l < r) {
            int mid = l + (r - l) / 2;
            if(lis[mid] >= target) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }
        return r;
    }

    static class Pair {
        int s;
        int e;

        public Pair(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
}
