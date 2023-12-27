### Q1. List Cycle
#### Problem Description
```text
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Try solving it using constant additional space.
```
#### Problem Constraints
```text

```
#### Input Format
```text

```
#### Output Format
```text

```
#### Example Input
```text
Input: 

                  ______
                 |     |
                 \/    |
        1 -> 2 -> 3 -> 4

Return the node corresponding to node 3. 
```
#### Example Output
```text

```
#### Example Explanation
```text

```
### Hints
* Hint 1
```text
Lets first look at detection of a cycle in the list.

Following are different ways of doing this

1) Use Hashing:
What if you could maintain a list of nodes already visited. As soon as you visit a node 
already visited, you know that there is a cycle.

2) 2 pointer approach ( Floyd’s Cycle-Finding Algorithm ) :

What if you have 2 pointers which are going at different speed. For arguments sake, 
lets just say one pointer is going at double the speed of the other.

Would they meet if there is a cycle ? Are they guaranteed to meet if there is a cycle ?
What happens if there is no cycle ?

Once you detect a cycle, think about finding the starting point.
```
* Solution Approach
```text
Lets now look at the starting point.
If we were using hashing, the first repetition we get is the starting point. Simple!

What happens with the 2 pointer approach ?

Method 1 :
If you detect a cycle, the meeting point is definitely a point within the cycle.

    * Can you determine the size of the cycle ? ( Easy ) Let the size be k.
    * Fix one pointer on the head, and another pointer to kth node from head.
    * Now move them simultaneously one step at a time. They will meet at the starting point of 
      the cycle.
Method 2 :
This might be slightly more complicated. It involves a bit of maths and is not as 
intuitive as method 1.

Suppose the first meet at step k,the distance between the start node of list and the 
start node of cycle is s, and the distance between the start node of cycle and the 
first meeting node is m.
Then
2k = (s + m + n1r)
2(s + m + n2r) = (s + m + n1r)
s + m = nr where n is an integer.
s = nr - m
s = (r - m) + (n-1)r

So, if we have one pointer on the head and another pointer at the meeting point. Note that 
since the distance between start node of cycle and the first meeting node is m, therefore 
if the pointer moves (r - m) steps, it will reach the start of the cycle. When the pointer 
at the head moves s steps, the second pointer moves (r-m) + (n-1)r steps which both points 
to the start of the cycle. In other words, both pointers meet first at the start of the 
cycle.
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
    public ListNode detectCycle(ListNode A) {

        HashSet<ListNode> hashSet = new HashSet<>();
        
        while (A != null) {
            if (hashSet.contains(A)) {
                return A;
            } else {
                hashSet.add(A);
            }
            A = A.next;
        }
        
        return null;
    }
}
```
* * Solution in Javascript
```javascript
// Definition for singly-linked list.
//			function Node(data){
//				this.data = data
//				this.next = null
//			}
module.exports = {
    //param A : head node of linked list
    //return the head node in the linked list
    detectCycle: function (A) {
        
        if (A == null || A.next == null) return null;

        let slow_pointer = A;
        let fast_pointer = A;
        let is_cycle = false;

        while (slow_pointer != null && fast_pointer != null) {
            slow_pointer = slow_pointer.next;

            if (fast_pointer.next == null) return null;
            fast_pointer = fast_pointer.next.next;

            if (slow_pointer == fast_pointer) {
                is_cycle = true;
                break;
            }

        }
        if (!is_cycle) return null;

        slow_pointer = A;
        while (slow_pointer != fast_pointer) {
            slow_pointer = slow_pointer.next;
            fast_pointer = fast_pointer.next;
        }

        return slow_pointer;

    }
};
```
* * Solution in C++
```cpp
class Solution {
public:
    ListNode *detectCycle(ListNode *head) {
        if (head == NULL || head->next == NULL) return NULL;

        ListNode* firstp = head;
        ListNode* secondp = head;
        bool isCycle = false;

        while(firstp != NULL && secondp != NULL) {
            firstp = firstp->next;
            if (secondp->next == NULL) return NULL;
            secondp = secondp->next->next;
            if (firstp == secondp) { isCycle = true; break; }
        }

        if(!isCycle) return NULL;
        firstp = head;
        while( firstp != secondp) {
            firstp = firstp->next;
            secondp = secondp->next;
        }

        return firstp;

        
    }
};
```

