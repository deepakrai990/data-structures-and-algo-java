package com.scaler.core.java_3_advance_3.dsa_34_trees_4_lowest_common_ancestor;

import com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.model.TreeNode;
import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 8:36 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Search_in_BT {
    /**
     * Question: Given a Binary Tree which contains all unique values.
     * Search if there exists a K in the Binary Tree
     * Note: Try out the recursive function
     * **/
    private static boolean searchBT(TreeNode root, int K) {
        if (root == null) return false;
        if (root.val == K) return true;
        if (searchBT(root.left, K) || searchBT(root.right, K)) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        TreeNode root = createTree();
        int K = 6;
        boolean result = searchBT(root, K);
        PrintUtils.print(result);
    }
    private static TreeNode createTree() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(7);
        root.left.left = new TreeNode(9);
        root.left.left.left = new TreeNode(12);
        root.left.left.right = new TreeNode(19);

        root.right = new TreeNode(4);
        root.right.right = new TreeNode(18);
        root.right.left = new TreeNode(14);
        root.right.left.left = new TreeNode(15);
        root.right.left.right = new TreeNode(-12);
        root.right.left.right.right = new TreeNode(6);

        return root;
    }
}
