### Q2. Reverse the String
#### Problem Description
```text
You are given a string A of size N.

Return the string A after reversing the string word by word.

NOTE:

    * A sequence of non-space characters constitutes a word.
    
    * Your reversed string should not contain leading or 
      trailing spaces, even if it is present in the input string.
    
    * If there are multiple spaces between words, reduce 
      them to a single space in the reversed string.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= N &lt;= 3 * 10<sup>5</sup></p>
</div>

```text
1 <= N <= 3 * 10^5
```
#### Input Format
```text
The only argument given is string A.
```
#### Output Format
```text
Return the string A after reversing the string word by word.
```
#### Example Input
```text
Input 1:
 A = "the sky is blue"

Input 2:
 A = "this is ib"
```
#### Example Output
```text
Output 1:
 "blue is sky the"

Output 2:
 "ib is this"    
```
#### Example Explanation
```text
Explanation 1:
    We reverse the string word by word so the string 
    becomes "blue is sky the".

Explanation 2:
    We reverse the string word by word so the string 
    becomes "ib is this".
```
### Hints
* Hint 1
```text
This is just a brute force problem that can be simulated in 
one or two passes of the main string.

Try to focus on the words(beginning and ending positions) 
instead of extra spaces.
```
* Solution Approach
```text
One simple approach is a two-pass solution:

    * First pass to split the string by spaces into an 
      array of words
    
    * Then second pass to extract the words in reversed order

We can do better in one-pass. While iterating the string in 
reverse order, we keep track of a word’s beginning and 
end position.

When we are at the beginning of a word, we append it.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public String solve(String s) {
        StringBuilder res = new StringBuilder();
        StringBuilder buf = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c != ' ') buf.append(c);
            else create(res, buf);
        }

        create(res, buf);
        return res.toString();
    }

    private void create(StringBuilder res, StringBuilder buf) {
        int i = buf.length() - 1;

        while (i >= 0) {
            if (i == buf.length() - 1 && res.length() > 0) res.append(' ');
            res.append(buf.charAt(i));
            i--;
        }
        buf.setLength(0);
    }
}
```
* * Solution in Javascript
```javascript
/** Not available **/
```
* * Solution in C++
```cpp
string Solution::solve(string A) {
    stack <string> st;
    for(int i=0;i<A.length();i++){
        string word="";
        while(A[i]!=' ' and i<A.length()){
            word+=A[i];
            i++;
        }
        if(word==""){
            continue;
        }
        st.push(word);
    }
    string ans="";
    while(!st.empty()){
        ans+=st.top();
        st.pop();
        
        if(st.empty()){
            continue;
        }
        ans+=" ";
    }
    return ans;
}
```

