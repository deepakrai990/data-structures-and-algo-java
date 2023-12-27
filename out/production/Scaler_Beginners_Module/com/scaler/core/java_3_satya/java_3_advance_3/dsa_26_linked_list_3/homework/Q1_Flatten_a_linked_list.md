### Q1. Flatten a linked list
#### Problem Description
```text
Given a linked list where every node represents a linked list 
and contains two pointers of its type:

    1. Pointer to next node in the main list (right pointer)
    
    2. Pointer to a linked list where this node is 
       head (down pointer). All linked lists are sorted.

You are asked to flatten the linked list into a single 
list. Use down pointer to link nodes of the flattened 
list. The flattened linked list should also be sorted.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= Total nodes in the list &lt;= 100000</p>
    <p>1 &lt;= Value of node &lt;= 10<sup>9</sup></p>
</div>

```text
1 <= Total nodes in the list <= 100000

1 <= Value of node <= 10^9
```
#### Input Format
```text
The only argument given is head pointer of the doubly linked list.
```
#### Output Format
```text
Return the head pointer of the Flattened list.
```
#### Example Input
```text
Input 1:
   3 -> 4 -> 20 -> 20 ->30
   |    |    |     |    |
   7    11   22    20   31
   |               |    |
   7               28   39
   |               |
   8               39

Input 2:
   2 -> 4 
   |    |       
   7    11    
   |            
   7
```
#### Example Output
```text
Output 1:
 3 -> 4 -> 7 -> 7 -> 8 -> 11 -> 20 -> 20 -> 20 -> 22 -> 28 -> 30 -> 31 -> 39 -> 39 

Output 2:
 2 -> 4 -> 7 -> 7 -> 11
```
#### Example Explanation
```text
Explanation 1:
    The return linked list is the flatten sorted list.
```
### Hints
* Hint 1
```text
Consider each list as an independent list.

As each of the lists is sorted, initially think of a way 
to merge n lists into a single list.
```
* Solution Approach
```text
What if we were given only two lists how we would have merged them?

The idea is to extend the same on multiple lists, select any 
two list and merge them to make a single list.

Now we have (total - 1) lists to merge, again repeat the above 
process until we have only one list left.
```
* Complete Solution
* * Solution in Java
```java
/*
class ListNode {
    int val;
    ListNode right, down;
    ListNode(int x) {
        val = x;
        right = down = null;
    }
}
*/
class Solution {
    ListNode merge(ListNode a, ListNode b) {
        if (a == null)
            return b;
        if (b == null)
            return a;
        ListNode result;
        if (a.val < b.val) {
            result = a;
            result.down = merge(a.down, b);
        } else {
            result = b;
            result.down = merge(a, b.down);
        }
        return result;
    }

    ListNode flatten(ListNode root) {
        if (root == null || root.right == null)
            return root;
        return merge(root, flatten(root.right));
    }
    
    class ListNode {
        int val;
        ListNode right, down;
        ListNode(int x) {
            val = x;
            right = down = null;
        }
    }
}
```
* * Solution in Javascript
```javascript
// Definition for linked list.
//          function Node(data) {
//              this.data = data
//              this.right = null
//              this.down = null
//              }
function merge(A, B) {
    
    if( A == null)
        return B;
    if( B == null)
        return A;
    
    let result = null;
    if( A.data < B.data) {
        result = A;
        result.down = merge(A.down,B);
    }
    else {
        
        result = B;
        result.down = merge(A, B.down);
    }
    return result;
}
function flatten(root) {
    
    if(root == null || root.right == null)
        return root;
    
    return merge(root, flatten(root.right));

}
```
* * Solution in C++
```cpp
/*
struct ListNode {
    int val;
    ListNode *right,*down;
    ListNode(int x) {
        val = x;
        right = down = NULL;
    }
};
*/

ListNode * merge(ListNode * a, ListNode * b) {
    if (a == NULL)
        return b;
    if (b == NULL)
        return a;
    ListNode * result;
    if (a -> val < b -> val) {
        result = a;
        result -> down = merge(a -> down, b);
    } else {
        result = b;
        result -> down = merge(a, b -> down);
    }
    return result;
}

ListNode * flatten(ListNode * root) {
    if (root == NULL || root -> right == NULL)
        return root;
    return merge(root, flatten(root -> right));
}
```

