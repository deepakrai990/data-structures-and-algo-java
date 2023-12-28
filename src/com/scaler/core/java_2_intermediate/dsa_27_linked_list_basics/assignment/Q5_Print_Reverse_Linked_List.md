### Q5. Print Reverse Linked List
#### Problem Description
```text
You are given a singly linked list having head node A. You need to 
print the linked list in reverse order.

Note :- The node values must be space separated. You must give a 
newline after printing all the nodes.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= Length of linked list &lt;= 10<sup>5</sup><br>
    1 &lt;= Value of each linked list node &lt;= 10<sup>9</sup></p>
</div>

```text
1 <= Length of linked list <= 10^5
1 <= Value of each linked list node <= 10^9
```
#### Input Format
```text
First and only argument is a linked-list node A.
```
#### Output Format
```text
Print the linked list in reverse order
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
 5 4 3 2 1

Output 2:
 3 
```
#### Example Explanation
```text
Explanation 1:
    The linked list has 5 nodes. After reversing them, 
    the list becomes : 5 -> 4 -> 3 -> 2 -> 1 -> NULL 

Explanation 2:
    The linked list consists of only a single node. After 
    reversing it, the list becomes : 3 -> NULL 
```
### Hints
* Hint 1
```text
Try to traverse all the nodes of the linked list 
recursively.
```
* Solution Approach
```text
We will recursively call the next node for each node
of the linked list. After calling the function, we will
print the value of that node.

Time Complexity : O(N)
Space Complexity : O(N)

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
    public void printLL(ListNode A){
        if(A == null){
            return;
        }
        printLL(A.next);
        System.out.print(A.val + " ");
    }
    public void solve(ListNode A) {
        printLL(A);
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
 void printLL(ListNode * A){
	if(A == NULL){
		return;
	}
	printLL(A->next);
	cout<<A->val<<" ";
}
void Solution::solve(ListNode* A) {
	printLL(A);
	cout<<endl;
}
```

