### Q2. Largest BST Subtree
#### Problem Description
```text
You are given a Binary Tree A with N nodes.

Write a function that returns the size of the largest subtree, which is 
also a Binary Search Tree (BST).

If the complete Binary Tree is BST, then return the size of the whole tree.

NOTE:
    The largest subtree is the subtree with the most number of nodes.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= N &lt;= 10<sup>5</sup></p>
</div>

```text
1 <= N <= 10^5
```
#### Input Format
```text
First and only argument is an pointer to root of the binary tree A.
```
#### Output Format
```text
Return an single integer denoting the size of the largest subtree which is also a BST.
```
#### Example Input
```text
Input 1:

     10
    / \
   5  15
  / \   \ 
 1   8   7

Input 2:

     5
    / \
   3   8
  / \ / \
 1  4 7  9
```
#### Example Output
```text
Output 1:
 3

Output 2:
 7
```
#### Example Explanation
```text
Explanation 1:
    Largest BST subtree is
                            5
                           / \
                          1   8
Explanation 2:
    Given binary tree itself is BST.
```
### Hints
* Hint 1
```text
One Approach: check whether every node is BST or not and return the maximum size subtree.
Time Complexity: O (n^2)

Improvement:
Go from bottom to top and check whether the given tree is subtree or not.
```
* Solution Approach
```text
Maintain a data structure that stores for every node the maximum value in the subtree 
of a node, the minimum value in the subtree of a node, size of the subtree, size of 
the largest BST found in the subtree of a node, and flag to denote whether this 
subtree is bst or not.

Traverse the tree in a bottom-up manner.

A Tree is BST if the following is true for every node X.

    1. The largest value in the left subtree (of X) is smaller than the value of X.
    
    2. The smallest value in the right subtree (of X) is greater than the value of X.
       update the details of these nodes accordingly.
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
    public int solve(TreeNode A) {
        return largestBST(A);
    }

    int largestBST(TreeNode node) {
        Value val = new Value();
        largestBSTUtil(node, val, val, val, val);

        return val.max_size;
    }

    /* largestBSTUtil() updates *max_size_ref for the size of the largest BST 
     subtree.   Also, if the tree rooted with node is non-empty and a BST, 
     then returns size of the tree. Otherwise returns 0.*/
    int largestBSTUtil(TreeNode node, Value min_ref, Value max_ref,
                       Value max_size_ref, Value is_bst_ref) {

        /* Base Case */
        if (node == null) {
            is_bst_ref.is_bst = true; // An empty tree is BST 
            return 0; // Size of the BST is 0 
        }

        int min = Integer.MAX_VALUE;

        /* A flag variable for left subtree property 
         i.e., max(root->left) < root->data */
        boolean left_flag = false;

        /* A flag variable for right subtree property 
         i.e., min(root->right) > root->data */
        boolean right_flag = false;

        int ls, rs; // To store sizes of left and right subtrees 

        /* Following tasks are done by recursive call for left subtree 
         a) Get the maximum value in left subtree (Stored in *max_ref) 
         b) Check whether Left Subtree is BST or not (Stored in *is_bst_ref) 
         c) Get the size of maximum size BST in left subtree (updates *max_size) */
        max_ref.max = Integer.MIN_VALUE;
        ls = largestBSTUtil(node.left, min_ref, max_ref, max_size_ref, is_bst_ref);
        if (is_bst_ref.is_bst == true && node.val > max_ref.max) {
            left_flag = true;
        }

        /* Before updating *min_ref, store the min value in left subtree. So that we 
         have the correct minimum value for this subtree */
        min = min_ref.min;

        /* The following recursive call does similar (similar to left subtree)  
         task for right subtree */
        min_ref.min = Integer.MAX_VALUE;
        rs = largestBSTUtil(node.right, min_ref, max_ref, max_size_ref, is_bst_ref);
        if (is_bst_ref.is_bst == true && node.val < min_ref.min) {
            right_flag = true;
        }

        // Update min and max values for the parent recursive calls 
        if (min < min_ref.min) {
            min_ref.min = min;
        }
        if (node.val < min_ref.min) // For leaf nodes 
        {
            min_ref.min = node.val;
        }
        if (node.val > max_ref.max) {
            max_ref.max = node.val;
        }

        /* If both left and right subtrees are BST. And left and right 
         subtree properties hold for this node, then this tree is BST. 
         So return the size of this tree */
        if (left_flag && right_flag) {
            if (ls + rs + 1 > max_size_ref.max_size) {
                max_size_ref.max_size = ls + rs + 1;
            }
            return ls + rs + 1;
        } else {
            //Since this subtree is not BST, set is_bst flag for parent calls 
            is_bst_ref.is_bst = false;
            return 0;
        }
    }
}

