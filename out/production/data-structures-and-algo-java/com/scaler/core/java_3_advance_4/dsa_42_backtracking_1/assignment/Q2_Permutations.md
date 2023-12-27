### Q2. Permutations
#### Problem Description
```text
Given an integer array A of size N denoting collection of numbers , return all possible 
permutations.

NOTE:

No two entries in the permutation sequence should be the same.
For the purpose of this problem, assume that all the numbers in the collection are unique.
Return the answer in any order

WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS. 
Example : next_permutations in C++ / itertools.permutations in python.
If you do, we will disqualify your submission retroactively and give you penalty points.
```
#### Problem Constraints
```text
1 <= N <= 9
```
#### Input Format
```text
Only argument is an integer array A of size N.
```
#### Output Format
```text
Return a 2-D array denoting all possible permutation of the array.
```
#### Example Input
```text
Input
 A = [1, 2, 3]
```
#### Example Output
```text
Output
 [ [1, 2, 3]
   [1, 3, 2]
   [2, 1, 3] 
   [2, 3, 1] 
   [3, 1, 2] 
   [3, 2, 1] ]
```
#### Example Explanation
```text
Explanation
    All the possible permutation of array [1, 2, 3].
```
### Hints
* Hint 1
```text
Again, what helps here is thinking in terms of recursion.

At each step you can keep any of the elements from the remaining one and permute 
remaining one excluding current one.
```
* Solution Approach
```text
Heap’s algorithm is used to generate all permutations of n objects. The idea is to 
generate each permutation from the previous permutation by choosing a pair of elements 
to interchange, without disturbing the other n-2 elements.

Algorithm:

    1). The algorithm generates (n-1)! permutations of the first n-1 elements, adjoining 
        the last element to each of these. This will generate all of the permutations that 
        end with the last element.

    2). If n is odd, swap the first and last element and if n is even, then swap the ith 
        element (i is the counter starting from 0) and the last element and repeat the above 
        algorithm till i is less than n.

    3). In each iteration, the algorithm will produce all the permutations that end with 
        the current last element.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    private boolean[] marked;
    private ArrayList<ArrayList<Integer>> res;
    private ArrayList<Integer> A;
    private int n;

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        n = A.size();
        marked = new boolean[n];
        res = new ArrayList<>();
        this.A = A;
        rec(0, new ArrayList<>());
        return res;
    }

    public void rec(int idx, ArrayList<Integer> temp) {
        if (idx == n) {
            res.add(new ArrayList<>(temp));
            return;
        }
        // try all possible elements for the current position
        for (int i = 0; i < n; i++) {
            if (!marked[i]) {
                marked[i] = true;
                temp.add(A.get(i));
                rec(idx + 1, temp);
                marked[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : array of integers
    //return a array of array of integers
    permute: function (A) {
        if (A.length == 1) {
            return [A];
        }
        var ans = [[A[0]]];
        for (var i = 1; i < A.length; i++) {
            var len = ans.length;
            for (var j = 0; j < len; j++) {
                var curr = ans.shift();
                for (var k = 0; k <= curr.length; k++) {
                    var temp = curr.slice(0);
                    temp.splice(k, 0, A[i]);
                    ans.push(temp);
                }
            }
        }
        return ans;
    }
};
```
* * Solution in C++
```cpp
void permutes(vector<int> & num, int start, vector<vector<int>> & result) {
    if (start == num.size() - 1) {
        result.push_back(num);
        return;
    }
    // try all possible elements for the current position
    for (int i = start; i < num.size(); i++) {
        swap(num[start], num[i]);
        permutes(num, start + 1, result);
        swap(num[start], num[i]);
    }
}

vector<vector<int>> Solution::permute(vector<int> &A) {
    vector<vector<int>> result;
    if (A.size() == 0)
        return result;
    permutes(A, 0, result);
    return result;
}
```

