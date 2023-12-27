### Q2. IsPrime
#### Problem Description
```text
Given an Integer A. Return 1 if A is prime and return 0 if not.
```
#### Problem Constraints
* <p>1 &lt;= <strong>A </strong>&lt;= 10<sup>12</sup></p>
```text
1 <= A <= 10^12
```
#### Input Format
```text
The first argument is a single integer A.
```
#### Output Format
```text
Return 1 if A is prime else return 0.
```
#### Example Input
```text
Input 1:
 A = 5

Input 2:
 A = 10
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
    5 is a prime number.
Explanation 2:
    10 is not a prime number.
```
### Hints
* Hint 1
```text
So when is a number prime? When it is not divisible by any integer 
other than 1 and itself.

Now to check if a number is prime or not till which number should we 
check and see if it divides our number N?

Should we check till N-1? or should we check till N/2. or could we 
check even less numbers? Remembers the lesser numbers we check the 
faster our program will be.
```
* Solution Approach
```text
So when is a number prime? When it is not divisible by any integer 
other than 1 and itself.

Now to check if a number is prime or not till which number should we 
check and see if it divides our number N?

Should we check till N-1? or should we check till N/2. or could we 
check even less numbers? 

Remember the lesser numbers we check the faster our program will be.

Well the right answer is we can confirm if the number is prime or not 
by checking upto the numbers floor(sqrt(N)).

Think why this is true.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(Long A) {
        if (A == 1) return 0;
        for (long i = 2; i * i <= A; i++) {
            if (A % i == 0) return 0;
        }
        return 1;
    }
}
```
* * Solution in Javascript
```javascript

```
* * Solution in C++
```cpp
int Solution::solve(long A){
    if(A==1)return 0;
    for(long i=2;i*i<=A;i++)if(A%i==0)return 0;
    return 1;
}
```

