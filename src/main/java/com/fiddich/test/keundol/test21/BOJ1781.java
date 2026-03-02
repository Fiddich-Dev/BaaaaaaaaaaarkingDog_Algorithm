package com.fiddich.test.keundol.test21;

import java.util.*;
import java.io.*;

public class BOJ1781 {

    static int n;
    static Pair[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        a = new Pair[n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(a, (p1, p2) -> {
            if(p1.deadLine == p2.deadLine) {
                return p2.reward - p1.reward;
            }
            return p1.deadLine - p2.deadLine;
        });

        int ret = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < n; i++) {
            int deadLine = a[i].deadLine;
            int reward = a[i].reward;
            if(pq.size() < deadLine) {
                pq.add(reward);
            }
            else {
                if(pq.peek() < reward) {
                    pq.poll();
                    pq.add(reward);
                }
            }
        }

        for(int i : pq) {
            ret += i;
        }

        System.out.println(ret);
    }

    static class Pair {
        int deadLine;
        int reward;

        public Pair(int deadLine, int reward) {
            this.deadLine = deadLine;
            this.reward = reward;
        }
    }
}
