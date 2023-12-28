### Q4. Time to equality
#### Problem Description
```text
Given an integer array A of size N. In one second, you can 
increase the value of one element by 1.

Find the minimum time in seconds to make all elements of 
the array equal.
```
#### Problem Constraints
```text
1 <= N <= 1000000
1 <= A[i] <= 1000
```
#### Input Format
```text
First argument is an integer array A.
```
#### Output Format
```text
Return an integer denoting the minimum time to make all elements equal.
```
#### Example Input
```text
A = [2, 4, 1, 3, 2]
```
#### Example Output
```text
8
```
#### Example Explanation
```text
We can change the array A = [4, 4, 4, 4, 4]. The time required 
will be 8 seconds.
```
### Hints
* Hint 1
```text
Since we can only increase the element by 1, we should increase 
all elements up to the maximum element.
```
* Solution Approach
```text
Since we can only increase the element by 1, we should increase all 
elements up to the maximum element.

We can find the maximum element, and for finding the minimum number 
of moves, we should find the summation of 
the absolute difference of all 

elements with the maximum element.  
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int[] A) {
        int n=A.length;
        int val=0;
        for(int i=0;i<n;i++)
        {
            val=Math.max(val,A[i]);
        }
        int ans=0;
        for(int i=0;i<n;i++)
        {
          ans+=val-A[i];
        }
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = { 
 //param A : array of integers
 //return an integer
	solve : function(A){
	    
	    let max = -1;
	    let n = A.length;
	    
	    for(let i = 0; i < n; i++)
	        max = Math.max(max,A[i]);
	    let ans = 0;
	    for(let i = 0; i < n; i++)
	        ans+=(max - A[i]);
	    return ans;
	}
};
```
* * Solution in C++
```cpp
int Solution::solve(vector<int> &A) {
    int n=A.size();
      int val=0;
      for(int i=0;i<n;i++)
      {
        val=max(val,A[i]);
      }
      int ans=0;
      for(int i=0;i<n;i++)
      {
        ans+=val-A[i];
      }
      return ans;
}
```

