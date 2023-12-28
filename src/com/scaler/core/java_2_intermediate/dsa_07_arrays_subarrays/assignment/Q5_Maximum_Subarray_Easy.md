### Q5. Maximum Subarray Easy
#### Problem Description
```text
You are given an integer array C of size A. Now you need to 
find a subarray (contiguous elements) so that the sum of 
contiguous elements is maximum.

But the sum must not exceed B.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px; ">
    1 &lt;= A &lt;= 10<sup>3</sup><br>
    1 &lt;= B &lt;= 10<sup>9</sup><br>
    1 &lt;= C[i] &lt;= 10<sup>6</sup><br>
</div>

```text
1 <= A <= 10^3
1 <= B <= 10^9
1 <= C[i] <= 10^6
```
#### Input Format
```text
The first argument is the integer A.
The second argument is the integer B.
The third argument is the integer array C.
```
#### Output Format
```text
Return a single integer which denotes the maximum sum.
```
#### Example Input
```text
Input 1:
 A = 5
 B = 12
 C = [2, 1, 3, 4, 5]

Input 2:
 A = 3
 B = 1
 C = [2, 2, 2]
```
#### Example Output
```text
Output 1:
 12

Output 2:
 0
```
#### Example Explanation
```text
Explanation 1:
    We can select {3,4,5} which sums up to 12 which is the maximum 
    possible sum.

Explanation 2:
    All elements are greater than B, which means we cannot select 
    any subarray.
    Hence, the answer is 0.

```
### Hints
* Hint 1
```text
What is the brute force approach that you can think of?
How can you optimize it?
```
* Solution Approach
```text
The most basic brute force approach would be to find the sum of 
every subarray and check if it less than B, we will put it in a 
variable which will store the maximum value less than B.

The time complexity of this approach would be O(N ^ 3).

But, for the given constraints, the best we can do is O(N ^ 2).

We can do this easily just by modifying the way we 
iterate through the loop.

We will use the following pseudocode:

ans = 0
for(start = 0, start < size; start += 1)
    sum = 0
    for(end = start; end < size; end += 1)
        sum += array[end]
        if(sum <= MaximumValue)
            ans = max(sum, ans)
        else
            break

Using this, we are checking the sum of every subarray but 
this method is faster.

Refer to the complete solution for more details.
```
* Complete Solution
* * Solution in Java
```java
class Solution {
    public int maxSubarray(int A, int B, int[] C) {
        int ans = 0;
        for (int i = 0; i < A; i++) {
            int sum = 0;
            for (int j = i; j < A; j++) {
                sum += C[j];
                if (sum <= B)
                    ans = Math.max(ans, sum);
                else break;
            }
        }
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = { 
 //param A : integer
 //param B : integer
 //param C : array of integers
 //return an integer
	maxSubarray : function(A, B, C){
	    
	    let ans = 0;
	    for( let i = 0; i < A; i++) {
	        
	        let sum = 0n;
	        for( let j = i; j < A; j++) {
	            sum += C[j];
	            
	            if( sum <= B && ans < sum)
	                ans = Number(sum);
	            else if( sum > B)
	                break;
	        }
	    }
	    return ans;
	}
};
```
* * Solution in C++
```cpp
int Solution::maxSubarray(int A, int B, vector < int > & C) {
    assert(A >= 1 && A <= 1000);
    assert(B >= 1 && B <= 1e9);
    for(auto &x : C) assert(x >= 1 && x <= 1e6);
    int ans = 0;
    for (int i = 0; i < A; i++) {
        int sum = 0;
        for (int j = i; j < A; j++) {
            sum += C[j];
            if (sum <= B)
                ans = max(ans, sum);
            else break;
        }
    }
    return ans;
}
```

