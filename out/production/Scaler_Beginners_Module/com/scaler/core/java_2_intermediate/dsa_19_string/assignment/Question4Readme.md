### Q4. tolower()
#### Problem Description
```text
You are given a function to_lower() which takes a character 
array A as an argument.

Convert each character of A into lowercase characters if it 
exists. If the lowercase of a character does not exist, it 
remains unmodified.

The uppercase letters from A to Z are converted to lowercase 
letters from a to z respectively.

Return the lowercase version of the given character array.
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
The only argument is a character array A.
```
#### Output Format
```text
Return the lowercase version of the given character array.
```
#### Example Input
```text
Input 1:
 A = ['S', 'c', 'A', 'l', 'e', 'r', 'A', 'c', 'a', 'D', 'e', 'm', 'y']

Input 2:
 A = ['S', 'c', 'a', 'L', 'e', 'r', '#', '2', '0', '2', '0']
```
#### Example Output
```text
Output 1:
 ['s', 'c', 'a', 'l', 'e', 'r', 'a', 'c', 'a', 'd', 'e', 'm', 'y']

Output 2:
 ['s', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0']
```
#### Example Explanation
```text
Explanation 1:
    All the characters in the returned array are in lowercase alphabets.
```
### Hints
* Hint 1
```text
Loop through the character array and use the inbuilt function to 
convert the uppercase character to a lowercase character.
```
* Solution Approach
```text
Loop through the character array and use the inbuilt function 
to convert the uppercase character to a lowercase character.

In C/C++, tolower() function takes a character and converts it into lowercase.

Similarly, in python, we can use character.lower().
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public ArrayList<Character> to_lower(ArrayList<Character> A) {
        for (int i = 0; i < A.size(); ++i) {
            A.set(i, Character.toLowerCase(A.get(i)));
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
    to_lower: function (A) {
        let ans = A.join('').toLowerCase().split('');
        return ans;
    }
};
```
* * Solution in C++
```cpp
vector<char> Solution::to_lower(vector<char> &A) {
    int n = A.size();
    for(int i = 0; i < n; i++){
        A[i] = tolower(A[i]);
    }
    return A;
}
```

