package com.scaler.core.java_3_advance_3.dsa_32_trees_2_views_and_types_of_binary_tree;

import com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.model.TreeNode;

import java.util.*;

/**
 * @author Deepak Kumar Rai
 * @created 07/11/23
 * @project scaler_course_code
 */

public class Q2_Binary_Tree_Diagonal_Traversal {
    static class Pair {
        TreeNode node;
        int horizontalDistance;
        Pair(TreeNode node, int horizontalDistance) {
            this.node = node;
            this.horizontalDistance = horizontalDistance;
        }
    }
    private static List<List<Integer>> diagonalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Map<Integer, List<Integer>> diagonalMap = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            TreeNode node = pair.node;
            int horizontalDistance = pair.horizontalDistance;
            // Add the current node to the diagonal list
            diagonalMap.putIfAbsent(horizontalDistance, new ArrayList<>());
            diagonalMap.get(horizontalDistance).add(node.val);
            if (node.left != null) {
                queue.offer(new Pair(node.left, horizontalDistance + 1));
            }
            if (node.right != null) {
                queue.offer(new Pair(node.right, horizontalDistance));
            }
        }
        // Convert the diagonal map to the result list
        for (int i = 0; diagonalMap.containsKey(i); i++) {
            result.add(diagonalMap.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = createTree();
        List<List<Integer>> result = diagonalTraversal(root);
        for (List<Integer> diagonal : result) {
            System.out.println(diagonal);
        }
    }

    private static TreeNode createTree() {
        TreeNode root = new TreeNode(9);
        root.left = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(9);
        root.left.left.left.right = new TreeNode(14);
        root.left.left.right = new TreeNode(11);

        root.left.right = new TreeNode(3);
        root.left.right.left = new TreeNode(5);
        root.left.right.left.right = new TreeNode(19);

        root.right = new TreeNode(4);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(1);
        root.right.right.left = new TreeNode(12);

        return root;
    }

}
