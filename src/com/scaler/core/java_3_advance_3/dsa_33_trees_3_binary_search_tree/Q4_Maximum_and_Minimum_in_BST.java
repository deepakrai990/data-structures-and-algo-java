package com.scaler.core.java_3_advance_3.dsa_33_trees_3_binary_search_tree;

import com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.model.TreeNode;

/**
 * @author Deepak Kumar Rai
 * @created 09/11/23
 * @project scaler_course_code
 */
public class Q4_Maximum_and_Minimum_in_BST {
    /**
     * Given root node of a Binary Search Tree, return maximum of Binary Search Tree.
     * **/
    private static int findMax(TreeNode root) {
        if (root == null) {
            throw new IllegalArgumentException("The tree is empty");
        }
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }
    /**
     * Given root node of a Binary Search Tree, return minimum of Binary Search Tree.
     * **/
    private static int findMin(TreeNode root) {
        if (root == null) {
            throw new IllegalArgumentException("The tree is empty");
        }
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        int maxValue = findMax(root);
        System.out.println("Maximum value in the Binary Search Tree: " + maxValue);
        int minValue = findMin(root);
        System.out.println("Minimum value in the Binary Search Tree: " + minValue);
    }
}
