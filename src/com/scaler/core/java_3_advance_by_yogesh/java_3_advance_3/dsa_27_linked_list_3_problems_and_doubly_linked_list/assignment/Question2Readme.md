### Q2. Longest Palindromic List
#### Problem Description
```text
Given a linked list of integers. Find and return the length of the longest palindrome list that exists in that linked list.

A palindrome list is a list that reads the same backward and forward.

Expected memory complexity : O(1)
```
#### Problem Constraints
```text
1 <= length of the linked list <= 2000

1 <= Node value <= 100
```
#### Input Format
```text
The only argument given is head pointer of the linked list.
```
#### Output Format
```text
Return the length of the longest palindrome list.
```
#### Example Input
```text
Input 1:
 2 -> 3 -> 3 -> 3

Input 2:
 2 -> 1 -> 2 -> 1 ->  2 -> 2 -> 1 -> 3 -> 2 -> 2
```
#### Example Output
```text
Output 1:
 3

Output 2:
 5
```
#### Example Explanation
```text
Explanation 1:
 3 -> 3 -> 3 is largest palindromic sublist

Explanation 2:
 2 -> 1 -> 2 -> 1 -> 2 is largest palindromic sublist.
```
### Hints
* Hint 1
```text
N^2 solution time complexity can also pass,
So can we just retrieve the numbers from the list and them find longest
palindromic subarray??
```
* Solution Approach
```text
N^2 solution time complexity can also pass,

So can we just retrieve the numbers from the list and them find longest
palindromic subarray??

We can iterate over the list and store all numbers in another list. 

Now we can use N^2 brute force solution to calculate the longest palindromic 
substring in the given list.
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

        ListNode dummy = new ListNode(-1);
        ListNode cur = A, prev = dummy;
        int ans = 0;

        while (cur != null) {
            // Case 1: cur is a center node of palindrome of odd length

            ListNode prevItr = prev, nextItr = cur.next;
            int l = 1;
            while (prevItr != null && nextItr != null) {
                if (prevItr.val == nextItr.val) {
                    prevItr = prevItr.next;
                    nextItr = nextItr.next;
                    l++;
                } else break;

            }
            ans = Math.max(ans, l + l - 1);

            // Case 2: When palindrome length is even
            l = 0;
            prevItr = prev;
            nextItr = cur;

            while (prevItr != null && nextItr != null) {
                if (prevItr.val == nextItr.val) {
                    prevItr = prevItr.next;
                    nextItr = nextItr.next;
                    l++;
                } else break;

            }

            ans = Math.max(2 * l, ans);

            ListNode Next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = Next;
        }

        return ans;
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
int Solution::solve(ListNode * A) {
    ListNode * dummy = new ListNode(-1);
    ListNode * cur = A;
    ListNode * prev = dummy;
    int ans = 0;

    while (cur != NULL) {
        
        // Case 1: cur is a center node of palindrome of odd length
        ListNode * prevItr = prev;
        ListNode * nextItr = cur -> next;
        int l = 1;
        while (prevItr != NULL && nextItr != NULL) {
            if (prevItr -> val == nextItr -> val) {
                prevItr = prevItr -> next;
                nextItr = nextItr -> next;
                l++;
            } else break;
        }
        ans = max(ans, l + l - 1);

        // Case 2: When palindrome length is even
        l = 0;
        prevItr = prev;
        nextItr = cur;
        while (prevItr != NULL && nextItr != NULL) {
            if (prevItr -> val == nextItr -> val) {
                prevItr = prevItr -> next;
                nextItr = nextItr -> next;
                l++;
            } else break;
        }
        ans = max(2 * l, ans);

        ListNode * Next = cur -> next;
        cur -> next = prev;
        prev = cur;
        cur = Next;
    }

    return ans;
}
```

