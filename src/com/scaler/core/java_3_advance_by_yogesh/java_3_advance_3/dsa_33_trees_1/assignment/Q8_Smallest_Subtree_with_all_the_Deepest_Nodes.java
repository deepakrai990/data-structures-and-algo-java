package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_33_trees_1.assignment;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_33_trees_1.model.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @created 14/03/23 4:05 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q8_Smallest_Subtree_with_all_the_Deepest_Nodes {
    TreeNode ref = null;
    int maxDepth = -2;

    public TreeNode solve(TreeNode A) {

        findH(A, 0);
        return ref;
    }

    public int findH(TreeNode A, int deepth) {
        if (A == null) return deepth;
        int Dl = findH(A.left, deepth + 1);
        int Dr = findH(A.right, deepth + 1);
        if (Dl == Dr && maxDepth <= Dl) {
            maxDepth = Dl;
            ref = A;
        }
        return Math.max(Dl, Dr);
    }

    public class Solution {
        HashMap<Integer, ArrayList<TreeNode>> depthMap = new HashMap<>();
        int maxDepth = 0;

        public TreeNode solve(TreeNode A) {
            fillDepthMap(A, 0);

            ArrayList<TreeNode> maxDepthList = depthMap.get(maxDepth);

            for (int i = maxDepth; i >= 0; i--) {
                ArrayList<TreeNode> depthList = depthMap.get(i);
                for (int j = 0; j < depthList.size(); j++) {
                    TreeNode temp = depthList.get(j);
                    if (containsAll(temp, maxDepthList)) {
                        return temp;
                    }
                }
            }

            return null;
        }

        public void fillDepthMap(TreeNode A, int d) {
            if (A == null) return;
            if (A.val == -1) return;

            if (depthMap.containsKey(d)) {
                ArrayList<TreeNode> depthList = depthMap.get(d);
                depthList.add(A);
                depthMap.put(d, depthList);
            } else {
                ArrayList<TreeNode> depthList = new ArrayList<>();
                depthList.add(A);
                depthMap.put(d, depthList);
            }

            maxDepth = Math.max(maxDepth, d);
            fillDepthMap(A.left, d + 1);
            fillDepthMap(A.right, d + 1);
        }

        public boolean containsAll(TreeNode A, ArrayList<TreeNode> depthList) {
            boolean ans = true;
            for (int i = 0; i < depthList.size(); i++) {
                TreeNode temp = depthList.get(i);
                if (!check(A, temp.val)) {
                    ans = false;
                    break;
                }
            }
            return ans;
        }

        public boolean check(TreeNode A, int k) {
            if (A == null) return false;
            if (A.val == -1) return false;
            if (A.val == k) return true;
            return check(A.left, k) || check(A.right, k);
        }
    }
}
