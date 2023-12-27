### Q2. Path Sum
#### Problem Description
```text
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such 
that adding up all the values along the path equals the given sum.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= number of nodes &lt;= 10<sup>5</sup></p>
    <p>-100000 &lt;= B, value of nodes &lt;= 100000</p>
</div>

```text
1 <= number of nodes <= 10^5

-100000 <= B, value of nodes <= 100000
```
#### Input Format
```text
First argument is a root node of the binary tree, A.

Second argument is an integer B denoting the sum.
```
#### Output Format
```text
Return 1, if there exist root-to-leaf path such that adding up all the values along 
the path equals the given sum. Else, return 0.
```
#### Example Input
```text
Input 1:

 Tree:    5
         / \
        4   8
       /   / \
      11  13  4
     /  \      \
    7    2      1

 B = 22

Input 2:

 Tree:    5
         / \
        4   8
       /   / \
     -11 -13  4

 B = -1
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
    There exist a root-to-leaf path 5 -> 4 -> 11 -> 2 which has sum 22. So, return 1.

Explanation 2:
    There is no path which has sum -1.
```
### Hints
* Hint 1
```text
Can you traverse the tree while keeping the sum from root to current node?

How can you check if you have reached the leaf or not?
```
* Solution Approach
```text
Recursion might make this problem much easier to solve.

You just need to keep a track of the sum from the root to the current node.

Then it becomes a question of just checking if the current node is a leaf node, 
and if so, do the sum match.
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
    public int hasPathSum(TreeNode A, int B) {
        boolean status = sum(A, 0, B);
        return status ? 1 : 0;
    }
    public boolean sum(TreeNode A, int curSum, int reqSum) {
        if (A == null) {
            return false;
        }
        if (A.left == null && A.right == null) {
            curSum += A.val;
            if (curSum == reqSum)
                return true;
            return false;
        }
        int sum = curSum + A.val;
        return sum(A.left, sum, reqSum) || sum(A.right, sum, reqSum);
    }
}
```
* * Solution in Javascript
```javascript
var hasPathSum = function (root, sum) {
  if (!root) return false;
  if (!root.left && !root.right) {
    return sum === root.data;
  } else {
    return (
      hasPathSum(root.left, sum - root.data) ||
      hasPathSum(root.right, sum - root.data)
    );
  }
};
module.exports = {
  hasPathSum: function (A, B) {
    return +hasPathSum(A, B);
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


int Solution::hasPathSum(TreeNode * root, int sum) {
    if (root == NULL) 
        return false;
    if (root -> left == NULL && root -> right == NULL) {
        return sum == root -> val;
    }
    int remainingSum = sum - root -> val;
    return hasPathSum(root -> left, remainingSum) || hasPathSum(root -> right, remainingSum);
}
```

