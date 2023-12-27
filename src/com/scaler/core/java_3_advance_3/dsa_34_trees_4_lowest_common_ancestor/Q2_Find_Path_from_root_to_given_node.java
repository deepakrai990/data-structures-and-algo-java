package com.scaler.core.java_3_advance_3.dsa_34_trees_4_lowest_common_ancestor;

import com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.model.TreeNode;
import com.scaler.core.utils.PrintUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Deepak Kumar Rai
 * @created 11/11/23
 * @project scaler_course_code
 */
public class Q2_Find_Path_from_root_to_given_node {
    /**
     * Question: Find a path from root to given node in Binary Tree
     * **/
    private static List<Integer> findPath(TreeNode root, int K) {
        List<Integer> paths = new ArrayList<>();
        searchBTHelper(root, K, paths);
        Collections.reverse(paths);
        return paths;
    }

    private static boolean searchBTHelper(TreeNode root, int K, List<Integer> paths) {
        if (root == null) return false;
        if (root.val == K) {
            paths.add(root.val);
            return true;
        }
        paths.add(root.val);
        if (searchBTHelper(root.left, K, paths) || searchBTHelper(root.right, K, paths)) {
            return true;
        }
        paths.remove(paths.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = createTree();
        int K = 6;
        List<Integer> paths = findPath(root, K);
        PrintUtils.print(paths);
    }
    private static TreeNode createTree() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(7);
        root.left.left = new TreeNode(9);
        root.left.left.left = new TreeNode(12);
        root.left.left.right = new TreeNode(19);

        root.right = new TreeNode(4);
        root.right.right = new TreeNode(18);
        root.right.left = new TreeNode(14);
        root.right.left.left = new TreeNode(15);
        root.right.left.right = new TreeNode(-12);
        root.right.left.right.right = new TreeNode(6);

        return root;
    }
}
