package com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.assignment;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_33_trees_1.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @created 02/04/23 6:16 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Binary_Tree_From_Inorder_And_Postorder {
    private Map<Integer, Integer> map;
    private TreeNode buildTree(int[] A, int[] B) {
        return makeTree(A, B);
    }
    private TreeNode makeTree(int[] inorder, int[] postOrder) {
        map = new HashMap<>();
        int n = inorder.length;
        for(int i = 0; i < n; i++){
            map.put(inorder[i], i);
        }

        return buildTree(inorder, postOrder, 0, n-1, 0, n-1);

    }
    private TreeNode buildTree(int[] inorder, int[] postOrder, int si, int ei, int sp, int ep){
        if(ep < sp) return null; // base case

        int rootVal = postOrder[ep];
        int rootIndex = -1;
        if(map.containsKey(rootVal)){
            rootIndex = map.get(rootVal);
        }
        int boundary = (rootIndex - 1) - si + sp;
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(inorder, postOrder, si, rootIndex - 1, sp, boundary);
        root.right = buildTree(inorder, postOrder, rootIndex + 1, ei, boundary + 1, ep -1);
        return root;
    }

    private static TreeNode makeTree_1(int[] A, int[] B,int ins,int ine,int pos,int poe){
        if(ins>ine || pos>poe) return null;
        TreeNode root = new TreeNode(B[poe]);
        int idx = poe;
        for(int i = ins;i<=ine;i++){
            if(A[i]==B[poe]){
                idx = i;
            }
        }
        int poEnd = idx-ins-1+pos;
        int poStart = poe-(ine-idx);
        root.left = makeTree_1(A,B,ins,idx-1,pos,poEnd);
        root.right = makeTree_1(A,B,idx+1,ine,poStart,poe-1);
        return root;

    }
    private static TreeNode buildTree_1(int[] A, int[] B) {
        return makeTree_1(A,B,0,A.length-1,0,B.length-1);
    }

    public static void main(String[] args) {
        int[] A = {6, 1, 3, 2};
        int[] B = {6, 3, 2, 1};
        Q2_Binary_Tree_From_Inorder_And_Postorder solution = new Q2_Binary_Tree_From_Inorder_And_Postorder();
        TreeNode result = solution.buildTree(A, B);
        preOrder(result);

    }
    private static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
}
