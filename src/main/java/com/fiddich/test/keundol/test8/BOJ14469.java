package com.fiddich.test.keundol.test8;

import java.util.*;

public class BOJ14469 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Pair[] a = new Pair[n];
        for(int i = 0; i < n; i++) {
            a[i] = new Pair(sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(a, (p1, p2) -> {
            return p1.s - p2.s;
        });

        int cur = 0;
        for(int i = 0; i < n; i++) {
            int s = a[i].s;
            int t = a[i].t;
            cur = Math.max(cur, s);
            cur += t;
        }

        System.out.println(cur);
    }

    static class Pair {
        int s;
        int t;

        public Pair(int s, int t) {
            this.s = s;
            this.t = t;
        }
    }
}
