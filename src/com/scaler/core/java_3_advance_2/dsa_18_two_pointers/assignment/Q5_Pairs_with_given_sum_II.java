package com.scaler.core.java_3_advance_2.dsa_18_two_pointers.assignment;

/**
 * @created 02/04/23 7:11 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q5_Pairs_with_given_sum_II {
    private static int solve(int[] A, int B) {
        int N = A.length;
        int i = 0, j = N - 1;
        int mod = (int) (Math.pow(10, 9)) + 7;
        long ans = 0;
        long sum = 0;
        while (i < j) {
            sum = (A[i] + A[j]) % mod;
            if (sum > B) {
                j--;
            } else if (sum < B) {
                i++;
            } else {
                if (A[i] == A[j]) {
                    long x = j - i + 1; //no other elements will be in between ith index and jth index
                    ans += ((x * (x - 1)) / 2) % mod;
                    break;
                } else {
                    int a = 1, b = 1;
                    while (A[i] == A[i + 1]) { //counting duplicate values
                        a++;
                        i += 1;
                    }
                    i += 1;
                    while (A[j] == A[j - 1]) {
                        b++;
                        j -= 1;
                    }
                    j -= 1;
                    ans += ((long) a * b) % mod;
                }
            }

        }
        return (int) ans % mod;
    }

    private static int solve1(int[] A, int B) {
        int mod = (int) (Math.pow(10, 9)) + 7;
        int left = 0, right = A.length - 1, ans = 0;
        while (left < right) {
            int sum = A[left] + A[right];
            if (sum == B) {
                int count = 0, prev = right;
                while (prev > left && A[right] == A[prev]) {//count duplicate values from right pointer
                    count++;
                    prev--;
                }
                ans = (ans + count) % mod;
                left++;
            } else if (sum < B) {
                left++;
            } else if (sum > B) {
                right--;
            }
        }
        return ans;
    }
}
