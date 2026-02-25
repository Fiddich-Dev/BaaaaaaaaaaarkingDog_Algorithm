package com.fiddich.test.keundol.test18;

import java.util.*;

public class BOJ13913 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] visited = new int[200004];
        int[] prev = new int[200004];
        Arrays.fill(prev, -1);
        Queue<Integer> q = new LinkedList<>();
        visited[n] = 1;
        q.add(n);

        while(!q.isEmpty()) {
            int now = q.poll();
            int[] temp = {now + 1, now - 1, now * 2};
            for(int next : temp) {
                if(next < 0 || next > 200002) {
                    continue;
                }
                if(visited[next] == 0) {
                    visited[next] = visited[now] + 1;
                    prev[next] = now;
                    q.add(next);
                }
            }
        }

        System.out.println(visited[m] - 1);

        List<Integer> ret = new ArrayList<>();
        int start = m;
        while(start != -1) {
            ret.add(start);
            start = prev[start];
        }

        Collections.reverse(ret);
        for(int i : ret) {
            System.out.print(i + " ");
        }
    }
}
