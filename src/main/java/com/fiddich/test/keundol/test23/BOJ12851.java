package com.fiddich.test.keundol.test23;

import java.util.*;

public class BOJ12851 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] visited = new int[200004];
        int[] cnt = new int[200004];
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n] = 1;
        cnt[n] = 1;

        while(!q.isEmpty()) {
            int now = q.poll();
            int[] temp = {now + 1, now - 1, now * 2};
            for(int next : temp) {
                if(next < 0 || next > 200000) {
                    continue;
                }
                if(visited[next] == 0) {
                    visited[next] = visited[now] + 1;
                    cnt[next] += cnt[now];
                    q.add(next);
                }
                else if(visited[next] == visited[now] + 1) {
                    cnt[next] += cnt[now];
                }
            }
        }

        System.out.println(visited[m] - 1);
        System.out.println(cnt[m]);

    }
}
