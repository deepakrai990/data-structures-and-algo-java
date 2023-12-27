### Q1. Minimum largest element
#### Problem Description
```text
Given an array A of N numbers, you have to perform B operations. In each operation, you 
have to pick any one of the N elements and add the original value(value stored at 
the index before we did any operations) to its current value. You can choose any of 
the N elements in each operation.

Perform B operations in such a way that the largest element of the 
modified array(after B operations) is minimized.

Find the minimum possible largest element after B operations.
```
#### Problem Constraints
```text
1 <= N <= 10^6
0 <= B <= 10^5
-10^5 <= A[i] <= 10^5
```
#### Input Format
```text
The first argument is an integer array A.
The second argument is an integer B.
```
#### Output Format
```text
Return an integer denoting the minimum possible largest element after B operations.
```
#### Example Input
```text
Input 1:
 A = [1, 2, 3, 4] 
 B = 3

Input 2:
 A = [5, 1, 4, 2] 
 B = 5
```
#### Example Output
```text
Output 1:
 4

Output 2:
 5
```
#### Example Explanation
```text
Explanation 1:
    Apply operation on element at index 0, the array would change to [2, 2, 3, 4]
    Apply operation on element at index 0, the array would change to [3, 2, 3, 4]
    Apply operation on element at index 0, the array would change to [4, 2, 3, 4]
    Minimum possible largest element after 3 operations is 4.

Explanation 2:
    Apply operation on element at index 1, the array would change to [5, 2, 4, 2]
    Apply operation on element at index 1, the array would change to [5, 3, 4, 2]
    Apply operation on element at index 1, the array would change to [5, 4, 4, 2]
    Apply operation on element at index 1, the array would change to [5, 5, 4, 2]
    Apply operation on element at index 3, the array would change to [5, 5, 4, 4]
    Minimum possible largest element after 5 operations is 5.
```
### Hints
* Hint 1
```text
Consider the current and the next value of every element of an array.
How can we pick the best possible element so that the largest element is minimized?
Will using a min-heap of the next states of the elements of an array help?
```
* Solution Approach
```text
Let’s keep a state array to keep track of the value of every element in the 
array after K operations.

Maintain a state array, which tells about the state of the array after every operation.

Initially, the state array will be the same as the initial array.

We need to consider the next state of every element in the array.
Consider a min-heap. And initially push the next state of every element in the heap.

Note that you need to keep track of the indices of every element in the heap, 
present in the initial array.

Pick the top element, and change the state of that element in the state array.

Pop this element and push the next state in the heap.
At every operation, we are choosing the element whose next state is minimum hence 
there are only two possibilities:
    
    1) Either the maximum element remains the same, and we return that element directly.
    
    2) The next state of the popped element is the maximum.

We made sure changing the state of this element is the best option, as the next state 
of this element is the minimum.

Hence the maximum will be the least using this approach.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int[] A, int B) {
        PriorityQueue < Pair > pq = new PriorityQueue(new CustomComp());
        int s = A.length;
        //Let's keep a state array to keep track of the value of every element in the array after K operations.
        //Initially state array will be the same as the inital array.
        int[] state = new int[s];
        for (int i = 0; i < s; i++){
            state[i] = A[i];
        }
        
        //Consider a min heap. And initially push the next state of every element in the heap.
        //Note that you need to keep track of the indices of every element in the heap, present in the initial array.
        for (int i = 0; i < s; i++){
            pq.offer(new Pair(2 * A[i], i));
        }
        
        while(B-- > 0) {
            Pair top = pq.poll();
            
            //Pick the top element, and change the state of that element, in the state array. 
            state[top.ss] = top.ff;
            
            pq.offer(new Pair(A[top.ss] + top.ff, top.ss));
        }
        
        int mx = state[0];
        for (int i = 0; i < s; i++) mx = Math.max(mx, state[i]);
        return mx;
    }
}
class Pair {
    int ff;
    int ss;
    public Pair(int c, int d) {
        this.ff = c;
        this.ss = d;
    }
}
class CustomComp implements Comparator < Pair > {
    @Override
    public int compare(Pair a, Pair b) {
        return a.ff - b.ff;
    }
}
```
* * Solution in Javascript
```javascript
class MaxBinaryHeap {
  get size() {
    return this.values.length;
  }

  constructor() {
    this.values = [];
  }

  insert(elem) {
    this.values.push(elem);
    let index = this.size - 1;
    if (index === 0) return;

    let parentIndex = Math.floor((index - 1) / 2);

    while (
      this.values[parentIndex] &&
      this.values[parentIndex].val > this.values[index].val
    ) {
      [this.values[parentIndex], this.values[index]] = [
        this.values[index],
        this.values[parentIndex],
      ];
      index = parentIndex;
      parentIndex = Math.floor((index - 1) / 2);
    }
  }

  extract() {
    let parentIndex = 0;
    let lastIndex = this.size - 1;
    [this.values[parentIndex], this.values[lastIndex]] = [
      this.values[lastIndex],
      this.values[parentIndex],
    ];
    let result = this.values.pop();

    let leftChildIndex = 2 * parentIndex + 1;
    let rightChildIndex = 2 * parentIndex + 2;

    while (
      (this.values[leftChildIndex] !== undefined &&
        this.values[leftChildIndex].val < this.values[parentIndex].val) ||
      (this.values[rightChildIndex] !== undefined &&
        this.values[rightChildIndex].val < this.values[parentIndex].val)
    ) {
      let highestChildIndex;
      if (
        this.values[leftChildIndex] === undefined ||
        this.values[rightChildIndex] === undefined
      ) {
        highestChildIndex = leftChildIndex || rightChildIndex;
      } else {
        highestChildIndex =
          this.values[leftChildIndex].val < this.values[rightChildIndex].val
            ? leftChildIndex
            : rightChildIndex;
      }
      [this.values[parentIndex], this.values[highestChildIndex]] = [
        this.values[highestChildIndex],
        this.values[parentIndex],
      ];
      parentIndex = highestChildIndex;
      leftChildIndex = 2 * parentIndex + 1;
      rightChildIndex = 2 * parentIndex + 2;
    }
    return result;
  }
}
module.exports = {
  solve: function (A, B) {
    let pq = new MaxBinaryHeap();
    let s = A.length;

    let state = A.slice();

    for (let i = 0; i < s; i++) {
      let obj = {
        val: 2 * A[i],
        id: i,
      };
      pq.insert(obj);
    }
    while (B--) {
      let top = pq.extract();
      state[top.id] = top.val;
      let obj = {
        val: A[top.id] + top.val,
        id: top.id,
      };
      pq.insert(obj);
    }
    let mx = state[0];
    for (let i = 0; i < s; i++) mx = Math.max(mx, state[i]);
    return mx;
  },
};
```
* * Solution in C++
```cpp
int Solution::solve(vector < int > & A, int B) {
  priority_queue < pair < int, int > , vector < pair < int, int > > , greater < pair < int, int > > > pq;
  int s = A.size();
  assert(s >= 1 && s <= 1000000);
  assert(B >= 0 && B <= 100000);
  //Let's keep a state array to keep track of the value of every element in the array after K operations.
  //Initially state array will be the same as the inital array.
  vector < int > state = A;

  //Consider a min heap. And initially push the next state of every element in the heap.
  //Note that you need to keep track of the indices of every element in the heap, present in the initial array.

  for (int i = 0; i < s; i++) {
    assert(A[i] >= -10000 && A[i] <= 10000);
    pq.push(make_pair(2 * A[i], i));
  }
  while (B--) {
    pair < int, int > top = pq.top();

    //Pick the top element, and change the state of that element, in the state array. 
    state[top.second] = top.first;

    //Pop this element and push the next state in the heap.
    pq.pop();
    pq.push(make_pair(A[top.second] + top.first, top.second));
  }
  int mx = state[0];
  for (int i = 0; i < s; i++) mx = max(mx, state[i]);
  return mx;
}
```

