package com.fiddich.test.keundol.test22;

import java.util.*;

public class BOJ14890 {

    static int n, l;
    static int[][] a;
    static int ret = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        l = sc.nextInt();
        a = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        solve();
        rotate90();
        solve();

        System.out.println(ret);
    }

    static void rotate90() {
        int[][] ret = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                ret[j][n-1-i] = a[i][j];
            }
        }
        a = ret;
    }

    static void solve() {
        for(int i = 0; i < n; i++) {
            int[] visited = new int[n];
            for(int j = 0; j < n; j++) {
                if(j == n-1) {
                    ret++;
                    continue;
                }

                // 오르막일때
                if(a[i][j] + 1 == a[i][j+1]) {
                    if(!canUp(i, j, visited)) {
                        break;
                    }
                }
                // 내리막일떄
                else if(a[i][j] == a[i][j+1] + 1) {
                    if(!canDown(i, j, visited)) {
                        break;
                    }
                }
                else if(a[i][j] == a[i][j+1]) {
                    continue;
                }
                else {
                    break;
                }
            }
        }
    }

    static boolean canDown(int y, int x, int[] visited) {
        int h = a[y][x];
        for(int i = 1; i <= l; i++) {
            if(x+i >= n) {
                return false;
            }
            if(a[y][x+i] != h-1 || visited[x+i] == 1) {
                return false;
            }
        }

        for(int i = 1; i <= l; i++) {
            visited[x+i] = 1;
        }
        return true;
    }

    static boolean canUp(int y, int x, int[] visited) {
        int h = a[y][x];
        for(int i = 0; i < l; i++) {
            if(x-i < 0) {
                return false;
            }
            if(a[y][x - i] != h || visited[x - i] == 1) {
                return false;
            }
        }

        for(int i = 0; i < l; i++) {
            visited[x-i] = 1;
        }

        return true;
    }
}
