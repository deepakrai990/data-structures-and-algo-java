### Q4. Balanced Binary Tree
#### Problem Description
```text
Given a root of binary tree A, determine if it is height-balanced.

A height-balanced binary tree is defined as a binary tree in which the depth of the 
two subtrees of every node never differ by more than 1.
```
#### Problem Constraints
```text
1 <= size of tree <= 100000
```
#### Input Format
```text
First and only argument is the root of the tree A.
```
#### Output Format
```text
Return 0 / 1 ( 0 for false, 1 for true ) for this problem.
```
#### Example Input
```text
Input 1:

    1
   / \
  2   3

Input 2:
 
       1
      /
     2
    /
   3
```
#### Example Output
```text
Output 1:
 1

Output 2:
 0
```
#### Example Explanation
```text
Explanation 1:
    It is a complete binary tree.

Explanation 2:
    Because for the root node, left subtree has depth 2 and right subtree has depth 0. 
    Difference = 2 > 1. 
```
### Hints
* Hint 1
```text
Think recursively.

How can you maintain the depth of subtree of every node?
```
* Solution Approach
```text
A tree is balanced if :
1) Left subtree is balanced
2) Right subtree is balanced
3) The difference in the height of the left and right subtree is at most 1.

Can you think of a way to simulate that with recursion?

Note that depth of a tree can also be calculated recursively 
as max(depth(rightSubtree), depth(leftSubtree)) + 1.
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
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    int balanced = 1;

    public int isBalanced(TreeNode A) {
        balanced(A);
        return balanced;
    }

    public int balanced(TreeNode A) {
        if (A == null)
            return 0;

        int heightLeft = 1 + balanced(A.left);
        int heightRight = 1 + balanced(A.right);

        if (Math.abs(heightLeft - heightRight) > 1)
            balanced = 0;
        return Math.max(heightLeft, heightRight);
    }
}
```
* * Solution in Javascript
```javascript
// Definition for a  binary tree node
//    function TreeNode(data){
//      this.data = data
//      this.left = null
//      this.right = null
//    }
let balanced = 1;

function findHeight(root) {
    if (!root) {
        return 0;
    }
    if (balanced === 0) {
        return;
    }
    let leftHeight = findHeight(root.left);
    let rightHeight = findHeight(root.right);
    let diff = Math.abs(leftHeight - rightHeight);
    if (diff > 1) {
        balanced = 0;
    }
    return Math.max(leftHeight, rightHeight) + 1;
}
module.exports = {
    //param A : root node of tree
    //return an integer
    isBalanced: function (root) {
        balanced = 1;
        findHeight(root);
        return balanced;
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
pair < int, bool > isBalancedWithDepth(TreeNode * root) {
    if (root == NULL) return make_pair(0, true);
    pair < int, bool > left = isBalancedWithDepth(root -> left);
    pair < int, bool > right = isBalancedWithDepth(root -> right);
    int depth = max(right.first, left.first) + 1;
    // The subtree is balanced if right subtree is balanced, left subtree is balanced 
    // and the depth difference is less than 1. 
    bool isbalanced = right.second && left.second && (abs(right.first - left.first) < 2);
    return make_pair(depth, isbalanced);
}
int Solution::isBalanced(TreeNode * A) {
    TreeNode * root;
    root = A;
    if (root == NULL)
        return true;
    return isBalancedWithDepth(root).second;
}
```

