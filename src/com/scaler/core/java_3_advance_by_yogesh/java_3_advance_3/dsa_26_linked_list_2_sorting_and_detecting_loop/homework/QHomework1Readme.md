### Q1. Swap List Nodes in pairs
#### Problem Description
```text
Given a linked list A, swap every two adjacent nodes and return its head.

NOTE: Your algorithm should use only constant space. You may 
not modify the values in the list; only nodes themselves can be changed.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p> 1 &lt;= |A| &lt;= 10<sup>6</sup> </p>
</div>

```text
1 <= |A| <= 10^6
```
#### Input Format
```text
The first and the only argument of input contains a pointer to 
the head of the given linked list.
```
#### Output Format
```text
Return a pointer to the head of the modified linked list.
```
#### Example Input
```text
Input 1:
 A = 1 -> 2 -> 3 -> 4

Input 2:
 A = 7 -> 2 -> 1
```
#### Example Output
```text
Output 1:
 2 -> 1 -> 4 -> 3

Output 2:
 2 -> 7 -> 1
```
#### Example Explanation
```text
Explanation 1:
    In the first example (1, 2) and (3, 4) are the adjacent 
    nodes. Swapping them will result in 2 -> 1 -> 4 -> 3

Explanation 2:
    In the second example, 3rd element i.e. 1 does not have 
    an adjacent node, so it won't be swapped. 
```
### Hints
* Hint 1
```text
A->B->C.

Take a look at A and B. How can you change the next pointer 
of these elements without changing their values 
such that they are swapped?
```
* Solution Approach
```text
Let’s first look at the problem of swapping 2 nodes.

Method 1: Just swap the values in the 2 nodes. 
In most cases, this won’t be a permissible solution.

Method 2: Move around the pointers.
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
    public ListNode swapPairs(ListNode A) {
        if (A == null)
            return null;
        A = rec(A);
        return A;
    }

    public ListNode rec(ListNode node) {
        ListNode nextNode;
        ListNode firstNode = node;
        ListNode prevNode = null;
        if (node.next != null)
            firstNode = node.next;
        while (!(node == null || node.next == null)) {
            // swap the two adjacent nodes
            nextNode = node.next;
            node.next = nextNode.next;
            nextNode.next = node;
            if (prevNode != null)
                prevNode.next = nextNode;
            prevNode = node;
            node = node.next;
        }
        return firstNode;
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
    //return the head node in the linked list
    swapPairs: function (head) {
        if (head == null) return null;
        let newHead = new Node();
        let ptr = newHead;
        let prev = null,
            cur = head,
            len = 0;
        while (cur !== null) {
            let next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            len++;
            if (len % 2 == 0) {
                ptr.next = prev;
                ptr = ptr.next.next;
            }
        }
        if (len % 2 == 1) {
            ptr.next = prev;
            ptr = ptr.next
        }
        ptr.next = null;
        return newHead.next;
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
ListNode * swap(ListNode * next1, ListNode * next2) {
    next1 -> next = next2 -> next;
    next2 -> next = next1;
    return next2;
}

ListNode * Solution::swapPairs(ListNode * head) {
    ListNode * start = new ListNode(0); //make head no longer a special case
    start -> next = head;
    ListNode * cur = start;
    while (cur -> next != NULL && cur -> next -> next != NULL) {
        // swap the two adjacent nodes
        cur -> next = swap(cur -> next, cur -> next -> next);
        cur = cur -> next -> next;
    }
    return start -> next;
}
```

