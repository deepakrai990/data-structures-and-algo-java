### Q2. Partition List
#### Problem Description
```text
Given a linked list A and a value B, partition it such that 
all nodes less than B come before nodes greater than or equal to B.

You should preserve the original relative order of the nodes in 
each of the two partitions.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p> 1 &lt;= |A| &lt;= 10<sup>6</sup> </p>
    <p> 1 &lt;= A[i], B &lt;= 10<sup>9</sup> </p>
</div>

```text
1 <= |A| <= 10^6

1 <= A[i], B <= 10^9
```
#### Input Format
```text
The first argument of input contains a pointer to the head 
to the given linked list.

The second argument of input contains an integer, B.
```
#### Output Format
```text
Return a pointer to the head of the modified linked list.
```
#### Example Input
```text
Input 1:
 A = [1, 4, 3, 2, 5, 2]
 B = 3

Input 2:
 A = [1, 2, 3, 1, 3]
 B = 2
```
#### Example Output
```text
Output 1:
 [1, 2, 2, 4, 3, 5]

Output 2:
 [1, 1, 2, 3, 3]
```
#### Example Explanation
```text
Explanation 1:
    [1, 2, 2] are less than B where as [4, 3, 5] are greater than 
    or equal to B.

Explanation 2:
    [1, 1] are less than B where as [2, 3, 3] are greater than 
    or equal to B.
```
### Hints
* Hint 1
```text
Another pointer game.
Traverse the list while maintaining 
two pointers ( what should they represent?).

For this question, we have to maintain 2 pointers.

The first pointer is the one that maintains all nodes that 
are less than x.

The second pointer is the one that maintains the nodes that 
are greater than or equal to x.
```
* Solution Approach
```text
For this question, we have to maintain two pointers.

The first pointer is the one that maintains all nodes that 
are less than x.

The second pointer is the one that maintains the nodes that 
are greater than or equal to x.

As we traverse along with our list, when we are at a node that 
is greater than or equal to x,

we remove this node from our list and move it to a list of nodes 
that are greater than x.
```
* Complete Solution
* * Solution in Java
```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode A, int B) {
        ListNode lessPrev = null;
        ListNode greaterPrev = null;
        ListNode head = A;
        ListNode greaterHead = null;
        while (A != null) {
            if (A.val < B) {
                // contains the node with value < B
                if (lessPrev != null) {
                    // append A to the list
                    lessPrev.next = A;
                    lessPrev = A;
                } else {
                    // A is the starting node
                    lessPrev = A;
                    head = A;
                }
            } else {
                // contains the node with value >= B
                if (greaterPrev != null) {
                    // append A to the list
                    greaterPrev.next = A;
                    greaterPrev = A;
                } else {
                    // A is the starting node
                    greaterPrev = A;
                    greaterHead = A;
                }
            }
            A = A.next;
        }
        if (greaterPrev != null)
            greaterPrev.next = null;
        if (lessPrev != null) {
            lessPrev.next = greaterHead;
        }
        return head;
    }
}
```
* * Solution in Javascript
```javascript
// Definition for singly-linked list.
//    function Node(data){
//      this.data = data
//      this.next = null
//    }

module.exports = { 
 //param A : head node of linked list
 //param B : integer
 //return the head node in the linked list
	partition : function(A, B){
        if (A == null)
            return null
        let less = new Node(0);
        let greaterEqual = new Node(0);
        let tempLess = less, tempGreaterEqual = greaterEqual, temp = A;
        while (temp != null) {
            if (temp.data < B) {
                // contains the node with value < B
                tempLess.next = temp;
                tempLess = tempLess.next;
            }
            else {
                // contains the node with value >= B
                tempGreaterEqual.next = temp;
                tempGreaterEqual = tempGreaterEqual.next;
            }
            cur = temp;
            temp = temp.next;
            cur.next = null;
        }
        // connect both the linked lists
        tempLess.next = greaterEqual.next;
        return less.next;
	}
};
```
* * Solution in C++
```cpp
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
ListNode* Solution::partition(ListNode* A, int B) {
    if (!A)
        return NULL;
    ListNode * iterator = A;
    ListNode * start = new ListNode(0); // list of nodes greater than x
    ListNode * tail = start;
    ListNode * newHead = new ListNode(0);
    newHead -> next = A;
    ListNode * pre = newHead; // previous node, we need it for removing
    while (iterator) {
        if (iterator -> val >= B) {
            pre -> next = iterator -> next; // remove from our list
            tail -> next = iterator; // add to list of nodes greater than x
            tail = tail -> next;
            iterator = iterator -> next;
            tail -> next = NULL;
        } else
            pre = iterator, iterator = iterator -> next;
    }
    pre -> next = start -> next;
    return newHead -> next;
}
```