class Value {

    int max_size = 0; // for size of largest BST 
    boolean is_bst = false;
    int min = Integer.MAX_VALUE; // For minimum value in right subtree 
    int max = Integer.MIN_VALUE; // For maximum value in left subtree 

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
class Value {
    constructor() {
        this.max_size = 0; // for size of largest BST 
        this.is_bst = false;
        this.min = Number.MAX_VALUE; // For minimum value in right subtree 
        this.max = Number.MIN_VALUE;
    }
}

function largestBST(node) {
    let val = new Value();
    largestBSTUtil(node, val, val, val, val);
    return val.max_size;
}

function largestBSTUtil(node, min_ref, max_ref,
    max_size_ref, is_bst_ref) {

    /* Base Case */
    if (node == null) {
        is_bst_ref.is_bst = true; // An empty tree is BST 
        return 0; // Size of the BST is 0 
    }

    let min = Number.MAX_VALUE;

    /* A flag variable for left subtree property 
     i.e., max(root->left) < root->data */
    let left_flag = false;

    /* A flag variable for right subtree property 
     i.e., min(root->right) > root->data */
    let right_flag = false;

    let ls, rs; // To store sizes of left and right subtrees 

    /* Following tasks are done by recursive call for left subtree 
     a) Get the maximum value in left subtree (Stored in *max_ref) 
     b) Check whether Left Subtree is BST or not (Stored in *is_bst_ref) 
     c) Get the size of maximum size BST in left subtree (updates *max_size) */
    max_ref.max = Number.MIN_VALUE;
    ls = largestBSTUtil(node.left, min_ref, max_ref, max_size_ref, is_bst_ref);
    if (is_bst_ref.is_bst == true && node.data > max_ref.max) {
        left_flag = true;
    }

    /* Before updating *min_ref, store the min value in left subtree. So that we 
     have the correct minimum value for this subtree */
    min = min_ref.min;

    /* The following recursive call does similar (similar to left subtree)  
     task for right subtree */
    min_ref.min = Number.MAX_VALUE;
    rs = largestBSTUtil(node.right, min_ref, max_ref, max_size_ref, is_bst_ref);
    if (is_bst_ref.is_bst == true && node.data < min_ref.min) {
        right_flag = true;
    }

    // Update min and max values for the parent recursive calls 
    if (min < min_ref.min) {
        min_ref.min = min;
    }
    if (node.data < min_ref.min) // For leaf nodes 
    {
        min_ref.min = node.data;
    }
    if (node.data > max_ref.max) {
        max_ref.max = node.data;
    }

    /* If both left and right subtrees are BST. And left and right 
     subtree properties hold for this node, then this tree is BST. 
     So return the size of this tree */
    if (left_flag && right_flag) {
        if (ls + rs + 1 > max_size_ref.max_size) {
            max_size_ref.max_size = ls + rs + 1;
        }
        return ls + rs + 1;
    } else {
        //Since this subtree is not BST, set is_bst flag for parent calls 
        is_bst_ref.is_bst = false;
        return 0;
    }
}
module.exports = {
    //param A : root node of tree
    //return an integer
    solve: function (A) {
        return largestBST(A);
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

struct Info {
    int sz;
    int mx;
    int mn;
    int ans;
    bool isBST;
};

Info largestBSTinBinaryTree(TreeNode * root) {
    if (root == NULL)
        return {
            0,
            INT_MIN,
            INT_MAX,
            0,
            true
        };

    if (root -> left == NULL && root -> right == NULL)
        return {
            1,
            root -> val,
            root -> val,
            1,
            true
        };

    Info l = largestBSTinBinaryTree(root -> left);
    Info r = largestBSTinBinaryTree(root -> right);

    Info ret;
    ret.sz = (1 + l.sz + r.sz);

    if (l.isBST && r.isBST && l.mx < root -> val && r.mn > root -> val) {
        ret.mn = min(l.mn, min(r.mn, root -> val));
        ret.mx = max(r.mx, max(l.mx, root -> val));
        ret.ans = ret.sz;
        ret.isBST = true;
        return ret;
    }

    ret.ans = max(l.ans, r.ans);
    ret.isBST = false;
    return ret;
}

int Solution::solve(TreeNode * A) {
    Info res = largestBSTinBinaryTree(A);
    return res.ans;
}
```

