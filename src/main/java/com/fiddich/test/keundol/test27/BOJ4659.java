package com.fiddich.test.keundol.test27;

import java.util.*;

public class BOJ4659 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while(true) {
            String s = sc.next();
            if(s.equals("end")) {
                break;
            }

            sb.append("<").append(s).append("> ");
            if(isValid1(s) && isValid2(s) && isValid3(s)) {
                sb.append("is acceptable.");
            }
            else {
                sb.append("is not acceptable.");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static boolean isValid3(String s) {
        for(int i = 0; i <= s.length() - 2; i++) {
            if(s.charAt(i) != 'e' && s.charAt(i) != 'o' && s.charAt(i) == s.charAt(i+1)) {
                return false;
            }
        }
        return true;
    }

    static boolean isValid2(String s) {
        for(int i = 0; i <= s.length() - 3; i++) {
            int moCnt = 0;
            int jaCnt = 0;
            for(int j = 0; j < 3; j++) {
                if(isMo(s.charAt(i + j))) {
                    moCnt++;
                }
                else {
                    jaCnt++;
                }
            }

            if(moCnt == 3 || jaCnt == 3) {
                return false;
            }
        }
        return true;
    }

    static boolean isValid1(String s) {
        for(char c : s.toCharArray()) {
            if(isMo(c)) {
                return true;
            }
        }
        return false;
    }

    static boolean isMo(char c) {
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    }
}
