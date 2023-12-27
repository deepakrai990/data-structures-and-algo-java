### Q7. Isalnum()
#### Problem Description
```text
You are given a function isalpha() consisting of a 
character array A.

Return 1 if all the characters of a character array are 
alphanumeric (a-z, A-Z, and 0-9) else, return 0.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= |A| &lt;= 10<sup>5</sup></p>
</div>

```text
1 <= |A| <= 10^5
```
#### Input Format
```text
Only argument is a character array A.
```
#### Output Format
```text
Return 1 if all the characters of the character array are 
alphanumeric (a-z, A-Z and 0-9), else return 0.
```
#### Example Input
```text
Input 1:
 A = ['S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y', '2', '0', '2', '0']

Input 2:
 A = ['S', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0']
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
 All the characters are alphanumeric.

Explanation 2:
 All the characters are NOT alphabets i.e ('#').
```
### Hints
* Hint 1
```text
Loop through the character array and use the inbuilt function 
to check if the character is an alphabet or a number.
```
* Solution Approach
```text
Loop through the character array and use the inbuilt function 
to check if the character is an alphabet or a number.

In C/C++, isalnum() function takes a character and return 0 if 
the character is NOT an alphabet or a number.

Similarly, in python, we can use character.isalnum().
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(ArrayList<Character> A) {
        for (Character x : A) {
            if (!Character.isLetterOrDigit(x)) {
                return 0;
            }
        }
        return 1;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = { 
    //param A : array of characters
    //return an integer
	solve : function(A){
	    let n = A.length;
	    let ans = 1;
	    for(let i = 0; i < n; i++) {
	        if((A[i]>='a' && A[i]<='z') || (A[i]>='A' && A[i]<= 'Z') || (A[i]>='0' && A[i]<='9'))
	            continue;
	         else
	            ans = 0;
	    }
	    return ans;
	}
};
```
* * Solution in C++
```cpp
int Solution::solve(vector<char> &A) {
    int n = A.size();
    for(int i = 0; i < n; i++){
        if(!isalnum(A[i])){
            return 0;
        }
    }
    return 1;
}
```

