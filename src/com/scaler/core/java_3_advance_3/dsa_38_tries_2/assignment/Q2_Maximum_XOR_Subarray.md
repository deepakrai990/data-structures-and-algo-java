### Q2. Maximum XOR Subarray
#### Problem Description
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>Given an array, <strong>A</strong> of integers of size 
    <strong>N</strong>. Find the subarray <strong>A<sub>L</sub>, A<sub>
    L+1</sub>, A<sub>L+2</sub>, ... A<sub>R</sub></strong> with 
    <strong>1</strong>&lt;=<strong>L</strong>&lt;=<strong>R</strong>
    &lt;=<strong>N,</strong> which has maximum <strong>XOR</strong> value.</p>
    <p><strong>NOTE: </strong>If there are multiple subarrays with the same 
    maximum value, return the subarray with <strong>minimum length</strong>. 
    If the length is the same, return the subarray with the <strong>minimum starting 
    index</strong>.</p>
</div>

```text
Given an array, A of integers of size N. Find the subarray AL, AL+1, AL+2, ... AR 
with 1<=L<=R<=N, which has maximum XOR value.

NOTE: If there are multiple subarrays with the same maximum value, return the subarray 
with minimum length. If the length is the same, return the subarray with the minimum 
starting index.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= N &lt;= 100000<br>
    0 &lt;= A[i] &lt;= 10<sup>9</sup></p>
</div>

```text
1 <= N <= 100000
0 <= A[i] <= 10^9
```
#### Input Format
```text
First and only argument is an integer array A.
```
#### Output Format
```text
Return an integer array B of size 2. B[0] is the starting index(1-based) of the 
subarray and B[1] is the ending index(1-based) of the subarray.
```
#### Example Input
```text
Input 1:
 A = [1, 4, 3]

Input 2:
 A = [8]
```
#### Example Output
```text
Output 1:
 [2, 3]

Output 2:
 [1, 1]
```
#### Example Explanation
```text
Explanation 1:
    There are 6 possible subarrays of A:
    subarray            XOR value
    [1]                     1
    [4]                     4
    [3]                     3
    [1, 4]                  5 (1^4)
    [4, 3]                  7 (4^3)
    [1, 4, 3]               6 (1^4^3)
    
    [4, 3] subarray has maximum XOR value. So, return [2, 3].

Explanation 2:
    There is only one element in the array. So, the maximum XOR value is 
    equal to 8 and the only possible subarray is [1, 1]. 
```
### Hints
* Hint 1
<div >
    <p>Suppose the <strong>i<sup>th</sup></strong> element of the prefXor array 
    represents the xor of all elements from <strong>0</strong> to <strong>i</strong>. 
    To find the xor of any subarray[l..r], Just take the xor of prefXor[r] and 
    prefXor[l-1].<br>
    For every <strong>r</strong> find the index <strong>l</strong> which gives 
    maximum xor and take the maximum of all of them.</p>
</div>

```text
Suppose the ith element of the prefXor array represents the xor of all elements 
from 0 to i. To find the xor of any subarray[l..r], Just take the xor 
of prefXor[r] and prefXor[l-1].

For every r find the index l which gives maximum xor and take the maximum of all of them.
```
* Solution Approach
<div>
    <p>Build a <strong>prefXor</strong> array in which the 
    <strong>i<sup>th</sup></strong> element represents the xor of all elements 
    from <strong>0</strong> to <strong>i</strong>. To find the xor of any 
    subarray[l..r], we can just take the xor of prefXor[r] and prefXor[l-1].</p>
    <p>To find the maximum xor subarray ending at the index 
    <strong>i</strong>, insert the <strong>bit representation</strong>(starting from most significant bit) of all the elements of <strong>prefXor</strong> array upto <strong>i-1</strong> into the trie data structure. <br>
    We have two possible cases at <strong>i<sup>th</sup></strong> index.</p>
    <ol>
      <li>The prefix itself has maximum xor.</li>
      <li>We need to remove some prefix  (ending at index from 
        <strong>0</strong> to <strong>i-1</strong>).Try to have most significant 
        bit to be set bit i.e. <strong>1</strong>.  As we have maintained the trie 
        data structure of bit representation of <strong>i-1</strong> elements of
        prefXor array, we can find the maximum xor in O(logm) where m is the 
        maximum number present in the given array.</li>
    </ol>
    <p>We can find the maximum subarray ending at every index and return the 
    subarray, which has the maximum XOR value.</p>
</div>

* Complete Solution
* * Solution in Java
```java
public class Solution {
    static final int INT_SIZE = 32;
    static class TrieNode {
        int value;
        int end;
        TrieNode[] arr = new TrieNode[2];
        public TrieNode() {
            end = -1;
            value = 0;
            arr[0] = null;
            arr[1] = null;
        }
    }
    static TrieNode root;
    static void insert(int pre_xor, int index) {
        TrieNode temp = root;
        for (int i = INT_SIZE - 1; i >= 0; i--) {
            int val = (pre_xor & (1 << i)) >= 1 ? 1 : 0;
            if (temp.arr[val] == null)
                temp.arr[val] = new TrieNode();

            temp = temp.arr[val];
        }
        temp.value = pre_xor;
        temp.end = index;
    }
    static pair query(int pre_xor) {
        TrieNode temp = root;
        for (int i = INT_SIZE - 1; i >= 0; i--) {
            int val = (pre_xor & (1 << i)) >= 1 ? 1 : 0;
            if (temp.arr[1 - val] != null)
                temp = temp.arr[1 - val];
            else if (temp.arr[val] != null)
                temp = temp.arr[val];
        }
        return (new pair(pre_xor ^ (temp.value), temp.end));
    }
    public int[] solve(int[] arr) {
        int n = arr.length;
        root = new TrieNode();
        insert(0, -1);
        int[] res = new int[2];
        int result = Integer.MIN_VALUE;
        int pre_xor = 0;
        int start = -1;
        int end = 0;
        for (int i = 0; i < n; i++) {
            pre_xor = pre_xor ^ arr[i];
            insert(pre_xor, i);
            pair ans = query(pre_xor);
            if (ans.a > result) {
                result = ans.a;
                end = i;
                start = ans.b + 1;
            } else if (ans.a == result) {
                int currLen = end - start + 1;
                int newLen = i - (ans.b + 1) + 1;
                if (newLen < currLen) {
                    start = ans.b + 1;
                    end = i;
                } else if (newLen == currLen && (ans.b + 1) < start) {
                    start = ans.b + 1;
                    end = i;
                }
            }
        }
        res[0] = start + 1;
        res[1] = end + 1;
        return res;
    }
}
class pair {
    int a, b;
    public pair(int c, int d) {
        this.a = c;
        this.b = d;
    }
}
```
* * Solution in Javascript
```javascript
class Node {
    constructor() {
        this.isEnd = false;
        this.next = new Array(2).fill(null);
        this.cnt = 0;
    }
}
let rot = new Node();

