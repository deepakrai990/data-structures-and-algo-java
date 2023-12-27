### Q2. Remove Duplicates from Sorted List
#### Problem Description
```text
Given a sorted linked list, delete all duplicates 
such that each element appears only once.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>0 &lt;= length of linked list &lt;= 10<sup>6</sup></p>
</div>

```text
0 <= length of linked list <= 10^6
```
#### Input Format
```text
First argument is the head pointer of the linked list.
```
#### Output Format
```text
Return the head pointer of the linked list after removing all duplicates.
```
#### Example Input
```text
Input 1:
 1->1->2

Input 2:
 1->1->2->3->3
```
#### Example Output
```text
Output 1:
 1->2

Output 2:
 1->2->3
```
#### Example Explanation
```text
Explanation 1:
    Each element appear only once in 1->2.
```
### Hints
* Hint 1
```text
You need to change the next pointer of some element to 
the next different element. Take care of corner cases, if any.
```
* Solution Approach
```text
Skip the node where head->next != NULL && head->val == head->next->val.

Make sure you take care of corner cases :
    
    1) Do you handle repetitions at the end? ex : 1 -> 1
    
    2) Do you handle cases where there is just one element? ex : 1
    
    3) Do you handle cases where there is just one element 
       repeated numerous times? 1->1->1->1->1->1
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
    public ListNode deleteDuplicates(ListNode A) {
        if (A == null)
            return A;
        ListNode next;
        ListNode prevNode;
        int prev = A.val;
        next = A.next;
        prevNode = A;
        while (next != null) {
            if (next.val == prev) {
                prevNode.next = next.next;
            } else {
                prevNode = next;
                prev = next.val;
            }
            next = next.next;
        }
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
 //return the head node in the linked list
	deleteDuplicates : function(A){
        let origin = A;
        while (A != null) {
            while (A.next != null && A.data == A.next.data) {
                A.next = A.next.next;
            }
            A = A.next;
        }
        return origin;
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
ListNode * Solution::deleteDuplicates(ListNode * A) {
    ListNode * origin = A;
    while (A != NULL) {
        while (A -> next != NULL && A -> val == A -> next -> val) {
            A -> next = A -> next -> next;
        }
        A = A -> next;
    }
    return origin;
}
```

