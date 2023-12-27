### Q4. Reverse Link List II
#### Problem Description
```text
Reverse a linked list A from position B to C.

NOTE: Do it in-place and in one-pass.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p> 1 &lt;= |A| &lt;= 10<sup>6</sup> </p>
    <p> 1 &lt;= B &lt;= C &lt;= |A| </p>
</div>

```text
1 <= |A| <= 10^6

1 <= B <= C <= |A|
```
#### Input Format
```text
The first argument contains a pointer to the head of the given linked list, A.

The second argument contains an integer, B.

The third argument contains an integer C.
```
#### Output Format
```text
Return a pointer to the head of the modified linked list.
```
#### Example Input
```text
Input 1:
 A = 1 -> 2 -> 3 -> 4 -> 5
 B = 2
 C = 4

Input 2:
 A = 1 -> 2 -> 3 -> 4 -> 5
 B = 1
 C = 5
```
#### Example Output
```text
Output 1:
 1 -> 4 -> 3 -> 2 -> 5

Output 2:
 5 -> 4 -> 3 -> 2 -> 1
```
#### Example Explanation
```text
Explanation 1:
    In the first example, we want to reverse the highlighted 
    part of the given linked list : 1 -> 2 -> 3 -> 4 -> 5 
    
    Thus, the output is 1 -> 4 -> 3 -> 2 -> 5 

Explanation 2:

    In the second example, we want to reverse the highlighted 
    part of the given linked list : 1 -> 4 -> 3 -> 2 -> 5  
    
    Thus, the output is 5 -> 4 -> 3 -> 2 -> 1 
```
### Hints
* Hint 1
```text
Let’s first look at the problem of reversing the linked list.

a -> b -> c should become
a <- b <- c

Obviously, at every instant, you need to know about 
the previous of the current node so that you can link it to 
the next of the node.

Can you think along the lines of maintaining a previousNode, 
curNode, and nextNode ?

Now, once you know how to reverse a linked list, how can 
you apply it to the current problem?
```
* Solution Approach
```text
If you are still stuck at reversing the full linked list problem,
then would maintaining curNode, nextNode and a tmpNode help?

Maybe at every step, you do something like this :

    tmp = nextNode->next;
            nextNode->next = cur;
            cur = nextNode;
            nextNode = tmp;
Now, let’s say you did solve the problem of reversing the 
linked list and are stuck at applying it to the current problem.

What if your function reverses the linked list and returns 
the endNode of the list.

You can simply do
prevNodeOfFirstNode -> next = reverseLinkedList(curNode, n - m + 1);

Explanation in the video:
We can also find the two pointers between which the list needs 
to be reversed and only reverse that portion.

We will also have to make two new connections, one from the 
node just before the first node in the original portion to 
the node at the starting of the reversed portion, another 
from the first node of the original portion to the node after 
the last node in the original portion.

A detailed explanation is in the video.
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
    public ListNode reverseBetween(ListNode A, int m, int n) {
        int i;
        ListNode node = A;
        ListNode prev = null;
        m--;
        n--;
        for (i = 0; i < m; i++) {
            prev = node;
            node = node.next;
        }
        if (prev != null)
            prev.next = reverseList(node, n - m + 1);
        else
            A = reverseList(node, n - m + 1);
        return A;
    }

    public ListNode reverseList(ListNode A, int count) {
        ListNode node, prev, temp, last;
        node = A;
        last = A;
        if (node == null)
            return null;
        prev = null;
        while (node != null && count > 0) {
            temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
            count--;
        }
        last.next = node;
        return prev;
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
    //param C : integer
    //return the head node in the linked list
    reverseBetween: function (head, m, n) {
        let start = head,
            cur = head;
        let i = 1;
        while (i < m) {
            start = cur;
            cur = cur.next;
            i++;
        }
        let prev = null,
            tail = cur;
        while (i <= n) {
            let next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            i++;
        }
        start.next = prev;
        tail.next = cur;
        return m == 1 ? prev : head;
    }
};
```
* * Solution in C++
```cpp
// Reverses the linkedList which starts from head, and extends to size nodes. 
// Returns the end node. 
// Also sets the head->next as endNode->next. 
ListNode * reverseLinkedList(ListNode * head, int size) {
    if (size <= 1)
        return head;
    ListNode * cur = head, * nextNode = head -> next, * tmp;
    for (int i = 0; i < (size - 1); i++) {
        tmp = nextNode -> next;
        nextNode -> next = cur;
        cur = nextNode;
        nextNode = tmp;
    }
    head -> next = nextNode;
    return cur;
}

ListNode * Solution::reverseBetween(ListNode * A, int B, int C) {
    int sz = 0;
    ListNode * tmp = A;
    while (tmp) {
        sz++;
        tmp = tmp -> next;
    }
    assert(sz <= 1e6);
    // Introduce dummyhead to not handle corner cases. 
    ListNode * dummyHead = new ListNode(0);
    dummyHead -> next = A;
    // Figure out the start node of the sublist we are going to reverse
    ListNode * prev = dummyHead;
    ListNode * cur = A;
    int index = 1;
    while (index < B) {
        prev = cur;
        cur = cur -> next;
        index++;
    }
    // At this point, we have start of sublist in cur, prev of startSubList in prev.
    // Lets reverse the sublist now. 
    ListNode * endSubList = reverseLinkedList(cur, C - B + 1);
    prev -> next = endSubList;
    return dummyHead -> next;
}
```

