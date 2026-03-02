package com.fiddich.test.keundol.test21;

import java.util.*;

public class BOJ2852 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Info[] a = new Info[n+1];
        for(int i = 0 ; i < n; i++) {
            int team = sc.nextInt();
            String[] s = sc.next().split(":");
            int time = Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
            a[i] = new Info(team, time);
        }
        a[n] = new Info(1, 48 * 60);

        int time1 = 0;
        int time2 = 0;

        int score1 = 0;
        int score2 = 0;

        int now = 0;
        for(int i = 0; i <= n; i++) {
            Info info = a[i];
            int team = info.team;
            int time = info.time;

            if(score1 < score2) {
                time2 += time - now;
            }
            else if(score1 > score2) {
                time1 += time - now;
            }

            if(team == 1) {
                score1++;
            }
            else if(team == 2) {
                score2++;
            }
            now = time;
        }

        System.out.println(convert(time1));
        System.out.println(convert(time2));
    }

    static String convert(int time) {
        StringBuilder sb = new StringBuilder();
        int hour = time / 60;
        int minute = time % 60;
        if(hour >= 10) {
            sb.append(hour);
        }
        else {
            sb.append(0).append(hour);
        }

        sb.append(":");

        if(minute >= 10) {
            sb.append(minute);
        }
        else {
            sb.append(0).append(minute);
        }

        return sb.toString();
    }

    static class Info {
        int team;
        int time;

        public Info(int team, int time) {
            this.team = team;
            this.time = time;
        }
    }
}
