### Q8. Decimal to Any Base
#### Problem Description
```text
Given a decimal number A and base B.

You are required to change the decimal number A into the 
corresponding value in base B and return that.
```
#### Problem Constraints
```text
0 <= A <= 512
2 <= B <= 10
```
#### Input Format
```text
The first argument will be decimal number A.
The second argument will be base B.
```
#### Output Format
```text
Return the conversion of A in base B.
```
#### Example Input
```text
Input:
 A = 4
 B = 3
```
#### Example Output
```text
Output:
 11
```
#### Example Explanation
```text
Explanation:
 Decimal number 4 in base 3 is 11.
```
### Hints
* Hint 1
```text
Repeatedly divide A by the base B and note the remainders at each step.
```
* Solution Approach
```text
Step 1:- Divide the decimal number to be converted by the value 
         of the new base.

Step 2:- Get the remainder from Step 1 as the rightmost 
         digit (least significant digit) of new base number.

Step 3:− Divide the quotient of the previous divide by the new base.

Step 4 − Record the remainder from Step 3 as the next 
         digit (to the left) of the new base number.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int DecimalToAnyBase(int A, int B) {
        int ans = 0;
        int pow = 1;
        while(A > 0){
            int digit = A%B;
            A /= B;
            ans += digit*pow;
            pow *= 10;
        }
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
/** Not available **/
```
* * Solution in C++
```cpp
int Solution::DecimalToAnyBase(int A, int B) {
    assert(A>=0 and A<=512);
    assert(B>=2 and B<=10);
    int pow = 1;
    int ans = 0;
    while(A>0){
        int digit = A%B;
        ans += digit*pow;
        pow = pow*10;
        A = A/B;
    }
    return ans;
}
```

