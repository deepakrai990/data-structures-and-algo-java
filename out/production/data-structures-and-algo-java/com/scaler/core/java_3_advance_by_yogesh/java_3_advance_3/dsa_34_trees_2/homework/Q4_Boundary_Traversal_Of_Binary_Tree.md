### Q4. Boundary Traversal Of Binary Tree
#### Problem Description
```text
Given a binary tree, return the values of its boundary in anti-clockwise 
direction starting from the root. Boundary includes left boundary, 
leaves, and right boundary in order without duplicate nodes.

Left boundary is defined as the path from the root to the left-most 
node. Right boundary is defined as the path from the root to the 
right-most node. If the root doesn't have left subtree or 
right subtree, then the root itself is left boundary or right boundary. 
Note this definition only applies to the input binary tree, and not 
applies to any subtrees.

The left-most node is defined as a leaf node you could reach when you 
always firstly travel to the left subtree if exists. If not, travel 
to the right subtree. Repeat until you reach a leaf node.

The right-most node is also defined by the same way with left and 
right exchanged.

Return an array of integers denoting the boundary values of tree in 
anti-clockwise order.
```
#### Problem Constraints
```text
/** Not available **/
```
#### Input Format
```text
/** Not available **/
```
#### Output Format
```text
/** Not available **/
```
#### Example Input
```text
Input 1:
               _____1_____
              /           \
             2             3
            / \            / 
           4   5          6   
              / \        / \
             7   8      9  10  
Output 1:
    [1, 2, 4, 7, 8, 9, 10, 6, 3]
    Explanation 1:
        The left boundary are node 1,2,4. (4 is the left-most node according to definition)
        The leaves are node 4,7,8,9,10.
        The right boundary are node 1,3,6,10. (10 is the right-most node).
        So order them in anti-clockwise without duplicate nodes we have [1,2,4,7,8,9,10,6,3].

Input 2:
                1
               / \
              2   3
             / \  / \
            4   5 6  7
Output 2:
     [1, 2, 4, 5, 6, 7, 3] 
```
#### Example Output
```text
/** Not available **/
```
#### Example Explanation
```text
/** Not available **/
```
### Hints
* Hint 1
```text
/** Not available **/
```
* Solution Approach
```text
Find the Leftmost boundary path:
This path can be found in top down manner and store this in temp array.
Find all the leaves from left to right:
Find all leaf nodes using inorder traversal and store them at the end of temp array.
Find the Rightmost boundary path:
This path can be found in bottom up manner and store this at the end of temp array.
Now traverse temp array and remove duplicates.
```
* Complete Solution
* * Solution in Java
```java
/** Not available **/
```
* * Solution in Javascript
```javascript
/** Not available **/
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

void leftMost(TreeNode* root, vector<TreeNode *> &vec){
    while(root){
        vec.push_back(root);
        if(root->left)
            root = root->left;
        else
            root = root->right;
    }
}


void leaf(TreeNode* root, vector<TreeNode *> &vec){
    if(root){
        if(!root->left && !root->right)
            vec.push_back(root);
        if(root->left)
            leaf(root->left, vec);
        if(root->right)
            leaf(root->right, vec);
    }
}

void rightMost(TreeNode* root, vector<TreeNode *> &vec){
        stack<TreeNode *> st;
    while(root){
        st.push(root);
        if(root->right)
            root = root->right;
        else
            root = root->left;
    }
    while(!st.empty()){
        vec.push_back(st.top());
        st.pop();
    }
}

vector<int> boundaryTraversal(TreeNode* root) {
    vector<int> ans;
    if(!root)
        return ans;
    vector<TreeNode *> tmp;
    unordered_set<TreeNode *> s;
    leftMost(root, tmp);
    leaf(root, tmp);
    rightMost(root, tmp);
    for(TreeNode *p : tmp){
        if(s.find(p) == s.end()){
            ans.push_back(p->val);
            s.insert(p);
            }
    }
    return ans;
}


vector<int> Solution::solve(TreeNode* A) {
    return boundaryTraversal(A);
}
```

