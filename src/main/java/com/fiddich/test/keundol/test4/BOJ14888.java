package com.fiddich.test.keundol.test4;

import java.util.*;

public class BOJ14888 {

    static int n;
    static int[] a;
    static int[] op;
    static long mx = Long.MIN_VALUE;
    static long mn = Long.MAX_VALUE;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n];
        op = new int[4];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for(int i = 0; i < 4; i++) {
            op[i] = sc.nextInt();
            for(int j = 0; j < op[i]; j++) {
                list.add(i);
            }
        }

        permutation(0, n-1, n-1);

        System.out.println(mx);
        System.out.println(mn);
    }

    static void permutation(int depth, int n, int r) {
        if(depth == r) {
            long ret = calc(list);
            mx = Math.max(mx, ret);
            mn = Math.min(mn, ret);
            return;
        }
        for(int i = depth; i < n; i++) {
            swap(depth, i);
            permutation(depth+1, n, r);
            swap(depth, i);
        }
    }

    static void swap(int a, int b) {
        int temp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, temp);
    }

    static long calc(List<Integer> list) {
        long temp = a[0];
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i) == 0) {
                temp += a[i+1];
            }
            else if(list.get(i) == 1) {
                temp -= a[i+1];
            }
            else if(list.get(i) == 2) {
                temp *= a[i+1];
            }
            else if(list.get(i) == 3) {
                temp /= a[i+1];
            }
        }
        return temp;
    }
}
