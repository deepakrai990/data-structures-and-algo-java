package com.scaler.core.java_1_beginner.intro_05_patterns1;

import java.util.Scanner;

/**
 * @created 02/08/22 8:08 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class PatterQuestion8HomeWork {
    /**
     * Print pattern
     *
     * *	*	*	*	*
     *  	*	*	*	*
     * 	    	*	*	*
     * 		    	*	*
     * 			    	*
     *
     * input n = 5
     *
     * **/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i ; j++) {
                System.out.print("\t");
            }
            for (int j = 0; j <= n - i; j++) {
                System.out.print("*\t");
            }
            System.out.println();
        }

        System.out.println("----------------Right down Mirror Star Pattern----------------");

        for (int i = n; i >= 1; i--)  {
            for (int j = n; j > i; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
