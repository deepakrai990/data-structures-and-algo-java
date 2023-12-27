### Q4. Serialize Binary Tree
#### Problem Description
```text
Given the root node of a Binary Tree denoted by A. You have to Serialize the given Binary Tree in the described format.

Serialize means encode it into a integer array denoting the Level Order Traversal of the given Binary Tree.

NOTE:
    * In the array, the NULL/None child is denoted by -1.
    * For more clarification check the Example Input.
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
Only argument is a A denoting the root node of a Binary Tree.
```
#### Output Format
```text
Return an integer array denoting the Level Order Traversal of the given Binary Tree.
```
#### Example Input
```text
Input 1:
           1
         /   \
        2     3
       / \
      4   5
      
Input 2:
            1
          /   \
         2     3
        / \     \
       4   5     6
```
#### Example Output
```text
Output 1:
 [1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1]

Output 2:
 [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1]
```
#### Example Explanation
```text
Explanation 1:
    The Level Order Traversal of the given tree will 
    be [1, 2, 3, 4, 5 , -1, -1, -1, -1, -1, -1].
    Since 3, 4 and 5 each has both NULL child we had represented that using -1.

Explanation 2:
    The Level Order Traversal of the given tree will 
    be [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1].
    Since 3 has left child as NULL while 4 and 5 each has both NULL child.
```
### Hints
* Hint 1
```text
Think of using queue data structure to do a Level Order Traversal of the Binary Tree.
```
* Solution Approach
```text
We can do this simply by using a queue data structure.

Firstly, we will push the root node in the queue.
Now, run a loop until the queue is empty.
Pop the Node, store the value of the node if it not NULL else store -1 in the output array.

Then push the left child and right child of the node respectively in the queue.

Return the output array.
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
 *      left = null;
 *      right = null;
 *     }
 * }
 */
public class Solution {
    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(A);
        while(q.size() != 0){
            TreeNode cur = q.peek();
            q.remove();
            if(cur == null){
                ans.add(-1);
                continue;
            }
            
            ans.add(cur.val);
            q.add(cur.left);
            q.add(cur.right);
        }
        return ans;
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
	solve : function(root){
            if (!root) {
                return [];
            }
            let queue = [root] , arr = [];
            while (queue.length > 0) {
                let node = queue.pop();
                if (node == null) {
                    arr.push(-1);
                    continue;
                }
                else{
                    arr.push(node.data);
                }
                queue.unshift(node.right , node.left);
            }
            return arr;
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
vector < int > Solution::solve(TreeNode * A) {
  vector < int > ans;
  queue < TreeNode * > q;
  q.push(A);
  while (!q.empty()) {
    TreeNode * cur = q.front();
    q.pop();
    if (cur == NULL) {
      ans.push_back(-1);
      continue;
    }
    ans.push_back(cur -> val);
    q.push(cur -> left);
    q.push(cur -> right);
  }
  return ans;
}
```

