package com.fiddich.backtracking;

import java.util.*;

public class BOJ18809 {

    static int n, m, g, r;
    static int[][] a;
    static List<Pair> can = new ArrayList<>();
    static int[] used;
    static Info[][] visited;
    static Queue<Status> q;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int ret = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        g = sc.nextInt();
        r = sc.nextInt();
        a = new int[n][m]; // 0은 호수, 1은 배양액 X, 2는 배양액 O
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
                if(a[i][j] == 2) {
                    can.add(new Pair(i, j));
                }
            }
        }
        used = new int[can.size()];

        List<Pair> v = new ArrayList<>();
        combi(-1, v);


        System.out.println(ret);
    }

    // 배양액을 뿌를 수 있는 땅 중에 뿌릴데를 고름
    static void combi(int start, List<Pair> b) {
        if(b.size() == g + r) {
            List<Pair> v = new ArrayList<>();
            combiColor(-1, v, b);
            return;
        }
        for(int i = start+1; i < can.size(); i++) {
            b.add(can.get(i));
            combi(i, b);
            b.remove(b.size() - 1);
        }
    }

    static void combiColor(int start, List<Pair> b, List<Pair> origin) {
        if(b.size() == g) {
            visited = new Info[n][m];
            q = new LinkedList<>();

            for(Pair p : b) { // 초록
                visited[p.y][p.x] = new Info(1, 'G');
                q.add(new Status(p.y, p.x, 'G'));
            }
            for(Pair p : origin) { // 빨강
                if(visited[p.y][p.x] != null) {
                    continue;
                }
                visited[p.y][p.x] = new Info(1, 'R');
                q.add(new Status(p.y, p.x, 'R'));
            }

            bfs();

            return;
        }
        for(int i = start+1; i < origin.size(); i++) {
            b.add(origin.get(i));
            combiColor(i, b, origin);
            b.remove(b.size() - 1);
        }
    }

    static void bfs() {
        int cnt = 0;

        while(!q.isEmpty()) {
            Status s = q.poll();
            int y = s.y;
            int x = s.x;
            char color = s.color;

            if(visited[y][x].color == 'F') {
                continue;
            }

            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }
                // 퍼질 수 있는 경우
                if(visited[ny][nx] == null && a[ny][nx] != 0) {
                    visited[ny][nx] = new Info(visited[y][x].time + 1, color);
                    q.add(new Status(ny, nx, color));
                    continue;
                }

                if(visited[ny][nx] == null) {
                    continue;
                }

                // 꽃이 생길때, 표시해야함
                // 다른 색인데 time이 같을때
                if(visited[y][x].time + 1 == visited[ny][nx].time) {
                    if((visited[y][x].color == 'G' && visited[ny][nx].color == 'R') ||(visited[y][x].color == 'R' && visited[ny][nx].color == 'G')) {
                        visited[ny][nx].color = 'F';
//                        System.out.println(ny + " : " + nx);
                        cnt++;
                    }
                }
            }


        }

        ret = Math.max(ret, cnt);
    }

    static class Status {
        int y;
        int x;
        char color;

        public Status(int y, int x, char color) {
            this.y = y;
            this.x = x;
            this.color = color;
        }
    }

    static class Info {
        int time;
        char color;

        public Info(int time, char color) {
            this.time = time;
            this.color = color;
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

// 10 C 5 * 10 C 5 * 2500
