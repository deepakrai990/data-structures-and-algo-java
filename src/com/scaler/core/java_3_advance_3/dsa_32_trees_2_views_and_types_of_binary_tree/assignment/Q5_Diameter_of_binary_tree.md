### Q5. Diameter of binary tree
#### Problem Description
```text
Given a Binary Tree A consisting of N integer nodes, you need to find the diameter of 
the tree.

The diameter of a tree is the number of edges on the longest path between two nodes in 
the tree.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p> 0 &lt;= N &lt;= 10<sup>5</sup> </p>
</div>

```text
0 <= N <= 10^5
```
#### Input Format
```text
First and only Argument represents the root of binary tree A.
```
#### Output Format
```text
Return an single integer denoting the diameter of the tree.
```
#### Example Input
```text
Input 1:

           1
         /   \
        2     3
       / \
      4   5

Input 2:

            1
          /   \
         2     3
        / \     \
       4   5     6
```
#### Example Output
```text
Output 1:

 3
Output 2:

 4
```
#### Example Explanation
```text
Explanation 1:
    Longest Path in the tree is 4 -> 2 -> 1 -> 3 and the number of edges in this 
    path is 3 so diameter is 3.

Explanation 2:
    Longest Path in the tree is 4 -> 2 -> 1 -> 3 -> 6 and the number of edges in 
    this path is 4 so diameter is 4.
```
### Hints
* Hint 1
```text
Imagine how you would find the height of a tree and modify it a little bit to 
get the diameter.
```
* Solution Approach
```text
First, let’s see how to find the height or maxDepth of a tree:

1. If the tree is empty, then return 0
2. Else
    (a) Get the max depth of each subtree recursively.
    
    (b) Take the max depth and second max depth of any subtree. Get the max depth of 
        the right subtree recursively, i.e., call height( tree->right-subtree)
    
    (c) Get the max of max depths of left and right subtrees and add 1 to it for the 
        current node.
        max_depth = max(max dept of left subtree, max depth of right subtree) + 1
    
    (d) Return max_depth

Diameter of a tree can be calculated by only using the height function, because the 
diameter of a tree is nothing but maximum value of (left_height + right_height + 1) for 
each node. So we need to calculate this value (left_height + right_height + 1) for 
each node and update the result. Time complexity – O(N).
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
    static int diameter;
    public int solve(TreeNode A) {
        diameter = 0;
        height(A);
        return diameter;
    }
    public static int height(TreeNode root) {
        if (root == null)
            return -1;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        diameter = Math.max(diameter, 2 + leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
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
let diameter = 0;

function height(root) {
    if (root == null) {
        return -1;
    }
    let leftHeight = height(root.left);
    let rightHeight = height(root.right);
    diameter = Math.max(diameter, 2 + leftHeight + rightHeight);
    return 1 + Math.max(leftHeight, rightHeight);
}

module.exports = {
    //param A : root node of tree
    //return an integer
    solve: function (A) {
        diameter = 0;
        height(A);
        return diameter;
    }
};
```
* * Solution in C++
```cpp
int height(TreeNode * root, int & diameter) {
    if (root == NULL)
        return -1;
    int leftHeight = height(root -> left, diameter);
    int rightHeight = height(root -> right, diameter);
    diameter = max(diameter, 2 + leftHeight + rightHeight);
    return 1 + max(leftHeight, rightHeight);
}
int Solution::solve(TreeNode * A) {
    int diameter = INT_MIN;
    height(A, diameter);
    return diameter;
}
```

