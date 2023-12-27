package com.scaler.core.java_3_advance_3.dsa_32_trees_2_views_and_types_of_binary_tree.assignment;

import com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.model.TreeNode;
import com.scaler.core.utils.PrintUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

/**
 * @created 02/04/23 12:51 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Vertical_Order_traversal {
    static class Tuple {
        TreeNode node;
        int row;
        int col;

        public Tuple(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    private static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        TreeMap<Integer, TreeMap<Integer, ArrayList<Integer>>> map = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<>();
        Tuple tuple = new Tuple(A, 0, 0);
        queue.add(tuple);
        while (!queue.isEmpty()) {
            tuple = queue.remove();
            TreeNode node = tuple.node;
            int x = tuple.row;
            int y = tuple.col;
            if (!map.containsKey(x)) {
                map.put(x, new TreeMap<>());
            }
            if (!map.get(x).containsKey(y)) {
                map.get(x).put(y, new ArrayList<>());
            }
            map.get(x).get(y).add(node.val);

            if (node.left != null) {
                queue.add(new Tuple(node.left, x - 1, y + 1));
            }
            if (node.right != null) {
                queue.add(new Tuple(node.right, x + 1, y + 1));
            }
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (TreeMap<Integer, ArrayList<Integer>> maps : map.values()) {
            result.add(new ArrayList<>());
            for (ArrayList<Integer> nodes : maps.values()) {
                for (int i = 0; i < nodes.size(); i++)
                    result.get(result.size() - 1).add(nodes.get(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(9);

        ArrayList<ArrayList<Integer>> results = verticalOrderTraversal(root);
        PrintUtils.print(results);
    }


}
