### Q3. Counting Subarrays Easy
#### Problem Description
```text
Given an array A of N non-negative numbers and 
a non-negative number B, you need to find the 
number of subarrays in A with a sum less than B.

We may assume that there is no overflow.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px; ">
    <p>1 &lt;= N &lt;= 10<sup>3</sup></p>
    <p>1 &lt;= A[i] &lt;= 1000</p>
    <p>1 &lt;= B &lt;= 10<sup>7</sup></p>
</div>

```text
1 <= N <= 10^3

1 <= A[i] <= 1000

1 <= B <= 10^7
```
#### Input Format
```text
First argument is an integer array A.

Second argument is an integer B.
```
#### Output Format
```text
Return an integer denoting the number of subarrays in A 
having sum less than B.
```
#### Example Input
```text
Input 1:
 A = [2, 5, 6]
 B = 10

Input 2:
 A = [1, 11, 2, 3, 15]
 B = 10
```
#### Example Output
```text
Output 1:
 4

Output 2:
 4
```
#### Example Explanation
```text
Explanation 1:
    The subarrays with sum less than B are {2}, {5}, {6} and {2, 5},

Explanation 2:
    The subarrays with sum less than B are {1}, {2}, {3} and {2, 3}
```
### Hints
* Hint 1
```text
The constraints are small. Have you tried doing just what 
the question says?
```
* Solution Approach
```text
The constraints are small. Have you tried doing just what the question says?

Since the constraints are small we can generate all subarrays 
using 2 loops. This can be done in O(N^2). Then find the sum 
of each subarray and if the sum is less than B we 
add 1 to our answer.

Note that we cannot iterate over the subarray after generating 
the left index and right index to find the sum as this will 
increase the time complexity of the solution to O(N^3). We can 
find the sum of each subarray in O(1) with the help of a 
prefix sum array, which takes an O(N) pre-computation.

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
                int sum = pref[j];
                if (i > 0) {
                    sum -= pref[i - 1];
                }
                if (sum < B) ans++;
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
	            if(sum < B)
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
    int n=A.size();
    int pref[n];
    pref[0]=A[0];
    int ans=0;
    for(int i=1;i<n;i++)pref[i]=pref[i-1]+A[i];
    for(int i=0;i<n;i++){
        for (int j=i;j<n;j++){
            int val = pref[j];
            if(i > 0){
                val -= pref[i-1];
            }
            if(val<B)ans++;
        }
    }
    return ans;
}
```

