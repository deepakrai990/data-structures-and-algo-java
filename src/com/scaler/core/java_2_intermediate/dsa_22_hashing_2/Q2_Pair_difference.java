package com.scaler.core.java_2_intermediate.dsa_22_hashing_2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Deepak Kumar Rai
 * @created 08/01/24
 * @project scaler_course_code
 */
public class Q2_Pair_difference {
    /**
     * Problem: Pair Difference
     * Given array A[N], check is there exists a pair of (i, j),
     * such that A[i] - A[j] equals to K.
     * Where i != j
     * **/
    private static boolean pairDifference(int[] A, int K) {
        int N = A.length;
        for (int i = 0; i < N; i++) {
            int a = A[i], b = K + A[i];
            for (int j = i + 1; j < N; j++) {
                if (A[j] == b) {
                    return true;
                }
            }
        }
        return false;
    }
    // Optimise Approach 1 with HashMap
    private static boolean pairDifference1(int[] A, int K) {
        int N = A.length;
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < N; i++) {
            hm.put(A[i], hm.getOrDefault(A[i], 0) + 1);
        }
        for (int i = 0; i < N; i++) {
            int a = A[i], b = K + A[i];
            if (a != b && hm.containsKey(b)) {
                return true;
            }
            if (a == b && hm.get(a) > 1) {
                return true;
            }
        }
        return false;
    }
    // Optimise Approach 2 with HashSet
    private static boolean pairDifference2(int[] A, int K) {
        int N = A.length;
        Set<Integer> hs = new HashSet<>();
        for (int i = 0; i < N; i++) {
            int a = A[i], b = K + A[i];
            if (hs.contains(b)) {
                return true;
            }
            hs.add(a);
        }
        return false;
    }
    // Optimise Approach 3 with HashMap
    // Function to check if there exists a pair with difference equal to K using HashMap
    private static boolean hasPairWithDifference(int[] array, int target) {
        // Use a HashMap to store elements and their frequencies
        HashMap<Integer, Integer> elementsMap = new HashMap<>();
        // Iterate through the array
        for (int i = 0; i < array.length; i++) {
            int currentElement = array[i];
            int complement = currentElement - target;
            // Check if the complement is already in the HashMap
            if (elementsMap.containsKey(complement) && elementsMap.get(complement) > 0) {
                return true; // Pair found
            }
            // Update the frequency of the current element in the HashMap
            elementsMap.put(currentElement, elementsMap.getOrDefault(currentElement, 0) + 1);
        }
        // No pair with difference equal to K found
        return false;
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 7, 9, 2, 5, 6};
        int K = 2;

        boolean result = pairDifference(A, K);
        System.out.println("Pair with Difference " + K + " Exists: " + result);

        result = pairDifference1(A, K);
        System.out.println("Pair with Difference " + K + " Exists: " + result);

        result = pairDifference2(A, K);
        System.out.println("Pair with Difference " + K + " Exists: " + result);

        result = hasPairWithDifference(A, K);
        System.out.println("Pair with Difference " + K + " Exists: " + result);
    }
}
