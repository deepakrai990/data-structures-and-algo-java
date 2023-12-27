### Q4. Recover Binary Search Tree
#### Problem Description
```text
Two elements of a binary search tree (BST), represented by root A are 
swapped by mistake. Tell us the 2 values swapping which the tree will 
be restored.

A solution using O(n) space is pretty straightforward. Could you 
devise a constant space solution?
```
#### Problem Constraints
```text
1 <= size of tree <= 100000
```
#### Input Format
```text
First and only argument is the head of the tree, A
```
#### Output Format
```text
Return the 2 elements which need to be swapped.
```
#### Example Input
```text
Input 1:

         1
        / \
       2   3

Input 2:

         2
        / \
       3   1
```
#### Example Output
```text
Output 1:
 [2, 1]

Output 2:
 [3, 1]
```
#### Example Explanation
```text
Explanation 1:
    
    Swapping 1 and 2 will change the BST to be 
             2
            / \
           1   3
    which is a valid BST 

Explanation 2:

    Swapping 1 and 3 will change the BST to be 
             2
            / \
           1   3
    which is a valid BST 
```
### Hints
* Hint 1
```text
In an ideal case, the inorder traversal should be sorted. Can you think 
about how the inorder traversal will look and how it can help you if you 
swap two elements?

The tricky part now is devising a constant space solution for in-order 
traversal. There is a famous algorithm for the same. Can you remember?
```
* Solution Approach
```text
Let’s look at the inorder traversal of the tree.
In the ideal case, the inorder traversal should be sorted. But in this 
case, because of the swapping 2 cases might arise :

    1) A sequence like {1, 4, 3, 7, 9}, where the swapped pair are adjacent 
       to each other. Only one inversion ( Inversion here means pair of 
       integer A[i], A[i+1] where A[i] > A[i+1] ).
    
    2) A sequence like {1, 9, 4, 5, 3, 10} where the swapped pair are not 
       adjacent. 2 inversions. We take the min and max of the inversion 
       numbers, and we know the number we need to swap to get the right answer.

Now to figure this out, we need to do an inorder traversal. However, 
the traditional recursive inorder traversal has memory overhead of 
the depth of the tree.

Using a stack has the same memory overhead.

So, we need something which does not use recursion or stack and can 
still do the inorder traversal. This part is a bit tricky. Not all 
interviewers expect you to know this.

Morris traversal helps us achieve what we are after. It works on the 
fact that we can modify the tree when traversing and then resetting 
the tree to its original state once we are done.

The idea of Morris traversal is based on the Threaded Binary 
tree ( http://en.wikipedia.org/wiki/Threaded_binary_tree ).

In this traversal, we first create links to Inorder successor and 
print the data using these links, and finally revert the changes to 
restore the original tree.

    1. Initialize current as root
    2. While current is not NULL
       If the current does not have left child
            a) Print current’s data
            b) Go to the right, i.e., current = current->right
       Else
            a) Make current as the right child of the rightmost node 
               in current’s left subtree
            b) Go to this left child, i.e., current = current->left

Although the tree is modified through the traversal, it is reverted back 
to its original shape after the completion.
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
    private TreeNode left;
    private TreeNode right;
    private TreeNode prev;
    public int[] recoverTree(TreeNode root) {
        int[] res = new int[2];
        dfs(root);
        if (left == null) return res;
        int tmp = left.val;
        left.val = right.val;
        right.val = tmp;
        res[0] = left.val;
        res[1] = right.val;
        return res;
    }
    private void dfs(TreeNode node) {
        if (node == null)
            return;
        dfs(node.left);
        if (prev != null) {
            if (node.val < prev.val) {
                if (left == null) {
                    left = prev;
                    right = node;
                } else {
                    right = node;
                }
            }
        }
        prev = node;
        dfs(node.right);
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
    recoverTree: function (root) {
        var node1, node2;
        var prev = new TreeNode(-Number.MAX_VALUE);
        traverse(root);
        var tmp = node1.data;
        node1.data = node2.data;
        node2.data = tmp;

        function traverse(node) {
            if (!node) {
                return;
            }
            traverse(node.left);
            if (node.data < prev.data) {
                node2 = node;
                if (!node1) node1 = prev;
            }
            prev = node;
            traverse(node.right);
        }

        return [node1.data, node2.data];
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
 /* 
 * MORRIS TRAVERSAL
 * Inorder Traversal（should get ascending seq.）：Analysis:
 * case A: If 2 near nodes swapped，then there will be just 1 Inversion Pair.
 * case B: If 2 nodes not near swapped，then there will be 2 Inversion Pairs.
 * Whether case A or case B, the max-value and the min-value of the Inversion Pair(s) are
 * the values we are interested in. 
 */
vector<int> Solution::recoverTree(TreeNode* A) {
    TreeNode * cur, * pre, * node1, * node2; // node1, node2: Record 2 near nodes
    TreeNode * first, * second; // At the end, first and second will be the 2 nodes to be swapped. 
    node1 = node2 = first = NULL;
    cur = A;
    while (cur) {
        if (cur -> left == NULL) {
            if (node1 == NULL) node1 = cur;
            else if (node2 == NULL) node2 = cur;
            else {
                node1 = node2;
                node2 = cur;
            }
            cur = cur -> right;
        } else {
            pre = cur -> left;
            while (pre -> right && pre -> right != cur) pre = pre -> right;
            if (pre -> right == NULL) {
                pre -> right = cur;
                cur = cur -> left;
                continue;
            } else {
                pre -> right = NULL;
                if (node2 == NULL) node2 = cur;
                else {
                    node1 = node2;
                    node2 = cur;
                }
                cur = cur -> right;
            }
        }
        if (node1 && node2 && node1 -> val > node2 -> val) {

            if (first == NULL) first = node1;
            second = node2;
        }
    }
    /* Now lets return the answer */
    vector < int > ans;
    ans.push_back(min(first -> val, second -> val));
    ans.push_back(max(first -> val, second -> val));
    return ans;
}
```

