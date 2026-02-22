package com.fiddich.test.keundol.test3;

import java.util.*;

public class BOJ2109 {

    static int n;
    static Pair[] a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new Pair[n];
        for(int i = 0; i < n; i++) {
            int p = sc.nextInt();
            int d = sc.nextInt();
            a[i] = new Pair(d, p);
        }
        Arrays.sort(a, (p1, p2) -> {
            if(p1.d == p2.d) {
                return p1.p - p2.p;
            }
            return p1.d - p2.d;
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(Pair pair : a) {
            int d = pair.d;
            int p = pair.p;

            pq.add(p);

            while(d < pq.size()) {
                pq.poll();
            }
        }

        int ret = 0;
        for(int i : pq) {
            ret += i;
        }
        System.out.println(ret);
    }

    // 방금 넣은 d 값이랑 pq의 크기가 같아질때까지 뺌


    static class Pair {
        int d;
        int p;

        public Pair(int d, int p) {
            this.d = d;
            this.p = p;
        }
    }
}
