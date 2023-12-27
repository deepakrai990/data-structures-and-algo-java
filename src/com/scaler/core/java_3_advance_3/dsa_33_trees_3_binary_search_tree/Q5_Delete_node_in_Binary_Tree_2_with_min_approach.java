package com.scaler.core.java_3_advance_3.dsa_33_trees_3_binary_search_tree;

import com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.model.TreeNode;

/**
 * @author Deepak Kumar Rai
 * @created 09/11/23
 * @project scaler_course_code
 */
public class Q5_Delete_node_in_Binary_Tree_2_with_min_approach {
    private static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        // Search for the node to be deleted
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // Node with two children
            root.val = findMin(root.right);
            // Delete the in-order successor
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }
    private static int findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }
    private static void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }
    public static void main(String[] args) {
        // Example Binary Search Tree
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        System.out.println("Original BST:");
        inorderTraversal(root);

        // Delete node with value 3
        int keyToDelete = 3;
        root = deleteNode(root, keyToDelete);

        System.out.println("\nBST after deleting node with value " + keyToDelete + ":");
        inorderTraversal(root);
    }
}
