package com.fiddich.graph;

import java.util.*;

public class BOJ11724 {

    static int n, m;
    static List<Integer>[] adj;
    static int[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        adj = new ArrayList[n];
        visited = new int[n];
        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            adj[u].add(v);
            adj[v].add(u);
        }

        int ret = 0;

        for(int i = 0; i < n; i++) {
            if(visited[i] != 0) {
                continue;
            }
            ret++;
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            visited[i] = 1;

            while(!q.isEmpty()) {
                int now = q.poll();
                for(int next : adj[now]) {
                    if(visited[next] != 0) {
                        continue;
                    }
                    q.add(next);
                    visited[next] = visited[now] + 1;
                }
            }
        }

        System.out.println(ret);
    }

    static void dfs(int now) {
        visited[now] = 1;
        for(int next : adj[now]) {
            if(visited[next] == 1) {
                continue;
            }
            dfs(next);
        }
    }
}
