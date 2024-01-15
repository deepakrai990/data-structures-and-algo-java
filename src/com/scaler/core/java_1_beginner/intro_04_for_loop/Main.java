package com.scaler.core.java_1_beginner.intro_04_for_loop;

import java.util.Scanner;

/**
 * @created 28/07/22 7:44 am
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Main {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);

		/*
		// Prime
		int n = scn.nextInt();
		int countFactor = 0;

		// n = 24 -> 1 2 3 4 6 8 12 24
		// keyword = break -> stop the iteration for current loop(just outer loop) and
		// start execution after the loop.

		for(int i = 1; i <= n; i++) {
			if(countFactor == 3) {
				break;
			}

			if(n % i == 0) {
				countFactor++;
			}
		}

		if(countFactor == 1) {
			System.out.println("Neither prime nor composite");
		} else if(countFactor == 2) {
			System.out.println("Prime");
		} else {
			System.out.println("Composite");
		}
		*/

        // int i = 1;
        // if condition is not written -> it consider it as true

        // for(; ;) {
        // 	if(i == 5) {
        // 		break;
        // 	}
        // 	System.out.println(i);
        // 	i = i + 1;
        // }


        // for(; i <= 4; ){
        // 	System.out.println(i);
        // 	i = i + 1;
        // }


        // Q. Print all the number form 1 to 10, except 3 and 5.

        // i = 1, 2, 3

        // for(int i = 1; i <= 10; i++) {
        // 	if(i == 3 || i == 5) {
        // 		break;
        // 	}
        // 	System.out.print(i + " ");
        // }

        // we want to skip an iteration,
        // we can use continue keyword to skip a particular iteration

        // for(int i = 1; i <= 10; i++) {
        // 	if(i == 3 || i == 5) {
        // 		continue;
        // 		// skip this iteration
        // 	}
        // 	System.out.print(i + " ");
        // }


        // i = 1, 2, 3, 4 ...... 10
        // 1, 2, 4. .... 10

        // for(int i = 1; i <= 10; i++) {
        // 	if(i != 3 && i != 5) {
        // 		System.out.print(i + " ");
        // 	}
        // }


        // for(int i = 1; i <= 10; i++) {
        // 	if(i % 2 == 0) {
        // 		continue;
        // 	}
        // 	System.out.print(i + " ");
        // }


        double k = 0.5;
        for(k = 0.5; k < 3.0; k++) {
            System.out.println("Hello");
        }


        // i++ <===> i = i + 1;

        // i += 1 <===> i = i + 1
        // i -= 1 <===> i = i - 1
        // i *= 1 <===> i = i * 1
        // i /= 1 <===> i = i / 1


        // a += b <===> a = a + b
        // a -= b <===> a = a - b
        // a *= b <===> a = a * b
        // a /= b <===> a = a / b
        scn.close();
    }
}
