### Q2. The ship company
#### Problem Description
```text
The local ship renting service has a special rate plan:

    * It is up to a passenger to choose a ship.
    * If the chosen ship has X (X > 0) vacant places at the given moment, then the 
      ticket for such a ship costs X.

The passengers buy tickets in turn, the first person in the queue goes first, then 
the second one, and so on up to A-th person.

You need to tell the maximum and the minimum money that the ship company can earn 
if all A passengers buy tickets.
```
#### Problem Constraints
```text
1 ≤ A ≤ 3000
1 ≤ B ≤ 1000
1 ≤ C[i] ≤ 1000
It is guaranteed that there are at least A empty seats in total.
```
#### Input Format
```text
First argument is a integer A denoting the number of passengers in the queue.

Second argument is a integer B denoting the number of ships.

Third argument is an integer array C of size B where C[i] denotes the number of 
empty seats in the i-th ship before the ticket office starts selling tickets.
```
#### Output Format
```text
Return an array of size 2 denoting the maximum and minimum money that the ship 
company can earn.
```
#### Example Input
```text
Input 1:
 A = 4
 B = 3
 C = [2, 1, 1]

Input 2:
 A = 4
 B = 3
 C = [2, 2, 2]
```
#### Example Output
```text
Output 1:
 [5, 5]

Output 2:
 [7, 6]
```
#### Example Explanation
```text
Explanation 1:
    Maximum money can be earned if the passenger 
    choose : 2(first ship) + 1(first ship) + 1(second ship) + 1(third ship).
    
    So, the cost will be 5.
    
    Minimum money can be earned if the passenger 
    choose : 1(second ship) + 2(first ship) + 1(first ship) + 1(third ship).
    
    So, the cost will be 5.

Explanation 2:
    Maximum money can be earned if the passenger 
    choose : 2(first ship) + 2(second ship) + 2(third ship) + 1(first ship).
    
    So, the cost will be 7.
    
    Minimum money can be earned if the passenger 
    choose : 2(second ship) + 2(first ship) + 1(first ship) + 1(second ship).
    
    So, the cost will be 6.
```
### Hints
* Hint 1
```text
Think greedy when will the cost of tickets is maximum and minimum.
```
* Solution Approach
```text
Make two priority queues, one for taking maximum cost tickets till now and the other 
for the minimum.

Now for A passengers, pop these two queues separately and take the sum of maximum 
and minimum answers.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int[] solve(int A, int B, int[] C) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue(new CustomComp());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int a : C) {
            maxHeap.offer(a);
            minHeap.offer(a);
        }
        int[] res = new int[2];
        int maxe = 0;
        int mine = 0;
        int i = 0;
        while (maxHeap.size() > 0 && i < A) {
            i++;
            int val = maxHeap.poll();

            if (val > 1) {
                maxHeap.offer(val - 1);
            }
            maxe += val;
        }
        i = 0;
        while (minHeap.size() > 0 && i < A) {
            i++;
            int val = minHeap.poll();

            if (val > 1) {
                minHeap.offer(val - 1);
            }
            mine += val;
        }
        res[0] = maxe;
        res[1] = mine;
        return res;
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
module.exports = {
    solve: function (A, B, C) {
        let minheap = new PriorityQueue(1),
            maxheap = new PriorityQueue(-1);

        for (let i = 0; i < C.length; i++) {
            maxheap.push(C[i]);
            minheap.push(C[i]);
        }
        let max_ans = 0,
            min_ans = 0;
        let i = 0;

        while (!maxheap.empty() && i < A) {
            i++;
            let val = maxheap.pop();
            if (val > 1) {
                maxheap.push(val - 1);
            }
            max_ans += val;
        }

        i = 0;

        while (!minheap.empty() && i < A) {
            i++;
            let val = minheap.pop();

            if (val > 1) {
                minheap.push(val - 1);
            }
            min_ans += val;
        }

        let ans = [];

        ans.push(max_ans);
        ans.push(min_ans);

        return ans;
    },
};

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
```
* * Solution in C++
```cpp
vector < int > Solution::solve(int A, int B, vector < int > & C) {
  priority_queue < int > minheap, maxheap; // make 2 priority queues for minimum pop and maximum pop

  for (int i = 0; i < C.size(); i++) {
    maxheap.push(C[i]);
    minheap.push(-C[i]);
  }
  // Store maximum and minimum answer
  int max_ans = 0, min_ans = 0;

  int i = 0;

  while (!maxheap.empty() && i < A) {
    i++;
    int val = maxheap.top(); // take the maximum till now 

    maxheap.pop();

    if (val > 1) {
      maxheap.push(val - 1); // decrement the available vacancy for passenger by 1 and again push it into priority queue
    }
    max_ans += val;

  }

  i = 0;

  while (!minheap.empty() && i < A) {
    i++;
    int val = -minheap.top(); // take the minimum till now 
    minheap.pop();

    if (val > 1) {
      minheap.push(-val + 1); // decrement the available vacancy for passenger by 1 and again push it into priority queue
    }
    min_ans += val;
  }

  vector < int > ans;

  ans.push_back(max_ans);
  ans.push_back(min_ans);

  return ans;
}
```

