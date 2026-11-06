package com.fiddich.dijkstra;

import java.util.*;

public class BOJ11779 {

    static int n, m, s, e;
    static int[] dis;
    static List<Node>[] adj;
    static int[] prev;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        adj = new ArrayList[n];
        dis = new int[n];
        prev = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            int w = sc.nextInt();
            adj[a].add(new Node(b, w));
        }
        s = sc.nextInt() - 1;
        e = sc.nextInt() - 1;

        prev[s] = -1;

        dijkstra();

        System.out.println(dis[e]);

    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> {
            return n1.weight - n2.weight;
        });
        pq.add(new Node(s, 0));
        dis[s] = 0;

        while(!pq.isEmpty()) {
            Node n = pq.poll();
            int now = n.target;
            int dist = n.weight;

            if(dis[now] < dist) {
                continue;
            }
            for(Node next : adj[now]) {
                int cost = dist + next.weight;

                if(dis[next.target] > cost) {
                    dis[next.target] = cost;
                    pq.add(new Node(next.target, dis[next.target]));
                }
            }
        }
    }

    static class Node {
        int target;
        int weight;

        public Node(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }
}
