### Q5. Product of 3
#### Problem Description
```text
Given an integer array A of size N.

You have to find the product of the three largest integers in array A from 
range 1 to i, where i goes from 1 to N.

Return an array B where B[i] is the product of the largest 3 integers in 
range 1 to i in array A. If i < 3, then the integer at index i in B should be -1.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= N &lt;= 10<sup>5</sup><br>
    0 &lt;= A[i] &lt;= 10<sup>3</sup></p>
</div>

```text
1 <= N <= 10^5
0 <= A[i] <= 10^3
```
#### Input Format
```text
First and only argument is an integer array A.
```
#### Output Format
```text
Return an integer array B. B[i] denotes the product of the largest 3 integers 
in range 1 to i in array A.
```
#### Example Input
```text
Input 1:
 A = [1, 2, 3, 4, 5]

Input 2:
 A = [10, 2, 13, 4]
```
#### Example Output
```text
Output 1:
 [-1, -1, 6, 24, 60]

Output 2:
 [-1, -1, 260, 520]
```
#### Example Explanation
```text
Explanation 1:
    For i = 1, ans = -1
    For i = 2, ans = -1
    For i = 3, ans = 1 * 2 * 3 = 6
    For i = 4, ans = 2 * 3 * 4 = 24
    For i = 5, ans = 3 * 4 * 5 = 60
    
    So, the output is [-1, -1, 6, 24, 60].

Explanation 2:
    For i = 1, ans = -1
    For i = 2, ans = -1
    For i = 3, ans = 10 * 2 * 13 = 260
    For i = 4, ans = 10 * 13 * 4 = 520
    
    So, the output is [-1, -1, 260, 520].
```
### Hints
* Hint 1
```text
Instead of traversing the whole array for each i from 1 to N.

Instead, we can find the top 3 largest numbers for each index by using a 
data structure like a heap.

A max heap will have the largest number at the top of it. Once the top number is removed,
it will have the second-largest number at the top.

Once the second-largest number is removed, we will have the third-largest 
number at the top.
```
* Solution Approach
```text
If we have traversed the array till some number (say i^th number), we will only 
add numbers further to it, and no deletion will occur.

A max heap will have the largest number at the top of it. Once the top number 
is removed, it will have the second-largest number at the top. Once the 
second-largest number is removed, we will have the third-largest number at the top.

Using these two observations, we can devise the following algorithm to compute 
the product of the three largest numbers from the first number to ith number.

    * Take the i^th number, and add it to the max heap.
    
    * Take the top number, this is the largest number from first number to 
      the i^th number. Store this in your product.
    
    * Delete the largest number. Now, the top number will have the 
      second largest number. Take this and multiply to the product.
    
    * Delete the top element of the max heap and now the top element is the 
      third largest number. Read that and multiply to the product so far to 
      get the product of the three largest numbers from first to ith number.

We can directly use priority queues (from STL in CPP) since they are 
already an implementation of the max heaps.

The above runs for each number in the list, and hence the worst-case 
time complexity would be O(n log(n)) which would easily fit with the constraints.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int[] solve(int[] A) {
        // n is the size of the vector
        int n = A.length;
        // Initialize an answer vector
        ArrayList < Integer > ans = new ArrayList < Integer > ();
        // Initialize a priority queue
        PriorityQueue < Integer > pq = new PriorityQueue(new CustomComp());

        for (int i = 0; i < n; i++) {
            // Add element in priority queue
            pq.offer(A[i]);
            // Append -1 to the answer as number of elements are < 3.
            if (i < 2) {
                ans.add(-1);
            } else {
                //take 3 maximum elements from queue.
                int a = pq.poll();
                int b = pq.poll();
                int c = pq.poll();
                //add all these numbers back to queue
                pq.offer(a);
                pq.offer(b);
                pq.offer(c);
                //append the product to answer
                ans.add(a * b * c);
            }
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++)
            res[i] = ans.get(i);
        return res;
    }
}
class CustomComp implements Comparator < Integer > {
    @Override
    public int compare(Integer a, Integer b) {
        return b - a;
    }
}
```
* * Solution in Javascript
```javascript
const top = 0;
const parent = i => ((i + 1) >>> 1) - 1;
const left = i => (i << 1) + 1;
const right = i => (i + 1) << 1;

class PriorityQueue {
    constructor(comparator = (a, b) => a > b) {
        this._heap = [];
        this._comparator = comparator;
    }
    size() {
        return this._heap.length;
    }
    isEmpty() {
        return this.size() == 0;
    }
    peek() {
        return this._heap[top];
    }
    push(...values) {
        values.forEach(value => {
            this._heap.push(value);
            this._siftUp();
        });
        return this.size();
    }
    pop() {
        const poppedValue = this.peek();
        const bottom = this.size() - 1;
        if (bottom > top) {
            this._swap(top, bottom);
        }
        this._heap.pop();
        this._siftDown();
        return poppedValue;
    }
    replace(value) {
        const replacedValue = this.peek();
        this._heap[top] = value;
        this._siftDown();
        return replacedValue;
    }
    _greater(i, j) {
        return this._comparator(this._heap[i], this._heap[j]);
    }
    _swap(i, j) {
        [this._heap[i], this._heap[j]] = [this._heap[j], this._heap[i]];
    }
    _siftUp() {
        let node = this.size() - 1;
        while (node > top && this._greater(node, parent(node))) {
            this._swap(node, parent(node));
            node = parent(node);
        }
    }
    _siftDown() {
        let node = top;
        while (
            (left(node) < this.size() && this._greater(left(node), node)) ||
            (right(node) < this.size() && this._greater(right(node), node))
        ) {
            let maxChild = (right(node) < this.size() && this._greater(right(node), left(node))) ? right(node) : left(node);
            this._swap(node, maxChild);
            node = maxChild;
        }
    }
}
module.exports = {
    //param A : array of integers
    //return a array of integers
    solve: function (A) {
        let n = A.length;
        // Initialize an answer vector
        let ans = [];
        // Initialize a priority queue
        let pq = new PriorityQueue();

        for (let i = 0; i < n; i++) {
            // Add element in priority queue
            pq.push(A[i]);
            // Append -1 to the answer as number of elements are < 3.
            if (i < 2) {
                ans.push(-1);
            } else {
                //take 3 maximum elements from queue.
                let a = pq.pop();
                let b = pq.pop();
                let c = pq.pop();
                //add all these numbers back to queue
                pq.push(a);
                pq.push(b);
                pq.push(c);
                //append the product to answer
                ans.push(a * b * c);
            }
        }
        return ans;
    }
};
```
* * Solution in C++
```cpp
vector < int > Solution::solve(vector < int > & A) {

    // n is the size of the vector
    int n = A.size();

    // Initialize an answer vector
    vector < int > ans;

    // Initialize a priority queue
    priority_queue < int > pq;

    for (int i = 0; i < n; i++) {

        // Add element in priority queue
        pq.push(A[i]);

        // Append -1 to the answer as number of elements are < 3.
        if (i < 2) {
            ans.push_back(-1);
        } else {
            //take 3 maximum elements from queue.
            int a = pq.top();
            pq.pop();
            int b = pq.top();
            pq.pop();
            int c = pq.top();

            pq.pop();

            //add all these numbers back to queue
            pq.push(a);
            pq.push(b);
            pq.push(c);

            //append the product to answer
            ans.push_back(a * b * c);
        }
    }
    return ans;
}
```

