package com.fiddich.test.keundol.test11;

import java.util.*;

public class BOJ17822 {

    static int n, m, t;
    static int[][] a;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        t = sc.nextInt();
        a = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i < t; i++) {
            int x = sc.nextInt();
            int d = sc.nextInt();
            int k = sc.nextInt();

            roll(x, d, k);
            erase();
        }

        int ret = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                ret += a[i][j];
            }
        }

        System.out.println(ret);
    }

    static void erase() {
        int[][] visited = new int[n][m];
        boolean flag = false;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int cur = a[i][j];
                if(cur == 0) {
                    continue;
                }

                for(int k = 0; k < 4; k++) {
                    int ny = i + dy[k];
                    int nx = j + dx[k];
                    if(ny < 0 || ny >= n) {
                        continue;
                    }
                    if(nx < 0) {
                        nx += m;
                    }
                    else if(nx >= m) {
                        nx -= m;
                    }

                    if(a[ny][nx] == cur) {
                        visited[ny][nx] = 1;
                        visited[i][j] = 1;
                        flag = true;
                    }
                }
            }
        }

        int sum = 0;
        int cnt = 0;
        // 원판 지우기
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(a[i][j] != 0) {
                    sum += a[i][j];
                    cnt++;
                }

                if(visited[i][j] == 1) {
                    a[i][j] = 0;
                }
            }
        }
        if(!flag && cnt != 0) {
            int avg = sum / cnt;
            int temp = sum % cnt;

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(a[i][j] == 0) {
                        continue;
                    }

                    if(a[i][j] > avg) {
                        a[i][j]--;
                        continue;
                    }
                    if(a[i][j] < avg) {
                        a[i][j]++;
                        continue;
                    }
                    if(a[i][j] == avg && temp != 0) {
                        a[i][j]++;
                    }

                }
            }
        }
    }

    static void roll(int x, int d, int k) {
        for(int i = x; i <= n; i += x) {
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j < m; j++) {
                temp.add(a[i-1][j]);
            }
            if(d == 0) {
                Collections.rotate(temp, k);
            }
            else {
                Collections.rotate(temp, k * -1);
            }

            for(int j = 0; j < m; j++) {
                a[i-1][j] = temp.get(j);
            }
        }
    }

}
