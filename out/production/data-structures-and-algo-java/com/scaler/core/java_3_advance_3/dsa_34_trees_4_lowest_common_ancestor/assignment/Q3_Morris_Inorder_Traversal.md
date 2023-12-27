### Q3. Morris Inorder Traversal
#### Problem Description
```text
Given a binary tree, return the inorder traversal of its nodes' values.

NOTE: Using recursion and stack are not allowed.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p> 1 &lt;= number of nodes &lt;= 10<sup>5</sup></p>
</div>

```text
1 <= number of nodes <= 10^5
```
#### Input Format
```text
First and only argument is root node of the binary tree, A.
```
#### Output Format
```text
Return an integer array denoting the inorder traversal of the given binary tree.
```
#### Example Input
```text
Input 1:

   1
    \
     2
    /
   3

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
 [1, 3, 2]

Output 2:
 [6, 1, 3, 2]
```
#### Example Explanation
```text
Explanation 1:
    The Inorder Traversal of the given tree is [1, 3, 2].

Explanation 2:
    The Inorder Traversal of the given tree is [6, 1, 3, 2].
```
### Hints
* Hint 1
```text
We are not allowed to use recursion and stacks but we can first create links to 
inorder successor and append the data using the list, and finally revert the 
changes to restore original tree. 
```
* Solution Approach
```text
The Morris Inorder Traversal algorithm is as follows :-

1) Initialize the root as the current node.

2) While current is not null, check if current has a left child.

3) If current does not have a left child, append current node value to our answer 
   and update it to point to the node on the right of current.

4) Otherwise, make current as the right child of its inorder predecessor.

5) Update current to its left node.


Time Complexity : O(N)
Space Complexity : O(1)
where N = number of nodes in A
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
    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList < Integer> ans = new ArrayList < Integer >();
        TreeNode current, pre;
        current = A;
        while (current != null) {
            if (current.left == null) {
                ans.add(current.val);
                current = current.right;
            }
            else {
                // Find the inorder predecessor of current
                pre = current.left;
                while (pre.right != null && pre.right != current)
                    pre = pre.right;
     
                // Make current as the right child of its inorder predecessor
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                }
                else {
                    pre.right = null;
                    ans.add(current.val);
                    current = current.right;
                } 
            }
        }     
        return ans;
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
 
vector<int> Solution::solve(TreeNode* A) {
    vector<int> ans;
    TreeNode *current, *pre;
 
    if (A == NULL)
        return ans;
 
    current = A;
    while (current != NULL) {
 
        if (current->left == NULL) {
            ans.push_back(current->val);
            current = current->right;
        }
        else {
 
            // Find the inorder predecessor of current
            pre = current->left;
            while (pre->right != NULL && pre->right != current)
                pre = pre->right;
 
            // Make current as the right child of its inorder predecessor
            if (pre->right == NULL) {
                pre->right = current;
                current = current->left;
            }
            else {
                pre->right = NULL;
                ans.push_back(current->val);
                current = current->right;
            } 
        }
    }     
    return ans;
}
```

