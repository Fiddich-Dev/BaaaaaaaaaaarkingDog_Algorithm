package com.fiddich.test.keundol.test9;

import java.util.*;

public class BOJ9934 {

    static List<Integer>[] ret;
    static int[] a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ret = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            ret[i] = new ArrayList<>();
        }

        int len = (1 << n) - 1;
        a = new int[len];
        for(int i = 0; i < len; i++) {
            a[i] = sc.nextInt();
        }

        go(0, len-1, 0);

//        System.out.println(ret[n-1].size());

        for(int i = 0; i < n; i++) {
            for(int j : ret[i]) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    static void go(int l, int r, int depth) {
        if(l == r) {
            ret[depth].add(a[l]);
            return;
        }

        int mid = l + (r - l) / 2;
        ret[depth].add(a[mid]);
        go(l, mid - 1, depth + 1);
        go(mid + 1 , r, depth + 1);
    }
}
