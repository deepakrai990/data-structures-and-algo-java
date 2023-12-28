### Q7. Even Subarrays
#### Problem Description
```text
You are given an integer array A.

Decide whether it is possible to divide the array into one or more 
subarrays of even length such that the first and last element 
of all subarrays will be even.

Return "YES" if it is possible; otherwise, 
return "NO" (without quotes).
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= |A|, A[i] &lt;= 10<sup>6</sup></p>
</div>

```text
1 <= |A|, A[i] <= 10^6
```
#### Input Format
```text
The first and the only input argument is an integer array, A.
```
#### Output Format
```text
Return a string "YES" or "NO" denoting the answer.
```
#### Example Input
```text
Input 1:
 A = [2, 4, 8, 6]

Input 2:
 A = [2, 4, 8, 7, 6]
```
#### Example Output
```text
Output 1:
 "YES"

Output 2:
 "NO"
```
#### Example Explanation
```text
Explanation 1:
    We can divide A into [2, 4] and [8, 6].

Explanation 2:
    There is no way to divide the array into even length subarrays.

```
### Hints
* Hint 1
```text
Try to find a pattern in this question. For some particular 
cases, the answer is always going to Yes and No otherwise.

Try to make that observation.
```
* Solution Approach
```text
If the first and the last element are even and the size of the 
array is even, then only the answer will be “YES.”

Otherwise will be “NO,” as we can’t divide the array into subarrays 
that meet the given conditions in the question.

So, if(A[0]%2 == 0 and A[n-1]%2 == 0 and n%2 == 0)
return “YES”;
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public String solve(int[] A) {
        int n = (int)A.length;
        if(A[0]%2 == 0 && A[n-1]%2 == 0 && n%2 == 0)
            return "YES";
        return "NO";
    }
}
```
* * Solution in Javascript
```javascript
module.exports = { 
 //param A : array of integers
 //return a strings
	solve : function(A){
            let n = A.length;
            if(A[0]%2 == 0 && A[n-1]%2 == 0 && n%2 == 0)
                return "YES";
            else
                return "NO";
	}
};
```
* * Solution in C++
```cpp
string Solution::solve(vector<int> &A) {
    
    int n = (int)A.size();
    /* 
        If the first and the last element is even and
        thesize of the array is even then only the answer will be "YES"
    */
    if(A[0]%2 == 0 and A[n-1]%2 == 0 and n%2 == 0)
        return "YES";
    // Otherwise answer will be "NO", as we can't divide the array into subarrays that met required conditions.
    return "NO";
}
```

