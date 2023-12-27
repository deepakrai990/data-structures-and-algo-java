### Q1. Counting the Nodes
#### Problem Description
```text
Given the root of a tree A with each node having a certain value, 
find the count of nodes with more value than all its ancestor.
```
#### Problem Constraints
```text
1 <= Number of Nodes <= 200000

1 <= Value of Nodes <= 2000000000
```
#### Input Format
```text
The first and only argument of input is a tree node.
```
#### Output Format
```text
Return a single integer denoting the count of nodes that have 
more value than all of its ancestors.
```
#### Example Input
```text
Input 1:
 
     3

Input 2:
 
    4
   / \
  5   2
     / \
    3   6
```
#### Example Output
```text
Output 1:
 1 

Output 2:
 3
```
#### Example Explanation
```text
Explanation 1:
    There's only one node in the tree that is the valid node.

Explanation 2:
    The valid nodes are 4, 5 and 6.
```
### Hints
* Hint 1
```text
Can you use a DFS to keep track of the maximum value that 
you have encountered for the left and right subtrees?
```
* Solution Approach
```text
Run a DFS and keep track of the maximum so far.

When arriving at a node, first find the answer for the left 
sub-tree, if it exists; then find the answer for the right 
sub-tree; Our current answer is the sum of both ans. But if the 
current node value is greater than max so far, we increment the answer.

Note that since we keep track of max from above, it covers all 
nodes. Please look into complete solution for implementation.
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
    int dfs(TreeNode cur, int mx) {
        if(cur == null) {
            return 0;
        }
        int ans = dfs(cur.left, Math.max(mx, cur.val)) + dfs(cur.right, Math.max(mx, cur.val));
        if(cur.val > mx) {
            ++ans;
        }
        return ans;
    }
    public int solve(TreeNode A) {
        return dfs(A, 0);
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

var dfs = function (root, maxsofar) {
    if (root == null) {
        return 0;
    }
    var ans = 0;
    if (root.val > maxsofar) {
        ans = 1;
        maxsofar = root.val;
    }
    ans += dfs(root.left, maxsofar);
    ans += dfs(root.right, maxsofar);
    return ans;
}
module.exports = {
    //param A : root node of tree
    //return an integer
    solve: function (A) {
        return dfs(A, 0);
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

int dfs(TreeNode * root, int maxsofar) {
    if (root == NULL) {
        return 0;
    }
    int ans = 0;
    if (root -> val > maxsofar) {
        ans = 1;
        maxsofar = root -> val;
    }
    ans += dfs(root -> left, maxsofar);
    ans += dfs(root -> right, maxsofar);
    return ans;
}

int Solution::solve(TreeNode * A) {
    return dfs(A, 0);
}
```

