### Q3. Array with consecutive elements
#### Problem Description
```text
Given an array of positive integers A, check and return whether the array elements 
are consecutive or not.

NOTE: Try this with O(1) extra space.
```
#### Problem Constraints
```text
1 <= length of the array <= 100000
1 <= A[i] <= 10^9
```
#### Input Format
```text
The only argument given is the integer array A.
```
#### Output Format
```text
Return 1 if the array elements are consecutive else return 0.
```
#### Example Input
```text
Input 1:
 A = [3, 2, 1, 4, 5]

Input 2:
 A = [1, 3, 2, 5]
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
    As you can see all the elements are consecutive, so we return 1.

Explanation 2:
    Element 4 is missing, so we return 0.
```
### Hints
* Hint 1
```text
Try Sorting the given array.

Now you need to check if the adjacent elements have an absolute difference 1.
```
* Solution Approach
```text
We can check that if we sort the array in increasing order, the prev element should be 
less than the current one.

If this condition satisfies for the whole array, then we return 1 else, return 0.

NOTE: Array doesn’t need to start with 1.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(ArrayList < Integer > A) {
        // sort the given array
        Collections.sort(A);
        int minn = A.get(0);
        // check if the elements are consecutive
        for (int x: A) {
            if (x != minn)
                return 0;
            minn++;
        }
        return 1;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    solve: function (A) {
        if (A.length <= 1) return 1;
        // sort the given array
        A.sort((a, b) => a - b);
        // check if the elements are consecutive
        for (let i = 1; i < A.length; i++) {
            if (A[i - 1] != A[i] - 1) return 0;
        }
        return 1;
    },
};
```
* * Solution in C++
```cpp
int Solution::solve(vector < int > & A) {
    int n = A.size();
    int prev;
    // sort the given array
    sort(A.begin(), A.end());
    // check if the elements are consecutive
    for (int i = 0; i < n; i++) {
        if (i == 0)
            prev = A[i];
        else if (A[i] != prev + 1)
            return 0;
        prev = A[i];
    }
    return 1;
}
```

