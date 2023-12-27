### Q4. Flip and Find Nearest
#### Problem Description
```text
Given a binary string A of size N. There are Q queries given by 
the array B of size Q*2.

Each query is given by :-

1 X :- Flip the bit of the X-th position in A

2 X :- Find the index of the nearest '1' from X. If there are 
       multiple such indexes, return the one with the lower 
       index. Return -1 if there are no '1's in A

Note :- We use 1-based indexing
```
#### Problem Constraints
* <p>1 &lt;= N &lt;= 10<sup>5</sup></p>
* <p>1 &lt;= Q &lt;= 10<sup>5</sup></p>
* <p>1 &lt;= B[i][0] &lt;= 2</p>
* <p>1 &lt;= B[i][1] &lt;= N</p>
```text
1 <= N <= 10^5

1 <= Q <= 10^5

1 <= B[i][0] <= 2

1 <= B[i][1] <= N
```
#### Input Format
```text
First argument A is a string.

Second argument B is a 2D array of integers describing the queries.
```
#### Output Format
```text
Return an array of integers denoting the answers to each query of type 2.
```
#### Example Input
```text
Input 1:
 A = "10010"
 B = [[1, 2]
      [2, 3]]

Input 2:
 A = "010000100"
 B = [[2, 5]
      [1, 7]
      [2, 9]]
```
#### Example Output
```text
Output 1:
 [2]

Output 2:
 [7, 2]
```
#### Example Explanation
```text
Explanation 1:
    For Input 1:
    After first query, A = "11010".
    For second query, X = 3. Both index 2 and index 4 are at the same 
    distance but we choose the lower index.

Explanation 2:
    For Input 2:
    For first query, the index 2 is at a distance 3 and index 7 is 
    at a distance 2. So we choose index 7.
    After second query, A = "010000000"
    For third query, the only index with '1' is 2.
```
### Hints
* Hint 1
```text
We can keep a store of all the indexes that has '1' in the string A.
Then we can perform some operations to get the nearest '1' for each query.
```
* Solution Approach
```text
We will use a sorted set to store all indexes that has '1' in A.

For query of type 1, we will remove that index from the set if it is already
present in it or add the index if it is not present.

For query of type 2, we will use lower_bound operation to find the nearest index
with a '1'.

Time Complexity : O(NlogN + QlogN)
Space Complexity : O(N + Q)

```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int[] solve(String A, int[][] B) {
        final int inf = (int)(1e9);
        TreeSet<Integer> set = new TreeSet<Integer>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        // set stores the index of all '1's
        for(int i = 0; i < A.length(); i++){
            if(A.charAt(i) == '1'){
                set.add(i + 1);
            }
        }
        for(int i = 0; i < B.length; i++){
            int type = B[i][0];
            int x = B[i][1];
            if(type == 1){
                if(set.contains(x)){
                    // flip the bit from '1' to '0'
                    set.remove(x);
                }
                else{
                    // flip the bit from '0' to '1'
                    set.add(x);
                }
            }
            else{
                int left = -inf, right = inf;
                if(set.ceiling(x) != null){
                    // finds the nearest '1' on the right
                    right = set.ceiling(x);
                }
                if(set.floor(x) != null){
                    // finds the nearest '1' on the left
                    left = set.floor(x);
                }
                if(left == -inf && right == inf){
                    ans.add(-1);
                }
                else if(x - left <= right - x){
                    ans.add(left);
                }
                else{
                    ans.add(right);
                }
            }
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
}
```
* * Solution in Javascript
```javascript

```
* * Solution in C++
```cpp
const int inf = 1e9;
vector<int> Solution::solve(string A, vector<vector<int> > &B) {
    int n = A.size();
    set<int> indexes;
    // indexes stores the index of all '1's
    for(int i = 0; i < n; i++){
        if(A[i] == '1'){
            indexes.insert(i + 1);
        }
    }
    vector<int> ans;
    for(int i = 0 ; i < B.size() ; i++){
        int type = B[i][0];
        int pos = B[i][1];
        if(type == 1){
            if(indexes.find(pos) == indexes.end()){
                // flip the bit from '0' to '1'
                indexes.insert(pos);
            }
            else{
                // flip the bit from '1' to '0'
                indexes.erase(pos);
            }
        }    
        else{
            if(indexes.size() == 0){
                ans.push_back(-1);
                continue;
            }
            int left = -inf, right = inf;
            if(indexes.lower_bound(pos) != indexes.end()){
                // finds the nearest '1' on the right
                right = *indexes.lower_bound(pos);
            }
            if(*indexes.begin() < pos){
                // finds the nearest '1' on the left
                left = *(--indexes.lower_bound(pos));
            }
            if(pos - left <= right - pos){
                ans.push_back(left);
            }
            else{
                ans.push_back(right);
            }
        }
    }
    return ans;
}
```

