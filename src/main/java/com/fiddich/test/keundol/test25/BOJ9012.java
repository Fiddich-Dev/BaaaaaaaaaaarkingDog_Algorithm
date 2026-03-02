package com.fiddich.test.keundol.test25;

import java.util.*;

public class BOJ9012 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            String s = sc.next();
            solve(s);
        }
    }

    static void solve(String s) {
        Stack<Character> stk = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == '(') {
                stk.push(c);
            }
            else if(c == ')') {
                if(stk.isEmpty() || stk.peek() != '(') {
                    System.out.println("NO");
                    return;
                }
                stk.pop();
            }
        }

        if(stk.isEmpty()) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
}
