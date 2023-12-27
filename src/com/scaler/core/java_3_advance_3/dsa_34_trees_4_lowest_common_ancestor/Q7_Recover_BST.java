package com.scaler.core.java_3_advance_3.dsa_34_trees_4_lowest_common_ancestor;

import com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.model.TreeNode;
import com.scaler.core.utils.PrintUtils;

/**
 * @author Deepak Kumar Rai
 * @created 19/11/23
 * @project scaler_course_code
 */
public class Q7_Recover_BST {
    /**
     * Given a BST (Binary Search Tree), which is formed by swapping two distinct nodes.
     * Recover the Original BST (Binary Search Tree).
     * **/
    private TreeNode left;
    private TreeNode right;
    private TreeNode prev;
    private int[] recoverTree(TreeNode root) {
        int[] res = new int[2];
        dfs(root);
        if (left == null) return res;
        int tmp = left.val;
        left.val = right.val;
        right.val = tmp;
        res[0] = left.val;
        res[1] = right.val;
        return res;
    }
    private void dfs(TreeNode node) {
        if (node == null)
            return;
        dfs(node.left);
        if (prev != null) {
            if (node.val < prev.val) {
                if (left == null) {
                    left = prev;
                    right = node;
                } else {
                    right = node;
                }
            }
        }
        prev = node;
        dfs(node.right);
    }

    public static void main(String[] args) {
        Q7_Recover_BST recoverBst = new Q7_Recover_BST();
        TreeNode root = createTree();
        int[] results = recoverBst.recoverTree(root);
        PrintUtils.print(results);
    }
    private static TreeNode createTree() {
        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(14);
        root.left.right.left = new TreeNode(7);

        root.right = new TreeNode(15);
        root.right.right = new TreeNode(20);
        root.right.right.left = new TreeNode(19);

        root.right.left = new TreeNode(13);
        root.right.left.right = new TreeNode(9);

        return root;
    }
}
