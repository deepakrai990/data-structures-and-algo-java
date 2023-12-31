### Q2. Binary tree to Circular Doubly Linked List
#### Problem Description
```text
Given a binary tree convert it into circular doubly linked list based on the following rules:

    * The left and right pointers in nodes are to be used as previous and next pointers 
      respectively in converted Circular Linked List.
    
    * The order of nodes in List must be same as Inorder of the given Binary Tree.
    
    * The first node of Inorder traversal must be the head node of the Circular List.

NOTE: You are expected to convert the binary tree into Doubly linked list in place.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>0 &lt;= Number of nodes in tree &lt;= 100000</p>
    <p>1 &lt;= Value of node &lt;= 10<sup>9</sup></p>
</div>

```text
0 <= Number of nodes in tree <= 100000

1 <= Value of node <= 10^9
```
#### Input Format
```text
The only argument given is the root pointer of the tree, A.
```
#### Output Format
```text
Return the head pointer of the converted circular doubly linked list.
```
#### Example Input
```text
Input 1:
 Serialized from input of binary tree:(where 7 denotes the number of elements in serial)
    7 20 8 -1 -1 22 -1 -1 
    Binary tree is
      20 
     /  \
    8    22
    8 is the left child of 20 and 22 is the right child of 20.

Input 2:
 Serialized from input of binary tree:(where 7 denotes the number of elements in serial)
    7 10 8 -1 -1 11 -1 -1 
    Binary tree is
      10 
     /  \
    8    11
    8 is the left child of 10 and 11 is the right child of 10.
```
#### Example Output
```text
Output 1:
     _____________
    |             |
    8 <-> 20 <-> 22
    |_____________|

Output 2:
     _____________
    |             |
    8 <-> 10 <-> 11
    |_____________|
```
#### Example Explanation
```text
Explanation 1:
    The inorder traversal of binary tree is: [8, 20, 22]. Return the head pointer of 
    the circular doubly linked list.

Explanation 2:
    The inorder traversal of binary tree is: [8, 10, 11]. Return the head pointer of 
    the circular doubly linked list.
```
### Hints
* Hint 1
```text
Think of recursively concatenating the left and right subtree of the tree into a 
circular double linked list.
```
* Solution Approach
```text
Given the root of the tree, we will try to form the circular double linked list 
for each left and right subtree separately and then concatenate each circular 
double linked list.

We can do this recursively, first for left subtree and then for right subtree.

Now traverse the given tree:

-> Recursively convert left subtree to a circular DLL. Let the converted list be leftlist.

-> Recursively convert right subtree to a circular DLL. Let the converted list be rightlist.

-> Make a circular linked list of root of the tree, make left and right of root 
   to point to itself.

-> Concatenate leftlist with list of single root node.

-> Concatenate the list produced in step above with rightList.

To Concatenate two circular DLLs, we will follow below steps:

-> Get the last node of the leftlist. Retrieving the last node is an O(1) operation, 
   since the prev pointer of the head points to the last node of the list.

-> Connect it with the first node of the right list

-> Get the last node of the second list

-> Connect it with the head of the list.
```
* Complete Solution
* * Solution in Java
```java
/*
class TreeNode {
    int val;
    TreeNode left, right;
    ListNode(int x) {
        val = x;
        left = right = null;
    }
}
*/
class Solution {
    TreeNode concatenate(TreeNode leftList, TreeNode rightList) {
        // If either of the list is empty, then return the other list 
        if (leftList == null)
            return rightList;
        if (rightList == null)
            return leftList;

        // Store the last Node of left List 
        TreeNode leftLast = leftList.left;

        // Store the last Node of right List 
        TreeNode rightLast = rightList.left;

        // Connect the last node of Left List with the first Node of the right List 
        if (leftLast != null)
            leftLast.right = rightList;
        rightList.left = leftLast;

        // left of first node refers to the last node in the list 
        leftList.left = rightLast;

        // Right of last node refers to the first node of the List 
        if (rightLast != null)
            rightLast.right = leftList;

        // Return the Head of the List 
        return leftList;
    }

    // Method converts a tree to a circular Link List and then returns the head of the Link List 
    TreeNode bTreeToCList(TreeNode root) {
        if (root == null)
            return null;

        // Recursively convert left and right subtrees 
        TreeNode left = bTreeToCList(root.left);
        TreeNode right = bTreeToCList(root.right);

        // Make a circular linked list of single node (or root). To do so, make the right and left pointers of this node point to itself 
        root.left = root.right = root;

        // Step 1 (concatenate the left list with the list with single node, i.e., current node) 
        // Step 2 (concatenate the returned list with the right List) 
        return concatenate(concatenate(left, root), right);
    }


    TreeNode solve(TreeNode root) {
        return bTreeToCList(root);
    }
}
```
* * Solution in Javascript
```javascript
//param A : root node of tree
//return the root node in the tree
function concatenate(leftList, rightList) {
    if (leftList == null)return rightList;
    if (rightList == null)return leftList;

    let leftLast = leftList.left;

    let rightLast = rightList.left;
    if(leftLast)
         leftLast.right = rightList;
    rightList.left = leftLast;
    leftList.left = rightLast;
    if(rightLast)
            rightLast.right = leftList;
    return leftList;
}

function bTreeToCList(root) {
    if (root == null)
        return null;
    let leftlist = bTreeToCList(root.left);
    let rightlist = bTreeToCList(root.right);
    root.left = root.right = root;
    return concatenate(concatenate(leftlist, root), rightlist);
}

function solve(A){
    return bTreeToCList(A);
}
```
* * Solution in C++
```cpp
/*
Definition for binary tree
struct TreeNode {
      int val;
      TreeNode *left;
      TreeNode *right;
      TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};
*/

TreeNode *concatenate(TreeNode *leftList, TreeNode *rightList) {
    if (leftList == NULL)
              return rightList;
    if (rightList == NULL)
              return leftList;

    TreeNode *leftLast = leftList->left;

    TreeNode *rightLast = rightList->left;
    if(leftLast)
         leftLast->right = rightList;
    rightList->left = leftLast;
    leftList->left = rightLast;
    if(rightLast)
            rightLast->right = leftList;
    return leftList;
}

TreeNode *bTreeToCList(TreeNode *root) {
    if (root == NULL)
        return NULL;
    TreeNode *leftlist = bTreeToCList(root->left);
    TreeNode *rightlist = bTreeToCList(root->right);
    root->left = root->right = root;
    return concatenate(concatenate(leftlist, root), rightlist);
}

TreeNode *solve(TreeNode *A){
    return bTreeToCList(A);
}
```

