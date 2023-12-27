### Q1. Maximum & Minimum Magic
#### Problem Description
```text
Given an array of integers A of size N where N is even.

Divide the array into two subsets such that

1.Length of both subset is equal.
2.Each element of A occurs in exactly one of these subset.

Magic number = sum of absolute difference of 
corresponding elements of subset.

Note: You can reorder the position of elements within 
the subset to find the value of the magic number.

For Ex:- 
subset 1 = {1, 5, 1}, 
subset 2 = {1, 7, 11}
Magic number = abs(1 - 1) + abs(5 - 7) + abs(1 - 11) = 12

Return an array B of size 2, where B[0] = maximum 
possible value of Magic number modulo 10^9 + 7, B[1] = minimum 
possible value of a Magic number modulo 10^9 + 7.
```

<p>Return an array <strong>B</strong> of size 
<strong>2</strong>, where B[0] = maximum possible 
value of Magic number modulo <strong>10
<sup>9</sup> + 7</strong>, B[1] = minimum possible 
value of a Magic number modulo <strong>10
<sup>9</sup> + 7</strong>.</p>

#### Problem Constraints
* <p>1 &lt;= N &lt;= 10<sup>5</sup></p>
* <p>-10<sup>9</sup> &lt;= A[i] &lt;= 10<sup>9</sup></p>
* <p>N is even</p>
```text
1 <= N <= 10^5

-10^9 <= A[i] <= 10^9

N is even
```
#### Input Format
```text
The first argument given is the integer array A.
```
#### Output Format

<p>Return an array B of size 2, where B[0] = maximum possible 
value of Magic number % 10<sup>9</sup> + 7,B[1] = minimum 
possible value of a Magic number % 10<sup>9</sup> + 7.</p>

```text
Return an array B of size 2, where B[0] = maximum possible 
value of Magic number % 10^9 + 7,B[1] = minimum possible 
value of a Magic number % 10^9 + 7.
```
#### Example Input
```text
Input 1:
 A = [3, 11, -1, 5]

Input 2:
 A = [2, 2]
```
#### Example Output
```text
Output 1:
 [14, 10]

Output 2:
 [0, 0]
```
#### Example Explanation
```text
Explanation 1:
     All possible magical numbers:-
     sub1 = {3, 11}, sub2 = {-1, 5}, Magic Number = abs(3 - -1) + abs(11 - 5) = 10
     sub1 = {3, -1}, sub2 = {11, 5}, Magic Number = abs(3 - 11) + abs(-1 - 5) = 14 
     sub1 = {3, 5}, sub2 = {11, -1}, Magic Number = abs(3 - 11) + abs(5 - -1) = 14
     sub1 = {11, -1}, sub2 = {3, 5}, Magic Number = abs(11 - 3) + abs(-1 - 5) = 14
     sub1 = {11, 5}, sub2 = {3, -1}, Magic Number = abs(11 - 3) + abs(5 - -1) = 14
     sub1 = {-1, 5}, sub2 = {3, 11}, Magic Number = abs(-1 - 3) + abs(5 - 11) = 10 
     maximum of all magic number = 14 % 10^9 + 7 = 14
     minimum of all magic number = 10 % 10^9 + 7 = 10

Explanation 2:
    Answer is evident.
```
### Hints
* Hint 1
```text
You can try sorting the array first. This will help you 
formulate your solution easier maybe make the thought 
process clearer.
```
* Solution Approach
```text
Initially, sort the array.
For the minimum magic, find the sum of the difference 
between adjacent elements in pairs of two.

for i=1 ; i<n ; i+=2
    min_magic+=a[i]-a[i-1]

For the maximum magic, find the sum of the difference 
between the two elements equidistant from the front 
and back of the array.

for i=0 ; i<n/2 ; i++
    max_magic+=a[n/2+i]-a[i]
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public ArrayList < Integer > solve(ArrayList < Integer > A) {
        int mod = 1000 * 1000 * 1000 + 7;
        // sorting the array
        Collections.sort(A);
        int n = A.size();
        long mins = 0, maxs = 0;
        // for minimum magic number
        for (int i = 1; i < n; i += 2) {
            mins += (A.get(i) - A.get(i - 1));
            mins %= mod;
        }
        // for maximum magic number
        for (int i = 0; i < n / 2; i++) {
            maxs += (A.get(n - 1 - i) - A.get(i));
            maxs %= mod;
        }
        ArrayList < Integer > ans = new ArrayList < Integer > (2);
        ans.add((int) maxs);
        ans.add((int) mins);
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    solve: function (A) {
        // sorting the array
        A.sort((a, b) => a - b);
        let mx = 0,
            mn = 0;
        const MOD = 1e9 + 7;
        // for minimum magic number
        for (let i = 1; i < A.length; i += 2) {
            mn += Math.abs(A[i] - A[i - 1]);
            mn %= MOD;
        }
        // for maximum magic number
        let i = 0,
            j = A.length - 1;
        while (i < j) {
            mx += Math.abs(A[j--] - A[i++]);
            mx %= MOD;
        }
        return [mx, mn];
    },
};
```
* * Solution in C++
```cpp
#define ll long long
#define mod 1000000007
vector < int > Solution::solve(vector < int > &A) {
    int n = A.size();
    // sorting the array
    sort(A.begin(), A.end());
    
    ll min_magic = 0, max_magic = 0;
    
    // for minimum magic number    
    for (int i = 1; i < n; i += 2)
        min_magic += (ll)(A[i] - A[i - 1]);

    // for maximum magic number
    for (int i = 0; i < n / 2; i++)
        max_magic += (ll)(A[n/2+i] - A[i]);
    
    vector < int > ans(2);
    ans[0] = max_magic % mod;
    ans[1] = min_magic % mod;
    return ans;
}
```

