package com.fiddich.test.keundol.test1;

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

        int now = -1;
        int cnt = 0;
        for(Pair p : a) {
            int start = p.s;
            int end = p.e;
            if(now <= start) {
                now = end;
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static class Pair {
        int s;
        int e;
        Pair(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
}
