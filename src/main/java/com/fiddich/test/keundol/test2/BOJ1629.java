package com.fiddich.test.keundol.test2;

import java.util.*;

public class BOJ1629 {

    static int a, b, c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();


        System.out.println(go(b));
    }

    static long go(int now) {
        if(now == 0) {
            return 1;
        }
        if(now % 2 == 0) {
            long temp = go(now / 2) % c;
            return (temp * temp) % c;
        }
        else {
            long temp = go(now / 2) % c;
            return (((temp * temp) % c) * (a % c)) % c;
        }
    }
}
