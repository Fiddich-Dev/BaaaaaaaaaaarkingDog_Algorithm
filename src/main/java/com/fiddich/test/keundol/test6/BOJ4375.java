package com.fiddich.test.keundol.test6;

import java.util.*;

public class BOJ4375 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            int ret = solve(n);
            System.out.println(ret);
        }
    }

    static int solve(int n) {
        int now = 0;
        int prev = 0;
        while(true) {
            now++;
            int temp = (((prev % n) * (10 % n)) % n + 1) % n;
            if(temp == 0) {
                break;
            }

            prev = temp;
        }
        return now;
    }
}
