### Q1. Subarray with the least average
#### Problem Description
```text
Given an array of size N, find the subarray of size K with 
the least average.
```
#### Problem Constraints
* <p>1 <= k <= N <= 1 * 10<sup>5</sup></p>
* <p>-1 * 10<sup>5</sup> <= A[i] <= 1 * 10<sup>5</sup></p>
```text
1 <= k <= N <= 1e5
-1e5 <= A[i] <= 1e5
```
#### Input Format
```text
First argument contains an array A of integers of size N.

Second argument contains integer k.
```
#### Output Format
```text
Return the index of the first element of the subarray of size k 
that has least average.

Array indexing starts from 0.
```
#### Example Input
```text
Input 1:
 A=[3, 7, 90, 20, 10, 50, 40]
 B=3

Input 2:
 A=[3, 7, 5, 20, -10, 0, 12]
 B=2
```
#### Example Output
```text
Output 1:
 3

Output 2:
 4
```
#### Example Explanation
```text
Explanation 1:
    Subarray between indexes 3 and 5
    The subarray {20, 10, 50} has the least average 
    among all subarrays of size 3.

Explanation 2:
    Subarray between [4, 5] has minimum average
```
### Hints
* Hint 1
```text
Average for any particular subarray is sum_of_elements/no_of_elements.

In this no. of elements is same in each subarray as we have 
to find only subarray of size k.

So now question reduces to find subarray which has minimum sum.
```
* Solution Approach
```text
An Efficient Solution is to solve the above problem 
in O(n) time and O(1) extra space. The idea is to use 
sliding window of size k. Keep track of sum of 
current k elements. To compute sum of current window, 
remove first element of previous window and add current 
element (last element of current window).

1) Initialize res_index = 0 // Beginning of result index
2) Find sum of first k elements. Let this sum be 'curr_sum'
3) Initialize min_sum = sum
4) Iterate from (k+1)'th to n'th element, do following
   for every element arr[i]
      a) curr_sum = curr_sum + arr[i] - arr[i-k]
      b) If curr_sum < min_sum
           res_index = (i-k+1)
5) Print res_index and res_index+k-1 as beginning and ending
   indexes of resultant subarray.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    private int findMinAvgSubarray(int arr[], int n, int k) {

        // Initialize  beginning index of result
        int res_index = 0;

        // Compute sum of first subarray of size k
        int curr_sum = 0;
        for (int i = 0; i < k; i++)
            curr_sum += arr[i];

        // Initialize minimum sum as current sum
        int min_sum = curr_sum;

        // Traverse from (k+1)'th element to n'th element
        for (int i = k; i < n; i++) {
            // Add current item and remove first item of
            // previous subarray
            curr_sum += arr[i] - arr[i - k];

            // Update result if needed
            if (curr_sum < min_sum) {
                min_sum = curr_sum;
                res_index = (i - k + 1);
            }
        }
        return res_index;
    }

    public int solve(int[] A, int B) {
        int n = A.length;
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) arr[i] = A[i];
        return findMinAvgSubarray(arr, n, B);
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
	    
	    let sum = 0;
	    for(let i = 0; i < B; i++)
	        sum += (A[i]);
	    let ans = sum;
	    let index = 0;
	    for(let i = B; i<A.length; i++) {
	        
	        sum -= A[i-B];
	        sum += A[i];
	        if(sum < ans) {
	            ans = sum;
	            index = i- B +1;
	        }
	    }
	    return index ; 
	}
};
```
* * Solution in C++
```cpp
int findMinAvgSubarray(int arr[], int n, int k)
{
  
    // Initialize  beginning index of result
    int res_index = 0;
  
    // Compute sum of first subarray of size k
    int curr_sum = 0;
    for (int i = 0; i < k; i++)
        curr_sum += arr[i];
  
    // Initialize minimum sum as current sum
    int min_sum = curr_sum;
  
    // Traverse from (k+1)'th element to n'th element
    for (int i = k; i < n; i++) {
        // Add current item and remove first item of
        // previous subarray
        curr_sum += arr[i] - arr[i - k];
  
        // Update result if needed
        if (curr_sum < min_sum) {
            min_sum = curr_sum;
            res_index = (i - k + 1);
        }
    }
    return res_index;
}
int Solution::solve(vector<int> &A, int B) {
    int n=A.size();
    int arr[n];
    for(int i=0;i<n;i++) arr[i]=A[i];
    return findMinAvgSubarray(arr,n,B);
}
```

