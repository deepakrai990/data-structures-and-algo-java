### Q1. Common Nodes in Two BST
#### Problem Description
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>Given two BST's <strong>A</strong> and <strong>B</strong>, 
    return the <strong>(sum of all common nodes in both A and B) % (10<sup>9</sup> +7) 
    </strong> .</p>
    <p>In case there is no common node, return 0.</p>
    <p><strong>NOTE:</strong></p>
    <p>Try to do it one pass through the trees.</p>
</div>

```text
Given two BST's A and B, return the (sum of all common nodes in both A and B) % (10^9 +7) .

In case there is no common node, return 0.

NOTE:

Try to do it one pass through the trees.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= Number of nodes in the tree A and B &lt;= 10<sup>5</sup></p>
    <p>1 &lt;= Node values &lt;= 10<sup>6</sup><br></p>
</div>

```text
1 <= Number of nodes in the tree A and B <= 10^5

1 <= Node values <= 10^6
```
#### Input Format
```text
First argument represents the root of BST A.

Second argument represents the root of BST B.
```
#### Output Format
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>Return an integer denoting the <strong>(sum of all common nodes in 
    both BST's A and B) % (10<sup>9</sup> +7) </strong>.</p>
</div>

```text
Return an integer denoting the (sum of all common nodes in both BST's A and B) % (10^9 +7) .
```
#### Example Input
```text
Input 1:

 Tree A:
    5
   / \
  2   8
   \   \
    3   15
        /
        9

 Tree B:
    7
   / \
  1  10
   \   \
    2  15
       /
      11
      
Input 2:

  Tree A:
    7
   / \
  1   10
   \   \
    2   15
        /
       11

 Tree B:
    7
   / \
  1  10
   \   \
    2  15
       /
      11
```
#### Example Output
```text
Output 1:
 17

Output 2:
 46
```
#### Example Explanation
```text
Explanation 1:
    Common Nodes are : 2, 15
    So answer is 2 + 15 = 17

Explanation 2:
    Common Nodes are : 7, 2, 1, 10, 15, 11
    So answer is 7 + 2 + 1 + 10 + 15 + 11 = 46
```
### Hints
* Hint 1
```text
Inorder Traversal of BST return an sorted array.

Also think of finding intersection of two sorted arrays using two pointers and 
try to apply it on this question.
```
* Solution Approach
```text
Method 1 (Linear Time) We can find common elements in O(n) time.

1) Do inorder traversal of first tree and store the traversal in an auxiliary array ar1[].
2) Do inorder traversal of second tree and store the traversal in an auxiliary array ar2[]
3) Find intersection of ar1[] and ar2[].

Time complexity of this method is O(m+n) where m and n are number of nodes in first 
and second tree respectively.

This solution requires O(m+n) extra space.

Method 2 (Linear Time and limited Extra Space) We can find common elements 
in O(n) time and O(h1 + h2) extra space where h1 and h2 are heights of first and 
second BSTs respectively.

The idea is to use iterative inorder traversal. We use two auxiliary stacks for 
two BSTs. Since we need to find common elements, whenever we get same element, 
we add it to the sum .
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
    public int solve(TreeNode A, TreeNode B) {
        int temp = (int) common(A, B);
        return temp;
    }

    public static long common(TreeNode root1, TreeNode root2) {
        int mod = 1000000007;
        long sum = 0;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        while (true) {
            // push the Nodes of first tree in stack s1  
            if (root1 != null) {
                s1.push(root1);
                root1 = root1.left;
            }
            // push the Nodes of second tree in stack s2  
            else if (root2 != null) {
                s2.push(root2);
                root2 = root2.left;
            }
            // Both root1 and root2 are NULL here  
            else if (!s1.isEmpty() && !s2.isEmpty()) {
                root1 = s1.peek();
                root2 = s2.peek();
                // If current keys in two trees are same  
                if (root1.val == root2.val) {
                    long temp = (long) root1.val;
                    sum = ((sum % mod) + (temp % mod)) % mod;
                    s1.pop();
                    s2.pop();
                    // move to the inorder successor  
                    root1 = root1.right;
                    root2 = root2.right;
                } else if (root1.val < root2.val) {
                    // If Node of first tree is smaller, than that of  
                    // second tree, then its obvious that the inorder  
                    // successors of current Node can have same value  
                    // as that of the second tree Node. Thus, we pop  
                    // from s2  
                    s1.pop();
                    root1 = root1.right;
                    // root2 is set to NULL, because we need  
                    // new Nodes of tree 1  
                    root2 = null;
                } else if (root1.val > root2.val) {
                    s2.pop();
                    root2 = root2.right;
                    root1 = null;
                }
            }
            // Both roots and both stacks are empty  
            else
                break;
        }
        return sum;
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
    //param B : root node of tree
    //return an integer
    solve: function (A, B) {

        var sum = 0;
        const M = 1000000007;

        let stackA = [];
        let currentA = A;

        let stackB = [];
        let currentB = B;

        while ((stackA.length > 0 || currentA) || (stackB.length > 0 || currentB)) {
            if (currentA || currentB) {
                if (currentA) {
                    stackA.push(currentA);
                    currentA = currentA.left;
                }
                if (currentB) {
                    stackB.push(currentB);
                    currentB = currentB.left;
                }
            } else {

                if (stackA.length == 0 || stackB.length == 0)
                    break;

                let nodeA = stackA[stackA.length - 1];
                let nodeB = stackB[stackB.length - 1];

                if (nodeA.data == nodeB.data) {
                    sum = (sum + nodeB.data) % M;
                    stackA.pop();
                    currentA = nodeA.right;
                    stackB.pop();
                    currentB = nodeB.right;
                } else if (nodeA.data < nodeB.data) {
                    stackA.pop();
                    currentA = nodeA.right;
                } else {
                    stackB.pop();
                    currentB = nodeB.right;
                }
            }
        }
        return sum;
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
const long long int mod = 1e9 + 7;
int commonsum(TreeNode * root1, TreeNode * root2) {
    stack < TreeNode * > stack1, s1, s2;
    long long int sum = 0;
    while (1) {
        if (root1) {
            s1.push(root1);
            root1 = root1 -> left;
        } else if (root2) {
            s2.push(root2);
            root2 = root2 -> left;
        } else if (!s1.empty() && !s2.empty()) {
            root1 = s1.top();
            root2 = s2.top();
            if (root1 -> val == root2 -> val) {
                assert(sum <= INT_MAX - root1 -> val);
                sum = ((sum % mod) + ((root1 -> val) % mod)) % mod;
                s1.pop();
                s2.pop();
                root1 = root1 -> right;
                root2 = root2 -> right;
            } else if (root1 -> val < root2 -> val) {
                s1.pop();
                root1 = root1 -> right;
                root2 = NULL;
            } else if (root1 -> val > root2 -> val) {
                s2.pop();
                root2 = root2 -> right;
                root1 = NULL;
            }
        } else break;
    }
    return sum;
}

int Solution::solve(TreeNode * A, TreeNode * B) {
    return commonsum(A, B);
}
```

