### Q2. First Missing Integer
#### Problem Description
```text
Given an unsorted integer array, A of size N. 
Find the first missing positive integer.

Note: Your algorithm should run in O(n) time 
and use constant space.
```
#### Problem Constraints
* <p>1 &lt;= N &lt;= 1000000</p>
* <p>-10<sup>9</sup> &lt;= A[i] &lt;= 10<sup>9</sup></p>
```text
1 <= N <= 1000000

-109 <= A[i] <= 109
```
#### Input Format
```text
First argument is an integer array A.
```
#### Output Format
```text
Return an integer denoting the first missing 
positive integer.
```
#### Example Input
```text
Input 1:
 [1, 2, 0]

Input 2:
 [3, 4, -1, 1]

Input 3:
 [-8, -7, -6]
```
#### Example Output
```text
Output 1:
 3

Output 2:
 2

Output 3:
 1
```
#### Example Explanation
```text
Explanation 1:

A = [1, 2, 0]
First positive integer missing from the array is 3.

```
### Hints
* Hint 1
```text
To simply solve this problem, search all positive 
integers, starting from 1 in the given array. We 
may have to search at most n+1 numbers in the 
given array. So this solution takes O(n^2) in 
the worst case.

We can use sorting to solve it in lesser time 
complexity. We can sort the array in O(NlogN) time.

Once the array is sorted, then a linear scan of 
the array is all that remains to be done.

So this approach takes O(nLogn + n) time which is O(nLogn).

We can also use hashing. We can build a hash table 
of all positive elements in the given array.

Once the hash table is built, all positive integers, 
starting from 1 can be searched here. As soon as we 
find a number that is not there in the hash 
table, we return it.

Approximately, this approach may take O(n) time, 
but it requires O(n) extra space.

But what we are really looking for is a O(n) time, 
O(1) space solution.

Note that ( N being the size of the array ), 
A[i]<=0 and A[i]>N are not the numbers you are 
looking for because the missing positive integer 
will be in the range [1, N+1].

The answer will be N+1 if and only if all of the 
elements of the array have exactly one 
occurrence of [1, N].

If using extra space was an option, creating buckets 
would have been an easy solution.

Creating an array of size N initialized to 0, 
for every value A[i], which lies in the 
range [1, N], we would have incremented its 
count in the array. Consequently, we would traverse 
the array to find the first array position with value 0, 
hence finding our answer.

However, since we are not allowed buckets, can we use 
the existing array as a bucket somehow?
```
* Solution Approach
```text
Note: numbers A[i]<=0 and A[i]>N ( N being the size 
of the array ) are not important to us since the 
missing positive integer will be in the range [1, N+1].

The answer will be N+1 only if all of the elements 
of the array are exact one occurrence of [1, N].

Creating buckets would have been an easy solution 
if using extra space was allowed.

An array of size N initialized to 0 would have 
been created.

For every value A[i], which lies in the range [1, N], 
its count in the array would have been incremented.

Finally, traversing the array would help to find the 
first array position with value 0, and that will 
be our answer.

However, usage of buckets is not allowed; can we use 
the existing array as a bucket somehow?

Now, since additional space is not allowed either, 
the given array itself needs to be used to track it.

It may be helpful to use the fact that the size of 
the set we are looking to track is [1, N]

which happens to be the same size as the size 
of the array.

This means we can use the array to track these 
elements.

We traverse the array, and if A[i] is in [1, N] range, 
we try to put in the index of same value in the array.

Time complexity : O(N)
Auxiliary Space : O(1)
```
* Complete Solution
```java
public class Solution {
    public int firstMissingPositive(ArrayList<Integer> A) {
        int n = A.size();
        for (int i = 0; i < n; i++) {
            if (A.get(i) > 0 && A.get(i) <= n) {
                int pos = A.get(i) - 1;
                if (A.get(pos) != A.get(i)) {
                    Collections.swap(A, pos, i);
                    i--;
                    // We are doing i-- as we have swapped i'th element with pos'th element and we might not have processed the pos'th element.
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (A.get(i) != i + 1) 
                return (i + 1);
        }
        return n + 1;
    }
}
```

```javascript
module.exports = {
  //param A : array of integers
  //return an integer
  firstMissingPositive: function (A) {
    A = A.map((ele) => ele - 1);
    let id = 0;
    while (id < A.length) {
        if (A[id] >= 0 && A[id] < A.length) {
            let now = A[id];
            if (A[now] != A[id]) {
                [A[now], A[id]] = [A[id], A[now]];
                id--;
                // We are doing id-- as we have swapped i'th element with pos'th element and we might not have processed the pos'th element.
            }
        }
        id++;
    }
    for (let i = 0; i < A.length; i++) {
      if (i != A[i]) return i + 1;
    }
    return A.length + 1;
  },
};
```

```cpp
int Solution::firstMissingPositive(vector<int> &A) {
    int n = A.size();
    for (int i = 0; i < n; i++) {
        if (A[i] > 0 && A[i] <= n) {
            int pos = A[i] - 1;
            if (A[pos] != A[i]) {
                swap(A[pos], A[i]);
                i--;
                // We are doing i-- as we have swapped i'th element with pos'th element and we might not have processed the pos'th element.
            }
        }
    }
    for (int i = 0; i < n; i++) {
        if (A[i] != i + 1) 
            return (i + 1);
    }
    return n + 1;
}
```

