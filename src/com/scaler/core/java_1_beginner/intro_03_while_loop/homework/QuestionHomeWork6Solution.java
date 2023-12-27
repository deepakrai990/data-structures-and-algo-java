package com.scaler.core.java_1_beginner.intro_03_while_loop.homework;

import java.util.Scanner;

/**
 * @created 26/07/22 3:10 PM
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QuestionHomeWork6Solution {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        long N = scn.nextLong();
        int M = scn.nextInt();
        while(M-- > 0) {
            int opr = scn.nextInt();
            long amt = scn.nextLong();
            if(opr == 1) {
                N = N + amt;
                System.out.println(N);
            }
            else {
                if(amt > N) {
                    System.out.println("Insufficient Funds");
                }
                else {
                    N = N - amt;
                    System.out.println(N);
                }
            }
        }
    }
}
