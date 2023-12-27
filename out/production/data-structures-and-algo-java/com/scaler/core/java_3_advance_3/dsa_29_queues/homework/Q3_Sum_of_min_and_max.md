### Q3. Sum of min and max
#### Problem Description
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>Given an array <strong>A</strong> of both positive and
    negative integers.</p>
    <p>Your task is to compute the sum of <strong>minimum</strong> 
    and <strong>maximum</strong> elements of all sub-array of 
    size <strong>B</strong>.</p>
    <p><strong>NOTE:</strong> Since the answer can be very large, 
    you are required to return the sum modulo 10<sup>9</sup> + 7.</p>
</div>

```text
Given an array A of both positive and negative integers.

Your task is to compute the sum of minimum and maximum elements 
of all sub-array of size B.

NOTE: Since the answer can be very large, you are required to 
return the sum modulo 10^9 + 7.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= size of array A &lt;= 10<sup>5</sup></p>
    <p>-10<sup>9</sup> &lt;= A[i] &lt;= 10<sup>9</sup></p>
    <p>1 &lt;= B &lt;= size of array</p>
</div>

```text
1 <= size of array A <= 10^5

-10^9 <= A[i] <= 10^9

1 <= B <= size of array
```
#### Input Format
```text
The first argument denotes the integer array A.
The second argument denotes the value B
```
#### Output Format
```text
Return an integer that denotes the required value.
```
#### Example Input
```text
Input 1:
 A = [2, 5, -1, 7, -3, -1, -2]
 B = 4

Input 2:
 A = [2, -1, 3]
 B = 2
```
#### Example Output
```text
Output 1:
 18

Output 2:
 3
```
#### Example Explanation
```text
Explanation 1:
    Subarrays of size 4 are : 
    [2, 5, -1, 7],   min + max = -1 + 7 = 6
    [5, -1, 7, -3],  min + max = -3 + 7 = 4      
    [-1, 7, -3, -1], min + max = -3 + 7 = 4
    [7, -3, -1, -2], min + max = -3 + 7 = 4   
    Sum of all min & max = 6 + 4 + 4 + 4 = 18 

Explanation 2:
    Subarrays of size 2 are : 
    [2, -1],   min + max = -1 + 2 = 1
    [-1, 3],   min + max = -1 + 3 = 2
    Sum of all min & max = 1 + 2 = 3 
```
### Hints
* Hint 1
```text
Can we find the maximum and minimum element for each subarray 
in constant time?

Think of using a Double-ended Queue.
```
* Solution Approach
```text
We will use Deque(Double-Ended Queue) and the concept of the sliding window.

We create two empty double-ended queues of size B (‘S’ , ‘G’) that 
only store indexes of elements of the current window that are not useless.

An element is useless if it can not be the maximum or minimum of 
the next subarrays.

-> In deque ‘G’, we maintain decreasing order of values from front to rear.

-> In deque ‘S’, we maintain increasing order of values from front to rear.

Maintain both Dequeue such that the front element gives maximum and 
minimum element respectively for each window.

Add that element to the sum variable.

Return the sum % 10 ^ 9 + 7.

