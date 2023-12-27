### Q2. BST nodes in a range
#### Problem Description
```text
Given a binary search tree of integers. You are given a range B and C.

Return the count of the number of nodes that lie in the given range.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= Number of nodes in binary tree &lt;= 100000</p>
    <p>0 &lt;= B &lt; = C &lt;= 10<sup>9</sup> </p>
</div>

```text
1 <= Number of nodes in binary tree <= 100000

0 <= B < = C <= 10^9
```
#### Input Format
```text
First argument is a root node of the binary tree, A.

Second argument is an integer B.

Third argument is an integer C.
```
#### Output Format
```text
Return the count of the number of nodes that lies in the given range.
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

     B = 12
     C = 20

Input 2:

            8
           / \
          6  21
         / \
        1   7

     B = 2
     C = 20
```
#### Example Output
```text
Output 1:
 5

Output 2:
 3
```
#### Example Explanation
```text
Explanation 1:
    Nodes which are in range [12, 20] are : [12, 14, 15, 20, 16]

Explanation 2:
    Nodes which are in range [2, 20] are : [8, 6, 7]
```
### Hints
* Hint 1
```text
The idea is to traverse the given binary search tree starting from the root. 
```
* Solution Approach
```text
The idea is to traverse the given binary search tree starting from the root.

For every node being visited, check if this node lies in range,

if yes, then add 1 to the result and recur for both of its children.

If the current node is smaller than the low value of the range, then recur 
for the right child; else recur for the left child.
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
    static int ans = 0;
    public int solve(TreeNode A, int B, int C) {
        ans = 0;
        traverse(A, B, C);
        return ans;
    }
    public static void traverse(TreeNode a, int B, int C) {
        if (a == null)
            return;
        if (a.val >= B && a.val <= C)
            ans++;
        traverse(a.left, B, C);
        traverse(a.right, B, C);
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
module.exports = {
    //param A : root node of tree
    //param B : integer
    //param C : integer
    //return an integer
    solve: function (root, low, high) {
        let sum = 0;
        dfs(root);
        return sum;

        function dfs(root) {
            if (!root) {
                return;
            }
            if (root.data < low) {
                dfs(root.right);
            } else if (root.data > high) {
                dfs(root.left);
            } else {
                sum += 1;
                dfs(root.left);
                dfs(root.right);
            }
        }
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

int traverse(TreeNode * root, int low, int high) {
    if (root == NULL)
        return 0;
    if (root -> val == high && root -> val == low)
        return 1;
    if (root -> val <= high && root -> val >= low)
        return 1 + traverse(root -> left, low, high) + traverse(root -> right, low, high);
    else if (root -> val < low)
        return traverse(root -> right, low, high);
    else
        return traverse(root -> left, low, high);
    return 0;
}
int Solution::solve(TreeNode * A, int B, int C) {
    return traverse(A, B, C);
}
```

