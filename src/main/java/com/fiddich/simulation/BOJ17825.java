package com.fiddich.simulation;

import java.util.*;

public class BOJ17825 {

    static int[] dice = new int[10];
    static List<Integer>[] map = new ArrayList[40];
    static int[] score = {0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 13, 16, 19, 25, 30, 35, 22, 24, 28, 27, 26};
    static int[] horses = new int[4];
    static int total = 0;
    static int ret = 0;


    public static void main(String[] args) {
        for(int i = 0; i < 40; i++) {
            map[i] = new ArrayList<>();
        }

        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 10; i++) {
            dice[i] = sc.nextInt();
        }
        fillMap();

        go(0);

        System.out.println(ret);
    }

    static void go(int num) {
        if(num == 10) {
            ret = Math.max(ret, total);
            return;
        }
        for(int i = 0; i < 4; i++) {
            if(!canMove(i, dice[num])) {
                continue;
            }

            int prev = horses[i];

            move(i, dice[num]);
            if(horses[i] != 100) {
                total += score[horses[i]];
            }


            go(num + 1);

            if(horses[i] != 100) {
                total -= score[horses[i]];
            }
            horses[i] = prev;
        }
    }

    static void move(int idx, int dis) {
        int now = horses[idx];
        int next = map[now].get(map[now].size() - 1);
        now = next;

        if(now == 100) {
            horses[idx] = now;
            return;
        }

        for(int i = 1; i < dis; i++) {
            next = map[now].get(0);
            now = next;
            // 목적지 도착
            if(now == 100) {
                break;
            }
        }
        horses[idx] = now;
    }

    static boolean canMove(int idx, int dis) {
        int now = horses[idx];
        // 도착지에 있지 않기
        if(now == 100) {
            return false;
        }

        // 목적지에 다른말이 없기
        int prev = horses[idx];
        move(idx, dis);
        int goal = horses[idx];

        for(int i = 0; i < 4; i++) {
            if(i == idx) {
                continue;
            }
            if(horses[i] != 100 && goal == horses[i]) {
                horses[idx] = prev;
                return false;
            }
        }
        horses[idx] = prev;
        return true;
    }

    static void fillMap() {
        for(int i = 0; i < 20; i++) {
            map[i].add(i+1);
        }
        map[5].add(21);
        map[10].add(27);
        map[15].add(29);
        // 도착지를 100으로
        map[20].add(100);

        for(int i = 21; i < 26; i++) {
            map[i].add(i+1);
        }
        map[26].add(20);

        map[27].add(28);
        map[28].add(24);
        map[29].add(30);
        map[30].add(31);
        map[31].add(24);
    }
}

