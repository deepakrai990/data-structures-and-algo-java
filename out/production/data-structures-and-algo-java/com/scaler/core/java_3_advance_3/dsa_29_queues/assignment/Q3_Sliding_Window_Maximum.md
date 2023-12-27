### Q3. Sliding Window Maximum
#### Problem Description
```text
Given an array of integers A. There is a sliding window of size B, moving from the 
very left of the array to the very right. You can only see the B numbers in the 
window. Each time the sliding window moves rightwards by one position. You have 
to find the maximum for each window.

Return an array C, where C[i] is the maximum value in the array from A[i] to A[i+B-1].

Refer to the given example for clarity.

NOTE: If B > length of the array, return 1 element with the max of the array.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= |A|, B &lt;= 10<sup>6</sup></p>
</div>

```text
1 <= |A|, B <= 10^6
```
#### Input Format
```text
The first argument given is the integer array A.

The second argument given is the integer B.
```
#### Output Format
```text
Return an array C, where C[i] is the maximum value of from A[i] to A[i+B-1].
```
#### Example Input
```text
Input 1:
 A = [1, 3, -1, -3, 5, 3, 6, 7]
 B = 3

Input 2:
 A = [1, 2, 3, 4, 2, 7, 1, 3, 6]
 B = 6
```
#### Example Output
```text
Output 1:
 [3, 3, 5, 5, 6, 7]

Output 2:
 [7, 7, 7, 7]
```
#### Example Explanation
```text
Explanation 1:
     Window position     | Max
     --------------------|-------
     [1 3 -1] -3 5 3 6 7 | 3
     1 [3 -1 -3] 5 3 6 7 | 3
     1 3 [-1 -3 5] 3 6 7 | 5
     1 3 -1 [-3 5 3] 6 7 | 5
     1 3 -1 -3 [5 3 6] 7 | 6
     1 3 -1 -3 5 [3 6 7] | 7

Explanation 2:
     Window position     | Max
     --------------------|-------
     [1 2 3 4 2 7] 1 3 6 | 7
     1 [2 3 4 2 7 1] 3 6 | 7
     1 2 [3 4 2 7 1 3] 6 | 7
     1 2 3 [4 2 7 1 3 6] | 7
```
### Hints
* Hint 1
```text
Approach 1 :
The obvious brute force solution with O(n * w) run time complexity is not efficient 
enough. Every time the window is moved, you have to search for a total of w elements 
in the window.

Approach 2:
A heap data structure quickly comes to mind. We could boost the run time to 
approximately O(n lg w) (Note that I said approximately because the size of the 
heap changes constantly and averages about w). Insert operation takes O(lg w) time, 
where w is the size of the heap. However, getting the maximum value is cheap; it 
takes constant time as the maximum value is always kept in the root (head) of the heap.

As the window slides to the right, some elements in the heap might not be valid 
anymore (range is outside of the current window). How should you remove them? You 
would need to be somewhat careful here. Since you only remove elements out of the 
window’s range, you would need to keep track of the elements’ indices.

Time complexity: O ( n log n ). Not good enough.

Approach 3 :
A double-ended queue should do the trick here.
The double-ended queue is the perfect data structure for this problem. It supports 
insertion/deletion from the front and back. The trick is to find a way such that 
the largest element in the window would always appear in the front of the queue. 
How would you maintain this requirement as you push and pop elements in and out of 
the queue?
```
* Solution Approach
```text
The double-ended queue is the perfect data structure for this problem. It supports 
insertion/deletion from the front and back. The trick is to find a way such that 
the largest element in the window would always appear in the front of the queue. 
How would you maintain this requirement as you push and pop elements in and out 
of the queue?

You might notice some redundant elements in the queue that we shouldn’t even 
consider about. For example, if the current queue has the elements: [10 5 3], 
and a new element in the window has the element 11. Now, we could have emptied 
the queue without considering elements 10, 5, and 3 and inserted only element 11 
into the queue.

