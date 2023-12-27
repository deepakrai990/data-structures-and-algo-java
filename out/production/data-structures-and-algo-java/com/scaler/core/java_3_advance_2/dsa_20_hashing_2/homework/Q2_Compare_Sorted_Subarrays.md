### Q2. Compare Sorted Subarrays
#### Problem Description
```text
Given an array A of length N. You have to answer Q queries.

Each query will contain four integers l1, r1, l2, and r2. If sorted segment 
from [l1, r1] is the same as the sorted segment from [l2 r2], then the answer is 1 else 0.

NOTE The queries are 0-indexed.
```
#### Problem Constraints
```text
0 <= A[i] <= 100000
1 <= N <= 100000
1 <= Q <= 100000
```
#### Input Format
```text
The first argument is an array A.
The second is a 2D array B denoting queries with dimension Q * 4.
Consider i^th query as l1 = B[i][0], r1 = B[i][1], l2 = A[i][2], r2 = B[i][3].
```
#### Output Format
```text
Return an array of length Q with answers to the queries in the same order as the input.
```
#### Example Input
```text
Input 1:
 A = [1, 7, 11, 8, 11, 7, 1]
 B = [ 
       [0, 2, 4, 6]
     ]

Input 2:
 A = [1, 3, 2]
 B = [
       [0, 1, 1, 2]
     ] 
```
#### Example Output
```text
Output 1:
 [1]

Output 2:
 [0]
```
#### Example Explanation
```text
Explanation 1:
    (0, 2) -> [1, 7, 11]
    (4, 6) -> [11, 7, 1]
    Both are same when sorted hence 1.

Explanation 2:
    (0, 1) -> [1, 3]
    (1, 2) -> [3, 2] 
    Both are different when sorted hence 0.
```
### Hints
* Hint 1
```text
Think about hashing.

Try to find a hash function f(a,b) for subarray [a,a+1,…b] such that chances 
of collisions are rare.
```
* Solution Approach
```text
If both sub-arrays are the same after sorting, their sum of values will be the same. 
So, we can find the sum in the range [l1, r1] and the sum in the range[l2, r2]. If they 
are different, then we are sure that ans is 0. But, if they are equal, then? Consider 
two sub-arrays [3 5] and [4 4]. Both have sum 8, but still, they are different.

The above approach fails because the input will be carefully chosen.

Now, we can still use the same idea but let’s first assign each value a unique random 
label from a vast range like 0 to 10^13. Now, the probability of failure will be very 
less that can be neglected with given constraints.

Note: Any solution with random hashing is not 100% correct. The possibility of 
failure exists. But with a wide range of numbers probability of failure will be too small.

Note: Make sure that you assign the same label to all the occurrences. If value 5 comes 
three times, every 3 occurrences should be given the same random label. Make sure you 
are using the appropriate data type. Also, choosing an extensive range like 0 to 10^15 
can overflow long long int.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public ArrayList < Integer > solve(ArrayList < Integer > A, ArrayList < ArrayList < Integer >> B) {
        int n = A.size();
        Random rd = new Random();
        HashMap < Integer, Long > hm = new HashMap < > ();
        HashSet < Long > used = new HashSet < > ();
        long psum[] = new long[n + 1];
        for (int i = 0; i < n; i++) {
            if (!hm.containsKey(A.get(i))) {
                // generate a random number
                long hash = rd.nextLong();
                while (used.contains(hash)) {
                    hash = rd.nextLong();
                }
                hm.put(A.get(i), hash);
            }
            psum[i + 1] = psum[i] + hm.get(A.get(i));
        }
        ArrayList < Integer > ans = new ArrayList < Integer > ();
        for (ArrayList < Integer > tmp: B) {
            long val1 = psum[tmp.get(1) + 1] - psum[tmp.get(0)];
            long val2 = psum[tmp.get(3) + 1] - psum[tmp.get(2)];
            if (val1 == val2) {
                ans.add(1);
            } else {
                ans.add(0);
            }
        }
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
const N = 100000;
const INF = 2 ** 46;
let Hash = new Map();
function rand46() {
    let ret = 0;
    ret |= Math.floor(Math.random() * (2 ** 15));
    ret |= (Math.floor(Math.random() * (2 ** 15)) << 15);
    return ret;
}
function setHash(a) {
    Hash.clear();
    let n = a.length;
    for (let i = 0; i < n; i++) {
        let it = Hash.get(a[i]);
        if (!it) {
            Hash.set(a[i], rand46());
        }
    }
}
module.exports = { 
	solve : function(A, B){
        let n = A.length;
        setHash(A);
        let psum = new Array(n).fill(0);
        psum[0] = Hash.get(A[0]);
        for (let i = 1; i < n; i++) {
            psum[i] = psum[i - 1] + Hash.get(A[i]);
        }
        let q = B.length;
        let ans = new Array(q).fill(0);
        for (let i = 0; i < q; i++) {
            let v1 = psum[B[i][1]] - (B[i][0] > 0 ? psum[B[i][0] - 1] : 0);
            let v2 = psum[B[i][3]] - (B[i][2] > 0 ? psum[B[i][2] - 1] : 0);
            ans[i] = v1 === v2 ? 1 : 0;
        }
        return ans;
	}
};
```
* * Solution in C++
```cpp
const int N = 100000;
const long long int INF = 1LL << 46;
unordered_map < int, long long int > Hash;
long long int rand46() { // generates 46bit random number
    long long int ret = 0LL;
    ret |= rand();
    ret |= (((long long int) rand()) << 15);
    assert(0 <= ret);
    assert(ret < INF);
    return ret;
}

void set_hash(vector < int > & a) {
    Hash.clear();
    srand(time(NULL));
    int n = a.size();
    for (int i = 0; i < n; i++) {
        auto it = Hash.find(a[i]);
        if (it == Hash.end()) { // consider multiple occurences
            Hash[a[i]] = rand46();
        }
    }
}

vector < int > Solution::solve(vector < int > & A, vector < vector < int >> & B) {
    int n = A.size();
    set_hash(A);
    vector < long long int > psum(n, 0LL);
    psum[0] = Hash[A[0]];
    for (int i = 1; i < n; i++) {
        psum[i] = psum[i - 1] + Hash[A[i]];
    }
    int q = B.size();
    vector < int > ans(q, 0);
    for (int i = 0; i < q; i++) {
        long long int v1 = psum[B[i][1]] - ((B[i][0] > 0) ? (psum[B[i][0] - 1]) : (0LL));
        long long int v2 = psum[B[i][3]] - ((B[i][2] > 0) ? (psum[B[i][2] - 1]) : (0LL));
        ans[i] = (v1 == v2);
    }
    return ans;
}
```

