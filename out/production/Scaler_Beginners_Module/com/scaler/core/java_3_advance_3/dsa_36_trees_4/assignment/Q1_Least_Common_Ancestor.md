### Q1. Least Common Ancestor
#### Problem Description
```text
Find the lowest common ancestor in an unordered binary tree A, given 
two values, B and C, in the tree.

Lowest common ancestor: the lowest common ancestor (LCA) of two nodes 
and w in a tree or directed acyclic graph (DAG) is the 
lowest (i.e., deepest) node that has both v and w as descendants.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= size of tree &lt;= 100000</p>
    <p>1 &lt;= B, C &lt;= 10<sup>9</sup></p>
</div>

```text
1 <= size of tree <= 100000

1 <= B, C <= 10^9
```
#### Input Format
```text
First argument is head of tree A.

Second argument is integer B.

Third argument is integer C.
```
#### Output Format
```text
Return the LCA.
```
#### Example Input
```text
Input 1:
 
      1
     /  \
    2    3
B = 2
C = 3

Input 2:

      1
     /  \
    2    3
   / \
  4   5
B = 4
C = 5
```
#### Example Output
```text
Output 1:

 1
Output 2:

 2
```
#### Example Explanation
```text
Explanation 1:
    LCA is 1.

Explanation 2:
    LCA is 2.
```
### Hints
* Hint 1
```text
Bruteforce approach :
Pick every node. For every node, search for val1, val2 in the subtree. 
If val1 and val2 are found in the subtree, then the current node is 
definitely one of the ancestors. Also, track the depth of the 
current node. Pick the qualifying node of the highest depth.

Hint for a better solution :

    1) If you had the path from the nodes to the root, what property would 
       the path have? Can the paths be used to determine LCA?
    2) If you took a bottom-up approach using recursion, can you think of 
       a simple solution?
```
* Solution Approach
```text
Linear solution using path calculation :

    1) Find a path from the root to n1 and store it in a vector or array.
    
    2) Find a path from the root to n2 and store it in another vector or array.
    
    3) Traverse both paths till the values in arrays are the same. Return 
       the common element just before the mismatch

Linear solution using recursion :

We traverse from the bottom, and once we reach a node that matches 
one of the two nodes, we pass it up to its parent. The parent will 
then test its left and right subtree if each contains one of the 
two nodes. If yes, then the parent must be the LCA, and we pass its 
parent up to the root. If not, we pass the lower node, which contains 
either one of the two nodes (if the left or right subtree contains 
either p or q) or NULL (if both the left and right subtree does not 
contain either p or q) up.
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
/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

public class Solution {
    public static TreeNode LCA(TreeNode root, int val1, int val2) {
        if (root == null)
            return null;
        if (root.val == val1 || root.val == val2)
            return root;
        TreeNode l = LCA(root.left, val1, val2);
        TreeNode r = LCA(root.right, val1, val2);
        if (l != null && r != null)
            return root;
        if (l != null)
            return l;
        return r;
    }
    public static boolean find(TreeNode root, int val1) {
        if (root == null)
            return false;
        if (root.val == val1)
            return true;
        return (find(root.left, val1) || find(root.right, val1));
    }
    public int lca(TreeNode A, int B, int C) {
        int val1 = B;
        int val2 = C;
        TreeNode root = A;
        if (find(root, val1) == false || find(root, val2) == false) 
            return -1;
        TreeNode ans = LCA(root, val1, val2);
        if (ans == null) 
            return -1;
        return ans.val;
    }
}
```
* * Solution in Javascript
```javascript
function path(root, s, val) {
  if (root == null) return false;
  s.push(root.data);
  if (root.data == val) return true;
  if (
    (root.left != null && path(root.left, s, val)) ||
    (root.right != null && path(root.right, s, val))
  )
    return true;
  s.pop();
  return false;
}

module.exports = {
  lca: function (root, val1, val2) {
    let s1 = [];
    let s2 = [];

    if (path(root, s1, val1) == false || path(root, s2, val2) == false)
      return -1;
    let i = 0;
    while (i < s1.length && i < s2.length) {
      if (s1[i] != s2[i]) break;
      i += 1;
    }
    return s1[i - 1];
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
TreeNode * LCA(TreeNode * root, int val1, int val2) {
    if (!root)
        return NULL;
    if (root -> val == val1 || root -> val == val2) 
        return root;
    TreeNode * L = LCA(root -> left, val1, val2);
    TreeNode * R = LCA(root -> right, val1, val2);
    if (L && R) 
        return root; // If val1, val2 are on both sides 
    return L ? L : R; // either one of val1, val2 is on one side OR val1, val2 is not in L&R subtrees
}

bool find(TreeNode * root, int val1) {
    if (!root) 
        return false;
    if (root -> val == val1) 
        return true;
    return (find(root -> left, val1) || find(root -> right, val1));
}

int Solution::lca(TreeNode * A, int B, int C) {
    int val1 = B;
    int val2 = C;
    TreeNode * root = A;
    if (!find(root, val1) || !find(root, val2)) 
        return -1;
    TreeNode * ans = LCA(root, val1, val2);
    if (!ans) 
        return -1;
    return ans -> val;
}
```

