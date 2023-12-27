package com.scaler.core.java_3_advance_3.dsa_34_trees_4_lowest_common_ancestor;

import com.scaler.core.java_3_advance_3.dsa_31_Trees_1_structure_of_binary_tree_and_tree_traversals.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Deepak Kumar Rai
 * @created 11/11/23
 * @project scaler_course_code
 */
public class Q3_Lowest_Common_Ancestor {
    /**
     * Lowest Common Ancestor: is defined between two nodes p and q as
     * the lowest node in the Tree. Which is ancestor to both p and q.
     * Note: A node can be ancestor to itself.
     * **/
    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathP = findPath(root, p);
        List<TreeNode> pathQ = findPath(root, q);
        // Find the last common node in the paths
        TreeNode lca = null;
        int minLength = Math.min(pathP.size(), pathQ.size());
        for (int i = 0; i < minLength; i++) {
            if (pathP.get(i) == pathQ.get(i)) {
                lca = pathP.get(i);
            } else {
                break;
            }
        }
        return lca;
    }
    private static List<TreeNode> findPath(TreeNode root, TreeNode target) {
        List<TreeNode> path = new ArrayList<>();
        searchBTHelper(root, target, path);
        return path;
    }

    private static boolean searchBTHelper(TreeNode root, TreeNode target, List<TreeNode> paths) {
        if (root == null) return false;
        if (root.val == target.val) {
            paths.add(root);
            return true;
        }
        paths.add(root);
        if (
                searchBTHelper(root.left, target, paths)
                || searchBTHelper(root.right, target, paths)
        ) {
            return true;
        }
        paths.remove(paths.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = createTree();
        TreeNode p = root.left.left;  // Node with value 5
        TreeNode q = root.left.right; // Node with value 15

        TreeNode lca = lowestCommonAncestor(root, p, q);

        System.out.println("Lowest Common Ancestor of " + p.val + " and " + q.val + " is: " + lca.val);
    }
    private static TreeNode createTree() {
        TreeNode root = new TreeNode(20);

        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(15);
        root.right.left = new TreeNode(25);
        root.right.right = new TreeNode(35);

        return root;
    }
}
