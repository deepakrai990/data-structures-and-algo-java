package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_14_sorting_3_radix_sort_and_problems.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 11/02/23 8:06 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question3 {

    private static int[][] solve(int[][] A, int B) {
        int n = A.length;
        mergeSort(A, 0, n - 1);
        int[][] ans = new int[B][2];
        for (int i = 0; i < ans.length; i++) {
            ans[i][0] = A[i][0];
            ans[i][1] = A[i][1];
        }
        return ans;
    }
    private static void mergeSort(int[][] A, int s, int e) {
        if(s >= e) return;
        int mid = (s + e) / 2;
        mergeSort(A, s, mid);
        mergeSort(A, mid + 1, e);
        merge(A, s, mid, e);
    }
    private static void merge(int[][] A, int s, int mid, int e) {
        int n1 = mid - s + 1;
        int n2 = e - mid;
        int A1[][] = new int[n1][2];
        int A2[][] = new int[n2][2];
        int index = 0;

        for(int i = s; i <= mid; i++) {
            A1[index][0] = A[i][0];
            A1[index][1] = A[i][1];
            index++;
        }

        index = 0;
        for(int i = mid+1; i <= e; i++) {
            A2[index][0] = A[i][0];
            A2[index][1] = A[i][1];
            index++;
        }

        int i = 0, j = 0;
        index = s;
        while (i < n1 && j < n2) {
            long s1 = (long) (A1[i][0] * A1[i][0]) + (long) (A1[i][1] * A1[i][1]);
            long s2 = (long) (A2[j][0] * A2[j][0]) + (long) (A2[j][1] * A2[j][1]);
            if (s1 < s2) {
                A[index][0] = A1[i][0];
                A[index][1] = A1[i][1];
                index++;
                i++;
            } else {
                A[index][0] = A2[j][0];
                A[index][1] = A2[j][1];
                index++;
                j++;
            }
        }
        while (i < n1) {
            A[index][0] = A1[i][0];
            A[index][1] = A1[i][1];
            index++;
            i++;
        }
        while(j < n2){
            A[index][0] = A2[j][0];
            A[index][1] = A2[j][1];
            index++;
            j++;
        }
    }
    public static void main(String[] args) {
        int[][] A = {{1, 3}, {-2, 2}};
        int B = 1;
        int[][] results = solve(A, B);
        PrintUtils.print2DArray(results);
    }
}
