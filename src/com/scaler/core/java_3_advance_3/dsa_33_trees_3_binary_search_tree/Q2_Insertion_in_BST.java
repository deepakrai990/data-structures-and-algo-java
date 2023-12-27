package com.scaler.core.java_3_advance_3.dsa_33_trees_3_binary_search_tree;

import com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.model.TreeNode;
import com.scaler.core.utils.PrintUtils;

/**
 * @author Deepak Kumar Rai
 * @created 09/11/23
 * @project scaler_course_code
 */
public class Q2_Insertion_in_BST {
    /**
     * Given K, insert it in the Binary Search Tree, and return the root node of the Binary Search Tree.
     * **/
    private static TreeNode insertBST(TreeNode root, int K) {
        if (root == null) {
            return new TreeNode(K); // Create a new node if the tree is empty
        }
        if (root.val == K) return root;
        if (root.val > K) {
            // Insert into the left subtree if K is less than the current node's value
            root.left = insertBST(root.left, K);
        } else {
            // Insert into the right subtree if K is greater than or equal to the current node's value
            root.right = insertBST(root.right, K);
        }
        return root;
    }
    private static void inOrderTraversal(TreeNode root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        System.out.println(root.val + " ");
        inOrderTraversal(root.right);
    }
    public static void main(String[] args) {
        TreeNode root = createTree();
        int K = 2;
        TreeNode result = insertBST(root, K);
        inOrderTraversal(result);
        System.out.println();
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
