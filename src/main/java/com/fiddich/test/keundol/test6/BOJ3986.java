package com.fiddich.test.keundol.test6;

import java.util.*;

public class BOJ3986 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = 0;
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            String s = sc.next();
            if(isValid(s)) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for(char c : s.toCharArray()) {
            if(!stk.isEmpty() && stk.peek() == c) {
                stk.pop();
                continue;
            }

            stk.push(c);
        }

        return stk.isEmpty();
    }
}
