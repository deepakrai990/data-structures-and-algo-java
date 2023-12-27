### Q1. Nodes Count
#### Problem Description
```text
You are given the root node of a binary tree A. You have to find 
the number of nodes in this tree.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= Number of nodes in the tree &lt;= 10<sup>5</sup></p>
    <p>0 &lt;= Value of each node &lt;= 10<sup>7</sup></p>
</div>

```text
1 <= Number of nodes in the tree <= 10^5

0 <= Value of each node <= 10^7
```
#### Input Format
```text
The first and only argument is a tree node A.
```
#### Output Format
```text
Return an integer denoting the number of nodes of the tree.
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
         4   3                       
        /         
       2  
```
#### Example Output
```text
Output 1:

 3 

Output 2:

 4 
```
#### Example Explanation
```text
Explanation 1:

    Clearly, there are 3 nodes 1, 4 and 3.

Explanation 2:

    Clearly, there are 4 nodes 1, 4, 3 and 2.
```
### Hints
* Hint 1
```text
Just do BFS or DFS over the tree.
```
* Solution Approach
```text
Run a recursive function, call left and right children if they 
exist, and increase the answer variable accordingly.  
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int dfs(TreeNode cur) {
        if (cur == null) return 0;
        return 1 + dfs(cur.left) + dfs(cur.right);
    }

    public int solve(TreeNode A) {
        return dfs(A);
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
function count(A, ans) {
    if (A === null) return;
    ans.value++;
    count(A.left, ans);
    count(A.right, ans);
}

module.exports = {
    //param A : root node of tree
    //return an integer
    solve: function (A) {
        const ans = {value: 0};
        count(A, ans);
        return ans.value;
    }
};
```
* * Solution in C++
```cpp
void count(TreeNode* A, int &ans){
    if(A == NULL) return;
    ans++;
    count(A->left,ans);
    count(A->right,ans);
}
int Solution::solve(TreeNode* A) {
    int ans=0;
    count(A,ans);
    return ans;
}
```

