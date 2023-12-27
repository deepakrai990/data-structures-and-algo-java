### Q2. Count of primes
#### Problem Description
```text
You will be given an integer n. You need to return the count of 
prime numbers less than or equal to n.
```
#### Problem Constraints
* <p>0 &lt;= n &lt;= 10<sup>3</sup></p>
```text
0 <= n <= 10^3
```
#### Input Format
```text
Single input parameter n in function.
```
#### Output Format
```text
Return the count of prime numbers less than or equal to n.
```
#### Example Input
```text
Input 1: 
 19

Input 2: 
 1
```
#### Example Output
```text
Output 1: 
 8

Output 2: 
 0
```
#### Example Explanation
```text
Explanation 1: 
    Primes <= 19 are 2, 3, 5, 7, 11, 13, 17, 19

Explanation 2: 
    There are no primes <= 1
```
### Hints
* Hint 1
```text
Prime numbers are those numbers which have exactly 2 factors.
```
* Solution Approach
```text
Prime numbers are positive numbers divisible by only 1 and itself
To check for primality of any number x iterate through all numbers 
from 1 to x and for each check the number of its factors. If the 
numbers of factors is 2 increment count of prime numbers.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int A) {
        int cnt = 0;
        // Looping from 1 to A
        for(int i=1 ; i<=A ; i++){
            int factors = 0;
            // Looping from 1 to i
            for(int j=1;j<=i;j++) {
                if(i%j==0){
                    factors++;
                }
            }
            if(factors==2) {
                cnt++;
            }
        }
        return cnt;
    }
}
```
* * Solution in Javascript
```javascript
/** Not available **/
```
* * Solution in C++
```cpp
int Solution::solve(int A) {
    int cnt = 0;
    // Looping from 1 to A
    for(int i=1 ; i<=A ; i++){
        int factors = 0;
        // Looping from 1 to i
        for(int j=1;j<=i;j++) {
            if(i%j==0){
                factors++;
            }
        }
        if(factors==2) {
            cnt++;
        }
    }
    return cnt;
}
```

