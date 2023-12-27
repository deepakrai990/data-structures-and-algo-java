### Q2. Largest Coprime Divisor
#### Problem Description
```text
You are given two positive numbers A and B . You need to 
find the maximum valued integer X such that:

    *  X divides A i.e. A % X = 0
    *  X and B are co-prime i.e. gcd(X, B) = 1
```

#### Problem Constraints
* <p>1 &lt;= A, B &lt;= 10<sup>9</sup></p>
```text
1 <= A, B <= 10^9
```
#### Input Format
```text
First argument is an integer A.
Second argument is an integer B.
```
#### Output Format
```text
Return an integer maximum value of X as described above.
```
#### Example Input
```text
Input 1:
 A = 30
 B = 12

Input 2:
 A = 5
 B = 10
```
#### Example Output
```text
Output 1:
 5
 
Output 2:
 1
```
#### Example Explanation
```text
Explanation 1:

 All divisors of A are (1, 2, 3, 5, 6, 10, 15, 30). 
 The maximum value is 5 such that A%5 == 0 and gcd(5,12) = 1

Explanation 2:

 1 is the only value such that A%5 == 0 and gcd(1,10) = 1
```
### Hints
* Hint 1
```text
We know A is the greatest number dividing A. So if A and B 
are coprime, we can return the value of X to be A. Else, we 
can try to remove the common factors of A and B from A.

Given this hint, how would you think of the solution?
```
* Solution Approach

<div><p>We can try to remove the common factors of 
<strong>A</strong> and <strong>B</strong> from 
<strong>A</strong> by finding the greatest common 
divisor (gcd) of <strong>A</strong> and 
<strong>B</strong> and dividing 
<strong>A</strong> with that gcd.</p>
<ul>
  <li>Mathematically, <strong>A</strong> = 
<strong>A</strong> / gcd(<strong>A</strong>, 
<strong>B</strong>) —— <em>STEP1</em></li>
</ul>
<p>Now, we repeat <em>STEP1</em> till we get 
gcd(<strong>A</strong>, <strong>B</strong>) = 1.<br>
Atlast, we return <strong>X</strong> = 
<strong>A</strong></p>
<p><em>How does this work ?</em></p>
<p>On doing prime factorization of <strong>A</strong> 
and <strong>B</strong>, we get :</p>
<ul>
  <li><strong>A</strong> = <em>p<sub>1</sub>
    <sup>x<sub>1</sub></sup></em> <strong>.</strong> 
    <em>p<sub>2</sub><sup>x<sub>2</sub></sup></em> 
    <strong>.</strong> …   <strong>.</strong> <em>p
    <sub>k</sub><sup>x<sub>k</sub></sup></em></li>
  <li><strong>B</strong> = <em>q<sub>1</sub><sup>y
    <sub>1</sub></sup></em> <strong>.</strong> <em>q
    <sub>2</sub><sup>y<sub>2</sub></sup></em> 
    <strong>.</strong> … <strong>.</strong> 
    <em>q<sub>l</sub><sup>y<sub>l</sub></sup></em></li>
</ul>
<p>Where p<sub>i</sub> ; i = 1, 2, ..., k are prime factors 
of <strong>A</strong> and x<sup>i</sup> ; i = 1, 2, …, k 
are their respective powers<br>
Similarly, q<sub>j</sub> ; i = 1, 2, ..., l are prime factors 
of <strong>B</strong> and y<sup>i</sup> ; j = 1, 2, …, l are 
their respective powers</p>
<p>Let r<sub>i</sub> ; i = 1, 2, ..., m be the common factors 
of <strong>A</strong> and <strong>B</strong>. By repeating 
<em>STEP1</em>, we are reducing the respective powers of r
<sub>i</sub> by at least one each time (Proof of this is 
left to the reader). Therefore, we reach a point where 
powers of r<sub>i</sub> become zero, and the product of 
the rest prime-powers in <strong>A</strong> form the largest 
divisor of <strong>A</strong> that is co-prime with 
<strong>B</strong>.</p></div>

* Complete Solution
```java
public class Solution {
    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
    public int cpFact(int A, int B) {
        while (gcd(A, B) != 1){
            // dividing A by gcd(A, B)
            A = A / gcd(A, B);
        }
        return A;
    }
}
```

```javascript
function gcd(a, b) {
    return b ? gcd(b, a % b) : a;
}
module.exports = {
    cpFact: function (A, B) {
        let val = gcd(A, B);
        while (val > 1) {
            // dividing A by gcd(A, B)
            A /= val;
            val = gcd(A, B);
        }
        return A;
    },
};
```

```cpp
int Solution::cpFact(int A, int B) {
    while (__gcd(A, B) != 1) {
        // dividing A by gcd(A, B)
        A = A / __gcd(A, B);
    }
    return A;
}
```

