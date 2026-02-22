package com.fiddich.test.keundol.test5;

import java.util.*;

public class BOJ2979 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int[] time = new int[104];

        for(int i = 0; i < 3; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            for(int j = s; j < e; j++) {
                time[j]++;
            }
        }

        int ret = 0;
        for(int i = 0; i < 104; i++) {
            if(time[i] == 1) {
                ret += a;
            }
            else if(time[i] == 2) {
                ret += 2 * b;
            }
            else if(time[i] == 3) {
                ret += 3 * c;
            }
        }

        System.out.println(ret);
    }
}
