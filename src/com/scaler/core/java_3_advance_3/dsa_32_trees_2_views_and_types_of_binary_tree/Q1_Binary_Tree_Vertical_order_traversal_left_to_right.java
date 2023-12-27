package com.scaler.core.java_3_advance_3.dsa_32_trees_2_views_and_types_of_binary_tree;

import com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.model.TreeNode;

import java.util.*;

/**
 * @created 22/04/23 11:10 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Binary_Tree_Vertical_order_traversal_left_to_right {
    static class Pair {
        TreeNode node;
        int level;
        Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
    private static void verticalOrderTraversalLeftToRight(TreeNode root) {
        int minLevel = 0, maxLevel = 0;
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            TreeNode node = pair.node;
            int levelOder = pair.level;
            List<Integer> list = new ArrayList<>();
            if (hashMap.containsKey(levelOder)) {
                list = hashMap.get(levelOder);
                list.add(node.val);
                hashMap.replace(levelOder, list);
            } else {
                list.add(node.val);
                hashMap.put(levelOder, list);
            }
            minLevel = Math.min(minLevel, levelOder);
            maxLevel = Math.max(maxLevel, levelOder);
            if (node.left != null) queue.add(new Pair(node.left, levelOder - 1));
            if (node.right != null) queue.add(new Pair(node.right, levelOder + 1));
        }
        for (int i = minLevel; i <= maxLevel; i++) {
            List<Integer> results = hashMap.get(i);
            for (int result: results) {
                System.out.print(result + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------Top View-----------------");
        for (int i = minLevel; i <= maxLevel; i++) {
            List<Integer> results = hashMap.get(i);
            // print a fist element of the list for top view
            System.out.print(results.get(0) + " ");
        }
        System.out.println();
        System.out.println("---------------Bottom View---------------");
        for (int i = minLevel; i <= maxLevel; i++) {
            List<Integer> results = hashMap.get(i);
            // print a last element of the list for bottom view
            System.out.print(results.get(results.size() - 1) + " ");
        }
        System.out.println();

    }
    public static void main(String[] args) {
        TreeNode root = createTree();
        verticalOrderTraversalLeftToRight(root);
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
