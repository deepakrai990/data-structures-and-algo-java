package com.scaler.core.java_3_advance_3.dsa_32_trees_2_views_and_types_of_binary_tree.assignment;

import com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.model.TreeNode;
import com.scaler.core.utils.PrintUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @created 02/04/23 12:52 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Top_View_of_Binary_tree {
    private static int[] solve(TreeNode A) {
        Queue<TreeNode> leftQueue = new LinkedList<>();
        Queue<TreeNode> rightQueue = new LinkedList<>();

        leftQueue.add(A.left);
        rightQueue.add(A.right);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(A.val);

        //first process all the leftNodes.
        while (!leftQueue.isEmpty()) {
            TreeNode node = leftQueue.poll();
            if (node == null) break;
            leftQueue.add(node.left);
            list.add(node.val);
        }
        //then process all the right.
        while (!rightQueue.isEmpty()) {
            TreeNode node = rightQueue.poll();
            if (node == null) break;
            rightQueue.add(node.right);
            list.add(node.val);
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);

        int[] result = solve(root);
        PrintUtils.print(result);
    }
}
