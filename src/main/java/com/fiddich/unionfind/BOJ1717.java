package com.fiddich.unionfind;

import java.util.*;

public class BOJ1717 {

    static int n, m;
    static int[] next;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        next = new int[n+1];
        Arrays.fill(next, -1);
        for(int i = 0; i < m; i++) {
            int cmd = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            // 합치기
            if(cmd == 0) {
                union(a, b);
            }
            // 같은 집합인지 확인하지
            else {
                isSameSet(a, b);
            }
        }
    }

    static void isSameSet(int a, int b) {
        a = find(a);
        b = find(b);
        // a, b
        if(a == b && a != -1) {
            System.out.println("YES");
            return;
        }
        System.out.println("NO");
        return;
    }

    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a == b) { // 같은 집합일때
            return false;
        }
        if(next[a] < next[b]) { // b의 깊이가 더 작을때
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

    static int find(int n) {
        if(next[n] < 0) {
            return n;
        }
        return next[n] = find(next[n]);
    }
}
