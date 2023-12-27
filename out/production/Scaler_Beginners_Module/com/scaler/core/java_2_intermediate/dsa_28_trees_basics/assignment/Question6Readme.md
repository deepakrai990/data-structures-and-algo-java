### Q6. Sum of nodes of a Binary Tree
#### Problem Description
```text
Given the root of a binary tree A. Return the sum of all the 
nodes of the binary tree.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= Number of nodes in A &lt;= 10<sup>4</sup><br>
    1 &lt;= value of each node &lt;= 10<sup>4</sup></p>
</div>

```text
1 <= Number of nodes in A <= 10^4
1 <= value of each node <= 10^4
```
#### Input Format
```text
First argument is the root of binary tree A.
```
#### Output Format
```text
Return an integer denoting the sum of all the nodes
```
#### Example Input
```text
Input 1:

 A =   2                 
      / \                           
     1   4            
    /                           
   5

Input 2:

A =   3
      / \
      6  1
      \   \
       2   7
```
#### Example Output
```text
Output 1:
 12

Output 2:
 19
```
#### Example Explanation
```text
Explanation 1:
    The sum of all the nodes is 12

Explanation 2:
    The sum of all the nodes is 19
```
### Hints
* Hint 1
```text
We need to traverse all the nodes and
calculate the sum
```
* Solution Approach
```text
We will do level order traversing by using a queue.

Initially we add the root to the queue, after that we keep
popping the front node of the queue, add it's sum and then
push it's child nodes to the back of the queue.

Time Complexity : O(N)
Space Complexity : O(N)

where N is the number of nodes of the binary tree
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
    public int sum(TreeNode A){
        if(A == null){
            return 0;
        }
        return A.val + sum(A.left) + sum(A.right);
    }
    public int solve(TreeNode A) {
        return sum(A);
    }
}
```
* * Solution in Javascript
```javascript
/** Not available **/
```
* * Solution in C++
```cpp
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
    public int sum(TreeNode A){
        if(A == null){
            return 0;
        }
        return A.val + sum(A.left) + sum(A.right);
    }
    public int solve(TreeNode A) {
        return sum(A);
    }
}
```

