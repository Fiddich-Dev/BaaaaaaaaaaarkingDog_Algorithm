package com.fiddich;

import java.util.*;

public class Cast {

    public static void main(String[] args) {
        printCast1();
        printCharCast();
        printCast2();
        printToInt();
        printString();
    }

    static void printCast1() {
        byte a = 100;
        int b = a;
        byte c = (byte) b;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
    }

    static void printCharCast() {
        char a1 = 'A';
        char a2 = '가';
        int a3 = a1;
        double d1 = 56.789;
        short a4 = (short) a1;
        short a5 = (short) a2;
        System.out.println("a1 = " + (int) a1);
        System.out.println("a2 = " + (int) a2);
        System.out.println("a3 = " + a3);
        System.out.println("a4 = " + (char) a4);
        System.out.println("a5 = " + (char) a5);
    }

    static void printCast2() {
        int a = 1234567890;
        float b = a;
        System.out.println("b = " + b);

        double c = 3.6;
        int d = (int) c;
        System.out.println("c = " + c);

        int e = 1522;
        byte f = (byte) e;
        System.out.println("f = " + f);
    }

    static void operCast() {
        byte a = 10;
        byte b = 20;
        byte c = (byte) (a + b);
        System.out.println("c = " + c);
        byte d = 10 + 20;
        System.out.println("d = " + d);
        short e = 100 + 200;
        System.out.println("e = " + e);
        System.out.println(5/2);
        System.out.println(5/2.);
    }

    static void printToInt() {
        double a = -3.6;
        double b = -3.4;
        double c = 3.4;
        double d = 3.6;

        double[] values = {a, b, c, d};

        for (double v : values) {
            System.out.printf("%.1f\t%d\t\t%.1f\t\t%.1f%n",
                    v, Math.round(v), Math.ceil(v), Math.floor(v));
        }
    }

    static void printString() {
        String	s1	=	"Hello";
        String	s2	=	"World";
        System.out.println(s1	+	s2);
        int a1=3,	a2=5;
        System.out.println(s1	+	a1	+	a2);
        System.out.println(a1	+	a2	+	s1);
        System.out.println(s1	+	(a1	+	a2));
    }
}
