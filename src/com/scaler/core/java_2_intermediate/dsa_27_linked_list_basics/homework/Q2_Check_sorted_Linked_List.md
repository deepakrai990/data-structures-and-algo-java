### Q2. Check sorted Linked List
#### Problem Description
```text
You are given the head of a linked list A. Check if the data 
inside it exists in non-decreasing order.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= size of linked list &lt;= 10<sup>5</sup><br>
    1 &lt;= value of nodes &lt;= 10<sup>9</sup></p>
</div>

```text
1 <= size of linked list <= 10^5
1 <= value of nodes <= 10^9
```
#### Input Format
```text
The first argument A is the head of a linked list.
```
#### Output Format
```text
Return 1 if the data of nodes is non-decreasing and 0 otherwise
```
#### Example Input
```text
Input 1:
 A = 1 -> 2 -> 3 -> 3

Input 2:
 A = 4 -> 3 -> 2 -> 1
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
    The data of nodes follow a non-decreasing order.

For Input 2:
    The data of nodes are not in non-decreasing order.
```
### Hints
* Hint 1
```text
We can check the condition for every neighbouring nodes.
```
* Solution Approach
```text
Check for all nodes whether their data is less than or equal 
to the data of the next node.

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
    public int solve(ListNode A) {
        while(A != null){
            if(A.next != null){
                if(A.next.val < A.val){
                    return 0;
                }
            }
            A = A.next;
        }
        return 1;
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
int Solution::solve(ListNode* A) {
    while(A){
		if(A->next != NULL){
			if(A->next->val < A->val){
				return 0;
			}
		}
		A = A->next;
	}
	return 1;
}
```

