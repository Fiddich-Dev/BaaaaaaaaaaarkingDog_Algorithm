package com.fiddich;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Pair p1 = new Pair(0, 0);
        Pair p2 = new Pair(2, 2);
        System.out.println(p1.equals(p2));
    }

    static class Pair {
        int y;
        int x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}

