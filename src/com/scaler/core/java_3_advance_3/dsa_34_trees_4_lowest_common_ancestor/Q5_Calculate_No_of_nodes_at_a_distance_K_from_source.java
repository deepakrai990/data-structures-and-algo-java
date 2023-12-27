package com.scaler.core.java_3_advance_3.dsa_34_trees_4_lowest_common_ancestor;

import com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.model.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Deepak Kumar Rai
 * @created 11/11/23
 * @project scaler_course_code
 */
public class Q5_Calculate_No_of_nodes_at_a_distance_K_from_source {
    /**
     * Question: Calculate the number of nodes at a distance K from source.
     * Note 1: Only source node value is given, we need to search it first.
     * Note 2: Binary Tree contains unique values.
     * **/
    private static int countNodes(TreeNode root, int sourceVal, int K) {
        // Step 1: Path from source to root
        List<TreeNode> p = getPath(root, sourceVal);
        // We have the path from source to root node in p
        TreeNode sourceNode = findSourceNode(root, sourceVal);
        int count = below(sourceNode, K);
        for (int i = 1; i < p.size(); i++) {
            // Node = p[i], dist = K - i
            if (K - i == 0) {
                count = count + 1;
                break;
            }
            // Node is p[i], one of it's children is p[i - 1]
            if (p.get(i).left.val == p.get(i - 1).val) { // go right and search
                count = count + below(p.get(i).right, K - i - 1);
            } else { // got left and search
                count = count + below(p.get(i).left, K - i - 1);
            }
        }
        return count;
    }
    private static List<TreeNode> getPath(TreeNode root, int K) {
        List<TreeNode> paths = new ArrayList<>();
        searchBTHelper(root, K, paths);
        Collections.reverse(paths);
        return paths;
    }

    private static boolean searchBTHelper(TreeNode root, int K, List<TreeNode> paths) {
        if (root == null) return false;
        if (root.val == K) {
            paths.add(root);
            return true;
        }
        paths.add(root);
        if (searchBTHelper(root.left, K, paths) || searchBTHelper(root.right, K, paths)) {
            return true;
        }
        paths.remove(paths.size() - 1);
        return false;
    }
    private static TreeNode findSourceNode(TreeNode root, int sourceNodeValue) {
        if (root == null) return null;
        if (root.val == sourceNodeValue) return root;
        TreeNode sourceNodeInLeftSubtree = findSourceNode(root.left, sourceNodeValue);
        if (sourceNodeInLeftSubtree != null) {
            return sourceNodeInLeftSubtree;
        }
        TreeNode sourceNodeInRightSubtree = findSourceNode(root.right, sourceNodeValue);
        if (sourceNodeInRightSubtree != null) {
            return sourceNodeInRightSubtree;
        }
        return null;
    }
    private static int below(TreeNode source, int K) {
        if (source == null) return 0;
        if (K == 0) return 1;
        int left = below(source.left, K - 1);
        int right = below(source.right, K - 1);
        return left + right;
    }

    public static void main(String[] args) {
        TreeNode root = createTree();
        int sourceNodeValue = 4;
        int K = 2;
        int numberOfNodesAtDistanceK = countNodes(root, sourceNodeValue, K);

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
