### Q3. Subset
#### Problem Description
```text
Given a set of distinct integers A, return all possible subsets.

NOTE:

    * Elements in a subset must be in non-descending order.
    * The solution set must not contain duplicate subsets.
    * Also, the subsets should be sorted in ascending ( lexicographic ) order.
    * The list is not necessarily sorted.
```
#### Problem Constraints
```text
1 <= |A| <= 16
INTMIN <= A[i] <= INTMAX
```
#### Input Format
```text
First and only argument of input contains a single integer array A.
```
#### Output Format
```text
Return a vector of vectors denoting the answer.
```
#### Example Input
```text
Input 1:
 A = [1]

Input 2:
 A = [1, 2, 3]
```
#### Example Output
```text
Output 1:
 [
     []
     [1]
 ]

Output 2:
 [
  []
  [1]
  [1, 2]
  [1, 2, 3]
  [1, 3]
  [2]
  [2, 3]
  [3]
 ]
```
#### Example Explanation
```text
Explanation 1:
    You can see that these are all possible subsets.

Explanation 2:
    You can see that these are all possible subsets.
```
### Hints
* Hint 1
```text
Think in terms of recursion.

How can you simulate the choices of elements in a subset?
```
* Solution Approach

<div style="background-color: #f9f9f9; padding: 5px 10px; ">
    <p>For every element, you have 2 options.</p>
    <p>You may either include the element in your subset or do not 
    include the element in your subset.</p>
    <p>Make the call for both cases.<br>
    Remember to include a base case to avoid infinite calling.</p>
    <p>Can you also do it iteratively?<br>
    Hint: You can use the fact that each number from 0 to 2
    <sup>N</sup> - 1, represent each subset of N elements.</p>
</div>

```text
For every element, you have 2 options.

You may either include the element in your subset or do not 
include the element in your subset.

Make the call for both cases.
Remember to include a base case to avoid infinite calling.

Can you also do it iteratively?
Hint: You can use the fact that each number from 0 to 2^N - 1, 
represent each subset of N elements.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    ArrayList<ArrayList<Integer>> ans;

    void solve(int idx, ArrayList<Integer> cur, ArrayList<Integer> A) {
        if (idx == A.size()) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        solve(idx + 1, cur, A); // not take
        int element = A.get(idx);
        cur.add(element); // DO
        solve(idx + 1, cur, A); // take
        cur.remove(cur.size() - 1); // UNDO
    }

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        Collections.sort(A);
        ans = new ArrayList<>();
        ArrayList<Integer> cur = new ArrayList<>();
        solve(0, cur, A);
        // sort the list of list
        Collections.sort(ans, (ArrayList<Integer> first, ArrayList<Integer> second) -> {
            for (int i = 0; i < first.size() && i < second.size(); i++) {
                if (first.get(i) < second.get(i))
                    return -1;
                if (first.get(i) > second.get(i))
                    return 1;
            }
            if (first.size() > second.size())
                return 1;
            return -1;
        });
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
var res; 
function subsetsRec(arr , A) {
    res.push(arr.sort(function(a , b) {
        return a - b 
    }));
    if(A.length !== 0) {
        // for every element we can either take it or skip it
        for(var i = 0; i < A.length; i++) 
            subsetsRec(arr.concat(A[i]) , A.slice(i + 1 , A.length));
    }
}

module.exports = {
 //param A : array of integers
 //return a array of array of integers
	subsets : function(A){
	    A.sort(function(a , b) {
	        return a - b 
	    });
	    res = [];
	    subsetsRec([] , A);
	    return res;
	}
};
```
* * Solution in C++
```cpp
void subset(vector < int > & A, vector < vector < int >> & ans, vector < int > temp, int index) {
    // insert the current subset to our answer
    ans.push_back(temp);
    for (int i = index; i < A.size(); i++) {
        // for every element we can either take it or skip it
        temp.push_back(A[i]);
        subset(A, ans, temp, i + 1);
        temp.pop_back();
    }
    return;
}
vector < vector < int > > Solution::subsets(vector < int > & A) {
    vector < vector < int >> ans;
    sort(A.begin(), A.end());
    int index = 0;
    vector < int > temp;
    subset(A, ans, temp, index);
    return ans;
}
```

