package com.fiddich.test.keundol.test13;

import java.util.*;

public class BOJ1202 {

    static int n, k;
    static Pair[] a;
    static List<Integer> bag = new ArrayList<>();
    static List<Integer>[] list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        a = new Pair[n];
        for(int i = 0; i < n; i++) {
            int w = sc.nextInt();
            int v = sc.nextInt();
            a[i] = new Pair(w, v);
        }
        list = new ArrayList[k];
        for(int i = 0; i < k; i++) {
            bag.add(sc.nextInt());
            list[i] = new ArrayList<>();
        }

        Arrays.sort(a, (p1, p2) -> {
            if(p2.v == p1.v) {
                return p1.w - p2.w;
            }
            return p2.v - p1.v;
        });

        // 가치가 높은걸 먼저 담는다
        Collections.sort(bag);

        long ret = 0;
        for(Pair p : a) {
            int w = p.w;
            int v = p.v;
            int idx = lowerBound(0, bag.size(), w);
            if(idx == bag.size()) {
                continue;
            }
            list[idx].add(v);
        }

        int[] temp = new int[k];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < k; i++) {
            pq.addAll(list[i]);

            if(!pq.isEmpty()) {
                temp[i] = pq.poll();
            }
        }

        for(int i = 0; i < k; i++) {
            ret += temp[i];
        }

        System.out.println(ret);
    }

    static int lowerBound(int l, int r, int target) {
        while(l < r) {
            int mid = l + (r - l) / 2;
            if(bag.get(mid) >= target) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }
        return r;
    }

    static class Pair {
        int w;
        int v;

        public Pair(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }
}
