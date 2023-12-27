### Q3. B-th Smallest Prime Fraction
#### Problem Description
```text
Given a sorted array of integers A which contains 1 and some number of primes.
Then, for every p < q in the list, we consider the fraction p / q.

What is the B-th smallest fraction considered?

Return your answer as an array of integers, where answer[0] = p and answer[1] = q.
```
#### Problem Constraints
```text
1 <= length(A) <= 2000
1 <= A[i] <= 30000
1 <= B <= length(A)*(length(A) - 1)/2
```
#### Input Format
```text
The first argument of input contains the integer array, A.
The second argument of input contains an integer B.
```
#### Output Format
```text
Return an array of two integers, where answer[0] = p and answer[1] = q.
```
#### Example Input
```text
Input 1:
 A = [1, 2, 3, 5]
 B = 3

Input 2:
 A = [1, 7]
 B = 1
```
#### Example Output
```text
Output 1:
 [2, 5]

Output 2:
 [1, 7]
```
#### Example Explanation
```text
Explanation 1:
    The fractions to be considered in sorted order are:
    [1/5, 1/3, 2/5, 1/2, 3/5, 2/3]
    The third fraction is 2/5.

Explanation 2:
    The fractions to be considered in sorted order are:
    [1/7]
    The first fraction is 1/7.
```
### Hints
* Hint 1
```text
The constraints allow us to generate all the possible combinations of pairs of fractions, 
but perhaps its time complexity is not small enough.
```
* Solution Approach
<div>
    <p>The brute-force solution for this problem would be to generate all the 
    possible combinations, sort them by their value and then return the Kth element.</p>
    <p>The complexity of this solution would be O(N<sup>2</sup>log2(N<sup>2</sup>), <br>
    which exceeds the allocated time limit.</p>
    <p>Instead, what we can do is use a min-heap such that its size never exceeds N. <br>
    We can achieve this by maintaining a heap that stores the following structure:</p>
    <div class="highlighter-rouge"><pre class="highlight"><code>(A[j]/A[i], i, j)
    </code></pre>
    </div>
    <p>We know that if we increase the denominator, the value of the fraction decreases.</p>
    <p>Initially, we push all the elements divided by the largest element, as they will 
    be the smallest fractions. <br>
    Now, we remove the smallest element in the min-heap, <br>
    increase its denominator if possible and then insert it back into the min-heap.</p>
    <p>After doing this B times, the element on the top will be the B-th smallest 
    fraction. <br>
    The complexity of this solution will be O(N<sup>2</sup>log2(N)).</p>
</div>

* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int[] solve(int[] A, int B) {
        int K = B;
        PriorityQueue < Pair > q = new PriorityQueue < Pair > (new CustomComp());
        Map < Integer, Integer > nxt = new HashMap < Integer, Integer > ();
        for (int i = A.length - 1; i > 0; i--) {
            if (nxt.containsKey(A[i]) == true)
                nxt.replace(A[i], A[i - 1]);
            else
                nxt.put(A[i], A[i - 1]);
        }

        double last = (double) A[A.length - 1];
        double d;
        if (nxt.containsKey(1) == true)
            nxt.replace(1, 0);
        else
            nxt.put(1, 0);

        for (int i = 0; i < A.length; i++) {
            d = (double) A[i] / last;
            q.offer(new Pair(d, A[i], (int) last));
        }

        while (q.size() > 0 && K > 0) {
            K--;
            if (K == 0) break;
            Pair p = q.poll();
            if (nxt.containsKey(p.tt) == true && nxt.get(p.tt) != 0) {
                p.tt = nxt.get(p.tt);
                d = (double) p.ss / (double) p.tt;
                q.offer(new Pair(d, p.ss, p.tt));
            }
        }
        int[] ret = new int[2];
        ret[0] = q.peek().ss;
        ret[1] = q.peek().tt;

        return ret;
    }
}
//class and comparator for pairs
class Pair {
    double ff;
    int ss;
    int tt;
    public Pair(double c, int d, int e) {
        this.ff = c;
        this.ss = d;
        this.tt = e;
    }
}
class CustomComp implements Comparator < Pair > {
    @Override
    public int compare(Pair a, Pair b) {
        if (a.ff > b.ff)
            return 1;
        return -1;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : array of integers
    //param B : integer
    //return a array of integers
    solve: function (A, B) {
        let [start, end] = [0, 1];
        let ans = [0, 1];
        while (start <= end) {
            let mid = (start + end) / 2;
            let cnt = 0;
            let best = -Infinity;
            // counts the number of pairs whose value fraction is less than or equal mid
            for (let i = 0, j = A.length - 1; i < A.length - 1 && j > 0;) {
                let numerator = A[i], denominator = A[A.length - j];
                let fraction = numerator / denominator;
                if (fraction <= mid) {
                    // A[i] will form a fraction less than equal to mid with j elements
                    cnt += j;
                    i++;
                    if (fraction > best) {
                        // best stores the maximum fraction value from the chosen pairs
                        best = fraction;
                        ans = [numerator, denominator];
                    }
                } else {
                    j--;
                }
            }
            if (cnt == B) {
                return ans;
            } else if (cnt > B) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return ans;
    }
};
```
* * Solution in C++
```cpp
#define y second.second
#define x second.first

vector < int > Solution::solve(vector < int > & A, int B) {
    int K = B;
    priority_queue < pair < double, pair < int, int >> , vector < pair < double, pair < int, int >>> , greater < pair < double, pair < int, int >>> > q;
    unordered_map < int, int > nxt;
    for (int i = A.size() - 1; i > 0; i--)
        nxt[A[i]] = A[i - 1];

    double last = A[A.size() - 1], d;
    nxt[1] = 0;

    for (int i = 0; i < A.size(); i++) {
        d = (double) A[i] / last;
        q.push(make_pair(d, make_pair(A[i], last)));
    }

    while (q.size() && K) {
        K--;
        if (K == 0)
            break;

        pair < double, pair < int, int >> p = q.top();
        q.pop();
        if (nxt[p.y] != 0) {
            p.y = nxt[p.y];
            d = (double) p.x / (double) p.y;
            q.push(make_pair(d, p.second));
        }
    }

    vector < int > ret(2);
    ret[0] = q.top().second.first;
    ret[1] = q.top().second.second;

    return ret;
}
```

