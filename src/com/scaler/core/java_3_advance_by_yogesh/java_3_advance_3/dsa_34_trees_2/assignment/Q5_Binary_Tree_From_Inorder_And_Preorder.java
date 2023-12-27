package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_34_trees_2.assignment;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_33_trees_1.model.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @created 16/03/23 10:18 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q5_Binary_Tree_From_Inorder_And_Preorder {
    /**
     * Definition for binary tree
     * class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) {
     * val = x;
     * left=null;
     * right=null;
     * }
     * }
     */
    HashMap<Integer, Integer> hm = new HashMap<>();

    public TreeNode create(int[] A, int[] B, int Ps, int Pe, int Is, int Ie) {
        if (Ps > Pe || Is > Ie) return null;

        TreeNode root = new TreeNode(A[Ps]);
        int rootIndex = hm.get(A[Ps]);

        int elements_in_Lst = rootIndex - Is;

        root.left = create(A, B, Ps + 1, Ps + elements_in_Lst, Is, rootIndex - 1);
        root.right = create(A, B, Ps + elements_in_Lst + 1, Pe, rootIndex + 1, Ie);

        return root;
    }

    public TreeNode buildTree(int[] A, int[] B) {
        // Ps = preorder start, Pe = preorder end, Is = inorder start, Ie = inorder end
        int Ps = 0, Pe = A.length - 1, Is = 0, Ie = B.length - 1;
        for (int i = 0; i < B.length; i++) {
            hm.putIfAbsent(B[i], i);
        }
        return create(A, B, Ps, Pe, Is, Ie);
    }

    public TreeNode buildTree_1(ArrayList<Integer> A, ArrayList<Integer> B) {
        return Helper(A, B);
    }

    public TreeNode Helper(ArrayList<Integer> A, ArrayList<Integer> B) {
        if (A == null || B == null || A.size() != B.size())
            return null;

        //Generate a HM of Inorder elements
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < B.size(); i++) {
            map.putIfAbsent(B.get(i), i);
        }
        // Very Important: Pass value by reference
        int[] preRootIndex = new int[1];
        preRootIndex[0] = 0;
        int inorderStart = 0;
        int inorderEnd = A.size() - 1;

        return GenerateTree(A, B, preRootIndex, inorderStart, inorderEnd, map, A.size());
    }

    public TreeNode GenerateTree(ArrayList<Integer> preorder, ArrayList<Integer> inorder, int[] preRootIndex,
                                 int inorderStart, int inorderEnd, HashMap<Integer, Integer> map, int N) {
        if (preRootIndex[0] >= N || inorderStart > inorderEnd)
            return null;
        // Get the first node of the PreOrder as it is the root node
        // TreeNode rootNode = new TreeNode(preorder.get(preRootIndex[0]));

        // Get the position of root node in Inorder
        // For INORDER, Determine the boundary of the left and right subtree of the current node
        //int inorderRootIdx = map.get(preorder.get(preRootIndex[0]));

        int element = preorder.get(preRootIndex[0]++);
        TreeNode rootNode = new TreeNode(element);
        int inorderRootIdx = map.get(element);

        // Increment the index here, so that you don’t need to increment it in the function call.
        // preRootIndex[0]++;
        rootNode.left = GenerateTree(preorder, inorder, preRootIndex, inorderStart, inorderRootIdx - 1, map, N);
        rootNode.right = GenerateTree(preorder, inorder, preRootIndex, inorderRootIdx + 1, inorderEnd, map, N);
        return rootNode;
    }
}
