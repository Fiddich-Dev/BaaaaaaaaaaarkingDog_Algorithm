package com.fiddich.test.keundol.test3;

import java.util.*;

public class BOJ19942 {

    static int n;
    static int mp, mf, ms, mv;
    static Info[] a;
    static int ret = Integer.MAX_VALUE;
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        mp = sc.nextInt();
        mf = sc.nextInt();
        ms = sc.nextInt();
        mv = sc.nextInt();
        a = new Info[n];
        for(int i = 0; i < n; i++) {
            int p = sc.nextInt();
            int f = sc.nextInt();
            int s = sc.nextInt();
            int v = sc.nextInt();
            int price = sc.nextInt();
            a[i] = new Info(p, f, s, v, price);
        }

        Info info = new Info(0, 0, 0, 0, 0);
        List<Integer> list = new ArrayList<>();
        go(0, info, list);

        if(ret == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        System.out.println(ret);

        for(int i : result) {
            System.out.print(i + " ");
        }
    }


    static boolean isValid(Info info) {
        if(info.p >= mp && info.f >= mf && info.s >= ms && info.v >= mv) {
            return true;
        }
        return false;
    }

    static void go(int num, Info info, List<Integer> list) {
        if(isValid(info)) {
            if(info.price < ret) {
                ret = info.price;
                result = new ArrayList<>(list);
            }
            return;
        }

        if(num == n) {
            return;
        }

        info.p += a[num].p;
        info.f += a[num].f;
        info.s += a[num].s;
        info.v += a[num].v;
        info.price += a[num].price;
        list.add(num + 1);

        go(num + 1, info, list);

        list.remove(list.size() - 1);
        info.p -= a[num].p;
        info.f -= a[num].f;
        info.s -= a[num].s;
        info.v -= a[num].v;
        info.price -= a[num].price;

        go(num + 1, info, list);
    }

    static class Info {
        int p;
        int f;
        int s;
        int v;
        int price;

        public Info(int p, int f, int s, int v, int price) {
            this.p = p;
            this.f = f;
            this.s = s;
            this.v = v;
            this.price = price;
        }
    }
}
