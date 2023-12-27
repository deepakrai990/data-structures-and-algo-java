package com.scaler.core.java_3_advance_3.dsa_35_trees_5_problems_on_trees.homework;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_33_trees_1.model.TreeNode;

/**
 * @created 02/04/23 12:44 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Sum_binary_tree_or_not {
    /**
     * Definition for binary tree
     * class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) {
     * val = x;
     * left=null;
     * right=null;
     * }
     * }
     */
    private static int solve(TreeNode A) {
        if (A == null) {
            return 1;
        }
        if (A.left == null && A.right == null) {
            return 1;
        }

        if (solve(A.left) == 1 && solve(A.right) == 1) {
            int l = 0, r = 0;
            if (A.left != null) l = A.left.val;
            if (A.right != null) r = A.right.val;
            if (A.val == l + r) {
                A.val += l + r;
                return 1;
            }
        }
        return 0;
    }
}
