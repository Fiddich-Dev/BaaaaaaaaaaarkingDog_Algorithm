package com.fiddich.graph;

import java.util.*;

public class BOJ11403 {

    static int n;
    static List<Integer>[] adj;
    static int[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        adj = new ArrayList[n];
        visited = new int[n];

        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
            for(int j = 0; j < n; j++) {
                int num = sc.nextInt();
                if(num == 1) {
                    adj[i].add(j);
                }
            }
        }

        for(int i = 0; i < n; i++) {
            visited = new int[n];
            for(int next : adj[i]) {
                dfs(next);
            }

            for(int j = 0; j < n; j++) {
                if(visited[j] == 1) {
                    System.out.print(1 + " ");
                }
                else {
                    System.out.print(0 + " ");
                }
            }

            System.out.println();
        }
    }

    static void dfs(int now) {
        visited[now] = 1;
        for(int next : adj[now]) {
            if(visited[next] != 0) {
                continue;
            }
            dfs(next);
        }
    }
}
