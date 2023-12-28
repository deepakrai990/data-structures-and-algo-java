### Q4. Josephus Problem
#### Problem Description
```text
Given the total number of person A and a number B which 
indicates that B-1 persons are skipped and the Bth 
person is killed in a circle. Find the last person 
standing in the circle.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    1 &lt;= A &lt;= 10<sup>4</sup><br>
    2 &lt;= B &lt;= A<br><sup><br></sup>
</div>

```text
1 <= A <= 10^4
2 <= B <= A
```
#### Input Format
```text
First argument A is an integer.
Second argument B is an integer.
```
#### Output Format
```text
Return an integer.
```
#### Example Input
```text
Input 1:
 A = 4
 B = 2

Input 2:
 A = 5
 B = 3
```
#### Example Output
```text
Output 1:
 1

Output 2:
 4
```
#### Example Explanation
```text
For Input 1:
    Firstly, the person at position 2 is killed, then the 
    person at position 4 is killed, then the person at 
    position 3 is killed. So the person at 
    position 1 survives. 

For Input 2:
    Firstly, the person at position 3, then the person 
    at position 1 is killed, then the person at 
    position 5 is killed. Finally, the person at 
    position 2 is killed. 
    
    So the person at position 4 survives. 
```
### Hints
* Hint 1
```text
Since the people are in a circle, can you think 
of some recursive algorithm ?
```
* Solution Approach
```text
After the first person (B-th from the beginning) is killed, 
A-1 persons are left. So we call Josephus(A – 1, B) to get the 
position with A-1 persons. But the position returned by 
Josephus(A – 1, B) will consider the position starting from B % A + 1. 
So, we must make adjustments to the position 
returned by Josephus(A – 1, B). 

Time Complexity : O(A)
Space Complexity : O(A)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int josephus(int n, int k){
        if(n == 1){
            return 1;
        }
        return (josephus(n - 1, k) + k - 1) % n + 1;
    }
    public int solve(int A, int B) {
        return josephus(A,B);
    }
}
```
* * Solution in Javascript
```javascript
/** Not available **/
```
* * Solution in C++
```cpp
int josephus(int n, int k){
    if(n == 1){
        return 1;
    }
    return (josephus(n - 1, k) + k - 1) % n + 1;
}
int Solution::solve(int A, int B) {
	return josephus(A, B);
}
```

