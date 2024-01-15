package com.scaler.core.java_2_intermediate.dsa_04_introduction_to_arrays;

/**
 * @created 13/12/22 3:11 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_At_least_One_Greater_element {
    private static int countGreaterElement(int[] A, int N) {
        int maxElement = A[0];
        for (int i = 1; i < N; i++) {
            maxElement = Math.max(A[i], maxElement);
        }
        int freqCount = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] == maxElement)
                freqCount++;
        }
        return N - freqCount;
    }
    private static int countGreaterElement2(int[] A, int N) {
        int maxElement = 0;
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] > maxElement) {
                maxElement = A[i];
                count = 1;
            } else if (maxElement == A[i]) {
                count = count + 1;
            }
        }
        return N - count;
    }
    /**
     * Using one loop
     * **/
    private static int countGreaterElement1(int[] A, int N) {
        int maxElement = 0, freqCount = 0;
        for(int i = 0 ; i < N ; i++){
            if(A[i] > maxElement){
                maxElement = A[i];
                freqCount = 1;
            }
            else if(A[i] == maxElement){
                freqCount += 1;
            }
        }
        return N - freqCount;
    }
    public static void main(String[] args) {
        int[] A = {2, 5, 1, 4, 8, 0, 8, 1, 3, 8};
        int result = countGreaterElement(A, A.length);
        System.out.printf("%s%10d\n", "Result = ", result);
        result = countGreaterElement1(A, A.length);
        System.out.printf("%s%10d\n", "Result = ", result);
        result = countGreaterElement2(A, A.length);
        System.out.printf("%s%10d\n", "Result = ", result);
    }
}
