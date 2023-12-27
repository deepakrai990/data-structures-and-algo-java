### Q5. Amazing Subarrays
#### Problem Description
```text
You are given a string S, and you have to find all the 
amazing substrings of S.

An amazing Substring is one that starts with 
a vowel (a, e, i, o, u, A, E, I, O, U).
```
#### Problem Constraints
* <p>1 &lt;= length(S) &lt;= 1 * 10<sup>6</sup></p>
* <p>S can have special characters</p>
```text
1 <= length(S) <= 1e6 (1 * 10 ^ 6)
S can have special characters
```
#### Input Format
```text
Only argument given is string S.
```
#### Output Format
```text
Return a single integer X mod 10003, here X is the number of 
Amazing Substrings in given the string.
```
#### Example Input
```text
 ABEC
```
#### Example Output
```text
 6
```
#### Example Explanation
```text
Amazing substrings of given string are :
    1. A
    2. AB
    3. ABE
    4. ABEC
    5. E
    6. EC
here number of substrings are 6 and 6 % 10003 = 6.
```
### Hints
* Hint 1
```text
Brute Force Approach is to find all the substrings and count 
the substrings those start with a vowel.

This approach will result in the timeout as the time complexity 
of the same is O(n^2).

Is there any need to find all the substrings?

Try to find a pattern.
```
* Solution Approach
```text
The main idea to solve this problem is to traverse the string and 
when you encounter a vowel, 
add ( length(string) - position_of_curr_char ) to the answer.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(String A) {
        TreeSet<Character> se = new TreeSet<>();
        se.add('a');
        se.add('e');
        se.add('i');
        se.add('o');
        se.add('u');
        se.add('A');
        se.add('E');
        se.add('I');
        se.add('O');
        se.add('U');

        int n = A.length();
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (se.contains(A.charAt(i))) {
                ans += (n - i);
            }
        }
        return (int) (ans % 10003);
    }
}
```
* * Solution in Javascript
```javascript
module.exports = { 
 //param A : string
 //return an integer
	solve : function(A) {
	    let ans = 0;
	    let mp = new Map();
	    mp.set('a',1);  mp.set('e',1);  mp.set('i',1);  
	    mp.set('o',1);  mp.set('u',1);
	    mp.set('A',1);  mp.set('E',1);  mp.set('I',1);  
	    mp.set('O',1);  mp.set('U',1);
	    let n = A.length;
	    for( let i = 0; i < n; i++) {
	        if(mp.has(A[i]))
	            ans= (ans+n - i)%10003;
	    }
            return ans;
	}
};
```
* * Solution in C++
```cpp
int Solution::solve(string s) {
    
    map<char, bool> m;
    m['a'] = m['e'] = m['i'] = m['o'] = m['u'] = 1;
    m['A'] = m['E'] = m['I'] = m['O'] = m['U'] = 1;
    
    int n = s.length();
    long long ans = 0;
    for(int i = 0; i < n; i += 1) {
        if(m[s[i]])
            ans += (n - i);
    }
    return ans % 10003;
}
```

