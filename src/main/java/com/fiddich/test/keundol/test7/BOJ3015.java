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
            int num = a[i];
            Pair cur = new Pair(num, 1);

            // 다음 사람이 키가 이전 사람보다 크거나 같을때
            while(!stk.isEmpty() && stk.peek().num <= num) {
                Pair p = stk.pop();
                ret += p.cnt;
                // 만약 키가 같으면
                if(p.num == num) {
                    cur.cnt += p.cnt;
                }
            }

            if(!stk.isEmpty()) {
                ret++;
            }
            stk.push(cur);
        }

        System.out.println(ret);
    }

    static class Pair {
        int num;
        int cnt;

        public Pair(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
}
