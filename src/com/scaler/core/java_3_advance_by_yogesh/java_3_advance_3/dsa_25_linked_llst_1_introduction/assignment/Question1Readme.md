### Q1. Reverse Linked List
#### Problem Description
```text
You are given a singly linked list having head node A. 
You have to reverse the linked list and return the head 
node of that reversed list.

NOTE: You have to do it in-place and in one-pass.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= Length of linked list &lt;= 10<sup>5</sup> <br>
    Value of each node is within the range of a 32-bit integer.</p>
</div>

```text
1 <= Length of linked list <= 10^5

Value of each node is within the range of a 32-bit integer.
```
#### Input Format
```text
First and only argument is a linked-list node A.
```
#### Output Format
```text
Return a linked-list node denoting the head of the reversed linked list.
```
#### Example Input
```text
Input 1:
 A = 1 -> 2 -> 3 -> 4 -> 5 -> NULL 

Input 2:
 A = 3 -> NULL 
```
#### Example Output
```text
Output 1:
 5 -> 4 -> 3 -> 2 -> 1 -> NULL 

Output 2:
 3 -> NULL 
```
#### Example Explanation
```text
Explanation 1:
    The linked list has 5 nodes. After reversing them, 
    the list becomes : 5 -> 4 -> 3 -> 2 -> 1 -> NULL 

Explanation 2:
    The linked list consists of only a single node. 
    After reversing it, the list becomes : 3 -> NULL 
```
### Hints
* Hint 1
```text
To reverse Linked list we will next next node, previous node and 
current node. So, what if we iterate over the linked list and reverse 
node by node.
```
* Solution Approach
```text
ITERATIVE SOLUTION
Assume that we have linked list 1 → 2 → 3 → Ø, we would like 
to change it to Ø ← 1 ← 2 ← 3.

While you are traversing the list, change the 
current node's next pointer to point to its previous element. 

Since a node does not have reference to its previous node, 
you must store its previous element beforehand. 

You also need another pointer to store the next node before 
changing the reference. 

Do not forget to return the new head reference at the end!
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
	public ListNode reverseList(ListNode A) {
	    ListNode node, prev, temp;
	    node = A;
	    if (node == null)
	        return null;
	    prev = null;
	    while (node != null) {
	        temp = node.next;
	        node.next = prev;
	        prev = node;
	        node = temp;
	    }
	    return prev;
	}
}
```
* * Solution in Javascript
```javascript
/** not available **/
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
ListNode* Solution::reverseList(ListNode* A) {
    ListNode* head = A; 
    if(head == NULL) return NULL;
    ListNode *cur = head, *nextNode, *prevNode;
    prevNode = NULL;

    while (cur != NULL) {
        nextNode = cur->next;
        cur->next = prevNode;
        prevNode = cur;
        cur = nextNode;
    }

    head = prevNode;
    return head;
}
```

