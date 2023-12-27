package com.scaler.core.java_3_advance_3.dsa_34_trees_4_lowest_common_ancestor.assignment;


import com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.model.TreeNode;

/**
 * @created 02/04/23 12:46 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_LCA_in_BST {
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
    public int solve(TreeNode A, int B, int C) {
        TreeNode curr = A;
        while (curr != null) {
            if (B < curr.val && C < curr.val) {
                curr = curr.left;
            } else if (B > curr.val && C > curr.val) {
                curr = curr.right;
            } else {
                return curr.val;
            }
        }
        return 0;
    }
}
