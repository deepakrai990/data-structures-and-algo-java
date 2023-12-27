### Q3. Binary Strings
#### Problem Description
```text
You are given a string A consisting of 1's and 0's. Now the task is to make the string 
consisting of only 1's. But you are allowed to perform only the following operation:

    * Take exactly B consecutive string elements and change 1 to 0 and 0 to 1.

Each operation takes 1 unit time, so you have to determine the minimum time required 
to only make the string of 1's. If not possible, return -1.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>2 ≤ length of A ≤ 10<sup>5</sup> <br>
    2 ≤ B ≤ (length of A)</p>
</div>

```text
2 ≤ length of A ≤ 10^5
2 ≤ B ≤ (length of A)
```
#### Input Format
```text
The first argument is a string A consisting of 1's and 0's.
The second argument is an integer B which represents the number of consecutive 
elements which can be changed.
```
#### Output Format
```text
Return an integer which is the minimum time to make the string of 1's only or -1 if 
not possible.
```
#### Example Input
```text
Input 1:
 A = "00010110"
 B = 3

Input 2:
 A = "011"
 B = 3
```
#### Example Output
```text
Output 1:
 3

Output 2:
 -1
```
#### Example Explanation
```text
Explanation 1:
    You can get 1 by first changing the leftmost 3 elements, getting to 11110110, then 
    the rightmost 3, getting to 11110001, and finally the 3 left out 0's to 11111111; 
    In 3 unit time.

Explanation 2:
    It's not possible to convert the string into string of all 1's.
```
### Hints
* Hint 1
```text
Think of a greedy approach to solve this problem.
For each element, think how far to iterate starting from the left 
before making some operation?
```
* Solution Approach
```text
Let us follow a greedy strategy.

Maintain an answer = 0.
Also, maintain a variable and an auxiliary array, let’s say xr and temp, respectively.
Initially, both are 0.

Start from the leftmost index of the string and iterate till the index ((string length)-B).
Now consider the curr index is i.
Firstly, xr = xr ^ temp[i]
If ( A[i] == ‘1’ && xr == 1) || (A[i] == ‘0’ && xr == 0) then increment the answer.
Also mark temp[i+B] as 1 and xr = 1 - xr.

Now check for the remaining elements and if there is any 0, return -1.
Else,
Return ans

Time Complexity: O(N)
Space Complexity: O(N)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(String A, int B) {
        int n = A.length();
        int[] temp = new int[n];
        Arrays.fill(temp, 0);
        int xr = 0;
        int ans = 0;
        int i = 0;
        for (i = 0; i <= n - B; i++) {
            xr ^= temp[i];
            if ((A.charAt(i) == '0' && xr == 0) || (A.charAt(i) == '1' && xr == 1)) {
                ans++;
                if (i + B < n) {
                    temp[i + B] = 1;
                }
                xr = 1 - xr;
            }
        }
        while (i < n) {
            xr ^= temp[i];
            int val = A.charAt(i) - 48;
            if ((val ^ xr) == 0) {
                return -1;
            }
            i++;
        }
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    solve: function (A, B) {
        let n = A.length;
        let temp = new Array(n).fill(0);
        let xr = 0;
        let ans = 0;
        let i = 0;
        for (i = 0; i <= n - B; i++) {
            xr ^= temp[i];
            if ((A[i] == "0" && xr == 0) || (A[i] == "1" && xr == 1)) {
                ans++;
                if (i + B < n) {
                    temp[i + B] = 1;
                }
                xr = 1 - xr;
            }
        }
        while (i < n) {
            xr ^= temp[i];
            let val = A[i].charCodeAt(0) - "0".charCodeAt(0);
            if (val ^ (xr == 0)) {
                return -1;
            }
            i++;
        }
        return ans;
    },
};
```
* * Solution in C++
```cpp
int Solution::solve(string A, int B) {
    int n = A.size();
    int temp[n];
    memset(temp, 0, sizeof(temp));
    int xr = 0;
    int ans = 0;
    int i = 0;
    for (i = 0; i <= n - B; i++) {
        xr ^= temp[i];
        if ((A[i] == '0' && xr == 0) || (A[i] == '1' && xr == 1)) {
            ans++;
            if (i + B < n) {
                temp[i + B] = 1;
            }
            xr = 1 - xr;
        }
    }
    while (i < n) {
        xr ^= temp[i];
        int val = A[i] - '0';
        if (val ^ xr == 0) {
            return -1;
        }
        i++;
    }
    return ans;
}
```

