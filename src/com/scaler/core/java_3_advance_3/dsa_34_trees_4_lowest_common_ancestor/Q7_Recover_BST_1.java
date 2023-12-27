package com.scaler.core.java_3_advance_3.dsa_34_trees_4_lowest_common_ancestor;

import com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.model.TreeNode;

/**
 * @author Deepak Kumar Rai
 * @created 19/11/23
 * @project scaler_course_code
 */
public class Q7_Recover_BST_1 {
    /**
     * Given a BST (Binary Search Tree), which is formed by swapping two distinct nodes.
     * Recover the Original BST (Binary Search Tree).
     * **/
    private TreeNode firstMisplaced, secondMisplaced, prev;
    public void recoverTree(TreeNode root) {
        // Initialize variables
        firstMisplaced = null;
        secondMisplaced = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        // Find misplaced nodes in the BST
        identifyMisplacedNodes(root);
        // Swap values of misplaced nodes to recover the original BST
        if (firstMisplaced != null && secondMisplaced != null) {
            int temp = firstMisplaced.val;
            firstMisplaced.val = secondMisplaced.val;
            secondMisplaced.val = temp;
        }
    }

    private void identifyMisplacedNodes(TreeNode root) {
        if (root == null) return;
        // In-order traversal to find misplaced nodes
        identifyMisplacedNodes(root.left);
        // Check if the current node is misplaced
        if (root.val < prev.val) {
            if (firstMisplaced == null) {
                firstMisplaced = prev;
            }
            secondMisplaced = root;
        }
        prev = root;
        identifyMisplacedNodes(root.right);
    }
    // Helper method to print in-order traversal of BST
    private void inOrderTraversal(TreeNode root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.val + " ");
            inOrderTraversal(root.right);
        }
    }
    public static void main(String[] args) {
        // Example usage
        Q7_Recover_BST_1 recoverBST = new Q7_Recover_BST_1();
        // Example BST with swapped nodes
        TreeNode root = createTree();

        System.out.println("Original BST:");
        recoverBST.inOrderTraversal(root);

        recoverBST.recoverTree(root);

        System.out.println("\nRecovered BST:");
        recoverBST.inOrderTraversal(root);
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
