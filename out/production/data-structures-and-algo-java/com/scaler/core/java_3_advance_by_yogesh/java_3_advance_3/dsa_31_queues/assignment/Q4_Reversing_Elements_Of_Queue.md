### Q4. Reversing Elements Of Queue
#### Problem Description
```text
Given an array of integers A and an integer B, we need to reverse 
the order of the first B elements of the array, leaving the other 
elements in the same relative order.

NOTE: You are required to the first insert elements into an 
auxiliary queue then perform Reversal of first B elements.
```
#### Problem Constraints
```text
1 <= B <= length of the array <= 500000
1 <= A[i] <= 100000
```
#### Input Format
```text
The argument given is the integer array A and an integer B.
```
#### Output Format
```text
Return an array of integer after reversing the first B elements 
of A using queue.
```
#### Example Input
```text
Input 1:
 A = [1, 2, 3, 4, 5]
 B = 3

Input 2:
 A = [5, 17, 100, 11]
 B = 2
```
#### Example Output
```text
Output 1:
 [3, 2, 1, 4, 5]

Output 2:
 [17, 5, 100, 11]
```
#### Example Explanation
```text
Explanation 1:
    Reverse first 3 elements so the array becomes [3, 2, 1, 4, 5]

Explanation 2:
    Reverse first 2 elements so the array becomes [17, 5, 100, 11]
```
### Hints
* Hint 1
```text
This can be easily done by inserting the first B elements in the 
queue and replacing that value in array A such that the 
first B elements of the array are reversed.
```
* Solution Approach
<div style="background-color: #f9f9f9; padding: 5px 10px; ">
    <p>The idea is to use an auxiliary queue.</p>
    <p>1) Create an empty queue.<br>
    2) Append the first B elements in the queue<br>
    3) One by one, dequeue the elements from the queue and update 
    the array at i<sup>th</sup> position. (Initially i = B-1)<br>
    4) Repeat 3 until the queue is empty. Also, decrement i by one 
    at each step.</p>
</div>

```text
The idea is to use an auxiliary queue.

1) Create an empty queue.
2) Append the first B elements in the queue
3) One by one, dequeue the elements from the queue and update the 
   array at i^th position. (Initially i = B-1)
4) Repeat 3 until the queue is empty. Also, decrement i by one at each step.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int[] solve(int[] A, int B) {
        Deque<Integer> q = new ArrayDeque<Integer>(A.length);
        int i = 0;
        // Insert first B elements in queue
        for (i = 0; i < B; i++)
            q.addLast(A[i]);
        // Reverse the first B elements in the array A
        while (q.size() > 0) {
            i--;
            A[i] = q.getFirst();
            q.removeFirst();
        }
        return A;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = { 
 //param A : array of integers
 //param B : integer
 //return a array of integers
	solve : function(A, B){
        q = [];
        let i;
        // Insert first B elements in queue
        for (i = 0; i < B; i++)
            q.push(A[i]);
        // Reverse the first B elements in the array A
        while (q.length > 0) {
            i--;
            A[i] = q.shift();
        }
        return A;
	}
};
```
* * Solution in C++
```cpp
vector < int > Solution::solve(vector < int > & A, int B) {
    queue < int > q;
    int i;
    // Insert first B elements in queue
    for (i = 0; i < B; i++)
        q.push(A[i]);
    // Reverse the first B elements in the array A
    while (!q.empty()) {
        i--;
        A[i] = q.front();
        q.pop();
    }
    return A;
}
```

