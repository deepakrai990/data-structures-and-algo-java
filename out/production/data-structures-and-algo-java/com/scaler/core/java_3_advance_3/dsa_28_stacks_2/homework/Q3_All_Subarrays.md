### Q3. All Subarrays
#### Problem Description
```text
Given an integer array A of size N. You have to generate it's all subarrays 
having a size greater than 1.

Then for each subarray, find Bitwise XOR of its maximum and second maximum element.

Find and return the maximum value of XOR among all subarrays.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>2 &lt;= N &lt;= 10<sup>5</sup></p>
    <p>1 &lt;= A[i] &lt;= 10<sup>7</sup></p>
</div>

```text
2 <= N <= 10^5

1 <= A[i] <= 10^7
```
#### Input Format
```text
The only argument is an integer array A.
```
#### Output Format
```text
Return an integer, i.e., the maximum value of XOR of maximum and 
2nd maximum element among all subarrays.
```
#### Example Input
```text
Input 1:

 A = [2, 3, 1, 4]
Input 2:

 A = [1, 3]
```
#### Example Output
```text
Output 1:
 7

Output 2:
 2
```
#### Example Explanation
```text
Explanation 1:
    All subarrays of A having size greater than 1 are:
    Subarray            XOR of maximum and 2nd maximum no.
    1. [2, 3]           1
    2. [2, 3, 1]        1
    3. [2, 3, 1, 4]     7
    4. [3, 1]           2
    5. [3, 1, 4]        7
    6. [1, 4]           5
    So maximum value of Xor among all subarrays is 7.

Explanation 2:
    Only subarray is [1, 3] and XOR of maximum and 2nd maximum is 2.
```
### Hints
* Hint 1
```text
The subarray can only be reflected on its maximum element and second maximum element, 
so apparently, there must be a lot of meaningless subarrays which we need not check 
them at all.

Can we use a stack to maintain the maximum and 2nd maximum of all subarrays?
```
* Solution Approach
```text
The subarray can only be reflected on its maximum element and second maximum element, 
so apparently, there must be a lot of meaningless subarrays which we need not 
check them at all. But how can we skip them?

Maintain a monotone-decreasing-stack can help us.

While a new element came into the view, pop the top element in the stack, and check 
the corresponding interval, until the new element is greater than the top element 
in the stack. We can easily see it is correct since we won’t lost the answer as long as 
it exists.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int[] A) {
        int ans = 0;
        int n = A.length;
        // create a stack to store the maximum value of all subarrays
        Stack<Integer> s = new Stack<Integer>();
        for (int i = 0; i < n; i++) {
            // while stack is not empty take xor of its top and current element
            while (!s.empty()) {
                // store the maximum value of xor
                int topElement = s.peek();
                ans = Math.max(ans, (A[topElement] ^ A[i]));
                // if top of the stack is greater than current element than break the loop
                if (A[topElement] > A[i]) break;
                else s.pop(); //pop out the top of the stack
            }
            // push the current element into the stack
            s.push(i);
        }
        // return the answer
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
  //param A : array of integers
  //return an integer
    solve: function (A) {
        let ans = 0,
            n = A.length;
        // create a stack to store the maximum value of all subarrays
        let s = [];
        for (let i = 0; i < n; i += 1) {
            // while stack is not emepty take xor of its top and current element
            while (s.length) {
                // store the maximum value of xor
                ans = Math.max(ans, A[s[s.length - 1]] ^ A[i]);
                // if top of the stack is greater than current element than break the loop
                if (A[s[s.length - 1]] > A[i]) break;
                // else pop out the top of the stack
                s.pop();
            }
            // push the current element into the stack
            s.push(i);
        }
        // return the answer
        return ans;
    },
};
```
* * Solution in C++
```cpp
int Solution::solve(vector < int > & A) {
    int ans = 0, n = A.size();
    // create a stack to store the maximum value of all subarrays
    stack < int > s;

    for (int i = 0; i < n; i += 1) {
        // while stack is not empty take xor of its top and current element
        while (!s.empty()) {
            // strore the maximum value of xor
            ans = max(ans, (A[s.top()] ^ A[i]));
            // if top of the stack is greater than current element than break the loop
            if (A[s.top()] > A[i]) break;
            // else pop out the top of the stack
            s.pop();
        }
        // push the current element into the stack
        s.push(i);
    }
    // return the answer
    return ans;
}
```

