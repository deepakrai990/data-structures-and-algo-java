package com.scaler.core.java_3_advance_3.dsa_34_trees_4_lowest_common_ancestor;

import com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.model.TreeNode;

/**
 * @author Deepak Kumar Rai
 * @created 11/11/23
 * @project scaler_course_code
 */
public class Q3_LowestCommonAncestorBST_2 {
    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        int rootVal = root.val;
        int pVal = p.val;
        int qVal = q.val;
        // If both nodes are in the left subtree
        if (pVal < rootVal && qVal < rootVal) {
            return lowestCommonAncestor(root.left, p, q);
        }
        // If both nodes are in the right subtree
        else if (pVal > rootVal && qVal > rootVal) {
            return lowestCommonAncestor(root.right, p, q);
        }
        // If one node is in the left subtree and the other is in the right subtree
        else {
            return root;
        }
    }

    public static void main(String[] args) {
        // Example Binary Search Tree
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(15);
        root.right.left = new TreeNode(25);
        root.right.right = new TreeNode(35);

        TreeNode p = root.left.left;  // Node with value 5
        TreeNode q = root.left.right; // Node with value 15

        TreeNode lca = lowestCommonAncestor(root, p, q);

        System.out.println("Lowest Common Ancestor of " + p.val + " and " + q.val + " is: " + lca.val);
    }
}
