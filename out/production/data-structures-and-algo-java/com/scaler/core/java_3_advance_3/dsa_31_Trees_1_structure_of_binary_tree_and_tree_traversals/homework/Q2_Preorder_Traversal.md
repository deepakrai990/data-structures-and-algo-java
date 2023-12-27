### Q2. Preorder Traversal
#### Problem Description
```text
Given a binary tree, return the preorder traversal of its nodes values.

NOTE: Using recursion is not allowed.
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
Return an integer array denoting the preorder traversal of the 
given binary tree.
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
 [1, 2, 3]

Output 2:
 [1, 6, 2, 3]
```
#### Example Explanation
```text
Explanation 1:
    The Preorder Traversal of the given tree is [1, 2, 3].

Explanation 2:
    The Preorder Traversal of the given tree is [1, 6, 2, 3].
```
### Hints
* Hint 1
```text
You can do this problem easily with recursion, but recursion 
is not allowed here.

Stack can help you to avoid recursion. How?
```
* Solution Approach
```text
Think about using Stack.

Recursive call would look something like this :

print(root->val);
preorderprint(root->left);
preorderprint(root->right);

Instead of calling the functions, can you put the nodes on a stack 
and process them?
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
  public ArrayList < Integer > preorderTraversal(TreeNode A) {
    ArrayList < Integer > res = new ArrayList < Integer > ();
    Stack < TreeNode > stack = new Stack < > ();
    if (A == null)
      return res;
    stack.push(A);
    TreeNode node;
    while (!stack.isEmpty()) {
      node = stack.pop();
      res.add(node.val);
      if (node.right != null)
        stack.push(node.right);
      if (node.left != null)
        stack.push(node.left);
    }
    return res;
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
    //return a array of integers
    preorderTraversal: function (root) {
        if (!root) {
            return [];
        }
        let stack = [], res = [];
        stack.push(root);
        while (stack.length) {
            let node = stack.pop();
            res.push(node.data);
            if (node.right) {
                stack.push(node.right);
            }
            if (node.left) {
                stack.push(node.left);
            }
        }
        return res;
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
vector<int> Solution::preorderTraversal(TreeNode* root) {
    vector<int> res;
    stack<TreeNode*> s;
    s.push(root);
    TreeNode* temp = NULL;
    while(!s.empty()) {
        temp = s.top();
        s.pop();
        res.push_back(temp->val);
        if(temp->right)s.push(temp->right);
        if(temp->left)s.push(temp->left);
    }
    return res;
}
```

