package com.fiddich.test.keundol.test14;

import java.util.*;
import java.io.*;

public class BOJ1325 {

    static int n, m;
    static List<Integer>[] adj;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        adj = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken()) - 1;
            int from = Integer.parseInt(st.nextToken()) - 1;
            adj[from].add(to);
        }

        int[] cnt = new int[n];
        int mx = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            visited = new int[n];
            cnt[i] = bfs(i);
            mx = Math.max(mx, cnt[i]);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            if(cnt[i] == mx) {
                sb.append(i+1).append(" ");
            }
        }
        System.out.println(sb);
    }

    static int bfs(int start) {
        int ret = 0;

        Queue<Integer> q = new ArrayDeque<>();
        visited[start] = 1;
        q.add(start);

        while(!q.isEmpty()) {
            int now = q.poll();

            ret++;
            for(int next : adj[now]) {
                if(visited[next] == 0) {
                    visited[next] = visited[now] + 1;
                    q.add(next);
                }
            }
        }

        return ret;
    }
}
