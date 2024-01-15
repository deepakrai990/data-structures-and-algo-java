package com.scaler.core.java_2_intermediate.dsa_28_trees_basics;

import com.scaler.core.java_2_intermediate.dsa_28_trees_basics.model.TreeNode;

/**
 * @author Deepak Kumar Rai
 * @created 08/01/24
 * @project scaler_course_code
 */
public class Q3_Tree_Sum {
    // Recursive function to calculate the sum of all nodes in the tree
    private static int calculateTreeSum(TreeNode root) {
        // Base case: return 0 for null nodes
        if (root == null) {
            return 0;
        }
        // Recursive calls for the left and right subtrees
        int leftSum = calculateTreeSum(root.left);
        int rightSum = calculateTreeSum(root.right);
        // Return the total sum of the tree including the current node
        return leftSum + rightSum + root.val;
    }
    public static void main(String[] args) {
        TreeNode root = createTreeNode();

        int sum = calculateTreeSum(root);
        System.out.println("Sum of all nodes in the tree: " + sum);
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
