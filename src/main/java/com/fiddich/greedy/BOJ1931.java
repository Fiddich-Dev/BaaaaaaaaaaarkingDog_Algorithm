package com.fiddich.greedy;

import java.util.*;

public class BOJ1931 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Pair[] a = new Pair[n];
        for(int i = 0; i < n; i++) {
            a[i] = new Pair(sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(a, (p1, p2) -> {
            if(p1.e == p2.e) {
                return p1.s - p2.s;
            }
            return p1.e - p2.e;
        });

        int ret = 0;
        int now = 0;
        for(int i = 0; i < n; i++) {
            Pair p = a[i];
            if(now <= p.s) {
                ret++;
                now = p.e;
            }
        }

        System.out.println(ret);
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
