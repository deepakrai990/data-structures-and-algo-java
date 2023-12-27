package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_20_hashing_1_introduction_and_problems.assignment;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * @created 16/02/23 10:10 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question4 {
    public int[] solve(String A, int[][] B) {
        TreeSet<Integer> set = new TreeSet<>();
        int n = A.length();
        //Put all indexes with the character 1 in the TreeSet
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == '1') {
                set.add(i + 1);
            }
        }
        //Since we do not know how many 2 X queries will be there
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < B.length; i++) {
            //Operation to be performed
            int ops = B[i][0];
            //1 based index ops to be done on
            int index = B[i][1];
            if (ops == 1) {
                if (set.contains(index)) {
                    set.remove(index);
                } else {
                    set.add(index);
                }
            } else {
                int left = Integer.MIN_VALUE, right = Integer.MAX_VALUE;
                if (set.ceiling(index) != null) {
                    // finds the nearest '1' on the right
                    right = set.ceiling(index);
                }
                if (set.floor(index) != null) {
                    // finds the nearest '1' on the left
                    left = set.floor(index);
                }
                if (left == Integer.MIN_VALUE && right == Integer.MAX_VALUE) {
                    ans.add(-1);
                } else if (left != Integer.MIN_VALUE && (index - left <= right - index)) {
                    ans.add(left);
                } else {
                    ans.add(right);
                }
            }
        }
        int[] res = new int[ans.size()];
        int j = 0;
        for (int i = 0; i < ans.size(); i++) {
            res[j++] = ans.get(i);
        }
        return res;
    }

    private static int[] solve1(String A, int[][] B) {
        char[] C = A.toCharArray();
        int k = 0, index = -1;
        int p1 = -1, p2 = -1;
        int n = B.length;
        int[] result = new int[n];

        for (int j = 0; j < B.length; j++) {
            if (B[j][0] == 1) {
                int l = B[j][1] - 1;
                C[l] = (char) ((int) ((C[l] - '0') ^ 1) + '0');
            } else {
                p2 = p1 = B[j][1] - 1;
                index = findNearestOne(C, p1, p2);
                result[k++] = index;
            }
        }
        int count = 0;
        for (int i = 0; i < result.length; i++) {
            if (result[i] != 0)
                count++;
        }
        int[] res = new int[count];
        int l = 0;
        for (int i = 0; i < result.length; i++) {
            if (result[i] != 0)
                res[l++] = result[i];
        }
        return res;
    }

    private static int findNearestOne(char[] C, int p1, int p2) {
        int li = -1, ri = -1;
        while (p1 >= 0 || p2 < C.length) {
            if (p1 >= 0) {
                if (C[p1] != '1') {
                    p1--;
                } else {
                    li = p1;
                    return li + 1;
                }
            }
            if (p2 < C.length) {
                if (C[p2] != '1') {
                    p2++;
                } else {
                    ri = p2;
                    return ri + 1;
                }
            }
        }
        return -1;
    }
}
