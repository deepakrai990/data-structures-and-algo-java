### Q3. Maximum Absolute Difference
#### Problem Description
```text
You are given an array of N integers, A1, A2, .... AN.

Return the maximum value of f(i, j) 
for all 1 ≤ i, j ≤ N. f(i, j) is defined 
as |A[i] - A[j]| + |i - j|, where |x| denotes 
absolute value of x.
```
#### Problem Constraints

* <p>1 &lt;= N &lt;= 100000</p>
* <p>-10<sup>9</sup> &lt;= A[i] &lt;= 10<sup>9</sup></p>

```text
1 <= N <= 100000

-10^9 <= A[i] <= 10^9
```
#### Input Format
```text
First argument is an integer array A of size N.
```
#### Output Format
```text
Return an integer denoting the maximum value of f(i, j).
```
#### Example Input
```text
Input 1:
 A = [1, 3, -1]
 
Input 2:
 A = [2]
```
#### Example Output
```text
Output 1:
 5

Output 2:
 0
```
#### Example Explanation
```text
Explanation 1:

 f(1, 1) = f(2, 2) = f(3, 3) = 0
 f(1, 2) = f(2, 1) = |1 - 3| + |1 - 2| = 3
 f(1, 3) = f(3, 1) = |1 - (-1)| + |1 - 3| = 4
 f(2, 3) = f(3, 2) = |3 - (-1)| + |2 - 3| = 5

 So, we return 5.


Explanation 2:

 Only possibility is i = 1 and j = 1. That gives answer = 0.
```
### Hints
* Hint 1
```text
For two indices, i and j, try to observe how we expand f(i, j).
```
** ** ** <em>Read more about absolute value <a href="https://en.wikipedia.org/wiki/Absolute_value">here</a>.</em>


* Solution Approach
```text
(i, j) = |A[i] - A[j]| + |i - j| can be written in 4 ways (Since we 
are looking at max value, we don’t even care if the value becomes 
negative as long as we are also covering the max value in some way).

(A[i] + i) - (A[j] + j)
-(A[i] - i) + (A[j] - j) 
(A[i] - i) - (A[j] - j) 
(-A[i] - i) + (A[j] + j) = -(A[i] + i) + (A[j] + j)
Note that case 1 and 4 are equivalent and so are case 2 and 3.

We can construct two arrays with values: A[i] + i and A[i] - i. Then, 
for the above 2 cases, we find the maximum value possible. For that, 
we just have to store minimum and maximum values 
of expressions A[i] + i and A[i] - i for all i.
```
* Complete Solution
```java
public class Solution {
    public int maxArr(int[] A) {
    
        int ans = 0, n = A.length; 
        
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++){
            max1 = Math.max(max1, A[i] + i);
            max2 = Math.max(max2, A[i] - i);
            min1 = Math.min(min1, A[i] + i);
            min2 = Math.min(min2, A[i] - i);
        }   
        
        ans = Math.max(ans, max2 - min2);
        ans = Math.max(ans, max1 - min1);
        return ans;
    }
}
```

