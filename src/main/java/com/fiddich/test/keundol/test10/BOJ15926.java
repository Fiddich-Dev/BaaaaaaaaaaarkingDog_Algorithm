package com.fiddich.test.keundol.test10;

import java.util.*;

public class BOJ15926 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        Stack<Integer> stk = new Stack<>();

        int ret = 0;
        stk.push(-1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stk.push(i);
            } else if (c == ')') {
                if(stk.size() > 1 && s.charAt(stk.peek()) == '(') {
                    stk.pop();
                    ret = Math.max(ret, i - stk.peek());
                }
                else {
                    stk.add(i);
                }
            }
        }

        System.out.println(ret);
    }
}
