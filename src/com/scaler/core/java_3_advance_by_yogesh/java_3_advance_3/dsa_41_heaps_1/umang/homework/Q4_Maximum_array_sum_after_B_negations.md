### Q4. Maximum array sum after B negations
#### Problem Description
```text
Given an array of integers A and an integer B. You must modify the array 
exactly B number of times. In a single modification, we can replace any 
one array element A[i] by -A[i].

You need to perform these modifications in such a way that after 
exactly B modifications, sum of the array must be maximum.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= length of the array &lt;= 5*10<sup>5</sup><br>
    1 &lt;= B &lt;= 5 * 10<sup>6</sup><br>
    -100 &lt;= A[i] &lt;= 100</p>
</div>

```text
1 <= length of the array <= 5*10^5
1 <= B <= 5 * 10^6
-100 <= A[i] <= 100
```
#### Input Format
```text
The first argument given is an integer array A.
The second argument given is an integer B.
```
#### Output Format
```text
Return an integer denoting the maximum array sum after B modifications.
```
#### Example Input
```text
Input 1:
 A = [24, -68, -29, -9, 84]
 B = 4

Input 2:
 A = [57, 3, -14, -87, 42, 38, 31, -7, -28, -61]
 B = 10
```
#### Example Output
```text
Output 1:
 196

Output 2:
 362
```
#### Example Explanation
```text
Explanation 1:
    Final array after B modifications = [24, 68, 29, -9, 84]

Explanation 2:
    Final array after B modifications = [57, -3, 14, 87, 42, 38, 31, 7, 28, 61]
```
### Hints
* Hint 1
```text
If you have only one modification to perform, then changing which element will 
give us the maximum answer.
```
* Solution Approach
```text
This problem can simply be solved by just changing the minimum element A[i] to -A[i].

Keep on getting the minimum element from the array and multiply that element by -1. 
Do this exactly B times.

It is easy to observe that if the minimum element is zero, we can’t increase our 
answer by any modification.

If the minimum element is x < 0, then just change it to -x.

If the minimum element is x > 0 and the number of operations left is even. You do 
not need to change anything.

If the minimum element is x > 0 and the number of operations left is odd. We can 
directly change the number of operations left to 0 and set x to -x.

Now, just find the sum of all the elements.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int[] A, int B) {
        PriorityQueue<Integer> pq = new PriorityQueue();
        // insert all elements into the queue
        for (int x : A) pq.offer(x);
        // perform B modifications
        while (B > 0) {
            // pop minimum element from the queue
            int x = pq.poll();
            // if minimum element is 0, we will use all remaining operations on this and the result will be same      
            if (x == 0) {
                B = 0;
            }
            // if minimum element is negative, modify the element to -x and push -x to queue.
            else if (x < 0) {
                pq.offer(-x);
            } else {
                //if remaining operations are even, then in one operation we convert x to -x and in another -x to x. So, no change
                //if operations are odd, we will change the number to -x. Set B = 0.
                if (B % 2 == 0) {
                    pq.offer(x);
                } else {
                    pq.offer(-x);
                }
                B = 0;
                break;
            }
            B--;
        }
        int ans = 0;
        // add all the elements in the queue to the answer
        while (pq.size() > 0) {
            ans += pq.poll();
        }
        return ans;
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
    solve: function (A, B) {
        let pq = new PriorityQueue();
        // insert all elements into the queue
        for (let i = 0; i < A.length; i++) {
            pq.push(A[i]);
        }
        // perform B modifications
        while (B > 0) {
            // pop minimum lement from the queue
            let x = pq.pop();
            // if minimum element is 0, we will use all remaining opeations on this and the result will be same      
            if (x == 0) {
                B = 0;
            }
            // if minimum element is negative, modify the element to -x and push -x to queue.
            else if (x < 0) {
                pq.push(-x);
            } else {
                //if remaining operations are even, then in one operation we convert x to -x and in another -x to x. So, no change
                //if operations are odd, we will change the number to -x. Set B = 0.
                if (B % 2 == 0) {
                    pq.push(x);
                } else {
                    pq.push(-x);
                }
                B = 0;
                break;
            }
            B--;
        }
        let ans = 0;
        // add all the elements in the queue to the answer
        while (!pq.isEmpty()) {
            ans += pq.pop();
        }
        return ans;
    }
};
```
* * Solution in C++
```cpp
int Solution::solve(vector < int > & A, int B) {

    priority_queue < int, vector < int > , greater < int >> pq;

    // insert all elements into the queue
    for (int x: A) pq.push(x);

    // perform B modifications

    while (B > 0) {
        // pop minimum lement from the queue
        int x = pq.top();
        pq.pop();

        // if minimum element is 0, we will use all remaining opeations on this and the result will be same      
        if (x == 0) {
            B = 0;
        }
        // if minimum element is negative, modify the element to -x and push -x to queue.
        else if (x < 0) {
            pq.push(-x);
        } else {
            //if remaining operations are even, then in one operation we convert x to -x and in another -x to x. So, no change
            //if operations are odd, we will change the number to -x. Set B = 0.
            if (B % 2 == 0) {
                pq.push(x);
            } else {
                pq.push(-x);
            }

            B = 0;
            break;
        }

        B--;
    }

    int ans = 0;

    // add all the elements in the queue to the answer
    while (!pq.empty()) {
        ans += pq.top();
        pq.pop();
    }

    return ans;
}
```

