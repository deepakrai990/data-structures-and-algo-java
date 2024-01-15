package com.scaler.core.java_2_intermediate.dsa_19_string;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @created 07/10/22 12:09 am
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q2_Sort_in_alphabetical_order {
    /**
     * Problem: Sort in alphabetical order
     * Given a char array s[N], which contains only lowercase alphabets.
     * Sort the given characters in alphabetical order
     * **/
    private static char[] sortString(char[] s) {
        int n = s.length;
        int[] cntArr = new int[26];
        for (int i = 0; i < n; i++) { // Iterate s
            int index = s[i] - 97;
            cntArr[index]++;
        }
        // Modify an original char array
        int k = 0;
        for (int i = 0; i < 26; i++) {
            // cntArr[i] = Frequency of ('a' + i)
            char ch = (char) ('a' + i);
            for (int j = 1; j <= cntArr[i]; j++) {
                s[k] = ch;
                k++;
            }
        }
        return s;
    }
    // Function to sort characters in s based on their frequency
    private static char[] sortByFrequency(char[] s) {
        int n = s.length;
        int[] freq = new int[26];
        // Count the frequency of each character
        for (int i = 0; i < n; i++) {
            int index = s[i] - 'a';
            freq[index]++;
        }
        // Modify the original char array based on frequency
        int k = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < freq[i]; j++) {
                s[k] = (char) ('a' + i);
                k++;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'c', 'e', 'b', 'c', 'b', 'a', 'c', 'e'};
        System.out.println("Before Sorting : " + Arrays.toString(chars));
        char[] results = sortString(chars);
        System.out.println("After Sorting  : " + Arrays.toString(results));

        char[] chars1 = {'a', 'b', 'c', 'e', 'b', 'c', 'b', 'a', 'c', 'e'};
        System.out.println("Before Sorting : " + Arrays.toString(chars1));
        char[] results1 = sortByFrequency(chars1);
        System.out.println("After Sorting  : " + Arrays.toString(results1));
    }
}
