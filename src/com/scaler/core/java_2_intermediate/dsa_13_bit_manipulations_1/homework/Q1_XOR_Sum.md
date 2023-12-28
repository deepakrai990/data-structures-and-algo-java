### Q1. XOR Sum
#### Problem Description
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    Given two integers A and B. Find the 
    minimum value (A ⊕ X) + (B ⊕ X) that can be achieved for 
    any X.<br><br>
    where P ⊕ Q is the 
    <a href="https://en.wikipedia.org/wiki/Bitwise_operation#XOR">bitwise XOR</a> 
    operation of the two numbers P and Q.
</div>

```text
Given two integers A and B. Find the minimum 
value (A ⊕ X) + (B ⊕ X) that can be achieved for any X.

where P ⊕ Q is the bitwise XOR operation of the two 
numbers P and Q.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    1 &lt;= A, B &lt;= 10<sup>9</sup>
</div>

```text
1 <= A, B <= 10^9
```
#### Input Format
```text
The first argument is a single integer A.
The second argument is a single integer B.
```
#### Output Format
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    Return the minimum value (A ⊕ X) + (B ⊕ X) that can be 
    achieved for any X.
</div>

```text
Return the minimum value (A ⊕ X) + (B ⊕ X) that can be achieved for any X.
```
#### Example Input
```text
Input 1:-
 A = 6
 B = 12

Input 2:-
 A = 4
 B = 9
```
#### Example Output
```text
Output 1:-
 10

output 2:-
 13
```
#### Example Explanation
```text
Explanation 1:-
    X ^ A + X ^ B = 10 when X = 4

Explanation 2:-
    X ^ A + X ^ B = 13 when X = 0
```
### Hints
* Hint 1
```text
We can choose any X. So lets try to choose optimally. Say for 
any i th bit in binary values of A and B, the bit is 
set for both A and B.

Then we can also set it in X such that XOR with both becomes 0.

Similarly, if for both A and B the bit was unset, we unset it 
for X as well. XOR of that bit remains 0.

Now try to think if the bit is set for one and unset for other 
what will X and our result be.
```
* Solution Approach
```text
We can choose any X. So lets try to choose optimally. Say for 
any i th bit in binary values of A and B, the bit is set 
for both A and B.

Then we can also set it in X such that XOR with both becomes 0.

Similarly, if for both A and B the bit was unset, we unset it 
for X as well. XOR of that bit remains 0.

Now try to think if the bit is set for one and unset for other 
what will X and our result be.

That's right doesnt matter if the bit is set or unset that bit 
will be added to our answer 
as either A ^ X != 0 or B ^ X != 0 for that bit.

Now did you take the observation? If we are adding a bit to 
out answer if that bit is set for one number and unset for 
another, then it is A ^ B operation itself. So A ^ B is 
our answer.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int A, int B) {
        return A ^ B;
    }
}
```
* * Solution in Javascript
```javascript
/** Not available **/
```
* * Solution in C++
```cpp
int Solution::solve(int A, int B) {
    return A^B;
}
```

