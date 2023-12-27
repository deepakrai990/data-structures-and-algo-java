### Q1. XOR TRIPLETS
#### Problem Description
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>Given an array of integers <strong>A</strong> of size <strong>N</strong>.</p>
    <p>A triplet <strong>(i, j, k), i &lt; j &lt;= k</strong> is called a power 
    triplet if <strong>A[i] ^ A[i+1] ^....A[j-1] = A[j] ^.....^A[k]</strong>.</p>
    <p>Where, <strong>^</strong> denotes bitwise xor.</p>
    <p>Return the <strong>count</strong> of all possible power triplets. Since the 
    answer could be large return <strong>answer % 10<sup>9</sup> +7</strong>.</p>
</div>

```text
Given an array of integers A of size N.

A triplet (i, j, k), i < j <= k is called a power 
triplet if A[i] ^ A[i+1] ^....A[j-1] = A[j] ^.....^A[k].

Where, ^ denotes bitwise xor.

Return the count of all possible power triplets. Since the answer could be large 
return answer % 10^9 +7.
```
#### Problem Constraints
```text
1 <= N <= 100000
1 <= A[i] <= 100000
```
#### Input Format
```text
The first argument given is the integer array A.
```
#### Output Format
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>Return the count of all possible power triplets % 10<sup>9</sup> + 7.</p>
</div>

