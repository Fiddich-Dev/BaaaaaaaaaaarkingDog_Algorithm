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

        }
    }

    static boolean isValid1() {
        int[] visited = new int[v];
        visited[0] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

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

        if(cnt == v) {
            return true;
        }
        return false;
    }
}
