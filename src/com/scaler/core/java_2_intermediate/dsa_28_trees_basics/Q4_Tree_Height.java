package com.scaler.core.java_2_intermediate.dsa_28_trees_basics;

import com.scaler.core.java_2_intermediate.dsa_28_trees_basics.model.TreeNode;

/**
 * @author Deepak Kumar Rai
 * @created 08/01/24
 * @project scaler_course_code
 */
public class Q4_Tree_Height {
    // Recursive function to calculate the height of the tree
    private static int calculateTreeHeight(TreeNode root) {
        // Base case: return -1 for null nodes
        if (root == null) {
            return -1;
        }
        // Recursive calls for the left and right subtrees
        int leftHeight = calculateTreeHeight(root.left);
        int rightHeight = calculateTreeHeight(root.right);
        // Return the maximum height of the left and right subtrees, plus 1 for the current node
        return Math.max(leftHeight, rightHeight) + 1;
    }
    public static void main(String[] args) {
        TreeNode root = createTreeNode();
        // Calculate the height of the tree
        int height = calculateTreeHeight(root);
        // Print the result
        System.out.println("Height of the tree: " + height);
    }
    private static TreeNode createTreeNode() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(11);
        root.right = new TreeNode(14);
        root.right.right = new TreeNode(3);
        root.right.right.left = new TreeNode(2);
        root.right.right.right = new TreeNode(17);
        return root;
    }
}