### Q3. LCA in BST
#### Problem Description
```text
Given a Binary Search Tree A. Also given are two nodes B and C. 
Find the lowest common ancestor of the two nodes.

Note 1 :- It is guaranteed that the nodes B and C exist.

Note 2 :- The LCA of B and C in A is the shared ancestor 
          of B and C that is located farthest from the root.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= Number of nodes in binary tree &lt;= 10<sup>5</sup></p>
    <p>1 &lt;= B , C &lt;= 10<sup>5</sup></p>
</div>

```text
1 <= Number of nodes in binary tree <= 10^5

1 <= B , C <= 10^5
```
#### Input Format
```text
First argument is a root node of the binary tree, A.

Second argument is an integer B.

Third argument is an integer C.
```
#### Output Format
```text
Return the LCA of the two nodes
```
#### Example Input
```text
Input 1:

            15
          /    \
        12      20
        / \    /  \
       10  14  16  27
      /
     8

     B = 8
     C = 20

Input 2:

            8
           / \
          6  21
         / \
        1   7

     B = 7
     C = 1
```
#### Example Output
```text
Output 1:
 15

Output 2:
 6
```
#### Example Explanation
```text
Explanation 1:
    The LCA of node 8 and 20 is the node 15.

Explanation 2:
    The LCA of node 7 and 1 is the node 6.
```
### Hints
* Hint 1
```text
For a node in BST, the values of all the nodes in the right subtree 
are greater and those in the left subtree are lesser than its own value.
```
* Solution Approach
```text
For Binary search tree, while traversing the tree from top to bottom 
the first node whose value lies in the range [min(B, C), max(B, C)] is 
the LCA of B and C.

So just recursively traverse the BST , if current node value is 
greater than both B and C, then the LCA lies in the left subtree of 
the current node. If it is smaller than both B and C, then the LCA 
lies on the right subtree. Otherwise, the current node is the LCA

Time Complexity : O(H)
Space Complexity : O(H)
where H is the height of the BST
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
    public int solve(TreeNode A, int B, int C) {
        if (A.val > B && A.val > C)
        return solve(A.left, B, C);
 
        if (A.val < B && A.val < C)
            return solve(A.right, B, C);
     
        return A.val;
    }
}
```
* * Solution in Javascript
```javascript
/** Not available **/
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
int Solution::solve(TreeNode* A, int B, int C) {
    if (A->val > B && A->val > C)
        return solve(A->left, B, C);
 
    if (A->val < B && A->val < C)
        return solve(A->right, B, C);
 
    return A->val;
}

```

