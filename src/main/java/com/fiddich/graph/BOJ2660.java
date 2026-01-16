package com.fiddich.graph;

import java.util.*;

public class BOJ2660 {

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
        }
        while(true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(a == -1 && b == -1) {
                break;
            }
            a--;
            b--;
            adj[a].add(b);
            adj[b].add(a);
        }

        int[] score = new int[n]; // visited의 최댓값 - 1
        List<Integer> ret = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            visited = new int[n];
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

            Arrays.sort(visited);
            score[i] = visited[n-1] - 1;
        }

        // 최소 score 구하기
        int a = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            a = Math.min(a, score[i]);
        }
        for(int i = 0; i < n; i++) {
            if(score[i] == a) {
                ret.add(i+1);
            }
        }

        System.out.println(a + " " + ret.size());
        for(int temp : ret) {
            System.out.print(temp + " ");
        }



    }
}
