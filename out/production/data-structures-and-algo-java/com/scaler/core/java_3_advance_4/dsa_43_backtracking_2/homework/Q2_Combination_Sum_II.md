### Q2. Combination Sum II
#### Problem Description
```text
Given an array of size N of candidate numbers A and a target number B. Return 
all unique combinations in A where the candidate numbers sums to B.

Each number in A may only be used once in the combination.

Note:

    1. All numbers (including target) will be positive integers.
    2. Elements in a combination (a1, a2, … , ak) must be in non-descending 
       order. (ie, a1 ≤ a2 ≤ … ≤ ak).
    3. The solution set must not contain duplicate combinations.

Warning:

DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.

Example : itertools.combinations in python. If you do, we will disqualify your 
submission and give you penalty points.
```
#### Problem Constraints
```text
1 <= N <= 20
```
#### Input Format
```text
First argument is an integer array A denoting the collection of candidate numbers.
Second argument is an integer which represents the target number.
```
#### Output Format
```text
Return all unique combinations in A where the candidate numbers sums to B.
```
#### Example Input
```text
Input 1:
 A = [10, 1, 2, 7, 6, 1, 5]
 B = 8

Input 2:
 A = [2, 1, 3]
 B = 3
```
#### Example Output
```text
Output 1:
 [ 
  [1, 1, 6 ],
  [1, 2, 5 ],
  [1, 7 ], 
  [2, 6 ] 
 ]

Output 2:
 [
  [1, 2 ],
  [3 ]
 ]
```
#### Example Explanation
```text
Explanation 1:
     1 + 1 + 6 = 8
     1 + 2 + 5 = 8
     1 + 7 = 8
     2 + 6 = 8
     All the above combinations sum to 8 and are arranged in ascending order.

Explanation 2:
     1 + 2 = 3
     3 = 3
     All the above combinations sum to 3 and are arranged in ascending order.
```
### Hints
* Hint 1
```text
Think how can you use recursion with current index and target sum in order 
to generate all combinations.

Also, you will have to take special care of those elements which can be overcounted 
as they are repeated.
```
* Solution Approach
```text
Some elements can be repeated in the input set.
Make sure you iterate over the number of occurrences of those elements to make sure 
you are not counting the same combinations again.

Once you do that, things are fairly straightforward. Backtracking is the solution here.
You make a recursive call with the remaining sum and make sure the indices are 
moving forward.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    ArrayList < ArrayList < Integer >> res;
    public ArrayList < ArrayList < Integer >> combinationSum(ArrayList < Integer > A, int B) {
        if (A == null)
            return null;
        res = new ArrayList < > ();
        Collections.sort(A);
        rec(A, new ArrayList < > (), B, 0);
        return res;
    }
    public void rec(ArrayList < Integer > A, ArrayList < Integer > ans, int B, int index) {
        if (B == 0) {
            res.add(new ArrayList < > (ans));
            return;
        }
        if (B < 0 || index >= A.size())
            return;
        int i = index + 1;
        for (; i < A.size(); i++)
            if (A.get(i) != A.get(i - 1))
                break;
        rec(A, ans, B, i);
        ans.add(A.get(index));
        rec(A, ans, B - A.get(index), index + 1);
        ans.remove(ans.size() - 1);
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    combinationSum: function (candidates, target) {
        if (!candidates || candidates.length == 0) return [];
        let res = [];
        candidates.sort((a, b) => a - b);
        var helper = function (curSum, cur, index) {
            if (curSum == target) {
                res.push([...cur]);
                return;
            }
            // try for all possible next candidate
            for (let i = index; i < candidates.length; i++) {
                if (i != index && candidates[i] == candidates[i - 1]) continue;
                if (curSum > target) return;
                cur.push(candidates[i]);
                helper(curSum + candidates[i], cur, i + 1);
                cur.pop();
            }
        };
        helper(0, [], 0);
        return res;
    },
};
```
* * Solution in C++
```cpp
void recur(vector < int > & A, int B, vector < int > v, vector < vector < int >> & ans, int sum, int index) {
    if (sum > B) return;
    if (sum == B) {
        ans.push_back(v);
        return;
    }
    // try for all possible next candidate
    for (int i = index; i < A.size(); ++i) {
        v.push_back(A[i]);
        recur(A, B, v, ans, sum + A[i], i + 1);
        v.pop_back();
    }
    return;
}

vector < vector < int > > Solution::combinationSum(vector < int > & A, int B) {
    vector < int > v;
    vector < vector < int >> ans;
    sort(A.begin(), A.end());
    recur(A, B, v, ans, 0, 0);
    for (auto & x: ans) {
        sort(x.begin(), x.end());
    }
    set < vector < int >> s(ans.begin(), ans.end());
    vector < vector < int >> temp(s.begin(), s.end());

    return temp;
}
```

