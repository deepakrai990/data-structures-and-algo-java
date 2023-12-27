### Q2. Reorder List
#### Problem Description
```text
Given a singly linked list A

    A: A0 → A1 → … → An-1 → An 

reorder it to:
    
    A0 → An → A1 → An-1 → A2 → An-2 → … 

You must do this in-place without altering the nodes' values.
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
the head of the linked list A.
```
#### Output Format
```text
Return a pointer to the head of the modified linked list.
```
#### Example Input
```text
Input 1:
 A = [1, 2, 3, 4, 5] 

Input 2:
 A = [1, 2, 3, 4] 
```
#### Example Output
```text
Output 1:
 [1, 5, 2, 4, 3] 

Output 2:
 [1, 4, 2, 3] 
```
#### Example Explanation
```text
Explanation 1:
    The array will be arranged to [A0, An, A1, An-1, A2].

Explanation 2:
    The array will be arranged to [A0, An, A1, An-1, A2].
```
### Hints
* Hint 1
```text
Note that moving in the reverse order in the list is not 
feasible unless you use additional memory. This indicates 
that we need to reverse some parts of the list.

Can you figure out a solution reversing a part of the list?
```
* Solution Approach
```text
We can try to break down the solution approach into majorly three parts.

Firstly, we try to break the list from the middle into 
two separate linked lists.

Now, we reverse the latter half of the linked list.

Finally, we would merge the lists so that the nodes alternate 
to get the required answer.
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
    public ListNode reorderList(ListNode head) {
        int sz = 0;
        ListNode tmp = head;
        while (tmp != null) {
            sz++;
            tmp = tmp.next;
        }
        if (head == null || head.next == null || head.next.next == null)
            return head;
        //find the middle of the list, and split into two lists.    
        ListNode slow = head, fast = head;
        while (slow != null && fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        //reverse from the middle to the end
        ListNode secondHalfReversed = reverseLinkedList(mid);
        //merge these two list
        return head = mergeTwoLists(head, secondHalfReversed);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode head = l1; // head of the list to return
        l1 = l1.next;
        ListNode p = head; // pointer to form new list
        // A boolean to track which list we need to extract from. 
        // We alternate between first and second list. 
        boolean curListNum = true;
        while (l1 != null && l2 != null) {
            if (curListNum == false) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
            if (curListNum) {
                curListNum = false;
            } else {
                curListNum = true;
            }
        }
        // add the rest of the tail, done!
        if (l1 != null) {
            p.next = l1;
        } else {
            p.next = l2;
        }
        return head;
    }

    ListNode reverseLinkedList(ListNode head) {
        if (head.next == null) return head;
        ListNode cur = head, nextNode = head.next, tmp;
        while (nextNode != null) {
            tmp = nextNode.next;
            nextNode.next = cur;
            cur = nextNode;
            nextNode = tmp;
        }
        head.next = nextNode;
        return cur;
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
const reverseList = (head) => {
    let prev = null,
        cur = head;
    while (cur !== null) {
        let next = cur.next;
        cur.next = prev;
        prev = cur;
        cur = next;
    }
    return prev;
}
module.exports = {
    //param A : head node of linked list
    //return the head node in the linked list
    reorderList: function (head) {
        let dummyHead = new Node();
        let cur = dummyHead;
        let slow = head,
            fast = head;
        while (fast !== null) {
            fast = fast.next;
            if (fast === null) {
                break;
            }
            fast = fast.next;
            slow = slow.next;
        }
        let rightHead = reverseList(slow);
        let leftHead = head;
        while (leftHead && rightHead) {
            cur.next = leftHead;
            cur = cur.next;
            leftHead = leftHead.next;

            cur.next = rightHead;
            cur = cur.next;
            rightHead = rightHead.next;
        }
        cur.next = null;
        return dummyHead.next;
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
    ListNode * head = l1; // head of the list to return
    l1 = l1 -> next;
    ListNode * p = head; // pointer to form new list
    // A boolean to track which list we need to extract from. 
    // We alternate between first and second list. 
    bool curListNum = true;
    while (l1 && l2) {
        if (curListNum == false) {
            p -> next = l1;
            l1 = l1 -> next;
        } else {
            p -> next = l2;
            l2 = l2 -> next;
        }
        p = p -> next;
        curListNum = !curListNum;
    }
    // add the rest of the tail, done!
    if (l1) {
        p -> next = l1;
    } else {
        p -> next = l2;
    }
    return head;
}

ListNode * reverseLinkedList(ListNode * head) {
    if (head -> next == NULL) return head;
    ListNode * cur = head, * nextNode = head -> next, * tmp;
    while (nextNode != NULL) {
        tmp = nextNode -> next;
        nextNode -> next = cur;
        cur = nextNode;
        nextNode = tmp;
    }
    head -> next = nextNode;
    return cur;
}

ListNode * Solution::reorderList(ListNode * head) {
    int sz = 0;
    ListNode * tmp = head;
    while (tmp) {
        sz++;
        tmp = tmp -> next;
    }
    assert(sz <= 1e6);
    if (head == NULL || head -> next == NULL || head -> next -> next == NULL)
        return head;
    //find the middle of the list, and split into two lists.    
    ListNode * slow = head, * fast = head;
    while (slow != NULL && fast != NULL && fast -> next != NULL && fast -> next -> next != NULL) {
        slow = slow -> next;
        fast = fast -> next -> next;
    }
    ListNode * mid = slow -> next;
    slow -> next = NULL;
    //reverse from the middle to the end
    ListNode * secondHalfReversed = reverseLinkedList(mid);
    //merge these two list
    return head = mergeTwoLists(head, secondHalfReversed);
}
```

