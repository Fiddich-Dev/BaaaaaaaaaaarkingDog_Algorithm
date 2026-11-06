package com.fiddich.dijkstra;

import java.util.*;

public class BOJ1753 {

    static int v, e, s;
    static List<Node>[] adj;
    static int[] dis;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();
        s = sc.nextInt() - 1;
        dis = new int[v];
        Arrays.fill(dis, Integer.MAX_VALUE);
        adj = new ArrayList[v];
        for(int i = 0; i < v; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < e; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            int w = sc.nextInt();
            adj[a].add(new Node(b, w));
        }

        dijkstra();

        for(int i = 0; i < v; i++) {
            if(dis[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            }
            else {
                System.out.println(dis[i]);
            }
        }

    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> {
            return n1.weight - n2.weight;
        });
        pq.add(new Node(s, 0));
        dis[s] = 0;

        while(!pq.isEmpty()) {
            Node n = pq.poll(); // 지금까지의 거리
            int now = n.target;
            int dist = n.weight;

            // 현재의 최단거리가 지금까지의 거리보다 작으면 확인 안해도됨
            if(dis[now] < dist) {
                continue;
            }

            for(Node next : adj[n.target]) { // 한칸 거리
                int cost = n.weight + next.weight;

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
