### Q3. Special Median
#### Problem Description
```text
You are given an array A containing N numbers. This array is called special if 
it satisfies one of the following properties:

    1. There exists an element A[i] in the array such that A[i] is equal to the median 
       of elements [A[0], A[1], ...., A[i-1]]
    2. There exists an element A[i] in the array such that A[i] is equal to the median 
       of elements [A[i+1], A[i+2], ...., A[N-1]]

The Median is the middle element in the sorted list of elements. If the number 
of elements is even then the median will be (sum of both middle elements) / 2.

Return 1 if the array is special else return 0.

NOTE:

    * Do not neglect decimal point while calculating the median
    
    * For A[0] consider only the median of elements [A[1], A[2], ..., A[N-1]] 
      (as there are no elements to the left of it)
    
    * For A[N-1] consider only the median of elements [A[0], A[1], ...., A[N-2]]
```
#### Problem Constraints
```text
1 <= N <= 1000000.
A[i] is in the range of a signed 32-bit integer.
```
#### Input Format
```text
The first and only argument is an integer array A.
```
#### Output Format
```text
Return 1 if the given array is special else return 0.
```
#### Example Input
```text
Input 1:
 A = [4, 6, 8, 4]

Input 2:
 A = [2, 7, 3, 1]
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
    Here, 6 is equal to the median of [8, 4].

Explanation 2:
    No element satisfies any condition.
```
### Hints
* Hint 1
```text
This problem requires you to find the median at every point in the array.
Using a naive algorithm for finding the median won’t work here.
Can you think of a method where you can find the median at every point in O(logN) time?
```
* Solution Approach
```text
This problem is the same as finding the median in a stream of numbers. You can use 
max and min heaps to solve this problem. Following is the detailed algorithm:

Use two heaps:

    1. A max-heap to store all the elements that are less than or equal to the 
       effective median at any point.
    
    2. A min-heap to store all the elements that are more than the effective median 
       at any point.

Now, if the number of elements to find the median is odd, then the median is equal 
to the root of the max-heap. If the number of elements is even, then the median is 
equal to (the root of min-heap + root of max-heap)/2.

Note that the size of both the heaps at any point will differ by at most 1.

Using the Priority_queue interface of C++, the coding part is very easy.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    static PriorityQueue<Integer> maxHeap;
    static PriorityQueue<Integer> minHeap;

    public int solve(int[] A) {
        int n = A.length;
        minHeap = new PriorityQueue();
        maxHeap = new PriorityQueue(new CustomComp());
        for (int i = 0; i < (n - 1); i++) {
            add_number(A[i]);
            if (A[i + 1] == find_median()) return 1;
        }
        minHeap = new PriorityQueue();
        maxHeap = new PriorityQueue(new CustomComp());
        for (int i = n - 1; i > 0; i--) {
            add_number(A[i]);
            if (A[i - 1] == find_median()) return 1;
        }
        return 0;
    }

    public static void add_number(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.peek());
        maxHeap.poll();
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.peek());
            minHeap.poll();
        }
    }

    public static int find_median() {
        if (maxHeap.size() > minHeap.size()) return maxHeap.peek();
        else {
            int ans = maxHeap.peek() + minHeap.peek();
            if (ans % 2 != 0) return Integer.MAX_VALUE; //answer is a fraction
            else return ans / 2;
        }
    }
}

class CustomComp implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b) {
        return b - a;
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

    while (id > 0 && this.heap[id] > this.heap[par]) {
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
    if (l < this.heap.length && this.heap[cur] < this.heap[l]) cur = l;
    if (r < this.heap.length && this.heap[cur] < this.heap[r]) cur = r;
    if (cur != node) {
      [this.heap[node], this.heap[cur]] = [this.heap[cur], this.heap[node]];
      this.recurDown(cur);
    }
  }
  size() {
    return this.heap.length;
  }
  empty() {
    return this.heap.length == 0;
  }
}

const INF = 1000000000000;
let minHeap, maxHeap;

function add_number(num) {
  maxHeap.push(num);
  minHeap.push(-maxHeap.top());
  maxHeap.pop();

  if (maxHeap.size() < minHeap.size()) {
    maxHeap.push(-minHeap.top());
    minHeap.pop();
  }
}

function find_median() {
  if (maxHeap.size() > minHeap.size()) return maxHeap.top();
  else {
    let ans = maxHeap.top() - minHeap.top();
    if (ans % 2) return INF;
    else return Math.floor(ans / 2);
  }
}
module.exports = {
  solve: function (A) {
    let n = A.length;

    minHeap = new PriorityQueue();
    maxHeap = new PriorityQueue();

    for (let i = 0; i < n - 1; i++) {
      add_number(A[i]);
      if (A[i + 1] == find_median()) return 1;
    }

    minHeap = new PriorityQueue();
    maxHeap = new PriorityQueue();

    for (let i = n - 1; i > 0; i--) {
      add_number(A[i]);
      if (A[i - 1] == find_median()) return 1;
    }
    return 0;
  },
};
```
* * Solution in C++
```cpp
#define LL long long
#define INF 1000000000000LL

//Priority_Queue stores numbers as long long because we have to negate the numbers and
// also add two numbers, overflow will result in some corner cases and using long long will avoid it.
priority_queue < LL > minHeap, maxHeap;

void add_number(LL num) {
  //negative of a number is pushed because priority_queue is by defualt a max heap

  maxHeap.push(num);
  minHeap.push(-maxHeap.top());
  maxHeap.pop();

  if (maxHeap.size() < minHeap.size()) {
    maxHeap.push(-minHeap.top());
    minHeap.pop();
  }
}

LL find_median() {
  if (maxHeap.size() > minHeap.size()) return maxHeap.top();
  else {
    LL ans = maxHeap.top() - minHeap.top();
    if (ans % 2) return INF; //answer is a fraction
    else return ans / 2;
  }
}
int Solution::solve(vector < int > & A) {
  int n = A.size();

  //clear the priority queues (priority_queue in C++ doesn't have a clear() method)
  minHeap = priority_queue < LL > ();
  maxHeap = priority_queue < LL > ();

  for (int i = 0; i < (n - 1); i++) {
    add_number((LL)(A[i]));
    if (A[i + 1] == find_median()) return 1;
  }

  //clear the priority queues (priority_queue in C++ doesn't have a clear() method)
  minHeap = priority_queue < LL > ();
  maxHeap = priority_queue < LL > ();

  for (int i = n - 1; i > 0; i--) {
    add_number((LL)(A[i]));
    if (A[i - 1] == find_median()) return 1;
  }
  return 0;
}
```

