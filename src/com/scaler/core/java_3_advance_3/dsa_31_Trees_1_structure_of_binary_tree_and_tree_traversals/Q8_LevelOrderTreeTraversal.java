package com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals;

import com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @created 20/04/23 9:09 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q8_LevelOrderTreeTraversal {
    private static void levelOrder_1(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode firstTree = queue.poll();
            System.out.print(firstTree.val + " ");
            if (firstTree.left != null) {
                queue.add(firstTree.left);
            }
            if (firstTree.right != null) {
                queue.add(firstTree.right);
            }
        }
    }
    private static void levelOrder_2(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 1; i <= n; i++) {
                TreeNode firstTree = queue.poll();
                System.out.print(firstTree.val + " ");
                if (firstTree.left != null) {
                    queue.add(firstTree.left);
                }
                if (firstTree.right != null) {
                    queue.add(firstTree.right);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TreeNode root = createTree();
        levelOrder_1(root);
        System.out.println("\n-------------------------------------");
        TreeNode root1 = createTree();
        levelOrder_2(root1);
    }
    private static TreeNode createTree() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(12);
        root.left.right = new TreeNode(-9);
        root.left.right.left = new TreeNode(4);

        root.right = new TreeNode(6);
        root.right.left = new TreeNode(-1);
        root.right.right = new TreeNode(10);

        root.right.left.left = new TreeNode(15);

        root.right.right.left = new TreeNode(9);
        root.right.right.left.right = new TreeNode(19);

        return root;
    }
}
