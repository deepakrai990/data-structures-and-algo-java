### Q2. Running Median
#### Problem Description
```text
Given an array of integers, A denoting a stream of integers. 
New arrays of integer B and C are formed.
Each time an integer is encountered in a stream, append it at the 
end of B and append the median of array B at the C.

Find and return the array C.

NOTE:

    * If the number of elements is N in B and N is odd, then consider 
      the median as B[N/2] ( B must be in sorted order).
    
    * If the number of elements is N in B and N is even, then consider 
      the median as B[N/2-1]. ( B must be in sorted order).
```
#### Problem Constraints
```text
1 <= length of the array <= 100000
1 <= A[i] <= 10^9
```
#### Input Format
```text
The only argument given is the integer array A.
```
#### Output Format
```text
Return an integer array C, C[i] denotes the median of the 
first i elements.
```
#### Example Input
```text
Input 1:
 A = [1, 2, 5, 4, 3]

Input 2:
 A = [5, 17, 100, 11]
```
#### Example Output
```text
Output 1:
 [1, 1, 2, 2, 3]

Output 2:
 [5, 5, 17, 11]
```
#### Example Explanation
```text
Explanation 1:
    stream          median
    [1]             1
    [1, 2]          1
    [1, 2, 5]       2
    [1, 2, 5, 4]    2
    [1, 2, 5, 4, 3] 3

Explanation 2:
    stream          median
    [5]              5
    [5, 17]          5
    [5, 17, 100]     17
    [5, 17, 100, 11] 11 
```
### Hints
* Hint 1
```text
To find the median of N elements. First, we need to sort the array 
and then take the middle element.

It means the median is an element of the array such that half elements 
are smaller and half elements are greater than that element.

Can we maintain two groups containing N/2 elements each?
```
* Solution Approach
```text
As it is mentioned in the hint, the median is an element of the array 
such that half elements are smaller and half elements are greater than 
that element.

So, the idea is to use max heap and min heap to store the elements of 
the higher half and lower half.

Max heap and min heap can be implemented using STL.

Algorithm

    1. Create two heaps. One max heap to maintain elements of the lower 
       half and one min heap to maintain elements of the higher half 
       at any point in time.
    
    2. Take the initial value of the median as 0.
    
    3. For every newly read element, insert it into either max heap or 
       min-heap and calculate the median based on the following conditions:

            1. If the size of the max-heap is greater than the size of 
               the min-heap and the element is less than the previous 
               median, then pop the top element from the max-heap and 
               insert it into the min-heap and insert the new element 
               into the max-heap else insert the new element to min-heap. 
               Calculate the new median as the average of the top of 
               elements of both max and min-heap.

            2. If the size of the max-heap is less than the size of the 
               min-heap and the element is greater than the previous median, 
               then pop the top element from the min-heap and insert 
               it into the max heap and insert the new element to the 
               min-heap else insert the new element to max-heap. 
               Calculate the new median as the average of the top of 
               elements of both max and min-heap.

            3. If the size of both heaps are the same. Then check if the 
               current is less than the previous median or not. If the 
               current element is less than the previous median, then 
               insert it into the max-heap, and the new median will be 
               equal to the top element of the max-heap. If the current 
               element is greater than the previous median, then insert 
               it into the min-heap, and the new median will be equal to 
               the top element of the min-heap.

Time Complexity:- O(NlogN)
Space Complexity:- O(N)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    static PriorityQueue<Integer> max_heap;
    static PriorityQueue<Integer> min_heap;

    public int[] solve(int[] A) {
        min_heap = new PriorityQueue();
        max_heap = new PriorityQueue(new CustomComp());
        int n = A.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            add(A[i]);
            ans[i] = get_median();
        }

        return ans;
    }

    public static int get_median() {
        int total = min_heap.size() + max_heap.size();
        int ret;
        if (total % 2 == 1) {
            if (max_heap.size() > min_heap.size())
                ret = max_heap.peek();
            else
                ret = min_heap.peek();
        } else {
            ret = Integer.MAX_VALUE;
            if (max_heap.size() != 0)
                ret = Math.min(ret, max_heap.peek());
            if (min_heap.size() != 0)
                ret = Math.min(ret, min_heap.peek());
        }
        return ret;
    }

    public static void add(int a) {
        if (max_heap.size() != 0 && (a >= max_heap.peek()))
            min_heap.offer(a);
        else
            max_heap.offer(a);

        if (Math.abs(max_heap.size() - min_heap.size()) > 1) {
            if (max_heap.size() > min_heap.size()) {
                int temp = max_heap.peek();
                max_heap.poll();
                min_heap.offer(temp);
            } else {
                int temp = min_heap.peek();
                min_heap.poll();
                max_heap.offer(temp);
            }
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
  constructor(fct) {
    this.heap = [];
    this.fct = fct;
  }
  top() {
    if (this.heap.length == 0) return undefined;
    return this.heap[0] * this.fct;
  }
  push(node) {
    this.heap.push(node * this.fct);
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
    return ret * this.fct;
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
  size() {
    return this.heap.length;
  }
  empty() {
    return this.heap.length == 0;
  }
}
let min_heap = new PriorityQueue(1);
let max_heap = new PriorityQueue(-1);

function add(a) {
  if (max_heap.size() && a >= max_heap.top()) min_heap.push(a);
  else max_heap.push(a);

  if (Math.abs(max_heap.size() - min_heap.size()) > 1) {
    if (max_heap.size() > min_heap.size()) {
      let temp = max_heap.pop();
      min_heap.push(temp);
    } else {
      let temp = min_heap.pop();
      max_heap.push(temp);
    }
  }
}

function get_median() {
  let total = min_heap.size() + max_heap.size();
  let ret;

  if (total % 2 == 1) {
    if (max_heap.size() > min_heap.size()) ret = max_heap.top();
    else ret = min_heap.top();
  } else {
    ret = Number.MAX_SAFE_INTEGER;
    if (max_heap.empty() == false) ret = Math.min(ret, max_heap.top());
    if (min_heap.empty() == false) ret = Math.min(ret, min_heap.top());
  }
  return ret;
}

function runningMedian(a) {
  let n = a.length;
  let ans = [];

  while (!min_heap.empty()) min_heap.pop();

  while (!max_heap.empty()) max_heap.pop();

  for (let i = 0; i < n; ++i) {
    add(a[i]);
    ans.push(get_median());
  }
  return ans;
}

module.exports = {
  solve: function (A) {
    return runningMedian(A);
  },
};
```
* * Solution in C++
```cpp
priority_queue < int, vector < int > , greater < int > > min_heap;
priority_queue < int > max_heap;

void add(int a) {
    if (max_heap.size() && a >= max_heap.top())
        min_heap.push(a);
    else
        max_heap.push(a);

    if (abs((int)max_heap.size() - (int)min_heap.size()) > 1) {
        if (max_heap.size() > min_heap.size()) {
            int temp = max_heap.top();
            max_heap.pop();
            min_heap.push(temp);
        } else {
            int temp = min_heap.top();
            min_heap.pop();
            max_heap.push(temp);
        }
    }
}

int get_median() {
    int total = min_heap.size() + max_heap.size();
    int ret;

    if (total % 2 == 1) {
        if (max_heap.size() > min_heap.size())
            ret = max_heap.top();
        else
            ret = min_heap.top();
    } else {
        ret = INT_MAX;
        if (max_heap.empty() == false)
            ret = min(ret, max_heap.top());
        if (min_heap.empty() == false)
            ret = min(ret, min_heap.top());
    }
    return ret;
}

vector < int > runningMedian(vector < int > & a) {

    int n = a.size();
    vector < int > ans;

    assert(n >= 1 && n <= 100000);

    // clear global variables
    while (!min_heap.empty())
        min_heap.pop();

    while (!max_heap.empty())
        max_heap.pop();

    for (int i = 0; i < n; ++i) {
        assert(a[i] >= 1 && a[i] <= 1000000000);
        add(a[i]);
        ans.push_back(get_median());
    }

    return ans;
}

vector < int > Solution::solve(vector < int > & A) {
    return runningMedian(A);
}
```

