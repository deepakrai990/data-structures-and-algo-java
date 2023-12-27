### Q2. K reverse linked list
#### Problem Description
```text
Given a singly linked list A and an integer B, 
reverse the nodes of the list B at a time 
and return the modified linked list.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= |A| &lt;= 10<sup>3</sup><br>
    B always divides A</p>
</div>

```text
1 <= |A| <= 10^3

B always divides A
```
#### Input Format
```text
The first argument of input contains a pointer to 
the head of the linked list.

The second arugment of input contains the integer, B.
```
#### Output Format
```text
Return a pointer to the head of the modified linked list.
```
#### Example Input
```text
Input 1:
 A = [1, 2, 3, 4, 5, 6]
 B = 2

Input 2:
 A = [1, 2, 3, 4, 5, 6]
 B = 3
```
#### Example Output
```text
Output 1:
 [2, 1, 4, 3, 6, 5]

Output 2:
 [3, 2, 1, 6, 5, 4]
```
#### Example Explanation
```text
Explanation 1:
    For the first example, the list can be reversed in groups of 2.
        [[1, 2], [3, 4], [5, 6]]
    After reversing the K-linked list
        [[2, 1], [4, 3], [6, 5]]

Explanation 2:
    For the second example, the list can be reversed in groups of 3.
        [[1, 2, 3], [4, 5, 6]]
    After reversing the K-linked list
        [[3, 2, 1], [6, 5, 4]]
```
### Hints
* Hint 1
```text
You can try to split the given linked list into a bucket 
of K and try to solve the problem for those fixed buckets of size K.

How will you solve the problem if you have to reverse 
the whole linked list?

Moreover, you would try to somehow link the buckets after 
you have individually solved each of them, try thinking on 
how to achieve linking and reversing of the buckets 
using a minimum number of pointers.

Problems like these are using a divide and conquer 
type of approach where the bucket size is fixed. 

First, you divide the given list into |A|/K parts and 
then solve each one individually and then link the answers together.
```
* Solution Approach
```text
The given linked list can be split into buckets of length K. 
For doing this; you can use two pointers that are K elements 
apart in the linked list.

Now, let us try to solve the problem for one bucket, i.e., reversing
a single linked list.

So now, our problem has been modified to solve the problem 
for each bucket and then concatenating the lists to get a final
K-reversed linked list which is just an implementation issue.
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
    public ListNode reverseList(ListNode A, int B) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        prev.next = A;
        while (A != null) {
            int cnt = 1;
            ListNode cur = A;
            // take B consecutive nodes and reverse them
            while (cur.next != null && cnt < B) {
                cnt++;
                cur = cur.next;
            }
            if (cnt == B) {
                ListNode next = cur.next;
                cur.next = null;
                ListNode rev = reverse(A);
                prev.next = rev;
                A.next = next;
            }
            prev = A;
            A = A.next;
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode A) {
        ListNode prev = new ListNode(0), head = A;
        prev.next = A;
        while (A != null) {
            ListNode tmp = A.next;
            A.next = prev;
            prev = A;
            A = tmp;
        }
        head.next = null;
        return prev;
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
const reverseList = (head, k) => {
    let prev = null,
        cur = head;
    for (let i = 0; i < k; i++) {
        let next = cur.next;
        cur.next = prev;
        prev = cur;
        cur = next;
    }
    return prev;
}
module.exports = {
    //param A : head node of linked list
    //param B : integer
    //return the head node in the linked list
    reverseList: function (head, k) {
        if (!head) {
            return null;
        }
        let dummyHead = new Node();
        let newList = dummyHead;
        let cur = head;
        while (cur !== null) {
            let start = cur;
            // take B consecutive nodes and reverse them
            for (let i = 1; i < k; i++) {
                cur = cur.next;
                if (!cur) {
                    return dummyHead.next;
                }
            }
            let next = cur.next;
            newList.next = reverseList(start, k);
            start.next = next;
            newList = start;
            cur = next;
        }
        return dummyHead.next;
    }
};
```
* * Solution in C++
```cpp
ListNode * reverse(ListNode * A) {
    if (!A -> next)
        return A;
    ListNode * next = A -> next;
    A -> next = NULL;
    ListNode * reversed = reverse(next);
    next -> next = A;
    return reversed;
}

ListNode * Solution::reverseList(ListNode * A, int B) {
    ListNode * reversedFirst = A;
    for (int i = 1; i < B; i += 1) {
        reversedFirst = reversedFirst -> next;
    }
    ListNode * prev = new ListNode(0);
    ListNode * first;
    prev -> next = A;
    ListNode * last = prev;
    while (last -> next) {
        // take B consecutive nodes and reverse them
        for (int i = 1; i <= B; i += 1) {
            last = last -> next;
        }
        first = prev -> next;
        prev -> next = NULL;
        ListNode * next = last -> next;
        last -> next = NULL;
        reverse(first);
        prev -> next = last;
        first -> next = next;
        prev = last = first;
    }
    return reversedFirst;
}
```

