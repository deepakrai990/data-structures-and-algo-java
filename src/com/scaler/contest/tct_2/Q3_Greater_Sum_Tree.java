package com.scaler.contest.tct_2;

/**
 * @created 26/09/23 4:14 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
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
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}
public class Q3_Greater_Sum_Tree {
    /**
     * Example
     *          3
     *         / \
     *        2   5
     *       /   / \
     *      1   4   6
     * **/
    public TreeNode solve(TreeNode A) {
        int[] sum = {0};
        reverseInorder(A, sum);
        return A;
    }
    private static void reverseInorder(TreeNode root, int[] sum) {
        if (root == null) return;
        reverseInorder(root.right, sum);
        root.val += sum[0];
        sum[0] = root.val;
        reverseInorder(root.left, sum);
    }
}
