package com.scaler.core.java_2_intermediate.dsa_18_sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/**
 * @author Deepak Kumar Rai
 * @created 07/01/24
 * @project scaler_course_code
 */
public class Q4_Bubble_Sort_Algorithms {
    private static void bubbleSort(int[] A) {
        int N = A.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                if (A[j] > A[j + 1]) { // Edge case j = N - 1: A[N - 1]
                    swap(A, j, j + 1);
                }
            }
        }
    }
    private static void swap(int[] A, int start, int end) {
        int temp = A[start];
        A[start] = A[end];
        A[end] = temp;
    }
    // Bubble sort with comparator
    private static <T> void bubbleSort1(T[] array, Comparator<T> comparator) {
        int N = array.length;
        boolean swapped;
        for (int i = 0; i < N - 1; i++) {
            swapped = false;
            for (int j = 0; j < N - i - 1; j++) {
                if (comparator.compare(array[j], array[j + 1]) > 0) {
                    // Swap array[j] and array[j + 1]
                    swap(array, j, j + 1);
                    swapped = true;
                }
            }
            // If no two elements were swapped by inner loop, the array is already sorted
            if (!swapped) {
                break;
            }
        }
    }
    private static <T> void swap(T[] A, int start, int end) {
        T temp = A[start];
        A[start] = A[end];
        A[end] = temp;
    }
    public static void main(String[] args) {
        int[] A = {3, 8, 6, 2, 4};
        System.out.println("Before sorting : " + Arrays.toString(A));

        bubbleSort(A);
        System.out.println("After sorting  : " + Arrays.toString(A));

        Integer[] intArray = {64, 34, 25, 12, 22, 11, 90};
        Comparator<Integer> intComparator = (Integer a, Integer b) -> { // Ascending order
                if (Objects.equals(a, b)) return 0;
                else if (a > b) return 1;
                else return  -1;
        };
        System.out.println("Before sorting : " + Arrays.toString(intArray));

        bubbleSort1(intArray, intComparator);
        System.out.println("After sorting  : " + Arrays.toString(intArray));
        Integer[] intArray1 = {64, 34, 25, 12, 22, 11, 90};
        Comparator<Integer> intComparator1 = (Integer a, Integer b) -> { // Descending order
            if (Objects.equals(a, b)) return 0;
            else if (a < b) return 1;
            else return  -1;
        };

        System.out.println("Before sorting : " + Arrays.toString(intArray1));

        bubbleSort1(intArray1, intComparator1);
        System.out.println("After sorting  : " + Arrays.toString(intArray1));
    }
}
