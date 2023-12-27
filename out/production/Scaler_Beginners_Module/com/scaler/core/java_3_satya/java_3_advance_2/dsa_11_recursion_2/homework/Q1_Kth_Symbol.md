### Q1. Kth Symbol
#### Problem Description
```text
On the first row, we write a 0. Now in every subsequent row, we look at the previous row and 
replace each occurrence of 0 with 01, and each occurrence of 1 with 10.

Given row number A and index B, return the B^th indexed symbol in row A. (The values of B are 1-indexed.).
```
<div id="problem_description_markdown_content_value" style="background-color: 
#f9f9f9; padding: 5px 10px; "><p>On the first row, we write a <code>0</code>. 
Now in every subsequent row, we look at the previous row and replace each occurrence of <code>0</code> 
with <code>01</code>, and each occurrence of <code>1</code> with <code>10</code>.</p>
<p>Given row number <strong>A</strong> and index <strong>B</strong>, return the 
<strong>B<sup>th</sup></strong> indexed symbol in row <strong>A</strong>. 
(The values of <strong>B</strong> are 1-indexed.).</p>
</div>

#### Problem Constraints

<div id="problem_constraints_markdown_content_value" 
style="background-color: #f9f9f9; padding: 5px 10px; "><p>1 &lt;= A &lt;= 20</p>
<p>1 &lt;= B &lt;= 2<sup>A - 1</sup></p>
</div>

```text
1 <= A <= 20

1 <= B <= 2^(A - 1)
```
#### Input Format
```text
First argument is an integer A.

Second argument is an integer B.
```
#### Output Format

<div id="output_format_markdown_content_value" style="background-color: 
#f9f9f9; padding: 5px 10px; "><p>Return an integer denoting the <strong>B<sup>th</sup></strong> 
indexed symbol in row <strong>A</strong>.</p>
</div>

```text
Return an integer denoting the B^th indexed symbol in row A.
```
#### Example Input
```text
Input 1:
 A = 2
 B = 1

Input 2:
 A = 2
 B = 2
```
#### Example Output
```text
Output 1:
 0

Output 2:
 1
```
#### Example Explanation
```text
Explanation 1:
 Row 1: 0
 Row 2: 01

Explanation 2:
 Row 1: 0
 Row 2: 01
```
### Expected Output
```text
Provide sample input and click run to see the correct output for the provided input. 
Use this to improve your problem understanding and test edge cases
```

### Hints
* Hint 1
```text
When
A = 1 -> 0
A = 2 ->01
A = 3 ->0110

As we can see that there are two part in string (when A>=2)
first part is repeating of (A-1)^th step and second part is also compliment of (A-1)th step
```
* Solution Approach

<div class="html-content__container cr-p-hint-modal__content">
<p>When<br>
A = 1 -&gt; 0<br>
A = 2 -&gt;01<br>
A = 3 -&gt;0110</p>
<p>As we can see that there are two part in string (when A&gt;=2)<br>
first part is repeating of (A-1)<sup>th&gt;</sup> step and second part is also compliment of (A-1)th step</p>
<p>for A = 3 -&gt; first part - 01 ( it is same as when A == 2) second part- 10 ( compliment of when A == 2)</p>
<p>We know that on every expansion, the length of String is <strong>2<sup>(A-1)</sup></strong></p>
<p>so what we can do when B value is &lt;= mid we can search the result in first part of (A-1)<sup>th</sup> step solve(A-1, B)</p>
<p>and when B &gt; mid we can search the result in (A-1)<sup>th</sup> step but compliment of that index to get 
the actual index in 1st part we have to do <strong>B - mid</strong>.</p>
</div>

```text
When
A = 1 -> 0
A = 2 ->01
A = 3 ->0110

As we can see that there are two part in string (when A>=2)
first part is repeating of (A-1)^th> step and second part is also compliment of (A-1)th step

for A = 3 -> first part - 01 ( it is same as when A == 2) second part- 10 ( compliment of when A == 2)

We know that on every expansion, the length of String is 2^(A-1)

so what we can do when B value is <= mid we can search the result in first part of (A-1)^th step solve(A-1, B)

and when B > mid we can search the result in (A-1)^th step but compliment of that index to get the actual index in 1st part we have to do B - mid.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int A, int B) {
        return solveQ(A, B) ? 1 : 0;
    }
    static boolean solveQ(int n, int k) {

        if (n == 1 && k == 1)
            return false;

        int mid = (int) Math.pow(2, n - 1) / 2;

        if (k <= mid)
            return solveQ(n - 1, k);
        else
            return !solveQ(n - 1, k - mid);
    }
}
```
* * Solution in Javascript
```javascript
/** Not available **/
```
* * Solution in C++
```cpp
int kthGrammar(int N, int K) {

  // Base Case

  if (N == 1) {
    return 0;
  }
  int n = pow(2, N - 1);
  int flag;
  // hypothesis design
  if (K <= n / 2) {
    flag = 0;
  } else {
    flag = 1;
    K = K - (n / 2);
  }
  // induction
  int ans = kthGrammar(N - 1, K);
  return (flag == 0) ? ans : !(ans);
}
int Solution::solve(int A, int B) {
  return kthGrammar(A, B);
}
```

