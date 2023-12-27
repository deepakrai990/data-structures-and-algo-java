package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_12_sorting_1_selection_and_merge_sort;

/**
 * @created 28/01/23 5:37 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion7 {
    int mod = 1000000007;
    long inversionCount = 0l;

    public int solve(int[] A) {
        int n = A.length;
        mergeSort(A, 0, n - 1);
        return (int) inversionCount;
    }

    public void mergeSort(int[] A, int s, int e) {
        if (s >= e) return;
        int mid = (s + e) / 2;
        mergeSort(A, s, mid);
        mergeSort(A, mid + 1, e);
        merge(A, s, mid, e);
    }

    public void merge(int[] A, int s, int mid, int e) {
        int n1 = mid - s + 1;
        int n2 = e - mid;
        int A1[] = new int[n1];
        int A2[] = new int[n2];
        int index = 0;
        for (int i = s; i <= mid; i++) {
            A1[index++] = A[i];
        }
        index = 0;
        for (int i = mid + 1; i <= e; i++) {
            A2[index++] = A[i];
        }
        int i = 0, j = 0;
        index = s;

        while (i < n1 && j < n2) {
            if (A1[i] <= A2[j])
                A[index++] = A1[i++];
            else {
                inversionCount = (inversionCount + (A1.length - i)) % mod;
                A[index++] = A2[j++];
            }
        }
        while (i < n1) {
            A[index++] = A1[i++];
        }
        while (j < n2) {
            A[index++] = A2[j++];
        }
    }
}
