### Q2. Sort List
#### Problem Description
```text
Sort a linked list, A in O(n log n) time using constant space complexity.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p> 0 &lt;= |A| = 10<sup>5</sup> </p>
</div>

```text
0 <= |A| = 10^5
```
#### Input Format
```text
The first and the only argument of input contains a pointer to 
the head of the linked list, A.
```
#### Output Format
```text
Return a pointer to the head of the sorted linked list.
```
#### Example Input
```text
Input 1:
 A = [3, 4, 2, 8]

Input 2:
 A = [1]
```
#### Example Output
```text
Output 1:
 [2, 3, 4, 8]

Output 2:
 [1]
```
#### Example Explanation
```text
Explanation 1:
    The sorted form of [3, 4, 2, 8] is [2, 3, 4, 8].

Explanation 2:
    The sorted form of [1] is [1].
```
### Hints
* Hint 1
```text
Merge sort is usually quicker and easier to implement when 
it comes to implementing sorting in O(n log n).

Think recursively. You will end up breaking the problems 
into small pieces.
```
* Solution Approach
```text
We can try to implement either merge sort or qsort.

Let us look at the merge sort. We start traversing the singly 
linked list to find the midpoint of the singly linked list.

Now, we will sort the first half and second half separately 
by calling the merge sort function on them.

Then we only have to merge the 2 lists ( Note that we already 
have solved a problem to merge 2 lists ).
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
    public ListNode sortList(ListNode A) {
        if (A == null || A.next == null)
            return A;
        ListNode first = A;
        // find the middle node
        ListNode second = findMidNode(A);
        first = sortList(first);
        second = sortList(second);
        ListNode res = mergeNodes(first, second);
        return res;

    }

    public ListNode mergeNodes(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (node1 != null && node2 != null) {
            // find the smaller node
            if (node1.val <= node2.val) {
                dummy.next = node1;
                node1 = node1.next;
            } else {
                dummy.next = node2;
                node2 = node2.next;
            }
            dummy = dummy.next;
        }
        // add the remaining nodes
        dummy = addNodes(dummy, node1);
        addNodes(dummy, node2);
        head = head.next;
        return head;
    }

    public ListNode addNodes(ListNode node, ListNode node1) {
        while (node1 != null) {
            node.next = node1;
            node1 = node1.next;
            node = node.next;
        }
        return node;
    }

    public ListNode findMidNode(ListNode node) {
        ListNode doubleRate;
        ListNode prev;
        if (node == null || node.next == null)
            return node;
        doubleRate = node;
        prev = node;
        while (doubleRate.next != null && doubleRate.next.next != null) {
            prev = node;
            node = node.next;
            doubleRate = doubleRate.next.next;
        }
        prev = node;
        node = node.next;
        prev.next = null;
        return node;
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
const merge = (l1, l2) => {
    let dummy = new Node(),
        head = dummy;

    while (l1 && l2) {
        // find the smaller node
        if (l1.data <= l2.data) {
            head.next = l1;
            l1 = l1.next;
        } else {
            head.next = l2;
            l2 = l2.next;
        }
        head = head.next;
    }
    // add the remaining nodes
    head.next = l1 ? l1 : l2;
    return dummy.next;
}

const sortL = head => {
    if (!head || !head.next) {
        return head;
    }
    let pre = head,
        fast = head,
        slow = head;
    
    // find the middle node
    while (fast && fast.next) {
        pre = slow;
        slow = slow.next;
        fast = fast.next.next;
    }

    pre.next = null;
    return merge(sortL(head), sortL(slow));
};

module.exports = {
    //param A : head node of linked list
    //return the head node in the linked list
    sortList: function (head) {
        return sortL(head);
    }
};
```
* * Solution in C++
```cpp
ListNode * mergeTwoLists(ListNode * l1, ListNode * l2) {
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

ListNode * Solution::sortList(ListNode * head) {
    int sz = 0;
    ListNode * tmp = head;
    while (tmp) {
        tmp = tmp -> next;
        sz++;
    }
    assert(sz <= 1e5);
    if (head == NULL || head -> next == NULL)
        return head;
    // find the middle place
    ListNode * p1 = head;
    ListNode * p2 = head -> next;
    while (p2 && p2 -> next) {
        p1 = p1 -> next;
        p2 = p2 -> next -> next;
    }
    p2 = p1 -> next;
    p1 -> next = NULL;

    return mergeTwoLists(sortList(head), sortList(p2));
}
```

