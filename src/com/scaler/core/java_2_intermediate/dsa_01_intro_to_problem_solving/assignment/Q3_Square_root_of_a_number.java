package com.scaler.core.java_2_intermediate.dsa_01_intro_to_problem_solving.assignment;

/**
 * @created 19/09/22 3:24 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q3_Square_root_of_a_number {
    private static int solve(int A) {
        for(int i = 1; i * i <= A; i++) {
            if((A % i == 0) && (A / i == i)) {
                return i;
            }
        }
        return -1;
    }
    /**
     * Scaler Solution
     * **/
    private static int solve1(int A) {
        for(int i = 1; i <= 10000; i++){
            if(i * i == A){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int A = 1001;
        int result = solve(A);
        System.out.println("Result : " + result);
        result = solve1(A);
        System.out.println("Result : " + result);
    }
}
