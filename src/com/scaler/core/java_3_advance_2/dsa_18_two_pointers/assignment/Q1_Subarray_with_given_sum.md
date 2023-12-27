### Q1. Subarray with given sum
#### Problem Description
```text
Given an array of positive integers A and an integer B, find 
and return first continuous subarray which adds to B.

If the answer does not exist return an array with a 
single element "-1".

First sub-array means the sub-array for which starting 
index in minimum.
```
#### Problem Constraints
* <p>1 &lt;= length of the array &lt;= 100000</p>
* <p>1 &lt;= A[i] &lt;= 10<sup>9</sup></p>
* <p>1 &lt;= B &lt;= 10<sup>9</sup></p>
```text
1 <= length of the array <= 100000
1 <= A[i] <= 10^9
1 <= B <= 10^9
```
#### Input Format
```text
The first argument given is the integer array A.

The second argument given is integer B.
```
#### Output Format
```text
Return the first continuous sub-array which adds to B and 
if the answer does not exist return an array with 
a single element "-1".
```
#### Example Input
```text
Input 1:
 A = [1, 2, 3, 4, 5]
 B = 5

Input 2:
 A = [5, 10, 20, 100, 105]
 B = 110
```
#### Example Output
```text
Output 1:
 [2, 3]

Output 2:
 -1
```
#### Example Explanation
```text
Explanation 1:
 [2, 3] sums up to 5.

Explanation 2:
 No subarray sums up to required number.
```
### Hints
* Hint 1
```text
First lets think of brute force solution.
You can iterate through all subarrays and find the answer.
Can you do this efficiently?
```
* Solution Approach
```text
We can use 2 pointer technique to solve this problem efficiently.

We can keep pointers left and right.

We move right if our sum is < target.

We move left when sum > target. using left and right, we get 
our subarray.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int[] solve(int[] A, int B) {
        long n = A.length;
        int l = 0, r = 0;
        long sum = A[l];
        while (r < n) {
            if (sum == B) {
                // current window sum = B
                int[] ans = new int[r - l + 1];
                for (int i = l; i <= r; i++) ans[i - l] = A[i];
                return ans;
            } else if (sum < B) {
                // current window sum < B
                r++;
                if (r < n) sum += A[r];
            } else {
                // current window sum > B
                sum -= A[l];
                l++;
                if (l > r && l < n - 1) {
                    r++;
                    sum += A[r];
                }
            }
        }
        int ans[] = new int[1];
        ans[0] = -1;
        return ans;
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
        let n = A.length;
        let l = 0, r = 0;
        let sum = A[l];
        while (r < n && l <= r) {
            if (sum == B) {
                // current window sum = B
                return A.slice(l, r + 1);
            } else if (sum < B) {
                // current window sum < B
                r++;
                if (r < n) {
                    sum += A[r];
                }
            } else {
                // current window sum > B
                sum -= A[l];
                l++;
                if (l > r && l < n - 1) {
                    r++;
                    sum += A[r];
                }
            }
        }
        return [-1];
	}
};
```
* * Solution in C++
```cpp
vector < int > Solution::solve(vector < int > & A, int B) {
    int n = A.size();
    int l = 0, r = 0;
    int sum = A[l];
    while (r < n && l <= r) {
        if (sum == B) {
            // current window sum = B
            vector < int > ans;
            for (int i = l; i <= r; i++) 
                ans.push_back(A[i]);
            return ans;
        } else if (sum < B) {
            // current window sum < B
            r++;
            if (r < n) sum += A[r];
        } else {
            // current window sum > B
            sum -= A[l];
            l++;
            if (l > r && l < n - 1) {
                r++;
                sum += A[r];
            }
        }
    }
    return {-1};
}
```

