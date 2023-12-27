package com.scaler.core.java_3_advance_3.dsa_33_trees_3_binary_search_tree;

import com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.model.TreeNode;
import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 8:36 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Check_K_is_present_in_given_BST {
    /**
     * Check K is present in given Binary Search Tree, if Yes return true, otherwise return false.
     * **/
    private static boolean searchBST(TreeNode root, int K) {
        if (root == null) return false;
        if (root.val == K) {
            return true; // value found
        } else if (root.val > K) {
            return searchBST(root.left, K); // Search in the left subtree
        } else {
            return searchBST(root.right, K); // Search in the right subtree
        }
    }
    public static void main(String[] args) {
        TreeNode root = createTree();
        int K = 9;
        boolean result = searchBST(root, K);
        PrintUtils.print(result);
    }
    private static TreeNode createTree() {
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
