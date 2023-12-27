### Q1. Number of Squareful Arrays
#### Problem Description
```text
Given an array of integers A, the array is squareful if for every pair of adjacent elements, 
their sum is a perfect square.

Find and return the number of permutations of A that are squareful. 
Two permutations A1 and A2 differ if and only if there is some index i 
such that A1[i] != A2[i].
```
#### Problem Constraints
```text
1 <= length of the array <= 12

1 <= A[i] <= 10^9
```
#### Input Format
```text
The only argument given is the integer array A.
```
#### Output Format
```text
Return the number of permutations of A that are squareful.
```
#### Example Input
```text
Input 1:
 A = [2, 2, 2]
Input 2:
 A = [1, 17, 8]
```
#### Example Output
```text
Output 1:
 1

Output 2:
 2
```
#### Example Explanation
```text
Explanation 1:
    Only permutation is [2, 2, 2], the sum of adjacent element is 4 and 4 and 
    both are perfect square.

Explanation 2:
    Permutation are [1, 8, 17] and [17, 8, 1].
```
### Hints
* Hint 1
```text
Construct a graph where an edge from i to j exists if A[i] + A[j] is a perfect square.

Our goal is to investigate Hamiltonian paths of this graph: paths that visit all the 
nodes exactly once.
```
* Solution Approach
```text
Construct a graph where an edge from i to j exists if A[i] + A[j] is a perfect square.

Our goal is to investigate Hamiltonian paths of this graph: paths that visit all the 
nodes exactly once.

Let’s keep a current count of what values of nodes are left to visit, and a 
count todo of how many nodes left to visit.

From each node, we can explore all neighboring nodes (by value, which reduces the complexity).

Alternate solution that is explained in the video:
We can also go through all permutations and then check which ones satisfy the given 
condition in the problem.

But since this will be very time inefficient, we can instead only permute further 
when we are sure that the current permutation will lead to the answer, this is called 
pruning. More details are in the video explanation.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    boolean isPerfectSquare(int n) {
        int m = (int) Math.sqrt(n) - 2;
        while (1L * m * m < n) m++;
        return m * m == n;
    }

    public int solve(int[] A) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int N = A.length;
        for (int i = 0; i < N; i++) {
            count.put(A[i], count.getOrDefault(A[i], 0) + 1);
        }
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (isPerfectSquare(A[i] + A[j])) {
                    // add an edge from i to j and j to i
                    HashSet<Integer> set = graph.getOrDefault(A[i], new HashSet<Integer>());
                    if (!set.contains(A[j])) {
                        set.add(A[j]);
                        graph.put(A[i], set);
                    }
                    set = graph.getOrDefault(A[j], new HashSet<Integer>());
                    if (!set.contains(A[i])) {
                        set.add(A[i]);
                        graph.put(A[j], set);
                    }
                }
            }
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i : count.keySet()) {
            backtrack(graph, count, N, i, new ArrayList<Integer>(), res);
        }
        return res.size();
    }

    public void backtrack(HashMap<Integer, HashSet<Integer>> graph, Map<Integer, Integer> count, int N, int value,
                          List<Integer> temp, ArrayList<ArrayList<Integer>> res) {
        if (count.get(value) == 0)
            return;
        if (!graph.containsKey(value))
            return;
        count.put(value, count.get(value) - 1);
        temp.add(value);
        if (temp.size() == N) {
            res.add(new ArrayList<Integer>(temp));
        } else {
            for (int i : graph.get(value)) {
                // traverse all adjacent vertices
                backtrack(graph, count, N, i, temp, res);
            }
        }
        temp.remove(temp.size() - 1);
        count.put(value, count.get(value) + 1);
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
  solve: function (A) {
    if (A.length < 2) return 0;
    return numSquarefulPerms(A);
  },
};
const isSquarable = (a, b) => {
  const root = parseInt(Math.sqrt(a + b));
  return root * root === a + b;
};

const numSquarefulPerms = (A) => {
  let resultsCount = 0;
  let res = [];
  let used = {};

  A.sort((a, b) => a - b);
  const traverse = () => {
    if (res.length === A.length) {
      return resultsCount++;
    }

    let lastPushed;
    for (let i = 0; i < A.length; i++) {
      if (
        used[i] ||
        A[i] === lastPushed ||
        (res.length && !isSquarable(A[i], res[res.length - 1]))
      ) {
        continue;
      }

      used[i] = true;
      lastPushed = A[i];
      res.push(A[i]);
      traverse();
      res.pop();
      used[i] = false;
    }
  };
  traverse(0);

  return resultsCount;
};
```
* * Solution in C++
```cpp
bool isPerfectSquare(int x) {
    int n = (int) sqrt(x);
    return pow(n, 2) == x;
}

void backtrack(map < int, set < int > > & graph, map < int, int > & count, int n, int value, vector < int > temp, vector < vector < int > > & res) {
    if (count[value] == 0) {
        return;
    }
    if (graph.find(value) == graph.end()) {
        return;
    }
    count[value]--;
    temp.push_back(value);
    if (temp.size() == n) {
        res.push_back(vector < int > (temp.begin(), temp.end()));
    } else {
        for (auto i: graph[value]) {
            // traverse all adjacent vertices
            backtrack(graph, count, n, i, temp, res);
        }
    }
    temp.pop_back();
    count[value]++;
}

int Solution::solve(vector < int > & A) {
    map < int, int > count;
    int i, j, n = A.size();
    for (i = 0; i < n; i++) {
        count[A[i]]++;
    }
    map < int, set < int > > graph;
    for (i = 0; i < n - 1; i++) {
        for (j = i + 1; j < n; j++) {
            if (isPerfectSquare(A[i] + A[j])) {
                // add an edge from i to j and j to i
                set < int > s = graph[A[i]];
                if (s.find(A[j]) == s.end()) {
                    s.insert(A[j]);
                    graph[A[i]] = s;
                }
                s = graph[A[j]];
                if (s.find(A[i]) == s.end()) {
                    s.insert(A[i]);
                    graph[A[j]] = s;
                }
            }
        }
    }
    vector < vector < int > > res;
    for (auto i: count) {
        vector < int > v;
        backtrack(graph, count, n, i.first, v, res);
    }
    return res.size();
}


// Alternate solution explained in the video


bool isSquare(int x) {
    int n = round(sqrt(x));
    return pow(n, 2) == x;
}

void rec(vector<int> nums, int i, int &count) {
    if (nums.size() == 1)
        return;
    if (i == nums.size() - 1) {
        if (isSquare(nums[i] + nums[i - 1]))
            count += 1;
        return;
    }
    // check for all permutations
    for (int k = i; k < nums.size(); k++) {
        if (i != k && nums[i] == nums[k])
            continue;
        swap(nums[i], nums[k]);
        if (i == 0 || (i > 0 && isSquare(nums[i] + nums[i - 1])))
            rec(nums, i + 1, count);
    }
}

int Solution::solve(vector<int> &A) {
    sort(A.begin(), A.end());
    int ans = 0;
    rec(A, 0, ans);
    return ans;
}
```

