### Q1. Task Scheduling
#### Problem Description
```text
A CPU has N tasks to be performed. It is to be noted that the 
tasks have to be completed in a specific order to avoid deadlock. 
In every clock cycle, the CPU can either perform a task or move it 
to the back of the queue. You are given the current state of the 
scheduler queue in array A and the required order of the 
tasks in array B.

Determine the minimum number of clock cycles to complete all the tasks.
```
#### Problem Constraints
```text
1 <= N <= 1000
1 <= A[i], B[i] <= N
```
#### Input Format
```text
First argument consist of integer array A.
Second argument consist of integer array B.
```
#### Output Format
```text
Return an integer denoting the minimum number of clock cycles 
required to complete all the tasks.
```
#### Example Input
```text
Input 1:
 A = [2, 3, 1, 5, 4]
 B = [1, 3, 5, 4, 2]

Input 2:
 A = [1]
 B = [1]
```
#### Example Output
```text
Output 1:
 10

Output 2:
 1
```
#### Example Explanation
```text
Explanation 1:
    According to the order array B task 1 has to be performed 
    first, so the CPU will move tasks 2 and 3 to the end of 
    the queue (in 2 clock cycles).
    
    Total clock cycles till now = 2
    
    Now CPU will perform task 1.
    
    Total clock cycles till now = 3
    
    Now, queue becomes [5, 4, 2, 3]
    
    Now, CPU has to perform task 3. So it moves tasks 5, 4, and 2 to 
    the back one-by-one.
    
    Total clock cycles till now = 6
    Now all the tasks in the queue are as in the required order so the CPU will perform them one-by-one.
    Total clock cycles = 10

Explanation 2:
    Directly task 1 is completed.
```
### Hints
* Hint 1
```text
The problem is easy if you think of a perfect data structure.
The problem can be easily solved using a double-ended queue and 
maintaining the number of moves.
```
* Solution Approach
```text
The problem is easy if you think of a perfect data structure. 

The problem can be easily solved using a double-ended queue and 
maintaining the number of moves.

For each index, you have to find that person in the double-ended 
queue and increase the move in the ideal order.

Finally, return the moves.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int[] A, int[] B) {
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < A.length; i++) {
            q.add(A[i]);
        }
        int ans = 0;
        for (int i = 0; i < B.length; i++) {
            // move the task to the back of the queue if it is not equal to B[i]
            while (B[i] != q.peek()) {
                ans++;
                q.add(q.poll());
            }
            q.remove();
            ans++;
        }
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : array of integers
    //param B : array of integers
    //return an integer
    solve: function (A, B) {
        let q = [];
        let ans = 0;
        let n = A.length;
        for (let i = 0; i < n; i++) {
            q.push(A[i]);
        }
        for (let i = 0; i < n; i++) {
            // move the task to the back of the queue if it is not equal to B[i]
            while (B[i] != q[0]) {
                let temp = q[0];
                q.shift();
                ans++;
                q.push(temp);
            }
            ans++;
            q.shift();
        }
        return ans;
    }
};
```
* * Solution in C++
```cpp
int Solution::solve(vector < int > & A, vector < int > & B) {
    int n = A.size();
    int ans = 0;
    deque < int > q;
    for (int i = 0; i < n; i++) {
        q.push_back(A[i]);
    }
    for (int i = 0; i < n; i++) {
        // move the task to the back of the queue if it is not equal to B[i]
        while (B[i] != q.front()) {
            int temp = q.front();
            q.pop_front();
            ans++;
            q.push_back(temp);
        }
        ans++;
        q.pop_front();
    }
    return ans;
}
```

