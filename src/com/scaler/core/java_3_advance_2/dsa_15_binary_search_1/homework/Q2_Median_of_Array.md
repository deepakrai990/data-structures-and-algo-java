### Q2. Median of Array
#### Problem Description
```text
There are two sorted arrays A and B of sizes N and M respectively.

Find the median of the two sorted arrays ( The median of the array formed 
by merging both the arrays ).

NOTE:

    * The overall run time complexity should be O(log(m+n)).
    * IF the number of elements in the merged array is even, then 
      the median is the average of (n/2)^th and (n/2+1)^th 
      element. For example, if the array is [1 2 3 4], the median 
      is (2 + 3) / 2.0 = 2.5.
```
* <p><strong>NOTE:</strong> </p>
  <ul>
    <li>The overall run time complexity should be <code>O(log(m+n))
    </code>.</li>
    <li>IF the number of elements in the merged array is even, 
        then the median is the average of (n/2)<sup>th</sup> 
        and (n/2+1)<sup>th</sup> element. For example, 
        if the array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5.
    </li>
  </ul>
#### Problem Constraints
* <p>1 &lt;= N + M &lt;= 2*10<sup>6</sup></p>
```text
1 <= N + M <= 2*10^6
```
#### Input Format
```text
The first argument is an integer array A of size N.
The second argument is an integer array B of size M.
```
#### Output Format
```text
Return a decimal value denoting the median of two sorted arrays.
```
#### Example Input
```text
Input 1:
 A = [1, 4, 5]
 B = [2, 3]

Input 2:
 A = [1, 2, 3]
 B = [4]
```
#### Example Output
```text
Output 1:
 3.0

Output 2:
 2.5
```
#### Example Explanation
```text
Explanation 1:
 The median of both the sorted arrays will be 3.0.

Explanation 2:
 The median of both the sorted arrays will be (2+3)/2 = 2.5.
```
### Hints
* Hint 1
```text
he expected time complexity gives away binary search in this case.
We are going to do binary search for the answer in this case.

Given a sorted array A of length m, we can split it into two parts:

{ A[0], A[1], … , A[i - 1] }	{ A[i], A[i + 1], … , A[m - 1] }
All elements in the right part are greater than elements in the left part.

The left part has i elements, and the right part has m - i elements.
There are m + 1 kinds of splits.

(i = 0 ~ m)

When i = 0, the left part has “0” elements, the right part has “m” elements.
When i = m, the left part has “m” elements, right part has “0” elements.

For the array B, we can split it in the same way:

{ B[0], B[1], … , B[j - 1] }	{ B[j], B[j + 1], … , B[n - 1] }
The left part has “j” elements, and the right part has “n - j” elements.

Put A’s left part and B’s left part into one set. (Let’s name this 
set “LeftPart”)

Put A’s right part and B’s right part into one set. (Let’s name 
this set”RightPart”)

        LeftPart           |            RightPart
{ A[0], A[1], … , A[i - 1] }	{ A[i], A[i + 1], … , A[m - 1] }
{ B[0], B[1], … , B[j - 1] }	{ B[j], B[j + 1], … , B[n - 1] }
If we can ensure the following:

    * LeftPart’s length == RightPart’s length (or RightPart’s length + 1)
    * All elements in RightPart is greater than elements in LeftPart,

Then we can split all elements in {A, B} into two parts with equal 
length, and one part is always greater than the other part.

Then the median can thus be easily found.

    * Based on condition 1, can you derive the value of j if the 
      value of i is known?
    * Can you binary search on i ?
```
* Solution Approach
```text
Given a sorted array A of length m, we can split it into two parts:

{ A[0], A[1], … , A[i - 1] }	{ A[i], A[i + 1], … , A[m - 1] }
All the elements in the right part are greater than those in the left part.

The left part has “i” elements, and the right has “m - i” elements.

There are “m + 1” kinds of splits. (i = 0 ~ m)

When i = 0, the left part has “0” elements, right part has “m” elements.

When i = m, the left part has “m” elements, right part has “0” elements.

For array B, we can split it with the same way:

{ B[0], B[1], … , B[j - 1] }	{ B[j], B[j + 1], … , B[n - 1] }
The left part has “j” elements, and the right has “n - j” elements.

Put A’s left part and B’s left part into one set. (Let us name this 
set “LeftPart”)

Put A’s right part and B’s right part into one set. (Let us name 
this set”RightPart”)

        LeftPart           |            RightPart 
{ A[0], A[1], … , A[i - 1] }	{ A[i], A[i + 1], … , A[m - 1] }
{ B[0], B[1], … , B[j - 1] }	{ B[j], B[j + 1], … , B[n - 1] }
If we can ensure the following:

1) LeftPart’s length == RightPart’s length (or RightPart’s length + 1)

2) All elements in RightPart is greater than elements in LeftPart,

Then we split all elements in {A, B} into two parts with equal 
length, and one part is always greater than the other part.

Then the median can be easily found.

The expected time complexity gives away binary search in this case.
We will do binary search for the answer in this case.

Given a sorted array A of length m, we can split it into two parts:

{ A[0], A[1], … , A[i - 1] }	{ A[i], A[i + 1], … , A[m - 1] }

All elements in the right part are greater than elements in the left part.

The left part has i elements, and the right has m - i elements.
There are m + 1 kinds of splits.

(i = 0 ~ m)

When i = 0, the left part has “0” elements, the right part has “m” elements.
When i = m, the left part has “m” elements, right part has “0” elements.

For the array B, we can split it in the same way:

{ B[0], B[1], … , B[j - 1] }	{ B[j], B[j + 1], … , B[n - 1] }

The left part has “j” elements, and the right part has “n - j” elements.

Put A’s left part and B’s left part into one set. (Let’s name this 
set “LeftPart”)

Put A’s right part and B’s right part into one set. (Let’s name 
this set”RightPart”)

        LeftPart           |            RightPart
{ A[0], A[1], … , A[i - 1] }	{ A[i], A[i + 1], … , A[m - 1] }
{ B[0], B[1], … , B[j - 1] }	{ B[j], B[j + 1], … , B[n - 1] }

If we can ensure the following:

    * LeftPart’s length == RightPart’s length (or RightPart’s length + 1)
    * All elements in RightPart is greater than elements in LeftPart,

Then we can split all elements in {A, B} into two parts with equal 
length, and one part is always greater than the other part.

Then the median can thus be easily found.
```
<hr>

