### Q4. Max Sum Path in Binary Tree
#### Problem Description
```text
Given a binary tree T, find the maximum path sum.

The path may start and end at any node in the tree.

Note: A maximum sum path is any path which has the maximum sum of the nodes lying on 
      the path.
```
#### Problem Constraints
```text
1 <= Number of Nodes <= 7e4

-1000 <= Value of Node in T <= 1000
```
#### Input Format
```text
The first and the only argument contains a pointer to the root of T, A.
```
#### Output Format
```text
Return an integer representing the maximum sum path.
```
#### Example Input
```text
Input 1:
  
        1
       / \
      2   3

Input 2:

       20
      /  \
   -10   20
        /  \
      -10  -50
```
#### Example Output
```text
Output 1:
 6

Output 2:
 40
```
#### Example Explanation
```text
Explanation 1:
    The path with maximum sum is: 2 -> 1 -> 3

Explanation 2:
    The path with maximum sum is: 20 -> 20
```
### Hints
* Hint 1
```text
This is a classical DP on tree problem.

Can you try to compute the answer for any vertex if you have answer for 
their left and right child?
```
* Solution Approach
```text
There are several ways of looking at this problem.
If we knew that root R is going to be a part of the longest path. Then we can look at 
the longest path to any leaf in the left subtree, longest path in the right subtree, 
and add them up along with root’s value to get the answer ( Obviously we only 
consider a path if its value is not negative ). To calculate the longest path 
till a leaf is O(n) [ Recursive call carrying forward the cumulative sum to a node ].

Given N possible roots, and then the O(n) leaf path calculation, the bruteforce 
becomes O(n^2).

However, note that the calculation of the longest path to the leaf is very 
redundant. So, to calculate the result for root R, can you reuse the results you 
have for R->left / R->right ?
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
    public int maxPathSum(TreeNode A) {
        Node node = rec(A);
        return node.maxSum;
    }

    public Node rec(TreeNode node) {
        if (node == null) return null;
        if (node.left == null && node.right == null) {
            Node n = new Node();
            n.maxSum = node.val;
            n.maxPath = node.val;
            return n;
        }
        Node left, right, n;

        left = rec(node.left);
        right = rec(node.right);
        n = new Node();

        if (left == null) {
            n.maxPath = node.val + right.maxPath;
            n.maxSum = Math.max(n.maxPath, right.maxSum);
        } else if (right == null) {
            n.maxPath = node.val + left.maxPath;
            n.maxSum = Math.max(n.maxPath, left.maxSum);
        } else {
            n.maxPath = Math.max(left.maxPath, right.maxPath) + node.val;
            n.maxSum = Math.max(n.maxPath, left.maxSum);
            n.maxSum = Math.max(n.maxSum, right.maxSum);
            n.maxSum = Math.max(n.maxSum, left.maxPath + right.maxPath + node.val);
        }
        n.maxPath = Math.max(node.val, n.maxPath);
        n.maxSum = Math.max(n.maxSum, n.maxPath);

        return n;
    }
    class Node {
        int maxSum;
        int maxPath;
    }
}
```
* * Solution in Javascript
```javascript
let global_max;

function maxPathAndGlobalUpdate(root) {
    if (root == null) return 0;
    let l = Math.max(0, maxPathAndGlobalUpdate(root.left));
    let r = Math.max(0, maxPathAndGlobalUpdate(root.right));
    global_max = Math.max(global_max, l + r + root.data);
    return root.data + Math.max(l, r);
}

module.exports = {
    maxPathSum: function (root) {
        global_max = -1e9;
        maxPathAndGlobalUpdate(root);
        return global_max;
    },
};
```
* * Solution in C++
```cpp
class Solution {
  public:
    int maxPathSum(TreeNode * root) {
      int maxAns = INT_MIN;
      maxPathAndGlobalUpdate(root, maxAns);
      return maxAns;
    }

  int maxPathAndGlobalUpdate(TreeNode * root, int & global_max) {
    if (root == NULL) return 0;
    int l = max(0, maxPathAndGlobalUpdate(root -> left, global_max));
    int r = max(0, maxPathAndGlobalUpdate(root -> right, global_max));
    global_max = max(global_max, l + r + root -> val);
    return root -> val + max(l, r);
  }
};
```

