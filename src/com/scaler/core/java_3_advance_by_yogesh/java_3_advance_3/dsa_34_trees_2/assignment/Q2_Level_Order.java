package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_34_trees_2.assignment;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_33_trees_1.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @created 16/03/23 10:16 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Level_Order {

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
}
