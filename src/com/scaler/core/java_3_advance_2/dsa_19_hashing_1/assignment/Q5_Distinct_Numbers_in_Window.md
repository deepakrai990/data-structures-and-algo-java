### Q5. Distinct Numbers in Window
#### Problem Description
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>You are given an array of <strong>N</strong> integers, 
    <strong>A<sub>1</sub>, A<sub>2</sub> ,..., A<sub>N</sub></strong> 
    and an integer <strong>B</strong>. Return the of count of 
    distinct numbers in all windows of size <strong>B</strong>.
    </p>
    <p>Formally, return an array of size <strong>N-B+1</strong> 
    where <strong>i'th</strong> element in this array contains 
    number of distinct elements in sequence <strong>A<sub>i</sub>, 
    A<sub>i+1</sub> ,..., A<sub>i+B-1</sub>.</strong></p>
    <p><strong>NOTE: </strong> if <strong>B</strong> &gt; 
    <strong>N</strong>, return an empty array.</p>
</div>

```text
You are given an array of N integers, A1, A2 ,..., AN and 
an integer B. Return the of count of distinct numbers in 
all windows of size B.

Formally, return an array of size N-B+1 where i'th element 
in this array contains number of distinct elements in 
sequence Ai, A(i+1) ,..., A(i+B-1).

NOTE: if B > N, return an empty array.
```
#### Problem Constraints
```text
Not available 
```
#### Input Format
```text
First argument is an integer array A
Second argument is an integer B.
```
#### Output Format
```text
Return an integer array.
```
#### Example Input
```text
Input 1:
 A = [1, 2, 1, 3, 4, 3]
 B = 3

Input 2:
 A = [1, 1, 2, 2]
 B = 1
```
#### Example Output
```text
Output 1:
 [2, 3, 3, 2]

Output 2:
 [1, 1, 1, 1]
```
#### Example Explanation
```text
Explanation 1:
    A=[1, 2, 1, 3, 4, 3] and B = 3
    All windows of size B are
    [1, 2, 1]
    [2, 1, 3]
    [1, 3, 4]
    [3, 4, 3]
    So, we return an array [2, 3, 3, 2].

Explanation 2:
    Window size is 1, so the output array is [1, 1, 1, 1].
```
### Hints
* Hint 1
```text
If you have solution for window [i, i+k-1], can you quickly 
build solution for window [i+1, i+k], using some 
data structure?

What could be this data structure? A data structure which 
can store distinct elements(and their count?)?
```
* Solution Approach
```text
If you have solution for window [i, i+k-1], can you quickly 
build solution for window [i+1, i+k]?

If we have a data structure where we can maintain count of 
all keys and number of distinct keys, then we just have to 
reduce count of key A[i] and increasing count of A[i+k]. If 
count of some key has been reduced to zero, we need to 
remove that key.

This structure is a hashmap. All operations that we have said 
a constant time in it.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        int n = A.size();
        ArrayList<Integer> ret = new ArrayList<>();
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            // Increase key
            if (m.containsKey(A.get(i))) {
                m.put(A.get(i), m.get(A.get(i)) + 1);
            } else {
                m.put(A.get(i), 1);
            }
            if (i - B + 1 >= 0) {
                // Decrease key
                ret.add(m.size());
                m.put(A.get(i - B + 1), m.get(A.get(i - B + 1)) - 1);
                // Remove if count becomes 0
                if (m.get(A.get(i - B + 1)) == 0) {
                    m.remove(A.get(i - B + 1));
                }
            }
        }
        return ret;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = { 
    //param A : array of integers
    //param B : integer
    //return a array of integers
    dNums : function(A, B){
        let n = A.length;
        let ans = [];
        let mp = new Map();
        for(let i = 0; i < B; i++) {
           
            if(!mp.has(A[i])) 
                mp.set(A[i],1);
            else 
                mp.set(A[i],mp.get(A[i])+1);
        }
        ans.push(mp.size);
       
        for(let i = B; i < n; i++) {
           
            if(!mp.has(A[i])) 
                mp.set(A[i],1);
            else 
                mp.set(A[i],mp.get(A[i])+1);
            mp.set(A[i-B],mp.get(A[i-B])-1);
           
            if(mp.get(A[i-B]) == 0)
                mp.delete(A[i-B]);
            ans.push(mp.size);
        }
        return ans; 
    }
};
```
* * Solution in C++
```cpp
vector < int > Solution::dNums(vector < int > & A, int B) {
    assert(B <= A.size());
    int n = A.size();
    vector < int > ret;
    unordered_map < int, int > m;
    for (int i = 0; i < n; i++) {
        //increase key
        m[A[i]]++;
        if (i - B + 1 >= 0) {

            //decrease key
            ret.push_back(m.size());
            m[A[i - B + 1]]--;

            //remove if count becomes 0
            if (m[A[i - B + 1]] == 0) m.erase(A[i - B + 1]);
        }
    }
    return ret;
}
```
