package com.scaler.core.java_3_advance_3.dsa_32_trees_2_views_and_types_of_binary_tree.homework;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_33_trees_1.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @created 02/04/23 6:14 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_ZigZag_Level_Order_Traversal_BT {
    private static int[][] zigzagLevelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(A);
        boolean flag = true;

        while (q.size() > 0) {
            int N = q.size();
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                TreeNode t = q.peek();
                if (t.left != null) q.add(t.left);
                if (t.right != null) q.add(t.right);
                if (flag == true) temp.add(q.poll().val);
                else temp.add(0, q.poll().val);
            }
            ans.add(temp);
            flag = !flag;
        }
        int[][] arr = ans.stream()
                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
        return arr;
    }
}
