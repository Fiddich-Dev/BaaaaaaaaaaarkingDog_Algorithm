package com.fiddich.test.keundol.test16;

import java.util.*;

public class BOJ1450 {

    static int n, c;
    static int[] a;
    static List<Integer> left, right;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        c = sc.nextInt();
        a = new int[n];
        for(int i= 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        left = new ArrayList<>();
        right = new ArrayList<>();
        go(left, 0, n/2, 0);
        go(right, n/2+1, n-1, 0);

        Collections.sort(right);
        int ret = 0;
        for(int i = 0; i < left.size(); i++) {
            ret += upperBound(0, right.size(), c - left.get(i));;
        }

        System.out.println(ret);
    }

    static int upperBound(int l, int r, int target) {
        while(l < r) {
            int mid = l + (r - l) / 2;
            if(right.get(mid) > target) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }

        return r;
    }

    static void go(List<Integer> list, int l, int r, int sum) {
        if(sum > c) {
            return;
        }
        if(l > r) {
            list.add(sum);
            return;
        }

        go(list, l+1, r, sum);
        go(list, l+1, r, sum+a[l]);
    }

}
