### Q3. Arithmetic Progression?
#### Problem Description
```text
Given an integer array A of size N. Return 1 if the array can be 
arranged to form an arithmetic progression, otherwise return 0.

A sequence of numbers is called an arithmetic progression if the 
difference between any two consecutive elements is the same.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>2 &lt;= N &lt;= 10<sup>5</sup></p>
    <p>-10<sup>9</sup> &lt;= A[i] &lt;= 10<sup>9</sup></p>
</div>

```text
2 <= N <= 10^5

-10^9 <= A[i] <= 10^9
```
#### Input Format
```text
The first and only argument is an integer array A of size N.
```
#### Output Format
```text
Return 1 if the array can be rearranged to form an arithmetic 
progression, otherwise return 0.
```
#### Example Input
```text
Input 1:
 A = [3, 5, 1]

Input 2:
 A = [2, 4, 1]
```
#### Example Output
```text
Output 1:
 1

Output 2:
 0
```
#### Example Explanation
```text
Explanation 1:
    We can reorder the elements as [1,3,5] or [5,3,1] with 
    differences 2 and -2 respectively, between 
    each consecutive elements.

Explanation 2:
    There is no way to reorder the elements to obtain 
    an arithmetic progression.
```
### Hints
* Hint 1
```text
Consider that any valid arithmetic progression will be in sorted order.
```
* Solution Approach
```text
Consider that any valid arithmetic progression will be 
in sorted order.

Sort the array, then check if the differences of 
all consecutive elements are equal.

Time Complexity: O(NlogN)
Space Complexity: O(1)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        Collections.sort(A);
        int dif = A.get(1) - A.get(0);
        int ans = 1;
        for (int i = 1; i < n; i++) {
            if (A.get(i) - A.get(i - 1) != dif) {
                ans = 0;
                break;
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
   solve : function(A) {
       A.sort(function(a,b) {return a - b});
           
       let d = A[1] - A[0];
       let n = A.length;
       let ans = 1;
       for(let i = 1;  i < n; i++) {
           if(A[i] - A[i-1] != d)
               ans = 0;
       }
       return ans;
   }
};
```
* * Solution in C++
```cpp
int Solution::solve(vector<int> &A) {
    int n = A.size();
    sort(A.begin(), A.end());
    int dif = A[1] - A[0];
    int ans = 1;
    for(int i = 1; i < n; i++){
        if(A[i] - A[i-1] != dif){
            ans = 0;
            break;
        }
    }
    return ans;
}
```

