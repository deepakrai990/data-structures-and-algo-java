### Q5. Equilibrium index of an array
#### Problem Description
```text
You are given an array A of integers of size N.

Your task is to find the equilibrium index of the given array

The equilibrium index of an array is an index such that the sum 
of elements at lower indexes is equal to the sum of elements 
at higher indexes.

If there are no elements that are at lower indexes or at higher 
indexes, then the corresponding sum of elements 
is considered as 0.

Note:

    * Array indexing starts from 0.
    * If there is no equilibrium index then return -1.
    * If there are more than one equilibrium indexes then 
      return the minimum index.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px; ">
    1 &lt;= N &lt;= 10<sup>5</sup><br/>
    -10<sup>5</sup> &lt;= A[i] &lt;= 10<sup>5</sup>
</div>

```text
1 <= N <= 10^5
-10^5 <= A[i] <= 10^5
```
#### Input Format
```text
First argument is an array A .
```
#### Output Format
```text
Return the equilibrium index of the given array. If no such index 
is found then return -1.
```
#### Example Input
```text
Input 1:
 A = [-7, 1, 5, 2, -4, 3, 0]

Input 2:
 A = [1, 2, 3]
```
#### Example Output
```text
Output 1:
 3

Output 2:
 -1
```
#### Example Explanation
```text
Explanation 1:

    i   Sum of elements at lower indexes    Sum of elements at higher indexes
    0                   0                                   7
    1                  -7                                   6
    2                  -6                                   1
    3                  -1                                  -1
    4                   1                                   3
    5                  -3                                   0
    6                   0                                   0
    
    3 is an equilibrium index, because: 
    A[0] + A[1] + A[2] = A[4] + A[5] + A[6]

Explanation 1:

    i   Sum of elements at lower indexes    Sum of elements at higher indexes
    0                   0                                   5
    1                   1                                   3
    2                   3                                   0
    Thus, there is no such index.
```
### Hints
* Hint 1
```text
Try to find answer for any particular index 'i' .
Try to maintain the prefix sum and suffix sum
```
* Solution Approach
```text
The idea is to get the total sum of the array first. Then Iterate through the array and keep updating the left sum which is initialized as zero. In the loop, we can get the right sum by subtracting the elements one by one.

1) Initialize leftSum  as 0
2) Get the total sum of the array as sum
3) Iterate through the array and for each index i, do following.
    a)  Update sum to get the right sum.  
           sum = sum - arr[i] 
       // sum is now right sum
    b) If leftSum is equal to sum, then return current index. 
       // update leftSum for next iteration.
    c) leftSum = leftSum + arr[i]
4) return -1 
// If we come out of loop without returning then
// there is no equilibrium index
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int[] A) {
        long sum1 = 0;  
        for(int i = 0; i < A.length ; i++) 
            sum1 += A[i];
        long sum2 = 0;  // sum of elements at lower indexes
        int ans = Integer.MAX_VALUE;
        for(int i = 0 ; i < A.length ; i++){
            sum1 -= A[i];   // sum of elements at higher indexes
            if(sum1 == sum2){
                ans = i;
                break;
            }
            sum2 += A[i];
        }
        if(ans == Integer.MAX_VALUE)
            ans =- 1;   // If no equilibrium index found, then return -1
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
        let sum = 0;
        for(let i = 0; i< A.length; i++)
            sum += A[i];
        let left_sum = 0; // sum of elements at lower indexes
        for( let i = 0; i< A.length; i++) {
            sum -= A[i];    // sum of elements at higher indexes
            if(sum == left_sum)
                return i;
            left_sum += A[i];
        }
        // If no equilibrium index found, then return -1
        return -1;
    }
};
```
* * Solution in C++
```cpp
int equilibrium(vector<int> &arr){
    int n = arr.size();
    int sum = 0; // initialize sum of whole array
    int leftsum = 0; // initialize leftsum
 
    /* Find sum of the whole array */
    for (int i = 0; i < n; ++i)
        sum += arr[i];
 
    for (int i = 0; i < n; ++i){
        sum -= arr[i]; // sum is now right sum for index i
 
        if (leftsum == sum)
            return i;
 
        leftsum += arr[i];
    }
 
    /* If no equilibrium index found, then return -1 */
    return -1;
}
 
int Solution::solve(vector<int> &A) {
    return equilibrium(A);
}
```

