package com.fiddich.test.keundol.test24;

import java.util.*;

public class BOJ3190 {

    static int n, m, k;
    static int[][] a;
    static Queue<Move> q = new LinkedList<>();
    static Snake snake;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] snakeMap;

    public static void main(String[] args) {
        input();
        snakeMap = new int[n][n];
        snake = new Snake(1);
        snake.body.add(new Pair(0, 0));

        int cur = 0;
        while(true) {
            if(!q.isEmpty() && cur == q.peek().sec) {
                snake.dir = (snake.dir + q.poll().dir) % 4;
            }

            if(!move()) {
                cur++;
                break;
            }
            cur++;
        }

        System.out.println(cur);
    }

    static boolean move() {
        Pair head = snake.body.get(snake.body.size() - 1);
        int dir = snake.dir;

        int ny = head.y + dy[dir];
        int nx = head.x + dx[dir];
        // 못갈때
        if(ny < 0 || nx < 0 || ny >= n || nx >= n || snakeMap[ny][nx] == 1) {
            return false;
        }

        snakeMap[ny][nx] = 1;
        snake.body.add(new Pair(ny, nx));

        if(a[ny][nx] == 1) {
            a[ny][nx] = 0;
            return true;
        }

        Pair tail = snake.body.get(0);
        snakeMap[tail.y][tail.x] = 0;
        snake.body.remove(0);
        return true;
    }

    static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n][n];
        m = sc.nextInt();
        for(int i = 0; i < m; i++) {
            a[sc.nextInt() - 1][sc.nextInt() - 1] = 1;
        }
        k = sc.nextInt();
        for(int i = 0; i < k; i++) {
            int sec = sc.nextInt();
            char c = sc.next().charAt(0);
            int dir;
            if(c == 'D') {
                dir = 1;
            }
            else {
                dir = 3;
            }
            q.add(new Move(sec, dir));
        }
    }

    static class Snake {
        List<Pair> body = new ArrayList<>();
        int dir;

        public Snake(int dir) {
            this.dir = dir;
        }
    }

    static class Move {
        int sec;
        int dir;

        public Move(int sec, int dir) {
            this.sec = sec;
            this.dir = dir;
        }
    }

    static class Pair {
        int y;
        int x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
