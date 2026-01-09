package com.fiddich.simulation;

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
            int x = sc.nextInt(); // x의 배수인 원판들
            int d = sc.nextInt(); // 회전방향 0은 시계, 1은 반시계
            int k = sc.nextInt(); // k칸 회전
            roll(x, d, k);

//            System.out.println("회전 후");
//            for(int j = 0; j < n; j++) {
//                for(int l = 0; l < m; l++) {
//                    System.out.print(a[j][l] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();

            check();

//            System.out.println("삭제 후");
//            for(int j = 0; j < n; j++) {
//                for(int l = 0; l < m; l++) {
//                    System.out.print(a[j][l] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();

        }

        int ret = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                ret += a[i][j];
            }
        }

        System.out.println(ret);

    }
    // 가장 안쪽 원판은 양쪽, 바깥쪽 확인
    // 가장 바깥쪽 원판은 양쪽, 안쪽 확인
    // 그외는 양쪽, 안쪽, 바깥쪽 확인

    static void roll(int x, int d, int k) {
        for(int i = x-1; i < n; i += x) {
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j < m; j++) {
                temp.add(a[i][j]);
            }

            if(d == 0) {
                Collections.rotate(temp, k);
            }
            else {
                Collections.rotate(temp, k * -1);
            }

            for(int j = 0; j < m; j++) {
                a[i][j] = temp.get(j);
            }
        }
    }

    static void check() { // 0이면 지운거

        int[][] visited = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(a[i][j] == 0) {
                    continue;
                }

                int value = a[i][j];
                boolean found = false;

                for(int k = 0; k < 4; k++) {
                    int ny = i + dy[k];
                    int nx = j + dx[k];
                    if(ny < 0 || ny >= n) {
                        continue;
                    }
                    if(nx < 0) {
                        nx = m-1;
                    }
                    if(nx >= m) {
                        nx = 0;
                    }

                    if(value == a[ny][nx]) {
                        visited[ny][nx] = 1;
                        found = true;
                    }
                    if(found) {
                        visited[i][j] = 1;
                    }
                }
            }
        }

        boolean isChange = false;
        int sum = 0;
        int cnt = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(visited[i][j] == 1) {
                    a[i][j] = 0;
                    isChange = true;
                }

                if(a[i][j] != 0) {
                    sum += a[i][j];
                    cnt++;
                }
            }
        }

        if(cnt != 0 && !isChange) {
            int avg = sum / cnt;
            boolean have = sum % cnt != 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(a[i][j] == 0) {
                        continue;
                    }

                    if(have) { // 나머지가 있을때
                        if(a[i][j] == avg) {
                            a[i][j]++;
                        }
                        else if(a[i][j] < avg) {
                            a[i][j]++;
                        }
                        else {
                            a[i][j]--;
                        }
                    }
                    else {
                        if(a[i][j] > avg) {
                            a[i][j]--;
                        }
                        else if(a[i][j] < avg) {
                            a[i][j]++;
                        }
                    }


                }
            }
        }
    }
}
