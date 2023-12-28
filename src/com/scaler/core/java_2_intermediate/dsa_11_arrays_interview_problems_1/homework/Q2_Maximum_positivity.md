### Q2. Maximum positivity
#### Problem Description
```text
Given an array of integers A, of size N.

Return the maximum size subarray of A having only non-negative 
elements. If there are more than one such subarray, return the 
one having the smallest starting index in A.

NOTE: It is guaranteed that an answer always exists.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= N &lt;= 10<sup>5</sup></p>
    <p>-10<sup>9</sup> &lt;= A[i] &lt;= 10<sup>9</sup></p>
</div>

```text
1 <= N <= 10^5

-10^9 <= A[i] <= 10^9
```
#### Input Format
```text
The first and only argument given is the integer array A.
```
#### Output Format
```text
Return maximum size subarray of A having only non-negative 
elements. If there are more than one such subarrays, return 
the one having earliest starting index in A.
```
#### Example Input
```text
Input 1:
 A = [5, 6, -1, 7, 8]

Input 2:
 A = [1, 2, 3, 4, 5, 6]
```
#### Example Output
```text
Output 1:
 [5, 6]

Output 2:
 [1, 2, 3, 4, 5, 6]
```
#### Example Explanation
```text
Explanation 1:
     There are two subarrays of size 2 having only non-negative elements.
     1. [5, 6]  starting point  = 0
     2. [7, 8]  starting point  = 3
     As starting point of 1 is smaller, return [5, 6]

Explanation 2:
     There is only one subarray of size 6 having only non-negative elements:
     [1, 2, 3, 4, 5, 6]
```
### Hints
* Hint 1
```text
If we try to bruteforce this problem we’ll look at all the 
subarrays, but there are some necessary computations that 
are taking place here, can you identify them?
```
* Solution Approach
```text
We can solve this problem using a single while loop:-

For all elements in array :-

1.If ith element is negative, we need to ignore it and go 
on next element

2. If ith element is non-negative, we will start a second while 
   loop from this position until a negative element arrives.
        
        a. If size of subarray received using this is greater than 
           size of previous such arrays, then update the answer
        
        b. else ignore it.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int[] solve(int[] A) {
        int size = 0, left = 0, right = 0;
        for (int l = -1, r = 0; r < A.length; r++) {
            if (A[r] >= 0) {
                if (size < r - l) {
                    size = r - l;
                    left = l;
                    right = r;
                }
            } else {
                l = r;
            }
        }
        int ans[] = new int[size];
        for (int i = left + 1; i <= right; i++) ans[i - left - 1] = A[i];
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
  solve: function (A) {
    let n = A.length;
    let i = 0;
    let max_count = 0,
      st_point = 0;
    while (i < n) {
      if (A[i] >= 0) {
        let temp = 0;
        let tempst = i;
        while (A[i] >= 0 && i < n) {
          i++;
          temp++;
        }
        if (temp > max_count) {
          max_count = temp;
          st_point = tempst;
        }
      } else {
        i++;
      }
    }
    let ans = [];
    for (let j = st_point; j < st_point + max_count; j++) {
      ans.push(A[j]);
    }
    return ans;
  },
};
```
* * Solution in C++
```cpp
vector <int> Solution::solve(vector <int> & A) {
  int n = A.size();
  int i = 0;
  int max_count = 0, st_point = 0;
  while (i < n) {
    if (A[i] >= 0) {
      int temp = 0;
      int tempst = i;
      while (A[i] >= 0 && i < n) {
        i++;
        temp++;
      }
      if (temp > max_count) {
        max_count = temp;
        st_point = tempst;
      }
    } else {
      i++;
    }
  }
  vector < int > ans;
  for (int j = st_point; j < st_point + max_count; j++) {
    ans.push_back(A[j]);
  }
  return ans;
}
```

