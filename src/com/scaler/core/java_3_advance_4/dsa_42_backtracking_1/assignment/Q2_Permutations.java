package com.scaler.core.java_3_advance_4.dsa_42_backtracking_1.assignment;

/**
 * @created 02/04/23 11:02 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Permutations {
    int[][] ans;
    int count = 0;

    private int[][] permute(int[] A) {
        int n = A.length;
        ans = new int[findFactorial(n)][n]; // no. of rows is fixed which is n!
        generate(0, A, n);
        return ans;
    }

    private void generate(int index, int[] A, int n) {
        // System.out.println(Arrays.toString(A));
        //base case
        if (index == n - 1) {
            ans[count] = A;
            count++;
        }

        for (int i = index; i < n; i++) {
            int[] temp = new int[n];//copy of existing array
            System.arraycopy(A, 0, temp, 0, n);
            swap(temp, index, i);
            generate(index + 1, temp, n);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //max value of n is 9
    private int findFactorial(int n) {
        int ans = 1;
        for (int i = 1; i <= n; i++)
            ans *= i;
        return ans;
    }
}
