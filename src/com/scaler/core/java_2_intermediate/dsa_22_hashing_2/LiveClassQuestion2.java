package com.scaler.core.java_2_intermediate.dsa_22_hashing_2;

import java.util.HashSet;

/**
 * @created 08/10/22 12:03 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion2 {
    public static int countPairSet(int A[], int B) {
        int n = A.length;
        int m = 1000000007;
        int count = 0;
        HashSet<Integer> hs = new HashSet<Integer>();
        for (int i = 0; i < n; i++){
            int a = A[i];
            int b = B - a;
            int c = B + a;
            if (hs.contains(b)){
                count++;
                count = (count + b) % m;
            }
            if (hs.contains(c)) {
                count++;
                count = (count + c) % m;
            }
            hs.add(a);
        }
        return count;
    }
    public static void main(String[] args) {
        int[] A = {2, 1, 2, 1, 2, 1, 2, 1, 2};
        int B = 1;
        int result = countPairSet(A, B);
        System.out.println("Result : " + result);
    }
}
