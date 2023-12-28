### Q4. Colorful Number
#### Problem Description
```text
Given a number A, find if it is COLORFUL number or not.

If number A is a COLORFUL number return 1 else, return 0.

What is a COLORFUL Number:

A number can be broken into different consecutive 
sequence of digits. 

The number 3245 can be broken into sequences 
like 3, 2, 4, 5, 32, 24, 45, 324 and 245. 

This number is a COLORFUL number, since the product of 
every consecutive sequence of digits is different
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= A &lt;= 2 * 10<sup>9</sup></p>
</div>

```text
1 <= A <= 2 * 10^9
```
#### Input Format
```text
The first and only argument is an integer A.
```
#### Output Format
```text
Return 1 if integer A is COLORFUL else return 0.
```
#### Example Input
```text
Input 1:
 A = 23

Input 2:
 A = 236
```
#### Example Output
```text
Output 1:
 1

Output 2:
 0
```
#### Example Explanation
```text
Explanation 1:
    Possible Sub-sequences: [2, 3, 23] where
    2 -> 2 
    3 -> 3
    23 -> 6  (product of digits)
    
    This number is a COLORFUL number since product of 
    every digit of a sub-sequence are different. 

Explanation 2:
    Possible Sub-sequences: [2, 3, 6, 23, 36, 236] where
    2 -> 2 
    3 -> 3
    6 -> 6
    23 -> 6  (product of digits)
    36 -> 18  (product of digits)
    236 -> 36  (product of digits)
    This number is not a COLORFUL number since the product 
    sequence 23  and sequence 6 is same. 
```
### Hints
* Hint 1
```text
Note that the input number can be of length at max 10.

So, the number of substrings can be at max 55.
```
* Solution Approach
```text
It is one of the easiest problems in this section.

You just need to simulate what has been stated in the problem.

Iterate over all the consecutive sequence of digits of the 
number and store the product in a set using hashing.

If the product is already present in the set at any point then 
the number is not Colorful.

Otherwise, it is a Colorful number.

Example:

    A = 123
    1 2 3 12 23 123
    1 -> 1
    2 -> 2
    3 -> 3
    12 -> 2  we have already encountered 2 before. Return 0
```
<pre>
    Time Complexity : O((log<sub>10</sub>A)<sup>2</sup>)<br>
    Space Complexity : O((log<sub>10</sub>A)<sup>2</sup>)
</pre>

* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int colorful(int A) {
        HashSet < Integer > hashSet = new HashSet < > ();
        ArrayList < Integer > numbers = new ArrayList < > ();
        while (A != 0) {
            int num = A % 10;
            numbers.add(num);
            A /= 10;
        }
        Collections.reverse(numbers);
        int n = numbers.size();
        for (int i = 0; i < n; i++) {
            int prod = 1;
            for (int j = i; j < n; j++) {
                // prod stores the product of every digit in the range [i..j]
                prod *= numbers.get(j);
                // check if the product is unique
                if (hashSet.contains(prod))
                    return 0;
                hashSet.add(prod);
            }
        }
        return 1;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param a : integer
    //return an integer
    colorful: function (a) {
        a = '' + a;
        var prods = {};
        var csize = 0;
        var code0 = '0'.charCodeAt(0);
        while (csize < a.length) {
            for (var i = 0; i + csize < a.length; i++) {
                var cnum = a.slice(i, i + csize + 1);
                var j = -1;
                var prod = 1;
                while (++j < cnum.length) {
                    prod *= (cnum.charCodeAt(j) - code0);
                }
                // check if the product is unique
                if (prods[prod]) {
                    return 0;
                }
                prods[prod] = 1;
            }
            csize++;
        }
        return 1;
    }
};
```
* * Solution in C++
```cpp
int Solution::colorful(int A) {
    char st[20];
    sprintf(st, "%d", A);
    int len = strlen(st);
    unordered_set < long long > Hash;
    for (int i = 0; i < len; ++i) {
        long long mul = 1;
        for (int j = i; j < len; ++j) {
            // mul stores the product of every digit in the range [i..j]
            mul *= (long long)(st[j] - '0');
            // check if the product is unique
            if (Hash.find(mul) != Hash.end())
                return 0;
            Hash.insert(mul);
        }
    }
    return 1;
}
```

