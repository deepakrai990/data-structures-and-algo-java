package com.scaler.core.java_3_advance_3.dsa_33_trees_3_binary_search_tree;

import com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.model.TreeNode;
import com.scaler.core.utils.PrintUtils;

/**
 * @author Deepak Kumar Rai
 * @created 09/11/23
 * @project scaler_course_code
 */
public class Q3_Check_if_given_tree_is_BST_or_not {
    /**
     * Check if a given tree is a Binary Search Tree or not
     * **/
    private static boolean isBST(TreeNode root) {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private static boolean isBSTUtil(TreeNode root, int minValue, int maxValue) {
        if (root == null) return true; // An empty tree is BST
        if (minValue <= root.val && maxValue >= root.val) {
            return isBSTUtil(root.left, minValue, root.val)
                    && isBSTUtil(root.right, root.val, maxValue);
        } else {
            return false;
        }
    }
    private static boolean isBST_1(TreeNode root) {
        return isBSTUtil_1(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private static boolean isBSTUtil_1(TreeNode root, int minValue, int maxValue) {
        if (root == null) return true; // An empty tree is BST
        if (root.val <= minValue || root.val >= maxValue) {
            return false;
        }
        return isBSTUtil_1(root.left, minValue, root.val)
                && isBSTUtil_1(root.right, root.val, maxValue);
    }
    public static void main(String[] args) {
        TreeNode root = createBST();
        boolean result = isBST(root);
        PrintUtils.print(result);
        result = isBST_1(root);
        PrintUtils.print(result);
    }
    private static TreeNode createBST() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(-1);
        root.left.right = new TreeNode(3);

        root.right = new TreeNode(10);
        root.right.right = new TreeNode(15);
        root.right.left = new TreeNode(7);

        root.right.left.left = new TreeNode(6);
        root.right.left.right = new TreeNode(9);

        return root;
    }
}
