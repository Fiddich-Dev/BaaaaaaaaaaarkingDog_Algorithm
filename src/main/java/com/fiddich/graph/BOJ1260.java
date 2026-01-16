package com.fiddich.graph;

import java.util.*;

public class BOJ1260 {

    static int n, m, v;
    static int[] visited;
    static List<Integer>[] adj;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        v = sc.nextInt();
        adj = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        visited = new int[n+1];
        for(int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            adj[s].add(e);
            adj[e].add(s);
        }

        for(int i = 1; i <= n; i++) {
            Collections.sort(adj[i]);
        }

        // dfs
        dfs(v);
        System.out.println();

        visited = new int[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v] = 1;
        while(!q.isEmpty()) {
            int now = q.poll();
            System.out.print(now + " ");
            for(int next : adj[now]) {
                if(visited[next] != 0) {
                    continue;
                }
                q.add(next);
                visited[next] = visited[now] + 1;
            }
        }
    }

    static void dfs(int now) {
        System.out.print(now + " ");
        visited[now] = 1;
        for(int next : adj[now]) {
            if(visited[next] != 0) {
                continue;
            }
            dfs(next);
        }
    }
}
