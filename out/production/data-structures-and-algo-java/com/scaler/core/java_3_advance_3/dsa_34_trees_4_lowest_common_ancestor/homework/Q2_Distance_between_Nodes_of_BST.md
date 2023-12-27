### Q2. Distance between Nodes of BST
#### Problem Description
```text
Given a binary search tree.

Return the distance between two nodes with given two keys B and C. 
It may be assumed that both keys exist in BST.

NOTE: Distance between two nodes is number of edges between them.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= Number of nodes in binary tree &lt;= 1000000</p>
    <p>0 &lt;= node values &lt;= 10<sup>9</sup> </p>
</div>

```text
1 <= Number of nodes in binary tree <= 1000000

0 <= node values <= 10^9
```
#### Input Format
```text
First argument is a root node of the binary tree, A.

Second argument is an integer B.

Third argument is an integer C.
```
#### Output Format
```text
Return an integer denoting the distance between two nodes with given 
two keys B and C
```
#### Example Input
```text
Input 1:
    
         5
       /   \
      2     8
     / \   / \
    1   4 6   11
 B = 2
 C = 11

Input 2:
    
         6
       /   \
      2     9
     / \   / \
    1   4 7   10
 B = 2
 C = 6
```
#### Example Output
```text
Output 1:
 3

Output 2:
 1
```
#### Example Explanation
```text
Explanation 1:
    Path between 2 and 11 is: 2 -> 5 -> 8 -> 11. Distance will be 3.

Explanation 2:
    Path between 2 and 6 is: 2 -> 6. Distance will be 1
```
### Hints
* Hint 1
```text
This problem can be easily solved in O(n).

Think of optimizing, as we sometime need only to go on 
the left side or right side.
```
* Solution Approach
```text
An efficient way to solve the above problem:

We start from the root and for every node, we do following.

If both keys are greater than the current node, we move to 
the right child of the current node.

If both keys are smaller than current node, we move to 
left child of current node.

If one keys is smaller and other key is greater, current node 
is Lowest Common Ancestor (LCA) of two nodes. We find distances 
of current node from two keys and return sum of the distances.

Time Complexity : O(h) (height of Tree)
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
    public int solve(TreeNode root, int a, int b) {
        int temp = 0;
        if (a > b) {
            temp = a;
            a = b;
            b = temp;
        }
        return distanceBetween2(root, a, b);
    }
    public static int distanceFromRoot(TreeNode root, int x) {
        if (root.val == x)
            return 0;
        else if (root.val > x)
            return 1 + distanceFromRoot(root.left, x);
        return 1 + distanceFromRoot(root.right, x);
    }
    public static int distanceBetween2(TreeNode root, int a, int b) {
        if (root == null)
            return 0;
        if (root.val > a && root.val > b)
            return distanceBetween2(root.left, a, b);
        if (root.val < a && root.val < b)
            return distanceBetween2(root.right, a, b);
        if (root.val >= a && root.val <= b)
            return distanceFromRoot(root, a) + distanceFromRoot(root, b);
        return 0;
    }
}
```
* * Solution in Javascript
```javascript
function lca(root, node1, node2) {
  while (true) {
    if (root.data > node1 && root.data > node2) {
      root = root.left;
    } else if (root.data < node1 && root.data < node2) {
      root = root.right;
    } else {
      return root;
    }
  }
}
function getDistance(src, dest) {
  if (src.data == dest) return 0;
  let node = src.left;
  if (src.data < dest) {
    node = src.right;
  }
  return 1 + getDistance(node, dest);
}

module.exports = {
  solve: function (root, node1, node2) {
    if (root == null) return -1;
    let la = lca(root, node1, node2);
    return getDistance(la, node1) + getDistance(la, node2);
  },
};
```
* * Solution in C++
```cpp
int distanceFromRoot(TreeNode * root, int x) {
    if (root -> val == x)
        return 0;
    else if (root -> val > x)
        return 1 + distanceFromRoot(root -> left, x);
    return 1 + distanceFromRoot(root -> right, x);
}

int distanceBetween2(TreeNode * root, int a, int b) {
    if (!root)
        return 0;
    if (root -> val > a && root -> val > b)
        return distanceBetween2(root -> left, a, b);
    if (root -> val < a && root -> val < b)
        return distanceBetween2(root -> right, a, b);
    if (root -> val >= a && root -> val <= b)
        return distanceFromRoot(root, a) +
            distanceFromRoot(root, b);
}
int Solution::solve(TreeNode * A, int B, int C) {
    if (B > C)
        swap(B, C);
    return distanceBetween2(A, B, C);
}
```

