### Q2. Odd and Even Levels
#### Problem Description
```text
Given a binary tree of integers. Find the difference between 
the sum of nodes at odd level and sum of nodes at even level.

NOTE: Consider the level of root node as 1.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= Number of nodes in binary tree &lt;= 100000</p>
    <p>0 &lt;= node values &lt;= 10<sup>9</sup></p>
</div>

```text
1 <= Number of nodes in binary tree <= 100000

0 <= node values <= 10^9
```
#### Input Format
```text
First and only argument is a root node of the binary tree, A
```
#### Output Format
```text
Return an integer denoting the difference between the sum of nodes 
at odd level and sum of nodes at even level.
```
#### Example Input
```text
Input 1:

        1
      /   \
     2     3
    / \   / \
   4   5 6   7
  /
 8 

Input 2:

        1
       / \
      2   10
       \
        4
```
#### Example Output
```text
Output 1:
 10

Output 2:
 -7
```
#### Example Explanation
```text
Explanation 1:
    Sum of nodes at odd level = 23
    Sum of nodes at even level = 13

Explanation 2:
    Sum of nodes at odd level = 5
    Sum of ndoes at even level = 12
```
### Hints
* Hint 1
```text
Use level Order traversal to calculate the sum of nodes at odd level 
and even level.
```
* Solution Approach
```text
Use level Order traversal to calculate the sum of nodes at odd level 
and even level.

If the level is odd add the node value in the odd variable,
Else, add it in variable storing the sum of even levels.

After completing the traversal, return odd - even.
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

        Queue < TreeNode > q = new LinkedList < TreeNode > ();

        if (A == null)
            return 0;

        int oddsum = 0;
        int evensum = 0;
        int level = 0;
        q.add(A);

        while (q.size() > 0) {
            // q contains all the nodes in a level
            int n = q.size();
            level ^= 1;
            while (n--> 0) {
                TreeNode temp = q.peek();
                q.remove();
                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);

                if (level != 0)
                    oddsum += temp.val;
                else
                    evensum += temp.val;
            }
        }
        return (oddsum - evensum);

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
    solve: function (root) {
        let q = [];
        if (root == null)
            return 0;
        let oddsum = 0;
        let evensum = 0;
        let level = 0;
        q.push(root);
        while (q.length > 0) {
            // q contains all the nodes in a level
            let n = q.length;
            level ^= 1;
            while (n > 0) {
                n -= 1;
                let temp = q.shift();
                if (temp.left)
                    q.push(temp.left);
                if (temp.right)
                    q.push(temp.right);
                if (level)
                    oddsum += temp.data;
                else
                    evensum += temp.data;
            }
        }
        return (oddsum - evensum);
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

int differencebetweenoddandevenlevels(TreeNode * root) {
    queue < TreeNode * > q;
    if (root == NULL)
        return 0;
    int oddsum = 0;
    int evensum = 0;
    int level = 0;
    q.push(root);
    while (!q.empty()) {
        // q contains all the nodes in a level
        int n = q.size();
        level ^= 1;
        while (n--) {
            TreeNode * temp = q.front();
            q.pop();
            if (temp -> left)
                q.push(temp -> left);
            if (temp -> right)
                q.push(temp -> right);
            if (level)
                oddsum += temp -> val;
            else
                evensum += temp -> val;
        }
    }
    return (oddsum - evensum);
}
int Solution::solve(TreeNode * A) {
    return differencebetweenoddandevenlevels(A);
}
```

