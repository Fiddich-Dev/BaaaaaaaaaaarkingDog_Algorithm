package com.fiddich.test.keundol.test14;

import java.util.*;

public class BOJ15685 {

    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {1, 0, -1, 0};
    static int[][] a = new int[104][104];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int dir = sc.nextInt();
            int gen = sc.nextInt();

            print(y, x, dir, gen);
        }

        int ret = 0;
        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) {
                if(a[i][j] == 1 && a[i+1][j] == 1 && a[i][j+1] == 1 && a[i+1][j+1] == 1) {
                    ret++;
                }
            }
        }

        System.out.println(ret);
    }

    static void print(int y, int x, int dir, int gen) {
        List<Integer> prev = new ArrayList<>();
        a[y][x] = 1;
        prev.add(dir);
        y += dy[dir];
        x += dx[dir];
        a[y][x] = 1;
        for(int i = 1; i <= gen; i++) {
            List<Integer> next = nextDir(prev);
            for(int nDir : next) {
                y += dy[nDir];
                x += dx[nDir];
                a[y][x] = 1;
                prev.add(nDir);
            }
        }
    }

    static List<Integer> nextDir(List<Integer> prev) {
        List<Integer> ret = new ArrayList<>();
        for(int i = prev.size() - 1; i >= 0; i--) {
            int nDir = (prev.get(i) + 1) % 4;
            ret.add(nDir);
        }
        return ret;
    }
}
