### Q8. Misha and Candies
#### Problem Description
```text
Misha loves eating candies. She has been given N boxes of Candies.

She decides that every time she will choose a box having the minimum 
number of candies, eat half of the candies and put the remaining candies 
in the other box that has the minimum number of candies.

Misha does not like a box if it has the number of candies greater than B so 
she won't eat from that box. Can you find how many candies she will eat?

NOTE 1: If a box has an odd number of candies then Misha will eat the floor(odd / 2).

NOTE 2: The same box will not be chosen again.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p> 1 &lt;= N &lt;= 10<sup>5</sup></p>
    <p> 1 &lt;= A[i] &lt;= 10<sup>5</sup></p>
    <p> 1 &lt;= B &lt;= 10<sup>6</sup></p>
</div>

```text
1 <= N <= 10^5

1 <= A[i] <= 10^5

1 <= B <= 10^6
```
#### Input Format
```text
The first argument is A an Array of Integers, where A[i] is the number of candies 
in the ith box.

The second argument is B, the maximum number of candies Misha like in a box.
```
#### Output Format
```text
Return an integer denoting the number of candies Misha will eat.
```
#### Example Input
```text
Input 1:
 A = [3, 2, 3]
 B = 4

Input 2:
 A = [1, 2, 1]
 B = 2
```
#### Example Output
```text
Output 1:
 2

Output 2:
 1
```
#### Example Explanation
```text
Explanation 1:
    1st time Misha will eat from 2nd box, i.e 1 candy she'll eat and will put 
    the remaining 1 candy in the 1st box.
    
    2nd time she will eat from the 3rd box, i.e 1 candy she'll eat and will put 
    the remaining 2 candies in the 1st box.
    
    She will not eat from the 3rd box as now it has candies greater than B.
    
    So the number of candies Misha eat is 2.

Explanation 2:

    1st time Misha will eat from 1st box, i.e she can't eat any and will put the 
    remaining 1 candy in the 3rd box.
    
    2nd time she will eat from the 3rd box, i.e 1 candy she'll eat and will put 
    the remaining 1 candies in the 2nd box.
    
    She will not eat from the 2nd box as now it has candies greater than B.
    
    So the number of candies Misha eat is 1.
```
### Hints
* Hint 1
```text
The main task is to optimally get the box with the least number of candies each time.

Think how you can get a box having the minimum number of candies in O(log(n))?
```
* Solution Approach
```text
The main task is to optimally get the box with the least number of candies each time.
Think how you can get a box having the minimum number of candies in O(log(n))?

You can use a priority queue or min-heap to get a box having the minimum number 
of candies in O(log(n)).
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int[] A, int B) {
        int candies_ate = 0;
        // create a priority_queue to get box with minimum candies in O(1);
        PriorityQueue < Integer > pq = new PriorityQueue();
        // put all elements in priority queue
        for (int i: A)
            pq.offer(i);
        int k = B;
        while (pq.size() > 0) {
            int curr_box = pq.poll(); // take out box with minimum candies
            if (curr_box > k) 
                break;
            candies_ate += (curr_box / 2); // eat half of the candies
            if (pq.size() == 0)
                break;
            int next_box = pq.poll() + (int) Math.ceil(curr_box / 2.0); // push remaining half candies into next box
            if (next_box <= k)
                pq.offer(next_box);
        }
        // return candies she can eat.
        return candies_ate;
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
    constructor(comparator = (a, b) => a < b) {
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
    //param B : integer
    //return an integer
    solve: function (A, k) {
        const pq = new PriorityQueue();
        let candies_ate = 0;
        // put all elements in priority queue
        for (let i = 0; i < A.length; i++)
            pq.push(A[i]);
        while (!pq.isEmpty()) {
            let curr_box = pq.pop(); // take out box with minimum candies
            if (curr_box > k)
                break;
            candies_ate += Math.floor(curr_box / 2); // eat half of the candies
            if (pq.isEmpty())
                break;
            let next_box = pq.pop() + Math.ceil(curr_box / 2); // push remaining half candies into next box
            if (next_box <= k)
                pq.push(next_box);
        }
        // return candies she can eat.
        return candies_ate;
    }
};
```
* * Solution in C++
```cpp
int Solution::solve(vector < int > & A, int k) {

    int candies_ate = 0;
    // create a priority_queue to get box with minimum candies in O(1);
    priority_queue < int, vector < int > , greater < int > > pq;
    // put all elements in priority queue
    for (auto & i: A)
        pq.push(i);

    while (pq.empty() == false) {
        int curr_box = pq.top(); // take out box with minimum candies
        pq.pop();
        if (curr_box > k)
            break;
        candies_ate += (curr_box / 2); // eat half of the candies
        if (pq.empty())
            break;
        int next_box = pq.top() + ceil(curr_box / 2.0); // push remaining half candies into next box
        pq.pop();
        if (next_box <= k)
            pq.push(next_box);
    }
    // return candies she can eat.
    return candies_ate;
}
```

