package com.fiddich.test.solveac.class4.test1;

import java.util.*;

public class BOJ11779 {

    static int n, m;
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
            int s = sc.nextInt() - 1;
            int e = sc.nextInt() - 1;
            int w = sc.nextInt();
            adj[s].add(new Node(e, w));
        }

        int s = sc.nextInt() - 1;
        int e = sc.nextInt() - 1;


        dijkstra(s, e);
    }

    static void dijkstra(int start, int end) {
        int[] dis = new int[n];
        int[] prev = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        PriorityQueue<Node> pq =  new PriorityQueue<>((n1, n2) -> {
            return n1.weight - n2.weight;
        });
        dis[start] = 0;
        prev[start] = -1;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node n = pq.poll();
            int cur = n.target;
            int curDis = n.weight;

            if(dis[cur] < curDis) {
                continue;
            }

            for(Node next : adj[cur]) {
                if(dis[next.target] > dis[cur] + next.weight) {
                    prev[next.target] = cur;
                    dis[next.target] = dis[cur] + next.weight;
                    pq.add(new Node(next.target, dis[next.target]));
                }
            }
        }

        System.out.println(dis[end]);

        List<Integer> ret = new ArrayList<>();
        int now = end;
        while(now != -1) {
            ret.add(now);
            now = prev[now];
        }

        Collections.reverse(ret);

        System.out.println(ret.size());

        for(int i : ret) {
            System.out.print((i+1) + " ");
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
