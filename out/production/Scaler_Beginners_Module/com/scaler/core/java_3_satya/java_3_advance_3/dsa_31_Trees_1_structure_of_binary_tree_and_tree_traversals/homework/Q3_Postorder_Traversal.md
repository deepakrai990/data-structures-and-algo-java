### Q3. Postorder Traversal
#### Problem Description
```text
Given a binary tree, return the Postorder traversal of its nodes values.

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
Return an integer array denoting the Postorder traversal of the 
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
 [3, 2, 1]

Output 2:
 [6, 3, 2, 1]
```
#### Example Explanation
```text
Explanation 1:
    The Preorder Traversal of the given tree is [3, 2, 1].

Explanation 2:
    The Preorder Traversal of the given tree is [6, 3, 2, 1].
```
### Hints
* Hint 1
```text
You can do this problem easily with recursion, but recursion is not allowed here.

Stack can help you to avoid recursion. How?
```
* Solution Approach
```text
Think about using Stack. 

Recursive call would look something like this : 

  postorderprint(root->left);
  postorderprint(root->right);
  print(root->val);


Instead of calling the functions, can you put the nodes on a stack 
and process them? 

Would the solution be easier to print the reverse of the asked?
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
	public ArrayList<Integer> postorderTraversal(TreeNode A) {
	    Stack<TreeNode> stack1, stack2;
	    ArrayList<Integer> postorder;
	    TreeNode node;
	    stack1 = new Stack<>();
	    stack2 = new Stack<>();
	    postorder = new ArrayList<>();
	    if (A == null)
	        return null;
	    stack1.push(A);
	    while (!stack1.isEmpty()) {
	        node = stack1.pop();
	        stack2.push(node);
	        if (node.left != null)
	            stack1.push(node.left);
	        if (node.right != null)
	            stack1.push(node.right);
	    }
	    while (!stack2.isEmpty()) {
	        node = stack2.pop();
	        postorder.add(node.val);
	    }
	    return postorder;
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
    postorderTraversal: function (A) {
        if (!A) return [];
        const stack1 = [];
        const stack2 = [];
        const arr = [];
        stack1.push(A);
        while (stack1.length > 0) {
            // push left, right.. 
            let curr = stack1.pop();
            stack2.push(curr);
            if (curr.left) {
                stack1.push(curr.left);
            }
            if (curr.right) {
                stack1.push(curr.right);
            }
        }
        while (stack2.length > 0) {
            let tmp = stack2.pop();
            arr.push(tmp.data)
        }

        return arr;
    }
};
```
* * Solution in C++
```cpp
/**
 * Pre-order traversal is root-left-right, and post order is left-right-root. 
 * Modify the code for pre-order to make it root-right-left, and then reverse the output 
 * so that we can get left-right-root .
 * 
 * Create an empty stack, Push root node to the stack.
 * Do following while stack is not empty.
 * 
 * 2.1. pop an item from the stack and print it.
 * 2.2. push the left child of popped item to stack.
 * 2.3. push the right child of popped item to stack.
 * 
 * reverse the ouput.
 * Code
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
vector < int > Solution::postorderTraversal(TreeNode * root) {
  stack < TreeNode * > nodeStack;
  vector < int > result;
  //base case
  if (root == NULL)
    return result;
  nodeStack.push(root);
  while (!nodeStack.empty()) {
    TreeNode * node = nodeStack.top();
    result.push_back(node -> val);
    nodeStack.pop();
    if (node -> left)
      nodeStack.push(node -> left);
    if (node -> right)
      nodeStack.push(node -> right);
  }
  reverse(result.begin(), result.end());
  return result;
}
```

