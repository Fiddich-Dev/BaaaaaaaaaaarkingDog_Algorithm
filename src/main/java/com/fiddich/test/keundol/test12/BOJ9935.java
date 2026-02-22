package com.fiddich.test.keundol.test12;

import java.util.*;

public class BOJ9935 {

    static String s, a;
    static Stack<Character> stk;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.next();
        a = sc.next();
        stk = new Stack<>();
        char trigger = a.charAt(a.length() - 1);
        for(char c : s.toCharArray()) {
            stk.push(c);

//            print();

            if(c != trigger) {
                continue;
            }
            if(canErase()) {
                erase();
            }


        }

        if(stk.isEmpty()) {
            System.out.println("FRULA");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for(char c : stk) {
            sb.append(c);
        }
        System.out.println(sb);
    }

    static void print() {
        StringBuilder sb = new StringBuilder();
        for(char c : stk) {
            sb.append(c);
        }
        System.out.println(sb);
    }

    static boolean canErase() {
        if(stk.size() < a.length()) {
            return false;
        }

        int n = a.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(stk.pop());
        }

        String temp = sb.reverse().toString();
        boolean ret = temp.equals(a);

        for(char c : temp.toCharArray()) {
            stk.push(c);
        }

        return ret;
    }

    static void erase() {
        int n = a.length();
        for(int i = 0; i < n; i++) {
            stk.pop();
        }
    }
}
