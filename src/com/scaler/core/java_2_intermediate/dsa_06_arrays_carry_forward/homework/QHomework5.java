package com.scaler.core.java_2_intermediate.dsa_06_arrays_carry_forward.homework;

import java.util.TreeSet;

/**
 * @created 07/09/22 10:26 am
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QHomework5 {
    /**
     * Q5. Amazing Subarrays
     *
     * You are given a string S, and you have to find all the amazing substrings of S.
     *
     * An amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).
     *
     * Input
     *
     * Only argument given is string S.
     * Output
     *
     * Return a single integer X mod 10003, here X is the number of Amazing Substrings in given the string.
     * Constraints
     *
     * 1 <= length(S) <= 1e6
     * S can have special characters
     * Example
     *
     * Input
     *     ABEC
     *
     * Output
     *     6
     *
     * Explanation
     *     Amazing substrings of given string are :
     *     1. A
     *     2. AB
     *     3. ABE
     *     4. ABEC
     *     5. E
     *     6. EC
     *     here number of substrings are 6 and 6 % 10003 = 6.
     * **/
    private static int solve(String A) {
        int count = 0;
        int n = A.length();

        for (int i = 0; i < n; i++) {
            char ch = A.charAt(i);
            if (isVowel(ch)) {
                String substr = A.substring(i, n);
                count = count + substr.length();
            }
        }
        return count % 10003;
    }
    private static boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A'
                || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
            return true;
        }
        return false;
    }
    /**
     * Scaler Solution
     * Approach
     *
     * Hint 1
     * Brute Force Approach is to find all the substrings and count the substrings those start with a vowel.
     * This approach will result in the timeout as the time complexity of the same is O(n^2).
     * Is there any need to find all the substrings?
     * Try to find a pattern.
     *
     * Solution Approach
     * The main idea to solve this problem is to traverse the string and when you encounter a vowel,
     * add ( length(string) - position_of_curr_char ) to the answer.
     * **/
    private static int solve1(String A) {
        TreeSet<Character> se = new TreeSet<>();
        se.add('a'); se.add('e'); se.add('i'); se.add('o'); se.add('u');
        se.add('A'); se.add('E'); se.add('I'); se.add('O'); se.add('U');

        int n = A.length();
        long ans = 0;
        for(int i = 0; i < n; i++){
            if(se.contains(A.charAt(i))){
                ans += (n - i);
            }
        }
        return (int)(ans % 10003);
    }

    public static void main(String[] args) {
        String A = "ABEC";
        int result = solve(A);
        System.out.println("result : " + result);
    }
}
