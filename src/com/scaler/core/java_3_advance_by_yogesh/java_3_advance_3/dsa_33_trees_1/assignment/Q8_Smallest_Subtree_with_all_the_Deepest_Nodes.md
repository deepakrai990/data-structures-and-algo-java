### Q8. Smallest Subtree with all the Deepest Nodes
#### Problem Description
```text
Given a binary tree with root node pointer A . The depth of each node 
is the shortest distance to the root. A node is deepest if it has 
the largest depth possible among any node in the entire tree.

The subtree of a node is that node, plus the set of all descendants 
of that node.

Return the node with the largest depth such that it contains all the 
deepest nodes of the entire tree lies in its subtree.

NOTE: All nodes values are uniques in the tree.
```
#### Problem Constraints
```text
1 <= Total number of nodes <= 100000
0 <= Nodes values <= 10
```
#### Input Format
```text
The only arguments given are root pointer A.
```
#### Output Format
```text
Return the node with the largest depth such that it contains all 
the deepest nodes of the entire tree lies in its subtree.
```
#### Example Input
```text
Input

       1
      / \
     2   3
    / \  \
   6   4  5
      / \
     12  13 
```
#### Example Output
```text
Output

      4
     / \
    12  13
```
#### Example Explanation
```text
Explanation

    Considering depth of root node as 0.
    Maximum depth is 3.
    Node with value 12 has depth 3.
    Node with value 13 has depth 3.
    Smallest subtree which contains 12 and 13 is (4,12,13).
```
### Hints
* Hint 1
```text
Identify the deepest node in the tree.
find leftmost and rightmost node having maximum depth.
Now think of finding the node form these leftmost and rightmost nodes.
```
* Solution Approach
```text
1. We do preorder traversal and keep track of the maxDepth.

2. If current node is a leaf, and it exceeds maxDepth, we 
   set ‘first’ to this node and second to null (reset).

3. If current node is a leaf and depth equals maxDepth, we 
   set ‘second’ to this node.

4. Now that we have the left most and right most deepest nodes, 
   we simply find the lowest common ancestor. This is the subtree 
   we are looking for.

5. In the case of only one deepest node, second is null so we 
   return first.
```
* Complete Solution
* * Solution in Java
```java
/** not available **/
```
* * Solution in Javascript
```javascript
/** not available **/
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

int maxDepth = -1;
TreeNode* first ;
TreeNode* second;

void DFS(TreeNode* root, int depth) {
    if (root==NULL)
        return;
    if (root->left==NULL && root->right==NULL) {
        if (depth > maxDepth) {
            first = root;
            second = NULL;
            maxDepth = depth;
        }
        else if (depth == maxDepth) {
            second = root;
        }
    }
    DFS(root->left, depth + 1);
    DFS(root->right, depth + 1);
}

TreeNode* lca(TreeNode* root, TreeNode* p, TreeNode* q) {
    if (!root)
        return NULL;
    if (p == root || q == root)
        return root;
    auto left = lca(root->left, p, q);
    auto right = lca(root->right, p, q);
    if (left && right) return root;
    return left ? left : right;
}

 
TreeNode* Solution::solve(TreeNode* A) {
    if (!A)
        return A;

    maxDepth = -1;
    first = NULL;
    second = NULL;
    DFS(A, 0);
    return !second ? first : lca(A, first, second);
    
}
```

