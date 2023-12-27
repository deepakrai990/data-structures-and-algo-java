package com.scaler.core.java_2_intermediate.dsa_28_trees_basics.homework;

import com.scaler.core.java_2_intermediate.dsa_28_trees_basics.model.TreeNode;

/**
 * @created 21/02/23 3:24 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework1 {
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
    public int solve(TreeNode A) {
        Integer max = 0;
        return countNodes(A, max);
    }
    private static int countNodes(TreeNode root, Integer max) {
        if (root == null)
            return 0;
        int counter = 0;
        if (root.val > max) {
            max = root.val;
            counter++;
        }
        counter += countNodes(root.left, max);
        counter += countNodes(root.right, max);
        return counter;
    }
}
