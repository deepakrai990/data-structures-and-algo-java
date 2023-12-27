### Q3. Common Elements
#### Problem Description
```text
Given two integer arrays, A and B of size N and M, 
respectively. Your task is to find all the common 
elements in both the array.

NOTE:

    * Each element in the result should appear as many times as 
      it appears in both arrays.
    
    * The result can be in any order.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= N, M &lt;= 10<sup>5</sup></p>
    <p>1 &lt;= A[i] &lt;= 10<sup>9</sup></p>
</div>

```text
1 <= N, M <= 10^5

1 <= A[i] <= 10^9
```
#### Input Format
```text
First argument is an integer array A of size N.

Second argument is an integer array B of size M.
```
#### Output Format
```text
Return an integer array denoting the common elements.
```
#### Example Input
```text
Input 1:
 A = [1, 2, 2, 1]
 B = [2, 3, 1, 2]

Input 2:
 A = [2, 1, 4, 10]
 B = [3, 6, 2, 10, 10]
```
#### Example Output
```text
Output 1:
 [1, 2, 2]

Output 2:
 [2, 10]
```
#### Example Explanation
```text
Explanation 1:
    Elements (1, 2, 2) appears in both the array. Note 2 appears 
    twice in both the array.

Explanation 2:
    Elements (2, 10) appears in both the array.
```
### Hints
* Hint 1
```text
Store the elements of one array in hashMap and iterate over 
another to find the common elements.
```
* Solution Approach
```text
Approach 1:

Use a HashMap to store the first array, then check each second 
array element and see if it is in the map.

Note that since we need to output all repeated elements, we also 
need to count the occurrence of each array element in the map and 
consume it when we compare it with the second array.

Time Complexity: O(N+M)
Space Complexity: O(min(N, m))

Approach 2:
Sort the two arrays and iterate over to find out the 
intersections. So the overall time complexity is bounded 
by O(n log n), where n is the length of the longer array.
The main body of the loop is bounded by O(m + n).
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        HashMap<Integer, Integer> a = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> b = new HashMap<Integer, Integer>();
        for (int x : A) {
            a.put(x, a.getOrDefault(x, 0) + 1);
        }
        for (int x : B) {
            b.put(x, b.getOrDefault(x, 0) + 1);
        }
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int k : a.keySet()) {
            if (b.containsKey(k)) {
                for (int i = 0; i < Math.min(a.get(k), b.get(k)); ++i) {
                    ans.add(k);
                }
            }
        }
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = { 
    //param A : array of integers
    //param B : array of integers
    //return a array of integers
	solve : function(A, B) {
	    let ans = [];
	    let map1 = new Map();
	    let map2 = new Map();
	    
	    for(let i = 0; i < A.length; i++) {
	        if(map1.has(A[i]) == true )
                map1.set(A[i], map1.get(A[i]) + 1);
	        else
                map1.set(A[i],1);
            }
        
            for(let i = 0; i < B.length; i++) {
                let num = map1.get(B[i]);
                if(num > 0) {
                    ans.push(B[i]);
                    map1.set(B[i], num - 1);
                }
            }
            return ans;
	}
};
```
* * Solution in C++
```cpp
vector<int> Solution::solve(vector<int> &A, vector<int> &B) {
    int n = A.size(), m = B.size();
    unordered_map<int,int> hashmap;
    for(int i = 0 ; i < n; i++){
        hashmap[A[i]] ++;
        assert(A[i] >= 1 && A[i] <= 1e9);
    }
    vector<int> ans;
    for(int i = 0; i < m; i++){
        if(hashmap.find(B[i]) != hashmap.end() && hashmap[B[i]] != 0){
            ans.push_back(B[i]);
            hashmap[B[i]]--;
        }
    }
    return ans;
}
```

