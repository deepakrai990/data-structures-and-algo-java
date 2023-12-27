package com.scaler.core.java_2_intermediate.dsa_28_trees_basics.homework;

import com.scaler.core.java_2_intermediate.dsa_28_trees_basics.model.TreeNode;

/**
 * @created 21/02/23 3:24 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework2 {
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
        if(A == null) return 0;
        int sum = 0;
        if(isLeafNode(A.left))
            sum += A.left.val;
        else
            sum += solve(A.left);
        sum += solve(A.right);
        return sum;
    }

    private static boolean isLeafNode(TreeNode node){
        if(node == null)  return false;
        if(node.left == null && node.right == null)   return true;
        return false;
    }
}
