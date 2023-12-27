### Q2. Middle element of linked list
#### Problem Description
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>Given a linked list of integers, find and return 
    the middle element of the linked list.</p>
    <p><strong>NOTE:</strong> If there are <strong>N</strong> 
    nodes in the linked list and N is even then return 
    the (N/2 + 1)<sup>th</sup> element.</p>
</div>

```text
Given a linked list of integers, find and return the 
middle element of the linked list.

NOTE: If there are N nodes in the linked list and N is even 
then return the (N/2 + 1)^th element.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= length of the linked list &lt;= 100000</p>
    <p>1 &lt;= Node value &lt;= 10<sup>9</sup> </p>
</div>

```text
1 <= length of the linked list <= 100000

1 <= Node value <= 10^9
```
#### Input Format
```text
The only argument given head pointer of linked list.
```
#### Output Format
```text
Return the middle element of the linked list.
```
#### Example Input
```text
Input 1:
 1 -> 2 -> 3 -> 4 -> 5

Input 2:
 1 -> 5 -> 6 -> 2 -> 3 -> 4
```
#### Example Output
```text
Output 1:
 3

Output 2:
 2
```
#### Example Explanation
```text
Explanation 1:
    The middle element is 3.

Explanation 2:
    The middle element in even length linked list of 
    length N is ((N/2) + 1)^th element which is 2.
```
### Hints
* Hint 1
```text
One way is to traverse the whole linked list and calculate 
the length and then traverse half the length to find the middle element.

Can you do it in one traversal?
```
* Solution Approach
```text
One way is to traverse the whole linked list and calculate 
the length and then traverse half the length to find the middle element.

We can do it in one traversal by maintaining a slow and fast pointer.

The fast pointer moves twice as the slow pointer does. When the 
fast pointer is at the end of the linked list, the slow pointer 
will point to the middle element.

Return the element at which the slow pointer points.
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
    public int solve(ListNode A) {
        if (A.next == null)
            return A.val;
        // slow and fast pointer
        ListNode slow = A, fast = A;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.val;
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
    //return an integer
    solve: function (head) {
        // slow and fast pointer
        let slow = head,
            fast = head;
        while (fast !== null) {
            fast = fast.next;
            if (fast == null) {
                break;
            } else {
                fast = fast.next;
            }
            slow = slow.next;
        }
        return slow.data;
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

int middleElement(ListNode * head) {
    // if only a single element
    if (head -> next == NULL)
        return head -> val;
    // slow and fast pointer
    ListNode * slow = head;
    ListNode * fast = head;
    while (fast && fast -> next) {
        fast = fast -> next -> next;
        slow = slow -> next;
    }
    return slow -> val;
}

int Solution::solve(ListNode * A) {
    return middleElement(A);
}
```

