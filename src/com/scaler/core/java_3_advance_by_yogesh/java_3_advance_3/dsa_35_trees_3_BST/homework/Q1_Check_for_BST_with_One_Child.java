package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_35_trees_3_BST.homework;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_33_trees_1.model.TreeNode;

/**
 * @created 18/03/23 4:55 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Check_for_BST_with_One_Child {
    private static String solve(int[] A) {
        int N = A.length;
        //if total nodes are less than 3 return YES, as we can always form a BST with 2 or 1 node(s).
        if (N < 3) return "YES";
        if (checkBST(A, N)) return "YES";
        return "NO";
    }

    private static boolean checkBST(int[] A, int N) {
        int leftRange = Integer.MIN_VALUE;
        int rightRange = Integer.MAX_VALUE;
        for (int i = 0; i < N - 1; ++i) {
            int currParent = A[i];
            int child = A[i + 1];
            if (currParent < child) {
                if (leftRange < child && child < rightRange) leftRange = currParent;
                else return false;
            } else {
                if (leftRange < child && child < rightRange) rightRange = currParent;
                else return false;
            }
        }
        return true;
    }

    private static String solve_1(int[] A) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        TreeNode root = null, node = null;
        for (int i = 0; i < A.length; i++) {
            if (root == null) {
                root = new TreeNode(A[i]);
                node = root;
            } else if (A[i] > node.val && A[i] < max && A[i] > min) {//right
                node.right = new TreeNode(A[i]);
                min = node.val;// [min, max] successive nodes should be in this range
                node = node.right;
            } else if (A[i] <= node.val && A[i] > min && A[i] < max) {
                node.left = new TreeNode(A[i]);
                max = node.val;
                node = node.left;
            } else {
                return "NO";
            }
        }
        return "YES";
    }
}
