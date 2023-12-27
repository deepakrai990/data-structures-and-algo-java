### Q5. Power function
#### Problem Description
```text
You are given two integers A and B.
```
<p>You have to find the value of <strong>A<sup>B</sup></strong>.</p>
<p>
    <strong>NOTE:</strong> The value of answer is always less than or 
    equal to <strong>10<sup>9</sup></strong>.
</p>

#### Problem Constraints
```text
1 <= A, B <= 1000
```
#### Input Format
```text
First parameter is an integer A.

Second parameter is an integer B.
```
#### Output Format
```text
Return an integer.
```
#### Example Input
```text
Input 1:
 A = 2
 B = 3 

Input 2:
 A = 1
 B = 10 
```
#### Example Output
```text
Output 1:
 8 

Output 2:
 1 
```
#### Example Explanation
```text
Explanation 1:
 For A = 2 and B = 3, the value of 23 = 2 * 2 * 2 = 8. 

Explanation 2:
 For A = 1 and B = 10, the value of 110 = 1.
```
### Hints
* Hint 1
```text
The ** operator in python is used to raise a number A to the power of B.
```
* Solution Approach
```text
Return A ** B.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int power(final int A, final int B) {
        int ans = 1;
        // Loop from 1 to B and each time multiply A by ans
        for (int i = 1; i <= B;i++){
            ans *= A;
        }
        return ans;
    }
}
```
* * Solution in Javascript
```javascript

```
* * Solution in C++
```cpp
int Solution::power(const int A, const int B) {
    int ans = 1;
    // Loop from 1 to B and each time multiply A by ans
    for (int i = 1; i <= B;i++){
        ans *= A;
    }
    return ans;
}
```