<p>To ensure these two conditions, we need to ensure:</p>

  <ul>
    <li><strong>Condition 1</strong>  :
      <div class="highlighter-rouge"><pre class="highlight"><code> i + j == (m - i) + (n - j)
        OR i + j == (m - i) + (n - j) + 1
        </code></pre>
      </div>
    </li>
  </ul>

* * <p>This means if n >= m,</p>
    <div class="highlighter-rouge"><pre class="highlight"><code>i = 0 to m
        j = (m + n + 1) / 2 - i
      </code></pre>
    </div>
<ul>
  <li><strong>Condition 2</strong>
    <div>
      <pre>
        <code>B[j - 1] &lt;= A[i] and A[i - 1] &lt;= B[j]</code>
      </pre>
    </div>
    <p>Considering edge values, we need to ensure:</p>
    <div>
      <pre>
        <code>(j == 0 or i == m or B[j - 1] &lt;= A[i]) and
        (i == 0 or j == n or A[i - 1] &lt;= B[j])
        </code>
      </pre>
    </div>
    <p>So, all we need to do is:</p>
    <ul>
      <li>Search <code class="highlighter-rouge">i</code> from <code class="highlighter-rouge">0 to m</code> to find an object <code class="highlighter-rouge">i</code> to meet conditions (1) and (2) above.</li>
    </ul>
    <p><strong>And we can do this search by binary search.</strong></p>
    <p><strong>How?</strong></p>
    <ul>
      <li>
        <p>If <code>B[j0 - 1] &gt; A[i0]</code>, 
          than the object <code>ix</code> can’t be in 
          <code>[0, i0]</code>.
        </p>
        <p>Why?</p>
        <p>Because if</p>
      </li>
    </ul>
    <div>
      <pre>
        <code>  ix &lt; i0, 
          =&gt; jx = (m + n + 1) / 2 - ix &gt; j0 
          =&gt; B[jx - 1] &gt;= B[j0 - 1] &gt; A[i0] &gt;= A[ix]. 
        </code>
      </pre>
    </div>
    <p>This <strong>violates</strong> the <strong>condition (2)</strong>. 
      So <code>ix</code> can’t be less than <code>i0</code>.
    </p>
    <ul>
      <li>And if <code>A[i0 - 1] &gt; B[j0]</code>, than the object 
        <code >ix</code> can’t be in <code>[i0, m]</code>.</li>
    </ul>
    <hr>
    <p>So we can do the binary search following the steps described below:</p>
    <blockquote>
      <ul>
        <li>set <code>imin, imax = 0, m</code>, 
        then start searching in <code>[imin, imax]</code></li>
      </ul>
    </blockquote>
    <div>
      <pre>
        <code>Search in [imin, imax]:
            i = (imin + imax) / 2
            j = ((m + n + 1) / 2) - i
            if B[j - 1] &gt; A[i]: 
                search in [i + 1, imax]
            else if A[i - 1] &gt; B[j]: 
                search in [imin, i - 1]
            else:
                if m + n is odd:
                    answer is max(A[i - 1], B[j - 1])
                else:
                    answer is (max(A[i - 1], B[j - 1]) + min(A[i], B[j])) / 2
        </code>
      </pre>
    </div>
  </li>
</ul>

