package com.scaler.core.java_3_advance_3.dsa_34_trees_4_lowest_common_ancestor;

import com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.model.TreeNode;

/**
 * @author Deepak Kumar Rai
 * @created 11/11/23
 * @project scaler_course_code
 */
public class Q5_Calculate_No_of_nodes_at_a_distance_K_from_source_1 {
    public static int findNumberOfNodesAtDistanceKFromSource(TreeNode root, int sourceNodeValue, int k) {
        if (root == null) return 0;
        /*
         * If the current node is the source node, return the number of nodes in its subtree
         * at a distance k from the root.
         * */
        if (root.val == sourceNodeValue) {
            return findNumberOfNodesAtDistanceKFromRoot(root, k);
        }
        // Find the number of nodes in the left and right subtrees at a distance k from the source node.
        int leftSubtreeCount = findNumberOfNodesAtDistanceKFromSource(root.left, sourceNodeValue, k);
        int rightSubtreeCount = findNumberOfNodesAtDistanceKFromSource(root.right, sourceNodeValue, k);
        /*
         * If the current node is an ancestor of the source node, return the number of nodes in
         * its subtree at a distance k from the root, plus the number of nodes in its left and right subtrees
         * at a distance k - 1 from the source node.
         **/
        if (leftSubtreeCount > 0 || rightSubtreeCount > 0) {
            return 1 + leftSubtreeCount + rightSubtreeCount;
        } else {
            return 0;
        }
    }
    private static int findNumberOfNodesAtDistanceKFromRoot(TreeNode root, int k) {
        if (root == null) return 0;
        if (k == 0) return 1;
        int left = findNumberOfNodesAtDistanceKFromRoot(root.left, k - 1);
        int right = findNumberOfNodesAtDistanceKFromRoot(root.right, k - 1);
        return left + right;
    }

    public static void main(String[] args) {
        TreeNode root = createTree();
        int sourceNodeValue = 4;
        int K = 2;
        int numberOfNodesAtDistanceK = findNumberOfNodesAtDistanceKFromSource(root, sourceNodeValue, K);

        System.out.println("The number of nodes at a distance " + K + " from the source node is: "
                + numberOfNodesAtDistanceK);
    }
    private static TreeNode createTree() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        return root;
    }
}
