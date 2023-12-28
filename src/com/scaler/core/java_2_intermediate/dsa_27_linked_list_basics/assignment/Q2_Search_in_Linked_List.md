### Q2. Search in Linked List
#### Problem Description
```text
You are given the head of a linked list A and an integer B, check 
if there is any node which contains this value B.

Return 1 if such a node is present else return 0.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= size of linked list &lt;= 10<sup>5</sup><br>
    1 &lt;= value of nodes &lt;= 10<sup>9</sup><br>
    1 &lt;= B &lt;= 10<sup>9</sup></p>
</div>

```text
1 <= size of linked list <= 10^5
1 <= value of nodes <= 10^9
1 <= B <= 10^9
```
#### Input Format
```text
The first argument A is the head of a linked list.

The second argument B is an integer.
```
#### Output Format
```text
Return 1 if such a node is present otherwise return 0.
```
#### Example Input
```text
Input 1:
 A = 1 -> 2 -> 3
 B = 4

Input 2:
 A = 4 -> 3 -> 2 -> 1
 B = 4
```
#### Example Output
```text
Output 1:
 0

Output 2:
 1
```
#### Example Explanation
```text
For Input 1:
    None of the nodes have a value 4.

For Input 2:
    The first node has a value 4.
```
### Hints
* Hint 1
```text
You need to search the value B in all the nodes
```
* Solution Approach
```text
Traverse all the nodes of the linked list. If you encounter a node with 
value B then return 1, otherwise keep traversing. Finally 
return 0 denoting that the required node is not found.

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
        while(A != null){
            if(A.val == B){
                return 1;
            }
            A = A.next;
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
int Solution::solve(ListNode* A, int B) {
    while(A != NULL){
		if(A->val == B){
			return 1;
		}
		A = A->next;
	}
	return 0;
}
```

