### Q4. Subsets II
#### Problem Description
```text
Given a collection of integers denoted by array A of size N that might contain 
duplicates, return all possible subsets.

NOTE:
    * Elements in a subset must be in non-descending order.
    
    * The solution set must not contain duplicate subsets.
    
    * The subsets must be sorted lexicographically.
```
#### Problem Constraints
```text
0 <= N <= 16
```
#### Input Format
```text
Only argument is an integer array A of size N.
```
#### Output Format
```text
Return a 2-D vector denoting all the possible subsets.
```
#### Example Input
```text
Input 1:
 A = [1, 2, 2]

Input 2:
 A = [1, 1]
```
#### Example Output
```text
Output 1:
 [
    [],
    [1],
    [1, 2],
    [1, 2, 2],
    [2],
    [2, 2]
 ]

Output 2:
 [
    [],
    [1],
    [1, 1]
 ]
```
#### Example Explanation
```text
Explanation 1:
    All the subsets of the array [1, 2, 2] in lexicographically sorted order.
```
### Hints
* Hint 1
```text
Think in terms of recursion.

Make sure not to include repetitive elements in such a way that they get over-counted.
```
* Solution Approach
```text
Think in terms of recursion.
This is very similar to the problem where you need to generate subsets for distinct integer. 
However, in this case, because of repetitions, things are not as simple as choosing or 
rejecting an element.

Now for the elements which are repeated you need to iterate over the count of elements 
you are going to include in your subset.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    ArrayList<ArrayList<Integer>> res;

    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        res = new ArrayList<>();
        if (A == null)
            return null;
        // to get same elements together
        Collections.sort(A);
        rec(A, new ArrayList<>(), 0);
        Collections.sort(res, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> a, List<Integer> b) {
                int size = Math.min(a.size(), b.size());
                for (int i = 0; i < size; i++) {
                    int cmp = Integer.compare(a.get(i), b.get(i));
                    if (cmp != 0)
                        return cmp;
                }
                return Integer.compare(a.size(), b.size());
            }
        });
        return res;
    }

    public void rec(ArrayList<Integer> A, ArrayList<Integer> ans, int index) {
        if (index >= A.size()) {
            res.add(new ArrayList<>(ans));
            return;
        }
        int curIndex = index + 1;
        while (curIndex < A.size() && A.get(curIndex) == A.get(index))
            curIndex++;
        // Take the element A[index] i times
        for (int i = 0; i <= (curIndex - index); i++) {
            for (int j = 0; j < i; j++)
                ans.add(A.get(index));
            rec(A, ans, curIndex);
            for (int j = 0; j < i; j++)
                ans.remove(ans.size() - 1);
        }
    }
}
```
* * Solution in Javascript
```javascript
function lexicoSort(a, b) {
  for (let i = 0; i < Math.min(a.length, b.length); i++) {
    if (a[i] < b[i]) return -1;
    else if (b[i] < a[i]) return 1;
  }
  return a.length - b.length;
}
module.exports = {
  subsetsWithDup: function (A) {
    let ret = new Array();
    // generate all unique subsets
    for (let i = 0; i < 1 << A.length; i++) {
      let cur = [];
      for (let j = 0; j < A.length; j++) {
        if ((i >> j) & 1) {
          cur.push(A[j]);
        }
      }
      cur.sort((a, b) => a - b);
      ret.push(cur);
    }
    ret = Array.from(new Set(ret.map(JSON.stringify)), JSON.parse);
    ret.sort(lexicoSort);
    return ret;
  },
};
```
* * Solution in C++
```cpp
void generateSubsets(vector < int > & S, int index, vector < int > & current, vector < vector < int > > & result) {
    if (index >= S.size()) {
        result.push_back(current);
        return;
    }
    // Find the number of occurence of the element at current index. 
    int curIndex = index + 1;
    while (curIndex < S.size() && S[curIndex] == S[index]) {
        curIndex++;
    }
    // There are curIndex - index number of repeating entries. 
    // Now we loop over the number of entries to include in our subset. 
    for (int i = 0; i <= (curIndex - index); i++) {
        for (int j = 0; j < i; j++) current.push_back(S[index]);
        generateSubsets(S, curIndex, current, result);
        for (int j = 0; j < i; j++) current.pop_back();
    }
}
vector < vector < int > > Solution::subsetsWithDup(vector < int > & A) {
    assert(A.size() >= 0 && A.size() <= 16);
    vector < vector < int > > result;
    vector < int > current;
    sort(A.begin(), A.end());
    generateSubsets(A, 0, current, result);
    sort(result.begin(), result.end());
    return result;
}
```

