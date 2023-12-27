### Q5. Deserialize Binary Tree
#### Problem Description
```text
You are given an integer array A denoting the Level Order Traversal of the Binary Tree.

You have to Deserialize the given Traversal in the Binary Tree and return the root of the Binary Tree.

NOTE:
    * In the array, the NULL/None child is denoted by -1.
    * For more clarification check the Example Input.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p> 1 &lt;= number of nodes &lt;= 10<sup>5</sup></p>
    <p> -1 &lt;= A[i] &lt;= 10<sup>5</sup></p>
</div>

```text
1 <= number of nodes <= 10^5

-1 <= A[i] <= 10^5
```
#### Input Format
```text
Only argument is an integer array A denoting the Level Order Traversal of the Binary Tree.
```
#### Output Format
```text
Return the root node of the Binary Tree.
```
#### Example Input
```text
Input 1:
 A = [1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1]

Input 2:
 A = [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1]
```
#### Example Output
```text
Output 1:
           1
         /   \
        2     3
       / \
      4   5

Output 2:
            1
          /   \
         2     3
        / \ .   \
       4   5 .   6
```
#### Example Explanation
```text
Explanation 1:
    Each element of the array denotes the value of the node. If the val is -1 then 
    it is the NULL/None child.
    Since 3, 4 and 5 each has both NULL child we had represented that using -1.

Explanation 2:
    Each element of the array denotes the value of the node. If the val is -1 then 
    it is the NULL/None child.
    Since 3 has left child as NULL while 4 and 5 each has both NULL child.
```
### Hints
* Hint 1
```text
Think of using a queue data structure to build the Binary Tree from the given 
Level Order Traversal.
```
* Solution Approach
```text
We can do this simply by using a queue data structure.

We know that the root node will always be the first element of level order traversal.
Create a root node and push the root node into the queue.

Now, run a loop until the queue is empty and keep a variable, let’s say i, for 
denoting the current index in the Level Order Traversal.

Pop the Node: If the node is not NULL, then the element at index i will be the 
left child, and the element at i+1 will be the right child.

Create those children and push the left child and right child of the node, 
respectively, in the queue.

After building the tree, return the root node.
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
    public TreeNode solve(ArrayList<Integer> A) {

        TreeNode root = new TreeNode(A.get(0));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while(q.size() != 0){
            TreeNode cur = q.peek();
            q.remove();
            if(cur == null){
                continue;
            }
            int val_left = A.get(i);
            int val_right = A.get(i+1);
            
            i += 2;
            
            if(val_left == -1){
                cur.left = null;
            }
            else{
                cur.left = new TreeNode(val_left);
            }
            if(val_right == -1){
                cur.right = null;
            }
            else{
                cur.right = new TreeNode(val_right);
            }
            q.add(cur.left);
            q.add(cur.right);
        }
        
        return root;

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
 //param A : array of integers
 //return the root node in the tree
	solve : function(A){
            let root = new TreeNode(A[0]);
            q = [];
            q.push(root);
            let i = 1;
            while(q.length > 0) {
                let cur = q.pop();
                
                if(cur == null) {
                    continue;
                }
                let val_left = A[i];
                let val_right = A[i + 1];
                
                i += 2;
                
                if(val_left == -1) {
                    cur.left = null;
                }
                else {
                    cur.left = new TreeNode(val_left);
                }
                if(val_right == -1) {
                    cur.right = null;
                }
                else {
                    cur.right = new TreeNode(val_right);
                }
                q.unshift(cur.left);
                q.unshift(cur.right);
            }
            return root;
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
TreeNode * Solution::solve(vector < int > & A) {
    TreeNode * root = new TreeNode(A[0]);
    queue < TreeNode * > q;
    q.push(root);
    int i = 1;
    while (!q.empty()) {
        TreeNode * cur = q.front();
        q.pop();
        if (cur == NULL) {
            continue;
        }
        int val_left = A[i];
        int val_right = A[i + 1];

        i += 2;

        if (val_left == -1) {
            cur -> left = NULL;
        } else {
            cur -> left = new TreeNode(val_left);
        }
        if (val_right == -1) {
            cur -> right = NULL;
        } else {
            cur -> right = new TreeNode(val_right);
        }
        q.push(cur -> left);
        q.push(cur -> right);
    }
    return root;
}
```

