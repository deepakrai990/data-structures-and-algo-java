package com.scaler.core.java_2_intermediate.dsa_28_trees_basics;

import com.scaler.core.java_2_intermediate.dsa_28_trees_basics.model.TreeNode;

/**
 * @author Deepak Kumar Rai
 * @created 08/01/24
 * @project scaler_course_code
 */
public class Q5_Tree_Path_Length {
    // Recursive function to calculate the length of the path
    private static int calculatePathLength(TreeNode root, int targetValue) {
        // Base case: return 0 for null nodes
        if (root == null) {
            return 0;
        }
        // Check if the current node is the target node
        if (root.val == targetValue) {
            return 1; // Count the current node
        }
        // Recursive calls for the left and right subtrees
        int leftLength = calculatePathLength(root.left, targetValue);
        int rightLength = calculatePathLength(root.right, targetValue);
        // If the target node is found in either subtree, add the length of the current node
        if (leftLength > 0 || rightLength > 0) {
            return 1 + Math.max(leftLength, rightLength);
        }
        // If the target node is not found in either subtree, return 0
        return 0;
    }
    public static void main(String[] args) {
        TreeNode root = createTreeNode();

        int targetValue = 17;
        int length = calculatePathLength(root, targetValue);
        System.out.println("Length of the path to node " + targetValue + ": " + length);
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
