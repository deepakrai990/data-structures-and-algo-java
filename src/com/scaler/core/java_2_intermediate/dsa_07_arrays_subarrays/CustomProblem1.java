package com.scaler.core.java_2_intermediate.dsa_07_arrays_subarrays;

/**
 * @created 17/12/22 5:45 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class CustomProblem1 {
    private static void printAndSumOfEachSubarray(int[] A, int N, int index) {
        int start = index;// 2
        int end = N - 1;
        int size = end - start;
        for (int i = 0; i <= size; i++) {
            System.out.print("{ ");
            for (int j = start; j <= start + i; j++) {
                System.out.print(A[j] + ", ");
            }
            System.out.print("}");
            System.out.print(", Sum = ");
            int sum = 0;
            for (int j = start; j <= start + i; j++) {
                sum = sum + A[j];
            }
            System.out.print(sum);
            System.out.println();
        }
        System.out.println();
    }

    private static void printAndSumOfEachSubarray1(int[] A, int N, int index) {
        for (int i = index; i < N; i++) {
            int sum = 0;
            for (int j = index; j < N; j++) {
                System.out.print("A["+j+"] =" + A[j] + ",  ");
                sum = sum + A[j];
                System.out.print("sum = " + sum + "\n");
            }
        }
    }

    public static void main(String[] args) {
        int[] A = {6, 7, 8, -7, 9};

        int N = A.length;
        int idx = 2;
        //printAndSumOfEachSubarray(A, N, idx);
        int[] A1 = {2, 1, 2, 3, 4, 5};
        int N1 = A1.length;
        int idx1 = 2;
        printAndSumOfEachSubarray(A1, N1, idx1);
    }
}
