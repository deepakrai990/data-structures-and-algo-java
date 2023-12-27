### Q1. Magician and Chocolates
#### Problem Description
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>Given <strong>N</strong> bags, each bag contains <strong>B<sub>i</sub></strong> 
    chocolates. There is a kid and a magician. <br>In a unit of time, the kid can 
    choose any bag <strong>i</strong>, and eat <strong>B<sub>i</sub></strong> 
    chocolates from it, then the magician will fill the <strong>ith</strong> bag 
    with <strong>floor(B<sub>i</sub>/2)</strong> chocolates.</p>
    <p>Find the maximum number of chocolates that the kid can eat in 
    <strong>A</strong> units of time.</p>
    <p><strong>NOTE:</strong></p>
    <ol>
    <li>floor() function returns the largest integer less than or equal to a 
    given number.</li>
    <li>Return your answer modulo <strong>10<sup>9</sup>+7</strong></li>
    </ol>
</div>

#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= N &lt;= 100000<br>
    0 &lt;= B[i] &lt;= INT_MAX<br>
    0 &lt;= A &lt;= 10<sup>5</sup></p>
</div>

```text
1 <= N <= 100000
0 <= B[i] <= INT_MAX
0 <= A <= 10^5
```
#### Input Format
```text
The first argument is an integer A.
The second argument is an integer array B of size N.
```
#### Output Format
```text
Return an integer denoting the maximum number of chocolates the kid can eat in A 
units of time.
```
#### Example Input
```text
Input 1:
 A = 3
 B = [6, 5]

Input 2:
 A = 5
 b = [2, 4, 6, 8, 10]
```
#### Example Output
```text
Output 1:
 14

Output 2:
 33
```
#### Example Explanation
```text
Explanation 1:
    At t = 1 kid eats 6 chocolates from bag 0, and the bag gets filled by 3 chocolates. 
    At t = 2 kid eats 5 chocolates from bag 1, and the bag gets filled by 2 chocolates. 
    At t = 3 kid eats 3 chocolates from bag 0, and the bag gets filled by 1 chocolate. 
    so, total number of chocolates eaten are 6 + 5 + 3 = 14

Explanation 2:
    Maximum number of chocolates that can be eaten is 33.
```
### Hints
* Hint 1
```text
It is pretty trivial to figure out that the kid will always choose the bag with the 
maximum number of chocolates.

By knowing this fact, how would you solve the problem?
```
* Solution Approach
```text
The solution to this problem can be found greedily.

At any time t, the kid will always choose the bag with the maximum number of chocolates 
and consume all its chocolates.

So we need to maintain the current maximum size among all bags for 
every time t = 1, … , B and also update the sizes of the bags.

This can be done using a max heap : https://en.wikipedia.org/wiki/Min-max_heap

Time Complexity:- O(AlogN + N)
Space Complexity:- O(N)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    static long mod = 1000000007;
    public int nchoc(int A, int[] B) {
        int N = B.length;
        int K = A;
        long ans = 0;
        PriorityQueue < Integer > heap = new PriorityQueue(new CustomComp());
        for (int a: B)
            heap.offer(a);
        while (K > 0) {
            //Get maximum element from the heap 
            long max_elem = (long) heap.poll();
            // Add the maximum element to the answer
            ans += max_elem;
            ans = ans % mod;
            // push the floor(A[i]/2) back to the heap.
            heap.offer((int)(max_elem / 2));
            K--;
        }
        return (int) ans;
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
    //param A : integer
    //param B : array of integers
    //return an integer
    nchoc: function (A, B) {
        let N = B.length;
        let K = A;
        let ans = 0;
        // create a heap containing all elements of B
        let heap = new PriorityQueue();
        for (let i = 0; i < N; i++) {
            heap.push(B[i]);
        }
        while (K--) {
            let max_elem = heap.pop();
            // Add the maximum element to the answer
            ans += max_elem;
            ans = ans % 1000000007;
            // push the floor(A[i]/2) back to the heap.
            heap.push(Math.floor(max_elem / 2));
        }
        return ans;
    }
};
```
* * Solution in C++
```cpp
long long int mod = 1000000007;
int Solution::nchoc(int A, vector < int > & B) {
    int N = B.size();
    int K = A;
    long long int ans = 0;

    // create a heap containing all elements of B
    priority_queue < int > heap(B.begin(), B.end());
    while (K--) {

        //Get maximum element from the heap 
        long long int max_elem = heap.top();

        // Add the maximum element to the answer
        ans += max_elem;
        ans = ans % mod;
        heap.pop();

        // push the floor(A[i]/2) back to the heap.
        heap.push((int)(max_elem / 2));
    }
    return ans;
}
```

