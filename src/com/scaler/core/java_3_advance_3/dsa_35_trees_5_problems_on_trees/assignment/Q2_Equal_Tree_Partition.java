package com.scaler.core.java_3_advance_3.dsa_35_trees_5_problems_on_trees.assignment;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_33_trees_1.model.TreeNode;

/**
 * @created 02/04/23 12:43 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Equal_Tree_Partition {
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
    int flag = 0;
    public int solve(TreeNode A) {
        if (A.left == null && A.right == null) return 0;
        //Finding sum of tree
        long sum1 = findSum(A);
        //checking if equal partition exists
        long sum2 = findAns(A, sum1);

        return flag;
    }

    public long findSum(TreeNode A) {
        if (A == null) return 0;
        long leftSum = findSum(A.left);
        long rightSum = findSum(A.right);
        return leftSum + rightSum + A.val;
    }

    public long findAns(TreeNode A, long sum) {
        if (A == null) return 0;
        //Starting From leaf finding the left sum and right sum.
        long leftSum = findAns(A.left, sum);
        long rightSum = findAns(A.right, sum);
        long z = leftSum + rightSum + A.val;
        //Checking if equal partition exists by subtracting from total sum
        if (z == sum - z) flag = 1;
        //returning sum with all the child of that node
        return z;
    }
}
