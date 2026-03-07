package com.fiddich.test.solveac.class3;

import java.util.*;

public class BOJ16928 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[101];
        int[] b = new int[101];
        for(int i = 0; i < n; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            a[from] = to;
        }
        for(int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            a[from] = to;
        }

        int[] visited = new int[104];
        Queue<Integer> q = new LinkedList<>();
        visited[1] = 1;
        q.add(1);

        while(!q.isEmpty()) {
            int now = q.poll();
            for(int i = 1; i <= 6; i++) {
                int next = now + i;
                if(next > 100) {
                    continue;
                }

                if(a[next] != 0) {
                    next = a[next];
                }

                if(visited[next] == 0) {
                    visited[next] = visited[now] + 1;
                    q.add(next);
                }
            }
        }


        System.out.println(visited[100] - 1);
    }
}
