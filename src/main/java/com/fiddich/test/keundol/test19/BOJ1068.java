package com.fiddich.test.keundol.test19;

import java.util.*;

public class BOJ1068 {

    static int n, deleted;
    static List<Integer>[] adj;
    static int cnt;
    static int[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        adj = new ArrayList[n];
        visited = new int[n];
        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            if(temp == -1) {
                continue;
            }
            adj[temp].add(i);
        }

        deleted = sc.nextInt();
        dfs(deleted);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < adj[i].size(); j++) {
                if(adj[i].get(j) == deleted) {
                    adj[i].remove(j);
                }
            }
        }

        for(int i = 0; i < n; i++) {
            if(adj[i].isEmpty() && visited[i] == 0) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static void dfs(int now) {
        for(int next : adj[now]) {
            dfs(next);
        }
        adj[now] = new ArrayList<>();
        visited[now] = 1;
    }
}
