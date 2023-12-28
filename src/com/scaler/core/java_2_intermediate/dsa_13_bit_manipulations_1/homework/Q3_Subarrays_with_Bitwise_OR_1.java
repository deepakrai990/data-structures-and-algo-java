package com.scaler.core.java_2_intermediate.dsa_13_bit_manipulations_1.homework;

/**
 * @created 21/09/22 4:13 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q3_Subarrays_with_Bitwise_OR_1 {
    /**
     * Q3. Subarrays with Bitwise OR 1
     *
     * Problem Description
     * Given an array B of length A with elements 1 or 0. Find the number of subarrays with bitwise OR 1.
     *
     *
     * Problem Constraints
     * 1 <= A <= 105
     *
     *
     * Input Format
     * The first argument is a single integer A.
     * The second argument is an integer array B.
     *
     *
     * Output Format
     * Return the number of subarrays with bitwise array 1.
     *
     *
     * Example Input
     * Input 1:
     *  A = 3
     * B = [1, 0, 1]
     * Input 2:
     *  A = 2
     * B = [1, 0]
     *
     *
     * Example Output
     * Output 1:
     * 5
     * Output2:
     * 2
     *
     *
     * Example Explanation
     * Explanation 1:
     * The subarrays are :- [1], [0], [1], [1, 0], [0, 1], [1, 0, 1]
     * Except the subarray [0] all the other subarrays has a Bitwise OR = 1
     * Explanation 2:
     * The subarrays are :- [1], [0], [1, 0]
     * Except the subarray [0] all the other subarrays has a Bitwise OR = 1
     * **/
    private static long solve(int A, int[] B) {
        long count = 0;
        for(int i = 0; i < A; i++) {
            if(B[i] == 1) {
                count += (A - i);
            } else {
                for(int j = i+1; j < A; j++) {
                    if(B[j] == 1) {
                        count += (A - j);
                        break;
                    }
                }
            }
        }
        return count;
    }
    /**
     * Scaler Solution
     * Approach
     *
     * Hint 1
     * Since the operation is a bitwise OR any subarray with atleast one element as 1 will have bitwise or 1.
     * Well every subarray has a unique pair of left and right end indices.
     * Now for every index i in the array find in how many subarrays with bitwise OR 1, it is the right index of.
     * And add this value to ans.
     *
     * Solution Approach
     * Since the operation is a bitwise OR any subarray with atleast one element as 1 will have bitwise or 1.
     * Well every subarray has a unique pair of left and right end indices.
     * Now for every index i in the array find in how many subarrays with bitwise OR 1, it is the right index of.
     * And add this value to ans.
     *
     * We can find this by seaching how many valid left index is present if current index i is taken as right index.
     * If j is the first index that has B[j] = 1 to the left of i (including i), then index 1 to j all can be taken
     * as left index as there is atlest one 1 is the subarray.
     * so ans += j for that particular i.
     *
     * **/
    private static long solve1(int A, int[] B) {
        int last = 0;
        long ans = 0;
        for(int i = 0; i < A; i++){
            if(B[i] == 1) {
                last = i + 1;
            }
            ans += last;
        }
        return ans;
    }
    public static void main(String[] args) {
        int A = 3;
        int[] B = {1, 0, 1};
        long result = solve(A, B);
        System.out.println("Result : " + result);
        result = solve1(A, B);
        System.out.println("Result : " + result);
    }
}
