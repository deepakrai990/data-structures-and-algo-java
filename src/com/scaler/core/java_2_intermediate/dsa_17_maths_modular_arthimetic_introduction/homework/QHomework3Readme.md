### Q3. Concatenate Three Numbers
#### Problem Description
```text
Given three 2-digit integers, A, B, and C, find out the minimum 
number obtained by concatenating them in any order.

Return the minimum result obtained.
```
#### Problem Constraints
```text
10 <= A, B, C <= 99
```
#### Input Format
```text
The first argument of input contains an integer, A.

The second argument of input contains an integer, B.

The third argument of input contains an integer, C.
```
#### Output Format
```text
Return an integer representing the answer.
```
#### Example Input
```text
Input 1:
 A = 10
 B = 20
 C = 30

Input 2:
 A = 55
 B = 43
 C = 47 
```
#### Example Output
```text
Output 1:
 102030 

Output 2:
 434755 
```
#### Example Explanation
```text
Explanation 1:
 10 + 20 + 30 = 102030 

Explanation 2:
 43 + 47 + 55 = 434755 
```
### Hints
* Hint 1
```text
There are only 3! = 6 ways of arranging the numbers.

You can generate and compare all.

The general solution is easy to see though.
```
* Solution Approach
```text
The minimum number will always be formed if the smallest 
number is taken first, the second smallest is taken second, and 
the largest is taken last.

This will be true only if the numbers have the same length.

So, you can also sort the numbers and concatenate them to 
get the answer.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int A, int B, int C) {
        int a[] = {A, B, C};
        Arrays.sort(a);
        return 10000*a[0] + 100*a[1] + a[2];
    }
}
```
* * Solution in Javascript
```javascript
module.exports = { 
    //param A : integer
    //param B : integer
    //param C : integer
    //return an integer
	solve : function(A, B, C){
        if(A <= B && B <= C)
            return A*10000 + B*100 + C;
        else if(A <= C && C <= B)
            return A*10000 + C*100 + B;
        else if(B <= A && A <= C)
            return B*10000 + A*100 + C;
        else if(B <= C && C <= A)
            return B*10000 + C*100 + A;
        else if(C <= A && A <= B)
            return C*10000 + A*100 + B;
        else
            return C*10000 + B*100 + A;
	}
};
```
* * Solution in C++
```cpp
int Solution::solve(int A, int B, int C) {
    if(A <= B and B <= C)
        return A*10000 + B*100 + C;
    else if(A <= C and C <= B)
        return A*10000 + C*100 + B;
    else if(B <= A and A <= C)
        return B*10000 + A*100 + C;
    else if(B <= C and C <= A)
        return B*10000 + C*100 + A;
    else if(C <= A and A <= B)
        return C*10000 + A*100 + B;
    else
        return C*10000 + B*100 + A;
}
```

