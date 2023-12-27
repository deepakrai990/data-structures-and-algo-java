### Q4. Maximum Frequency stack
#### Problem Description
```text
You are given a matrix A of size N x 2 which represents different operations.
Assume initially you have a stack-like data structure you have to perform operations on it.

Operations are of two types:

1 x: push an integer x onto the stack and return -1.

2 0: remove and return the most frequent element in the stack.

If there is a tie for the most frequent element, the element closest to the top of 
the stack is removed and returned.

A[i][0] describes the type of operation to be performed. A[i][1] describe the 
element x or 0 corresponding to the operation performed.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= N &lt;= 100000</p>
    <p>1 &lt;= A[i][0] &lt;= 2</p>
    <p>0 &lt;= A[i][1] &lt;= 10<sup>9</sup></p>
</div>

```text
1 <= N <= 100000

1 <= A[i][0] <= 2

0 <= A[i][1] <= 10^9
```
#### Input Format
```text
The only argument given is the integer array A.
```
#### Output Format
```text
Return the array of integers denoting the answer to each operation.
```
#### Example Input
```text
Input 1:
A = [
            [1, 5]
            [1, 7]
            [1, 5]
            [1, 7]
            [1, 4]
            [1, 5]
            [2, 0]
            [2, 0]
            [2, 0]
            [2, 0]  ]

Input 2:
 A =  [   
        [1, 5]
        [2, 0]
        [1, 4]   ]
```
#### Example Output
```text
Output 1:
 [-1, -1, -1, -1, -1, -1, 5, 7, 5, 4]

Output 2:
 [-1, 5, -1]
```
#### Example Explanation
```text
Explanation 1:
    Just simulate given operations.
Explanation 2:
    Just simulate given operations.
```
### Hints
* Hint 1
```text
Can you maintain a number of stacks to retrieve the
required information to get the answer??
```
* Solution Approach
```text
Pushing into a stack looks like this:
void push(int x)
{
    freq[x]++;
    if(freq[x] > max_freq) max_freq = freq[x];

    if(stacks.count(freq[x]))
    {
        stacks[freq[x]].push(x);    
    }
    else
    {
        stack st;
        st.push(x);
        stacks[freq[x]] = st;
    }
}
This helps in maintaining the required answer and getting the answer to each of the 
parts that need to be done such as push and pop of the elements</pre>
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    // to store frequence of an element in the stack.
    private HashMap<Integer, Stack<Integer>> stacks = new HashMap<Integer, Stack<Integer>>();
    // to maintain the structure of stack and pop out top most element in case of a tie. 
    private HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();
    private int maxfreq = 0;

    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < A.size(); i++) {
            int oper = A.get(i).get(0);
            //push operation
            if (oper == 1) {
                int x = A.get(i).get(1);
                if (freq.get(x) == null) {
                    freq.put(x, 1);
                } else {
                    freq.put(x, freq.get(x) + 1);
                }
                int fr = freq.get(x);
                maxfreq = Math.max(fr, maxfreq);
                if (stacks.get(fr) != null) {
                    Stack<Integer> tmp = stacks.get(fr);
                    tmp.push(x);
                } else {
                    Stack<Integer> tmp = new Stack<Integer>();
                    tmp.push(x);
                    stacks.put(fr, tmp);
                }
                ans.add(-1);
            } else {
                //pop operation
                Stack<Integer> tmp = stacks.get(maxfreq);
                int x = tmp.peek();
                ans.add(x);
                freq.put(x, maxfreq - 1);
                tmp.pop();
                if (tmp.empty()) maxfreq--;
            }
        }
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
class Stack {
    constructor() {
        this.items = [];
    }

    push(element) {
        this.items.push(element);
    }

    pop() {
        if (this.items.length == 0) return "Underflow";
        return this.items.pop();
    }

    top() {
        return this.items[this.items.length - 1];
    }

    empty() {
        return this.items.length == 0;
    }

    printStack() {
        var str = "";
        for (var i = 0; i < this.items.length; i++) str += this.items[i] + " ";
        return str;
    }

    clear() {
        this.items = [];
    }
}

let freq = new Map();
let stacks = new Map();
let max_freq = 0;

function push(x) {
    freq.set(x, (freq.get(x) || 0) + 1);
    if ((freq.get(x) || 0) > max_freq) max_freq = freq.get(x) || 0;
    if (stacks.has(freq.get(x))) {
        stacks.get(freq.get(x)).push(x);
    } else {
        let st = new Stack();
        st.push(x);
        stacks.set(freq.get(x), st);
    }
}

function pop() {
    let x = stacks.get(max_freq).top();
    stacks.get(max_freq).pop();
    freq.set(x, freq.get(x) - 1);
    if (stacks.get(max_freq).empty()) {
        max_freq--;
    }
    return x;
}

module.exports = {
    solve: function (A) {
        max_freq = 0;
        freq.clear();
        stacks.clear();
        let ans = [];
        for (let i = 0; i < A.length; i++) {
            if (A[i][0] == 1) {
                push(A[i][1]);
                ans.push(-1);
            } else {
                let x = pop();
                ans.push(x);
            }
        }
        return ans;
    },
};
```
* * Solution in C++
```cpp
unordered_map < int, int > freq; // to store frequence of an element in the stack.
unordered_map < int, stack < int >> stacks; // to maintain the structure of stack and pop out top most element in case of a tie. 

int max_freq = 0;
void push(int x) {
    freq[x]++;
    if (freq[x] > max_freq) max_freq = freq[x];

    if (stacks.count(freq[x])) {
        stacks[freq[x]].push(x);
    } else {
        stack < int > st;
        st.push(x);
        stacks[freq[x]] = st;
    }

}

int pop() {
    int x = stacks[max_freq].top();
    stacks[max_freq].pop();

    freq[x]--;
    if (stacks[max_freq].empty()) {
        max_freq--;
    }

    return x;
}

vector < int > Solution::solve(vector < vector < int > > & A) {
    // clear global variables
    max_freq = 0;
    freq.clear();

    stacks.clear();
    vector < int > ans;
    for (int i = 0; i < A.size(); i++) {
        if (A[i][0] == 1) {
            push(A[i][1]);
            ans.push_back(-1);
        } else {
            int x = pop();
            ans.push_back(x);
        }
    }

    return ans;
}
```

