package com.fiddich.mst;

import java.util.*;

public class BOJ1197 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        int[] next = new int[v];
        Arrays.fill(next, -1);
        Edge[] edges = new Edge[e];
        for(int i = 0; i < e; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            int c = sc.nextInt();
            edges[i] = new Edge(a, b, c);
        }

        Arrays.sort(edges, (e1, e2) -> {
            return e1.price - e2.price;
        });

        List<Edge> ret = new ArrayList<>();
        for(int i = 0; i < e; i++) {
            int a = edges[i].from;
            int b = edges[i].to;
            int c = edges[i].price;
            if(union(a, b, next)) {
                ret.add(edges[i]);
            }
            if(ret.size() == v - 1) {
                break;
            }
        }

        int result = 0;
        for(Edge edge : ret) {
            result += edge.price;
        }

        System.out.println(result);
    }

    static boolean union(int a, int b, int[] next) {
        a = find(a, next);
        b = find(b, next);
        if(a == b) {
            return false;
        }
        if(next[a] < next[b]) {
            int temp = a;
            a = b;
            b = temp;
        }
        if(next[a] == next[b]) {
            next[a]--;
        }
        next[b] = a;
        return true;
    }

    static int find(int n, int[] next) {
        if(next[n] < 0) {
            return n;
        }
        return next[n] = find(next[n], next);
    }

    static class Edge {
        int from;
        int to;
        int price;

        public Edge(int from, int to, int price) {
            this.from = from;
            this.to = to;
            this.price = price;
        }
    }
}
