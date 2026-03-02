package com.fiddich.test.keundol.test20;

import java.util.*;
import java.io.*;

public class BOJ16434 {

    static int n, atk;
    static Room[] a;
    static long nowAtk;
    static long ret = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        atk = Integer.parseInt(st.nextToken());
        nowAtk = atk;
        a = new Room[n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = new Room(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        binarySearch(1L, (long) 1e18);

        System.out.println(ret);
    }

    static void binarySearch(long l, long r) {
        while(l <= r) {
            long mid = l + (r - l) / 2;
            nowAtk = atk;
            if(isValid(mid)) {
                ret = Math.min(ret, mid);
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
    }

    static boolean isValid(long maxHp) {
        long curHp = maxHp;
        for(int i = 0; i < n; i++) {
            if(a[i].t == 1) {
                curHp = monster(a[i], curHp);
            }
            else if(a[i].t == 2) {
                curHp = water(a[i], curHp, maxHp);
            }

            if(curHp <= 0) {
                return false;
            }
        }
        return true;
    }

    static long water(Room room, long curHp, long maxHp) {
        nowAtk += room.a;
        curHp = Math.min(maxHp, curHp + room.h);
        return curHp;
    }

    static long monster(Room room, long curHp) {
        int a = room.a;
        int h = room.h;

        long atkCnt = h / nowAtk;
        if(h % nowAtk != 0) {
            atkCnt++;
        }

        curHp -= (long) a * (atkCnt - 1);

        return curHp;
    }

    static class Room {
        int t;
        int a;
        int h;

        public Room(int t, int a, int h) {
            this.t = t;
            this.a = a;
            this.h = h;
        }
    }
}
