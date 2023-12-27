### Q1. Delete middle node of a Linked List
#### Problem Description
```text
Given a singly linked list, delete middle of the linked list.

For example, if given linked list is 1->2->3->4->5 then linked list should be modified 
to 1->2->4->5

If there are even nodes, then there would be two middle nodes, we need to delete the 
second middle element.

For example, if given linked list is 1->2->3->4->5->6 then it should be modified 
to 1->2->3->5->6.

Return the head of the linked list after removing the middle node.

If the input linked list has 1 node, then this node should be deleted and a null 
node should be returned.
```
#### Problem Constraints
```text

```
#### Input Format
```text

```
#### Output Format
```text

```
#### Example Input
```text

```
#### Example Output
```text

```
#### Example Explanation
```text

```
### Hints
* Hint 1
```text

```
* Solution Approach
```text

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
        if (A.next == null) return null;
        ListNode fast = A, slow = A, lastslow = A;
        while (fast != null && fast.next != null) {
            lastslow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        lastslow.next = lastslow.next.next;
        return A;
    }
}
```
* * Solution in Javascript
```javascript

```
* * Solution in C++
```cpp

```

