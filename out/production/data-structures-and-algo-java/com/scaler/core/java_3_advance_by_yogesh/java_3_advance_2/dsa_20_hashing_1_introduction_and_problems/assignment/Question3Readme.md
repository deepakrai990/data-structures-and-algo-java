### Q3. Sub-array with 0 sum
#### Problem Description
```text
Given an array of integers A, find and return whether the given 
array contains a non-empty subarray with a sum equal to 0.

If the given array contains a sub-array with sum zero 
return 1, else return 0.
```
#### Problem Constraints
* <p>1 &lt;= |A| &lt;= 100000</p>
* <p>-10<sup>9</sup> &lt;= A[i] &lt;= 10<sup>9</sup></p>
```text
1 <= |A| <= 100000

-10^9 <= A[i] <= 10^9
```
#### Input Format
```text
The only argument given is the integer array A.
```
#### Output Format
```text
Return whether the given array contains a subarray with a sum equal to 0.
```
#### Example Input
```text
Input 1:
 A = [1, 2, 3, 4, 5]

Input 2:
 A = [-1, 1]
```
#### Example Output
```text
Output 1:
 0

Output 2:
 1
```
#### Example Explanation
```text
Explanation 1:
    No subarray has sum 0.
Explanation 2:
    The array has sum 0.
```
### Hints
* Hint 1
```text
Try using the prefix sum array.
The idea is to iterate through the array, and for every element A[i],
calculate sum of elements from 0 to i (this can simply be done 
as sum += arr[i]).
```
* Solution Approach
```text
The idea is to iterate through the array, and for every element A[i],
calculate sum of elements from 0 to i (this can simply be done 
as sum += arr[i]).

If the current sum has been seen before, then there is a zero-sum array.

Hashing is used to store the sum values so that we can quickly store sum and
find out whether the current sum is seen before or not.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(ArrayList < Integer > A) {
        HashSet < Long > set = new HashSet < Long > ();
        long sum = 0;
        set.add(sum);
        for (int x: A) {
            sum += x;
            if (set.contains(sum)) return 1;
            else {
                set.add(sum);
            }
        }
        return 0;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : array of integers
    //return an integer
    solve: function (A) {
        let prefixSum = 0;
        let m = new Map();
        let count = 0;
        for (let i = 0; i < A.length; i++) {
            prefixSum += A[i];
            if (prefixSum == 0) {
                count++;
            }
            if (m.has(prefixSum)) {
                count += m.get(prefixSum);
            }
            m.set(prefixSum, m.get(prefixSum) + 1 || 1);
        }
        if (count > 0) {
            return 1;
        }
        return 0;
    }
};
```
* * Solution in C++
```cpp
int Solution::solve(vector < int > & a) {
    unordered_map<long, bool> h;
    bool found = false;
    long s = 0;
    h[0] = true;
    for (int x: a) {
        s += x;
        if (h.find(s) != h.end()) found = true;
        h[s] = true;
    }
    return found ? 1 : 0;
}
```

