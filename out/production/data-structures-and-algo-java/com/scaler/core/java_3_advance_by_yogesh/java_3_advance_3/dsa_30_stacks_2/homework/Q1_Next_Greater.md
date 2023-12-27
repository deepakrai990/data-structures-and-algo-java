### Q1. Next Greater
#### Problem Description
```text
Given an array A, find the next greater element G[i] for every 
element A[i] in the array.

The next greater element for an element A[i] is the first greater 
element on the right side of A[i] in the array, A.

More formally:

G[i] for an element A[i] = an element A[j] such that 
    j is minimum possible AND 
    j > i AND
    A[j] > A[i]
    
Elements for which no greater element exists, consider the 
next greater element as -1.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= |A| &lt;= 10<sup>5</sup></p>
    <p>1 &lt;= A[i] &lt;= 10<sup>7</sup></p>
</div>

```text
1 <= |A| <= 10^5

1 <= A[i] <= 10^7
```
#### Input Format
```text
The first and the only argument of input contains the integer array, A.
```
#### Output Format
```text
Return an integer array representing the next greater element for 
each index in A.
```
#### Example Input
```text
Input 1:
 A = [4, 5, 2, 10] 

Input 2:
 A = [3, 2, 1] 
```
#### Example Output
```text
Output 1:
 [5, 10, 10, -1] 

Output 2:
 [-1, -1, -1] 
```
#### Example Explanation
```text
Explanation 1:
    For 4, the next greater element towards its right is 5.
    For 5 and 2, the next greater element towards their right is 10.
    For 10, there is no next greater element towards its right.

Explanation 2:
    As the array is in descending order, there is no next greater 
    element for all the elements. 
```
### Hints
* Hint 1
```text
/** Not available **/
```
* Solution Approach
```text
We can use a stack to find the next greater element.

    * Push the first element in the stack.
    * Pick rest of the elements one by one and follow the 
      following steps in loop
        
        1. Mark the current element as next.
        2. If stack is not empty, compare top element of stack with next.
        3. If next is greater than the top element, Pop element from 
           stack. Next is the next greater element for the popped element.
        4. Keep popping from the stack while the popped element is 
           smaller than next. Next becomes the next greater element 
           for all such popped elements.
    
    * Finally, push the next in the stack.
    * After the loop in step 2 is over, pop all the elements from 
      stack and print -1 as next element for them.

Time Complexity:- O(N)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int[] nextGreater(int[] A) {
        Stack<Integer> s = new Stack<>();
        s.push(0);
        int n = A.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int i = 1; i < n; i++) {
            if (s.isEmpty()) {
                s.push(i);
                continue;
            }
            // find the elements whose next greater element is A[i]
            while (!s.isEmpty() && A[s.peek()] < A[i]) {
                ans[s.peek()] = A[i];
                s.pop();
            }
            s.push(i);
        }
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    nextGreater: function (A) {
        let s = [];
        s.push(0);
        let n = A.length;
        let ans = new Array(n).fill(-1);
        for (let i = 1; i < n; i++) {
            if (!s.length) {
                s.push(i);
                continue;
            }
            // find the elements whose next greater element is A[i]
            while (s.length && A[s[s.length - 1]] < A[i]) {
                ans[s[s.length - 1]] = A[i];
                s.pop();
            }
            s.push(i);
        }
        return ans;
    },
};
```
* * Solution in C++
```cpp
vector < int > Solution::nextGreater(vector < int > & A) {
    stack < int > s;
    s.push(0);
    int n = A.size();
    vector < int > ans(n, -1);
    for (int i = 1; i < n; i++) {
        if (s.empty()) {
            s.push(i);
            continue;
        }
        // find the elements whose next greater element is A[i]
        while (s.empty() == false && A[s.top()] < A[i]) {
            ans[s.top()] = A[i];
            s.pop();
        }
        s.push(i);
    }
    return ans;
}
```

