### Q1. Painter's Partition Problem

<p>Given 2 integers <strong>A</strong> and <strong>B</strong> 
and an array of integers <strong>C</strong> of size 
<strong>N</strong>. Element <strong>C[i]</strong> represents 
the length of <strong>i<sup>th</sup></strong> board.<br> You 
have to paint all <strong>N</strong> boards 
<strong>[C<sub>0</sub>, C<sub>1</sub>, 
C<sub>2</sub>, C<sub>3</sub> … C<sub>N-1</sub>]</strong>. 
There are <strong>A</strong> painters available and each of 
them takes <strong>B</strong> units of time to paint 
<strong>1 unit</strong> of the board.</p>

#### Problem Description
```text
Calculate and return the minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of the board.
NOTE:
1. 2 painters cannot share a board to paint. That is to say, a board cannot be painted partially by one painter, and partially by another.
2. A painter will only paint contiguous boards. This means a configuration where painter 1 paints boards 1 and 3 but not 2 is invalid.

Return the ans % 10000003.
```
#### Problem Constraints
* <p>1 &lt;= A &lt;= 1000</p>
* <p>1 &lt;= B &lt;= 10<sup>6</sup></p>
* <p>1 &lt;= N &lt;= 10<sup>5</sup></p>
* <p>1 &lt;= C[i] &lt;= 10<sup>6</sup></p>
```text
1 <= A <= 1000
1 <= B <= 10^6
1 <= N <= 10^5
1 <= C[i] <= 10^6
```
#### Input Format
```text
The first argument given is the integer A.
The second argument given is the integer B.
The third argument given is the integer array C.
```
#### Output Format
```text
Return minimum time required to paint all boards under the 
constraints that any painter will only paint contiguous 
sections of board % 10000003.
```
#### Example Input
```text
Input 1:
 A = 2
 B = 5
 C = [1, 10]

Input 2:
 A = 10
 B = 1
 C = [1, 8, 11, 3]
```
#### Example Output
```text
Output 1:
 50
Output 2:
 11
```
#### Example Explanation
```text
Explanation 1:
    Possibility 1:- One painter paints both blocks, time 
    taken = 55 units.
    
    Possibility 2:- Painter 1 paints block 1, painter 2 
    paints block 2, time take = max(5, 50) = 50
    
    There are no other distinct ways to paint boards.
    ans = 50 % 10000003

Explanation 2:
    
    Each block is painted by a painter so, Painter 1 
    paints block 1, painter 2 paints block 2, painter 3 paints block 3 
    and painter 4 paints block 4, time taken = max(1, 8, 11, 3) = 11
    ans = 11 % 10000003
```
### Hints
* Hint 1
```text
Hint: Think binary search for the answer.

If you had a function bool isPossible which could tell 
you if it is possible to paint the boards in time T or 
less, can you solve the problem?
```
* Solution Approach
```text
You are already halfway there if you have already solved 
the problem corresponding to hint1.

You can do a binary search for the answer :

  start = 0, end = max_time_possible
  mid = (start + end) / 2
  if isPossible(mid): 
      end = mid - 1
  else 
    start = mid + 1

Now, let us look into how isPossible would be implemented.

Keep assigning boards to painter greedily till the time 
taken < mid, if you run out of painters, isPossible = false.
else isPossible = true.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {

    private static final int MOD = 10000003;

    public int paint(int A, int B, ArrayList < Integer > C) {

        long res = Long.MAX_VALUE;
        long low = 0;
        long high = Long.MAX_VALUE;
        long mid;

        while (low <= high) {
            mid = low + ((high - low) >> 1);
            boolean status = possible(A, B, C, mid);
            if (status) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int)(res % MOD);
    }

    private boolean possible(int A, int B, ArrayList < Integer > C, long time) {
        int n = C.size();
        int index = 0;
        long total;

        for (int i = 0; i < A && index < n; i++) {
            total = 0;
            while (total < time && index < n) {
                total += (1L * C.get(index) * B);
                if (total > time)
                    break;
                index++;
            }
        }
        if (index != n)
            return false;
        return true;
    }
}
```
* * Solution in Javascript
```javascript
const mod = 10000003;
function check(A, B, C, mid) {
    let cnt = 1;
    let n = C.length;
    let tmp = 0;
    for (let i = 0; i < n; ++i) {
        if (tmp + C[i] * B > mid) {
            tmp = C[i] * B;
            cnt++;
        } else tmp += C[i] * B;
    }
    if (cnt <= A) return true;
    else return false;
}

module.exports = {
    paint: function (A, B, C) {
        let n = C.length;
        let low = 0;
        let high = 0;
        for (let i = 0; i < n; ++i) {
            high += C[i];
            low = Math.max(low, C[i]);
        }
        low = low * B;
        high = high * B;
        while (low < high) {
            let mid = low + Math.floor((high - low) / 2);
            if (check(A, B, C, mid)) high = mid;
            else low = mid + 1;
        }
        return low % mod;
    },
};
```
* * Solution in C++
```cpp
const int mod = 10000003;
bool check(long long A, long long B, vector < int > & C, long long mid) {
   long long cnt = 1;
   long long n = C.size();
   long long tmp = 0;
   for (int i = 0; i < n; ++i) {
      if (tmp + C[i] * B > mid) {
         tmp = C[i] * B;
         cnt++;
      } else tmp += C[i] * B;
   }
   if (cnt <= A) return true;
   else return false;
}

int Solution::paint(int A, int B, vector < int > & C) {
   int n = C.size();
   long long low = 0;
   long long high = 0;
   for (int i = 0; i < n; ++i) {
      high += C[i];
      low = max(low, (long long) C[i]);
   }
   low = low * B;
   high = high * B;
   while (low < high) {
      long long mid = low + (high - low) / 2;
      if (check(A, B, C, mid)) high = mid;
      else low = mid + 1;
   }
   return low % mod;
}
```

