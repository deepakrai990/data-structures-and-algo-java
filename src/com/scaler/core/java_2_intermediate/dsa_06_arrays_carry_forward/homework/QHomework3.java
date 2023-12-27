package com.scaler.core.java_2_intermediate.dsa_06_arrays_carry_forward.homework;

/**
 * @created 07/09/22 8:59 am
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QHomework3 {
    /**
     * Q3. Count Subarrays
     *
     * Given a string A = "amazon", find the number of subarrays starting with the character 'a'.
     *
     *
     * Complete Solution
     * The subarrays starting with 'a' are "a", "am",
     * "ama" , "amaz" , "amazo" , "amazon" , "a" , "az",
     * "azo" and "azon".
     * The number of subarrays is 10.
     * **/

    /**
     * Your Suggestion/Fix
     * Approach is to use two pointer technique and hashing here. 1 left pointer and 1 right pointer
     *
     * also store the previous right index
     *
     * iterate your right pointer till end
     *
     * now if repeated element occurs, then
     *
     * 1. add subarrays formed excluding the repeated element
     *
     * 2. subtract those subarrays which are counted again
     *
     *
     * **/
    private static int solve(String A) {
        int ans = 0;
        for (int i = 0; i < A.length() ; i++) {
            System.out.println("i A.charAt("+i+") = " + A.charAt(i));
            if (A.charAt(i) == 'a') {
                int count = 0;
                for (int j = i; j < A.length(); j++) {
                    System.out.println("j A.charAt("+j+") = " + A.charAt(j));
                    count++;
                }
                ans += count;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String A = "amazon";
        int result = solve(A);
        System.out.println("result : " + result);
    }
}
