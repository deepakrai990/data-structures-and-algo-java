package com.scaler.core.java_3_advance_3.dsa_32_trees_2_views_and_types_of_binary_tree.homework;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_33_trees_1.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @created 02/04/23 6:14 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Odd_and_Even_Levels {
    private static int solve(TreeNode A) {
        return oddAndEvenLevels(A);
    }
    private static int oddAndEvenLevels(TreeNode root) {
        if (root == null)
            return 0;
        int odd = 0;
        int even = 0;
        int level = 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();
            if(level % 2 == 0) {
                for (int i = 0; i < n; i++) {
                    TreeNode temp = q.remove();
                    even += temp.val;
                    if (temp.left != null)
                        q.add(temp.left);
                    if (temp.right != null)
                        q.add(temp.right);
                }
            } else {
                for (int i = 0; i < n; i++) {
                    TreeNode temp = q.remove();
                    odd += temp.val;
                    if (temp.left != null)
                        q.add(temp.left);
                    if (temp.right != null)
                        q.add(temp.right);
                }
            }
            level++;
        }
        return even - odd;
    }
}
