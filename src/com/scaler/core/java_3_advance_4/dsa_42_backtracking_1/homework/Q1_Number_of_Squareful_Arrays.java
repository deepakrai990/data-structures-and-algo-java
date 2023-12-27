package com.scaler.core.java_3_advance_4.dsa_42_backtracking_1.homework;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @created 02/04/23 11:04 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Number_of_Squareful_Arrays {
    public int solve(int[] A) {
        int N = A.length;
        if (N == 1) return 0;

        int[] nums = new int[N];
        System.arraycopy(A, 0, nums, 0, N);
        /*
        for (int i = 0; i < N; i++) {
            nums[i] = A[i];
        }
        */

        HashSet<ArrayList<Integer>> set = new HashSet<>();
        permutate(nums, 0, set);
        return set.size();
    }

    private void permutate(int[] nums, int pos, HashSet<ArrayList<Integer>> set) {
        if (pos == nums.length) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int n : nums) {
                list.add(n);
            }
            set.add(list);
        }

        for (int i = pos; i < nums.length; i++) {
            //if(i != pos && nums[i] == nums[pos]) continue;
            swap(nums, i, pos);
            if (pos == 0 || (pos > 0 && checkPerfectSquare(nums[pos - 1] + nums[pos]))) {
                permutate(nums, pos + 1, set);
            }
            swap(nums, i, pos);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private boolean checkPerfectSquare(int num) {
        double perfectSquare = (double) Math.sqrt(num);
        if (Math.floor(perfectSquare) != Math.ceil(perfectSquare)) {
            return false;
        }
        return true;
    }



}
