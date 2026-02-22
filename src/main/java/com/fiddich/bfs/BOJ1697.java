package com.fiddich.bfs;

import java.util.*;

public class BOJ1697 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int visited[] = new int[200001];

        Queue<Integer> q = new LinkedList<>();
        visited[n] = 1;
        q.add(n);

        while(!q.isEmpty()) {
            int now = q.poll();
            int[] arr = {now + 1, now - 1, now * 2};
            for(int next : arr) {
                if(next < 0 || next > 200000) {
                    continue;
                }
                if(visited[next] == 0) {
                    visited[next] = visited[now] + 1;
                    q.add(next);
                }
            }
        }

        System.out.println(visited[k] - 1);
    }
}
