### Q3. Two Sum BST
#### Problem Description
```text
Given a binary search tree A, where each node contains a positive 
integer, and an integer B, you have to find whether or not there 
exist two different nodes X and Y such that X.value + Y.value = B.

Return 1 to denote that two such nodes exist. Return 0, otherwise.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= size of tree &lt;= 100000</p>
    <p>1 &lt;= B &lt;= 10<sup>9</sup></p>
</div>

```text
1 <= size of tree <= 100000

1 <= B <= 10^9
```
#### Input Format
```text
First argument is the head of the tree A.

Second argument is the integer B.
```
#### Output Format
```text
Return 1 if such a pair can be found, 0 otherwise.
```
#### Example Input
```text
Input 1:

         10
         / \
        9   20

B = 19

Input 2:

 
          10
         / \
        9   20

B = 40
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
    10 + 9 = 19. Hence 1 is returned.

Explanation 2:
    No such pair exists.
```
### Hints
* Hint 1
```text
How would you solve with O(N) memory?

Let’s say you are given a sorted array and you need to
find two indices i < j, such that A[i] = A[j].

Can you relate between a sorted array and a BST?

Can you avoid O(N) memory and do with O(height) memory?
```
* Solution Approach
```text
How would you solve with O(N) memory? Let’s say you are given a sorted 
array and you need to find two indices i < j, such that A[i] = A[j]. 
Can you relate between a sorted array and a BST? Can you avoid 
O(N) memory and do with O(height) memory?

If you do inorder traversal of BST you visit elements in increasing 
order. So, we use a two pointer approach, where we keep two pointers 
pt1 and pt2. Initially pt1 is at smallest value and pt2 at largest value.

Then we compare sum = pt1.value + pt2.value. If sum < target, we 
increase pt1, else we decrease pt2 until we reach target.

Using the same concept used 
in https://www.interviewbit.com/courses/programming/topics/trees/problems/treeiterator/ we can do this.
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
    public int t2Sum(TreeNode A, int B) {
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        TreeNode current1 = A;
        TreeNode current2 = A;

        while (((stack1.size() > 0) || current1 != null) || (stack2.size() > 0) || current2 != null) {
            if (current1 != null || current2 != null) {
                if (current1 != null) {
                    stack1.push(current1);
                    current1 = current1.left;
                }
                if (current2 != null) {
                    stack2.push(current2);
                    current2 = current2.right;
                }
            } else {
                if (stack1.size() == 0 || stack2.size() == 0)
                    break;
                TreeNode node1 = stack1.peek();
                TreeNode node2 = stack2.peek();

                int sum = node1.val + node2.val;
                if (node1.val == node2.val) {
                    return 0;
                } else if (sum == B)
                    return 1;
                else if (sum < B) {
                    stack1.pop();
                    current1 = node1.right;
                } else {
                    stack2.pop();
                    current2 = node2.left;
                }
            }
        }
        return 0;
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
    //param B : integer
    //return an integer
    t2Sum: function (A, B) {

        let stack1 = [];
        let stack2 = [];
        let current1 = A;
        let current2 = A;

        while (((stack1.length > 0) || current1) || (stack2.length > 0) || current2) {
            if (current1 || current2) {
                if (current1) {
                    stack1.push(current1);
                    current1 = current1.left;
                }
                if (current2) {
                    stack2.push(current2);
                    current2 = current2.right;
                }
            } else {
                if (stack1.length == 0 || stack2.length == 0)
                    break;
                let node1 = stack1[stack1.length - 1];
                let node2 = stack2[stack2.length - 1];

                let sum = node1.data + node2.data;
                if (node1.data == node2.data) {
                    return 0;
                } else if (sum == B)
                    return 1;
                else if (sum < B) {
                    stack1.pop();
                    current1 = node1.right;
                } else {
                    stack2.pop();
                    current2 = node2.left;
                }
            }
        }
        return 0;
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

TreeNode * getIterator(TreeNode * root, TreeNode * prev) {
    if (root == nullptr)
        return nullptr;
    TreeNode * start = getIterator(root -> left, root);
    if (start == nullptr)
        start = root;
    if (root -> right)
        root -> right = getIterator(root -> right, prev);
    else
        root -> right = prev;
    return start;
}

int Solution::t2Sum(TreeNode * root, int k) {
    TreeNode * head = getIterator(root, nullptr), * p = head -> right, * prev = head;
    while (p) {
        p -> left = prev;
        prev = p;
        p = p -> right;
    }
    TreeNode * l = head, * r = prev;
    while (l && r && l -> val < r -> val) {
        int sum = (r -> val) + (l -> val);
        if (sum == k)
            return 1;
        if (sum > k)
            r = r -> left;
        else
            l = l -> right;
    }
    return 0;
}
```

