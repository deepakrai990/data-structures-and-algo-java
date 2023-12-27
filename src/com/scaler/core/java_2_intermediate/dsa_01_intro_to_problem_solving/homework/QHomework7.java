package com.scaler.core.java_2_intermediate.dsa_01_intro_to_problem_solving.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @created 19/09/22 4:14 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QHomework7 {
    /**
     * Q7. Find Armstrong Numbers
     *
     * Problem Description
     * You are given an integer A. You need to print all the Armstrong Numbers between 1 to A.
     *
     * If sum of cubes of each digit of the number is equal to the number itself, then the number is called
     * an Armstrong number.
     *
     * For example, 153 = ( 1 * 1 * 1 ) + ( 5 * 5 * 5 ) + ( 3 * 3 * 3 ).
     *
     *
     *
     * Problem Constraints
     * 1 <= N <= 500
     *
     *
     *
     * Input Format
     * First and only argument is an integer A.
     *
     *
     *
     * Output Format
     * Return an integer array of all the Armstrong numbers in range [1,A].
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  5
     * Input 2:
     *
     *  200
     *
     *
     * Example Output
     * Output 1:
     *
     * 1
     * Output 2:
     *
     * [1, 153]
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     * 1 is an armstrong number.
     * Explanation 2:
     *
     * 1 and 153 are armstrong number under 200.
     * **/
    private static ArrayList<Integer> solve(int A) {
        ArrayList<Integer> totalArmstrong = new ArrayList<>();
        for(int i = 1; i <= A; i++) {
            if(isArmstrong(i)) {
                totalArmstrong.add(i);
            }
        }
        return totalArmstrong;
    }

    private static boolean isArmstrong(int n) {
        int m = n;
        int sum = 0;
        while (n > 0) {
            int rem = n % 10;
            sum = sum + (int) Math.pow(rem, 3);
            n /= 10;
        }
        if(sum == m) {
            return true;
        }
        return false;
    }
    /**
     * Scaler Solution
     * Approach
     * Given range is very small so we can iterate for each number in range and check whether it is armstrong or not.
     *
     * For each number in range we can find sum of cube of its digits and can check whether it is armstrong or not.
     *
     * Time Complexity : O(A)
     * Space Complexity : O(1)
     * **/
    private static ArrayList<Integer> solve1(int A) {
        ArrayList < Integer > ans = new ArrayList < Integer > ();
        for(int i = 1 ; i <= A ; i++){
            int temp = i, sum = 0;
            while(temp > 0){
                int dig = temp % 10;
                sum += (dig * dig * dig);
                temp /= 10;
            }
            if(sum == i){
                ans.add(i);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int A = 200;
        List<Integer> resutls = solve(A);
        System.out.println("Results [" + Arrays.toString(resutls.stream().mapToInt(Integer::intValue).toArray())
                + "]");
        resutls = solve1(A);
        System.out.println("Results [" + Arrays.toString(resutls.stream().mapToInt(Integer::intValue).toArray())
                + "]");
    }
}
