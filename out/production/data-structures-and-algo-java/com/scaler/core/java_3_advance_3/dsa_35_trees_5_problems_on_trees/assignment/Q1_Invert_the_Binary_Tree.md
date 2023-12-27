### Q1. Invert the Binary Tree
#### Problem Description
```text
Given a binary tree A, invert the binary tree and return it.

Inverting refers to making the left child the right child and vice versa.
```
#### Problem Constraints
```text
1 <= size of tree <= 100000
```
#### Input Format
```text
First and only argument is the head of the tree A.
```
#### Output Format
```text
Return the head of the inverted tree.
```
#### Example Input
```text
Input 1:
 
     1
   /   \
  2     3

Input 2:
 
     1
   /   \
  2     3
 / \   / \
4   5 6   7
```
#### Example Output
```text
Output 1:
 
     1
   /   \
  3     2

Output 2:
 
     1
   /   \
  3     2
 / \   / \
7   6 5   4
```
#### Example Explanation
```text
Explanation 1:
    Tree has been inverted.

Explanation 2:
    Tree has been inverted.
```
### Hints
* Hint 1
```text
Think recursively.

You need to invert the left and right subtree on every node 
and then swap them.
```
* Solution Approach
```text
Think recursively.

You need to invert the left and right subtree on every node 
and then swap them.
```
* Complete Solution
* * Solution in Java
```java
/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public TreeNode invertTree(TreeNode A) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }
}
```
* * Solution in Javascript
```javascript
function solve(root) {
    if (root == null) return root;
    [root.left, root.right] = [solve(root.right), solve(root.left)];
    return root;
}

module.exports = {
    invertTree: function (A) {
        return solve(A);
    }
};
```
* * Solution in C++
```cpp
/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
TreeNode * Solution::invertTree(TreeNode * A) {
    TreeNode * root = A;
    if (!root) 
        return root;
    root -> left = invertTree(root -> left);
    root -> right = invertTree(root -> right);
    TreeNode * temp = root -> left;
    root -> left = root -> right;
    root -> right = temp;
    return root;
}
```

