### Q3. Prime Addition
#### Problem Description
```text
You are given an even number N and you need to represent the given number as the 
sum of primes. The prime numbers do not necessarily have to be distinct. It is 
guaranteed that at least one possible solution exists.

You need to determine the minimum number of prime numbers needed to represent the 
given number.
```
#### Problem Constraints
```text

```
#### Input Format
```text
The first argument contains an integer N,the number you need to represent (2<=N<=10^9).
```
#### Output Format
```text
Return an integer which is the minimum number of prime numbers needed to represent 
the given number N.
```
#### Example Input
```text
Input
 26
```
#### Example Output
```text
Output
 2
```
#### Example Explanation
```text
Explanation
    You can represent 26 as: 13+13
    So we require minimum of 2 prime numbers to represent the number 26.
```
### Hints
* Hint 1
```text
Try writing down answers for some of even integers, do you see any pattern!
```
* Solution Approach
```text
Goldbach's conjecture states that every even integer greater than 2 can be 
expressed as the sum of two primes.

Bonus : This conjecture is not proven yet but verified until 4*10^18 integers.

And 2 is already a prime number.
```
* Complete Solution
* * Solution in Java
```java
/** Not available **/
```
* * Solution in Javascript
```javascript
/** Not available **/
```
* * Solution in C++
```cpp
int Solution::solve(int A) {
    if(A==2)        // 2 is the only even prime number
     {
      return 1;     
     }
     return 2;
}
```

