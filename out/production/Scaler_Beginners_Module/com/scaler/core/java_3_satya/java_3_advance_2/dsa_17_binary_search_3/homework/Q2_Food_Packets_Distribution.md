### Q2. Food Packets Distribution
#### Problem Description
```text
The government wants to set up B distribution offices across N cities for the 
distribution of food packets.

The population of the i^th city is A[i]. Each city must have at least 1 office and 
every person is assigned to exactly one office in their own city.

Let M denote the minimum number of people that are assigned to any of the offices. 
Find the maximum value of M possible.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= N &lt;= 10<sup>5</sup></p>
    <p>1 &lt;= A[i] &lt;= 10<sup>6</sup></p>
    <p>1 &lt;= B &lt;= 5 x 10<sup>5</sup></p>
</div>

```text
1 <= N <= 10^5

1 <= A[i] <= 10^6

1 <= B <= 5 x 10^5
```
#### Input Format
```text
The first line of input contains an integer array A. 

The second line of input contains an integer B.
```
#### Output Format
```text
Return one integer representing the maximum number of people who can get food in 
any single office.
```
#### Example Input
```text
Input 1:
  A = [10000, 22000, 36000]
  B = 6
Input 2:
  A = [1, 1, 1]
  B = 4
```
#### Example Output
```text
Output 1:
  10000

Output 2:
  0
```
#### Example Explanation
```text
Explanation 1:
    1 office can be opened in the first city,
    2 offices in the second city and
    3 in the third. This way ,
    10,000 people can get food in the office in the first city, and
    11,000 people can get food in each office in the second city and
    12,000 people can get food in third city.
    Had we allotted more in some office, we had to allot lesser in some other office 
    which will reduce the answer.

Explanation 2:
    We will have to allot 2 offices to one city. And one of these offices would 
    give food to 0 people. 
```
### Hints
* Hint 1
```text
If we allot x offices to a city, how many maximum number of people can go to a single office.

Can we check we can get a given number of people in any single office?
```
* Solution Approach
```text
If we allot x offices to a city, then a[i]/x number of people can go to a single office.

Hence, for checking if a given number of people can go to a single office, we can 
add a[i]/x for all cities and check if it is greater than B.

Observe that the answer is monotonic, So we can binary search for the answer.

Check for 0 explicitly.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    static long te, n, b;
    static long[] a = new long[100005];
    public static boolean check(long p) {
        long c = 0;
        for (int i = 0; i < n; i++)
            c += (a[i] / p);
        return c >= b;
    }
    public int solve(int[] A, int B) {
        n = A.length;
        long mn = 1000000000, sm = 0;
        for (int i = 0; i < n; i++) {
            a[i] = (long) A[i];
            sm += a[i];
            mn = Math.min(mn, a[i]);
        }
        b = B;
        if (sm < b)
            return 0;
        long l = 1, h = mn, m;
        while (h - l > 1) {
            m = (l + h) / 2;
            if (check(m))
                l = m;
            else
                h = m;
        }
        if (check(h))
            return (int) h;
        else
            return (int) l;
    }
}
```
* * Solution in Javascript
```javascript
let te, n, b;
 let a = new Array(100005);

 function check(p) {
     let c = 0;
     for (let i = 0; i < n; i++)
         c += Math.floor(a[i] / p);
     return c >= b;
 }
 module.exports = {
     //param A : array of integers
     //param B : integer
     //return an integer
     solve: function (A, B) {
         n = A.length;
         let mn = 1000000000,
             sm = 0;
         for (let i = 0; i < n; i++) {
             a[i] = A[i];
             sm += a[i];
             mn = Math.min(mn, a[i]);
         }
         b = B;
         if (sm < b)
             return 0;
         let l = 1,
             h = mn,
             m;
         while (h - l > 1) {
             m = (l + h) >> 1;
             if (check(m))
                 l = m;
             else
                 h = m;
         }
         if (check(h))
             return h;
         else
             return l;
     }
 };
```
* * Solution in C++
```cpp
long long te, n, b, a[100005];
bool check(long long p) {
    long long c = 0;
    for (int i = 0; i < n; i++)
        c += (a[i] / p);
    return c >= b;
}
int Solution::solve(vector < int > & A, int B) {
    n = A.size();
    long long mn = 1000000000, sm = 0;
    for (int i = 0; i < n; i++) {
        a[i] = A[i];
        sm += a[i];
        mn = min(mn, a[i]);
    }
    b = B;
    if (sm < b)
        return 0;
    long long l = 1, h = mn, m;
    while (h - l > 1) {
        m = (l + h) / 2;
        if (check(m))
            l = m;
        else
            h = m;
    }
    if (check(h))
        return h;
    else
        return l;
}
```

