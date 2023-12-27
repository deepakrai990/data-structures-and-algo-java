### Q1. Remove Loop from Linked List
#### Problem Description
```text
You are given a linked list that contains a loop.
You need to find the node, which creates a loop and 
break it by making the node point to NULL.
```
#### Problem Constraints
```text
1 <= number of nodes <= 1000
```
#### Input Format
```text
The first of the input contains a LinkedList, where the 
first number is the number of nodes N, and the next N nodes 
are the node value of the linked list.

The second line of the input contains an integer which denotes 
the position of node where cycle starts.
```
#### Output Format
```text
return the head of the updated linked list.
```
#### Example Input
```text
Input 1:
 1 -> 2
 ^    |
 | - - 

Input 2:
 3 -> 2 -> 4 -> 5 -> 6
           ^         |
           |         |    
           - - - - - -
```
#### Example Output
```text
Output 1:
 1 -> 2 -> NULL

Output 2:
 3 -> 2 -> 4 -> 5 -> 6 -> NULL
```
#### Example Explanation
```text
Explanation 1:
    Chain of 1->2 is broken.

Explanation 2:
    Chain of 4->6 is broken.
```
### Hints
* Hint 1
```text
You just need to find what the point is, which 
has 2 pointers pointing towards it.
```
* Solution Approach
```text
You just need to find what the point is, which has 2 pointers 
pointing towards it.

Once you have found it, remove one of the pointers and return 
the head of the new linked list.
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
    public ListNode solve(ListNode A) {
        detectAndRemoveLoop(A);
        return A;
    }

    int detectAndRemoveLoop(ListNode node) {
        ListNode slow = node, fast = node;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If slow and fast meet at same point then loop is present 
            if (slow == fast) {
                removeLoop(slow, node);
                return 1;
            }
        }
        return 0;
    }

    // Function to remove loop 
    void removeLoop(ListNode loop, ListNode curr) {
        ListNode ptr1 = null;
        ListNode ptr2 = null;
        /* Set a pointer to the beginning of the Linked List and 
         move it one by one to find the first node which is 
         part of the Linked List */
        ptr1 = curr;
        while (1 == 1) {
            /* Now start a pointer from loop_node and check if it ever 
             reaches ptr2 */
            ptr2 = loop;
            while (ptr2.next != loop && ptr2.next != ptr1) {
                ptr2 = ptr2.next;
            }
            /* If ptr2 reahced ptr1 then there is a loop. So break the 
             loop */
            if (ptr2.next == ptr1) {
                break;
            }
            /* If ptr2 did't reach ptr1 then try the next node after ptr1 */
            ptr1 = ptr1.next;
        }
        /* After the end of loop ptr2 is the last node of the loop. So 
         make next of ptr2 as NULL */
        ptr2.next = null;
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
function detectCycle(a) {
    let fast = a;
    let slow = a;

    while (fast.next != null && fast.next.next != null) {
        fast = fast.next.next;
        slow = slow.next;
        // If slow and fast meet at some point then there is a loop
        if (slow == fast) {
            slow = a;
            break;
        }
    }
    if (slow != a)
        return null;

    while (slow != fast) {
        slow = slow.next;
        fast = fast.next;
    }
    return slow;
}
module.exports = {
    //param A : head node of linked list
    //return the head node in the linked list
    solve: function (A) {
        let start = detectCycle(A);
        if (start == null) {
            return A;
        }
        let ptr = start;
        while (ptr.next != start) {
            ptr = ptr.next;
        }
        ptr.next = null;
        return A;
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
ListNode * removeLoop(ListNode * loop_node, ListNode * head) {
    struct ListNode * ptr1 = loop_node;
    struct ListNode * ptr2 = loop_node;
    unsigned int k = 1, i;
    while (ptr1 -> next != ptr2) {
        ptr1 = ptr1 -> next;
        k++;
    }
    ptr1 = head;
    ptr2 = head;
    for (i = 0; i < k; i++)
        ptr2 = ptr2 -> next;
    while (ptr2 != ptr1) {
        ptr1 = ptr1 -> next;
        ptr2 = ptr2 -> next;
    }
    while (ptr2 -> next != ptr1)
        ptr2 = ptr2 -> next;
    ptr2 -> next = NULL;
    return head;
}

ListNode * Solution::solve(ListNode * A) {
    struct ListNode * slow_p = A, * fast_p = A;
    struct ListNode * ans;
    while (slow_p && fast_p && fast_p -> next) {
        slow_p = slow_p -> next;
        fast_p = fast_p -> next -> next;
        // If slow_p and fast_p meet at some point then there is a loop
        if (slow_p == fast_p) {
            if (slow_p -> next == fast_p) {
                slow_p -> next = NULL;
                return A;
            }
            ans = removeLoop(slow_p, A);
            break;
        }
    }
    return ans;
}
```

