### Q2. Enumerating GCD
#### Problem Description

<div>
You are given a number <strong>A</strong> and a number 
<strong>B</strong>. Greatest Common Divisor (GCD) of all 
numbers between <strong>A</strong> and <strong>B</strong> 
inclusive is taken (GCD<strong>(A, A+1, A+2 ... B)</strong>).
<p> </p>
<p> </p>
<p>As this problem looks a bit easy, it is given that numbers 
<strong>A</strong> and <strong>B</strong> can be in the range 
of <strong>10<sup>100</sup></strong>.</p>
<p>You have to return the value of GCD found.</p>
<p>The greatest common divisor of 2 numbers, A and B, is the 
largest number, D that divides both A and B perfectly.</p>
<p> </p></div>

```text
You are given a number A and a number B. Greatest Common 
Divisor (GCD) of all numbers between A and B inclusive 
is taken (GCD(A, A+1, A+2 ... B)).

As this problem looks a bit easy, it is given that 
numbers A and B can be in the range of 10^100.

You have to return the value of GCD found.

The greatest common divisor of 2 numbers, A and B, is the largest number, 
D that divides both A and B perfectly.
```
#### Problem Constraints
* <p>1 &lt;= A &lt;= B &lt;= 10<sup>100</sup></p>
```text
1 <= A <= B <= 10^100
```
#### Input Format
```text
First argument is a string denoting A.

Second argument is a string denoting B.
```
#### Output Format
```text
Return a string which contains the digits of the integer 
which represents the GCD. The returned string should 
not have any leading zeroes.
```
#### Example Input
```text
Input 1:
 A = "1"
 B = "3"
```
#### Example Output
```text
Output 1:
 1
```
#### Example Explanation
```text
Greatest divisor that divides both 1 and 3 is 1.
```
### Hints
* Hint 1

<p>Both the numbers are given in the form of a string because 
they can go up to 10<sup>100</sup> in size.</p>

<p>10<sup>100</sup> cannot fit in any data type as an actual 
number, so try to find out a way to check what the GCD of 
numbers between <strong>P</strong> and <strong>Q</strong> 
would be, depending on the values of <strong>P</strong> and 
<strong>Q</strong>.</p>

```text
Both the numbers are given in the form of a string because they 
can go up to 10^100 in size.</p>

10^100 cannot fit in any data type as an actual number, so try 
to find out a way to check what the GCD of numbers 
between P and Q would be, depending on the values of P and Q.
```
* Solution Approach
    * <p>There is no point in converting <strong>P</strong> and <strong>Q</strong> to numbers, as they would not fit into a c++ data type, and if it does so (Python), calculating GCD of numbers from a range of 1 to 10<sup>100</sup> would take a very very large amount of time.</p>
    * <p>Instead, the question can be broken down into 2 cases.</p>

```text
Case 1: P == Q
        When P and Q are the same, it is obvious that the greatest divisor is the number itself.

Case 2: P ≠ Q
        When P and Q are not the same, our answer is GCD(P, P+1, P+2, ...., Q)
        But, we know that GCD(P, P+1) is always 1

        Proof:  We know that if a number D divides both A and B, it will also divide abs(A-B)
                Now, if B = A+1, let's assume D to be a number that divides both A and B.
                D should also divide abs(A-B) = abs(A - (A+1)) = 1
                But the only number to perfectly divide 1 is 1 itself. Hence D has to be 1.

        Therefore, if P ≠ Q, the answer is 1.
```
* Complete Solution
```java
public class Solution {
    public String solve(String A, String B) {
        // check if A equals B
        if (A.equals(B))
            return A;
        else 
            return "1";
    }
}
```

```javascript
module.exports = { 
	solve : function(A, B){
	    // check if A equals B
        return A == B ? A : 1;
	}
};
```

```cpp
string Solution::solve(string A, string B) {
    // check if A equals B
    if (A == B)
        return A;
    else
        return "1";
}
```

