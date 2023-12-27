### Q3. Kth Symbol - Hard
#### Problem Description
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>On the first row, we write a <code>0</code>. Now in 
    every subsequent row, we look at the previous row and 
    replace each occurrence of <code>0</code> 
    with <code>01</code>, and each occurrence of <code>1</code> 
    with <code>10</code>.</p>
    <p>Given row number <strong>A</strong> and index 
    <strong>B</strong>, return the 
    <strong>B<sup>th</sup></strong> indexed symbol in 
    row <strong>A</strong>. (The values of 
    <strong>B</strong> are 0-indexed.).
    </p>
</div>

```text
On the first row, we write a 0. Now in every subsequent 
row, we look at the previous row and replace each occurrence 
of 0 with 01, and each occurrence of 1 with 10.

Given row number A and index B, return the B^th indexed 
symbol in row A. (The values of B are 0-indexed.).
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= A &lt;= 10<sup>5</sup></p><p></p><p></p><p></p>
    <p>0 &lt;= B &lt;= min(2<sup>A - 1</sup> - 1 , 10<sup>18</sup>)</p>
</div>

```text
1 <= A <= 10^5

0 <= B <= min(2^(A - 1) - 1 , 10^18)
```
#### Input Format
```text
First argument is an integer A.

Second argument is an integer B.
```
#### Output Format
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>Return an integer denoting the 
    <strong>B<sup>th</sup></strong> indexed symbol in row 
    <strong>A</strong>.</p>
</div>

```text
Return an integer denoting the B^th indexed symbol in row A.
```
#### Example Input
```text
Input 1:
 A = 3
 B = 0

Input 2:
 A = 4
 B = 4
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
    Row 3: 0110

Explanation 2:
    Row 1: 0
    Row 2: 01
    Row 3: 0110
    Row 4: 01101001
```
### Hints
* Hint 1
```text
When
A = 1 -> 0
A = 2 ->01
A = 3 ->0110
```

<p>As we can see that there are two part in string (when A&gt;=2)<br>
first part is repeating of (A-1)<sup>th</sup> step and 
second part is also compliment of (A-1)th step</p>

* Solution Approach
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>When<br>
    A = 1 -&gt; 0<br>
    A = 2 -&gt;01<br>
    A = 3 -&gt;0110</p>
    <p>As we can see that there are two part in 
    string (when A&gt;=2)<br>
    first part is repeating of (A-1)<sup>th&gt;</sup> 
    step and second part is also compliment of (A-1)th step</p>
    <p>for A = 3 -&gt; first part - 01 ( it is same 
    as when A == 2) second part- 10 ( compliment of 
    when A == 2)</p>
    <p>We know that on every expansion, the length of 
    String is <strong>2<sup>(A-1)</sup></strong></p>
    <p>so what we can do when B value is &lt;= mid we 
    can search the result in first part 
    of (A-1)<sup>th</sup> step solve(A-1, B)</p>
    <p>and when B &gt; mid we can search the result 
    in (A-1)<sup>th</sup> step but compliment of that 
    index to get the actual index in 1st part we have 
    to do <strong>B - mid</strong>.</p>
</div>

* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int find(int n, long k) {
        if (k == 0) {
            return 0;
        }
        int val = find(n - 1, k / 2);
        if (k % 2 == 0) {
            return val;
        }
        return 1 - val;
    }

    public int solve(int A, long B) {
        return find(A, B);
    }
}
```
* * Solution in Javascript
```javascript
/** Not available **/
```
* * Solution in C++
```cpp
int find(int n, long k){
 	if(k==0){
		return 0;
 	}
	int val = find(n- 1 , k / 2);
	if(k % 2 == 0){
		return val;
	}
	return 1 - val;
}
int Solution::solve(int A, long B) {
	return find(A, B);
}
```

