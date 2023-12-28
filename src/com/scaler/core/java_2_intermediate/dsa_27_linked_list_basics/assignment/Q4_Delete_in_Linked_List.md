### Q4. Delete in Linked List
#### Problem Description
```text
You are given the head of a linked list A and an integer B. Delete 
the B-th node from the linked list.

Note : Follow 0-based indexing for the node numbering.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= size of linked list &lt;= 10<sup>5</sup><br>
    1 &lt;= value of nodes &lt;= 10<sup>9</sup><br>
    0 &lt;= B &lt; size of linked list</p>
</div>

```text
1 <= size of linked list <= 10^5
1 <= value of nodes <= 10^9
0 <= B < size of linked list
```
#### Input Format
```text
The first argument A is the head of a linked list.

The second argument B is an integer.
```
#### Output Format
```text
Return the head of the linked list after deletion
```
#### Example Input
```text
Input 1:
 A = 1 -> 2 -> 3
 B = 1

Input 2:
 A = 4 -> 3 -> 2 -> 1
 B = 0
```
#### Example Output
```text
Output 1:
 1 -> 3

Output 2:
 3 -> 2 -> 1
```
#### Example Explanation
```text
For Input 1:
    The linked list after deletion is 1 -> 3.

For Input 2:
    The linked list after deletion is 3 -> 2 -> 1.
```
### Hints
* Hint 1
```text
Find the required node and delete it from the linked list
```
* Solution Approach
```text
If the value of B is zero, then we return the next node pointed
by A.

We need to find the previous node to one which we would delete. Then,
make the next of this node equal to the next of the node to be deleted.

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
    public ListNode solve(ListNode A, int B) {
        if(B == 0){
            return A.next;
        }
        ListNode temp = A;
        int curr = 0;
        while(curr < B - 1){
            curr += 1;
            temp = temp.next;
        }
        temp.next = temp.next.next;
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
ListNode* Solution::solve(ListNode* A, int B) {
    if(B == 0){
		return A->next;
	}
	int curr = 0;
	ListNode* temp = A;
	while(curr < B - 1){
		temp = temp->next;
		curr++;
	}
	temp->next = temp->next->next;
	return A;
}
```

