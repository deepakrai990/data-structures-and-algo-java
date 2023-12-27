### Q3. Next Pointer Binary Tree
#### Problem Description
```text
Given a binary tree,

Populate each next pointer to point to its next right node. If there 
is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Assume perfect binary tree.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= Number of nodes in binary tree &lt;= 100000</p>
    <p>1 &lt;= node values &lt;= 10<sup>9</sup></p>
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
Return the head of the binary tree after the changes are made.
```
#### Example Input
```text
Input 1:
 
     1
    /  \
   2    3

Input 2:
 
        1
       /  \
      2    5
     / \  / \
    3  4  6  7
```
#### Example Output
```text
Output 1:
 
        1 -> NULL
       /  \
      2 -> 3 -> NULL

Output 2:
 
         1 -> NULL
       /  \
      2 -> 5 -> NULL
     / \  / \
    3->4->6->7 -> NULL
```
#### Example Explanation
```text
Explanation 1:
    Next pointers are set as given in the output.

Explanation 2:
    Next pointers are set as given in the output.
```
### Hints
* Hint 1
```text
Can you use a level order traversal algorithm to
get how each next pointer is to be set up??
```
* Solution Approach
```text
Breadth first approach to exploring a tree is based on the concept 
of the level of a node.

The level of a node is its depth or distance from the root node.

We process all the nodes on one level before moving on to the next one.

We need to link all the nodes together which lie on the same level and the
level order or the breadth first traversal gives us access to all such nodes.
```
* Complete Solution
* * Solution in Java
```java
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;

        Queue < TreeLinkNode > q = new LinkedList < TreeLinkNode > ();
        q.offer(root);

        while (q.size() > 0) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeLinkNode front = q.poll();
                if (i == n - 1) {
                    front.next = null;
                } else {
                    front.next = q.peek();
                }
                if (front.left != null)
                    q.offer(front.left);
                if (front.right != null)
                    q.offer(front.right);
            }
        }
        return;
    }
}
```
* * Solution in Javascript
```javascript
// Definition for a  binary tree node
//			function TreeNode(data){
//				this.data = data
//				this.left = null
//				this.right = null
//			}

module.exports = {
    //param A : root node of tree
    //return nothing
    connect: function (root) {
        if (root == null) {
            return;
        }
        let queue = [];
        queue.push(root);
        while (queue.length > 0) {
            let prev = queue.shift(),
                tmp, len = queue.length;
            for (let i = 0; i < len; i++) {
                if (prev.left) {
                    queue.push(prev.left)
                }
                if (prev.right) {
                    queue.push(prev.right)
                }
                tmp = queue.shift()
                prev.next = tmp
                prev = tmp
            }
            if (prev.left)
                queue.push(prev.left)
            if (prev.right)
                queue.push(prev.right)
            prev.next = null
        }
    }
};
```
* * Solution in C++
```cpp
/**
  * Definition for binary tree with next pointer.
  * struct TreeLinkNode {
  *  int val;
  *  TreeLinkNode *left, *right, *next;
  *  TreeLinkNode(int x) : val(x), left(NULL), right(NULL), next(NULL) {}
  * };
  */
 void Solution::connect(TreeLinkNode * A) {
     TreeLinkNode * root;
     root = A;
     if (!root)
         return;

     queue < TreeLinkNode * > q;
     q.push(root);

     while (!q.empty()) {
         int n = q.size();
         for (int i = 0; i < n; i++) {
             TreeLinkNode * front = q.front();
             q.pop();
             if (i == n - 1) {
                 front -> next == NULL;
             } else {
                 front -> next = q.front();
             }
             if (front -> left)
                 q.push(front -> left);
             if (front -> right)
                 q.push(front -> right);
         }
     }
 }
```

