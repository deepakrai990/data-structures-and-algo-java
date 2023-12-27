### Q3. Second Largest
#### Problem Description
```text
You are given an integer array A. You have to find the second 
largest element/value in the array or report that no 
such element exists.
```
#### Problem Constraints
```text
1 <= |A| <= 10^5

0 <= A[i] <= 10^9
```
#### Input Format
```text
The first argument is an integer array A.
```
#### Output Format
```text
Return the second largest element. If no such element 
exist then return -1.
```
#### Example Input
```text
Input 1:
 A = [2, 1, 2] 

Input 2:
 A = [2]
```
#### Example Output
```text
Output 1:
 1 

Output 2:
 -1 
```
#### Example Explanation
```text
Explanation 1:
    First largest element = 2
    Second largest element = 1

Explanation 2:
    There is no second largest element in the array.
```
### Hints
* Hint 1
<ul>
  <li>You can loop through the array maintaining two variables:
    <ol>
      <li>
            <strong>largest</strong>: denoting the largest element in 
            the array processed.
      </li>
      <li>
        <strong>secondLargest</strong>: denoting the second-largest 
        element in the array processed.
      </li>
    </ol>
  </li>
  <li>
    Try to find out the largest element, and then we can find 
    the second largest using it.
  </li>
</ul>

```text
* You can loop through the array maintaining two variables:
    1. largest: denoting the largest element in the array processed.
    2. secondLargest: denoting the second largest element in 
       the array processed.

* Try to find out the largest element, and then we can find the 
second largest using it.
```
* Solution Approach
```text
* First, we iterate over each element in the list and find the 
largest element. Let’s say max_elem.

* Then, we again iterate over each element in the list using a 
for loop and find the largest element, but we also check if that 
element is equal to max_elem, if it is we skip it.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int[] A) {
        int index = 0, n = A.length;
        // This will give us the maximum element of A
        for(int i = 1; i < n; i++){
            if(A[i] > A[index]){
                index = i;
            }
        }
        
        int ans = -1;
        // This will give us maximum element of A which is less than A[index]
        for(int i = 0; i < n; i++){
            if(A[i] != A[index]){
                ans = Math.max(ans, A[i]);
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
    //return an integer
    solve : function(A){
        let n = A.length;
        let index = 0;
        // This loop calculates the largest element in the list.
        for(let i = 0; i < n; i++) {
            if(A[i] > A[index])
                index = i;
        }
        let ans = -1;
        // This loop calculates the second largest element in the list. 
        for(let i = 0; i < n; i++) {
            if(A[i] != A[index] && A[i] > ans)
                ans = A[i];

        }
        return Number(ans);
    }
};
```
* * Solution in C++
```cpp
int Solution::solve(vector<int> &A) {
    int index = 0, n = A.size();
    // This will give us the maximum element of A
    for(int i = 1; i < n; i++){
        if(A[i] > A[index]){
            index = i;
        }
    }
    
    int ans = -1;
    // This will give us maximum element of A which is less than A[index]
    for(int i = 0; i < n; i++){
        if(A[i] != A[index]){
            ans = max(ans, A[i]);
        }
    }
    
    return ans;
}
```

