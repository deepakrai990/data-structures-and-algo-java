package com.scaler.core.java_1_beginner.intro_03_while_loop;

import java.util.Scanner;

/**
 * @created 26/07/22 12:59 PM
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Main1 {
    public static void main(String[] args) {
        // write your code here
        Scanner scn = new Scanner(System.in);
        // while-loop
		/*
		Q1 Print numbers from 1 to 10.
		-> 1 2 3 4 5 6 7 8 9 10
		*/

        // initilisation
        // int i = 1;
        // while(i <= 10) { // condition
        // 	System.out.println(i); // loop work
        // 	i = i + 1; // update
        // }

		/*
		Q1 Print numbers from 1 to N.
		N = 7
		-> 1 2 3 4 5 6 7
		*/
        // int n = scn.nextInt();
        // int i = 1;
        // while(i <= n) {
        // 	System.out.print(i + " ");
        // 	i = i + 1;
        // }


		/*
		Q3 Print odd numbers from 1 to N.
		Ex: N = 10
		-> 1 3 5 7 9
		*/
        // method 1
        // int n = scn.nextInt();
        // int i = 1;
        // while(i <= n) {
        // 	if(i % 2 != 0) {
        // 		System.out.println(i);
        // 	}
        // 	i = i + 1;
        // }
        // i = 1 2 3 4 5 6 7 8 9 10

        // method 2
        // int i = 1;
        // while(i <= n) {
        // 	System.out.println(i);
        // 	i = i + 2;
        // }

        // N = 10
        // iteration required in method 1 -> 10 iterations
        // iteration required in method 2 -> 5 iterations

        // method 2 is efficient


		/*
		Q4 Print even numbers from 1 to N.
		Ex: N = 10
		-> 2 4 6 8 10
		*/
        // int n = scn.nextInt();
        // method 1
        // int i = 1;
        // while(i <= n) {
        // 	if(i % 2 == 0) {
        // 		// i is even
        // 		System.out.println(i);
        // 	}
        // 	i = i + 1;
        // }

        // int i = 2;
        // while(i <= n) {
        // 	System.out.println(i);
        // 	i = i + 2;
        // }

		/*
		Q5 Print all numbers from N to 1.
		Ex: N = 10
		-> 10 9 8 7 6 5 4 3 2 1
		*/
        // int n = scn.nextInt();
        // while(n >= 1) {
        // 	System.out.println(n);
        // 	n = n - 1;
        // }

		/*
        Q6 Print numbers from 1 to N which are multiple of 4.
        Ex: N = 50
        -> 4 8 12 16 20 24 28 32 36 40 44 48
        */
        //  4 * i [i from 1 to N]
        //  smallest multiple is 4
        // int n = scn.nextInt();
        // int i = 4;
        // while(i <= n) {
        // 	System.out.println(i);
        // 	i = i + 4;
        // }

        // printing -> 4 * i
        // i is starting from i
        // i is updating by 1, i.e. i = i + 1
        // 4 * 1 = 4
        // 4 * 2 = 8
        // 4 * 3 = 12
        // .
        // .
        // .
        // .
        // 4 * 12 = 48
        // condition -> 4 * i <= n
        // int n = scn.nextInt();
        // int i = 1;
        // while(4 * i <= n) {
        // 	System.out.println(4 * i);
        // 	i = i + 1;
        // }


        // int n = scn.nextInt();
        // int i = 1;
        // while(i <= n) {
        // 	if(i % 4 == 0) {
        // 		System.out.println(i);
        // 	}
        // 	i = i + 1;
        // }

		/*
		Q7 Print numbers from 1 to N, which are perfect Square.
		N = 100
		-> 1 4 9 16 25 36 49 64 81 100
		*/
        // sqrt(10) = 3.xyz
        // that means 10 is perfect Square, because sqrt of 10 is not
        // integral numbers


        // sqrt(49) = 7
        // 49 is perfect square?


        // num = i * i
        // 1 = 1 * 1
        // 4 = 2 * 2
        // 9 = 3 * 3
        // 16 = 4 * 4
        // 25 = 5 * 5
        // 36 = 6 * 6
        // 49 = 7 * 7
        // 64 = 8 * 8
        // 81 = 9 * 9
        // 100 = 10 * 10

        int n = scn.nextInt();
        int i = 1;
        while(i * i <= n) {
            System.out.println(i * i);
            i = i + 1;
        }

        /**
        i <= 3 (n)
                i		condition	loop work  update
        1.	i = 1     true			done	i = 1 + 1 = 2
        2.  i = 2     true 			done	i = 2 + 1 = 3
        3.  i = 3     true			done	i = 3 + 1 = 4
        4.  i = 4     false -> discard this iteration -> loop will break

                total iteration is n
        **/
        int a = scn.nextInt();
        int b = scn.nextInt();
        int c = scn.nextInt();
        int d = scn.nextInt();

        if(a == 1) {
            System.out.println("january");
        }

        if(b == 6) {
            System.out.println("june");
        }
    }
}
