package com.fiddich.test.keundol.test4;

import java.util.*;

public class BOJ10988 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String reverse = "";
        for(int i = s.length() - 1; i >= 0; i--) {
            reverse += String.valueOf(s.charAt(i));
        }

        if(s.equals(reverse)) {
            System.out.println(1);
            return;
        }
        System.out.println(0);
    }
}