* Complete Solution
* * Solution in Java
```java
public class Solution {
    public double findMedianSortedArrays(final List<Integer> A, final List<Integer> B) {
	    int len = A.size() + B.size();
	    if(len % 2 == 1) 
	        return findKth(A, 0, B, 0, len / 2 + 1);
	    else return (findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)) / 2.0;
	}
	public int findKth(List<Integer> A, int A_start, List<Integer> B, int B_start, int k){
	    if(A_start >= A.size()) 
	        return B.get(B_start + k - 1);
	    if(B_start >= B.size()) 
	        return A.get(A_start + k - 1);
	    if(k == 1) 
	        return Math.min(A.get(A_start), B.get(B_start));
	    int A_key = A_start + k / 2 - 1 < A.size() ? A.get(A_start + k / 2 - 1) : Integer.MAX_VALUE;
	    int B_key = B_start + k / 2 - 1 < B.size() ? B.get(B_start + k / 2 - 1) : Integer.MAX_VALUE;
	    if(A_key < B_key)
	        return findKth(A, A_start + k / 2, B, B_start, k - k / 2);
	    else
	       return findKth(A, A_start, B, B_start + k / 2, k - k / 2);
	}
}
```
* * Solution in javascript
```javascript
module.exports = {
  //param A : array of integers
  //param B : array of integers
  //return an integer
  findMedianSortedArrays: function (A, B) {
    let INT_MAX = Number.MAX_SAFE_INTEGER;
    let INT_MIN = Number.MIN_SAFE_INTEGER;
    let maxNeed = Math.floor((A.length + B.length) / 2);
    let lo = 0,
      hi = Math.min(A.length, maxNeed),
      tot = A.length + B.length;

    while (lo <= hi) {
      let mid = (lo + hi) >> 1;
      let ele = maxNeed - mid;

      if (ele > B.length) lo = mid + 1;
      else if (
        ele - 1 >= 0 &&
        B.length &&
        mid < A.length &&
        B[ele - 1] > A[mid]
      )
        lo = mid + 1;
      else if (
        mid - 1 >= 0 &&
        A.length &&
        ele < B.length &&
        A[mid - 1] > B[ele]
      )
        hi = mid - 1;
      else {
        if (tot & 1)
          return Math.min(
            mid < A.length ? A[mid] : INT_MAX,
            ele < B.length ? B[ele] : INT_MAX
          ).toFixed(1);
        else {
          let ans =
            Math.min(
              mid < A.length ? A[mid] : INT_MAX,
              ele < B.length ? B[ele] : INT_MAX
            ) +
            Math.max(
              mid - 1 >= 0 && A.length ? A[mid - 1] : INT_MIN,
              ele - 1 >= 0 && B.length ? B[ele - 1] : INT_MIN
            );
          return (ans / 2).toFixed(1);
        }
      }
    }
    return 0;
  },
};
```
* * Solution in C++
```cpp
#include <iostream>
#include <vector>
#include <algorithm>

class Solution {
public:
    double findMedianSortedArrays(const std::vector<int>& A, const std::vector<int>& B) {
        int len = A.size() + B.size();
        if (len % 2 == 1)
            return findKth(A, 0, B, 0, len / 2 + 1);
        else
            return (findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)) / 2.0;
    }

    int findKth(const std::vector<int>& A, int A_start, const std::vector<int>& B, int B_start, int k) {
        if (A_start >= A.size())
            return B[B_start + k - 1];
        if (B_start >= B.size())
            return A[A_start + k - 1];
        if (k == 1)
            return std::min(A[A_start], B[B_start]);
        int A_key = A_start + k / 2 - 1 < A.size() ? A[A_start + k / 2 - 1] : std::numeric_limits<int>::max();
        int B_key = B_start + k / 2 - 1 < B.size() ? B[B_start + k / 2 - 1] : std::numeric_limits<int>::max();
        if (A_key < B_key)
            return findKth(A, A_start + k / 2, B, B_start, k - k / 2);
        else
            return findKth(A, A_start, B, B_start + k / 2, k - k / 2);
    }
};

int main() {
    // Example usage:
    Solution solution;
    std::vector<int> A = {1, 3};
    std::vector<int> B = {2};
    double result = solution.findMedianSortedArrays(A, B);
    std::cout << "Median: " << result << std::endl;

    return 0;
}
```
* * C++ 2
```c++
double Solution::findMedianSortedArrays(const vector<int> &A, const vector<int> &B) {
    int m = A.size(), n = B.size();
    if (m > n) 
        return findMedianSortedArrays(B, A);
    int imin, imax, i, j; 
    imin = 0;
    imax = m;
    while (imin <= imax) {
        i = (imin + imax)/2;
        j = (m+n+1)/2 - i;
        if (j > 0 && i < m && B[j - 1] > A[i])
            imin = i + 1;
        else if (i > 0 && j < n && A[i - 1] > B[j])
            imax = i - 1;
        else {
            // Figure out median now. 
            int median1 = 0, median2 = 0;
            if (i == 0)
                median1 = B[j - 1];
            else if (j == 0)
                median1 = A[i - 1];
            else
                median1 = max(A[i - 1], B[j - 1]);
                
            if ((m+n) % 2 == 1)
                return 1.0 * median1;
            if (i == m)
                median2 = B[j];
            else if (j == n)
                median2 = A[i];
            else
                median2 = min(A[i], B[j]);
            return 1.0 * (median1 + median2) / 2.0;
        }
    }
} 
```

