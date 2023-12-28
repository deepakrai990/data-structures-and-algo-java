### Q6. toupper()
#### Problem Description
```text
You are given a function to_upper() consisting of a character array A.

Convert each character of A into Uppercase character if it 
exists. If the Uppercase of a character does not exist, it 
remains unmodified.

The lowercase letters from a to z is converted to uppercase 
letters from A to Z respectively.

Return the uppercase version of the given character array.
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
Return the uppercase version of the given character array.
```
#### Example Input
```text
Input 1:
 A = ['S', 'c', 'A', 'L', 'E', 'r', 'A', 'c', 'a', 'D', 'e', 'm', 'y']

Input 2:
 A = ['S', 'c', 'a', 'L', 'e', 'R', '#', '2', '0', '2', '0']
```
#### Example Output
```text
Output 1:
 ['S', 'C', 'A', 'L', 'E', 'R', 'A', 'C', 'A', 'D', 'E', 'M', 'Y']

Output 2:
 ['S', 'C', 'A', 'L', 'E', 'R', '#', '2', '0', '2', '0']
```
#### Example Explanation
```text
Explanation 1:
    All the characters in the returned array are in uppercase alphabets.
```
### Hints
* Hint 1
```text
Loop through the character array and use the inbuilt function to 
convert the lowercase character to an uppercase character.
```
* Solution Approach
```text
Loop through the character array and use the inbuilt function to 
convert the lowercase character to an uppercase character.

In C/C++, toupper() function takes a character and 
converts it into uppercase.

Similarly, in python, we can use character.upper().
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public ArrayList<Character> to_upper(ArrayList<Character> A) {
        for (int i = 0; i < A.size(); ++i) {
            A.set(i, Character.toUpperCase(A.get(i)));
        }
        return A;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : array of characters
    //return a array of characters
    to_upper: function (A) {
        let ans = A.join('').toUpperCase().split('');
        return ans;
    }
};
```
* * Solution in C++
```cpp
vector<char> Solution::to_upper(vector<char> &A) {
    int n = A.size();
    for(int i = 0; i < n; i++){
        A[i] = toupper(A[i]);
    }
    return A;
}
```

