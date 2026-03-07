package com.fiddich.test.solveac.class3;

import java.util.*;

public class BOJ11286 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> {
            if(Math.abs(i1) == Math.abs(i2)) {
                return i1 - i2;
            }
            return Math.abs(i1) - Math.abs(i2);
        });
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if(num == 0) {
                if(pq.isEmpty()) {
                    sb.append(0).append("\n");
                }
                else {
                    sb.append(pq.poll()).append("\n");
                }
            }
            else {
                pq.add(num);
            }
        }

        System.out.println(sb);
    }
}
