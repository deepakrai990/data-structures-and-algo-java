### Q2. N integers containing only 1, 2 & 3
#### Problem Description
```text
Given an integer, A. Find and Return first positive A integers 
in ascending order containing only digits 1, 2, and 3.

NOTE: All the A integers will fit in 32-bit integers.
```
#### Problem Constraints
```text
1 <= A <= 29500
```
#### Input Format
```text
The only argument given is integer A.
```
#### Output Format
```text
Return an integer array denoting the first positive A integers 
in ascending order containing only digits 1, 2 and 3.
```
#### Example Input
```text
Input 1:
 A = 3

Input 2:
 A = 7
```
#### Example Output
```text
Output 1:
 [1, 2, 3]

Output 2:
 [1, 2, 3, 11, 12, 13, 21]
```
#### Example Explanation
```text
Explanation 1:
    Output denotes the first 3 integers that contains only 
    digits 1, 2 and 3.

Explanation 2:
    Output denotes the first 3 integers that contains only 
    digits 1, 2 and 3.

```
### Hints
* Hint 1
```text
Can you use a queue to store the integers in ascending order?
```
* Solution Approach
```text
We know the initial three values will be 1, 2, and 3.

Now, the upcoming values will be by appending 1, 2, and 3 in each given value.

We will use a queue to store the elements in ascending order.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public ArrayList<Integer> solve(int A) {
        Queue<Integer> q = new LinkedList<Integer>();
        ArrayList<Integer> ans = new ArrayList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        int cnt = 3;
        while (ans.size() < A) {
            int x = q.peek();
            ans.add(x);
            q.remove();
            if (cnt >= A) continue;
            // append 1, 2 and 3 to the current number
            q.add(10 * x + 1);
            q.add(10 * x + 2);
            q.add(10 * x + 3);
            cnt += 3;
        }
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : integer
    //return a array of integers
    solve: function (A) {
        ans = [];
        q = [];
        q.push(1);
        q.push(2);
        q.push(3);
        let ptr = 0;
        let cnt = 3;
        while (ans.length < A) {
            x = q[ptr];
            ++ptr;
            ans.push(x);
            if (cnt >= A) continue;
            // append 1, 2 and 3 to the current number
            let x1 = x * 10 + 1;
            let x2 = x * 10 + 2;
            let x3 = x * 10 + 3;
            q.push(x1);
            q.push(x2);
            q.push(x3);
            cnt += 3;
        }
        return ans;
    }
};
```
* * Solution in C++
```cpp
vector<int> doit(int n){
    vector<int> ans;
    queue<long long>q ;
    q.push(1);
    q.push(2);
    q.push(3);
    int cnt = 3;
    while(ans.size() < n){
        int x = q.front();
        q.pop();
        ans.push_back(x);
        if(cnt >= n)
            continue;
        // append 1, 2 and 3 to the current number
        int x1 = x * 10 + 1;
        int x2 = x * 10 + 2;
        int x3 = x * 10 + 3;
        q.push(x1);
        q.push(x2);
        q.push(x3);
        cnt += 3;
    }
    return ans;
}

vector<int> Solution::solve(int A) {
    return doit(A);
}
```

