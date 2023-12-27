package com.scaler.core.java_3_advance_3.dsa_38_tries_2.assignment;

import com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.model.TreeNode;

import java.util.ArrayList;

/**
 * @created 02/04/23 12:35 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_Nodes_Distance_K_in_Binary_Tree {
    ArrayList<Integer> ans = new ArrayList<>();

    public int[] solve(TreeNode A, int B, int C) {
        solve1(A, B, C);
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
    // this function is just to add all the nodes present at a given distance from the node we have passed.
    private void justAdd(TreeNode root, int dist) {
        if (root == null || dist < 0) {
            return;
        }
        if (dist == 0) {
            ans.add(root.val);
            return;
        }
        justAdd(root.left, dist - 1);
        justAdd(root.right, dist - 1);
    }

    private int solve1(TreeNode root, int target, int dist) {
        if (root == null) {
            return 0;
        }
        if (root.val == target) {
            justAdd(root, dist); // add all the subtree nodes at distance “dist”
            return 1; // returning one because we found the target node now while backtraking i will use this & calculate the distance of the current node from target node
        }
        int left = solve1(root.left, target, dist); // now eighter target is present on left
        int right = solve1(root.right, target, dist); // or right
        if (left == dist || right == dist) { // left or right has returned the value dist that means the currnent node is at required distance so add it
            ans.add(root.val);
        }
        if (left > 0) {
            justAdd(root.right, dist - left - 1);  // now if positive value is coming from left then we can say that
            //we found the node in the left at distance “left” .Now search is der any element on right at distance “dist - left - 1” if yes add it;
            return left + 1;
        }
        if (right > 0) {
            justAdd(root.left, dist - right - 1); // do the same way for the right way as well;
            return right + 1;
        }
        return 0;
    }
}
