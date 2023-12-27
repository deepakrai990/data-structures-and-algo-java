### Q6. Sum of All Subarrays
#### Problem Description
```text
You are given an integer array A of length N.

You have to find the sum of all subarray sums of A.

More formally, a subarray is defined as a contiguous part of an 
array which we can obtain by deleting zero or more elements from 
either end of the array.

A subarray sum denotes the sum of all the elements of that subarray.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px; ">
    1 &lt;= N &lt;= 10<sup>5</sup><br>
    1 &lt;= A<sub>i</sub> &lt;= 10 <sup>4</sup>
</div>

```text
1 <= N <= 10^5
1 <= Ai <= 10^4
```
#### Input Format
```text
The first argument is the integer array A.
```
#### Output Format
```text
Return a single integer denoting the sum of all subarray sums of 
the given array.
```
#### Example Input
```text
Input 1:
 A = [1, 2, 3]

Input 2:
 A = [2, 1, 3]
```
#### Example Output
```text
Output 1:
 20

Output 2:
 19
```
#### Example Explanation
```text
Explanation 1:
    The different subarrays for the given array 
    are: [1], [2], [3], [1, 2], [2, 3], [1, 2, 3].
    
    Their sums are: 1 + 2 + 3 + 3 + 5 + 6 = 20

Explanation 2:
    Similar to the first example, the sum of all subarray sums 
    for this array is 19.
```
### Hints
* Hint 1
```text
This problem has a straightforward solution with 
time complexity of O(N2). 

How can we improve it to O(N)?

Think about how each element contributes to the sum.
```
* Solution Approach
```text
For each element, if we know how many subarrays do they come in, 
we can easily calculate their contribution to the sum 
as (Number of Subarrays) * (A[i]).

How do we calculate the number of subarrays for each element?

Let us focus on the definition of a subarray. It is obtained by 
deleting zero or more elements from either end.

So, for each element, let X be the number of elements to 
their left, and Y be the number of elements to their right.

Number of required subarrays = (X + 1) * (Y + 1)

We can easily know X and Y from the index of the element.
Let the array be 0 - indexed and N be the length of the array, 
X = i, Y = N - i - 1

Refer to the complete solution for implementation details.
```
* Complete Solution
* * Solution in Java
```java
class Solution {
    public long subarraySum(int[] A) {
        long ans = 0;
        int n = A.length;
        for (int i = 0; i < n; i++)
            ans += (long) A[i] * (i + 1) * (n - i);
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : array of integers
    //return a long integers
    subarraySum: function (A) {
        let n = A.length;
        let sum = BigInt(0)
        for (let i = 0; i < n; i++) {
            let x = (i + 1) * (n - i);
            sum += BigInt(x) * BigInt(A[i]);
        }
        return sum;
    }
};
```
* * Solution in C++
```cpp
long Solution::subarraySum(vector<int> &A) {
    long ans = 0;
    int n = A.size();
    for (int i = 0; i < n; i++)
        ans += (long)A[i] * (i + 1) * (n - i);
    return ans;
}
```

