### Q3. String operations
#### Problem Description
```text
Akash likes playing with strings. One day he thought of applying 
following operations on the string in the given order:

* Concatenate the string with itself.
* Delete all the uppercase letters.
* Replace each vowel with '#'.

You are given a string A of size N consisting of lowercase 
and uppercase alphabets. Return the resultant string after 
applying the above operations.

NOTE: 'a' , 'e' , 'i' , 'o' , 'u' are defined as vowels.
```
#### Problem Constraints
```text
1<=N<=100000
```
#### Input Format
```text
First argument is a string A of size N.
```
#### Output Format
```text
Return the resultant string.
```
#### Example Input
```text
Input 1:
 A="AbcaZeoB"
```
#### Example Output
```text
Output 1:
 "bc###bc###"
```
#### Example Explanation
```text
Explanation 1:
    First concatenate the string with itself so string A 
    becomes "AbcaZeoBAbcaZeoB".
    
    Delete all the uppercase letters so string A becomes "bcaeobcaeo".
    
    Now replace vowel with '#'.
    
    A becomes "bc###bc###".
```
### Hints
* Hint 1
```text
Just do the operations as given in the order. Keep in mind that 
you follows the order.
```
* Solution Approach
```text
It can be solved using bruteforce solution i.e you just 
follow the operations.

Firstly concatenate the string with itself.

Then create an empty string and loop through the above obtained 
string and check if it is uppercase character then ignore that.

If it is vowel then replace it by ‘#’.

Finally return the output.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public String solve(String A) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) >= 'a' && A.charAt(i) <= 'z') {
                if (A.charAt(i) == 'a' || A.charAt(i) == 'e' || A.charAt(i) == 'i' || A.charAt(i) == 'o' || A.charAt(i) == 'u') {
                    res.append("#");
                } else {
                    res.append(A.charAt(i));
                }
            }
        }
        res.append(res);
        return res.toString();
    }
}
```
* * Solution in Javascript
```javascript
module.exports = { 
    //param A : string
    //return a strings
	solve : function(A) {
        A += A;
        let n = A.length;
        let ans = "";
        let mp = new Map();
        mp.set('a',1); mp.set('e',1); mp.set('i',1);
        mp.set('o',1); mp.set('u',1);
        for(let i = 0; i <n; i++) {
            if(A.charCodeAt(i) >= 97) {
                if(mp.has(A[i]))
                    ans += '#';
                else 
                    ans += A[i];
            }
        }
        return ans;
	}
};

```
* * Solution in C++
```cpp
string Solution::solve(string A) {
    A+=A;
  string b="";
  int n=A.size();
  for(int i=0;i<n;i++)
  {
    if(A[i]>='a' && A[i]<='z')
    {
        if(A[i]=='a' || A[i]=='e' || A[i]=='i' || A[i]=='o' || A[i]=='u')
        {
          b+='#';
        }
        else
        {
          b+=A[i];
        }
    }
  }
  return b;
}
```

