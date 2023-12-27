### Q5. Identical Binary Trees
#### Problem Description
```text
Given two binary trees, check if they are equal or not.

Two binary trees are considered equal if they are structurally 
identical and the nodes have the same value.
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
The first argument is a root node of the first tree, A.

The second argument is a root node of the second tree, B.
```
#### Output Format
```text
Return 0 / 1 ( 0 for false, 1 for true ) for this problem.
```
#### Example Input
```text
Input 1:

   1       1
  / \     / \
 2   3   2   3
Input 2:

   1       1
  / \     / \
 2   3   3   3
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
    Both trees are structurally identical and the nodes have the same value.

Explanation 2:
    Values of the left child of the root node of the trees are different.
```
### Hints
* Hint 1
```text
Think about solving recursively.

Call each left and right child simultaneously and check 
that both are the same or not.
```
* Solution Approach
```text
When are the two trees the same?
When the root values are the same, the left subtree of both trees is 
the same, and the right subtree of both trees is the same.

Can you think of a straightforward recursive solution based on the above fact?
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
    public int isSameTree(TreeNode A, TreeNode B) {
        return sameTree(A, B);
    }

    public int sameTree(TreeNode A, TreeNode B) {
        if (A == null && B == null)
            return 1;
        if (A == null || B == null)
            return 0;
        if (A.val != B.val)
            return 0;

        int num = 1;
        num = num & sameTree(A.left, B.left) & sameTree(A.right, B.right);
        return num;
    }
}
```
* * Solution in Javascript
```javascript
// Definition for a  binary tree node
//     function TreeNode(data){
//         this.data = data
//         this.left = null
//         this.right = null
//}

module.exports = {
    //param a : root node of tree
    //param b : root node of tree
    //return an integer
    isSameTree: function (a, b) {
        var recF = function (rootA, rootB) {
            if (rootA === null && rootB === null) {
                return true;
            } else if (rootA === null || rootB === null) {
                return false;
            } else {
                return rootA.data === rootB.data && recF(rootA.left, rootB.left) && recF(rootA.right, rootB.right);
            }
        };
        return recF(a, b) ? 1 : 0;
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
int Solution::isSameTree(TreeNode * p, TreeNode * q) {
    if (p == NULL && q == NULL)
        return true;
    if (p == NULL || q == NULL)
        return false;
    return ((p -> val == q -> val) && isSameTree(p -> left, q -> left) && isSameTree(p -> right, q -> right));
}
```

