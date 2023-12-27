### Q2. K Places Apart
#### Problem Description
```text
N people having different priorities are standing in a queue.

The queue follows the property that each person is standing 
at most B places away from its position in the sorted queue.

Your task is to sort the queue in the increasing order of priorities.

NOTE:

    * No two persons can have the same priority.
    * Use the property of the queue to sort the queue with complexity O(NlogB).
```
#### Problem Constraints
```text
1 <= N <= 100000
0 <= B <= N
```
#### Input Format
```text
The first argument is an integer array A representing the priorities 
and initial order of N persons.

The second argument is an integer B.
```
#### Output Format
```text
Return an integer array representing the sorted queue.
```
#### Example Input
```text
Input 1:
 A = [1, 40, 2, 3]
 B = 2

Input 2:
 A = [2, 1, 17, 10, 21, 95]
 B = 1
```
#### Example Output
```text
Output 1:
 [1, 2, 3, 40]

Output 2:
 [1, 2, 10, 17, 21, 95]
```
#### Example Explanation
```text
Explanation 1:
    Given array A = [1, 40, 2, 3]
    After sorting, A = [1, 2, 3, 40].
    We can see that difference between initial position of elements 
    amd the final position <= 2.

Explanation 2:
    After sorting, the array becomes [1, 2, 10, 17, 21, 95].
```
### Hints
* Hint 1
```text
If we have taken the first B+1 elements of the array, then using the 
given property, the minimum of these elements will be the 
smallest element of the array
```
* Solution Approach
```text
Take the first B+1 elements in a list, then finding the minimum of 
the list will give us the first element in the sorted array.

Remove the smallest element from the list and add the (B+2)th element 
from the given array to the list.

Now taking the minimum of the list will give us the second element 
in the sorted array as each element is <= B distance away from its 
sorted position.

Proceed in the same way and keep on finding the minimum of B+1 elements.

We can use priority_queue to implement the above solution. 
Each time we remove the minimum element from the queue and add 
the new element to the queue.

Time complexity of removing an element from the priority_queue 
will be O(log B) as the size of the queue is <= B+1, and we will 
remove all N elements from the queue one by one.

So, overall time complexity will be O(NlogB).
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int[] solve(int[] A, int B) {
        PriorityQueue<Integer> pq = new PriorityQueue();

        int i = 0, n = A.length;
        for (i = 0; i <= Math.min(B, n - 1); i++) {
            pq.offer(A[i]);
        }

        int j = 0;
        while (i < n) {
            A[j] = pq.poll();
            pq.offer(A[i]);
            i++;
            j++;
        }

        while (j < n) {
            A[j] = pq.poll();
            j++;
        }
        return A;
    }
}
```
* * Solution in Javascript
```javascript
class Pqs {
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
    let pq = new Pqs();
    let i = 0,
      n = A.length;
    for (i = 0; i <= Math.min(B, n - 1); i++) {
      pq.push(A[i]);
    }

    let j = 0;
    while (i < n) {
      A[j] = pq.pop();
      pq.push(A[i]);
      i++;
      j++;
    }

    while (j < n) {
      A[j] = pq.pop();
      j++;
    }

    return A;
  },
};

```
* * Solution in C++
```cpp
vector < int > Solution::solve(vector < int > & A, int B) {

  priority_queue < int, vector < int > , greater < int >> pq;

  int i = 0, n = A.size();
  for (i = 0; i <= min(B, n - 1); i++) {
    pq.push(A[i]);
  }

  int j = 0;
  while (i < n) {
    A[j] = pq.top();
    pq.pop();
    pq.push(A[i]);
    i++;
    j++;
  }

  while (j < n) {
    A[j] = pq.top();
    pq.pop();
    j++;
  }

  return A;
}
```

