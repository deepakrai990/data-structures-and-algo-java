### Q2. ZigZag Level Order Traversal BT
#### Problem Description
```text
Given a binary tree, return the zigzag level order traversal of 
its nodes values. (ie, from left to right, then right to left for 
the next level and alternate between).
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
Return a 2D integer array denoting the zigzag level order 
traversal of the given binary tree.
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

 [
   [3],
   [20, 9],
   [15, 7]
 ]

Output 2:

 [ 
   [1]
   [2, 6]
   [3]
 ]
```
#### Example Explanation
```text
Explanation 1:
    Return the 2D array. Each row denotes the zigzag traversal of each level.
```
### Hints
* Hint 1
```text
There are 2 approaches possible here.

1) Can you modify the level order approach to take care of this 
   problem ? Reversing the entries in alternate row ?
   
2) If you don’t prefer reversing after the initial pass, can you 
   instead use 2 stacks instead of queue to solve this problem ?
```
* Solution Approach
```text
We will be using 2 stacks to solve this problem. One for the current 
layer and other one for the next layer. Also keep a flag which 
indicates the direction of traversal on any level.

You need to pop out the elements from current layer stack and 
depending upon the value of flag push the childs of current 
element in next layer stack. You should maintain the output 
sequence in the process as well. Remember to swap the stacks 
before next iteration.

When should you terminate this algorithm?
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
    public ArrayList < ArrayList < Integer >> zigzagLevelOrder(TreeNode A) {
        Stack < TreeNode > stack1 = new Stack < > (), stack2 = new Stack < > ();
        ArrayList < ArrayList < Integer >> zigzag = new ArrayList < > ();
        if (A == null)
            return null;

        stack1.push(A);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            ArrayList < Integer > level = new ArrayList < > ();
            while (!stack1.isEmpty()) {
                TreeNode node = stack1.pop();
                level.add(node.val);
                if (node.left != null)
                    stack2.push(node.left);
                if (node.right != null)
                    stack2.push(node.right);
            }
            if (level.size() != 0)
                zigzag.add(level);
            level = new ArrayList < > ();

            while (!stack2.isEmpty()) {
                TreeNode node = stack2.pop();
                level.add(node.val);
                if (node.right != null)
                    stack1.push(node.right);
                if (node.left != null)
                    stack1.push(node.left);
            }
            if (level.size() != 0)
                zigzag.add(level);
        }
        return zigzag;
    }
}
```
* * Solution in Javascript
```javascript
// Definition for a  binary tree node
//    function TreeNode(data) {
//      this.data = data
//      this.left = null
//      this.right = null
//    }

module.exports = {
    //param A : root node of tree
    //return a array of array of integers
    zigzagLevelOrder: function (A) {
        var curr = [A];
        var rtl = false;
        var ans = [];
        while (curr.length > 0) {
            let new_stack = [];
            let temp = [];
            for (let i = curr.length - 1; i >= 0; i--) {
                if (!rtl) {
                    if (curr[i].left) new_stack.push(curr[i].left);
                    if (curr[i].right) new_stack.push(curr[i].right);
                } else {
                    if (curr[i].right) new_stack.push(curr[i].right);
                    if (curr[i].left) new_stack.push(curr[i].left);
                }
                temp.push(curr[i].data);
            }
            rtl = !rtl;
            ans.push(temp);
            curr = new_stack;
        }
        return ans;
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
vector < vector < int > > Solution::zigzagLevelOrder(TreeNode * root) {
    vector < vector < int > > output;
    if (root == NULL) return output;
    stack < TreeNode * > cur_layer;
    cur_layer.push(root);
    stack < TreeNode * > next_layer;
    vector < int > layer_output;
    int d = 0; // 0: left to right; 1: right to left.

    while (!cur_layer.empty()) {
        TreeNode * node = cur_layer.top();
        cur_layer.pop();
        layer_output.push_back(node -> val);
        if (d == 0) {
            if (node -> left != NULL) next_layer.push(node -> left);
            if (node -> right != NULL) next_layer.push(node -> right);
        } else {
            if (node -> right != NULL) next_layer.push(node -> right);
            if (node -> left != NULL) next_layer.push(node -> left);
        }

        if (cur_layer.empty()) {
            output.push_back(layer_output);
            layer_output.clear();
            cur_layer.swap(next_layer);
            if (d == 1) d = 0;
            else d = 1;
        }
    }
    return output;
}
```

