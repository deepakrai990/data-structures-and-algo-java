package com.scaler.core.java_3_advance_3.dsa_32_trees_2_views_and_types_of_binary_tree;

import com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.model.TreeNode;

/**
 * @author Deepak Kumar Rai
 * @created 06/11/23
 * @project scaler_course_code
 */
public class Q4_Construct_the_Tree_from_postOrder_and_inOrder_array {
    /**
     * Given postOrder abd inOrder arrays. Construct the tree.
     * **/
    private static TreeNode generateTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }

        int n = inorder.length;
        return buildTreeHelper(inorder, 0, n - 1, postorder, 0, n - 1);
    }

    private static TreeNode buildTreeHelper(int[] inorder, int inStart, int inEnd, int[] postorder,
                                     int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = inStart;
        while (inorder[rootIndex] != rootVal) {
            rootIndex++;
        }

        int leftSubtreeSize = rootIndex - inStart;
        root.left = buildTreeHelper(inorder, inStart, rootIndex - 1, postorder, postStart,
                postStart + leftSubtreeSize - 1);
        root.right = buildTreeHelper(inorder, rootIndex + 1, inEnd, postorder,
                postStart + leftSubtreeSize, postEnd - 1);

        return root;
    }

    // Helper method to print the tree (in-order traversal)
    private static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        printTree(root.left);
        System.out.print(root.val + " ");
        printTree(root.right);
    }

    public static void main(String[] args) {
        int[] postorder = {4, -9, 12, 15, -1, 19, 9, 10, 6, 5};
        int[] inorder = {12, 4, -9, 5, 15, -1, 6, 9, 19, 10};

        TreeNode root = generateTree(inorder, postorder);

        System.out.println("In-order traversal of the constructed tree:");
        printTree(root);
    }
}
