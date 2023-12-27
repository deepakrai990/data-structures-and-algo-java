### Q2. N max pair combinations
#### Problem Description
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>Given two integers arrays, <strong>A</strong> and <strong>B,</strong> 
    of size <strong>N</strong> each.</p>
    <p>Find the <strong>maximum N elements</strong> from the sum 
    combinations (A<sub>i</sub> + B<sub>j</sub>) formed from elements in 
    arrays A and B.</p>
</div>

```text
Given two integers arrays, A and B, of size N each.

Find the maximum N elements from the sum combinations (Ai + Bj) formed from elements in 
arrays A and B.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= N &lt;= 2 * 10<sup>5</sup></p>
    <p>-1000 &lt;= A[i], B[i] &lt;= 1000</p>
</div>

```text
1 <= N <= 2 * 10^5

-1000 <= A[i], B[i] <= 1000
```
#### Input Format
```text
The first argument is an integer array A.
The second argument is an integer array B.
```
#### Output Format
```text
Return an integer array denoting the N maximum element in descending order.
```
#### Example Input
```text
Input 1:
 A = [1, 4, 2, 3]
 B = [2, 5, 1, 6]

Input 2:
 A = [2, 4, 1, 1]
 B = [-2, -3, 2, 4]
```
#### Example Output
```text
Output 1:
 [10, 9, 9, 8]

Output 2:
 [8, 6, 6, 5]
```
#### Example Explanation
```text
Explanation 1:
    4 maximum elements are 10(6+4), 9(6+3), 9(5+4), 8(6+2).

Explanation 2:
    4 maximum elements are 8(4+4), 6(4+2), 6(4+2), 5(4+1).
```
### Hints
* Hint 1
```text
Brute force is to find all combinations pair sum O(N ^ 2) and return top N max elements.
Can Sorting Work better?
```
* Solution Approach
```text
Sort both the arrays in ascending order.

Let us take the priority queue (heap).

The first max element is going to be the sum of the last two elements of 
array A and B, i.e. (A[n-1] + B[n-1]).

Insert that in the heap with indices of both arrays, i.e. (n-1, n-1).

Start popping from the heap (n-iterations).

And insert the sum (A[L-1]+A[R]) and (A[L]+B[R-1]).

Take care that repeating indices should not be there in the heap (use a map for 
that or a set).
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        Collections.sort(A, Collections.reverseOrder());
        Collections.sort(B, Collections.reverseOrder());
        int n = A.size();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : A) {
            for (int j : B) {
                int s = i + j;
                if (pq.size() < n) {
                    pq.add(s);
                } else {
                    if (s > pq.peek()) {
                        pq.poll();
                        pq.add(s);
                    } else {
                        break;
                    }
                }
            }
        }

        ArrayList<Integer> ret = new ArrayList<>(pq);
        Collections.sort(ret, Collections.reverseOrder());
        return ret;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
  solve: function (A, B) {
    A.sort((a, b) => b - a);
    B.sort((a, b) => b - a);
    let data = kSmallestPairs(A, B, A.length);
    let ret = [];
    data.forEach((ele) => ret.push(ele[0] + ele[1]));
    ret.sort((a, b) => b - a);
    return ret;
  },
};

var kSmallestPairs = function (nums1, nums2, k) {
  if (!nums1.length || !nums2.length) return [];

  let heap = new MaxBinaryHeap();

  for (let i = 0; i < nums1.length; i++) {
    for (let j = 0; j < nums2.length; j++) {
      let elem = {
        index: [nums1[i], nums2[j]],
        val: (nums1[i] + nums2[j]) * -1,
      };
      if (heap.size < k) {
        heap.insert(elem);
      } else if (elem.val * -1 > heap.values[0].val * -1) {
        heap.extract();
        heap.insert(elem);
      } else {
        break;
      }
    }
  }

  return heap.values.map((n) => n.index);
};

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
      this.values[parentIndex].val < this.values[index].val
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
        this.values[leftChildIndex].val > this.values[parentIndex].val) ||
      (this.values[rightChildIndex] !== undefined &&
        this.values[rightChildIndex].val > this.values[parentIndex].val)
    ) {
      let highestChildIndex;
      if (
        this.values[leftChildIndex] === undefined ||
        this.values[rightChildIndex] === undefined
      ) {
        highestChildIndex = leftChildIndex || rightChildIndex;
      } else {
        highestChildIndex =
          this.values[leftChildIndex].val > this.values[rightChildIndex].val
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
```
* * Solution in C++
```cpp
vector < int > Solution::solve(vector < int > & A, vector < int > & B) {
    priority_queue < pair < int, pair < int, int > > > hp;
    set < pair < int, int > > S;
    int n = A.size();
    sort(A.begin(), A.end());
    sort(B.begin(), B.end());

    hp.push(make_pair(A[n - 1] + B[n - 1], make_pair(n - 1, n - 1)));
    S.insert(make_pair(n - 1, n - 1));

    vector < int > ans;
    int k = n;
    while (k--) {
        pair < int, pair < int, int > > top = hp.top();
        hp.pop();
        ans.push_back(top.first);
        int L = top.second.first;
        int R = top.second.second;

        if (R > 0 && L >= 0 && S.find(make_pair(L, R - 1)) == S.end()) {
            hp.push(make_pair(A[L] + B[R - 1], make_pair(L, R - 1)));
            S.insert(make_pair(L, R - 1));
        }
        if (R >= 0 && L > 0 && S.find(make_pair(L - 1, R)) == S.end()) {
            hp.push(make_pair(A[L - 1] + B[R], make_pair(L - 1, R)));
            S.insert(make_pair(L - 1, R));
        }
    }
    return ans;
}
```

