### Q3. Palindrome List
#### Problem Description
```text
Given a singly linked list A, determine if it's a palindrome. 
Return 1 or 0, denoting if it's a palindrome or not, respectively.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p> 1 &lt;= |A| &lt;= 10<sup>5</sup></p>
</div>

```text
1 <= |A| <= 10^5
```
#### Input Format
```text
The first and the only argument of input contains a pointer to the head of 
the given linked list.
```
#### Output Format
```text
Return 0, if the linked list is not a palindrome.

Return 1, if the linked list is a palindrome.
```
#### Example Input
```text
Input 1:
 A = [1, 2, 2, 1]

Input 2:
 A = [1, 3, 2]
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
Explanation 1:
    The first linked list is a palindrome as [1, 2, 2, 1] is equal to its reversed form.

Explanation 2:
    The second linked list is not a palindrome as [1, 3, 2] is not equal to [2, 3, 1].
```
### Hints
* Hint 1
```text
We need to check if the first half is equal to the last half(when reversed). 
But you can not store a different copy of reversed last half as 
this solution will not have constant space.

Can you modify the original list to do the above task?
```
* Solution Approach
```text
To check palindrome, we just have to reverse the latter half of 
the linked list, and then we can, in (n/2) steps total can compare if 
all elements are the same or not.

For finding the midpoint, first, we can in O(N) traverse the whole list 
and calculate the total number of elements.

Reversing is again O(N).
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
    public int lPalin(ListNode A) {
        ListNode slow_ptr = A, fast_ptr = A;
        ListNode second_half, prev_of_slow_ptr = A;
        ListNode midnode = null; // To handle odd size list
        int res = 1; // initialize result
        if (A != null && A.next != null) {
            /* Get the middle of the list. Move slow_ptr by 1
               and fast_ptrr by 2, slow_ptr will have the middle
               ListNode */
            while (fast_ptr != null && fast_ptr.next != null) {
                fast_ptr = fast_ptr.next.next;

                /*We need previous of the slow_ptr for
                  linked lists  with odd elements */
                prev_of_slow_ptr = slow_ptr;
                slow_ptr = slow_ptr.next;
            }
            /* fast_ptr would become NULL when there are even elements in list. 
               And not NULL for odd elements. We need to skip the middle ListNode 
               for odd case and store it somewhere so that we can restore the
               original list*/
            if (fast_ptr != null) {
                midnode = slow_ptr;
                slow_ptr = slow_ptr.next;
            }
            // Now reverse the second half and compare it with first half
            second_half = slow_ptr;
            prev_of_slow_ptr.next = null; // NULL terminate first half
            second_half = reverse(second_half); // Reverse the second half
            res = compareLists(A, second_half); // compare
        }
        return res;
    }
    public ListNode reverse(ListNode head_ref) {
        ListNode prev = null;
        ListNode current = head_ref;
        ListNode next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    /* Function to check if two input lists have same val*/
    int compareLists(ListNode head1, ListNode head2) {
        ListNode temp1 = head1;
        ListNode temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val == temp2.val) {
                temp1 = temp1.next;
                temp2 = temp2.next;
            } else return 0;
        }
        /* Both are empty reurn 1*/
        if (temp1 == null && temp2 == null)
            return 1;
        /* Will reach here when one is NULL
           and other is not */
        return 0;
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
 //return an integer
	lPalin : function(head){
            let slow = head, fast = head, prev, temp;
            while (fast && fast.next) {
                slow = slow.next, fast = fast.next.next;
    	    }
            prev = slow, slow = slow.next, prev.next = null;
            while (slow){
                temp = slow.next, slow.next = prev, prev = slow, slow = temp;
            }
            fast = head, slow = prev;
            while (slow){
                if (fast.data !== slow.data) return 0;
                else fast = fast.next, slow = slow.next;
            }
            return 1;
	}
};
```
* * Solution in C++
```cpp
void reverse(struct ListNode ** head_ref) {
    struct ListNode * prev = NULL;
    struct ListNode * current = * head_ref;
    struct ListNode * next;
    while (current != NULL) {
        next = current -> next;
        current -> next = prev;
        prev = current;
        current = next;
    }
    * head_ref = prev;
}

/* Function to check if two input lists have same val*/
bool compareLists(struct ListNode * head1, struct ListNode * head2) {
    struct ListNode * temp1 = head1;
    struct ListNode * temp2 = head2;
    while (temp1 && temp2) {
        if (temp1 -> val == temp2 -> val) {
            temp1 = temp1 -> next;
            temp2 = temp2 -> next;
        } else return 0;
    }
    /* Both are empty reurn 1*/
    if (temp1 == NULL && temp2 == NULL)
        return 1;
    /* Will reach here when one is NULL
       and other is not */
    return 0;
}

int Solution::lPalin(ListNode * A) {
    struct ListNode * slow_ptr = A, * fast_ptr = A;
    struct ListNode * second_half, * prev_of_slow_ptr = A;
    struct ListNode * midnode = NULL; // To handle odd size list
    int res = true; // initialize result
    if (A != NULL && A -> next != NULL) {
        /* Get the middle of the list. Move slow_ptr by 1
           and fast_ptrr by 2, slow_ptr will have the middle
           ListNode */
        while (fast_ptr != NULL && fast_ptr -> next != NULL) {
            fast_ptr = fast_ptr -> next -> next;

            /*We need previous of the slow_ptr for
              linked lists  with odd elements */
            prev_of_slow_ptr = slow_ptr;
            slow_ptr = slow_ptr -> next;
        }
        /* fast_ptr would become NULL when there are even elements in list. 
           And not NULL for odd elements. We need to skip the middle ListNode 
           for odd case and store it somewhere so that we can restore the
           original list*/
        if (fast_ptr != NULL) {
            midnode = slow_ptr;
            slow_ptr = slow_ptr -> next;
        }
        // Now reverse the second half and compare it with first half
        second_half = slow_ptr;
        prev_of_slow_ptr -> next = NULL; // NULL terminate first half
        reverse( & second_half); // Reverse the second half
        res = compareLists(A, second_half); // compare
    }
    return res;
}
```

