package com.fiddich.unionfind;

import java.util.*;
import java.io.*;

public class BOJ7511 {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= t; i++) {
            sb.append("Scenario ").append(i).append(":").append("\n");
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] next = new int[n];
            Arrays.fill(next, -1);
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            for(int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b, next);
            }
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            for(int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if(find(a, next) == find(b, next)) {
                    sb.append(1).append("\n");
                }
                else {
                    sb.append(0).append("\n");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static boolean union(int a, int b, int[] next) {
        a = find(a, next);
        b = find(b, next);
        if(a == b) {
            return false;
        }
        if(next[a] < next[b]) { // b가 더 얕을때
            int temp = a;
            a = b;
            b = temp;
        }
        if(next[a] == next[b]) {
            next[a]--;
        }
        next[b] = a;
        return true;
    }

    static int find(int n, int[] next) {
        if(next[n] < 0) {
            return n;
        }
        return next[n] = find(next[n], next);
    }
}
