### Q2. Max Product Subarray
#### Problem Description
```text
Given an integer array A of size N. Find the contiguous subarray within the given 
array (containing at least one number) which has the largest product.

Return an integer corresponding to the maximum product possible.

NOTE: Answer will fit in 32-bit integer value.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= N &lt;= 5 * 10<sup>5</sup></p>
    <p>-100 &lt;= A[i] &lt;= 100</p>
</div>

```text
1 <= N <= 5 * 10^5

-100 <= A[i] <= 100
```
#### Input Format
```text
First and only argument is an integer array A.
```
#### Output Format
```text
Return an integer corresponding to the maximum product possible.
```
#### Example Input
```text
Input 1:
 A = [4, 2, -5, 1]

Input 2:
 A = [-3, 0, -5, 0]
```
#### Example Output
```text
Output 1:
 8

Output 2:
 0
```
#### Example Explanation
```text
Explanation 1:
    We can choose the subarray [4, 2] such that the maximum product is 8.

Explanation 2:
    0 will be the maximum product possible.
```
### Hints
* Hint 1
```text
This problem can be solved in different ways:

    1. DP based solution: Try to compute the maximum positive/negative product ending 
       at any index i.

    2. Observation based solution: Maintain something similar to slider and try to 
       figure out when to change the position of slider. Keep maintaining positive/negative 
       maximum product too.
```
* Solution Approach
```text
If there were no zeros or negative numbers, then the answer would definitely be the 
product of the whole array.

Now lets assume there were no negative numbers and just positive numbers and 0. In that 
case we could maintain a current maximum product which would be reset to A[i] when 0s were 
encountered.

When the negative numbers are introduced, the situation changes ever so slightly. We need 
to now maintain the maximum product in positive and maximum product in negative. On 
encountering a negative number, the maximum product in negative can quickly come 
into picture.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maxProduct(final int[] A) {
        return maxProductC(A, A.length);
    }

    static int maxProductC(int arr[], int n) {

        // Variables to store maximum and minimum 
        // product till ith index. 
        int minVal = arr[0];
        int maxVal = arr[0];

        int maxProduct = arr[0];

        for (int i = 1; i < n; i++) {

            // When multiplied by -ve number, 
            // maxVal becomes minVal 
            // and minVal becomes maxVal. 
            if (arr[i] < 0) {
                int temp = maxVal;
                maxVal = minVal;
                minVal = temp;

            }

            // maxVal and minVal stores the 
            // product of subarray ending at arr[i]. 
            maxVal = Math.max(arr[i], maxVal * arr[i]);
            minVal = Math.min(arr[i], minVal * arr[i]);

            // Max Product of array. 
            maxProduct = Math.max(maxProduct, maxVal);
        }

        // Return maximum product found in array. 
        return maxProduct;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    maxProduct: function (A) {
        let n = A.length;
        let r = A[0];
        for (let i = 1, imax = r, imin = r; i < n; i++) {
            if (A[i] < 0) [imax, imin] = [imin, imax];
            imax = Math.max(A[i], imax * A[i]);
            imin = Math.min(A[i], imin * A[i]);
            r = Math.max(r, imax);
        }
        return r;
    },
};
```
* * Solution in C++
```cpp
int Solution::maxProduct(const vector < int > & A) {
  int n = A.size();
  // store the result that is the max we have found so far
  long long r = A[0];
  // imax/imin stores the max/min product of
  // subarray that ends with the current number A[i]
  for (long long i = 1, imax = r, imin = r; i < n; i++) {
    // multiplied by a negative makes big number smaller, small number bigger
    // so we redefine the extremums by swapping them
    if (A[i] < 0)
      swap(imax, imin);

    // max/min product for the current number is either the current number itself
    // or the max/min by the previous number times the current one
    imax = max(A[i] * 1 LL, imax * A[i]);
    imin = min(A[i] * 1 LL, imin * A[i]);

    // the newly computed max value is a candidate for our global result
    r = max(r, imax);

  }
  return r;
}
```

