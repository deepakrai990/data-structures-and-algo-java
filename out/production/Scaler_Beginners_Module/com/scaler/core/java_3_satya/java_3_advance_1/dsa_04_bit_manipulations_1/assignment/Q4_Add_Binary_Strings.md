### Q4. Add Binary Strings
#### Problem Description
```text
Given two binary strings A and B. Return their sum (also a binary string).
```
#### Problem Constraints
```text
1 <= length of A <= 105

1 <= length of B <= 105

A and B are binary strings
```
#### Input Format
```text
The two argument A and B are binary strings.
```
#### Output Format
```text
Return a binary string denoting the sum of A and B
```
#### Example Input
```text
Input 1:
 A = "100"
 B = "11"

Input 2:
 A = "110"
 B = "10"
```
#### Example Output
```text
Output 1:
 "111"

Output 2:
 "1000"
```
#### Example Explanation
```text
For Input 1:
    The sum of 100 and 11 is 111.

For Input 2: 
    The sum of 110 and 10 is 1000.
```
### Hints
* Hint 1
```text
This is exactly like adding two numbers.

    * Note 1: It might be easier if you construct the reverse of the answer, reversing 
              the strings that we have to add.
    
    * Note 2: Make sure you don’t stop before the carry is 0. (Cases like 11 + 1.)
```
* Solution Approach
```text
Since the sizes of the two strings may be different, we first make the size of the 
smaller string equal to that of the bigger one by adding leading 0s for simplicity. Note that you can handle the addition without adding zeroes by adding a few if statements. After making sizes the same, we add bits from the rightmost bit to the leftmost bit.

In every iteration, we must sum 3 bits: 2 bits of 2 given strings and carry.

The sum bit will be 1 if all 3 bits are set, or one of them is set.

So we can add all the bits and then take the remainder with 2 to get the 
current bit in the answer. How to find the carryover? Carry will be 1 if any of 
the two bits is set. So we can find carry by adding the bits and dividing the 
result by 2. Following is a step-by-step algorithm: 1. Make them equal-sized by 
adding 0s at the beginning of the smaller string. 2. Perform bit addition Boolean 
expression for adding 3 bits a, b, c Sum = (a + b + c) % 2 Carry = (a + b + c ) / 2
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public String addBinary(String A, String B) {
        int nA, nB;
        char res[];
        int i, j, k;
        nA = A.length();
        nB = B.length();
        res = new char[Math.max(nA, nB) + 1];
        k = Math.max(nA, nB);
        i = nA - 1;
        j = nB - 1;
        int sum = 0, carry = 0;
        // we add bits from the rightmost bit to the leftmost bit
        while (i >= 0 || j >= 0 || carry != 0) {
            sum = carry;
            if (i >= 0)
                sum += (A.charAt(i) - '0');
            if (j >= 0)
                sum += (B.charAt(j) - '0');
            res[k] = (char) ((sum % 2) + '0');
            carry = sum / 2;
            i--;
            j--;
            k--;
        }
        if (res[0] == '1')
            return new String(res);
        int len = Math.max(nA, nB);
        return new String(res, 1, len);
    }
}
```
* * Solution in Javascript
```javascript
module.exports = { 
 //param A : string
 //param B : string
 //return a strings
	addBinary : function(A, B){
	    
	    let i = A.length - 1;
	    let j = B.length - 1;
	    
	    let ans="";
	    let carry = 0,sum = 0;
	    
	    // we add bits from the rightmost bit to the leftmost bit
	    while(i >=0 || j>=0 || (carry==1)) {
	        sum = carry;
	        if( i >= 0) 
	            sum += Number(A[i]);
	        if( j >= 0) 
	            sum += Number(B[j]);
	        ans += (String(sum % 2));
	        carry = Math.floor(sum / 2);
	        i--;
	        j--;
	    }
	    return ans.split("").reverse().join("");
	}
};
```
* * Solution in C++
```cpp
string Solution::addBinary(string A, string B) {
    string ans = "";
    int ansLen = 0, carry = 0, sum;
    int i = A.length() - 1, j = B.length() - 1;
    // we add bits from the rightmost bit to the leftmost bit
    while (i >= 0 || j >= 0 || carry) {
        sum = carry;
        if (i >= 0) 
            sum += (A[i] - '0');
        if (j >= 0) 
            sum += (B[j] - '0');
        ans.push_back((char)('0' + sum % 2));
        carry = sum / 2;
        i--; 
        j--;
    }
    reverse(ans.begin(), ans.end());
    return ans;
}
```

