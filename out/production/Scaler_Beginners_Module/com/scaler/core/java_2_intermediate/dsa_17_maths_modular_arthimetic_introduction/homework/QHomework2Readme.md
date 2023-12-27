### Q2. Divisibility by 8
#### Problem Description
```text
You are given a number A in the form of a string. Check if the 
number is divisible by eight or not.

Return 1 if it is divisible by eight else, return 0.
```
#### Problem Constraints
```text
1 <= length of the String <= 100000
'0' <= A[i] <= '9'
```
#### Input Format
```text
The only argument given is a string A.
```
#### Output Format
```text
Return 1 if it is divisible by eight else return 0.
```
#### Example Input
```text
Input 1:
 A = "16"

Input 2:
 A = "123"
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
    16 = 8 * 2

Explanation 2:
    123 = 15 * 8 + 3
```
### Hints
* Hint 1
```text
Since the input number may be huge, we cannot use n % 8 to 
check if a number is divisible by eight or not, especially in 
languages like C/C++. The idea is based on the following fact.

A number is divisible by eight if the number formed by the last 
three digits of it is divisible by 8.
```
* Solution Approach
```text
Not available
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(String A) {
        int n = A.length();
        if (n == 1) {
            if ((A.charAt(0) - '0') % 8 == 0) {
                return 1;
            }
            return 0;
        }
        if (n == 2) {
            int x = (A.charAt(0) - '0') * 10 + A.charAt(1) - '0';
            if (x % 8 == 0) {
                return 1;
            }
            return 0;
        }
        int a3 = (A.charAt(n - 3) - '0') * 100 + (A.charAt(n - 2) - '0') * 10 + (A.charAt(n - 1) - '0');
        if (a3 % 8 == 0) {
            return 1;
        }
        return 0;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = { 
 //param A : string
 //return an integer
    
	solve : function(A){
	    
    	function check_divisible(A) {
            
            let num = Number(A);
            if(num % 8 == 0)
                return 1;
            else
                return 0;
        }
        
	    let n = A.length;
	    
	    if( n == 1) {
	        return check_divisible(A.substr(n-1,n));
	    }
	    else if( n == 2) {
	        return check_divisible(A.substr(n-2,n));
	    }
	    else
	        return check_divisible(A.substr(n-3,n));
	}
};
```
* * Solution in C++
```cpp
int ans(string & s) {
    int n = s.size();
    if (n == 1)
        return ((s[0] - '0') % 8 == 0);
    if (n == 2) {
        int x = (s[0] - '0') * 10 + s[1] - '0';
        return (x % 8 == 0);
    }
    int a3 = (s[n - 3] - '0') * 100 + (s[n - 2] - '0') * 10 + (s[n - 1] - '0');
    return (a3 % 8 == 0);
}

int Solution::solve(string A) {
    return ans(A);
}
```

