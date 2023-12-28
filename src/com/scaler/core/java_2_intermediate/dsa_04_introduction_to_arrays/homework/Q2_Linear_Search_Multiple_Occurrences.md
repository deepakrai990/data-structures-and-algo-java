### Q2. Linear Search - Multiple Occurrences
#### Problem Description
```text
Given an array A and an integer B, find the number of occurrences of B in A.
```
#### Problem Constraints
```text
1 <= B, Ai <= 10^9
1 <= |A| <= 10^5
```
#### Input Format
```text
Given an integer array A and an integer B.
```
#### Output Format
```text
Return an integer, number of occurrences of B in A.
```
#### Example Input
```text
Input 1:
 A = [1, 2, 2], B = 2 

Input 2:
 A = [1, 2, 1], B = 3 
```
#### Example Output
```text
Output 1:
 2
Output 2:
 0
```
#### Example Explanation
```text
Explanation 1:
    Element at index 2, 3 is equal to 2 hence count is 2.

Explanation 2:
    There is no element equal to 3 in the array.
```
### Hints
* Hint 1
```text
We can iterate through the array and check if the current element 
is equal to the required value, if it is then we can just 
increase the count.
```
* Solution Approach
<ul>
  <li>Initialize a variable <code>ans</code> with 0</li>
  <li>Iterate for i=0 to N-1</li>
  <li>Check if A[i] = B then increment <code>ans</code> by 1 every time</li>
</ul>

```text
* Initialize a variable ans with 0
* Iterate for i=0 to N-1
* Check if A[i] = B then increment ans by 1 every time
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        int ans = 0;
        // iterate over the for loop to check if current one is equal to B
        for(int i = 0; i < A.size(); ++i){
            if(A.get(i) == B){
                ans++;
            }
        }
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
/** Not available **/
```
* * Solution in C++
```cpp
int Solution::solve(vector<int> &A, int B) {
    int ans = 0;
    // iterate over the for loop to check if current one is equal to B
    for(int i = 0; i < A.size(); ++i){
        if(A[i] == B){
            ans++;
        }
    }
    return ans;
}
```

