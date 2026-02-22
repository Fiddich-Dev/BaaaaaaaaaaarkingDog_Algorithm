package com.fiddich.test.keundol.test14;

import java.util.*;

public class BOJ1094 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int sum = 64;
        pq.add(64);

        while(sum != x) {
            int min = pq.poll();
            sum -= min;
            int half = min / 2;

            if(half + sum >= x) {
                pq.add(half);
                sum += half;
            }
            else {
                pq.add(half);
                pq.add(half);
                sum += min;
            }
        }

        System.out.println(pq.size());
    }

}
