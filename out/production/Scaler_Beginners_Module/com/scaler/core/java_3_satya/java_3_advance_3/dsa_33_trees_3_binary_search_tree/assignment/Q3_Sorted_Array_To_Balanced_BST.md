### Q3. Sorted Array To Balanced BST
#### Problem Description
```text
Given an array where elements are sorted in ascending order, convert 
it to a height Balanced Binary Search Tree (BBST).

Balanced tree : a height-balanced binary tree is defined as a binary 
tree in which the depth of the two subtrees of every node never 
differ by more than 1.
```
#### Problem Constraints
```text
1 <= length of array <= 100000
```
#### Input Format
```text
First argument is an integer array A.
```
#### Output Format
```text
Return a root node of the Binary Search Tree.
```
#### Example Input
```text
Input 1:
 A : [1, 2, 3]

Input 2:
 A : [1, 2, 3, 5, 10]
```
#### Example Output
```text
Output 1:

      2
    /   \
   1     3

Output 2:

      3
    /   \
   2     5
  /       \
 1         10
```
#### Example Explanation
```text
Explanation 1:
    You need to return the root node of the Binary Tree.
```
### Hints
* Hint 1
```text
What will happen when you choose the middle element of the array 
as the root?

After that, can you simulate the same thing for the left and right 
parts of the array?
```
* Solution Approach
```text
For a BST, all values lower than the root go in the left part of the root, 
and all values higher go in the right part of the root.

To balance the tree, we will need to make sure we distribute the elements 
almost equally in the left and right parts.

So we choose the mid part of the array as the root and divide the elements 
around it.

Things to take care of :
    1) Are you passing a copy of the array around, or are you only passing 
       around a reference?
    
    2) Are you dividing the array before passing it onto the next function 
       call or are you just specifying the start and end index?
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
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public TreeNode sortedArrayToBST(final int[] A) {
        return helper(A, 0, A.length - 1);
    }

    private TreeNode helper(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        if (l == r) {
            return new TreeNode(nums[l]);
        }
        TreeNode node = new TreeNode(nums[(l + r) / 2]);
        node.left = helper(nums, l, (l + r) / 2 - 1);
        node.right = helper(nums, (l + r) / 2 + 1, r);
        return node;
    }
}
```
* * Solution in Javascript
```javascript
// Definition for a binary tree node 
// function TreeNode(data){ 
//       this.data = data 
//       this.left = null 
//       this.right = null 
// } 
module.exports = {
    /*** param A: list of integer
     ***  return: root node of balanced BST
     ***/
    sortedArrayToBST: function (nums) {
        return buildBST(nums, 0, nums.length - 1);

        function buildBST(nums, low, high) {
            if (low < 0 || high > nums.length - 1) {
                return null;
            }
            if (nums.length == 0 || low > high) {
                return null;
            }
            let mid = low + Math.floor((high - low) / 2);
            let root = new TreeNode(nums[mid]);
            root.left = buildBST(nums, low, mid - 1);
            root.right = buildBST(nums, mid + 1, high);
            return root;
        }
    },
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
TreeNode * helper(const vector < int > & num, int low, int high) {
    if (low > high) { // Done
        return NULL;
    }
    int mid = (low + high) / 2;
    TreeNode * node = new TreeNode(num[mid]);
    node -> left = helper(num, low, mid - 1);
    node -> right = helper(num, mid + 1, high);
    return node;
}

TreeNode * Solution::sortedArrayToBST(const vector < int > & num) {
    if (num.size() == 0)
        return NULL;
    return helper(num, 0, ((int) num.size()) - 1);
}
```

