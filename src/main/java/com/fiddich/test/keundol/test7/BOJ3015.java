package com.fiddich.test.keundol.test7;

import java.util.*;

public class BOJ3015 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        long ret = 0;
        Stack<Pair> stk = new Stack<>();

        for(int i = 0; i < n; i++) {

            Pair cur = new Pair(i, 1);
            while(!stk.isEmpty() && a[stk.peek().idx] <= a[i]) {
                Pair p = stk.pop();
                ret += p.cnt;
                if(a[p.idx] == a[i]) {
                    cur.cnt += p.cnt;
                }
            }

            if(!stk.isEmpty()) {
                ret++;
            }
            stk.add(cur);
        }

        System.out.println(ret);

    }

    static class Pair {
        int idx;
        int cnt;

        public Pair(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }
    }
} // 더 키큰 사람이 나오면 확인필요 없음
