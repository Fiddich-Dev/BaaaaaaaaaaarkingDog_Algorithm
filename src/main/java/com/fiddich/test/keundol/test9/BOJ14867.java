package com.fiddich.test.keundol.test9;

import java.util.*;

public class BOJ14867 {

    static Map<Long, Integer> visited = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long initA = sc.nextLong();
        long initB = sc.nextLong();
        long targetA = sc.nextLong();
        long targetB = sc.nextLong();


        Queue<Long> q = new LinkedList<>();
        q.add(0L);
        visited.put(0L, 1);

        while(!q.isEmpty()) {
            Long l = q.poll();
            long a = l % 1000000;
            long b = l / 1000000;
            int now = visited.get(l);

            for(int i = 0; i < 6; i++) {
                long na;
                long nb;
                if(i == 0) {
                    na = initA;
                    nb = b;
                }
                else if(i == 1) {
                    na = a;
                    nb = initB;
                }
                else if(i == 2) {
                    na = 0;
                    nb = b;
                }
                else if(i == 3) {
                    na = a;
                    nb = 0;
                }
                else if(i == 4) { // b -> a
                    long temp1 = initA - a; // a의 빈 공간
                    long temp2 = b; // b의 양
                    long temp = Math.min(temp1, temp2);
                    na = a + temp;
                    nb = b - temp;
                }
                else {
                    long temp1 = a;
                    long temp2 = initB - b;
                    long temp = Math.min(temp1, temp2);
                    na = a - temp;
                    nb = b + temp;
                }

                if(visited.get(nb * 1000000 + na) == null) {
                    q.add(nb * 1000000 + na);
                    visited.put(nb * 1000000 + na, visited.get(b * 1000000 + a) + 1);
                }
            }
        }
        int ret = visited.getOrDefault(targetB * 1000000 + targetA, 0);
        System.out.println(ret - 1);

    }
}

