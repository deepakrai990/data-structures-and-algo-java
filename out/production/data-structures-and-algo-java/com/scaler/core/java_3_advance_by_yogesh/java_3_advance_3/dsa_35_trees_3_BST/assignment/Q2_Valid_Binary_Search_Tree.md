### Q2. Valid Binary Search Tree
#### Problem Description
```text
You are given a binary tree represented by root A.

Assume a BST is defined as follows:

1) The left subtree of a node contains only nodes with keys less than 
   the node's key.

2) The right subtree of a node contains only nodes with keys greater 
   than the node's key.

3) Both the left and right subtrees must also be binary search trees.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= Number of nodes in binary tree &lt;= 10<sup>5</sup></p>
    <p>0 &lt;= node values &lt;= 2<sup>32</sup>-1</p>
</div>

```text
1 <= Number of nodes in binary tree <= 10^5

0 <= node values <= 2^32 - 1
```
#### Input Format
```text
First and only argument is head of the binary tree A.
```
#### Output Format
```text
Return 0 if false and 1 if true.
```
#### Example Input
```text
Input 1:
 
   1
  /  \
 2    3

Input 2:
 
  2
 / \
1   3
```
#### Example Output
```text
Output 1:
 0

Output 2:
 1
```
#### Example Explanation
```text
Explanation 1:
    2 is not less than 1 but is in left subtree of 1.

Explanation 2:
    Satisfies all conditions.
```
### Hints
* Hint 1
```text
For a Binary Search Tree, we can check two conditions:

    1. At each node, the left subtree is also a Binary Search Tree, and 
       the max value in the left subtree is smaller than the node.
    
    2. At each node, the right subtree is also a Binary Search Tree, and 
       the min value in the right subtree is greater than the node.
```
* Solution Approach
```text
As mentioned in the hints, we can check two conditions for a 
valid Binary Search Tree.

    1. At each node, the left subtree is also a Binary Search Tree, and 
       the max value in the left subtree is smaller than the node.
    
    2. At each node, the right subtree is also a Binary Search Tree, and 
       the min value in the right subtree is greater than the node.

The trick is when we traverse down the tree, maintain max and min 
allowed values for the subtree, and check that the node’s value 
should lie between the allowed max and min. The initial values 
for min and max should be INT_MIN and INT_MAX.

If at the current node, allowed min is minn and allowed max is maxx.

If we move to the left, then the max value in the left subtree 
should be smaller than the node. So, update maxx = min(maxx, value of node).

Similarly, If we move to the right, the min value in the right subtree 
should be greater than the node.So, update minn = max(minn, value of node).

In this, we are traversing each node only once. So, 
the time complexity is O(n).
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
    public int isValidBST(TreeNode A) {
        if (isValid(A, Long.MIN_VALUE, Long.MAX_VALUE))
            return 1;
        return 0;
    }
    public static boolean isValid(TreeNode A, long l, long r) {
        if (A == null)
            return true;
        if (A.val > l && A.val < r) {
            boolean left = isValid(A.left, l, A.val);
            boolean right = isValid(A.right, A.val, r);
            return (left && right);
        } else
            return false;
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
const isValidBSTHelper = (root, low, high) => {
    if (!root) {
        return true;
    }
    return root.data > low && root.data < high &&
        isValidBSTHelper(root.left, low, root.data) &&
        isValidBSTHelper(root.right, root.data, high);
}
module.exports = {
    //param A : root node of tree
    //return an integer
    isValidBST: function (A) {
        if (isValidBSTHelper(A, -Infinity, Infinity) == true) {
            return 1;
        }
        return 0;
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
/*
 * Returns the pair of following : 
 * min : Minimum of the values in the subtree with root as 'root'
 * max : Maximum of the values in the subtree with root as 'root'
 * isBST : bool indicating if the subtree is a BST
 */
pair < pair < int, int > , bool > isBST(TreeNode * root) {
    if (root == NULL) return make_pair(make_pair(-1, -1), true);
    // Leaf node 
    if (root -> left == NULL && root -> right == NULL) return make_pair(make_pair(root -> val, root -> val), true);

    pair < pair < int, int > , bool > result, result2;
    // If left tree is NULL. Tree is BST if min of the right subtree is greater than node's value
    if (!root -> left) {
        result = isBST(root -> right);
        return make_pair(make_pair(
                root -> val,
                result.first.second),
            result.second && result.first.first > root -> val);
    }
    // If right subtree is NULL. Tree is BST if max of the left subtree is less than node's value
    if (!root -> right) {
        result = isBST(root -> left);
        return make_pair(make_pair(
                result.first.first,
                root -> val),
            result.second && result.first.second < root -> val);
    }
    // Combination of the above 2 cases
    result = isBST(root -> left);
    result2 = isBST(root -> right);
    return make_pair(make_pair(
            result.first.first,
            result2.first.second),
        result.second && result2.second && result.first.second < root -> val && result2.first.first > root -> val);
}
int Solution::isValidBST(TreeNode * A) {
    return isBST(A).second;
}

```