```text
Return the count of all possible power triplets % 10^9 + 7.
```
#### Example Input
```text
Input 1:
 A = [5, 2, 7]

Input 2:
 A = [1, 2, 3]
```
#### Example Output
```text
Output 1:
 2

Output 2:
 2
```
#### Example Explanation
```text
Explanation 1:
    All possible power triplets are:
        1. (1, 2, 3) ->  A[1] = A[2] ^ A[3]
        2. (1, 3, 3) ->  A[1] ^ A[2] = A[3]

Explanation 2:
    All possible power triplets are:
        1. (1, 2, 3) ->  A[1] = A[2] ^ A[3]
        2. (1, 3, 3) ->  A[1] ^ A[2] = A[3]
```
### Hints
* Hint 1
```text
Can we say that to calculate answer we need to find the subarrays such that Xor of 
that subarray is Zero.
```
* Solution Approach
```text
A simple is to find the every possible triplet and check if it satisfies the above condition.
But this is not an efficient way to do that.

One thing we observe is that for (i,j,k), A[i]^A[i+1]..^A[j-1] = A[j]^A[j+1]^A[k] 
i.e A[i]^A[i+1]..^A[k] = 0.
So, if we find (i,k) such that A[i]^A[i+1]..^A[k] = 0, then all j in this range 
will satisfy our above condition.

An efficient solution is to use Trie.

->We will take the cumulative xor of the elements in the array and check that 
this xor value exists in the Trie or not.

->If the xor already exists in the Trie then we have encounted a subarray having 0 xor 
  and count all the triplets.

->Else push the value of xor into the Trie.

Alternate Method

-> We will find the prefix xor of the array elements.

->We maintain two hashmaps, one for the frequency of each prefix xor and the other for 
  the summation of indices for each

prefix xor

-> Now using the hashmap, we can find the number of triplet that satisfy the given 
condition
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    static final int INT_SIZE = 20;
    static class TrieNode {
        int soi;
        int noi;
        TrieNode[] arr = new TrieNode[2];
        public TrieNode() {
            soi = 0;
            noi = 0;
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
        temp.noi++;
        temp.soi += index;
    }
    static long query(int pre_xor, int index) {
        TrieNode temp = root;
        for (int i = INT_SIZE - 1; i >= 0; i--) {
            int val = (pre_xor & (1 << i)) >= 1 ? 1 : 0;
            if (temp.arr[val] == null)
                return 0;
            temp = temp.arr[val];
        }
        int sz = temp.noi;
        int sum = temp.soi;
        long ans = (long)((long) sz * (long) index) - (long)((long) sum);
        return ans;
    }
    public int solve(int[] A) {
        int curr_xor = 0;
        long mod = 1000000007;
        long number_of_triplets = 0;
        int n = A.length;
        root = new TrieNode();
        for (int i = 0; i < n; i++) {
            int x = A[i];
            insert(curr_xor, i);
            curr_xor ^= x;
            number_of_triplets += query(curr_xor, i);
            number_of_triplets %= mod;
        }
        long res = number_of_triplets % mod;
        return (int) res;
    }
}
```
* * Solution in Javascript
```javascript
const MOD = 1e9 + 7;
module.exports = {
  solve: function (A) {
    let n = A.length,
      res = 0,
      prefix = 0;
    let count = new Map();
    count.set(0, 1);
    let total = new Map();
    for (let i = 0; i < n; ++i) {
      prefix ^= A[i];
      res += (count.get(prefix) || 0) * i - (total.get(prefix) || 0);
      count.set(prefix, 1 + (count.get(prefix) || 0));
      total.set(prefix, i + 1 + (total.get(prefix) || 0));
    }
    return res % MOD;
  },
};
```
* * Solution in C++
```cpp
// Approach 1

#define lg 20
// Structure of a Trie Node 
struct TrieNode {
    // [0] index is bit 0 and [1] index is bit 1 
    TrieNode * children[2];

    // Sum of indexes inserted at at a node 
    int sum_of_indexes;

    // Number of indexes inserted at a node 
    int number_of_indexes;

    // Constructor to initialize a newly created node 
    TrieNode() {
        this -> children[0] = NULL;
        this -> children[1] = NULL;
        this -> sum_of_indexes = 0;
        this -> number_of_indexes = 0;
    }
};

// Function to insert curr_xor into the trie 
void insert(TrieNode * node, int num, int index) {
    for (int bits = lg; bits >= 0; bits--) {
        // Check if the current bit is set or not 
        int curr_bit = (num >> bits) & 1;

        // If this node isn't already present in the trie structure insert it into the trie. 
        if (node -> children[curr_bit] == NULL) {
            node -> children[curr_bit] = new TrieNode();
        }
        node = node -> children[curr_bit];
    }
    // Increase the sum of indexes by the current index value 
    node -> sum_of_indexes += index;

    // Increase the number of indexes by 1 
    node -> number_of_indexes++;
}

// Function to check if curr_xor is present in trie or not 
long long query(TrieNode * node, int num, int index) {

    for (int bits = lg; bits >= 0; bits--) {
        // Check if the current bit s set or not 
        int curr_bit = (num >> bits) & 1;

        // If this node isn't already present in the trie structure that means no sub array till current index has 0 xor so 
        // return 0 
        if (node -> children[curr_bit] == NULL) {
            return 0;
        }
        node = node -> children[curr_bit];
    }
    // Calculate the number of index inserted at final node 
    int sz = node -> number_of_indexes;

    // Calculate the sum of index inserted at final node 
    int sum = node -> sum_of_indexes;
    long long ans = (sz * index) - (sum);
    return ans;
}

int Solution::solve(vector < int > & A) {
    int curr_xor = 0;
    int mod = 1e9 + 7;
    long long number_of_triplets = 0;
    int n = A.size();
    // The root of the trie 
    TrieNode * root = new TrieNode();
    for (int i = 0; i < n; i++) {
        int x = A[i];

        // Insert the curr_xor in the trie 
        insert(root, curr_xor, i);

        // Update the cumulative xor 
        curr_xor ^= x;

        // Check if the cumulative xor is present in the trie or not if present then add (sz * index) - sum 
        number_of_triplets += query(root, curr_xor, i);
        number_of_triplets %= mod;
    }
    return number_of_triplets % mod;
}

// Approach 2

const int MOD = 1e9 + 7;
int Solution::solve(vector<int> &A) {
    int n = A.size(), res = 0, prefix = 0;
    map<int,int> count, total;
    count[0] = 1;
    for (int i = 0; i < n; ++i) {
        prefix ^= A[i];
        res = (res + (count[prefix] * i) % MOD - total[prefix] + MOD) % MOD;
        count[prefix] += 1;
        total[prefix] = (total[prefix] + (i + 1)) % MOD;
    }
    return res % MOD;
}
```

