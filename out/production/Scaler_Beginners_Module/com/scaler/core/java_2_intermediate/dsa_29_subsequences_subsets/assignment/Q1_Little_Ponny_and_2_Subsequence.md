### Q1. Little Ponny and 2-Subsequence
#### Problem Description
```text
Little Ponny has been given a string A, and he wants to find 
out the lexicographically minimum subsequence from it 
of size >= 2. Can you help him?

A string a is lexicographically smaller than string b, if the 
first different letter in a and b is smaller in a. For 
example, "abc" is lexicographically smaller than "acc" because 
the first different letter is 'b' and 'c' which is smaller in "abc".
```
#### Problem Constraints
```text
1 <= |A| <= 10^5

A only contains lowercase alphabets.
```
#### Input Format
```text
The first and the only argument of input contains the string, A.
```
#### Output Format
```text
Return a string representing the answer.
```
#### Example Input
```text
Input 1:
 A = "abcdsfhjagj" 

Input 2:
 A = "ksdjgha" 
```
#### Example Output
```text
Output 1:
 "aa" 

Output 2:
 "da" 
```
#### Example Explanation
```text
Explanation 1:
    "aa" is the lexicographically minimum subsequence from A. 

Explanation 2:
    "da" is the lexicographically minimum subsequence from A. 
```
### Hints
* Hint 1
```text
It may be clear from the examples that the answer will 
always be of size = 2.

Any subsequence of size >= 2 will be greater than if only its 
first two characters are considered.

We can exclude that part of the string where the first character 
cannot lie and include it later when choosing the second character.
```
* Solution Approach
```text
The last character of A cannot be a part of the first character 
of the answer, so we don’t consider it.

We can pick up the first occurrence of the smallest character 
in the rest of the string.

Now, all of the string lying before the occurrence of the 
first character is useless. So, we can exclude the whole 
string behind it and only consider the string after it.

We can pick the smallest character in the leftover substring.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public String solve(String A) {
        char minchar = 'z';
        int idx = 1000000000;
        for(int i = 0; i < A.length() - 1; i++){
            if(A.charAt(i) < minchar){
                minchar = A.charAt(i);
                idx = i;
            }
        }
        char minchar2 = 'z';
        for(int i = idx + 1; i < A.length(); i++)
            if(A.charAt(i) < minchar2)
                minchar2 = A.charAt(i);
        String ans = String.valueOf(minchar) + String.valueOf(minchar2);
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
/** not available **/
```
* * Solution in C++
```cpp
string Solution::solve(string A) {
    char minchar = 'z';
    int idx = 1e9;
    for(int i = 0; i < A.size() - 1; i++){
        if(A[i] < minchar){
            minchar = A[i];
            idx = i;
        }
    }
    char minchar2 = 'z';
    for(int i = idx + 1; i < A.size(); i++)
        if(A[i] < minchar2)
            minchar2 = A[i];
    string ans; ans += minchar; ans += minchar2;
    return ans;
}
```

