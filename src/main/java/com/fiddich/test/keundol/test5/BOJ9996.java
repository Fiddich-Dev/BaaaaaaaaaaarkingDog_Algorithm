package com.fiddich.test.keundol.test5;

import java.util.*;

public class BOJ9996 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        int pos = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '*') {
                pos = i;
            }
        }

        String front = s.substring(0, pos);
        String back = s.substring(pos+1);

        for(int i = 0; i < n; i++) {
            String temp = sc.next();

            if(temp.length() < front.length() + back.length()) {
                System.out.println("NE");
                continue;
            }

            String f = temp.substring(0, front.length());
            String b = temp.substring(temp.length() - back.length());

            if(front.equals(f) && back.equals(b)) {
                System.out.println("DA");
            }
            else {
                System.out.println("NE");
            }
        }
    }
}
