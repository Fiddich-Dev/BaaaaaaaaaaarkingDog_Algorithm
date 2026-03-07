package com.fiddich.test.keundol.test26;

import java.util.*;

public class BOJ16637 {

    static int n;
    static int[] num;
    static char[] oper;
    static int ret = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        num = new int[n/2 + 1];
        oper = new char[n/2];

        String s = sc.next();
        for(int i = 0; i < n; i++) {
            if(i % 2 == 0) {
                num[i/2] = s.charAt(i) - '0';
            }
            else {
                oper[i/2] = s.charAt(i);
            }
        }

        go(0, num[0]);

        System.out.println(ret);
    }

    static void go(int idx, int result) {
        if(idx == n/2) {
            ret = Math.max(ret, result);
            return;
        }

        // 앞에 먼저 더하기
        go(idx+1, calc(result, num[idx+1], oper[idx]));
        // 뒤에 먼저 더하기
        if(idx+2 < n/2 + 1) {
            int next = calc(num[idx + 1], num[idx + 2], oper[idx + 1]);
            go(idx + 2, calc(result, next, oper[idx]));
        }

    }

    static int calc(int num1, int num2, char oper) {
        if(oper == '+') {
            return num1 + num2;
        }
        else if(oper == '-') {
            return num1 - num2;
        }
        else {
            return num1 * num2;
        }
    }
}
