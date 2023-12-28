### Q3. Compare Linked List
#### Problem Description
```text
Given heads of two linked lists A and B, check if they are 
identical i.e. each of their corresponding nodes should 
contain the same data. The two given linked lists may or 
may not be of the same length.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= size of linked lists &lt;= 10<sup>5</sup><br>
    1 &lt;= value of each node &lt;= 10<sup>9</sup></p>
</div>

```text
1 <= size of linked lists <= 10^5
1 <= value of each node <= 10^9
```
#### Input Format
```text
You are given the head of two linked lists A and B.
```
#### Output Format
```text
Return 1 if both the linked lists are identical and 0 otherwise
```
#### Example Input
```text
Input 1:
 A = 1 -> 2 -> 3
 B = 1 -> 2 -> 3

Input 2:
 A = 4 -> 3 -> 2 -> 1
 B = 4 -> 2 -> 3 -> 1
```
#### Example Output
```text
Output 1:
 1

Output 2:
 0
```
#### Example Explanation
```text
For Input 1:
    Both the linked lists are identical

For Input 2:
    The value in the second node of both the linked lists
    are different.
```
### Hints
* Hint 1
```text
We will have to check for every node if the corresponding
value in the other linked list is same or not
```
* Solution Approach
```text
We traverse both the linked list and check if their value is
same. If the length of both the linked list are not same then 
they are not identical.

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
    public int solve(ListNode A, ListNode B) {
        while(A != null && B != null){
            if(A.val != B.val){
                return 0;
            }
            A = A.next;
            B = B.next;
        }
        if(A == null && B == null){
            return 1;
        }
        return 0;
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
int Solution::solve(ListNode* A, ListNode* B) {
    while(A != NULL and B != NULL){
		if(A->val != B->val){
			return 0;
		}
		A = A->next;
		B = B->next;
	}
	if(A == NULL and B == NULL){
		return 1;
	}
	return 0;
}
```