function insert(x) {
    let cur = rot;
    for (let i = 30; i >= 0; i--) {
        let b = (x >> i) & 1;
        if (cur.next[b] == null) cur.next[b] = new Node();
        cur = cur.next[b];
        cur.cnt++;
    }
}

function maxXor(x) {
    let ans = 0;
    let cur = rot;

    for (let i = 30; i >= 0; i--) {
        // console.log(x, i, (x >> i));
        let b = (x >> i) & 1;
        if (cur.next[b ^ 1] && cur.next[b ^ 1].cnt > 0) {
            ans += 1 << i;
            cur = cur.next[b ^ 1];
        } else cur = cur.next[b];
    }
    return ans;
}

function freeTrie(cur) {
    if (cur == null) return;
    for (let i = 0; i < 2; i++) freeTrie(cur.next[i]), (cur.next[i] = null);
}

module.exports = {
    solve: function(A) {
        freeTrie(rot);
        insert(0);
        for (let i = 1; i < A.length; i++) {
            A[i] ^= A[i - 1];
        }
        let ans = 0;
        let id = -1;
        let dist = 100000000;
        let mp = new Map();
        mp.set(0, -1);
        A.forEach((ele, index) => {
            let val = maxXor(ele);
            if (val > ans)
                (ans = val), (id = index), (dist = index - mp.get(ans ^ ele));
            else if (val == ans && dist > index - mp.get(ans ^ ele)) {
                dist = index - mp.get(ans ^ ele);
                id = index;
            }
            mp.set(ele, index);
            insert(ele);
        });
        return [mp.get(ans ^ A[id]) + 2, id + 1];
    },
};
```
* * Solution in C++
```cpp
struct TrieNode {
    TrieNode * children[2];
    int cnt;
};

TrieNode * newNode() {
    TrieNode * temp = new TrieNode;
    temp -> cnt = 0;
    temp -> children[0] = NULL;
    temp -> children[1] = NULL;
    return temp;
}

bool check(int N, int i) {
    return (bool)(N & (1 << i));
}

void insert(TrieNode * root, int x) {
    TrieNode * itr = root;
    // padding upto 32 bits 
    for (int i = 31; i >= 0; i--) {
        int f = check(x, i);
        if (!itr -> children[f])
            itr -> children[f] = newNode();
        itr = itr -> children[f];
    }
    itr -> cnt += 1;
}

int findXor(TrieNode * root, int x) {
    TrieNode * itr = root;
    // Do XOR from root to a leaf path 
    int ans = 0;
    for (int i = 31; i >= 0; i--) {
        // Find i-th bit in x 
        int f = check(x, i);
        // Move to the child whose XOR with f is 1. 
        if ((itr -> children[f ^ 1])) {
            ans = ans + (1 << i); // update answer 
            itr = itr -> children[f ^ 1];
        } else
            itr = itr -> children[f];
    }
    return ans;
}

vector < int > Solution::solve(vector < int > & A) {
    int n = A.size();
    for (int i = 1; i < n; i++) {
        A[i] = A[i] ^ A[i - 1];
    }
    vector < int > ans(2, 1);
    int maxx = A[0];
    TrieNode * root = newNode();
    insert(root, A[0]);
    unordered_map < int, int > mp; // to store the indices of the XOR value
    mp[A[0]] = 0;
    for (int i = 1; i < A.size(); i++) {
        // Case 1 check for subarray(0, i)
        mp[A[i]] = i;
        if (A[i] > maxx) {
            maxx = A[i];
            ans[0] = 1;
            ans[1] = i + 1;
        } else if (A[i] == maxx) {
            if (ans[0] != ans[1]) {
                ans[0] = i + 1;
                ans[1] = i + 1;
            }
        }
        int curMaxx = findXor(root, A[i]);
        int res = curMaxx ^ A[i];
        int j = mp[res];
        j += 1;
        if (curMaxx > maxx) {
            maxx = curMaxx;
            ans[0] = j + 1;
            ans[1] = i + 1;
        } else if (curMaxx == maxx) //  check for minimum length if current maximum  = maxx.           
        {
            int curL = i - j + 1, ansL = ans[1] - ans[0] + 1;
            if (curL < ansL) {
                ans[0] = j + 1;
                ans[1] = i + 1;
            }
        }
        insert(root, A[i]); // insert the xor of the prefix(0, i) into the trie.                  
    }
    return ans;
}
```

