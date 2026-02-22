package com.fiddich.test.keundol.test7;

import java.util.*;

public class BOJ1911 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        Pair[] a = new Pair[n];
        for(int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            a[i] = new Pair(Math.min(s, e), Math.max(s, e));
        }

        Arrays.sort(a, (p1, p2) -> {
            return p1.s - p2.s;
        });

        int ret = 0;

        int cur = 0;
        for(int i = 0; i < n; i++) {
            int s = a[i].s;
            int e = a[i].e;
            if(cur <= s) {
                cur = s;
            }

            if(cur >= e) {
                continue;
            }


            int dis = e - cur;
            int cnt = dis / l;
            if(dis % l != 0) {
                cnt++;
            }

            ret += cnt;
            cur += cnt * l;
        }

        System.out.println(ret);
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
