package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_17_searching_2_binary_search_problems;

/**
 * @created 07/02/23 7:30 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion1 {
    /**
     * Given a positive N, find sqrt(N) / Given N, find greater such that i * i <= N.
     * Note:-
     * floor(sqrt(N))
     * Like...
     * sqrt(25) = 5
     * sqrt(16) = 4
     * sqrt(47) = 6
     * sqrt(10) = 3
     **/
    // Idea 1 :- Start your i from 1 and keep on updating the answer until i * i <= N
    private static int sqrtIdea1(int N) {
        int i = 1, ans = 1;
        while ((i * i) <= N) {
            ans = i;
            i++;
        }
        return ans;
    }

    // Idea 2:- Target = sqrt(N)
    private static int sqrtIdea2(int N) {
        // Search Space
        int low = 1, high = N;
        int ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if ((mid * mid) == N) {
                return mid;
            } else if ((mid * mid) < N) {
                ans = mid;
                low = mid + 1; // go to right side
            } else if ((mid * mid) > N) {
                high = mid - 1; // go to left side
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int N = 40;
        int result = sqrtIdea1(N);
        System.out.println("Idea 1");
        System.out.printf("%s%5d", "Result: ", result);
        System.out.println("\nIdea 2");
        int result1 = sqrtIdea2(N);
        System.out.printf("%s%5d", "Result: ", result1);
    }
}
