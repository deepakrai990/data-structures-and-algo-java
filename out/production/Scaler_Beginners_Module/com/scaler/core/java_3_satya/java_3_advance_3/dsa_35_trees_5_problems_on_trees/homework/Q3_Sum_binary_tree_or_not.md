### Q3. Sum binary tree or not
#### Problem Description
```text
Given a binary tree. Check whether the given tree is a Sum-binary Tree or not.

Sum-binary Tree is a Binary Tree where the value of a every 
node is equal to sum of the nodes present in its left subtree 
and right subtree.

An empty tree is Sum-binary Tree and sum of an empty tree can 
be considered as 0. A leaf node is also considered as SumTree.

Return 1 if it sum-binary tree else return 0.
```
#### Problem Constraints
```text
1 <= length of the array <= 100000

0 <= node values <= 50
```
#### Input Format
```text
The only argument given is the root node of tree A.
```
#### Output Format
```text
Return 1 if it is sum-binary tree else return 0.
```
#### Example Input
```text
Input 1:

       26
     /    \
    10     3
   /  \     \
  4   6      3

Input 2:

       26
     /    \
    10     3
   /  \     \
  4   6      4
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
    All leaf nodes are considered as SumTree. 
    Value of Node 10 = 4 + 6.
    Value of Node 3 = 0 + 3 
    Value of Node 26 = 20 + 6 

Explanation 2:
    Sum of left subtree and right subtree is 27 which is not equal to 
    the value of root node which is 26.
```
### Hints
* Hint 1
<div>
    <p>A simple solution is to check for every node is their sub-tree 
    sum is equal to value of that node. But it will take O(n<sup>2</sup>)</p>
    <p>To optimize it, think of storing the sum of subTree at the node.</p>
</div>

```text
A simple solution is to check for every node is their sub-tree sum is 
equal to value of that node. But it will take O(n^2)

To optimize it, think of storing the sum of subTree at the node.
```
* Solution Approach

<div>
    <p>A simple solution is to check for every node is their sub-tree 
    sum is equal to value of that node. But it will take O(n<sup>2</sup>)
    </p>
    <p>An efficient approach is to store sum of subtree at the node, 
    so we don’t need to calculate it again and again.</p>
    <p>1) If the node is a leaf node then sum of subtree rooted with 
    this node is equal to value of this node.<br>
    2) If the node is not a leaf node then sum of subtree rooted with 
    this node is twice the value of this node (Assuming that the tree 
    rooted with this node is SumTree).</p>
    <p>If all nodes are sumTree return 1 else return 0.</p>
</div>

```text
A simple solution is to check for every node is their sub-tree sum 
is equal to value of that node. But it will take O(n^2)

An efficient approach is to store sum of subtree at the node, 
so we don’t need to calculate it again and again.

1) If the node is a leaf node then sum of subtree rooted with 
   this node is equal to value of this node.

2) If the node is not a leaf node then sum of subtree rooted 
   with this node is twice the value of this node (Assuming 
   that the tree rooted with this node is SumTree).

If all nodes are sumTree return 1 else return 0.
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
    public int solve(TreeNode A) {
        return checksumtree(A);
    }
    public static int isLeaf(TreeNode node) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return 1;
        return 0;
    }
    public static int isSumTree(TreeNode node) {
        int ls, rs;
        if (node == null || isLeaf(node) == 1)
            return 1;

        if (isSumTree(node.left) == 1 && isSumTree(node.right) == 1) {
            if (node.left == null)
                ls = 0;
            else if (isLeaf(node.left) == 1)
                ls = node.left.val;
            else
                ls = 2 * (node.left.val);
            if (node.right == null)
                rs = 0;
            else if (isLeaf(node.right) == 1)
                rs = node.right.val;
            else
                rs = 2 * (node.right.val);
            if (node.val == ls + rs)
                return 1;
            else
                return 0;
        }
        return 0;
    }

    public static int checksumtree(TreeNode root) {
        if (isSumTree(root) == 1)
            return 1;
        return 0;
    }
}
```
* * Solution in Javascript
```javascript
function sum(node) {
  if (node == null) {
    return 0;
  }
  return sum(node.left) + node.data + sum(node.right);
}

function isSumTree(node) {
  let ls, rs;

  if (node == null || (node.left == null && node.right == null)) {
    return 1;
  }

  ls = sum(node.left);
  rs = sum(node.right);

  if (
    node.data == ls + rs &&
    isSumTree(node.left) != 0 &&
    isSumTree(node.right) != 0
  ) {
    return 1;
  }
  return 0;
}

module.exports = {
  solve: function (A) {
    return isSumTree(A);
  },
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

int isLeaf(TreeNode * node) {
    if (node == NULL)
        return 0;
    if (node -> left == NULL && node -> right == NULL)
        return 1;
    return 0;
}

int isSumTree(TreeNode * node) {
    int ls;
    int rs;
    if (node == NULL || isLeaf(node))
        return 1;
    if (isSumTree(node -> left) && isSumTree(node -> right)) {
        if (node -> left == NULL)
            ls = 0;
        else if (isLeaf(node -> left))
            ls = node -> left -> val;
        else
            ls = 2 * (node -> left -> val);
        if (node -> right == NULL)
            rs = 0;
        else if (isLeaf(node -> right))
            rs = node -> right -> val;
        else
            rs = 2 * (node -> right -> val);
        return (node -> val == ls + rs);
    }

    return 0;
}

int checksumtree(TreeNode * root) {
    if (isSumTree(root))
        return 1;
    return 0;
}
int Solution::solve(TreeNode * A) {
    return checksumtree(A);
}
```

