package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_34_trees_2.homework;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_33_trees_1.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @created 17/03/23 5:58 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_ZigZag_Level_Order_Traversal_BT {
    public int[][] zigzagLevelOrder(TreeNode A) {
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
