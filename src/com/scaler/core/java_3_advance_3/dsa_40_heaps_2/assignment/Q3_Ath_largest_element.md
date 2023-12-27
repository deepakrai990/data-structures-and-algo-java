### Q3. Ath largest element
#### Problem Description
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>Given an integer array <strong>B</strong> of size <strong>N</strong>.</p>
    <p>You need to find the <strong>A<sup>th</sup></strong> largest element in 
    the <strong>subarray [1 to i],</strong> where <strong>i</strong> varies 
    from <strong>1</strong> to <strong>N</strong>. In other words, find the 
    <strong>A<sup>th</sup></strong> largest element in the sub-arrays 
    <strong>[1 : 1], [1 : 2], [1 : 3], ...., [1 : N]</strong>.</p>
    <p><strong>NOTE:</strong> If any subarray [1 : i] has less than A elements, 
    then the output should be <strong>-1</strong> at the <strong>i<sup>th</sup></strong> 
    index.</p>
</div>

```text
Given an integer array B of size N.

You need to find the Ath largest element in the subarray [1 to i], where i varies 
from 1 to N. In other words, find the Ath largest element in the 
sub-arrays [1 : 1], [1 : 2], [1 : 3], ...., [1 : N].

NOTE: If any subarray [1 : i] has less than A elements, then the output should 
be -1 at the ith index.
```
#### Problem Constraints
```text
1 <= N <= 100000
1 <= A <= N
1 <= B[i] <= INT_MAX
```
#### Input Format
```text
The first argument is an integer A.
The second argument is an integer array B of size N.
```
#### Output Format
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>Return an integer array C, where C[i] (1 &lt;= i &lt;= N) will have the 
    A<sup>th</sup> largest element in the subarray [1 : i].</p>
</div>

```text
Return an integer array C, where C[i] (1 <= i <= N) will have the A^th largest 
element in the subarray [1 : i].
```
#### Example Input
```text
Input 1:
 A = 4  
 B = [1 2 3 4 5 6] 

Input 2:
 A = 2
 B = [15, 20, 99, 1]
```
#### Example Output
```text
Output 1:
 [-1, -1, -1, 1, 2, 3]

Output 2:
 [-1, 15, 20, 20]
```
#### Example Explanation
```text
Explanation 1:
    for i <= 3 output should be -1.
    for i = 4, Subarray [1:4] has 4 elements 1, 2, 3 and 4. So, 4th maximum element is 1.
    for i = 5, Subarray [1:5] has 5 elements 1, 2, 3, 4 and 5. So, 4th maximum element is 2.
    for i = 6, Subarray [1:6] has 6 elements 1, 2, 3, 4, 5 and 6. So, 4th maximum element is 3.
    So, output array is [-1, -1, -1, 1, 2, 3].
 
Explanation 2:
    for i <= 1 output should be -1.
    for i = 2 , Subarray [1:2] has 2 elements 15 and 20. So, 2th maximum element is 15.
    for i = 3 , Subarray [1:3] has 3 elements 15, 20 and 99. So, 2th maximum element is 20.
    for i = 4 , Subarray [1:4] has 4 elements 15, 20, 99 and 1. So, 2th maximum element is 20.
    So, output array is [-1, 15, 20, 20].
```
### Hints
* Hint 1
```text
After each insertion, you need to retrieve the Kth largest element.
So basically, you need to keep the elements in sorted or semi-sorted order.
So you can use a data structure like a heap.
```
* Solution Approach
```text
One solution is to use a Min Heap of size k to store k largest numbers.
The Kth highest element is always at the root and can be found in O(1) time.

How to process a new number?
Compare the new number value X with the root of the heap. If X is smaller, then ignore it.
Otherwise, replace root with X and call heapify for the root of the modified heap.

The time complexity of adding a new element and finding the Kth highest element is O(logK).
STL priority queue can be used to implement a heap directly.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int[] solve(int A, int[] B) {
        PriorityQueue<Integer> pq = new PriorityQueue();
        int n = B.length;
        int[] ans = new int[n];

        for (int i = 0; i < A; i++) {
            pq.offer(B[i]);
            if (i != A - 1) ans[i] = -1;
            else ans[i] = pq.peek();
        }

        for (int i = A; i < n; i++) {
            if (B[i] <= pq.peek()) {
                ans[i] = pq.peek();
            } else {
                pq.poll();
                pq.offer(B[i]);
                ans[i] = pq.peek();
            }
        }
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
class PriorityQueue {
  constructor() {
    this.heap = [];
  }
  top() {
    if (this.heap.length == 0) return undefined;
    return this.heap[0];
  }
  push(node) {
    this.heap.push(node);
    let id = this.heap.length - 1;
    let par = Math.floor((id - 1) / 2);

    while (id > 0 && this.heap[id] < this.heap[par]) {
      [this.heap[id], this.heap[par]] = [this.heap[par], this.heap[id]];
      id = Math.floor((id - 1) / 2);
      par = Math.floor((id - 1) / 2);
    }
  }
  pop() {
    let ret = this.heap[0];
    this.heap[0] = this.heap[this.heap.length - 1];
    this.heap.pop();
    this.recurDown(0);
    return ret;
  }
  recurDown(node) {
    let l = node * 2 + 1;
    let r = node * 2 + 2;

    let cur = node;
    if (l < this.heap.length && this.heap[cur] > this.heap[l]) cur = l;
    if (r < this.heap.length && this.heap[cur] > this.heap[r]) cur = r;
    if (cur != node) {
      [this.heap[node], this.heap[cur]] = [this.heap[cur], this.heap[node]];
      this.recurDown(cur);
    }
  }
}

module.exports = {
  solve: function (A, B) {
    let pq = new PriorityQueue();
    let n = B.length;

    let ans = new Array(n).fill(0);

    for (let i = 0; i < A; i++) {
      pq.push(B[i]);
      if (i != A - 1) ans[i] = -1;
      else ans[i] = pq.top();
    }

    for (let i = A; i < n; i++) {
      if (B[i] <= pq.top()) {
        ans[i] = pq.top();
      } else {
        pq.pop();
        pq.push(B[i]);
        ans[i] = pq.top();
      }
    }
    return ans;
  },
};
```
* * Solution in C++
```cpp
vector < int > Solution::solve(int A, vector < int > & B) {
  priority_queue < int, vector < int > , greater < int > > pq; //stl priority_queue => implements min heap
  int n = B.size(); //number of elements in the input.

  vector < int > ans(n); //final answer

  for (int i = 0; i < A; i++) {
    pq.push(B[i]); //Push the element in the priority queue

    //if i<A-1 then definitely answer is -1 as the Ath element is yet to be discovered
    //If i==A-1 that means there are total A elements in the heap/pq therefore the root element
    //would be the Ath largest element
    if (i != A - 1) ans[i] = -1;
    else ans[i] = pq.top();
  }

  for (int i = A; i < n; i++) {
    //If the element is greater than the root element then we need to pop the root and add this element
    //else we ignore the element and our answer will be the root element.
    if (B[i] <= pq.top()) {
      ans[i] = pq.top();
    } else {
      pq.pop();
      pq.push(B[i]);
      ans[i] = pq.top();
    }
  }
  return ans;
}
```

