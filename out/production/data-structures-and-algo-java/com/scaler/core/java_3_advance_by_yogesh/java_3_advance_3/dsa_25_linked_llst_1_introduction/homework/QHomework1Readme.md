### Q1. Remove Nth Node from List End
#### Problem Description
```text
Given a linked list **A**, remove the **B-th** node from 
the end of the list and return its head. For example, Given 
linked list: `1->2->3->4->5`, and `B = 2`. 

After removing the second node from the end, the linked list 
becomes `1->2->3->5`. **NOTE:** If **B** is greater than the 
size of the list, remove the first node of the list. 

**NOTE:** Try doing it using constant additional space.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    1 &lt;= |A| &lt;= 10<sup>6</sup>
</div>

```text
1 <= |A| <= 10^6
```
#### Input Format
```text
The first argument of input contains a pointer to the head of 
the linked list. The second argument of input contains the integer B.
```
#### Output Format
```text
Return the head of the linked list after deleting 
the B-th element from the end.
```
#### Example Input
```text
Input 1:
 A = 1->2->3->4->5
 B = 2
 
Input 2:
 A = 1
 B = 1
```
#### Example Output
```text
Output 1:
 1->2->3->5

Output 2:

```
#### Example Explanation
```text
Explanation 1:
    In the first example, 4 is the second last element.

Explanation 2:
    In the second example, 1 is the first and the last element.
```
### Hints
* Hint 1
```text
Can you remove xth node from the start instead of nth node 
from the end?

Can you figure out the position of the node from 
the start, given its position from the end?
```
* Solution Approach
```text
Obviously, since we do not have back pointers, reaching 
the end node and then making our way back is not an option.

There are 2 approaches :
    
    1) Find out the length of the list in one go. Then you 
       know the number of the node to be removed. Traverse to 
       the node and remove it.
    
    2) Make the first pointer go n nodes. Then move the second 
       and first pointer simultaneously. This way, the first 
       pointer is always ahead of the second pointer 
       by n nodes. So when the first pointer reaches the end, 
       you are on the node to be removed.
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
    public ListNode removeNthFromEnd(ListNode A, int B) {
        int n;
        ListNode node;
        if (A == null)
            return null;
        n = 0;
        node = A;
        // calculates the size of the linked list
        while (node != null) {
            n++;
            node = node.next;
        }
        if (B >= n) {
            return A.next;
        }
        node = A;
        for (int i = 0; i < n - B - 1; i++)
            node = node.next;
        node.next = node.next.next;
        return A;
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
	removeNthFromEnd : function(A, B){
        let t1 = A, t2 = A;
        let sz = 0;
        // calculates the size of the linked list
        while (t1) {
            t1 = t1.next;
            sz++;
        }
        if (B >= sz){
            A = A.next;
        }
        else {
            for (let i = 0; i < sz - B - 1; i++){
                t2 = t2.next;
            }
            t2.next = t2.next.next;
        }
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
ListNode* Solution::removeNthFromEnd(ListNode* A, int B) {
    ListNode * t1 = A, * t2 = A;
    int sz = 0;
    // calculates the size of the linked list
    while (t1) {
        t1 = t1 -> next;
        sz++;
    }
    if (B >= sz)
        A = A -> next;
    else {
        for (int i = 0; i < sz - B - 1; i++)
            t2 = t2 -> next;
        t2 -> next = t2 -> next -> next;
    }
    return A;
}
```

