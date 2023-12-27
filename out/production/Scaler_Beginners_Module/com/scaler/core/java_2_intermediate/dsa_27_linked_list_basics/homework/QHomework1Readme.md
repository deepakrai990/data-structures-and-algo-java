### Q1. K-th element in linked list
#### Problem Description
```text
You are given the head of a linked list A and an integer B. You 
need to find the B-th element of the linked list.

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
Return an integer.
```
#### Example Input
```text
Input 1:
 A = 1 -> 2 -> 3
 B = 0

Input 2:
 A = 4 -> 3 -> 2 -> 1
 B = 1
```
#### Example Output
```text
Output 1:
 1

Output 2:
 3
```
#### Example Explanation
```text
For Input 1:
    The 0-th element of the linked list is 1.

For Input 2:
    The 1-st element of the linked list is 3.
```
### Hints
* Hint 1
```text
You need to traverse the linked list and find
the required node.
```
* Solution Approach
```text
Traverse the linked list till you reach the B-th element

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
    public int solve(ListNode A, int B) {
        int curr = 0;
        while(curr < B){
            A = A.next;
            curr += 1;
        }
        return A.val;
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
int Solution::solve(ListNode* A, int B) {
    int curr = 0;
	while(curr < B){
		A = A->next;
		curr++;
	}
	return A->val;
}
```

