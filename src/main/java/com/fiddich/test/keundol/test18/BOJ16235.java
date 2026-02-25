package com.fiddich.test.keundol.test18;

import java.util.*;

public class BOJ16235 {

    static int n, m, k;
    static int[][] energy;
    static PriorityQueue<Integer>[][] trees;
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[][] add;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        add = new int[n][n];
        energy = new int[n][n];
        trees = new PriorityQueue[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                add[i][j] = sc.nextInt();
                energy[i][j] = 5;
                trees[i][j] = new PriorityQueue<>();
            }
        }

        for(int i = 0; i < m; i++) {
            int y = sc.nextInt() - 1;
            int x = sc.nextInt() - 1;
            int age = sc.nextInt();
            trees[y][x].add(age);
        }

        for(int i = 0; i < k; i++) {
            spring();
            fall();
            winter();
        }

        int ret = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                ret += trees[i][j].size();
            }
        }
        System.out.println(ret);

    }

    // 겨울
    static void winter() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                energy[i][j] += add[i][j];
            }
        }
    }

    // 가을
    static void fall() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int k : trees[i][j]) {
                    if(k % 5 == 0) {
                        for(int l = 0; l < 8; l++) {
                            int ny = i + dy[l];
                            int nx = j + dx[l];
                            if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
                                continue;
                            }
                            trees[ny][nx].add(1);
                        }
                    }
                }
            }
        }
    }

    // 봄 여름
    static void spring() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                List<Integer> next = new ArrayList<>();
                List<Integer> die = new ArrayList<>();
                while(!trees[i][j].isEmpty()) {
                    int now = trees[i][j].poll();
                    if(now <= energy[i][j]) {
                        energy[i][j] -= now;
                        next.add(now+1);
                    }
                    else {
                        die.add(now);
                    }
                }

                trees[i][j].addAll(next);
                for(int k : die) {
                    energy[i][j] += k/2;
                }
            }
        }
    }
}
