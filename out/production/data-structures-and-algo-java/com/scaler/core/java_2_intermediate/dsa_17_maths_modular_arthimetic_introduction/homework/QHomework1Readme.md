### Q1. Leap year? - III
#### Problem Description
```text
Given an integer A representing a year, Return 1 if it 
is a leap year else, return 0.

A year is a leap year if the following conditions are satisfied:

    * The year is multiple of 400.
    * or the year is multiple of 4 and not multiple of 100.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= A &lt;= 10<sup>9</sup></p>
</div>

```text
1 <= A <= 10^9
```
#### Input Format
```text
First and only argument is an integer A
```
#### Output Format
```text
Return 1 if it is a leap year else return 0
```
#### Example Input
```text
Input 1
 A = 2020

Input 2:
 A = 1999
```
#### Example Output
```text
Output 1
 1

Output 2:
 0
```
#### Example Explanation
```text
Explanation 1
 2020 is a leap year.

Explanation 2:
 1999 is not a leap year.
```
### Hints
* Hint 1
```text
Solve it using nested if-else according to the given conditions.
```
* Solution Approach
```text
if the year is divisible by 400, then it is a leap year,
else if the year is divisible by 100, then it is not leap year,
else if the year is divisible by 4, then it is a leap year,
else it is not leap year.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int A) {
        if (A % 400 == 0) {
            return 1;
        }
        if (A % 100 == 0) {
            return 0;
        }
        if (A % 4 == 0) {
            return 1;
        }
        return 0;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = { 
 //param A : integer
 //return an integer
	solve : function(A){
        if(A % 400 == 0)
            return 1;
        if(A % 4 == 0 && A % 100 != 0)
            return 1;
        return 0;
	}
};
```
* * Solution in C++
```cpp
int Solution::solve(int A) {
    if(A%400 == 0){
        return 1;
    }
    if(A%100 == 0){
        return 0;
    }
    if(A%4 == 0){
        return 1;
    }
    return 0;
}
```

