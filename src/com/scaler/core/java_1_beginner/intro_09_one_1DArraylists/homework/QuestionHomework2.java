package com.scaler.core.java_1_beginner.intro_09_one_1DArraylists.homework;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @created 09/08/22 11:39 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QuestionHomework2 {
    /**
     * Q2. Uniquely Existing Elements
     *
     * Problem Description
     *
     * You are given an integer T (Number of test cases). For each test case, You are given an integer array A.
     *
     * You have to find all the values that are uniquely present in the array i.e, values having number
     * of occurrences = 1.
     *
     *
     *
     * Problem Constraints
     *
     * 1 <= T <= 10
     *
     * 1 <= |A| <= 103
     *
     * 0 <= A[i] <= 103
     *
     *
     *
     * Input Format
     *
     * First line consists of a single integer T.
     *
     * For each test case, on a separate line, first integer is |A| denoting the length of array, and then |A| integers
     * denote the array elements (all integers separated by single spaces).
     *
     *
     *
     * Output Format
     *
     * For each test case, print on a separate line, an integer array containing all such values in ascending order.
     *
     *
     *
     * Example Input
     *
     * Input 1:
     *
     *  2
     *  10 1 2 3 5 1 5 20 2 12 10
     *  5 3 2 1 0 0
     *
     * Input 2:
     *
     *  2
     *  2 1 1
     *  1 5
     *
     *
     *
     * Example Output
     *
     * Output 1:
     *
     *  3 10 12 20
     *  1 2 3
     *
     * Output 2:
     *
     *
     *  5
     *
     *
     *
     * Example Explanation
     *
     * Explanation 1:
     *
     *  For Test Case 1:
     *  Number of occurrences of 1 = 2
     *  Number of occurrences of 2 = 2
     *  Number of occurrences of 3 = 1
     *  Number of occurrences of 5 = 2
     *  Number of occurrences of 10 = 1
     *  Number of occurrences of 12 = 1
     *  Number of occurrences of 20 = 1
     *  Only 3, 10, 12 and 20 have number of occurrences = 1, i.e, they are uniquely present in the array.
     *
     *  For Test Case 2:
     *  Number of occurrences of 0 = 2
     *  Number of occurrences of 1 = 1
     *  Number of occurrences of 2 = 1
     *  Number of occurrences of 3 = 1
     *  Only 1, 2 and 3 have number of occurrences = 1, i.e, they are uniquely present in the array.
     *
     * Explanation 2:
     *
     *  For Test Case 1:
     *  Number of occurrences of 1 = 2
     *  There is no uniquely present value. So, an empty array is printed on a separate line.
     *
     *  For Test Case 2:
     *  Number of occurrences of 5 = 1
     *  5 is uniquely present in the array.
     * **/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i = 1; i <= T; i++) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int j = 0; j< n; j++) {
                arr[j] = in.nextInt();
            }

            Arrays.sort(arr);
            for(int j = 0; j < n; j++) {
                int element = arr[j];
                boolean isUnique = true;
                for(int k = 0; k < n; k++) {
                    isUnique = true;
                    if (j != k) {
                        if(element == arr[k]) {
                            isUnique = false;
                            break;
                        }
                    }
                }
                if(isUnique) {
                    System.out.print(element + " ");
                }
            }
            System.out.println();
        }
    }
}
