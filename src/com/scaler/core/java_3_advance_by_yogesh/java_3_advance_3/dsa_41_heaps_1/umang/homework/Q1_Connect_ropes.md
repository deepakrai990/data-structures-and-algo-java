### Q1. Connect ropes
#### Problem Description
```text
You are given an array A of integers that represent the lengths of ropes.

You need to connect these ropes into one rope. The cost of joining two ropes 
equals the sum of their lengths.

Find and return the minimum cost to connect these ropes into one rope.
```
#### Problem Constraints
```text
1 <= length of the array <= 100000
1 <= A[i] <= 1000
```
#### Input Format
```text
The only argument given is the integer array A.
```
#### Output Format
```text
Return an integer denoting the minimum cost to connect these ropes into one rope.
```
#### Example Input
```text
Input 1:
 A = [1, 2, 3, 4, 5]

Input 2:
 A = [5, 17, 100, 11]
```
#### Example Output
```text
Output 1:
 33

Output 2:
 182
```
#### Example Explanation
```text
Explanation 1:
    Given array A = [1, 2, 3, 4, 5].
    Connect the ropes in the following manner:
    1 + 2 = 3
    3 + 3 = 6
    4 + 5 = 9
    6 + 9 = 15
    
    So, total cost  to connect the ropes into one is 3 + 6 + 9 + 15 = 33.

Explanation 2:
    Given array A = [5, 17, 100, 11].
    Connect the ropes in the following manner:
    5 + 11 = 16
    16 + 17 = 33
    33 + 100 = 133
    
    So, total cost  to connect the ropes into one is 16 + 33 + 133 = 182.
```
### Hints
* Hint 1
<div>
    <p>Suppose you have 3 ropes of Length L<sub>1</sub>, L<sub>2</sub> 
    and L<sub>3</sub>.</p>
    <p>First combine L<sub>1</sub> and L<sub>2</sub> with cost = L
    <sub>1</sub> + L<sub>2</sub>, then combine L<sub>3</sub> with rope of Length L
    <sub>2</sub> + L<sub>1</sub> with cost = L<sub>1</sub> + L<sub>2</sub> + L
    <sub>3</sub>.</p>
    <p>Total cost = L<sub>1</sub> + L<sub>2</sub> + L<sub>1</sub> + L<sub>2</sub> + L
    <sub>3</sub> = 2*(L<sub>1</sub> + L<sub>2</sub>) + L<sub>3</sub>.</p>
    <p>To minimize the total cost, We should combine ropes of minimum Length first 
    to minimize the L<sub>1</sub> + L<sub>2</sub> factor.</p>
</div>

```text
Suppose you have 3 ropes of Length L1, L2 and L3.

First combine L1 and L2 with cost = L1 + L2, then combine L3 with rope of 
Length L2 + L1 with cost = L1 + L2 + L3.

Total cost = L1 + L2 + L1 + L2 + L3 = 2*(L1 + L2) + L3.

To minimize the total cost, We should combine ropes of minimum Length first 
to minimize the L1 + L2 factor.
```
* Solution Approach
```text
As mentioned in the hint, We should combine the ropes of minimum length first to get 
the minimum overall cost.

Let’s try to observe with an example: Suppose we are given four ropes of 
lengths 4, 6, 8, and 10.

1) First connect ropes of lengths 4 and 6. Now, we have three ropes of 
   length 10(4 + 6), 8 and 10.

2) Now connect ropes of lengths 8 and 10. Now, we have two ropes of 
   length 18(8 + 10) and 10(4 + 6).

3) Now connect both the ropes with cost 18(8 + 10) + 10(4 + 6) = 28 (4 + 6 + 8 + 10).

So, total cost is 28 + 10 + 18 = 56. If we try to connect in some other way, 
the cost will >= 56.

Let’s find how many times each given initial length is added to the final cost.

In the first step, combine 4 and 6 and the cost of connecting them is 10 = 4 + 6.
In second step, combine 8 + 10(4 + 6) and cost of connecting them is 18 = 8 + 4 + 6.
In last step, combine 18 + 10 and cost of connecting them is 28 = 8 + 4 + 6 + 10.

So, it is easy to observe that 4 and 6 are added the most number of times,
lengths of the ropes which are picked first are included more than once in the total cost.
So, the idea is to connect the smallest two ropes first and recur for the remaining ropes.

To find the answer, always take the two ropes with the smallest lengths and combine 
these ropes.

Keep on doing this until we have only one rope left. This can easily be done using 
priority_queue.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int[] A) {
        PriorityQueue<Integer> pq = new PriorityQueue();
        int cost = 0;
        // insert all elements in the queue
        for (int x : A) {
            pq.offer(x);
        }
        // keep on removing elements from the queue untill there is one element in the queue
        while (pq.size() != 1) {
            // Take the two ropes with smallest length
            int l1 = pq.poll();
            int l2 = pq.poll();
            // cost of combining these two ropes is l1 + l2.
            cost += l1 + l2;
            // add the newly formed rope of length l1 + l2 to the queue.
            pq.offer(l1 + l2);
        }
        return cost;
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
    //return an integer
    solve: function (A) {
        let pq = new PriorityQueue();

        let cost = 0;

        // insert all elements in the queue
        for (let i = 0; i < A.length; i++) {
            pq.push(A[i]);
        }

        // keep on removing elements from the queue untill there is one element in the queue
        while (pq.size() != 1) {

            // Take the two ropes with smallest length
            let l1 = pq.pop();
            let l2 = pq.pop();

            // cost of combining these two ropes is l1 + l2.
            cost += l1 + l2;

            // add the newly formed rope of length l1 + l2 to the queue.
            pq.push(l1 + l2);
        }

        return cost;
    }
};
```
* * Solution in C++
```cpp
int Solution::solve(vector < int > & A) {

    priority_queue < int, vector < int > , greater < int >> pq;

    int cost = 0;

    // insert all elements in the queue
    for (int x: A) {
        pq.push(x);
    }

    // keep on removing elements from the queue untill there is one element in the queue
    while (pq.size() != 1) {

        // Take the two ropes with smallest length
        int l1 = pq.top();
        pq.pop();
        int l2 = pq.top();
        pq.pop();

        // cost of combining these two ropes is l1 + l2.
        cost += l1 + l2;

        // add the newly formed rope of length l1 + l2 to the queue.
        pq.push(l1 + l2);
    }

    return cost;
}
```

