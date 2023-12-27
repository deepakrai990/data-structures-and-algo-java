### Q4. Maximum height of staircase
#### Problem Description
```text
Given an integer A representing the number of square 
blocks. The height of each square block is 1. The task is 
to create a staircase of max-height using these blocks.

The first stair would require only one block, and the 
second stair would require two blocks, and so on.

Find and return the maximum height of the staircase.
```
#### Problem Constraints
* <div style="background-color: #f9f9f9; padding: 5px 10px; ">
  <p>0 &lt;= A &lt;= 10<sup>9</sup></p>
  </div>
```text
0 <= A <= 10^9
```
#### Input Format
```text
The only argument given is integer A.
```
#### Output Format
```text
Return the maximum height of the staircase using these blocks.
```
#### Example Input
```text
Input 1:
 A = 10

Input 2:
 A = 20
```
#### Example Output
```text
Output 1:
 4

Output 2:
 5
```
#### Example Explanation
```text
Explanation 1:
 The stairs formed will have height 1, 2, 3, 4.

Explanation 2:
 The stairs formed will have height 1, 2, 3, 4, 5.
```
### Hints
* Hint 1
```text
How many square blocks are needed to create a staircase of height n?
```
* Solution Approach
```text
Sum of natural numbers upto n is given by (n(n+1))/2

So you have to find the largest n such that (n(n+1))/2 is 
less or equal to A.

Why?

As you have to find the maximum height so, suppose the 
maximum height is n, then there must be stairs with 
height n,n-1,n-2…..1 also we have a total of A stairs so 
summation of the height of stairs must be less than 
or equal to A.

So doing a binary search for n is the best approach for the problem.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int A) {
        int low = 0, high = 1000*1000*1000, ans = 0;
        while(low <= high){
            int mid = (high - low) / 2 + low;
            if((long)mid * (mid + 1) / 2 > A)
                high = mid - 1;   
            else{
                ans = mid;
                low = mid + 1;
            }
        }
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
  solve: function (A) {
    let lo = 0;
    let hi = 1e5;
    let mid;
    let ans = 0;

    while (lo <= hi) {
      mid = (lo + hi) >> 1;
      if ((mid * (mid + 1)) / 2 <= A) (ans = mid), (lo = mid + 1);
      else hi = mid - 1;
    }
    return ans;
  },
};
```
* * Solution in C++
```cpp
int Solution::solve(int A) {
    long long int ans = 0;
    int low = 1;
    int high = 1000000000;
    while(low <= high){
        long long int mid = (low + high) / 2;
        long long int val = ((mid) * (mid + 1)) / 2;
        if(val == A)
            return mid;
        if(val < A) {
            ans = max(ans, mid);
            low = mid + 1;
        }
        else high = mid - 1;
    }
    return ans;
}
```

