package com.scaler.core.java_3_advance_3.dsa_35_trees_5_problems_on_trees.assignment;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_33_trees_1.model.TreeNode;

/**
 * @created 02/04/23 12:42 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Invert_the_Binary_Tree {
    /**
     * Definition for binary tree
     * class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) {
     *      val = x;
     *      left=null;
     *      right=null;
     *     }
     * }
     */
    private static TreeNode invertTree(TreeNode A) {
        if (A == null) {
            return null;
        }

        TreeNode left = invertTree(A.left);
        TreeNode right = invertTree(A.right);
        A.left = right;
        A.right = left;

        return A;
    }

    private static TreeNode invertTree_1(TreeNode A) {
        if (A == null) {
            return null;
        }
        TreeNode temp = A.left;
        A.left = A.right;
        A.right = temp;
        invertTree_1(A.left);
        invertTree_1(A.right);
        return A;
    }
}
