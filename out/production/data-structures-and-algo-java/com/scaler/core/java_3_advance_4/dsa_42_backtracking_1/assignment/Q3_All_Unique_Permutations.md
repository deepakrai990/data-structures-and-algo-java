### Q3. All Unique Permutations
#### Problem Description
```text
Given an array A of size N denoting collection of numbers that might contain duplicates, 
return all possible unique permutations.

NOTE: No 2 entries in the permutation sequence should be the same.

WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS. 
Example : next_permutations in C++ / itertools.permutations in python.
If you do, we will disqualify your submission retroactively and give you penalty points.
```
#### Problem Constraints
```text
1 <= |A| <= 9

0 <= A[i] <= 10
```
#### Input Format
```text
Only argument is an integer array A of size N.
```
#### Output Format
```text
Return a 2-D array denoting all possible unique permutation of the array.
```
#### Example Input
```text
Input 1:

A = [1, 1, 2]
Input 2:

A = [1, 2]
```
#### Example Output
```text
Output 1:
 [ [1,1,2]
   [1,2,1]
   [2,1,1] ]

Output 2:
 [ [1, 2]
   [2, 1] ]
```
#### Example Explanation
```text
Explanation 1:
    All the possible unique permutation of array [1, 1, 2].

Explanation 2:
    All the possible unique permutation of array [1, 2].
```
### Hints
* Hint 1
```text
Try to think of a recursive solution in which iterate over the given array and on 
every iteration the ith element is picked as the first element of the current array 
and again call recursive function on the remaining suffix array.

Using recursion and backtracking we can iterate over all possible permutations but 
there will be many duplicates due to duplicate element possibility in the given array. 
How can we resolve this?
```
* Solution Approach
```text
Try to think of a recursive solution in which iterate over the given array and on 
every iteration the ith element is picked as the first element of the current array 
and again call recursive function on the remaining suffix array.

Using recursion and backtracking we can iterate over all possible permutations but 
there will be many duplicates due to duplicate element possibility in the given array. 
How can we resolve this?

Whatever approach we were following we follow the same approach just this time instead of 
iterating over the whole array in the recursive call we iterate only over the 
unique elements and reduce its frequency by 1 on further calls. This ensures that duplicate 
recursive call are not made keeping the same element in the same position. 
The frequencies can be tracked by using a frequency hashmap and updating it in the 
whole process in all recursive call and backtracking steps.

Check Implementation for details.

The overall time complexity in the worst case is O(N!) as in the worst case maximum number 
of permutations is N!.

Space Complexity - O(N)
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
        HashMap repeat = new HashMap();
        // try all possible elements for the current position
        for (int i = 0; i < n; i++) {
            if (!marked[i] && repeat.get(A.get(i)) == null) { // to avoid duplicates
                repeat.put(A.get(i), 1);
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
let ans;

function calculate(A, path) {
    if (A.length === 0) {
        ans.push(path.slice());
    }

    let last = '';
    // try all possible elements for the current position
    for (let i = 0; i < A.length; i++) {
        if (last === A[i]) {
            continue;
        }
        path.push(A[i]);
        last = A[i];
        calculate(A.slice(0, i).concat(A.slice(i + 1)), path);
        path.pop();
    }
}

module.exports = {
    //param A : array of integers
    //return a array of array of integers
    permute: function (A) {
        A.sort((a, b) => a - b);
        ans = [];
        calculate(A, []);
        return ans;
    }
};
```
* * Solution in C++
```cpp
void rec(vector<vector<int>> & result, vector<int>& hash, vector<int> current, int n) {
    if (current.size() == n) {
        result.push_back(current);
    }
    // try all possible elements for the current position
    for (int i = 0; i <= 10; i++) {
        if (hash[i] != 0) {
            hash[i]--;
            current.push_back(i);
            rec(result, hash, current, n);
            hash[i]++;
            current.pop_back();
        }
    }
}

vector<vector<int> > Solution::permute(vector<int> &A) {
    vector<vector<int>> result;
    vector<int> hash(11);
    for (int x: A)
        hash[x]++;
    vector<int> current;
    rec(result, hash, current, A.size());
    return result;
}
```

