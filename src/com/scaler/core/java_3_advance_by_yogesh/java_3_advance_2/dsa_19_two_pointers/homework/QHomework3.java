package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_19_two_pointers.homework;

/**
 * @created 15/02/23 11:15 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework3 {
    private static int[] maxOne1(int[] A, int B) {
        int i = 0;
        int j = 0;
        int zeros = 0;
        int max = Integer.MIN_VALUE;
        int previous = Integer.MIN_VALUE;
        int low = 0;
        int high = 0;
        //sliding window.
        while (j < A.length) {
            if (A[j] == 1) {
                j++;
            } else if (A[j] == 0) {
                j++;
                zeros++;
            }
            //Once zero is greater than B then move the left pointer  B =3 once zeros is 4.
            if (zeros > B) {
                while (zeros > B) {
                    if (A[i] == 0) {
                        zeros--;
                    }
                    i++;
                }
            }
            max = Math.max(max, (j - i + 1));
            //Maintain the max value index.
            if (max != previous) {
                low = i;
                high = j;
                previous = max;
            }

        }
        int[] res = new int[max - 1];
        for (int k = low; k < high; k++) {
            //low = 8 and K = 8 => res[8-8] => res[9 - 8]
            res[k - low] = k;

        }
        return res;
    }

    private static int[] maxOne(int[] A, int B) {
        int left = 0, right = 0, start = 0, end = 0, one = 0, zero = 0, max = 0;
        while (right < A.length) {
            if (zero > B) {
                if (A[left] == 0) zero--;
                else one--;
                left++;
            } else {
                if (A[right] == 0) zero++;
                else one++;
                if (zero <= B && one + zero > max) {
                    start = left;
                    end = right;
                    max = one + zero;
                }
                right++;
            }
        }
        int[] res = new int[end - start + 1];
        int k = 0;
        for (int i = start; i <= end; i++) res[k++] = i;
        return res;
    }
}
