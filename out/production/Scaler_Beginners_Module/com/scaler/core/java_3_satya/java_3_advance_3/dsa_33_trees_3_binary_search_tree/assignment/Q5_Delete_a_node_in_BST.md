### Q5. Delete a node in BST
#### Problem Description
```text
Given a Binary Search Tree(BST) A. If there is a node with value B present in the 
tree delete it and return the tree.

Note - If there are multiple options, always replace a node by its in-order predecessor
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    2 &lt;= No. of nodes in BST &lt;= 10<sup>5</sup><br>
    1 &lt;= value of nodes &lt;= 10<sup>9</sup><br>
    Each node has a unique value
</div>

```text
2 <= No. of nodes in BST <= 10^5
1 <= value of nodes <= 10^9
Each node has a unique value
```
#### Input Format
```text
The first argument is the root node of a Binary Search Tree A.
The second argument is the value B.
```
#### Output Format
```text
Delete the given node if found and return the root of the BST.
```
#### Example Input
```text
Input 1:

            15
          /    \
        12      20
        / \    /  \
       10  14  16  27
      /
     8

     B = 10

Input 2:

            8
           / \
          6  21
         / \
        1   7

     B = 6
```
#### Example Output
```text
Output 1:

            15
          /    \
        12      20
        / \    /  \
       8  14  16  27

Output 2:

            8
           / \
          1  21
           \
            7
```
#### Example Explanation
```text
Explanation 1:
    Node with value 10 is deleted 

Explanation 2:
    Node with value 6 is deleted 
```
### Hints
* Hint 1
```text
The different cases for deletion of nodes are

    * The node is a leaf node
    * The node has one child
    * The node has 2 children
```
* Solution Approach
```text
The node is a leaf node - In this cases, we can just delete the node and return the 
root, since deleting any leaf node doesn’t affect the remaining tree.


The node has one child - In this case, replace the node with the child node and 
return the root.


The node has 2 children - In this case, in order to conserve the BST properties, 
we need to replace the node with it’s inorder predecessor (The node that comes 
before in the inorder traversal) i.e; we need to replace it with :

The greatest value node in it’s left subtree and return the root.
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
    public TreeNode solve(TreeNode A, int B) {
        if(A != null) 
            if(B < A.val) 
                A.left = solve(A.left, B);                
            else if(B > A.val) 
                A.right = solve(A.right, B);       
            else{
                if(A.left == null && A.right == null) 
                    return null;              
                if (A.left == null || A.right == null)
                    return A.left != null ? A.left : A.right;           
                                                                  
                TreeNode temp = A.left;                         
                while(temp.right != null) 
                    temp = temp.right;  
                A.val = temp.val;                             
                A.left = solve(A.left, temp.val);        
            }
        return A;
    }
}
```
* * Solution in Javascript
```javascript
// Definition for a binary tree node
// function TreeNode(data){
//   this.data = data;
//   this.left = null;
//   this.right = null;
// }

module.exports = {
    //param A: root node of tree
    //param B: integer
    //return the root node in the tree
    solve: function (A, B) {
        if (A == null) {
            return null;
        }

        if (A.data == B) {
            if (A.left != null && A.right != null) {
                let temp = A.left;
                while (temp.right != null) {
                    temp = temp.right;
                }
                A.data = temp.data;
                A.left = this.solve(A.left, temp.data);
            } else {
                return A.left != null ? A.left : A.right;
            }
        } else if (B < A.data) {
            A.left = this.solve(A.left, B);
        } else {
            A.right = this.solve(A.right, B);
        }

        return A;
    },
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
TreeNode* Solution::solve(TreeNode* A, int B) {
    if(A) 
        if(B < A->val) A->left = solve(A->left, B);                 
        else if(B > A->val) A->right = solve(A->right, B);       
        else{
            if(!A->left && !A->right) return NULL;              
            if (!A->left || !A->right)
                return A->left ? A->left : A->right;           
                                                              
            TreeNode* temp = A->left;                         
            while(temp->right != NULL) temp = temp->right;  
            A->val = temp->val;                             
            A->left = solve(A->left, temp->val);		
        }
    return A;
}
```

