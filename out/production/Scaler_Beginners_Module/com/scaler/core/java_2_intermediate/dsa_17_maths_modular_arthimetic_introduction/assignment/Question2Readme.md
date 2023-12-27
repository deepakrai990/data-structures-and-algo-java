### Q2. Mod Array
#### Problem Description
```text
You are given a large number in the form of a array A of 
size N where each element denotes a digit of the number.

You are also given a number B. You have to find out the 
value of A % B and return it.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    1 &lt;= N &lt;= 10<sup>5</sup><br> 
    0 &lt;= A<sub>i</sub> &lt;= 9<br> 
    1 &lt;= B &lt;= 10<sup>9</sup>
</div>

```text
1 <= N <= 10^5
0 <= Ai <= 9
1 <= B <= 10^9
```
#### Input Format
```text
The first argument is an integer array A.
The second argument is an integer B.
```
#### Output Format
```text
Return a single integer denoting the value of A % B.
```
#### Example Input
```text
Input 1:
 A = [1, 4, 3]
 B = 2

Input 2:
 A = [4, 3, 5, 3, 5, 3, 2, 1]
 B = 47
```
#### Example Output
```text
Output 1:
 1

Output 2:
 20
```
#### Example Explanation
```text
Explanation 1:
    143 is an odd number so 143 % 2 = 1.

Explanation 2:
    43535321 % 47 = 20
```
### Hints
* Hint 1
```text
How can you use the distributive properties of modular arithmetic 
to solve this problem?
```
* Solution Approach
```text
We can use the two following properties:

    * (a * b) mod x = [(a mod x) * (b mod x)] mod x

    * (a + b) mod x = [(a mod x) + (b mod x)] mod x


We can represent a 
number [a, b, c, d] as (a * 1000) + (b * 100) + (c * 10) + (d * 1).

We can use the above properties of modular arithmetic to 
solve the problem.

We will iterate from the end of the array (least significant digit).

We will keep a variable that will store the values of powers 
of 10 modulo B at every step.

Then, we will perform the operations accordingly.

Be careful of integer overflows.

Refer to the complete solution for more implementation details.

Time Complexity : O(N)
Space Complexity : (1)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int[] A, int B) {
        long ans = 0;
        long mod = B;
        int n = A.length;
        long curr = 1;
        for (int i = n - 1; i >= 0; i--) {
            long dig = A[i];
            long term = (dig * curr) % mod;
            ans = (ans + term) % mod;
            curr = (curr * 10) % mod;
        }
        return (int) ans;
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
    long ans = 0;
    long mod = B;
    int n = A.size();
    long curr = 1;
    for(int i = n - 1; i >= 0; i--){
        long dig = A[i];
        long term = (dig * curr) % mod;
        ans = (ans + term) % mod;
        curr = (curr * 10) % mod;
    }
    return (int)ans;
}
```

