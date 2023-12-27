### Q2. Tree Height
#### Problem Description
```text
You are given the root node of a binary tree A. You have to find 
the height of the given tree.

A binary tree's height is the number of nodes along the longest 
path from the root node down to the farthest leaf node.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= Number of nodes in the tree &lt;= 10<sup>5</sup></p>
    <p>0 &lt;= Value of each node &lt;= 10<sup>9</sup></p>
</div>

```text
1 <= Number of nodes in the tree <= 10^5

0 <= Value of each node <= 10^9
```
#### Input Format
```text
The first and only argument is a tree node A.
```
#### Output Format
```text
Return an integer denoting the height of the tree.
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
 2 

Output 2:
 3 
```
#### Example Explanation
```text
Explanation 1:
    Distance of node having value 1 from root node = 1
    Distance of node having value 4 from root node = 2 (max)
    Distance of node having value 3 from root node = 2 (max)

Explanation 2:
    Distance of node having value 1 from root node = 1
    Distance of node having value 4 from root node = 2
    Distance of node having value 3 from root node = 2
    Distance of node having value 2 from root node = 3 (max)
```
### Hints
* Hint 1
```text
Try to solve the problem recursively.
```
* Solution Approach
```text
If the root node is Null, we can say the height is 0.

Else the tree's height will be 1 + (maximum out of left child's 
subtree height and right child's subtree height).
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
        if(A == null)
            return 0;
        return 1 + Math.max(solve(A.left), solve(A.right));
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
 //return an integer
	solve : function(A){
        if (A === null) return 0;
        return 1 + Math.max(this.solve(A.left), this.solve(A.right));
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

int Solution::solve(TreeNode* A) {
    if(A == NULL) return 0;
    return 1 + max(solve(A -> left),solve(A -> right));
}
```

