### Q1. Good Subarrays Easy
#### Problem Description
```text
Given an array of integers A, a subarray of an array is said to be 
good if it fulfills any one of the criteria:

1. Length of the subarray is be even, and the sum of all the 
   elements of the subarray must be less than B.

2. Length of the subarray is be odd, and the sum of all the 
   elements of the subarray must be greater than B.

Your task is to find the count of good subarrays in A.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px; ">
    1 &lt;= <strong>len(A)</strong> &lt;= 10<sup>3</sup><br>
    1 &lt;= <strong>A[i]</strong> &lt;= 10<sup>3</sup><br>
    1 &lt;= <strong>B</strong> &lt;= 10<sup>7</sup>
</div>

```text
1 <= len(A) <= 10^3
1 <= A[i] <= 10^3
1 <= B <= 10^7
```
#### Input Format
```text
The first argument given is the integer array A.
The second argument given is an integer B.
```
#### Output Format
```text
Return the count of good subarrays in A.
```
#### Example Input
```text
Input 1:
 A = [1, 2, 3, 4, 5]
 B = 4

Input 2:
 A = [13, 16, 16, 15, 9, 16, 2, 7, 6, 17, 3, 9]
 B = 65
```
#### Example Output
```text
Output 1:
 6

Output 2:
 36
```
#### Example Explanation
```text
Explanation 1:
    Even length good subarrays = {1, 2}
    
    Odd length good 
    subarrays = {1, 2, 3}, {1, 2, 3, 4, 5}, {2, 3, 4}, {3, 4, 5}, {5} 
```
### Hints
* Hint 1
```text
The constraints are small.
Have you tried doing just what the question says?
```
* Solution Approach
```text
The constraints are small.

Have you tried doing just what the question says?

Since the constraints are small we can generate all subarrays 
using 2 loops. This can be done in O(N^2). Then find the sum 
of each subarray and check both the conditions.

Note that we cannot iterate over the subarray after generating 
the left index and right index to find the sum as this will 
increase the time complexity of the solution to O(N^3). We can 
find the sum of each subarray in O(1) with the help of a 
prefix sum array, which takes an O(N) pre computation.

Please refer to the complete solution for implementation.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int[] A, int B) {
        int n = A.length;
        int pref[] = new int[n];
        pref[0] = A[0];
        int ans = 0;
        for (int i = 1; i < n; i++) {
            pref[i] = pref[i - 1] + A[i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sz = j - i + 1;
                int sum;
                if (i == 0) {
                    sum = pref[j];
                } else {
                    sum = pref[j] - pref[i - 1];
                }
                if (sz % 2 == 0 && sum < B) ans++;
                if (sz % 2 == 1 && sum > B) ans++;
            }
        }
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = { 
 //param A : array of integers
 //param B : integer
 //return an integer
	solve : function(A, B){
	    let n = A.length;
	    let pref = [];
	    pref[0] = A[0];
	    for(let i = 1; i < n; i++)
	        pref[i] = pref[i-1] + A[i];
	    
	    let ans = 0;
	    for(let i = 0 ; i < n; i++) {
	        for(let j = i; j <n; j++) {
	            let sum = pref[j];
	            if(i > 0)
	                sum -= pref[i-1];
	            if(sum < B && (j-i+1)%2 == 0)
	                ans++;
	            if(sum > B && (j-i+1)%2 == 1)
	                ans++;
	        }
	    }
	    return ans;
	}
};
```
* * Solution in C++
```cpp
int Solution::solve(vector <int> &A,int B){
    int n = A.size();
    int pref[n];
    pref[0] = A[0];
    int ans = 0;
    for(int i = 1 ; i < n ; i++){
        pref[i] = pref[i - 1] + A[i];
    }
    for(int i = 0 ; i < n ; i++){
        for (int j = i ; j < n ; j++){
            int sz = j - i + 1;
            int sum;
            if(i == 0){
                sum = pref[j];
            }
            else{
                sum = pref[j] - pref[i - 1];
            }
            if(sz % 2 == 0 && sum < B)ans++;
            if(sz & 1 && sum > B)ans++;
        }
    }
    return ans;
}
```

