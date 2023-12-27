package com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.assignment;


import com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.model.TreeNode;
import com.scaler.core.utils.PrintUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @created 02/04/23 6:17 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Level_Order {
    private static int[][] solve(TreeNode A) {
        return levelOrder(A);
    }
    private static int[][] levelOrder(TreeNode root) {
        List<int[]> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int n = q.size();
            int[] level = new int[n];
            for (int i = 0; i < n; i++) {
                TreeNode temp = q.remove();
                level[i] = temp.val;

                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
            }
            list.add(level);
        }

        int n = list.size();
        int[][] ans = new int[n][];
        int index = 0;
        for (int[] level : list) {
            ans[index++] = level;
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int[][] results = solve(root);
        PrintUtils.print(results);
    }
}
