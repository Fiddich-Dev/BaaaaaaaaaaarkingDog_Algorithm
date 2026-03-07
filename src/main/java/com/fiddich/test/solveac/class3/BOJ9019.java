package com.fiddich.test.solveac.class3;

import java.util.*;

public class BOJ9019 {

    static int n, a, b;
    static String[] visited;
    static String[] arr = {"D", "S", "L", "R"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {

            a = sc.nextInt();
            b = sc.nextInt();

            bfs(a);

            System.out.println(visited[b]);
        }
    }

    static void bfs(int start) {
        visited = new String[10004];
        visited[start] = "";
        Queue<Integer> q = new LinkedList<>();
        q.add(a);

        while(!q.isEmpty()) {
            int now = q.poll();
            for(int i = 0; i < 4; i++) {
                int next;
                if(i == 0) {
                    next = (now * 2) % 10000;
                }
                else if(i == 1) {
                    if(now == 0) {
                        next = 9999;
                    }
                    else {
                        next = now - 1;
                    }
                }
                else if(i == 2) {
                    next = L(now);
                }
                else {
                    next = R(now);
                }

//                if(next < 0 || next >= 10000) {
//                    continue;
//                }

                if(visited[next] == null) {
                    visited[next] = visited[now] + arr[i];
                    q.add(next);
                }
            }
        }
    }

    static int R(int now) {
        int last = now % 10;
        now = now / 10 + last * 1000;
        return now;
    }

    static int L(int now) {
        int first = now / 1000;
        now = (now % 1000) * 10 + first;
        return now;
    }
}
