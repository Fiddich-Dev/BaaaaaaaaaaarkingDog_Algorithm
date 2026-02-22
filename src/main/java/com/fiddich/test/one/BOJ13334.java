package com.fiddich.test.one;

import java.util.*;

public class BOJ13334 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Pair[] a = new Pair[n];
        for(int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            a[i] = new Pair(Math.min(s, e), Math.max(s, e));
        }
        int d = sc.nextInt();

        Arrays.sort(a, (p1, p2) -> {
            if(p1.e == p2.e) {
                return p1.s - p2.s;
            }
            return p1.e - p2.e;
        });

        int ret = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++) {
            int start = a[i].s;
            int end = a[i].e;

            if(end - start > d) {
                continue;
            }

            while(!pq.isEmpty() && pq.peek() + d < end) {
                pq.poll();
            }

            pq.add(start);

            ret = Math.max(ret, pq.size());
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
