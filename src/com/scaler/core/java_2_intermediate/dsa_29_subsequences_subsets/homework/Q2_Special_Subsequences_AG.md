### Q2. Special Subsequences "AG"
#### Problem Description
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>You have given a string <strong>A</strong> having 
    <strong>Uppercase English letters</strong>.</p>
    <p>You have to find how many times subsequence 
    <strong>"AG"</strong> is there in the given string.</p>
    <p><strong>NOTE: </strong> Return the answer modulo 
    <strong>10<sup>9</sup> + 7</strong> as the answer can 
    be very large.</p>
</div>

```text
You have given a string A having Uppercase English letters.

You have to find how many times subsequence "AG" is there in the given string.

NOTE: Return the answer modulo 10^9 + 7 as the answer can be very large.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= length(A) &lt;= 10<sup>5</sup></p>
</div>

```text
1 <= length(A) <= 10^5
```
#### Input Format
```text
First and only argument is a string A.
```
#### Output Format
```text
Return an integer denoting the answer.
```
#### Example Input
```text
Input 1:
 A = "ABCGAG"

Input 2:
 A = "GAB"
```
#### Example Output
```text
Output 1:
 3

Output 2:
 0
```
#### Example Explanation
```text
Explanation 1:
 Subsequence "AG" is 3 times in given string 

Explanation 2:
 There is no subsequence "AG" in the given string.
```
### Hints
* Hint 1
```text
The main task is to find the number of times subsequence “AG” 
appears in a string.

Can count of A’s and G’s in the given string help in any way?
```
* Solution Approach
```text
Approach 1

The main task is to find the number of times subsequence “AG” 
appears in a string.

Simply find the number of G’s after any index i by taking suffix sum.

Then traverse the string again, and when you encounter an ‘A’, add 
the number of G’s after that to the answer.

Time Complexity : O(n)
Space Complexity (extra) : O(n)

where ‘n’ is the length of the string A.

This solution is enough to pass the test cases.
However , Do we really need O(n) space? Can you think of a 
solution with constant space?

Approach 2(memory efficient)

This is just a modification of the previous approach.

Instead of keeping a suffix array for count of G’s , we can 
instead keep a variable ‘g’ storing count of G’s and iterate in 
the reverse order.

If the current character is ‘G’ , increment g.

If the current character is ‘A’ , add g to our answer.

for i from n-1 to 0
    if A[i]=='G'
        g++
    else 
        ans+=g
        ans%=mod

Time complexity : O(n)
Space complexity : O(1)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(String A) {
        int n = A.length(), ans = 0, MOD = 1000*1000*1000 + 7;
        int cnt_G[] = new int[n], count = 0;
        
        //Suffix count of G
        for(int i = n - 1 ; i >= 0 ; i--){
            if(A.charAt(i) == 'G')
                count = count + 1;
            cnt_G[i] = count;
        }
        
        // traverse the string again from beginning
        for(int i = 0; i < n; i++){
            // if current character is "A" then add number of G's after that 
            if(A.charAt(i) == 'A') {
                ans = ans + cnt_G[i];
                ans = ans % MOD;
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
	    let ans = 0,
        ct = 0;
        [...A].forEach((ele) => {
            ct += ele == "A";
            // if current character is "G" then add count of "A" before that 
            ans += ele == "G" ? ct : 0;
            ans %= 1000000007;
        });
        return ans;
	}
};
```
* * Solution in C++
```cpp
int Solution::solve(string A) {
    int n = (int)A.length(), mod = 1e9 + 7;
    
    // create an array to store number of G's from i to n
    int count_G[n];
    
    // initialize the array with 0
    for(int i = 0; i < n; i += 1)
        count_G[i] = 0;
    
    // set the value of count_G[n - 1] equal to 1 if last character is G
    count_G[n - 1] = (A[n - 1] == 'G');
    // traverse the string from backward and count number of G's from i to n
    for(int i = n - 2; i > 0; i -= 1) {
        count_G[i] = count_G[i + 1] + (A[i] == 'G');
    }
    
    int ans = 0;
    // traverse the string again from beginning
    for(int i = 0; i < n - 1; i += 1) {
        // if current character is "A" then add number of G's after that 
        if(A[i] == 'A') {
            ans = (ans + count_G[i + 1]) % mod;
        }
    }
    // return the answer
    return ans;    
}
```

