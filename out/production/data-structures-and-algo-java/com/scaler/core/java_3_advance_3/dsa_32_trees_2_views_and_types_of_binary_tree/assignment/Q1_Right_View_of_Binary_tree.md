### Q1. Right View of Binary tree
#### Problem Description
```text
Given a binary tree of integers denoted by root A. Return an array 
of integers representing the right view of the Binary tree.

Right view of a Binary Tree is a set of nodes visible when the 
tree is visited from Right side.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= Number of nodes in binary tree &lt;= 100000</p>
    <p>0 &lt;= node values &lt;= 10<sup>9</sup></p>
</div>

```text
1 <= Number of nodes in binary tree <= 100000

0 <= node values <= 10^9
```
#### Input Format
```text
First and only argument is head of the binary tree A.
```
#### Output Format
```text
Return an array, representing the right view of the binary tree.
```
#### Example Input
```text
Input 1:

            1
          /   \
         2    3
        / \  / \
       4   5 6  7
      /
     8 

Input 2:
 
            1
           /  \
          2    3
           \
            4
             \
              5
```
#### Example Output
```text
Output 1:
 [1, 3, 7, 8]

Output 2:
 [1, 3, 4, 5]
```
#### Example Explanation
```text
Explanation 1:
    Right view is described.

Explanation 2:
    Right view is described.
```
### Hints
* Hint 1
```text
How many nodes are visible for each level?
```
* Solution Approach
```text
We can clearly see that only one node will be visible for each level.

For each level the rightmost node will be visible.

So to get the answer we can simply find for each level whenever 
you encounters the last node on that level append it to the answer.

We can solve the problem using level order traversal.

We will store all the nodes from the right to left of a level 
in a queue. We will put a null value in the queue to mark the 
end of the current level.

For each level, the first value in the queue is the rightmost 
node. We push this node value to our answer.

Then we traverse and pop the remaining nodes of the same level 
and push the nodes of the next level in the queue.
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
    public ArrayList < Integer > rightview(TreeNode root) {
        ArrayList < Integer > ans = new ArrayList < Integer > ();
        Queue < TreeNode > q = new LinkedList < TreeNode > ();
        if (root == null)
            return ans;
        q.add(root);
        q.add(null);
        // store the nodes of each level from right to left followed by null
        while (q.size() != 0) {
            TreeNode temp = q.peek();
            if (temp != null) {
                ans.add(temp.val);
                while (q.peek() != null) {
                    if (temp.right != null)
                        q.add(temp.right);
                    if (temp.left != null)
                        q.add(temp.left);
                    q.remove();
                    temp = q.peek();
                }
                q.add(null);
            }
            q.remove();
        }
        return ans;
    }

    public ArrayList < Integer > solve(TreeNode A) {
        return rightview(A);
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
const dfsTraversal = (root, res, depth) => {
    if (!root) {
        return;
    }
    if (depth > res.length - 1) {
        res.push(root.data);
    }
    dfsTraversal(root.right, res, depth + 1);
    dfsTraversal(root.left, res, depth + 1);
}

module.exports = {
    //param A : root node of tree
    //return a array of integers
    solve: function (root) {
        let res = [];
        let rightLeafDepth = 0;
        dfsTraversal(root, res, 0);
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

vector < int > rightview(TreeNode * A) {
    vector < int > ans;
    queue < TreeNode * > q;
    if (A == NULL)
        return ans;
    q.push(A);
    q.push(NULL);
    // store the nodes of each level from right to left followed by NULL
    while (!q.empty()) {
        TreeNode * temp = q.front();
        if (temp) {
            ans.push_back(temp -> val);
            while (q.front() != NULL) {
                if (temp -> right)
                    q.push(temp -> right);
                if (temp -> left)
                    q.push(temp -> left);
                q.pop();
                temp = q.front();
            }
            q.push(NULL);
        }
        q.pop();
    }
    return ans;
}
vector < int > Solution::solve(TreeNode * A) {
    return rightview(A);
}
```

