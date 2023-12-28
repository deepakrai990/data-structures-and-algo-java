### Q2. Good Pair
#### Problem Description
```text
Given an array A and an integer B. A pair(i, j) in the array is a 
good pair if i != j and (A[i] + A[j] == B). Check if any 
good pair exist or not.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px; ">
    <p>1 &lt;= A.size() &lt;= 10<sup>4</sup></p>
    <p>1 &lt;= A[i] &lt;= 10<sup>9</sup></p>
    <p>1 &lt;= B &lt;= 10<sup>9</sup></p>
</div>

```text
1 <= A.size() <= 10^4

1 <= A[i] <= 10^9

1 <= B <= 10^9
```
#### Input Format
```text
First argument is an integer array A.

Second argument is an integer B.
```
#### Output Format
```text
Return 1 if good pair exist otherwise return 0.
```
#### Example Input
```text
Input 1:
 A = [1,2,3,4]
 B = 7
Input 2:
 A = [1,2,4]
 B = 4

Input 3:
 A = [1,2,2]
 B = 4
```
#### Example Output
```text
Output 1:
 1

Output 2:
 0

Output 3:
 1
```
#### Example Explanation
```text
Explanation 1:
    (i,j) = (3,4)

Explanation 2:
    No pair has sum equal to 4.

Explanation 3:
    (i,j) = (2,3)
```
### Hints
* Hint 1
```text
See if you can check for partner j for every i in the array one by one.
```
* Solution Approach
```text
Approach 1
    For every i run a loop of j and check if A[i]+A[j]==B or not. 
    Also, check if i!=j.
    
    Time complexity : O(n^2)
    
    This is enough to pass the test cases. However we can further 
    optimize this solution.

Approach 2
    Sort the array A in increasing order. For each i from 0 
    to n-1 find the first element in the array having a value 
    greater than or equal to B-A[i] using binary search.
    
    (For c++ we can directly use ‘lower_bound’ function) . Now 
    just check if this element is equal to B-A[i] , if it is then 
    return 1 , otherwise continue the process.
    
    Time complexity : O(n log n)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int[] A, int B) {
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A.length; j++){
                if(i == j) continue;
                if(A[i] + A[j] == B) return 1;
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
 //param B : integer
 //return an integer
	solve : function(A, B){
        for (let i = 0; i < A.length; ++i){
        	for(let j = 0; j < A.length; ++j){
        		if(i == j) continue;
        		if(A[i] + A[j] == B) return 1;
        	}
        }
        return 0;
	}
};
```
* * Solution in C++
```cpp
int Solution::solve(vector<int> &A, int B){
    for (int i = 0; i < A.size(); ++i){
    	for(int j = 0; j < A.size(); ++j){
    		if(i == j)continue;
    		if(A[i] + A[j] == B) return 1;
    	}
    }
    return 0;
}
```

