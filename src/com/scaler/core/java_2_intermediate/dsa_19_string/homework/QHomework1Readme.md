### Q1. Count Occurrences
#### Problem Description
```text
Find the number of occurrences of bob in string A consisting 
of lowercase English alphabets.
```
#### Problem Constraints
```text
1 <= |A| <= 1000
```
#### Input Format
```text
The first and only argument contains the string A, consisting of 
lowercase English alphabets.
```
#### Output Format
```text
Return an integer containing the answer.
```
#### Example Input
```text
Input 1:
 "abobc"

Input 2:
 "bobob"
```
#### Example Output
```text
Output 1:
 1

Output 2:
 2
```
#### Example Explanation
```text
Explanation 1:
    The only occurrence is at second position.

Explanation 2:
    Bob occurs at first and third position.
```
### Hints
* Hint 1
```text
Length of the string to be find is only 3 ("bob"). So, you can directly find
each occurrence of "bob" in the given string
```
* Solution Approach
```text
Iterate over the string and for each index i check whether substring 
formed by the index i, i+1 and i+2 is "bob" or not if yes then increase 
answer. You can also use inbuilt function for the same if it is present 
in your preferred language.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(String A) {
        int ans = 0;
        for (int i = 0; i + 2 < A.length(); ++i) {
            if (A.charAt(i) == 'b' && A.charAt(i + 1) == 'o' && A.charAt(i + 2) == 'b') {
                ++ans;
            }
        }
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = { 
 //param A : string
 //return an integer
	solve : function(A){
	    let ans = 0;
	    let n = A.length;
	    
	    for(let i = 2; i < n; i++) {
	        if(A[i] == 'b' && A[i-1] == 'o' && A[i-2] == 'b')
	            ans++;
	    }
	    return ans;
	}
};
```
* * Solution in C++
```cpp
int Solution::solve(string A) {
    string s = A;
    int prev = -1, cur, ans = 0;
    cur = s.find("bob",prev+1);
    while(cur != -1){
        ans++;
        prev = cur;
        cur = s.find("bob", prev+1);
    }
    return ans;
}

```

