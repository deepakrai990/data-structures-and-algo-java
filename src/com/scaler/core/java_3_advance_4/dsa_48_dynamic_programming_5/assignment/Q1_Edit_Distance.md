### Q1. Edit Distance
#### Problem Description
```text
Given two strings A and B, find the minimum number of steps required to 
convert A to B. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

    * Insert a character
    * Delete a character
    * Replace a character
```
#### Problem Constraints
```text
1 <= length(A), length(B) <= 450
```
#### Input Format
```text
The first argument of input contains a string, A.
The second argument of input contains a string, B.
```
#### Output Format
```text
Return an integer, representing the minimum number of steps required.
```
#### Example Input
```text
Input 1:
 A = "abad"
 B = "abac"

Input 2:
 A = "Anshuman"
 B = "Antihuman
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
    A = "abad" and B = "abac"
    After applying operation: Replace d with c. We get A = B.
 
Explanation 2:
    A = "Anshuman" and B = "Antihuman"
    After applying operations: Replace s with t and insert i before h. We get A = B.
```
### Hints
* Hint 1
```text
Can you solve the problem for some prefix of first string and some prefix of second 
string and use it to compute the final answer?

Try to think of DP on prefixes of both strings.
```
* Solution Approach
```text
This is a very standard Dynamic programming problem.

Lets look at the bruteforce approach for finding edit distance of S1 and S2.
We are trying to modify S1 to become S2.

We look at the first character of both the strings.
If they match, we can look at the answer from remaining part of S1 and S2.
If they don’t, we have 3 options.
1) Insert S2’s first character and then solve the problem for remaining part of S2, and S1.
2) Delete S1’s first character and trying to match S1’s remaining string with S2.
3) Replace S1’s first character with S2’s first character in which case we solve the 
   problem for remaining part of S1 and S2.

The code would probably look something like this :

int editDistance(string &S1, int index1, string &S2, int index2) {
// BASE CASES

if (S1[index1] == S2[index2]) {
     return editDistance(S1, index1 + 1, S2, index2 + 1);
} else {
     return min(
    1 + editDistance(S1, index1 + 1, S2, index2), // Delete S1 char
            1 + editDistance(S1, index1, S2, index2 + 1), // Insert S2 char
            1 + editDistance(S1, index1 + 1, S2, index2 + 1) // Replace S1 first char with S2 first char
     );
} }

The above approach is definitely exponential.
However, lets look at the number of ways in which the function 
can be called. S1 and S2 remain constant. The only thing changing is index1 and index2 
which can take len(S1) * len(S2) number of values. Can you use it to memoize ?

You can use the above observation to also come up with a non recursive solution.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    private int dp[][];
    private String A, B;
    public int minDistance(String A, String B) {
        if (A == null && B == null)
            return 0;
        int nA, nB;
        nA = A.length();
        nB = B.length();
        if (nA == 0)
            return nB;
        if (nB == 0)
            return nA;
        dp = new int[nA][nB];
        this.A = A;
        this.B = B;
        for (int i = 0; i < nA; i++)
            Arrays.fill(dp[i], -1);
        int res = rec(nA - 1, nB - 1);
        return res;
    }

    public int rec(int iA, int iB) {
        if (iA < 0 && iB < 0)
            return 0;
        if (iA < 0)
            return iB + 1;
        if (iB < 0)
            return iA + 1;
        if (dp[iA][iB] != -1)
            return dp[iA][iB];
        int res = Integer.MAX_VALUE;
        if (A.charAt(iA) == B.charAt(iB))
            res = rec(iA - 1, iB - 1);
        int temp = 1 + rec(iA - 1, iB - 1);
        temp = Math.min(temp, 1 + rec(iA - 1, iB));
        temp = Math.min(temp, 1 + rec(iA, iB - 1));
        res = Math.min(res, temp);
        return dp[iA][iB] = res;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : string
    //param B : string
    //return an integer
    minDistance: function (word1, word2) {
        let table = new Array(word1.length + 1) // +1 to count for case when it's 0 0 empty words
        for (let i = 0; i < table.length; i++) { // this table will show index+1th character 
            if (i === 0) {
                let topArray = []
                for (let i = 0; i < word2.length + 1; i++) {
                    topArray[i] = i
                }
                table[i] = topArray
            } else {
                table[i] = new Array(word2.length + 1)
                table[i][0] = i
            }
        }
        for (let i = 1; i < table.length; i++) {
            for (let j = 1; j < table[0].length; j++) {
                if (word1[i - 1] != word2[j - 1]) {
                    table[i][j] = 1 + Math.min(table[i - 1][j - 1], table[i - 1][j], table[i][j - 1]) // table[i-1][j-1] is not always the most efficient one to start off of since sometimes making it equal at table[i-1][j-1] might require more steps than table[i-1][j] etc
                } else {
                    //table[i][j]= Math.min(table[i-1][j-1] ,1+table[i-1][j],1+table[i][j-1])
                    table[i][j] = table[i - 1][j - 1]
                }
            }
        }
        // console.log(table)
        return table[table.length - 1][table[0].length - 1]
    }
};
```
* * Solution in C++
```cpp
int Solution::minDistance(string A, string B) {
    string word1 = A;
    string word2 = B;
    // DP talbe, i is the position in word1, and j is the position in word2
    vector < vector < int >> distance(word1.length() + 1, vector < int > (word2.length() + 1, 0));
    // when i or j=0 means empty string, the distance is the length of another string
    for (int i = 0; i < distance.size(); i++) {
        for (int j = 0; j < distance[0].size(); j++) {
            if (i == 0)
                distance[i][j] = j;
            else if (j == 0)
                distance[i][j] = i;
        }
    }
    // if word1[i] == word2[j], then the distance of i and j is the previous i and j
    // otherwise we either replace, insert or delete a char
    // when insert a char to word1 it means we are trying to match word1 at i-1 to word2 at j
    // when delete a char from word1 it equals to insert a char to word2, which
    // means we are trying to match word1 at i to word2 at j-1
    // when replace a char to word1, then we add one step to previous i and j
    for (int i = 1; i < distance.size(); i++) {
        for (int j = 1; j < distance[0].size(); j++) {
            if (word1[i - 1] == word2[j - 1])
                distance[i][j] = distance[i - 1][j - 1];
            else
                distance[i][j] = 1 + min(distance[i - 1][j - 1], min(distance[i - 1][j], distance[i][j - 1]));
        }
    }
    return distance[word1.length()][word2.length()];
}
```

