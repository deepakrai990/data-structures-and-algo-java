package com.scaler.core.java_2_intermediate.dsa_06_arrays_carry_forward.homework;

/**
 * @created 07/09/22 10:54 am
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q6_Pick_from_both_sides_1 {
    /**
     * Q6. Pick from both sides!
     *
     * Problem Description
     * You are given an integer array A of size N.
     *
     * You have to pick B elements in total. Some (possibly 0) elements from left end of array A and some
     * (possibly 0) from the right end of array A to get the maximum sum.
     *
     * Find and return this maximum possible sum.
     *
     * NOTE: Suppose B = 4, and array A contains 10 elements, then
     *
     * You can pick the first four elements or can pick the last four elements, or can pick 1 from front and 3 from
     * the back, etc. You need to return the maximum possible sum of elements you can pick.
     *
     *
     * Problem Constraints
     * 1 <= N <= 105
     *
     * 1 <= B <= N
     *
     * -103 <= A[i] <= 103
     *
     *
     *
     * Input Format
     * First argument is an integer array A.
     *
     * Second argument is an integer B.
     *
     *
     *
     * Output Format
     * Return an integer denoting the maximum possible sum of elements you picked.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = [5, -2, 3 , 1, 2]
     *  B = 3
     * Input 2:
     *
     *  A = [1, 2]
     *  B = 1
     *
     *
     * Example Output
     * Output 1:
     *
     *  8
     * Output 2:
     *
     *  2
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  Pick element 5 from front and element (1, 2) from back so we get 5 + 1 + 2 = 8
     * Explanation 2:
     *
     *  Pick element 2 from end as this is the maximum we can get
     * **/
    private static int solve(int[] A, int B) {
        int N = A.length;
        //sum of last B elements
        int sum = add_last(A, B, N);
        int max_sum = sum;
        //sliding the subarray
        for (int i = B; i > 0; i--) {
            //subtracting first element from the subarray and adding next element
            sum = sum - A[N-i] + A[(N-i+B)%N];
            if (sum > max_sum) max_sum = sum;
        }
        return max_sum;
    }
    private static int add_last(int[] A, int B, int N) {
        int sum=0;
        for (int i = N-B; i<N; i++) {
            sum += A[i];
        }
        return sum;
    }
    /**
     * Scaler Solution
     * Approach
     *
     * Hint 1
     * Try to use prefix and suffix sum arrays to solve the problem. You can try to pick one by one from the left
     * and then use the suffix array to pick from the right.
     *
     * Solution Approach
     * Approach using Prefix and Suffix Sums:
     *
     * Maintain two arrays prefix[i] and suffix[i] where prefix[i] denotes sum of elements from index [0,i]
     * and suffix[i] denotes sum of elements from index [i,N-1].
     *
     * Now iterate from left and one by one pick elements from left for example: if you pick ‘a’ elements from left
     * and remaining ‘k-a’ elements from right.
     * So the sum in this case will be prefix[a-1] + suffix[n-(k-a)]
     *
     * Maintain the maximum among all and return it.
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * where N is number of elements in array A
     *
     * Bonus: Try solving it in O(1) space.
     * **/
    private static int solve_method_1(int[] A, int B) {
        int n = A.length;
        int []suff = new int[n + 1];
        suff[n] = 0;
        suff[n - 1] = A[n - 1];
        for(int i = n - 2; i >= 0; i--){
            suff[i] = A[i] + suff[i + 1];
        }
        int pref_sum = 0;
        int ans = suff[n - B];
        for(int i = 0; i < B; i++){
            pref_sum = pref_sum + A[i];
            int suff_sum = suff[n - B + (i + 1)];
            ans = Math.max(ans, pref_sum + suff_sum);
        }
        return ans;
    }
    private static int solve_method_2(int[] A, int B) {
        int n = A.length;
        int cur = 0;
        for(int i = 0; i < B; i++){
            cur += A[i];
        }
        int back = B - 1;
        int ans = cur;
        for(int j = n - 1 ; j >= n-B; j--){
            cur += A[j];
            cur -= A[back];
            back--;
            ans = Math.max(ans, cur);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] A = {5, -2, 3 , 1, 2};
        int B = 3;
        int sum = solve(A, B);
        System.out.println("sum : " + sum);
        sum = solve_method_1(A, B);
        System.out.println("sum : " + sum);
        sum = solve_method_2(A, B);
        System.out.println("sum : " + sum);
    }
}
