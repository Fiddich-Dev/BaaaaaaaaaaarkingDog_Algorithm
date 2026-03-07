package com.fiddich.test.solveac.class4.test1;

import java.util.*;

public class BOJ14938 {

    static int n, m, r;
    static int[] a;
    static List<Node>[] adj;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt();
        a = new int[n];
        adj = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < r; i++) {
            int start = sc.nextInt() - 1;
            int end = sc.nextInt() - 1;
            int weight = sc.nextInt();
            adj[start].add(new Node(end, weight));
            adj[end].add(new Node(start, weight));
        }

        int ret = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            int price = dijkstra(i);
            ret = Math.max(ret, price);
        }

        System.out.println(ret);
    }

    static int dijkstra(int start) {
        int[] dis = new int[n];
        Arrays.fill(dis, 987654321);

        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> {
            return n1.weight - n2.weight;
        });
        dis[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node n = pq.poll();
            int cur = n.pos;
            int curDis = n.weight;

            if(dis[cur] < curDis) {
                continue;
            }

            for(Node next : adj[cur]) {
                if(dis[next.pos] > dis[cur] + next.weight) {
                    dis[next.pos] = dis[cur] + next.weight;
                    pq.add(new Node(next.pos, dis[next.pos]));
                }
            }
        }

        int sum = 0;
        for(int i = 0; i < n; i++) {
            if(dis[i] <= m) {
                sum += a[i];
            }
        }

        return sum;
    }

    static class Node {
        int pos;
        int weight;

        public Node(int pos, int weight) {
            this.pos = pos;
            this.weight = weight;
        }
    }
}
