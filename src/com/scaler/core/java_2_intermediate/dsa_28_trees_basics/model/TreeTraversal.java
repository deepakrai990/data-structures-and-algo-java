package com.scaler.core.java_2_intermediate.dsa_28_trees_basics.model;

/**
 * @created 28/12/22 1:19 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class TreeTraversal {
    private static void preorder(TreeNode root) {
        if (root == null) { return; }
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }
    private static void inorder(TreeNode root) {
        if (root == null) { return; }
        preorder(root.left);
        System.out.print(root.val + " ");
        preorder(root.right);
    }
    private static void postorder(TreeNode root) {
        if (root == null) { return; }
        preorder(root.left);
        preorder(root.right);
        System.out.print(root.val + " ");
    }
    private static int size(TreeNode root) {
        if (root == null) { return 0; }
        int left = size(root.left);
        int right = size(root.right);
        return left + right + 1;
    }
    private static int sum(TreeNode root) {
        if (root == null) { return 0; }
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        return leftSum + rightSum + root.val;
    }
    private static int height(TreeNode root) {
        if (root == null) { return -1; }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }
    public static void main(String[] args) {
        TreeNode tree = buildTreeNode();
        System.out.println("----------------------preorder----------------------");
        preorder(tree);
        System.out.println("\n----------------------inorder----------------------");
        inorder(tree);
        System.out.println("\n----------------------postorder----------------------");
        postorder(tree);
        System.out.println("\n----------------------size----------------------");
        int size = size(tree);
        System.out.println("Size = " + size);
        System.out.println("----------------------sum----------------------");
        int sum = sum(tree);
        System.out.println("Sum = " + sum);
        System.out.println("----------------------height----------------------");
        int height = height(tree);
        System.out.println("Height = " + height);
    }

    private static TreeNode buildTreeNode() {
        TreeNode root = new TreeNode(21);
        root.left = buildLeftTreeNode(24);
        root.left.left = buildLeftTreeNode(11);
        root.left.right = buildLeftTreeNode(10);
        root.left.right.left = buildLeftTreeNode(33);
        root.left.right.right = buildRightTreeNode(22);

        root.right = buildLeftTreeNode(44);
        root.right.left = buildLeftTreeNode(41);
        root.right.right = buildLeftTreeNode(14);
        root.right.right.right = buildLeftTreeNode(55);
        root.right.right.right.right = buildRightTreeNode(19);
        return root;
    }
    private static TreeNode buildLeftTreeNode(int value) {
        return new TreeNode(value);
    }
    private static TreeNode buildRightTreeNode(int value) {
        return new TreeNode(value);
    }
}
