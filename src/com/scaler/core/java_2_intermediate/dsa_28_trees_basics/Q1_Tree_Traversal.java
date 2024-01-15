package com.scaler.core.java_2_intermediate.dsa_28_trees_basics;


import com.scaler.core.java_2_intermediate.dsa_28_trees_basics.model.TreeNode;

/**
 * @author Deepak Kumar Rai
 * @created 27/12/23
 * @project scaler_course_code
 */
public class Q1_Tree_Traversal {
    private static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    private static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    private static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }
    public static void main(String[] args) {
        TreeNode root = createTreeNode();
        System.out.println("-------------------Tree Traversal pre-order-------------------");
        preOrder(root);
        System.out.println("\n-------------------Tree Traversal in-order-------------------");
        inOrder(root);
        System.out.println("\n-------------------Tree Traversal post-order-------------------");
        postOrder(root);
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
