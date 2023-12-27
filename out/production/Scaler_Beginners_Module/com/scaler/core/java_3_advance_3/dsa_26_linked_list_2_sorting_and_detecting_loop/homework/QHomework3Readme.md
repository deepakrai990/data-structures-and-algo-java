### Q3. Add Two Numbers as Lists
#### Problem Description
```text
You are given two linked lists, A and B, representing 
two non-negative numbers.

The digits are stored in reverse order, and each of 
their nodes contains a single digit.

Add the two numbers and return it as a linked list.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p> 1 &lt;= |A|, |B| &lt;= 10<sup>5</sup> </p>
</div>

```text
1 <= |A|, |B| <= 10^5
```
#### Input Format
```text
The first argument of input contains a pointer to the head of linked list A.

The second argument of input contains a pointer to the head of linked list B.
```
#### Output Format
```text
Return a pointer to the head of the required linked list.
```
#### Example Input
```text
Input 1:
 A = [2, 4, 3]
 B = [5, 6, 4]

Input 2: 
 A = [9, 9]
 B = [1]
```
#### Example Output
```text
Output 1: 
 [7, 0, 8]

Output 2: 
 [0, 0, 1]
```
#### Example Explanation
```text
Explanation 1:
 A = 342 and B = 465. A + B = 807. 

Explanation 2:
 A = 99 and B = 1. A + B = 100. 
```
### Hints
* Hint 1
```text
Let us try thinking about how we would solve the naive addition of 
two numbers if we are not allowed to store an integer 
as it is, i.e., in int or double, etc., data type.

How will you implement the naive addition of two integers? 
Take care of the case where you have to carry a number to 
the next digit place.
```
* Solution Approach
```text
This problem can be solved exactly like the naive addition is 
done, using the temporary sum and implementing a value that 
represents a carryover.

Although, you can consider that there are two edge cases to it:
    
    1) The first list can be shorter than the second list. How will 
       you solve a problem like that?
    
    2) It is possible that the answer has more digits than both the 
       given integers. How to handle a case like this?
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
    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        ListNode node;
        ListNode prev = null;
        ListNode first = null;
        int carry = 0;
        int sum = 0;
        while (A != null || B != null || carry != 0) {
            node = new ListNode(0);
            // finds the value of each node
            sum = carry;
            if (first == null)
                first = node;
            if (prev != null)
                prev.next = node;
            if (A != null) {
                sum += A.val;
                A = A.next;
            }
            if (B != null) {
                sum += B.val;
                B = B.next;
            }
            node.val = sum % 10;
            sum /= 10;
            carry = sum;
            prev = node;
        }
        return first;
    }
}
```
* * Solution in Javascript
```javascript
// Definition for singly-linked list.
//    function Node(data) {
//      this.data = data
//      this.next = null
//    }

module.exports = {
    //param A : head node of linked list
    //param B : head node of linked list
    //return the head node in the linked list
    addTwoNumbers: function (l1, l2) {
        var l1p = l1;
        var l2p = l2;
        var prev = new Node(null);
        var prevp = prev;
        var carry = false;
        while (l1p || l2p) {
            var curr = l1p != null ? l1p : l2p;
            var val1 = l1p != null ? l1p.data : 0;
            var val2 = l2p != null ? l2p.data : 0;
            var val3 = carry ? 1 : 0;
            // finds the value of each node
            var sum = val1 + val2 + val3;
            if (sum > 9) {
                sum = sum - 10;
                carry = true;
            } else {
                carry = false;
            }
            curr.data = sum;
            prevp.next = curr;
            prevp = prevp.next;
            if (l1p)
                l1p = l1p.next;
            if (l2p)
                l2p = l2p.next;
        }
        if (carry) {
            prevp.next = new Node(1);
        }
        return prev.next;
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
ListNode * Solution::addTwoNumbers(ListNode * l1, ListNode * l2) {
    if (!l1)
        return l2;
    if (!l2)
        return l1;
    int carry = (l1 -> val + l2 -> val) / 10;
    ListNode * l3 = new ListNode((l1 -> val + l2 -> val) % 10);
    ListNode * tail = l3;
    l1 = l1 -> next;
    l2 = l2 -> next;
    while (l1 || l2 || carry) {
        // finds the value of each node
        int sum = ((l1 ? l1 -> val : 0) + (l2 ? l2 -> val : 0) + carry);
        ListNode * t = new ListNode(sum % 10);
        carry = sum / 10;
        if (l1)
            l1 = l1 -> next;
        if (l2)
            l2 = l2 -> next;
        tail -> next = t;
        tail = t;
    }
    return l3;
}
```

