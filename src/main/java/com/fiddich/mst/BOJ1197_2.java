package com.fiddich.mst;

import java.util.*;

public class BOJ1197_2 {

    static int v, e;
    static List<Edge>[] adj;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();
        adj = new ArrayList[v];
        for(int i = 0; i < v; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < e; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            int c = sc.nextInt();
            adj[a].add(new Edge(a, b, c));
            adj[b].add(new Edge(b, a, c));
        }

        int[] used = new int[v];
        PriorityQueue<Edge> pq = new PriorityQueue<>((n1, n2) -> {
            return n1.price - n2.price;
        });
        int ret = 0;
        used[0] = 1;
        int cnt = 0;
        pq.addAll(adj[0]);
        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            if(used[edge.to] == 1) {
                continue;
            }
            cnt++;
            ret += edge.price;
            pq.addAll(adj[edge.to]);
            used[edge.to] = 1;

            if(cnt == v - 1) {
                break;
            }
        }

        System.out.println(ret);
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
