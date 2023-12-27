package com.scaler.core.java_3_advance_3.dsa_35_trees_5_problems_on_trees;

import com.scaler.core.java_3_advance_3.dsa_35_trees_5_problems_on_trees.model.TreeNode;

/**
 * @author Deepak Kumar Rai
 * @created 20/11/23
 * @project scaler_course_code
 */
public class Q3_Fill_next_in_a_perfect_BT {
    /**
     * Question: Fill next in a perfect BT (Binary Tree)
     * Note: Every node points to the next node horizontally.
     * **/
    private static void fillNext(TreeNode root) {
        if (root == null) return;
        TreeNode t = root;
        while (t.left != null) {
            TreeNode s = t;
            while (t != null) {
                t.left.next = t.right;
                if (t.next != null) {
                    t.right.next = t.next.left;
                }
                t = t.next;
            }
            t = s.left;
        }
    }
    public static void main(String[] args) {
        TreeNode root = createTree();

        fillNext(root);

        TreeNode node = root;
        while (node != null) {
            TreeNode currentLevel = node;
            while (currentLevel != null) {
                System.out.print(currentLevel.val + " ");
                currentLevel = currentLevel.next;
            }
            System.out.println();
            node = node.left;
        }
    }

    private static TreeNode createTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        return root;
    }
}
