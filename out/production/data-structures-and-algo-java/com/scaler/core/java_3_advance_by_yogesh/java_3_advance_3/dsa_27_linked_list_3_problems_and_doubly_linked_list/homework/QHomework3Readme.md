### Q3. Intersection of Linked Lists
#### Problem Description
```text
Write a program to find the node at which the intersection 
of two singly linked lists, A and B, begins. For example, the 
following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗
B:     b1 → b2 → b3

NOTE:

    * If the two linked lists have no intersection at all, return null.
    
    * The linked lists must retain their original structure after 
      the function returns.
    
    * You may assume there are no cycles anywhere in the entire 
      linked structure.
    
    * Your code should preferably run in O(n) time and use only O(1) memory.
    
    * The custom input to be given is different than the one 
      explained in the examples. Please be careful.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p> 0 &lt;= |A|, |B| &lt;= 10<sup>6</sup> </p>
</div>

```text
0 <= |A|, |B| <= 10^6
```
#### Input Format
```text
The first argument of input contains a pointer to the head of 
the linked list A.

The second argument of input contains a pointer to the head of 
the linked list B.
```
#### Output Format
```text
Return a pointer to the node after which the linked list is intersecting.
```
#### Example Input
```text
Input 1:
 A = [1, 2, 3, 4, 5]
 B = [6, 3, 4, 5]

Input 2:
 A = [1, 2, 3]
 B = [4, 5]
```
#### Example Output
```text
Output 1:
 [3, 4, 5]

Output 2:
 []
```
#### Example Explanation
```text
Explanation 1:
    In the first example, the nodes have the same values 
    after 3rd node in A and 2nd node in B. Thus, the 
    linked lists are intersecting after that point. 

Explanation 2:
    In the second example, the nodes don't have the same 
    values, thus we can return None/Null. 
```
### Hints
* Hint 1
```text
/** Not available **/
```
* Solution Approach
```text
Brute Force-
Check all pairs of both Linked Lists. For each node 
of Linked List A, compare it with all nodes of Linked List B and 
return the node if it is found equal to current node of A.

Return null if no intersection found.

Time Complexity - O(lA * lB) where lA is length of A and lB is length of B.

Optimized
Let’s say that the linked list A, has length lA, and 
linked list B has length lB. Let’s say both these 
linked lists merge at some point X. After X, both the 
linked lists will have the same length, but the lengths 
might differ before X.

So, what we can do is, initially, calculate both lA and lB by 
doing a simple traversal of the linked lists. Then we can 
keep ptr1 at the head of A, and ptr2 at the head of B.

If lA > lB, we move ptr1 forward, lA - lB times otherwise, we 
move ptr2 forward, lB - lA times. At this point, both the pointers 
will be equidistant from X. 
Now, we simple keep moving ptr1 and ptr2 ahead till they 
dont meet at a common point.

If, even after reaching the end of A and B, ptr1 and ptr2 are 
not equal, we can return None/Null.
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
	public ListNode getIntersectionNode(ListNode A, ListNode B) {
	    ListNode lastA, lastB;
	    int countA, countB;
	    
	    if (A == null || B == null)
	        return null;
	    
	    countA = countB = 1;
	    
	    lastA = A;
	    lastB = B;
	    
	    while (lastA.next != null) {
	        lastA = lastA.next;
	        countA++;
	    }
	    
	    while (lastB.next != null) {
	        lastB = lastB.next;
	        countB++;
	    }
	    
	    if (!lastA.equals(lastB))
	        return null;
	    
	    int diff = Math.abs(countA - countB);
	    
	    lastA = A;
	    lastB = B;
	    
	    if (countA > countB) {
	        while (diff-- > 0) {
	            lastA = lastA.next;
	        }
	    } else {
	        while (diff-- > 0)
	            lastB = lastB.next;
	    }
	    
	    while (!lastA.equals(lastB)) {
	        lastA = lastA.next;
	        lastB = lastB.next;
	    }
	    
	    return lastA;
	    
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
function getLength(head) {
  let ret = 0;
  while (head != null) {
    ret++;
    head = head.next;
  }
  return ret;
}

module.exports = {
  //param A : head node of the first linked list
  //param B : head node of the second linked list
  //return the intersection node
  solve: function(A, B) {
    if (!A || !B)
      return null;
    let pa = A;
    let pb = B;
    let lenA = getLength(A),
      lenB = getLength(B);
    let lenDiff = lenA - lenB;
    if (lenDiff > 0) {
      while (lenDiff != 0) {
        pa = pa.next;
        lenDiff--;
      }
    } else if (lenDiff < 0) {
      while (lenDiff != 0) {
        pb = pb.next;
        lenDiff++;
      }
    }
    while (pa && pb) {
      if (pa == pb)
        return pa;
      pa = pa.next;
      pb = pb.next;
    }
    return null;
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

int getLength(ListNode *head) {
    int ret = 0;
    while (head) {
        ret++;
        head = head->next;
    }
    return ret;
}

ListNode* Solution::getIntersectionNode(ListNode* A, ListNode* B) {
    if(!A || !B)
        return NULL;
    int lenA = getLength(A), lenB = getLength(B);
    int lenDiff = lenA - lenB;
    ListNode *pa = A;
    ListNode *pb = B;
    if(lenDiff > 0) {
        while(lenDiff != 0) {
            pa = pa->next;
            lenDiff--;
        }
    }
    else if(lenDiff < 0) {
        while(lenDiff != 0) {
            pb = pb->next;
            lenDiff++;
        }
    }
    while(pa && pb) {
        if(pa == pb)
            return pa;
        pa = pa->next;
        pb = pb->next;
    }
    return NULL;
}
```

