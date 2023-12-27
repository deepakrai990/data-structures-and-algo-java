### Q1. Binary Tree From Inorder And Preorder
#### Problem Description
```text
Given preorder and inorder traversal of a tree, construct the binary tree.

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
First argument is an integer array A denoting the preorder 
traversal of the tree.

Second argument is an integer array B denoting the inorder 
traversal of the tree.
```
#### Output Format
```text
Return the root node of the binary tree.
```
#### Example Input
```text
Input 1:
 A = [1, 2, 3]
 B = [2, 1, 3]

Input 2:
 A = [1, 6, 2, 3]
 B = [6, 1, 3, 2]
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
First element of preorder traversal will be root. Combine this 
info with inorder traversal. 

How can this help you?
```
* Solution Approach
```text
Focus on the preorder traversal to begin with. 
The first element in the traversal will definitely be the root. 
Based on this information, can you identify the elements in the left subtree
and right subtree ? ( Hint : Focus on inorder traversal and root information )

Once you do that, your problem has now been reduced to a smaller set. Now you 
have the inorder and preorder traversal for the left and right subtree and you
need to figure them out. 
Divide and conquer. 

Bonus points if you can do it without recursion.
```
* Complete Solution
* * Solution in Java
```java
/**
 * Definition for binary tree
 * class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    ArrayList<Integer> preorder, inorder;

    public TreeNode buildTree(ArrayList<Integer> preorder, ArrayList<Integer> inorder) {
        if (preorder == null || inorder == null || preorder.size() == 0 || inorder.size() == 0)
            return null;

        if (preorder.size() != inorder.size())
            return null;

        this.preorder = preorder;
        this.inorder = inorder;

        return rec(0, preorder.size() - 1, 0);
    }

    private TreeNode rec(int start, int end, int index) {
        if (start > end)
            return null;

        TreeNode root = new TreeNode(preorder.get(index));

        int i = start;

        for (; i <= end; i++) {
            if (inorder.get(i).intValue() == root.val)
                break;
        }
        root.left = rec(start, i - 1, index + 1);
        root.right = rec(i + 1, end, index + i - start + 1);
        return root;
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
 //param A : array of integers
 //param B : array of integers
 //return the root node in the tree
    buildTree : function(A , B){
        if(B.length == 0 || A.length == 0) {
            return null;
        }
        var root = new TreeNode(A[0]);
        var indexinorder = B.indexOf(A[0]);
        root.left = this.buildTree(A.slice(1 , indexinorder + 1) , B.slice(0 , indexinorder));
        root.right = this.buildTree(A.slice(indexinorder + 1 , A.length) , B.slice(indexinorder + 1 , B.length));
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

TreeNode * buildTreeTmp(vector < int > ::iterator prel, vector < int > ::iterator prer,
  vector < int > ::iterator inl, vector < int > ::iterator inr) {
  if (prel >= prer)
    return NULL;

  int val = * prel;
  TreeNode * root = new TreeNode(val);

  vector < int > ::iterator rootIndex = find(inl, inr, val);
  vector < int > ::size_type lsize = rootIndex - inl;

  root -> left = buildTreeTmp(prel + 1, prel + 1 + lsize, inl, rootIndex);
  root -> right = buildTreeTmp(prel + 1 + lsize, prer, rootIndex + 1, inr);

  return root;
}

TreeNode * Solution::buildTree(vector < int > & preorder, vector < int > & inorder) {
  return preorder.size() == 0 ? NULL : buildTreeTmp(preorder.begin(), preorder.end(), inorder.begin(), inorder.end());
}
```