Note that the sum % 10 ^ 9 + 7 will be in the range (0, 10 ^ 9 + 6).
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int[] A, int B) {
        int mod = 1000 * 1000 * 1000 + 7;
        // maintain increasing order of values from front to rear
        Deque<Integer> minn = new ArrayDeque<Integer>();
        // maintain decreasing order of values from front to rear
        Deque<Integer> maxx = new ArrayDeque<Integer>();
        int i = 0;

        // Process first window of size B
        for (; i < B; i++) {
            // Remove all previous greater elements that are useless.
            while (minn.size() > 0 && A[minn.getLast()] >= A[i]) {
                minn.removeLast();
            }
            // Remove all previous smaller that are elements are useless.
            while (maxx.size() > 0 && A[maxx.getLast()] <= A[i]) {
                maxx.removeLast();
            }
            // Add current element at rear of both deque
            minn.addLast(i);
            maxx.addLast(i);
        }
        long sum = A[minn.getFirst()] + A[maxx.getFirst()];

        while (i < A.length) {
            // remove all previous greater element that are useless
            while (minn.size() > 0 && A[minn.getLast()] >= A[i]) {
                minn.removeLast();
            }
            // remove all previous smaller that are elements are useless
            while (maxx.size() > 0 && A[maxx.getLast()] <= A[i]) {
                maxx.removeLast();
            }
            // Add current element at rear of both deque
            minn.addLast(i);
            maxx.addLast(i);
            // Remove all elements which are out of this window
            while (i - minn.getFirst() >= B) {
                minn.removeFirst();
            }
            while (i - maxx.getFirst() >= B) {
                maxx.removeFirst();
            }
            // Element at the front of the deque are the largest and smallest  element of previous window respectively
            sum += A[maxx.getFirst()] + A[minn.getFirst()];
            sum %= mod;
            i++;
        }
        sum += mod;
        sum %= mod;
        return (int) sum;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : array of integers
    //param B : integer
    //return an integer
    solve: function (A, B) {
        let mod = 1000 * 1000 * 1000 + 7;
        minn = [];
        maxx = [];
        let i = 0;
        for (; i < B; i++) {
            while (minn.length > 0 && A[minn[minn.length - 1]] >= A[i]) {
                minn.pop();
            }
            minn.push(i);
            while (maxx.length > 0 && A[maxx[maxx.length - 1]] <= A[i]) {
                maxx.pop();
            }
            maxx.push(i);
        }
        let sum = A[minn[0]] + A[maxx[0]];
        while (i < A.length) {
            while (minn.length > 0 && A[minn[minn.length - 1]] >= A[i]) {
                minn.pop();
            }
            minn.push(i);
            while (i - minn[0] >= B) {
                minn.shift();
            }
            while (maxx.length > 0 && A[maxx[maxx.length - 1]] <= A[i]) {
                maxx.pop();
            }
            maxx.push(i);
            while (i - maxx[0] >= B) {
                maxx.shift();
            }
            sum += A[maxx[0]] + A[minn[0]];
            sum %= mod;
            i++;
        }
        sum += mod;
        sum %= mod;
        return sum;
    }
};
```
* * Solution in C++
```cpp
void createDequeue(deque<int> & S, deque<int> & G, vector < int > & A, int B){
    // Process first window of size B
    int i = 0;
    for (i = 0; i < B; i++) {
        // Remove all previous greater elements that are useless.
        while ((!S.empty()) && A[S.back()] >= A[i])
            S.pop_back(); // Remove from rear
        // Remove all previous smaller that are elements are useless.
        while ((!G.empty()) && A[G.back()] <= A[i])
            G.pop_back(); // Remove from rear
        // Add current element at rear of both deque
        G.push_back(i);
        S.push_back(i);
    }
}

int Solution::solve(vector < int > & A, int B) {
    int mod = 1e9 + 7;
    long long sum = 0; // Initialize result
    int n = A.size();
    
    // The queue will store indexes of useful elements in every window
    // In deque 'G' we maintain decreasing order of values from front to rear
    // In deque 'S' we  maintain increasing order of values from front to rear
    deque < int > S(B), G(B);
    createDequeue(S, G, A, B);
    
    // Process rest of the Array elements
    for (int i = B; i < n; i++) {
        // Element at the front of the deque 'G' & 'S'  is the largest and smallest  element of previous window respectively
        sum += A[S.front()] + A[G.front()];
        
        // Remove all elements which are out of this window
        while (!S.empty() && S.front() <= i - B)
            S.pop_front();
        while (!G.empty() && G.front() <= i - B)
            G.pop_front();
        
        // remove all previous greater element that are useless
        while ((!S.empty()) && A[S.back()] >= A[i])
            S.pop_back(); // Remove from rear
        
        // remove all previous smaller that are elements are useless
        while ((!G.empty()) && A[G.back()] <= A[i])
            G.pop_back(); // Remove from rear
        
        // Add current element at rear of both deque
        G.push_back(i);
        S.push_back(i);
    }
    
    // Sum of minimum and maximum element of last window
    sum += A[S.front()] + A[G.front()];
    while (sum < 0)
        sum += mod;
    sum = sum % mod;
    return sum;
}
```

