package com.fiddich.test.solveac.class4.test1;

import java.util.*;

public class BOJ1916 {

    static int n, m;
    static int[] dis;
    static List<Node>[] adj;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        dis = new int[n+1];
        adj = new ArrayList[n+1];
        for(int i = 0; i < n+1; i++) {
            adj[i] = new ArrayList<>();
        }
        Arrays.fill(dis, 987654321);

        for(int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int weight = sc.nextInt();
            adj[start].add(new Node(end, weight));
        }

        int start = sc.nextInt();
        int end = sc.nextInt();

        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> {
            return n1.weight - n2.weight;
        });

        pq.add(new Node(start, 0));
        dis[start] = 0;

        while(!pq.isEmpty()) {
            Node n = pq.poll();
            int now = n.target;
            int weight = n.weight;

            // 돌아가는게 더 빠를때
            if(dis[now] < weight) {
                continue;
            }

            for(Node next : adj[now]) {
                if(dis[next.target] > dis[now] + next.weight) {
                    dis[next.target] = dis[now] + next.weight;
                    pq.add(new Node(next.target, dis[next.target]));
                }
            }
        }

        System.out.println(dis[end]);
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
