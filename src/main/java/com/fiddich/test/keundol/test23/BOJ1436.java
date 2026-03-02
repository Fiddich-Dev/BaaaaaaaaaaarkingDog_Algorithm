package com.fiddich.test.keundol.test23;

import java.util.*;

public class BOJ1436 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int cnt = 0;
        int now = 666;
        while(true) {
            if(is666(now)) {
                cnt++;
            }

            if(cnt == n) {
                break;
            }

            now++;
        }

        System.out.println(now);
    }

    static boolean is666(int num) {
        int r = 1;
        while(num / r > 0) {
            int temp = (num / r) % 1000;
            if(temp == 666) {
                return true;
            }
            r *= 10;
        }
        return false;
    }
}
