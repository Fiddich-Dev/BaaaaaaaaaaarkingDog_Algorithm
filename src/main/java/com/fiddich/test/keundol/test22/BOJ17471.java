package com.fiddich.test.keundol.test22;

import java.util.*;

public class BOJ17471 {

    static int n;
    static int[] a;
    static List<Integer>[] adj;
    static int[] divide;
    static int ret = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n];
        adj = new ArrayList[n];
        for(int i = 0 ; i < n; i++) {
            a[i] = sc.nextInt();
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < n; i++) {
            int m = sc.nextInt();
            for(int j = 0; j < m; j++) {
                int to = sc.nextInt() - 1;
                adj[i].add(to);
                adj[to].add(i);
            }
        }

        for(int i = 1; i < ((1 << n) - 1); i++) {
            divide = new int[n];
            for(int j = 0; j < n; j++) {
                if((i & (1 << j)) != 0) {
                    divide[j] = 1;
                }
            }

            int[] visited = new int[n];
            int[] cnt = new int[2];
            int[] sum = new int[2];
            for(int j = 0; j < n; j++) {
                if(visited[j] != 0) {
                    continue;
                }
                cnt[divide[j]]++;
                sum[divide[j]] += bfs(j, visited);
            }

            if(cnt[0] == 1 && cnt[1] == 1) {
                int dis = Math.abs(sum[0] - sum[1]);
                ret = Math.min(ret, dis);
            }
        }

        if(ret == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(ret);
    }

    static int bfs(int cur, int[] visited) {
        int num = divide[cur];
        Queue<Integer> q = new LinkedList<>();
        q.add(cur);
        visited[cur] = 1;

        int sum = 0;
        while(!q.isEmpty()) {
            int now = q.poll();
            sum += a[now];
            for(int next : adj[now]) {
                if(visited[next] == 0 && divide[next] == num) {
                    visited[next] = visited[now] + 1;
                    q.add(next);
                }
            }
        }
        return sum;
    }

}
