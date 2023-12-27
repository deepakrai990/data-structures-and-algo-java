package com.scaler.core.java_1_beginner.intro_01_input_and_output;

import java.util.Scanner;

/**
 * @created 23/07/22 3:46 PM
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class LiveClassMain {
    public static void main(String[] args) {
        // Write your code here

        // : -> colon
        // ; -> semicolon
        // result is Number
        // System.out.print(10 + 30);
        // printing -> Text
        // System.out.print("10");
        // System.out.print("Hello");
        // text is concatenate with number
        // System.out.print("Hello" + 10);
        // System.out.print("Hello " + "World");

        // print -> decimal number
        // System.out.print(1.22232);

        // text + Number
        // System.out.print("Hello " + 10);

        // text + Number + Number
        // System.out.print("Hello" + 10 + 20);
        // "Hello" + 10 -> Hello10
        // "Hello10" + 20 -> Hello1020

        // Text + text
        // System.out.print("Hello " + World); -> Error
        // System.out.print("Hello " + "World");

        // Text + Number + Text
        // System.out.print("Hello " + 10 + " World");
        // "Hello " + 10 -> "Hello 10"
        // "Hello 10" + " World" -> "Hello 10 World"

        // System.out.print("Hello " + 10 + 20 + " World");

        // Number + Text
        // System.out.print(10 + " World");
        // number + text -> text

        // Number + text  + Number
        // System.out.print(10 + " World " + 20);
        // 10 + " World" -> "10 World"
        // "10 World" + 20 ->  "10 World 20"

        // Number + Number + Text + Number
        // System.out.print(10 + 20 + " Hello " + 50);
        // execution start from left to right
        // 10 + 20 -> 30
        // 30 + " Hello " -> "30 Hello "
        // "30 Hello " + 50 -> "30 Hello 50"

        // primer -> do it with your interest, not necessary
        // System.out.print("Hello " + 1.223);

        //print and println
        // println -> print line OR write \n inside string
        // System.out.println("Name : Shreesh");
        // System.out.print("Age : 50");
        // System.out.println("Hello");

        // Data Types
        // int x;
        // x = 10;
        // System.out.println("Integer : " + x);
        // // "Integer : " + 10 -> "Integer : 10"
        // long l = 1000000000000l; // we can use Capital L or l
        // System.out.println("Long : " + l);
        // float f = 1.23f; // also we can use capital F or f
        // System.out.println("Float : " + f);
        // double d = 2.2323232323232;
        // System.out.println("Double : " + d);
        // boolean b = false;
        // System.out.println("Boolean : " + b);
        // System.out.println(10000000000000000000000000000l);
        // long a = 100000000000000000l;
        // long a = 100;
        // System.out.println(a);

        // How we can take input from user
        // 1. Create a tool
        // Scanner scn = new Scanner(System.in);
        // scn -> it is variable Name
        // System.out.println("Input from User");

        // take Integer input
        // int x;
        // x = scn.nextInt();
        // System.out.println(x);

        // int y = scn.nextInt();
        // System.out.println(y);


        // int x = scn.nextInt();
        // System.out.println(x);


        // long l1;
        // l1 = scn.nextLong();
        // System.out.println(l1);

        // long l2 = scn.nextLong();
        // System.out.println(l2);

        // float f;
        // f = scn.nextFloat();
        // System.out.println(f);

        // float f2 = scn.nextFloat();
        // System.out.println(f2);

        // double d;
        // d = scn.nextDouble();
        // System.out.println(d);

        // double d2 = scn.nextDouble();
        // System.out.println(d2);


        // Doubt
        long y;
        Scanner scn = new Scanner(System.in);
        y = scn.nextLong();
        System.out.println(y);
    }
}
