### Q1. Inorder Traversal
#### Problem Description
```text
Given a binary tree, return the inorder traversal of its nodes' values.

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
Return an integer array denoting the inorder traversal of the 
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
You can do this problem easily with recursion, but recursion 
is not allowed here.

A stack can help you to avoid recursion. How?
```
* Solution Approach
```text
Think stack.

Recursive call would look something like this :

inorderprint(root->left);
print(root->val);
inorderprint(root->right);

Instead of calling the functions, can you put the nodes on a 
stack and process them?

How would your solution work if you could change the original tree?

How would it work if you were not allowed to change the 
tree but use additional memory ( track the number of 
times a node has appeared in the tree )?

How would it work if you were not even allowed the extra memory?
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
	// Threaded binary tree Morris traversal
	public ArrayList<Integer> inorderTraversal(TreeNode A) {
	    TreeNode current, node;
	    ArrayList<Integer> res = new ArrayList<>();
	    current = A;
	    while (current != null) {
	        if (current.left == null) {
	            res.add(current.val);
	            current = current.right;
	        } else {
	            node = current.left;
	            while (node.right != null && !current.equals(node.right))
	                node = node.right;
	            
	            if (node.right == null) {
	                node.right = current;
	                current = current.left;
	            } else {
	                current = node.right;
	                node.right = null;
	                res.add(current.val);
	                current = current.right;
	            }
	        }
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
    inorderTraversal : function(A){
        if (!A){
            return [];
        }
        const arrI = [];
        const stack = [];
        let curr = A;
        while (curr || stack.length > 0) {
            while (curr) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            arrI.push(curr.data);
            curr = curr.right
        }
        return arrI;
    }
};
```
* * Solution in C++
```cpp
/** Method 1: Using one stack and the binary tree node will 
 * be changed. Easy ,not Practical
 **/

/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
vector < int > Solution::inorderTraversal(TreeNode * root) {
    vector < int > vector;
    if (!root)
        return vector;
    stack < TreeNode * > stack;
    stack.push(root);
    while (!stack.empty()) {
        TreeNode * pNode = stack.top();
        if (pNode -> left) {
            stack.push(pNode -> left);
            pNode -> left = NULL;
        } else {
            vector.push_back(pNode -> val);
            stack.pop();
            if (pNode -> right)
                stack.push(pNode -> right);
        }
    }
    return vector;
}
/**
 * Method 2: Using one stack and one unordered_map, this 
 * will not changed the node. Better
 **/

/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
vector < int > Solution::inorderTraversal(TreeNode * root) {
    vector < int > vector;
    if (!root)
        return vector;
    unordered_map < TreeNode * , bool > map; //left child has been visited:true.
    stack < TreeNode * > stack;
    stack.push(root);
    while (!stack.empty()) {
        TreeNode * pNode = stack.top();
        if (pNode -> left && !map[pNode]) {
            stack.push(pNode -> left);
            map[pNode] = true;
        } else {
            vector.push_back(pNode -> val);
            stack.pop();
            if (pNode -> right)
                stack.push(pNode -> right);
        }
    }
    return vector;
}
/** 
 * Method 3: Using one stack and will not changed 
 * the node. Best(at least in this three solutions)
 **/

/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
vector < int > Solution::inorderTraversal(TreeNode * root) {
    vector < int > vector;
    stack < TreeNode * > stack;
    TreeNode * pCurrent = root;

    while (!stack.empty() || pCurrent) {
        if (pCurrent) {
            stack.push(pCurrent);
            pCurrent = pCurrent -> left;
        } else {
            TreeNode * pNode = stack.top();
            vector.push_back(pNode -> val);
            stack.pop();
            pCurrent = pNode -> right;
        }
    }
    return vector;
}
```
