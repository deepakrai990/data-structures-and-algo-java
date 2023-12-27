### Q4. Kth Smallest Element In BST
#### Problem Description
```text
Given a binary search tree represented by root A, write a function 
to find the B^th smallest element in the tree.
```
#### Problem Constraints
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
Return an integer, representing the Bth element.
```
#### Example Input
```text
Input 1:
 
            2
          /   \
         1    3
B = 2

Input 2:
 
            3
           /
          2
         /
        1
B = 1
```
#### Example Output
```text
Output 1:
 2

Output 2:
 1
```
#### Example Explanation
```text
Explanation 1:
    2nd element is 2.

Explanation 2:
    1st element is 1.
```
### Hints
* Hint 1
```text
Think about the property of binary search tree and how it can help you.

Do you really need to visit right subtree of any node before 
visiting entire left subtree of it?
```
* Solution Approach
```text
Note the property of the binary search tree.

All elements smaller than root will be in the left subtree, and all 
elements greater than root will be in the right subtree.

This means we need not even explore the right subtree till we have 
explored everything in the left subtree. Or in other words, we go 
to the right subtree only when the size of left subtree + 1 ( root ) < k.

With that in mind, we can come up with an easy recursive solution 
which is similar to inorder traversal :

Step 1: Find the kth smallest element in left subtree decrementing k for 
        every node visited. If answer is found, return answer.

Step 2: Decrement k by 1. If k == 0 ( this node is the kth node 
        visited ), return node’s value

Step 3: Find the kth smallest element in right subtree.
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
     * TreeNode(int x) {
             * val = x;
             * left = null;
             * right = null;
             *
         }
         *
 }
 */
 public class Solution {
     static int k = 0;
     public int kthsmallest(TreeNode A, int B) {
         k = B;
         return find(A);
     }
     public static int find(TreeNode root) {
         if (root == null)
             return -1;
         // We do an inorder traversal here. 
         int k1 = find(root.left);
         if (k == 0)
             return k1; // left subtree has k or more elements.
         k--;
         if (k == 0)
             return root.val; // root is the kth element.
         return find(root.right); // answer lies in the right node.
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
    //param B : integer
    //return an integer
    kthsmallest: function (root, k) {
        let stack = []
        while (root || stack.length) {
            while (root) {
                stack.push(root)
                root = root.left
            }
            root = stack.pop()
            if (--k == 0)
                return root.data
            root = root.right
        }
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
int find(TreeNode * root, int & k) {
    if (!root)
        return -1;
    // We do an inorder traversal here. 
    int k1 = find(root -> left, k);
    if (k == 0)
        return k1; // left subtree has k or more elements.
    k--;
    if (k == 0)
        return root -> val; // root is the kth element.
    return find(root -> right, k); // answer lies in the right node.
}
int Solution::kthsmallest(TreeNode * A, int B) {
    return find(A, B);
}
```

