### Q1. Is magic?
#### Problem Description
```text
Given a number A, check if it is a magic number or not.

A number is said to be a magic number if the sum of its 
digits is calculated till a single digit recursively by 
adding the sum of the digits after every addition. If the 
single digit comes out to be 1, then the 
number is a magic number.
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
The first and only argument is an integer A.
```
#### Output Format
```text
Return an 1 if the given number is magic else return 0.
```
#### Example Input
```text
Input 1:
 A = 83557

Input 2:
 A = 1291
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
    Sum of digits of (83557) = 28
    Sum of digits of (28) = 10
    Sum of digits of (10) = 1. 
    Single digit is 1, so it's a magic number. Return 1.

Explanation 2:
    Sum of digits of (1291) = 13
    Sum of digits of (13) = 4
    Single digit is not 1, so it's not a magic number. Return 0.
```
### Hints
* Hint 1
```text
One approach is to recursively check the sum of digits 
until a single digit is left. 

Now, check if the number is 1, then it is a magic number. Else NOT.
```
* Solution Approach
```text
One approach is to recursively check the sum of 
digits until a single digit is left.

Now, check if the number is 1, then it is a magic number. Else NOT.

Efficient Approach:

There is also a shortcut method to verify Magic Number.
The function will determine if the remainder of dividing 
the input by 9 is 1 or not.

If it is 1, then the number is a magic number.

The divisibility rule of 9 says that a number is divisible 
by 9 if the sum of its digits is also divisible by 9.

Therefore, if a number is divisible by 9, then, 
recursively, all the digit sums are also divisible by 9.

The final digit sum is always 9. An increase of 1 in 
the original number will increase the ultimate value 
by 1, making it 10, and the ultimate sum will be 1, thus 
verifying that it is a magic number.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int A) {
        if(A%9 == 1){
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
	    
	    if( A % 9 == 1)
	        return 1;
	    else 
	        return 0;
	}
};
```
* * Solution in C++
```cpp
int Solution::solve(int A) {
    if(A%9 == 1){
        return 1;
    }
    return 0;
}
```

