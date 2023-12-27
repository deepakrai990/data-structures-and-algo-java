### Q2. Count distinct elements
#### Problem Description
```text
You are given an array A of N integers. You will have to 
return number of distinct elements of the array.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    1 &lt;= N &lt;= 10<sup>5</sup><br>
    1 &lt;= A[i] &lt;= 10<sup>9</sup>
</div>

```text
1 <= N <= 10^5
1 <= A[i] <= 10^9
```
#### Input Format
```text
First argument A is an array of integers.
```
#### Output Format
```text
Return an integer.
```
#### Example Input
```text
Input 1:
 A = [3, 4, 3, 6, 6]

Input 2:
 A = [3, 3, 3, 9, 0, 1, 0]
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
For Input 1:
    The distinct elements of the array are 3, 4 and 6.

For Input 2:
    The distinct elements of the array are 3, 9, 0 and 1.
```
### Hints
* Hint 1
```text
The set data structure can only store unique elements.
```
* Solution Approach
```text
We can use a simple python set to convert the given list to 
set and return its length.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int[] A) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0 ; i < A.length ; i++){
            set.add(A[i]);
        }
        return set.size();
    }
}
```
* * Solution in Javascript
```javascript
/** Not available **/
```
* * Solution in C++
```cpp
int Solution::solve(vector<int> &A) {
    set<int> s;
    for(auto it : A){
        s.insert(it);
    }
    return s.size();
}
```

