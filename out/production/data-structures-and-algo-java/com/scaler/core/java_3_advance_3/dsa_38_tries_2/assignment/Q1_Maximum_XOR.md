### Q1. Maximum XOR
#### Problem Description
```text
Given an array of integers A, find and return the maximum result of A[i] XOR A[j], 
where i, j are the indexes of the array.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= length of the array &lt;= 100000<br>
    0 &lt;= A[i] &lt;= 10<sup>9</sup> </p>
</div>

```text
1 <= length of the array <= 100000
0 <= A[i] <= 10^9
```
#### Input Format
```text
The only argument given is the integer array A.
```
#### Output Format
```text
Return an integer denoting the maximum result of A[i] XOR A[j].
```
#### Example Input
```text
Input 1:
 A = [1, 2, 3, 4, 5]

Input 2:
 A = [5, 17, 100, 11]
```
#### Example Output
```text
Output 1:
 7

Output 2:
 117
```
#### Example Explanation
```text
Explanation 1:
    Maximum XOR occurs between element of indicies(0-based) 1 and 4 i.e. 2 ^ 5 = 7.

Explanation 2:
    Maximum XOR occurs between element of indicies(0-based) 1 and 2 i.e. 17 ^ 100 = 117.
```
### Hints
* Hint 1
```text
The brute force approach is to run two loops for i and j, calculate all possible 
values of A[i] ^ A[j], and find the maximum possible result.

But this approach will not pass the given constraints. Let’s try to modify the 
problem a little.

Suppose you have i-1 elements, and you have to find the maximum xor of the ith 
element with i-1 elements. How will you proceed?
```
* Hint 2
```text
First, think of the solution to the problem. Given i-1 elements, find the 
maximum xor of the ith element with the previous i-1 elements.

To find the maximum XOR, It is wise to set the most significant bit to 1 first.

Get the bit representation of all the numbers. There can be two causes for the 
most significant bit(rightmost bit):

    1) If the most significant bit of ith number is 1, we will take the numbers 
       with that bit 0.

    2) If the most significant bit of ith number is 0, we will take the numbers 
       with that bit 1.

We will proceed from the most significant bit to the least significant bit(right to 
the left in bit representation of a number) and keep on taking the numbers with 
the opposite bit.

In this way, we are fixing the xor of our answer one bit at a time. Can we optimize 
our answer now?

Instead of checking every element with the same prefix of bit representation, 
Is there a way we can combine the numbers having the same prefix bit representation?

Think of using trie data structure for this.
```
* Solution Approach
```text
As mentioned in the hints, We will find the maximum XOR of ith element with 
the previous i-1 elements of the array. Do this for all i 1 to N and update the 
maximum XOR at eact step.

First build bitwise trie of i-1 elements which means insert the bit 
representation(from right to left) of all i-1 elements into the trie.

For ex: Given 3 numbers with their bit representation: 6(00110) , 5(00101) 
and 23(10111) and we need to find the maximum xor of 2(00010) with these numbers.

Insert 6(00110), 5(00101) and (10101).
After inserting, Our trie will look like this. (using only 5 bits for example)

        -1(root)
       /   \
      0     1
     /     /
    0     0
     \     \ 
      1     1
    /   \    \
   0     1    1
    \   /      \
   (5)1 0(6)      1(23)

We want to find the maximum xor of 2(00010) with the numbers in the trie.

Start traversing in the trie from root, At every node, there can be two possibilities:

    1) If the 2(00010) has 1 at that bit, move to the left means towards elements 
       having that bit 0.
    
    2) If the 2(00010) has 0 at that bit, move to the right means towards elements 
       having that bit 1.

Basically move in the direction of opposite bit to set that bit in our answer to one.

Algorithm:

    1) Convert numbers into binary form.
    
    2) Add numbers into the trie one by one and compute the maximum XOR of a number 
       to add with all previously inserted. Update maximum XOR at each step.
    
    3) Return the maximum XOR calculated.

At every i we are checking the maximum xor with all elements from 0 to i-1. 
Time complexity of this step is O(log(max_element in the array)).

We are doing this for every i 1 to N. Overall time complexity is O(Nlog(max_element in 
the array))
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    static private class TrieNode {
        TrieNode left = null; // left points to 0 
        TrieNode right = null; // right points to 1
    }

    public int solve(int[] A) {
        return findMaximumXOR(A);
    }

    public static int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();
        // Constructing the Trie
        for (int num : nums) {
            TrieNode curr = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >>> i) & 1;
                if (bit == 0) {
                    if (curr.left == null) {
                        curr.left = new TrieNode();
                    }
                    curr = curr.left;
                } else {
                    if (curr.right == null) {
                        curr.right = new TrieNode();
                    }
                    curr = curr.right;
                }
            }
        }
        int max = Integer.MIN_VALUE;

        // Query on Trie
        for (int num : nums) {
            TrieNode curr = root;
            int currSum = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >>> i) & 1;
                if (bit == 0) {
                    if (curr.right != null) {
                        currSum += (1 << i);
                        curr = curr.right;
                    } else {
                        curr = curr.left;
                    }
                } else {
                    if (curr.left != null) {
                        currSum += (1 << i);
                        curr = curr.left;
                    } else {
                        curr = curr.right;
                    }
                }
            }
            max = Math.max(currSum, max);
        }
        return max;
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
    //param A : array of integers
    //return an integer
    solve: function (A) {
        freeTrie(rot);
        insert(A[0]);
        let ans = 0
        for (let i = 1; i < A.length; i++) {
            let temp = maxXor(A[i]);
            ans = Math.max(ans, temp);
            insert(A[i]);
        }
        return ans;
    }
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

int Solution::solve(vector < int > & A) {
    int n = A.size();
    int ans = 0;
    TrieNode * root = newNode();
    insert(root, A[0]);
    for (int i = 1; i < n; i++) {
        int curMax = findXor(root, A[i]);
        ans = max(ans, curMax);
        insert(root, A[i]);
    }
    return ans;
}
```

