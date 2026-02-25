package com.fiddich;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        byte a = (byte) 128;
        short b = (short) 32768;
        int c = Integer.MAX_VALUE;
        long d = 21474843648L;

        int decimalValue = 7;
        int binValue = 0b1000_0101;
        int octalValue = 077;
        int hexaValue = 0XFEFE;
        System.out.println("decimalValue = " + decimalValue);
        System.out.println("binValue = " + binValue);
        System.out.println("octalValue = " + octalValue);
        System.out.println("hexaValue = " + hexaValue);

        float num1 = 1.1F;
        float num2 = 1.1F;
        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);

        double num3 = 123.456;
        double num4 = 1.23456e2;
        System.out.println("num3 = " + num3);
        System.out.println("num4 = " + num4);

        printApproximate();
        printBoolean();
        printSize();
        printTextual();
        printEscape();
    }

    static void printApproximate() {
        float num1 = 0.1234567890123456789F;
        float num2 = 123.1234567890123456789F;
        double num3 = 0.12345678901234567890;
        double num4 = 123.12345678901234567890;
        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
        System.out.println("num3 = " + num3);
        System.out.println("num4 = " + num4);
    }

    static void printBoolean() {
        boolean b1 = false;
        System.out.println("b1 = " + b1);
    }

    static void printSize() {
// byte 타입
        System.out.println("byte type");
        System.out.println("\tMin: " + Byte.MIN_VALUE);
        System.out.println("\tMax: " + Byte.MAX_VALUE);

        // short 타입
        System.out.println("short type");
        System.out.println("\tMin: " + Short.MIN_VALUE);
        System.out.println("\tMax: " + Short.MAX_VALUE);

        // int 타입
        System.out.println("int type");
        System.out.println("\tMin: " + Integer.MIN_VALUE);
        System.out.println("\tMax: " + Integer.MAX_VALUE);

        // long 타입
        System.out.println("long type");
        System.out.println("\tMin: " + Long.MIN_VALUE);
        System.out.println("\tMax: " + Long.MAX_VALUE);

        // float 타입
        System.out.println("float type");
        System.out.println("\tMin: " + Float.MIN_VALUE);
        System.out.println("\tMax: " + Float.MAX_VALUE);

        // double 타입
        System.out.println("double type");
        System.out.println("\tMin: " + Double.MIN_VALUE);
        System.out.println("\tMax: " + Double.MAX_VALUE);

        // char 타입
        System.out.println("char type");
        System.out.println("\tMin: " + Character.MIN_VALUE);
        System.out.println("\tMax: " + Character.MAX_VALUE);

        System.out.println("boolean: " + Boolean.TRUE);
        System.out.println("boolean: " + Boolean.FALSE);
    }

    static void printTextual() {
        char c1 = 'A';
        char c2 = '\t';
        char c3 = '\uAC00';
        String s1 = "\uD604\uC218";
        String s2 = "dream";
        System.out.println("c1 = " + c1);
        System.out.println("c2 = " + c2);
        System.out.println("c3 = " + c3);
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
    }

    static void printEscape() {
        String str1 = "Hello\tWorld\n반갑습니다.";
        System.out.println("str1 = " + str1);
        String str2 = "HelloWorld\r12345";
        System.out.println("str2 = " + str2);
        String multiLineStr = """
                여러	줄	문자열을	 표현할	수	있습니다.
                주로	JSON	데이터	또는	<HTML>	태그를	표현할	때	사용합니다.
                탭 키와	",	'를	위해	탈출문자를	사용하지	않아도	됩니다.
                \\는	여전히	탈출문자로	사용해야	합니다.
                n(\\n)은	사용가능하지만	코드에서	줄바꿈	해도	됩니다.
                되도록이면	들여쓰기	레벨은	같게	하세요.
                """;
        System.out.println("multiLineStr = " + multiLineStr);

        int n = 0;
        n |= ~(1 << n);

    }
}

