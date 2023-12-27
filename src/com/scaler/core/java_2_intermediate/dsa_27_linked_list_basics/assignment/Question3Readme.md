### Q3. Insert in Linked List
#### Problem Description
```text
You are given A which is the head of a linked list. Also given is 
the value B and position C. Complete the function that should 
insert a new node with the said value at the given position.

Notes:

    * In case the position is more than length of linked list, simply 
      insert the new node at the tail only.
    
    * In case the pos is 0 or less, simply insert the new 
      node at head only.
    
    * Follow 0-based indexing for the node numbering.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= size of linked list &lt;= 10<sup>5</sup><br>
    1 &lt;= value of nodes &lt;= 10<sup>9</sup><br>
    1 &lt;= B &lt;= 10<sup>9</sup><br>
    0 &lt;= C &lt;= 10<sup>5</sup></p>
</div>

```text
1 <= size of linked list <= 10^5
1 <= value of nodes <= 10^9
1 <= B <= 10^9
0 <= C <= 10^5
```
#### Input Format
```text
The first argument A is the head of a linked list.

The second argument B is an integer which denotes the value of the new node

The third argument C is an integer which denotes the position of the new node
```
#### Output Format
```text
Return the head of the linked list
```
#### Example Input
```text
Input 1:
 A = 1 -> 2
 B = 3
 C = 0

Input 2:
 A = 1 -> 2
 B = 3
 C = 1
```
#### Example Output
```text
Output 1:
 3 -> 1 -> 2

Output 2:
 1 -> 3 -> 2
```
#### Example Explanation
```text
For Input 1:
    The new node is add to the head of the linked list

For Input 2:
    The new node is added after the first node of the linked list
```
### Hints
* Hint 1
```text
Find the position where you need to insert the new node in
the given linked list
```
* Solution Approach
```text
There are three types of insertion possible:-
1) Insert at head - The new node becomes the new head and the next of the 
   new node points towards the old head.

2) Insert at tail - The next of the current tail will point 
   toward the new node

3) Insert at any other node - Traverse to the required 
   position, the next of the previous node should point 
   towards new node and the next of the new node should 
   point towards the old next of the previous node.

Time Complexity : O(N)
Space Complexity : O(1)

where N is the size of the linked list
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
    public ListNode solve(ListNode A, int B, int C) {
        ListNode n = new ListNode(B);
        if (C <= 0){
            n.next = A;
            return n;
        }
        
        int i = 0;
        ListNode temp = A;
        while (i < C-1 && temp.next != null){
            i += 1;
            temp = temp.next;
        }
        
        n.next = temp.next;
        temp.next = n;
        return A;
    }
}
```
* * Solution in Javascript
```javascript
/** Not available **/
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
ListNode* Solution::solve(ListNode* A, int B, int C) {
    ListNode* n = new ListNode(B);
    if (C <= 0){
        n->next = A;
        return n;
    }
    
    int i = 0;
    ListNode* temp = A;
    while (i < C-1 && temp->next != NULL){
        i += 1;
        temp = temp->next;
    }
    
    n->next = temp->next;
    temp->next = n;
    return A;
}
```

