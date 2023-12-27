### Q2. Binary Tree From Inorder And Postorder
#### Problem Description
```text
Given the inorder and postorder traversal of a tree, construct the binary tree.

NOTE: You may assume that duplicates do not exist in the tree.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= number of nodes &lt;= 10<sup>5</sup></p>
</div>

```text
1 <= number of nodes <= 10^5
```
#### Input Format
```text
First argument is an integer array A denoting the inorder 
traversal of the tree.

Second argument is an integer array B denoting the postorder 
traversal of the tree.
```
#### Output Format
```text
Return the root node of the binary tree.
```
#### Example Input
```text
Input 1:
 A = [2, 1, 3]
 B = [2, 3, 1]

Input 2:
 A = [6, 1, 3, 2]
 B = [6, 3, 2, 1]
```
#### Example Output
```text
Output 1:

   1
  / \
 2   3

Output 2:

   1  
  / \
 6   2
    /
   3
```
#### Example Explanation
```text
Explanation 1:
    Create the binary tree and return the root node of the tree.
```
### Hints
* Hint 1
```text
The last element of postorder traversal will be the root. 
Combine this info with inorder traversal. How can this help you?
```
* Solution Approach
```text
Focus on the postorder traversal, to begin with.
The last element in the traversal will definitely be the root.
Based on this information, can you identify the left subtree and 
right subtree elements? ( Hint: Focus on inorder traversal and 
root information )

Once you do that, your problem has now been reduced to a smaller set. 
Now you have the inorder and postorder traversal for the left and 
right subtree, and you need to figure them out.
Divide and conquer.

Bonus points if you can do it without recursion.
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
	public TreeNode buildTree(ArrayList<Integer> inorder, ArrayList<Integer> postorder) {
	    if (inorder == null || postorder == null || inorder.size() == 0 || inorder.size() != postorder.size())
	        return null;
	    TreeNode root;
	    int n = inorder.size();
	    
	    root = rec(inorder, postorder, 0, n - 1, n - 1);
	    
	    return root;
	}
	
	public TreeNode rec(ArrayList<Integer> inorder, ArrayList<Integer> postorder, int start, int end, int postIndex) {
	    if (start > end)
	        return null;
	    TreeNode node;
	    int nodeVal = postorder.get(postIndex);
	    node = new TreeNode(nodeVal);
	    int i;
	    for (i = start; i <= end; i++) {
	        if (inorder.get(i) == nodeVal)
	            break;
	    }
	    node.left = rec(inorder, postorder, start, i - 1, postIndex - (end - i + 1));
	    node.right = rec(inorder, postorder, i + 1, end, postIndex - 1);
	    return node;
	}
	
}
```
* * Solution in Javascript
```javascript
// Definition for a  binary tree node
//	function TreeNode(data){
//		this.data = data
//		this.left = null
//		this.right = null
//	}
module.exports = {
    //param A : array of integers
    //param B : array of integers
    //return the root node in the tree
    buildTree: function (inorder, postorder) {
        if (postorder.length == 0) {
            return null;
        }
        var head = postorder.pop();
        var node = new TreeNode(head);
        var pivot = inorder.indexOf(head);
        var l = inorder.slice(0, pivot);
        var r = inorder.slice(pivot + 1, inorder.length);
        var rpost = postorder.splice(postorder.length - r.length, r.length);
        var lpost = postorder;
        node.left = this.buildTree(l, lpost);
        node.right = this.buildTree(r, rpost);
        return node;
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
TreeNode * Solution::buildTree(vector < int > & inorder, vector < int > & postorder) {
    if (inorder.size() == 0) return NULL;
    TreeNode * p;
    TreeNode * root;
    vector < int > vint;
    vector < TreeNode * > vtn;
    root = new TreeNode(postorder.back());
    vtn.push_back(root);
    postorder.pop_back();
    while (true) {
        if (inorder.back() == vtn.back() -> val) {
            p = vtn.back();
            vtn.pop_back();
            inorder.pop_back();
            if (inorder.size() == 0) break;
            if (vtn.size())
                if (inorder.back() == vtn.back() -> val) continue;
            p -> left = new TreeNode(postorder.back());
            postorder.pop_back();
            vtn.push_back(p -> left);
        } else {
            p = new TreeNode(postorder.back());
            postorder.pop_back();
            vtn.back() -> right = p;
            vtn.push_back(p);
        }
    }
    return root;
}
```

