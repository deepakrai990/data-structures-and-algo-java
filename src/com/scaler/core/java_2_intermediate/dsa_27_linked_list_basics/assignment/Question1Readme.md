### Q1. Print Linked List
#### Problem Description
```text
You are given A which is the head of a linked list. Print the linked 
list in space separated manner.

Note : The last node value must also be succeeded by a space and 
after printing the entire list you should print a new line
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px; ">
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
You dont need to return anything
```
#### Example Input
```text
Input 1:
 A = 1 -> 2 -> 3

Input 2:
 A = 4 -> 3 -> 2 -> 1
```
#### Example Output
```text
Output 1:
 1 2 3

Output 2:
 4 3 2 1
```
#### Example Explanation
```text
For Input 1:
    We print the given linked list

For Input 2:
    We print the given linked list
```
### Hints
* Hint 1
```text
You need to print the entire linked list
```
* Solution Approach
```text
Traverse the entire list and print the value of
each node.

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
    public void solve(ListNode A) {
        while(A != null){
            System.out.print(A.val + " ");
            A = A.next;
        }
        System.out.print("\n");
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
void Solution::solve(ListNode* A) {
    while(A != NULL){
		cout<<A->val<<" ";
		A = A -> next;
	}
	cout<<endl;
}
```