A natural way most people would think is to try to maintain the queue size the 
same as the window’s size. Try to break away from this thought and try to think 
outside of the box. Removing redundant elements and storing only elements that 
need to be considered in the queue is the key to achieving the efficient O(n) solution.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    // DO NOT MODIFY THE LIST
    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        int n = A.size();
        int i;
        ArrayList<Integer> res = new ArrayList<>();
        int window = Math.min(A.size(), B);
        Deque<Node> deque = new LinkedList<>();
        int val;
        Node ans;
        for (i = 0; i < window - 1; i++) {
            val = A.get(i);
            while (!deque.isEmpty() && deque.peekFirst().val <= val) {
                deque.pollFirst();
            }
            deque.addFirst(new Node(i, val));
        }
        for (; i < n; i++) {
            val = A.get(i);
            // removes the elements not in range
            while (!deque.isEmpty() && (i - deque.peekLast().index >= window)) {
                deque.pollLast();
            }
            // removes the elements lesser than A[i]
            while (!deque.isEmpty() && deque.peekFirst().val <= val) {
                deque.pollFirst();
            }
            deque.addFirst(new Node(i, val));
            ans = deque.peekLast();
            res.add(ans.val);
        }
        return res;
    }

    class Node {
        int val;
        int index;

        public Node(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }
}
```
* * Solution in Javascript
```javascript
class Deque {
    constructor() {
        this.head = null;
        this.tail = null;
    }
    push(value, idx) {
        let node = new Node(value, idx);
        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            let tailElement = this.tail;
            tailElement.next = node;
            this.tail = node;
            this.tail.next = null;
            this.tail.prev = tailElement;
        }

    }
    pop() {
        this.tail = this.tail.prev;
        this.tail.next = null;
    }
    pushAndArrangeInDecendingOrder() {
        while (this.tail.prev && this.tail.prev.val.val < this.tail.val.val) {
            let prevPrevNode = this.tail.prev.prev;
            let prevNode = this.tail.prev;
            if (prevPrevNode) {
                prevPrevNode.next = this.tail;
                this.tail.prev = prevPrevNode;
            } else {
                this.tail.prev = null;
                this.head = this.tail;
                prevNode.next = null;
            }
            this.tail.next = null;
        }
    }
    findFirstNode() {
        return this.head.val;
    }
    shift() {
        if (!this.head) {
            return;
        } else if (this.head && this.head.next == null) {
            this.head = null;
            this.tail = null;
        } else {
            let headNode = this.head;
            this.head = headNode.next;
            this.head.prev = null;
        }
    }
}

class Node {
    constructor(value, idx) {
        this.val = {
            val: value,
            idx: idx
        };
        this.next = null;
        this.prev = null;
    }
}
module.exports = {
    //param A : array of integers
    //param B : integer
    //return a array of integers
    slidingMaximum: function (nums, k) {
        let maxElements = [];
        let deQueue = new Deque()
        for (let i = 0; i < nums.length; i++) {
            deQueue.push(nums[i], i);
            // removes the elements not in range
            if (deQueue.findFirstNode().idx <= i - k) {
                deQueue.shift();
            }
            deQueue.pushAndArrangeInDecendingOrder();
            if (i >= k - 1) {
                maxElements.push(deQueue.findFirstNode().val);
            }
        }
        return maxElements;
    }
};
```
* * Solution in C++
```cpp
vector < int > Solution::slidingMaximum(const vector < int > & A, int B) {
    deque < int > q;
    int N = A.size();
    int start = 0;
    vector < int > ans;
    for (int i = 0; i < B; i++) {
        while (q.size() > 0 && A[q.back()] < A[i]) {
            q.pop_back();
        }
        q.push_back(i);
    }
    ans.push_back(A[q.front()]);
    start++;
    for (int i = B; i < N; i++) {
        // removes the elements lesser than A[i]
        while (q.size() > 0 && A[q.back()] < A[i]) {
            q.pop_back();
        }
        q.push_back(i);
        // removes the elements not in range
        if (start > q.front()) q.pop_front();
        ans.push_back(A[q.front()]);
        start++;
    }
    return ans;
}
```

