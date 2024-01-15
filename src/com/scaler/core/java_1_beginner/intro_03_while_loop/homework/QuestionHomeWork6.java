package com.scaler.core.java_1_beginner.intro_03_while_loop.homework;

import java.util.Scanner;

/**
 * @created 26/07/22 2:54 PM
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QuestionHomeWork6 {
    /**
     * Problem Description
     *
     * You are given a Bank account having N amount and you are asked to perfrom ADD(credit) and SUBTRACT(debit) operations.
     *
     * After each operation print the amount left in the Bank account. If the debit amount is greater than current balance print "Insufficient Funds"(without quotes) and the operation is skipped.
     *
     *
     *
     * Problem Constraints
     *
     * 1 <= N, X <= 1011
     * 1 <= Number of operations <= 105
     *
     *
     *
     * Input Format
     *
     * First line contains a single integer N denoting the balance in bank account.
     *
     * Second line contains a single integer M denoting the number of operations.
     *
     * Each of next M lines contains two space separated integers Type and Amount(X).
     *
     * If Type == 1, Perform ADD operation.
     * If Type == 2, Perform SUBTRACT operation.
     *
     *
     * Output Format
     *
     * Print Amount in the bank balance after each operation on a new line.
     *
     *
     *
     * Example Input
     *
     * 1000
     * 3
     * 1 500
     * 2 1400
     * 2 500
     *
     *
     * Example Output
     *
     * 1500
     * 100
     * Insufficient Funds
     *
     *
     * Example Explanation
     *
     * Initially bank balance is 1000.
     * First operation, ADD 500, bank balance becomes 1500, print it.
     * Second operation, SUBTRACT 1400, bank balance becomes 100, print it.
     * Third operation, SUBTRACT 500, print "Insufficient Funds".
     * **/
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long N = input.nextInt(); // bank amount
        int M = input.nextInt(); // Number of operations
        int i = 1;
        while(i <= M) {
            int type = input.nextInt(); // Operations Type
            long amount =  input.nextLong(); // amount for operations
            if(type == 1) {
                N = N + amount;
                System.out.println(N);
            } else if(type == 2) {
                if (N < amount) {
                    System.out.println("Insufficient Funds");
                } else {
                    N = N - amount;
                    System.out.println(N);
                }
            }
            i = i + 1;
        }
        input.close();
    }
}
