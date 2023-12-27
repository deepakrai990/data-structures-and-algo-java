package com.scaler.core.java_3_advance_3.dsa_38_tries_2.homework;

import java.util.ArrayList; /**
 * @created 02/04/23 12:36 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Binary_tree_to_Circular_Doubly_Linked_List {
    class TreeNode {
        int val;
        TreeNode left, right;
        void ListNode(int x) {
            val = x;
            left = right = null;
        }
    }
    TreeNode solve (TreeNode root) {
        ArrayList<TreeNode> result = new ArrayList<>();
        inorderTraversal( root, result);
        int n = result.size();
        if(n == 0){
            return null;
        }
        TreeNode res = result.get(0);
        TreeNode NN = res;

        for(int i=1; i<n; i++){
            NN.right = result.get(i);
            NN = NN.right;
        }
        NN.right = res;
        return res;
    }
    public void inorderTraversal(TreeNode root, ArrayList<TreeNode> res){
        if(root == null){
            return;
        }
        inorderTraversal(root.left, res);
        res.add(root);
        inorderTraversal(root.right, res);
    }
}
