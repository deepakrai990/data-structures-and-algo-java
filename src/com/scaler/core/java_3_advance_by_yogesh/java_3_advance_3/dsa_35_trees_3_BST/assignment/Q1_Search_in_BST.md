### Q1. Search in BST
#### Problem Description
```text
Given a Binary Search Tree A. Check whether there exists a node with 
value B in the BST.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= Number of nodes in binary tree &lt;= 10<sup>5</sup></p>
    <p>0 &lt;= B &lt;= 10<sup>6</sup></p>
</div>

```text
1 <= Number of nodes in binary tree <= 10^5

0 <= B <= 10^6
```
#### Input Format
```text
First argument is a root node of the binary tree, A.

Second argument is an integer B.
```
#### Output Format
```text
Return 1 if such a node exist and 0 otherwise
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

     B = 16

Input 2:

            8
           / \
          6  21
         / \
        1   7

     B = 9
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
    Node with value 16 is present.

Explanation 2:
    There is no node with value 9.
```
### Hints
* Hint 1
```text
We will traverse the nodes and try to find a node with value B
```
* Solution Approach
```text
For a node, we check if its value is equal to B.
If the value is less than B, then we check in the right subtree of the node.
If the value if more than B, then we check in the left subtree of the node.


Time Complexity: O(N)
Space Complexity : O(1)

where N is the number of nodes in the BST
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
    public int solve(TreeNode A, int B) {
        while (A != null && A.val != B) {
            A = (A.val > B) ? A.left : A.right;
        }
        return A != null ? 1 : 0;
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
int Solution::solve(TreeNode* A, int B) {
    while (A != NULL && A->val != B) {
        A = (A->val > B) ? A->left : A->right;
    }
    return A ? 1 : 0;
}
```

