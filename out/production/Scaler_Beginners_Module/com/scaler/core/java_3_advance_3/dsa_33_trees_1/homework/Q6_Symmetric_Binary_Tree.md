### Q6. Symmetric Binary Tree
#### Problem Description
```text
Given a binary tree, check whether it is a mirror of itself 
(i.e., symmetric around its center).
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= number of nodes &lt;= 10<sup>5</sup></p>
</div>

```text
1 <= number of nodes <= 10^5
```
#### Input Format
```text
First and only argument is the root node of the binary tree.
```
#### Output Format
```text
Return 0 / 1 ( 0 for false, 1 for true ).
```
#### Example Input
```text
Input 1:

    1
   / \
  2   2
 / \ / \
3  4 4  3

Input 2:

    1
   / \
  2   2
   \   \
   3    3
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
    The above binary tree is symmetric. 

Explanation 2:
    The above binary tree is not symmetric.
```
### Hints
* Hint 1
```text
Think of recursion. How can you use it to simulate the 
symmetry check of two trees?
```
* Solution Approach
```text
2 trees, T1 and T2, are symmetric if
1) value of T1’s root is the same as T2’s root
2) T1’s left and T2’s right are symmetric.
3) T2’s left and T1’s right are symmetric.

Can you use the above fact to model an easy recursion-based solution?
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
    public int isSymmetric(TreeNode A) {
        if (A == null)
            return 0;
        return rec(A.left, A.right) ? 1 : 0;
    }
    public boolean rec(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null)
            return true;
        if (node1 == null || node2 == null)
            return false;
        if (node1.val != node2.val)
            return false;
        return rec(node1.left, node2.right) | rec(node1.right, node2.left);
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
const helper = function (p, q) {
    if (p == null && q == null)
        return true;
    if (p == null || q == null)
        return false;
    return p.val == q.val && helper(p.left, q.right) && helper(p.right, q.left)
}
module.exports = {
    //param A : root node of tree
    //return an integer
    isSymmetric: function (root) {
        if (helper(root, root) == true) {
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
bool isSymmetricHelper(TreeNode * leftTree, TreeNode * rightTree) {
    if (leftTree == NULL || rightTree == NULL)
        return leftTree == rightTree;
    if (leftTree -> val != rightTree -> val)
        return false;
    return isSymmetricHelper(leftTree -> left, rightTree -> right) && isSymmetricHelper(leftTree -> right, rightTree -> left);
}
int Solution::isSymmetric(TreeNode * A) {
    return A == NULL || isSymmetricHelper(A -> left, A -> right);
}
```

