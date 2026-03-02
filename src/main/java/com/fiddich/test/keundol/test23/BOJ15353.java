package com.fiddich.test.keundol.test23;

import java.util.*;

public class BOJ15353 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();

        int l1 = s1.length();
        int l2 = s2.length();

        if(l1 < l2) {
            for(int i = 0; i < l2 - l1; i++) {
                s1 = "0" + s1;
            }
        }
        else {
            for(int i = 0; i < l1 - l2; i++) {
                s2 = "0" + s2;
            }
        }

        System.out.println(add(s1, s2));
    }

    static String add(String s1, String s2) {
        String ret = "";
        int l = s1.length();

        boolean isTen = false;
        for(int i = l-1; i >= 0; i--) {
            int sum = (s1.charAt(i) - '0') + (s2.charAt(i) - '0');
            if(isTen) {
                sum++;
            }

            ret = String.valueOf(sum % 10) + ret;
            if(sum / 10 > 0) {
                isTen = true;
            }
            else {
                isTen = false;
            }
        }

        if(isTen) {
            ret = "1" + ret;
        }

        return ret;
    }
}
