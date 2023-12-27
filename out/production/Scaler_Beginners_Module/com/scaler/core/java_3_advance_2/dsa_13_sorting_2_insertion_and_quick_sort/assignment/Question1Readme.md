### Q1. Unique Elements
#### Problem Description
```text
You are given an array A of N elements. You have to make all elements unique. To do so, in one step you can increase any number by one.

Find the minimum number of steps.
```
#### Problem Constraints
* <p>1 &lt;= N &lt;= 10<sup>5</sup></p>
* <p>1 &lt;= A[i] &lt;= 10<sup>9</sup></p>
```text
1 <= N <= 10^5
1 <= A[i] <= 10^9
```
#### Input Format
```text
The only argument given is an Array A, having N integers.
```
#### Output Format
```text
Return the minimum number of steps required to make all elements unique.
```
#### Example Input
```text
Input 1:
 A = [1, 1, 3]

Input 2:
 A = [2, 4, 5]
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
    We can increase the value of 1st element by 1 in 1 step and will get all unique elements. i.e [2, 1, 3].

Explanation 2:
    All elements are distinct.
```
### Hints
* Hint 1
```text
The task is to make all the array elements unique, which 
needs to be done optimally in the minimum number of steps.
Is there any way that sorting can help?
```
* Solution Approach
```text
The task is to make all the array elements unique, which 
needs to be done optimally in the minimum number of steps.

Sort the Array and then start the traversing from the 2nd element.

If the current element is the same as the previous one, then 
make this element equal to (previous + 1) and count the steps.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int[] A) {
        int n = A.length;
        // sort the array
        Arrays.sort(A);
        // initialize variables
        int steps = 0, i = 1, j = 0;
        // loop unitil you reach the end
        while (j < n) {
            // make current element unique
            if (i >= A[j]) {
                steps += (i - A[j++]);
                i += 1;
            } else {
                i = A[j] + 1;
                j += 1;
            }
        }
        // return the answer
        return steps;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    solve: function (A) {
        // sort the array
        A.sort((a, b) => a - b);
        // initialize variables
        let mn = 1,
            ans = 0;
        // loop unitil you reach the end
        A.forEach((ele) => {
            // make current element unique
            if (ele < mn) 
                ans += mn - ele;
            else 
                mn = ele;
            mn++;
        });
        // return the answer
        return ans;
    },
};
```
* * Solution in C++
```cpp
int Solution::solve(vector < int > & A) {
    int n = A.size();
    // sort the array
    sort(A.begin(), A.end());
    // initialize variables
    int steps = 0, i = 1, j = 0;
    // loop unitil you reach the end
    while (j < n) {
        // make current element unique
        if (i >= A[j]) {
            steps += (i - A[j++]);
            i++;
        } else {
            i = A[j] + 1;
            j++;
        }
    }
    // return the answer
    return steps;
}
```

