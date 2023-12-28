### Q2. Unset x bits from right
#### Problem Description
```text
Given an integer A. Unset B bits from the right of A in binary.
For eg:-
A = 93, B = 4
A in binary = 1011101
A should become = 1010000 = 80. Therefore return 80.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    1 &lt;= A &lt;= 10<sup>18</sup><br>
    1 &lt;= B &lt;= 60
</div>

```text
1 <= A <= 10^18
1 <= B <= 60
```
#### Input Format
```text
The first argument is a single integer A.
The second argument is a single integer B.
```
#### Output Format
```text
Return the number with B unset bits from the right.
```
#### Example Input
```text
Input 1:-
 A = 25
 B = 3

Input 2:-
 A = 37
 B = 3
```
#### Example Output
```text
Output 1:-
 24

Output 2:-
 32
```
#### Example Explanation
```text
Explanation 1:-
    A = 11001 to 11000

Explanation 2:-
    A = 100101 to 100000
```
### Hints
* Hint 1
```text
Try using for loops iterate from 0 to B-1 and do the needful.
```
* Solution Approach
```text
Try using for loops iterate from 0 to B-1 and do the needful.

Initialise a variable ans = A

Iterate from i = 0 to i = B - 1. If ith bit was set in A that 
is (A & (1<<i)) != 0, ans -= (1<<i), unset it from the answer. 
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public long solve(long A, int B) {
        
        long ans=A;
        for(int i=0;i<B;i++){
            if((A & (1L<<i)) > 0)
               ans -= (1L<<i);
        }
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
/** Not availabe **/
```
* * Solution in C++
```cpp
long Solution::solve(long A, int B) {
    long ans=A;
    for(int i=0;i<B;i++)if(A & (1L<<i)) ans -= (1L<<i);
    return ans;
}
```

