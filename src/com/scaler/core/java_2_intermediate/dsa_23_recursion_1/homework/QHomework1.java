package com.scaler.core.java_2_intermediate.dsa_23_recursion_1.homework;

import java.util.Scanner;

/**
 * @created 11/10/22 8:03 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QHomework1 {
    private static void reverse(String str, int pos){
        if (pos == 0){
            System.out.print(str.charAt(pos));
            return;
        }
        System.out.print(str.charAt(pos));
        reverse(str, pos - 1);
    }

    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        reverse(str, str.length() - 1);
    }
}
