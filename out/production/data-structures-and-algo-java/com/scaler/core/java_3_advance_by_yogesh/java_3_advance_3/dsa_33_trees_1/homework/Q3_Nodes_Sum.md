### Q3. Nodes Sum
#### Problem Description
```text
You are given the root node of a binary tree A. You have to find 
the sum of node values of this tree.
```
#### Problem Constraints
```text
1 <= Number of nodes in the tree <= 10^5

0 <= Value of each node <= 10^4
```
#### Input Format
```text
First and only argument is a tree node A.
```
#### Output Format
```text
Return an integer denoting the sum of node values of the tree.
```
#### Example Input
```text
Input 1:
 
 Values =  1 
          / \     
         4   3                        


Input 2:

 Values =  1      
          / \     
         8   3                       
        /         
       2                                     
```
#### Example Output
```text
Output 1:
 8 

Output 2:
 14 
```
#### Example Explanation
```text
Explanation 1:
    Clearly, 1 + 4 + 3 = 8.

Explanation 2:
    Clearly, 1 + 8 + 3 + 2 = 14.
```
### Hints
* Hint 1
```text
Just do BFS or DFS over the tree.
```
* Solution Approach
```text
Let's solve this question by recursive approach.

Run a recursive function with the root node.

Then call left and right child inside the function if they exist. 

Afterwards in the recursive function increase the sum variable 
with the node values accordingly.

Return void from the function if the node value is NULL.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    private static int solve(TreeNode A) {
        return nodesSum(A);
    }
    private static int nodesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = nodesSum(root.left);
        int rightSum = nodesSum(root.right);
        return leftSum + rightSum + root.val;
    }
}
```
* * Solution in Javascript
```javascript
/** Not available **/
```
* * Solution in C++
```cpp
void count(TreeNode* A, int &ans){
    if(A == NULL) return;
    ans += A->val;
    count(A->left,ans);
    count(A->right,ans);
}

int Solution::solve(TreeNode* A) {
    int ans=0;
    count(A,ans);
    return ans;
}
```

