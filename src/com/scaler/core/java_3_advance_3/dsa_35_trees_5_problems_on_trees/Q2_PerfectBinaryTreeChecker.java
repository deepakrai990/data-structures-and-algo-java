package com.scaler.core.java_3_advance_3.dsa_35_trees_5_problems_on_trees;

import com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.model.TreeNode;

/**
 * @author Deepak Kumar Rai
 * @created 19/11/23
 * @project scaler_course_code
 */
public class Q2_PerfectBinaryTreeChecker {
    private TreeNode root;
    public Q2_PerfectBinaryTreeChecker() {
        this.root = null;
    }
    public boolean isPerfectBinaryTree() {
        int depth = findDepth(root);
        return isPerfectBinaryTree(root, depth, 0);
    }
    private int findDepth(TreeNode node) {
        if (node == null) return 0;
        int leftDepth = findDepth(node.left);
        int rightDepth = findDepth(node.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
    private boolean isPerfectBinaryTree(TreeNode node, int depth, int level) {
        if (node == null) return true;
        if (node.left == null && node.right == null) {
            return depth == level + 1;
        }
        if (node.left == null || node.right == null) {
            return false;
        }
        return isPerfectBinaryTree(node.left, depth, level + 1)
                && isPerfectBinaryTree(node.right, depth, level + 1);
    }

    public static void main(String[] args) {
        Q2_PerfectBinaryTreeChecker treeChecker = new Q2_PerfectBinaryTreeChecker();
        treeChecker.root = new TreeNode(1);
        treeChecker.root.left = new TreeNode(2);
        treeChecker.root.right = new TreeNode(3);
        treeChecker.root.left.left = new TreeNode(4);
        treeChecker.root.left.right = new TreeNode(5);
        treeChecker.root.right.left = new TreeNode(6);
        treeChecker.root.right.right = new TreeNode(7);

        boolean isPerfect = treeChecker.isPerfectBinaryTree();
        System.out.println("Is the given binary tree perfect? " + isPerfect);
    }
}
