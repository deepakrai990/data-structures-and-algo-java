### Q3. MAX and MIN
#### Problem Description
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>Given an array of integers <strong>A</strong>.</p>
    <p>value of a array = max(array) - min(array).</p>
    <p>Calculate and return the sum of values of all possible subarrays 
    of A <strong>modulo 10<sup>9</sup>+7</strong>.</p>
</div>

```text
Given an array of integers A.

value of a array = max(array) - min(array).

Calculate and return the sum of values of all possible subarrays 
of A modulo 10^9 + 7.
```
#### Problem Constraints
```text
1 <= |A| <= 100000

1 <= A[i] <= 1000000
```
#### Input Format
```text
The first and only argument given is the integer array A.
```
#### Output Format
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>Return the sum of values of all possible subarrays of 
    A modulo 10<sup>9</sup>+7.</p>
</div>

```text
Return the sum of values of all possible subarrays of A modulo 10^9 + 7.
```
#### Example Input
```text
Input 1:
 A = [1]

Input 2:
 A = [4, 7, 3, 8]
```
#### Example Output
```text
Output 1:
 0

Output 2:
 26
```
#### Example Explanation
```text
Explanation 1:
    Only 1 subarray exists. Its value is 0.

Explanation 2:
    value ( [4] ) = 4 - 4 = 0
    value ( [7] ) = 7 - 7 = 0
    value ( [3] ) = 3 - 3 = 0
    value ( [8] ) = 8 - 8 = 0
    value ( [4, 7] ) = 7 - 4 = 3
    value ( [7, 3] ) = 7 - 3 = 4
    value ( [3, 8] ) = 8 - 3 = 5
    value ( [4, 7, 3] ) = 7 - 3 = 4
    value ( [7, 3, 8] ) = 8 - 3 = 5
    value ( [4, 7, 3, 8] ) = 8 - 3 = 5
    sum of values % 10^9+7 = 26
```
### Hints
* Hint 1
```text
For each number Ai calculate how many subarrays including Ai, Ai is maximum or minimum.
```
* Solution Approach
```text
Calculate the next greater element and previous greater element for each element in 
the array. Each element Ai is the maximum of all subarrays starting at (previous 
greater element)i + 1 to (next greater element)i - 1.

Similarly, the next smaller element and previous smaller element can be used for 
minimum values of subarrays

Time Complexity:- O(N)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    int[] a;

    public void findNextGreaterElement(int[] Next_greater_element, int n) {
        // this function calculates next_greater element index
        Stack<Integer> s = new Stack<Integer>();
        for (int i = 0; i < n; i++) Next_greater_element[i + 1] = n + 1;
        for (int i = 1; i <= n; i++) {
            if (s.empty()) {
                s.push(i);
            } else {
                while (!s.empty() && a[s.peek()] <= a[i]) {
                    Next_greater_element[s.peek()] = i;
                    s.pop();
                }
                s.push(i);
            }
        }
    }

    public void findPreviousGreaterElement(int[] Previous_greater_element, int n) {
        // this function calculates Previous_greater element index
        Stack<Integer> s = new Stack<Integer>();
        for (int i = n; i > 0; i--) {
            if (s.empty()) {
                s.push(i);
            } else {
                while (!s.empty() && a[i] > a[s.peek()]) {
                    Previous_greater_element[s.peek()] = i;
                    s.pop();
                }
                s.push(i);
            }
        }
    }

    public void findPreviousSmallerElement(int[] Previous_smaller_element, int n) {
        // this function calculates Previous smaller element index
        Stack<Integer> s = new Stack<Integer>();
        for (int i = n; i > 0; i--) {
            if (s.empty()) {
                s.push(i);
            } else {
                while (!s.empty() && a[i] <= a[s.peek()]) {
                    Previous_smaller_element[s.peek()] = i;
                    s.pop();
                }
                s.push(i);
            }
        }
    }

    public void findNextSmallerElement(int[] Next_smaller_element, int n) {
        // function function calculates Next smaller element index
        Stack<Integer> s = new Stack<Integer>();
        for (int i = 0; i < n; i++) Next_smaller_element[i + 1] = n + 1;
        for (int i = 1; i <= n; i++) {
            if (s.empty()) {
                s.push(i);
            } else {
                while (!s.empty() && a[i] < a[s.peek()]) {
                    Next_smaller_element[s.peek()] = i;
                    s.pop();
                }
                s.push(i);
            }
        }
    }

    public int solve(int[] A) {
        int n = A.length, mod = 1000 * 1000 * 1000 + 7;
        a = new int[n + 1];
        int Next_greater_element[] = new int[n + 1];
        int Previous_greater_element[] = new int[n + 1];
        int Previous_smaller_element[] = new int[n + 1];
        int Next_smaller_element[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            a[i + 1] = A[i];
        }

        findNextGreaterElement(Next_greater_element, n);
        findPreviousGreaterElement(Previous_greater_element, n);
        findPreviousSmallerElement(Previous_smaller_element, n);
        findNextSmallerElement(Next_smaller_element, n);

        long ans = 0;
        for (int i = 1; i <= n; i++) {
            long right = Next_greater_element[i] - i;
            long left = i - Previous_greater_element[i];
            ans += (((left * right) % mod) * a[i]) % mod;
            ans %= mod;
            left = i - Previous_smaller_element[i];
            right = Next_smaller_element[i] - i;
            ans -= (((left * right) % mod) * a[i]) % mod;
            ans += mod;
            ans %= mod;
        }
        return (int) ans;
    }
}
```
* * Solution in Javascript
```javascript
let mod = 1e9 + 7;
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

function nextSmallerLeft(A, SL, n) {
  let s = new Stack();
  for (let i = n - 1; i >= 0; i--) {
    while (!s.empty() && A[s.top()] > A[i]) {
      SL[s.top()] = i;
      s.pop();
    }
    s.push(i);
  }
  return;
}

function nextSmallerRight(A, SR, n) {
  let s = new Stack();
  while (!s.empty()) s.pop();
  for (let i = 0; i < n; i++) {
    while (!s.empty() && A[s.top()] >= A[i]) {
      SR[s.top()] = i;
      s.pop();
    }
    s.push(i);
  }
  return;
}

function nextGreaterLeft(A, GL, n) {
  let s = new Stack();
  while (!s.empty()) s.pop();
  for (let i = n - 1; i >= 0; i--) {
    while (!s.empty() && A[s.top()] < A[i]) {
      GL[s.top()] = i;
      s.pop();
    }
    s.push(i);
  }
  return;
}

function nextGreaterRight(A, GR, n) {
  let s = new Stack();
  while (!s.empty()) s.pop();
  for (let i = 0; i < n; i++) {
    while (!s.empty() && A[s.top()] <= A[i]) {
      GR[s.top()] = i;
      s.pop();
    }
    s.push(i);
  }
  return;
}

module.exports = {
  solve: function (A) {
    let n = A.length;
    let a = [];
    for (let i = 0; i < n; i++) {
      a.push(A[i]);
    }
    let SL = new Array(n).fill(-1);
    let SR = new Array(n).fill(n);
    let GL = new Array(n).fill(-1);
    let GR = new Array(n).fill(n);
    nextSmallerLeft(A, SL, n);
    nextSmallerRight(A, SR, n);
    nextGreaterLeft(A, GL, n);
    nextGreaterRight(A, GR, n);

    let ans = 0;
    for (let i = 0; i < n; i++) {
      ans =
        (((ans - (((a[i] * ((SR[i] - i) * (i - SL[i]))) % mod) % mod)) % mod) +
          mod) %
        mod;
    }
    for (let i = 0; i < n; i++) {
      ans = (ans + (((a[i] * ((GR[i] - i) * (i - GL[i]))) % mod) % mod)) % mod;
    }
    return ans;
  },
};
```
* * Solution in C++
```cpp
#define mxn 100005
#define mxnn 200005
#define mod 1000000007
#define ll long long

vector<ll> a(mxn), Previous_greater_element(mxn), Next_greater_element(mxn), Next_smaller_element(mxn), Previous_smaller_element(mxn);

void findNextGreaterElement(int n){
    // this function calculates next_greater element index
    stack < ll > s;
    for (int i = 0; i <= n; i++) Next_greater_element[i] = n + 1;
    for (int i = 1; i <= n; i++) { 
        if (s.empty()) {
            s.push(i);
        } else {
            while (!s.empty() && a[s.top()] <= a[i]) {
                Next_greater_element[s.top()] = i;
                s.pop();
            }
            s.push(i);
        }
    }
}

void findPreviousGreaterElement(int n){
    // this function calculates Previous_greater element index
    stack < ll > s;
    for (int i = 0; i <= n; i++) Previous_greater_element[i] = 0;
    for (int i = n; i > 0; i--) { 
        if (s.empty()) {
            s.push(i);
        } else {
            while (!s.empty() && a[i] > a[s.top()]) {
                Previous_greater_element[s.top()] = i;
                s.pop();
            }
            s.push(i);
        }
    }
}

void findNextSmallerElement(int n){
    // this function calculates Next smaller element index
    stack < ll > s;
    for (int i = 0; i <= n; i++) Next_smaller_element[i] = n + 1;
    for (int i = 1; i <= n; i++) { 
        if (s.empty()) {
            s.push(i);
        } else {
            while (!s.empty() && a[i] < a[s.top()]) {
                Next_smaller_element[s.top()] = i;
                s.pop();
            }
            s.push(i);
        }
    }
}

void findPreviousSmallerElement(int n){
    // this function calculates Previous smaller element index
    stack < ll > s;
    for (int i = 0; i <= n; i++) Previous_smaller_element[i] = 0;
    for (int i = n; i > 0; i--) { 
        if (s.empty()) {
            s.push(i);
        } else {
            while (!s.empty() && a[i] <= a[s.top()]) {
                Previous_smaller_element[s.top()] = i;
                s.pop();
            }
            s.push(i);
        }
    }
}

int Solution::solve(vector < int > & A) {
    int n = A.size();
    for (int i = 0; i < n; i++) {
        a[i + 1] = A[i];
    }
    
    findNextGreaterElement(n);
    findPreviousGreaterElement(n);
    findNextSmallerElement(n);
    findPreviousSmallerElement(n);
    
    ll ans = 0;
    for (int i = 1; i <= n; i++) {
        ll left = i - Previous_greater_element[i];
        ll right = Next_greater_element[i] - i;
        ans += (((left * right) % mod) * a[i]) % mod;
        ans %= mod;
        left = i - Previous_smaller_element[i];
        right = Next_smaller_element[i] - i;
        ans -= (((left * right) % mod) * a[i]) % mod;
        ans += mod;
        ans %= mod;
    }
    return ans;
}
```

