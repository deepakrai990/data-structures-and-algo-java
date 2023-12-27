### Q1. Merge Two Sorted Lists
#### Problem Description
```text
Merge two sorted linked lists, A and B, and return it as a new list.

The new list should be made by splicing together the nodes of the 
first two lists and should also be sorted.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p> 0 &lt;= |A|, |B| &lt;= 10<sup>5</sup> </p>
</div>

```text
0 <= |A|, |B| <= 10^5
```
#### Input Format
```text
The first argument of input contains a pointer to the head of linked list A.

The second argument of input contains a pointer to the head of linked list B.
```
#### Output Format
```text
Return a pointer to the head of the merged linked list.
```
#### Example Input
```text
Input 1:
 A = 5 -> 8 -> 20
 B = 4 -> 11 -> 15

Input 2:
 A = 1 -> 2 -> 3
 B = Null
```
#### Example Output
```text
Output 1:
 4 -> 5 -> 8 -> 11 -> 15 -> 20

Output 2:
 1 -> 2 -> 3
```
#### Example Explanation
```text
Explanation 1:
    Merging A and B will result in 4 -> 5 -> 8 -> 11 -> 15 -> 20 

Explanation 2:
    We don't need to merge as B is empty. 

```
### Hints
* Hint 1
```text
Maintain pointers in both the linked list and keep appending 
the elements to the list to be returned.

NOTE: You don’t have to create new nodes here, i.e., the list to 
be returned should be made from the combination of both of the given lists.
```
* Solution Approach
```text
The first thing to note is that all you would want to do is 
modify the next pointers. You don’t need to create new nodes.

At every step, you choose the minimum of the current head X on 
the 2 lists and modify your answer’s next pointer to X. You move 
the current pointer on the said list and the current answer.

Corner case,
Make sure that at the end of the loop, when one of the lists 
goes empty, you do include the remaining elements from the second 
list into your answer.

Test case : 1->2->3 4->5->6
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
    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        return solve(A, B);
    }
    public ListNode solve(ListNode A, ListNode B) {
        if (A == null)
            return B;
        if (B == null)
            return A;
        ListNode head;
        ListNode node = new ListNode(0);
        head = node;
        while (A != null && B != null) {
            // compare both the values
            if (A.val <= B.val) {
                node.next = A;
                A = A.next;
                node = node.next;
            } else {
                node.next = B;
                B = B.next;
                node = node.next;
            }
        }
        if (A == null)
            node.next = B;
        else
            node.next = A;
        head = head.next;
        return head;
    }
}
```
* * Solution in Javascript
```javascript
// Definition for singly-linked list.
//    function Node(data){
//         this.data = data
//         this.next = null
//}

module.exports = {
    //param a : head node of linked list
    //param b : head node of linked list
    //return the head node in the linked list
    mergeTwoLists: function (a, b) {
        var result = new Node(1);
        var head = result;
        while (a != null && b != null) {
            if (a.data >= b.data) {
                var nextB = b.next;
                result.next = b;
                b.next = null;
                b = nextB;
            } else {
                var nextA = a.next;
                result.next = a;
                a.next = null;
                a = nextA;
            }
            result = result.next;
        }
        if (a != null)
            result.next = a;
        if (b != null)
            result.next = b;
        return head.next;
    }
};
```
* * Solution in C++
```cpp
ListNode * Solution::mergeTwoLists(ListNode * l1, ListNode * l2) {
    if (l1 == NULL)
        return l2;
    if (l2 == NULL)
        return l1;
    ListNode * head = NULL; // head of the list to return
    // find first element (can use dummy node to put this part inside of the loop)
    if (l1 -> val < l2 -> val) {
        head = l1;
        l1 = l1 -> next;
    } else {
        head = l2;
        l2 = l2 -> next;
    }
    ListNode * p = head; // pointer to form new list
    while (l1 && l2) {
        if (l1 -> val < l2 -> val) {
            p -> next = l1;
            l1 = l1 -> next;
        } else {
            p -> next = l2;
            l2 = l2 -> next;
        }
        p = p -> next;
    }
    // add the rest of the tail, done!
    if (l1) {
        p -> next = l1;
    } else {
        p -> next = l2;
    }
    return head;
}
```

