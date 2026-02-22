package com.fiddich.test.keundol.test15;

import java.util.*;

public class BOJ15662 {

    static int t, k;
    static int[][] a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        a = new int[t][8];
        for(int i = 0; i < t; i++) {
            String s = sc.next();
            for(int j = 0; j < 8; j++) {
                a[i][j] = s.charAt(j) - '0'; // 0은 N 1은 S
            }
        }
        k = sc.nextInt();
        for(int i = 0; i < k; i++) {
            int num = sc.nextInt() - 1;
            int dir = sc.nextInt(); // 1은 시계, -1은 반시계

            List<Pair> selected = select(num, dir);
            for(Pair p : selected) {
//                System.out.print(num + " ");
                roll(p.num, p.dir);
            }
//            System.out.println();
        }

        int cnt = 0;
        for(int i = 0; i < t; i++) {
            if(a[i][0] == 1) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static List<Pair> select(int num, int dir) {
        List<Pair> ret = new ArrayList<>();
        int nowDir = dir;
        for(int i = num+1; i < t; i++) {
            if(a[i-1][2] != a[i][6]) {
                nowDir *= -1;
                ret.add(new Pair(i, nowDir));
                continue;
            }
            break;
        }

        nowDir = dir;
        for(int i = num-1; i >= 0; i--) {
            if(a[i+1][6] != a[i][2]) {
                nowDir *= -1;
                ret.add(new Pair(i, nowDir));
                continue;
            }
            break;
        }
        ret.add(new Pair(num, dir));

        return ret;
    }

    static void roll(int num, int dir) {
        List<Integer> ns = new ArrayList<>();
        for(int i = 0; i < 8; i++) {
            ns.add(a[num][i]);
        }
        Collections.rotate(ns, dir);
        for(int i = 0; i < 8; i++) {
            a[num][i] = ns.get(i);
        }
    }

    static class Pair {
        int num;
        int dir;

        public Pair(int num, int dir) {
            this.num = num;
            this.dir = dir;
        }
    }
}
