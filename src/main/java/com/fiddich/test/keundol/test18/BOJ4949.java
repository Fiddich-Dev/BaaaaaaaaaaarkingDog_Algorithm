package com.fiddich.test.keundol.test18;

import java.util.*;

public class BOJ4949 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            String s = sc.nextLine();
            if(s.equals(".")) {
                break;
            }
            solve(s);
        }

    }

    static void solve(String s) {
        Stack<Character> stk = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == '(' || c == '[') {
                stk.push(c);
            }
            else if(c == ')') {
                if(!stk.isEmpty() && stk.peek() == '(') {
                    stk.pop();
                    continue;
                }
                System.out.println("no");
                return;
            }
            else if(c == ']') {
                if(!stk.isEmpty() && stk.peek() == '[') {
                    stk.pop();
                    continue;
                }
                System.out.println("no");
                return;
            }
        }

        if(stk.isEmpty()) {
            System.out.println("yes");
            return;
        }
        System.out.println("no");
    }
}
