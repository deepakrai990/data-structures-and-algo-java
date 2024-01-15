package com.scaler.core.java_2_intermediate.dsa_28_trees_basics;

import com.scaler.core.java_2_intermediate.dsa_28_trees_basics.model.TreeNode;

/**
 * @author Deepak Kumar Rai
 * @created 08/01/24
 * @project scaler_course_code
 */
public class Q2_Tree_Size {
    private static int calculateTreeSize(TreeNode root) {
        // Base case
        if (root == null) {
            return 0;
        }
        int left = calculateTreeSize(root.left);
        int right = calculateTreeSize(root.right);
        return left + right + 1;
    }
    public static void main(String[] args) {
        TreeNode root = createTreeNode();

        int size = calculateTreeSize(root);
        System.out.println("Size of the tree: " + size);
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
