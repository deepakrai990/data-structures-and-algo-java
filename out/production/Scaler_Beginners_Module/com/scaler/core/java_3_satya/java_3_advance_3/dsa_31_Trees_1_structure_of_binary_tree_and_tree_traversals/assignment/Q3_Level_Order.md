### Q3. Level Order
#### Problem Description
```text
Given a binary tree, return the level order traversal of 
its nodes' values. (i.e., from left to right, level by level).
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
Return a 2D integer array denoting the zigzag level order traversal 
of the given binary tree.
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
   [9, 20],
   [15, 7]
 ]

Output 2:
 [ 
   [1]
   [6, 2]
   [3]
 ]
```
#### Example Explanation
```text
Explanation 1:
    Return the 2D array. Each row denotes the traversal of each level.
```
### Hints
* Hint 1
```text
Can you maintain the depth of a node while traversing the tree? 

How can it help you after the tree traversal?
```
* Solution Approach
```text
There are two ways to solve this problem.

Approach 1: Maintain a vector of size ‘depth’ of the tree. 
            Do any tree traversals keep track of the current depth? 
            Append the current element to vector[currentDepth]. 
            Since we need stuff left to right, make sure the left 
            subtree is visited before the right subtree ( Any 
            traditional pre/post/inorder traversal should suffice ).

Approach 2: This is important. A lot of times, you’d be asked 
            to do a traditional level order traversal. Or, to put 
            informal words, a traversal where the extra memory used 
            should be proportional to the nodes on a level rather 
            than the depth of the tree. To do that, you need to make 
            sure you are accessing all the nodes on a level before 
            accessing the nodes next. This is a typical breadth-first 
            search problem—queue FTW.
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
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
	    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
	    ArrayList<Integer> level = new ArrayList<>();
	    Queue<TreeNode> queue = new LinkedList<>();
	    if (A == null)
	        return null;
	    queue.add(A);
	    queue.add(null);
	    TreeNode node;
	    while (!queue.isEmpty()) {
	        node = queue.remove();
	        if (node == null && queue.isEmpty()) {
	            res.add(new ArrayList<>(level));
	            break;
	        }
	        if (node == null) {
	            res.add(new ArrayList<>(level));
	            level.clear();
	            queue.add(null);
	            continue;
	        }
	        level.add(node.val);
	        if (node.left != null)
	            queue.add(node.left);
	        if (node.right != null) {
	            queue.add(node.right);
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
 //return a array of array of integers
	levelOrder : function(root){
            if (root == null){
                return [];
            }
            let queue = [] , values = [];
            queue.push(root);
            while (queue.length > 0) {
                let len = queue.length , level = [];
                for (let i = 0 ; i < len ; i++) {
                    let node = queue.shift();
                    level.push(node.data);
                    if (node.left){
                        queue.push(node.left);
                    }
                    if (node.right){
                        queue.push(node.right);
                    }
                }
                values.push(level);
            }
            return values;
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
 
void buildVector(TreeNode *root, int depth, vector<vector<int> > &ret) {
    if(root == NULL) return;
    if(ret.size() == depth)
        ret.push_back(vector<int>());

    ret[depth].push_back(root->val);
    buildVector(root->left, depth + 1, ret);
    buildVector(root->right, depth + 1, ret);
}

vector<vector<int> > Solution::levelOrder(TreeNode* root) {
    vector<vector<int> > ret;
    buildVector(root, 0, ret);
    return ret;
}
```

