package com.scaler.core.java_3_advance_3.dsa_34_trees_4_lowest_common_ancestor;

import com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.model.TreeNode;
import com.scaler.core.utils.PrintUtils;

/**
 * @author Deepak Kumar Rai
 * @created 11/11/23
 * @project scaler_course_code
 */
public class Q4_How_many_nodes_are_at_a_distance_K {
    /**
     * Given a source node (address of node), how many nodes are at a distance K.
     * Note 1: All nodes should be below source node.
     * Note 2: Distance is calculated based on edge.
     * **/
    private static int findNodesAtDistanceK(TreeNode source, int K) {
        if (source == null) return 0;
        if (K == 0) return 1;
        int left = findNodesAtDistanceK(source.left, K - 1);
        int right = findNodesAtDistanceK(source.right, K - 1);
        return left + right;
    }
    /**
     * T.C: O(N)
     * S.C: O(min (height, K))
     * **/
    public static void main(String[] args) {
        TreeNode source = createTree();
        int K = 2;
        int nodes = findNodesAtDistanceK(source, K);
        PrintUtils.print(nodes);
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
