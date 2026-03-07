package com.fiddich.test.solveac.class4.test1;

import java.util.*;

public class BOJ1504 {

    static int n, m, s, e;
    static List<Node>[] adj;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        adj = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            int start = sc.nextInt() - 1;
            int end = sc.nextInt() - 1;
            int weight = sc.nextInt();
            adj[start].add(new Node(end, weight));
            adj[end].add(new Node(start, weight));
        }

        s = sc.nextInt() - 1;
        e = sc.nextInt() - 1;

        dijkstra();
    }

    static void dijkstra() {
        int[] dis = new int[n];
        int[] cnt = new int[n];
        Arrays.fill(dis, 987654321);

        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> {
            return n1.weight - n2.weight;
        });
        dis[s] = 0;
        pq.add(new Node(s, 0));

        while(!pq.isEmpty()) {
            Node n = pq.poll();
            int cur = n.pos;
            int curDis = n.weight;

            if(dis[cur] < curDis) {
                continue;
            }

            for(Node next : adj[cur]) {
                if(dis[next.pos] > dis[cur] + next.weight) {
                    if(next.pos == e && cnt[cur] + 1 < 2) {
                        continue;
                    }
                    dis[next.pos] = dis[cur] + next.weight;
                    cnt[next.pos] = cnt[cur] + 1;
                    pq.add(new Node(next.pos, dis[next.pos]));
                }
            }
        }

        System.out.println(dis[e]);
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
