package com.fiddich.test.solveac.class3;

import java.util.*;

public class BOJ1389 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] visited = new int[n];
        List<Integer>[] adj = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        int m = sc.nextInt();
        for(int i = 0; i < m; i++) {
            int from = sc.nextInt() - 1;
            int to = sc.nextInt() - 1;
            adj[from].add(to);
            adj[to].add(from);
        }

        int[] cnt = new int[n];

        for(int i = 0; i < n; i++) {
            int temp = 0;
            visited = new int[n];
            Queue<Integer> q = new LinkedList<>();
            visited[i] = 1;
            q.add(i);

            while(!q.isEmpty()) {
                int now = q.poll();
                temp += visited[now] - 1;
                for(int next : adj[now]) {
                    if(visited[next] == 0) {
                        visited[next] = visited[now] + 1;
                        q.add(next);
                    }
                }
            }
            cnt[i] = temp;
        }

        int cur = Integer.MAX_VALUE;
        int ret = -1;
        for(int i = 0; i < n; i++) {
//            System.out.println(cnt[i]);
            if(cur > cnt[i]) {
                cur = cnt[i];
                ret = i;
            }
        }

        System.out.println(ret + 1);
    }
}
