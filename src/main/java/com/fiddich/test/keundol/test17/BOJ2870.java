package com.fiddich.test.keundol.test17;

import java.util.*;

public class BOJ2870 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> ret = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            String s = sc.next();

            String temp = "";
            for(char c : s.toCharArray()) {
                if(c - '0' >= 0 && c - '0' <= 9) {
                    temp += String.valueOf(c);
                }
                else {
                    if(!temp.isEmpty()) {
                        ret.add(convert(temp));
                        temp = "";
                    }
                }
            }

            if(!temp.isEmpty()) {
                ret.add(convert(temp));
            }
        }

        Collections.sort(ret, (s1, s2) -> {
            if(s1.length() == s2.length()) {
                return s1.compareTo(s2);
            }
            return s1.length() - s2.length();
        });

        for(String i : ret) {
            System.out.println(i);
        }

    }

    static String convert(String s) {
        int start = -1;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != '0') {
                start = i;
 ;               break;
            }
        }
        if(start == -1) {
            return "0";
        }
        return s.substring(start);
    }
}
