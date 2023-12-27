package com.scaler.core.java_3_advance_3.dsa_35_trees_5_problems_on_trees;

import com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.model.TreeNode;

/**
 * @author Deepak Kumar Rai
 * @created 19/11/23
 * @project scaler_course_code
 */
public class Q1_PerfectBinaryTreeExample {
    /**
     * Perfect Binary Tree:
     * - A perfect binary tree is one is that all the non-leaf nodes have two children and
     * all leaf-nodes are at the same level.
     * **/
    private TreeNode root;

    public Q1_PerfectBinaryTreeExample() {
        this.root = null;
    }
    public void createPerfectBinaryTree() {
        // Level 0
        root = new TreeNode(1);
        // Level 1
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        // Level 2
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        // Level 3
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);
        root.right.left.left = new TreeNode(12);
        root.right.left.right = new TreeNode(13);
        root.right.right.left = new TreeNode(14);
        root.right.right.right = new TreeNode(15);
    }
    public void printPerfectBinaryTree() {
        printPerfectBinaryTree(root, 0);
    }
    private void printPerfectBinaryTree(TreeNode node, int level) {
        if (node == null) return;
        printPerfectBinaryTree(node.right, level + 1);
        for (int i = 0; i < level; i++) {
            System.out.print("\t");
        }
        System.out.println(node.val);
        printPerfectBinaryTree(node.left, level + 1);
    }
    public static void main(String[] args) {
        Q1_PerfectBinaryTreeExample tree = new Q1_PerfectBinaryTreeExample();

        tree.createPerfectBinaryTree();

        System.out.println("Perfect Binary Tree:");

        tree.printPerfectBinaryTree();
    }
}
