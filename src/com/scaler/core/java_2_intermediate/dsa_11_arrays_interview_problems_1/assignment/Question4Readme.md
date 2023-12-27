### Q4. Josephus Problem - 2
#### Problem Description
```text
There are A people standing in a circle. Person 1 kills 
their immediate clockwise neighbour and pass the knife 
to the next person standing in circle. This process continues 
till there is only 1 person remaining. Find the last person 
standing in the circle.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    1 &lt;= A &lt;= 10<sup>5</sup>
</div>

```text
1 <= A <= 10^5
```
#### Input Format
```text
First argument A is an integer.
```
#### Output Format
```text
Return an integer.
```
#### Example Input
```text
Input 1:
 A = 4

Input 2:
 A = 5
```
#### Example Output
```text
Output 1:
 1

Output 2:
 3
```
#### Example Explanation
```text
For Input 1:
    Firstly, the person at position 2 is killed, then the person at 
    position 4 is killed, then the person at position 3 is killed. So 
    the person at position 1 survives. 
    
For Input 2: 
    Firstly, the person at position 2 is killed, then the person at 
    position 4 is killed, then the person at position 1 is killed. 
    Finally, the person at position 5 is killed. 
    So the person at position 3 survives. 
```
### Hints
* Hint 1
```text
For different values of A can you find a pattern here?
Try to find a general expression for all values of A. 
```
* Solution Approach
```text
For A = 1, 2, 4, 8,... the answer is always 1.

If A is a true power of 2 then the answer is always 1. 

For every A greater than that power of 2 the answer is 
incremented by 2.   

Time Complexity : O(logA)
Space Complexity : O(1)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int msbPos(int n){
        int pos = 0;
        while (n != 0) {
            pos++;
            n = n / 2;
        }
        return pos;
    }
    public int solve(int A) {
        int position = msbPos(A);
        int j = (int)Math.pow(2, (position - 1));
        A = A - j;
        A = A * 2;
        A = A + 1;
        return A;
    }
}
```
* * Solution in Javascript
```javascript
/** Not available **/
```
* * Solution in C++
```cpp
int msbPos(int n){
    int pos = 0;
    while (n != 0) {
        pos++;
        n = n / 2;
    }
    return pos;
}
int Solution::solve(int A) {
    int position = msbPos(A);
    int j = pow(2, position - 1); 
    A = A - j;
    A *= 2;
    A += 1;
    return A;
}

```

