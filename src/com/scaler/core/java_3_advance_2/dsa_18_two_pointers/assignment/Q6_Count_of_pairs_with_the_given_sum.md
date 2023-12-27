### Q6. Count of pairs with the given sum
#### Problem Description
```text
Given a sorted array of distinct integers A and an integer B, find and return 
how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.
```
#### Problem Constraints
```text
1 <= length of the array <= 100000
1 <= A[i] <= 10^9 
1 <= B <= 10^9
```
#### Input Format
```text
The first argument given is the integer array A.
The second argument given is integer B.
```
#### Output Format
```text
Return the number of pairs for which sum is equal to B.
```
#### Example Input
```text
Input 1:
    A = [1, 2, 3, 4, 5]
    B = 5
    
Input 2:
    A = [5, 10, 20, 100, 105]
    B = 110
```
#### Example Output
```text
Output 1:
    2
    
Output 2:
    2
```
#### Example Explanation
```text

```
### Hints
* Hint 1
```text

```
* Solution Approach
```text

```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int[] a, int b) {
        int ans = 0, l = 0, r = a.length - 1;
        while (l < r) {
            if (a[l] + a[r] == b) ans++;
            if (a[l] + a[r] <= b) l++;
            else r--;
        }
        return ans;
    }
}
```
* * Solution in Javascript
```javascript

```
* * Solution in C++
```cpp

```

