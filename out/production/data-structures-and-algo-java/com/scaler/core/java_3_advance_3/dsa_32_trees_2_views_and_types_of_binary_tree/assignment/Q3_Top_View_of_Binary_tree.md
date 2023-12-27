### Q3. Top View of Binary tree
#### Problem Description
```text
Given a binary tree of integers denoted by root A. Return an array of integers 
representing the top view of the Binary tree.

The top view of a Binary Tree is a set of nodes visible when the tree is visited 
from the top.

Return the nodes in any order.
```
#### Problem Constraints
```text
1 <= Number of nodes in binary tree <= 100000

0 <= node values <= 10^9
```
#### Input Format
```text
First and only argument is head of the binary tree A.
```
#### Output Format
```text
Return an array, representing the top view of the binary tree.
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
 [1, 2, 4, 8, 3, 7]

Output 2:
 [1, 2, 3]
```
#### Example Explanation
```text
Explanation 1:
    Top view is described.

Explanation 2:
    Top view is described.
```
### Hints
* Hint 1
```text
Whenever you encounter the last node on that level, append it to the answer for each level.
Try to Modify the level order traversal of the tree for this problem.
```
* Solution Approach
```text
You need to return every node to be visible from the top.
In other words, it should be the leftmost or the rightmost till that level.
This can be found using a queue and modifying the level order
traversal algorithm. You may need to maintain the level of each
node along with the nodes themselves.
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
    public ArrayList<Integer> topview(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if (root == null)
            return ans;

        Queue<Pair> level = new LinkedList<Pair>();

        level.add(new Pair(root, 0));
        HashMap<Integer, Integer> top = new HashMap<Integer, Integer>();
        //Using Level order traversal to find the top view
        while (level.size() != 0) {
            Pair curr = level.peek();
            level.remove();
            if (top.get(curr.second) == null)
                top.put(curr.second, curr.first.val);

            if (curr.first.left != null) {
                level.add(new Pair(curr.first.left, curr.second - 1));
            }
            if (curr.first.right != null) {
                level.add(new Pair(curr.first.right, curr.second + 1));
            }
        }

        for (Map.Entry elem : top.entrySet()) {
            ans.add((int) elem.getValue());
        }
        return ans;
    }

    public ArrayList<Integer> solve(TreeNode A) {
        return topview(A);
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
    solve: function (root) {
        let a = [],
            b = [];
        if (root == null) {
            return [];
        }
        let root2 = root;
        while (root != null) {
            a.push(root.data);
            root = root.left;
        }
        while (root2 != null) {
            b.push(root2.data);
            root2 = root2.right;
        }
        if (b.length > 0) {
            b.shift();
        }
        let ans = a.concat(b);
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
vector < int > topview(TreeNode * root) {
    vector < int > ans;
    if (root == NULL)
        return ans;

    queue < pair < TreeNode * , int >> level;
    map < int, int > top;

    level.push({
        root,
        0
    });

    // Using Level order traversal to find the top view
    while (!level.empty()) {
        pair < TreeNode * , int > curr = level.front();
        level.pop();
        if (top.find(curr.second) == top.end())
            top[curr.second] = curr.first -> val;
        if (curr.first -> left != NULL) {
            level.push({
                curr.first -> left,
                curr.second - 1
            });
        }
        if (curr.first -> right != NULL) {
            level.push({
                curr.first -> right,
                curr.second + 1
            });
        }
    }

    for (auto i = top.begin(); i != top.end(); i++) {
        ans.push_back(i -> second);
    }
    return ans;
}

vector < int > Solution::solve(TreeNode * A) {
    return topview(A);
}
```

