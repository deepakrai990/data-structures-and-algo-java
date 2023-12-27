### Q3. Replicating Substring
#### Problem Description
```text
Given a string B, find if it is possible to re-order the characters of the string B so 
that it can be represented as a concatenation of A similar strings.

Eg: B = aabb and A = 2, then it is possible to re-arrange the string as "abab" which 
is a concatenation of 2 similar strings "ab".

If it is possible, return 1, else return -1.
```
#### Problem Constraints
```text
1 <= Length of string B <= 1000

1 <= A <= 1000

All the alphabets of S are lower case (a - z)
```
#### Input Format
```text
First argument is an integer A.
Second argument is a string B.
```
#### Output Format
```text
Your function should return 1 if it is possible to re-arrange the characters of the 
string B so that it can be represented as a concatenation of A similar strings. If it 
is not, return -1.
```
#### Example Input
```text
Input 1:
 A = 2
 B = "bbaabb"

Input 2:
 A = 1
 B = "bc"
```
#### Example Output
```text
Output 1:
 1

Output 2:
 1
```
#### Example Explanation
```text
Explanation 1:
    We can re-order the given string into "abbabb".

Explanation 2:
    String "bc" is already arranged.
```
### Hints
* Hint 1
```text
If it should be possible to re-arrange the characters of the string to make it 
such that it appears as a concatenation of K similar strings, what constraint 
does this put on the frequency of each character?
```
* Solution Approach
```text
Each character must come in multiples of A if we are to represent the string as a 
concatenation of A strings.

Why?

Because that count divided by A will the number of times that particular character 
appears in 1 string.

So we maintain a hash which stores the frequency of each character.

Then we iterate over the hash and check if each character that appeared in the array 
appeared as a multiple of A or not.

If there exists even 1 character whose hash[i] % A is not equal to 0, it implies we 
cannot represent the string as A concatenated strings

Else the answer is yes.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int A, String B) {
        // hash array to keep a track of frequency of each character
        int hash[] = new int[26];
        for (int i = 0; i < B.length(); i++) {
            hash[B.charAt(i) - 'a']++;
        }
        int flag = 0;
        for (int i = 0; i < 26; i++) {
            // if the frequency of a charatcer present in the string isn't divisble by A, set a flag which 
            // indicates that it will never be possible to represent B as concatenation of A strings
            if (hash[i] % A != 0)
                flag = 1;
        }
        if (flag == 1)
            return -1;
        else
            return 1;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : integer
    //param B : string
    //return an integer
    solve: function (A, B) {
        // hash array to keep a track of frequency of each character
        let hash = Array(26).fill(0);
        let a = "a";
        for (let i = 0; i < B.length; i++) {
            hash[B.charCodeAt(i) - a.charCodeAt(0)] += 1;
        }
        let flag = 0;
        for (let i = 0; i < 26; i++) {
            // if the frequency of a charatcer present in the string isn't divisble by A, set a flag which 
            // indicates that it will never be possible to represent B as concatenation of A strings
            if (hash[i] % A != 0) {
                flag = 1;
            }
        }
        if (flag == 1) return -1;
        return 1;
    }
};
```
* * Solution in C++
```cpp
int Solution::solve(int A, string B) {
        // hash array to keep a track of frequency of each character
        int hash[26];
        memset(hash, 0, sizeof(hash));
        for (int i = 0; B[i] != '\0'; i++) {
            hash[B[i] - 'a']++;
        }

        int flag = 0;
        for (int i = 0; i < 26; i++) {
            // if the frequency of a charatcer present in the string isn't divisble by A, set a flag which 
            // indicates that it will never be possible to represent B as concatenation of A strings
            if (hash[i] % A != 0)
                flag = 1;
        }
        if (flag)
            return -1;
        else
            return 1;
}
```

