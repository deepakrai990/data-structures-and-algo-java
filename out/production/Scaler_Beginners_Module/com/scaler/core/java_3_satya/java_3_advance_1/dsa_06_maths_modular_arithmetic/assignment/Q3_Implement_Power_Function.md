### Q3. Implement Power Function
#### Problem Description
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    Implement <strong>pow(A, B) % C</strong>.
    <p>In other words, given <strong>A</strong>, 
    <strong>B</strong> and <strong>C</strong>, <strong>
    Find (A<sup>B</sup> % C).</strong></p>
    <p><strong>Note:</strong> The remainders on division 
    cannot be negative. In other words, make sure the 
    answer you return is non-negative.</p>
</div>

```text
Implement pow(A, B) % C.
In other words, given A, B and C, Find (A^B % C).

Note: The remainders on division cannot be negative. In 
other words, make sure the answer you return is non-negative.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    -10<sup>9</sup> &lt;= A &lt;= 10<sup>9</sup><br>
    0 &lt;= B &lt;= 10<sup>9</sup><br>
    1 &lt;= C &lt;= 10<sup>9</sup>
</div>

```text
-10^9 <= A <= 10^9
0 <= B <= 10^9
1 <= C <= 10^9
```
#### Input Format
```text
Given three integers A, B, C.
```
#### Output Format
```text
Return an integer.
```
#### Example Input
```text
Input 1:
 A = 2, B = 3, C = 3
```
#### Example Output
```text
Output 1:
 2
```
#### Example Explanation
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    2<sup>3</sup> % 3 = 8 % 3 = 2
</div>

```text
2^3 % 3 = 8 % 3 = 2
```
### Hints
* Hint 1
```text
You need to develop a solution better than O(n).

Think recursively. You can think of an example like 2^8. 
How many multiplications do you really need to evaluate 2^8?
```
* Solution Approach
```text
There are two important things to note here:

1) Overflow situation: Note that if x is large 
enough, multiplying x to the answer might 
overflow in integer.

2) Multiplying x one by one to the answer is O(n). We 
are looking for something better than O(n).

If n is even, note the following:

x ^ n = (x * x) ^ n/2

Can you use the above observation to develop a 
solution better than O(n)?
```
* Complete Solution
* * Solution in Java
```java
/** Method 1: **/
public class Solution {
	public int pow(int x, int n, int d) {
	    long a = x;
	    long res = 1L;
	    while (n > 0) {
	        if (n % 2 == 1) {
	            res *= a;
	            res %= d;
	        }
	        a *= a;
	        a %= d;
	        n = n >> 1;
	    }
	    res = (res + d) % d;
	    return (int) res;
	}
}

/** Method 2: **/
public class Solution {
    public int pow(int A, int B, int C) {
        if(A == 0)
            return 0;
        if(B == 0)
            return 1;
        long ans = pow(A, B / 2, C);
        ans = (ans * ans) % C;
        if(B % 2 == 1)
            ans = (ans * A);
        ans = (ans + C) % C;
        return (int)ans;
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
    pow: function (A, B, C) {

        if (B == 0) return 1 % C;
        let ans = 1n, base = BigInt(A), c1 = BigInt(C);

        while (B > 0) {
               
            if (B % 2 == 1) {
                ans = (ans * base) % c1;
                B--;
            } else {

                base = (base * base) % c1;
                B /= 2;
            }

        }
        if (ans < 0) ans = (ans + c1) % c1;
        return Number(ans);
    }
};
```
* * Solution in C++
```cpp
/** O(log n) solution: Method 1: **/

int Solution::pow(int x, int n, int p) {
    if (n == 0) return 1 % p;
    long long ans = 1, base = x;
    while (n > 0) {
        // We need (base ** n) % p. 
        // Now there are 2 cases. 
        // 1) n is even. Then we can make base = base^2 and n = n / 2.
        // 2) n is odd. So we need base * base^(n-1) 
        if (n % 2 == 1) {
            ans = (ans * base) % p;
            n--;
        } else {
            base = (base * base) % p;
            n /= 2;
        }
    }
    if (ans < 0) ans = (ans + p) % p;
    return ans;
}

Method 2:
int Solution::pow(int A, int B, int C) {
    if(A == 0)
        return 0;
    if(B == 0)
        return 1;
    long long ans = pow(A, B / 2, C);
    ans = (ans * ans) % C;
    if(B % 2 == 1)
        ans = (ans * A) % C;
    ans = (ans + C) % C;
    return ans;
}
```

