### Q2. Sum of Left Leaves
#### Problem Description
```text
Given a binary tree, find and return the sum of node value of all 
left leaves in it.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= number of nodes &lt;= 5 * 10<sup>5</sup><br>
    1 &lt;= node value &lt;= 10<sup>5</sup></p>
</div>

```text
1 <= number of nodes <= 5 * 10^5
1 <= node value <= 10^5
```
#### Input Format
```text
First and only argument is a pointer to the root node of the Binary Tree, A.
```
#### Output Format
```text
Return an integer denoting the sum of node value of all left leaves in it.
```
#### Example Input
```text
Input 1:

    3
   / \
  9  20
    /  \
   15   7

Input 2:

   1
  / \
 6   2
    /
   3
```
#### Example Output
```text
Output 1:
 24

Output 2:
 9
```
#### Example Explanation
```text
Explanation 1:
    Left leaf node in the given tree are 9 and 15. Return 24 (9 + 15).

Explanation 2:
    Left leaf node in the given tree are 6 and 3. Return 9 (6 + 3).
```
### Hints
* Hint 1
```text
Think of traversing the tree and if we encounter the left leaf then 
add the node value in the result.
```
* Solution Approach
```text
Traverse the tree using recursion and if we encounter the left leaf 
then add the node value in the result.

If both the left and right child of the node is empty and node is 
the left child of its parent then node is called left leaf node.

Corner Case: If there is only root of the tree, it is not considered 
as left leaf node.
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
    public int helper(TreeNode A) {
        if (A == null) {
            return 0;
        }
        int ans = 0;
        if (A.left != null && A.left.left == null && A.left.right == null) {
            ans += A.left.val;
        } else {
            ans += helper(A.left);
        }
        ans += helper(A.right);
        return ans;
    }
    public int solve(TreeNode A) {
        return helper(A);
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

// A utility function to check if a given node is leaf or not
bool isLeaf(TreeNode * node) {
    if (node == NULL)
        return false;
    if (node -> left == NULL && node -> right == NULL)
        return true;
    return false;
}

// This function returns sum of all left leaves in a given binary tree
int leftLeavesSum(TreeNode * root) {
    // Initialize result
    int res = 0;

    // Update result if root is not NULL
    if (root != NULL) {
        // If left of root is leaf node, then add val of left child
        if (isLeaf(root -> left))
            res += root -> left -> val;
        else // Else recur for left child of root
            res += leftLeavesSum(root -> left);

        // Recur for right child of root and update res
        res += leftLeavesSum(root -> right);
    }

    // return result
    return res;
}

int Solution::solve(TreeNode * A) {
    return leftLeavesSum(A);
}
```

