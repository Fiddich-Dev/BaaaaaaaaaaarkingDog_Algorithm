package com.fiddich.graph;

import java.util.*;

public class BOJ5567 {

    static int n, m;
    static List<Integer>[] adj;
    static int[] visited;
    static int ret = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        adj = new ArrayList[n+1];
        visited = new int[n+1];
        for(int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj[a].add(b);
            adj[b].add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = 1;

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

        // for(int i = 1; i <= n; i++) {
        //     System.out.print(visited[i] + " ");
        // }
        // System.out.println();

        for(int i = 1; i <= n; i++) {
            if(visited[i] > 1 && visited[i] <= 3) {
                ret++;
            }
        }

        System.out.println(ret);
    }

    static void dfs(int now, int depth) {
        System.out.println(now + " : " + depth);
        if(depth == 3) {
            return;
        }
        visited[now] = 1;

        ret++;
        for(int next : adj[now]) {
            if(visited[next] != 0) {
                continue;
            }
            dfs(next, depth+1);
        }
    }
}
