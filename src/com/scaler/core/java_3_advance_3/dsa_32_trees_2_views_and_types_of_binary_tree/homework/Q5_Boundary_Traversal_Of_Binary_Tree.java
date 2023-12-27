package com.scaler.core.java_3_advance_3.dsa_32_trees_2_views_and_types_of_binary_tree.homework;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_33_trees_1.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @created 02/04/23 6:15 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q5_Boundary_Traversal_Of_Binary_Tree {
    private static int[] solve(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(A.val);
        Left(A.left, ans);
        leaf(A, ans);
        Right(A.right, ans);
        int[] arr = ans.stream().mapToInt(i -> i).toArray();
        return arr;
    }

    private static void Left(TreeNode A, ArrayList<Integer> ans) {
        if (A == null || A.left == null && A.right == null) {
            return;
        }
        ans.add(A.val);
        if (A.left != null) {
            Left(A.left, ans);
        }
    }

    private static void Right(TreeNode A, ArrayList<Integer> ans) {
        if (A == null || A.left == null && A.right == null) {
            return;
        }
        if (A.right != null) {
            Right(A.right, ans);
        }
        ans.add(A.val);
    }

    private static void leaf(TreeNode A, ArrayList<Integer> ans) {
        if (A == null) {
            return;
        }
        if (A.left == null && A.right == null) {
            ans.add(A.val);
            return;
        }
        leaf(A.left, ans);
        leaf(A.right, ans);
    }

    private static ArrayList<Integer> solve_1(TreeNode A) {
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<Integer> lv = new ArrayList<>();
        ArrayList<Integer> rv = new ArrayList<>();
        ArrayList<Integer> bv = new ArrayList<>();

        q.add(A);
        while(q.size()>0){
            int n = q.size();
            int k =0;
            for(int i=1; i<=n; i++){
                TreeNode top = q.peek();
                if(top.right==null && top.left==null){
                    bv.add(k, top.val);  // to add bv in sequence of level, i.e. higher order will be added first
                    k++;
                }
                else{
                    if(i==1){
                        lv.add(top.val);
                    }
                    if(n>1 && i==n){
                        rv.add(0, top.val);  // to maintain reverse right view
                    }
                }

                if(top.left!=null){
                    q.add(top.left);
                }
                if(top.right!=null){
                    q.add(top.right);
                }

                q.remove();
            }
        }
        ArrayList<Integer> ans = lv;
        ans.addAll(bv);
        ans.addAll(rv);

        return ans;
    }
}
