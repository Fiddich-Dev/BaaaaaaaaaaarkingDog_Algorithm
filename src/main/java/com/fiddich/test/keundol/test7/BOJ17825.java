package com.fiddich.test.keundol.test7;

import java.util.*;

public class BOJ17825 {

    static int[] a;
    static int ret = Integer.MIN_VALUE;
    static List<Integer>[] map = new ArrayList[100];
    static int[] pos = new int[4];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = new int[10];
        for(int i = 0; i < 10; i++) {
            a[i] = sc.nextInt();
        }
        for(int i = 0; i < 100; i++) {
            map[i] = new ArrayList<>();
        }
        for(int i = 0; i <= 40; i += 2) {
            map[i].add(i+2);
        }

        map[10].add(53);
        map[53].add(56);
        map[56].add(59);
        map[59].add(65);
        map[65].add(70);
        map[70].add(75);
        map[75].add(40);

        map[20].add(62);
        map[62].add(64);
        map[64].add(65);

        map[30].add(68);
        map[68].add(67);
        map[67].add(66);
        map[66].add(65);


        go(0, 0);

        System.out.println(ret);
    }

    static void go(int num, int score) {
        if(num == 10) {
            ret = Math.max(ret, score);
            return;
        }

        for(int i = 0; i < 4; i++) {
            if(canMove(i, a[num])) {
                // 이전 위치 저장
                int prev = pos[i];
                int next = nextPos(i, a[num]);
                pos[i] = next;
                int temp = next;
                if(temp == 42) {
                    temp = 0;
                }
                else if(temp > 40) {
                    temp %= 40;
                }
                score += temp;

                go(num+1, score);

                // 원복
                score -= temp;
                pos[i] = prev;
            }
        }

    }

    static int nextPos(int num, int dice) {
        int start = pos[num];
        int cur = start;

        if(start == 10 || start == 20 || start == 30) {
            cur = map[start].get(1);
        }
        else {
            cur = map[start].get(0);
        }

        if(cur == 42) {
            return 42;
        }

        for(int i = 1; i < dice; i++) {
            int next = map[cur].get(0);
            cur = next;

            if(cur == 42) {
                return 42;
            }
        }

        return cur;
    }

    static boolean canMove(int num, int dice) {
        if(pos[num] == 42) {
            return false;
        }

        int next = nextPos(num, dice);
        if(next == 42) {
            return true;
        }

        for(int i = 0; i < 4; i++) {
            if(i == num) {
                continue;
            }

            if(pos[i] == next) {
                return false;
            }
        }

        return true;
    }
}
