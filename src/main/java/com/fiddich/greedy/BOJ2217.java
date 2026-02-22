package com.fiddich.greedy;

import java.util.*;

public class BOJ2217 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++) {
            pq.add(sc.nextInt());
        }

        int ret = Integer.MIN_VALUE;

        while(!pq.isEmpty()) {
            int min = pq.peek();
            int weight = min * pq.size();
            ret = Math.max(ret, weight);
            pq.poll();
        }

        System.out.println(ret);
    }
}
