package com.scaler.core.java_1_beginner.intro_02_if_else_conditions;

import java.util.Scanner;

/**
 * @created 23/07/22 2:03 PM
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class LiveClassMain {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        // 1. How to take string as input
        // String str = scn.next();
        // String str = scn.nextLine();

        // System.out.println(str);

        // 2. Type casting
        // widening type casting -> automatically
        // int a = 1000;
        // long b = a;

        // narrow typecasting -> manually
        // long a = 10000000000000000l;
        // int b = (int)a;
        // System.out.println(b);

        // int a = 400000;
        // int b = 100000;
        // int c = a * b;
        // System.out.println(c);

        // long a = 100000000l;
        // int b = (int)a;
        // System.out.println(b);

        // long a = 400000;
        // long b = 100000;
        // int c = (int)(a * b);
        // System.out.println(c);

        // int a = 400000;
        // int b = 100000;
        // long c = (long)a * b;
        // // cast a variable into long for calculation
        // System.out.println(c);

        // relational operator
        // int a = 21;
        // int b = 16;
        // int c = 16;
        // int d = 28;

        // System.out.println(a >= b);
        // System.out.println(b == c);
        // System.out.println(b == a);
        // System.out.println(a <= c);
        // System.out.println(d != a);
        // System.out.println(d > a);
        // System.out.println(c >= b);
        // System.out.println(a < d);

        // if - else
        /*
        Ques : we have age of person, print  eligible if he/she can vote
        otherwise print not eligible
        */
        // int age = scn.nextInt();
        // if(age >= 18) {
        //     System.out.print("Elgible, great.... :)");
        // } else {
        //     System.out.print("Not Elgible, better luck for next year :(");
        // }

        /*
        Q2: Given two numbers print the max of them.
		Ex: 4, 7
		ans  => 7 is greater
        */
        // Not a correct code
        // int a = scn.nextInt();
        // int b = scn.nextInt();
        // if(a > b) {
        //     System.out.println(a + " (a) is maximum");
        // } else {
        //     System.out.println(b + " (b) is maximum");
        // }

        // to solve multiple condition -> if-elseif
        // if(a > b) {
        //     System.out.println(a + " (a) is maximum");
        // } else if(a < b) {
        //     System.out.println(b + " (b) is maximum");
        // } else {
        //     System.out.println("Both are equal");
        // }

        // Break till : 8: 51

        // int a = 6;
        // int b = 5;

        // System.out.println(a != 7);
        // System.out.println(b != 7);
        // System.out.println(true && true);

        // if((a!=7) && (b!=7)){
        //     System.out.println("true");
        // }


        // 10 / 3 = 3 (quotient)
        // 10 / 3 = 3.3333
        // 10 / 3 -> quotient -> 3, remainder -> 1
        // divident = divisor * quotient + remainder
        // 10 = 3 * 3 + 1;
        // 10(int) / 3(int) -> 3 (int) quotient

        // break is over
        /*
        Q3: Given two numbers pritn the min of them.
        Ex: 4, 7
        ans  => 4 is smaller than 7
        Ex: 6, 6
	    */
        // int a = scn.nextInt();
        // int b = scn.nextInt();
        // if(a < b) {
        //     System.out.println(a + " (a) is min");
        // } else if(a > b) {
        //     System.out.println(b + " (b) is min");
        // } else {
        //     System.out.println("Both are equal");
        // }

        /*
		Q4: Read the temperature(Fahrenheit) of a person and
		print if he has fever, optimum tem or
		below optimum temperature.

		[98.2, 98.9] => Person doesn't have fever

		Ex: 101.5 => Person has fever
		Ex: 96.9 => Person has a low temperature
        */
        // float temp = scn.nextFloat();
        // if(temp > 98.9f) {
        //     // range ->  98. 9 < temp < infinity
        //     System.out.println("Person has fever :(");
        // } else if(temp >= 98.2f){
        //     // range => 98.2 <= temp <= 98.9
        //     System.out.println("Person doesn't have fever :)");
        // } else {
        //     // range -> 0 <= temp < 98.2
        //     System.out.println("Cool, Person has low temperature");
        // }

        /*
        Q5: Read the SpO2 level of a person.
        Print if the person's oxygen level is
        - normal (95-100]
        - Slighly below normal [90 - 95]
        - Alarmingly below normal < 90

        ()-> parenthesis
        (a, b) -> from a to b, a and b are not included
        (9, 13) -> 10, 11, 12 , Integer
        [9, 13] -> 9, 10, 11, 12, 13
        [] -> square barcket


        // spO2 can be in decimal
        */
        // float spO2 = scn.nextFloat();
        // if(spO2 < 90) {
        //     // range->  0 <= spO2 < 90
        //     System.out.println("Alarmingly below normal, :(, :(");
        // } else if(spO2 <= 95) {
        //     // range-> 90 <= spO2 <= 95
        //     System.out.println("Slighly below normal, :(");
        // } else if(spO2 <= 100){
        //     // range-> 95 < spO2 <= 100
        //     System.out.println("normal, :)");
        // }

        /*
		Q6: Given a number. print true if it is divisible by 4.
	    */
        // int num = scn.nextInt();
        // if(num % 4 == 0) {
        //     System.out.println(true);
        // }

        /*
		Q7: Given a number check if it is odd or even.

		Ex: 19 => odd
		22 => even
	    */
        // int num = scn.nextInt();
        // if(num % 2 == 0) {
        //     // divisible by 2
        //     System.out.println("even number");
        // } else {
        //     // not divisible
        //     System.out.println("odd number");
        // }

        /*
        Q8[Amazon]: FizzBuzz
            Given a number, print "fizz" if it divisible by 3,
            print "buzz" if it is divisible by 5
            print "fizz-buzz" if it is divisible by both 3 and 5
	    */
        // int num = scn.nextInt();
        // incorrect code
        // if(num % 3 == 0) {
        //     System.out.println("fizz");
        // } else if(num % 5 == 0) {
        //     System.out.println("buzz");
        // } else {
        //     System.out.println("fizz-buzz");
        // }

        // logical AND (&&)
        // if(num % 3 == 0 && num % 5 == 0) {
        //     System.out.println("fizz-buzz");
        // } else if(num % 3 == 0) {
        //     System.out.println("fizz");
        // } else if(num % 5 == 0) {
        //     System.out.println("buzz");
        // }


        // doubt session
        // without logical operator we can do it
        // boolean flag = false;
        // if(num % 3 == 0) {
        //     flag = true;
        //     System.out.print("fizz");
        // }
        // if(num % 5 == 0) {
        //     if(flag == true) {
        //         System.out.print("-buzz");
        //     } else {
        //         System.out.print("buzz");
        //     }
        // }

        int a=22;
        int b = 51;
        int c = 2;
        int d =7;
        int e = 73;
        double avg = (a+b+c+d+e)/5.0;
        System.out.printf("%.2f", avg);
    }
}
