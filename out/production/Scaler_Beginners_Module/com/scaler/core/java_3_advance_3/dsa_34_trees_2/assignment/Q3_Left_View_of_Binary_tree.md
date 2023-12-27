### Q3. Left View of Binary tree
#### Problem Description
```text
Given a binary tree of integers. Return an array of integers 
representing the left view of the Binary tree.

Left view of a Binary Tree is a set of nodes visible when the tree 
is visited from Left side

NOTE: The value comes first in the array which have lower level.
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
First and only argument is a root node of the binary tree, A.
```
#### Output Format
```text
Return an integer array denoting the left view of the Binary tree.
```
#### Example Input
```text
Input 1:

            1
          /   \
         2    3
        / \  / \
       4   5 6  7
      /
     8 

Input 2:

            1
           /  \
          2    3
           \
            4
             \
              5
```
#### Example Output
```text
Output 1:
 [1, 2, 4, 8]

Output 2:
 [1, 2, 4, 5]
```
#### Example Explanation
```text
Explanation 1:
    The Left view of the binary tree is returned.
```
### Hints
* Hint 1
```text
Try to Modify the the level order traversal of tree to find the 
solution for this problem.
```
* Solution Approach
```text
For each level whenever you encounters the first node on that 
level append it to the answer.

Try to Modify the the level order traversal of tree 
for this problem.

You can use queue to solve this problem as we do in level 
order traversal.
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

class Pair {

    public TreeNode first;
    public int second;

    public Pair(TreeNode x, int y) {
        first = x;
        second = y;
    }
}
public class Solution {
    public ArrayList < Integer > solve(TreeNode A) {

        ArrayList < Integer > ans = new ArrayList < Integer > ();
        Queue < Pair > q = new LinkedList < > ();
        int l = 0;

        q.add(new Pair(A, 0));
        while (q.size() > 0) {
            TreeNode temp = q.peek().first;
            int temp_l = q.peek().second;

            if (temp.left != null) {
                q.add(new Pair(temp.left, temp_l + 1));
            }
            if (temp.right != null) {
                q.add(new Pair(temp.right, temp_l + 1));
            }
            if (temp_l == l) {
                // append the first node of each level to the answer
                ans.add(temp.val);
                l++;
            }
            q.remove();
        }
        return ans;
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
    solve: function (A) {
        let ans = [];
        let q = [];
        let l = 0;
        q.push([A, 0]);
        while (q.length > 0) {
            let val = q.pop();
            let temp = val[0];
            let temp_l = val[1];
            if (temp.left != null) {
                q.unshift([temp.left, temp_l + 1]);
            }
            if (temp.right != null) {
                q.unshift([temp.right, temp_l + 1]);
            }
            if (temp_l == l) {
                // append the first node of each level to the answer
                ans.push(temp.data);
                l++;
            }
        }
        return ans;
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
vector < int > Solution::solve(TreeNode * A) {
    vector < int > ans;
    queue < pair < TreeNode * , int >> q;
    int l = 0;
    q.push({A, 0});
    while (!q.empty()) {
        TreeNode * temp = q.front().first;
        int temp_l = q.front().second;
        if (temp -> left != NULL) {
            q.push({temp -> left, temp_l + 1});
        }
        if (temp -> right != NULL) {
            q.push({temp -> right, temp_l + 1});
        }
        if (temp_l == l) {
            // append the first node of each level to the answer
            ans.push_back(temp -> val);
            l++;
        }
        q.pop();
    }
    return ans;
}
```

