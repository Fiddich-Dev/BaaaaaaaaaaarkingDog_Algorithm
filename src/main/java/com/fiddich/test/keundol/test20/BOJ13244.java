package com.fiddich.test.keundol.test20;

import java.util.*;

public class BOJ13244 {

    static int v, e;
    static List<Integer>[] adj;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- != 0) {
            v = sc.nextInt();
            e = sc.nextInt();
            adj = new ArrayList[v];
            for(int i = 0; i < v; i++) {
                adj[i] = new ArrayList<>();
            }
            for(int i = 0; i < e; i++) {
                int from  = sc.nextInt() - 1;
                int to = sc.nextInt() - 1;
                adj[from].add(to);
                adj[to].add(from);
            }

            // 트리의 조건 : 노드수 - 1 = 간선 수,
            if(v - 1 == e && bfs(0) == v) {
                System.out.println("tree");
            }
            else {
                System.out.println("graph");
            }
        }
    }

    static int bfs(int start) {
        int[] visited = new int[v];
        visited[start] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        int cnt = 0;
        while(!q.isEmpty()) {
            int now = q.poll();
            cnt++;
            for(int next : adj[now]) {
                if(visited[next] == 0) {
                    visited[next] = visited[now] + 1;
                    q.add(next);
                }
            }
        }
        return cnt;
    }

}
