### Q2. Equal Tree Partition
#### Problem Description
```text
Given a binary tree A. Check whether it is possible to partition 
the tree to two trees which have equal sum of values after removing 
exactly one edge on the original tree.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= size of tree &lt;= 100000</p>
    <p>0 &lt;= value of node &lt;= 10<sup>9</sup></p>
</div>

```text
1 <= size of tree <= 100000

0 <= value of node <= 10^9
```
#### Input Format
```text
First and only argument is head of tree A.
```
#### Output Format
```text
Return 1 if the tree can be partitioned into two trees of equal sum 
else return 0.
```
#### Example Input
```text
Input 1:
 
                5
               /  \
              3    7
             / \  / \
            4  6  5  6

Input 2:
 
                1
               / \
              2   10
                  / \
                 20  2
```
#### Example Output
```text
Output 1:
 1

Output 2:
 0
```
#### Example Explanation
```text
Explanation 1:

 Remove edge between 5(root node) and 7: 
 
        Tree 1 =                                        Tree 2 =
                        5                                              7
                       /                                              / \
                      3                                              5   6    
                     / \
                    4   6
        Sum of Tree 1 = Sum of Tree 2 = 18

Explanation 2:
 The given Tree cannot be partitioned.
```
### Hints
* Hint 1
```text
After removing some edge from parent to child,
(where the child cannot be the original root)
the subtree rooted at child must be half the sum of the entire tree.
```
* Solution Approach
```text
After removing some edge from parent to child,
(where the child cannot be the original root)
the subtree rooted at child must be half the sum of the entire tree.

Let’s record the sum of every subtree. We can do this recursively 
using depth-first search.

After, we should check that half the sum of the entire tree occurs 
somewhere in our recording (and not from the total of the entire tree.)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(TreeNode a) {
        Map < Long, Integer > map = new HashMap < > ();
        long tot = populate(a, map);
        // since total sum can also be zero
        if (tot == 0) 
            return map.getOrDefault(tot, 0) > 1 ? 1 : 0;
        return tot % 2 == 0 && map.containsKey(tot / 2) ? 1 : 0;
    }
    public long populate(TreeNode a, Map < Long, Integer > map) {
        if (a == null) 
            return 0;
        long sum = a.val + populate(a.left, map) + populate(a.right, map);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
  solve: function (A) {
    let seen = [];
    let root = A;
    function sum_(node) {
      if (!node) return 0;
      seen.push(sum_(node.left) + sum_(node.right) + node.data);
      return seen[seen.length - 1];
    }

    let total = sum_(root);
    seen.pop();
    let ret = 0;
    seen.forEach((ele) => {
      if (ele == Math.floor(total / 2)) ret = 1;
    });
    return ret;
  },
};
```
* * Solution in C++
```cpp
long dfs(TreeNode * root, unordered_map < long, int > & m) {
    if (!root)
        return 0;
    long cur = root -> val + dfs(root -> left, m) + dfs(root -> right, m);
    ++m[cur];
    return cur;
}

int checkEqualPartition(TreeNode * root) {
    unordered_map < long, int > m;
    long sum = dfs(root, m);
    if (sum == 0) {
        if (m[0] > 1)
            return 1;
        return 0;
    }
    if (sum % 2)
        return 0;
    if (m.count(sum / 2))
        return 1;
    return 0;
}

int Solution::solve(TreeNode * A) {
    return checkEqualPartition(A);
}
```

