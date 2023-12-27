### Q2. Modified Search
#### Problem Description
```text
Given two arrays of strings A of size N and B of size M.

Return a binary string C where C[i] = '1' if B[i] can be found in dictionary A using 
exactly one modification in B[i], Else C[i] = '0'.

NOTE: modification is defined as converting a character into another character.
```
#### Problem Constraints
```text
1 <= N <= 30000

1 <= M <= 2500

1 <= length of any string either in A or B <= 20

strings contains only lowercase alphabets
```
#### Input Format
```text
First argument is the string array A.

Second argument is the string array B.
```
#### Output Format
```text
Return a binary string C where C[i] = '1' if B[i] can be found in dictionary A using 
one modification in B[i], Else C[i] = '0'.
```
#### Example Input
```text
Input 1:
 A = [data, circle, cricket]
 B = [date, circel, crikket, data, circl]

Input 2:
 A = [hello, world]
 B = [hella, pello, pella]
```
#### Example Output
```text
Output 1:
 "10100"

Output 2:
 "110"
```
#### Example Explanation
```text
Explanation 1:
    1. date = dat*(can be found in A)
    2. circel =(cannot be found in A using exactly one modification)
    3. crikket = cri*ket(can be found in A)
    4. data = (cannot be found in A using exactly one modification)
    5. circl = (cannot be found in A using exactly one modification)

Explanation 2:
    Only pella cannot be found in A using only one modification.
```
### Hints
* Hint 1
```text
Naive solution will be to run over all the strings of A for each query B[i]. 
This will not an efficient way.

Can we think of using prefix Trie ?
```
* Solution Approach
```text
Naive solution will be to run over all the strings of A for each query B[i]. 
This will not an efficient way as it takes O(N * M * length of string).

An efficient approach is to use Trie.

First insert all the strings of array A in the Trie.

Now, For each query we need to check if there is any string in the dictionary 
such that we need to change only a single character in B[i].

Think of running a DFS(Depth First search) on Trie. Will it be efficient?

Take a flag variable, make flag = 1 if we have to change the character. Now we 
cannot do any further change so we will not traverse the part of trie which 
required more than 1 changes.

Return True if there exist any string such that we need to change a single character.

Try to Implement.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    static final int ALPHABET_SIZE = 26;
    static TrieNode root;
    
    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        boolean isEndOfWord;
        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }
    }
    
    static void insert(String key) {
        int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;
        for (level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();
            pCrawl = pCrawl.children[index];
        }
        pCrawl.isEndOfWord = true;
    }
    
    static boolean query(TrieNode cur, int i, String s, int flag, boolean last) {
        boolean ans = false;
        int n = s.length();
        if (i == n) {
            if (flag == 1 && last == true)
                return true;
            return false;
        }
        int c = s.charAt(i) - 97;
        if (flag == 0) {
            for (int x = 0; x < 26; x++) {
                if (cur.children[x] == null)
                    continue;
                if (x == c) {
                    ans = ans || query(cur.children[x], i + 1, s, flag, cur.children[x].isEndOfWord);
                } else
                    ans = ans || query(cur.children[x], i + 1, s, 1 - flag, cur.children[x].isEndOfWord);
            }
        } else {
            if (cur.children[c] != null)
                ans = ans || query(cur.children[c], i + 1, s, flag, cur.children[c].isEndOfWord);
        }
        return ans;
    }
    
    public String solve(String[] A, String[] B) {
        root = new TrieNode();
        for (String a: A)
            insert(a);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < B.length; i++) {
            if (query(root, 0, B[i], 0, false) == true)
                res.append('1');
            else
                res.append('0');
        }
        return res.toString();
    }
}
```
* * Solution in Javascript
```javascript
const mx = 26;

class Node {
    constructor() {
        this.isEnd = false;
        this.next = new Array(mx).fill(null);
        this.cnt = 0;
    }
}

let rot = new Node();

function insert(s) {
    let cur = rot;
    let number;
    [...s].forEach((ele) => {
        number = ele.charCodeAt(0) - 97;
        if (cur.next[number] == null) cur.next[number] = new Node();
        cur = cur.next[number];
        cur.cnt++;
    });
    cur.isEnd = 1;
}

function freeTrie(cur) {
    if (cur == null) return;
    for (let i = 0; i < 26; i++) freeTrie(cur.next[i]), (cur.next[i] = null);
}

function dfs(cur, pos, word, modification) {
    if (pos == word.length) return modification == 1 && cur.isEnd ? 1 : 0;
    let ans = 0;
    for (let i = 0; i < 26; i++) {
        let val = modification + (word[pos].charCodeAt(0) - 97 == i ? 0 : 1);
        if (val <= 1 && cur.next[i]) ans |= dfs(cur.next[i], pos + 1, word, val);
    }
    return ans;
}

module.exports = {
    solve: function (A, B) {
        freeTrie(rot);
        rot = new Node();
        A.forEach((ele) => insert(ele));

        let c = "";
        B.forEach((ele) => (c += dfs(rot, 0, ele, 0)));
        return c;
    },
};
```
* * Solution in C++
```cpp
struct TrieNode {
    map < char, TrieNode * > child;
    bool isend;
};

// Function to create New Trie Node
struct TrieNode * getNewTrieNode() {
    struct TrieNode * temp = new TrieNode;
    temp -> isend = false;
    return temp;
}

void insert(TrieNode * root, string word) {
    struct TrieNode * current = root;
    // To hold letters of the word
    char s;
    // Traverse through strings in list
    for (int i = 0; i < word.length(); i++) {
        s = word[i];
        // If s is not present in the character field of current node
        if (current -> child.find(s) == current -> child.end()) {
            // Get new node
            struct TrieNode * p = getNewTrieNode();

            // Insert s in character field of current node with reference to node p
            (current -> child)[s] = p;

        }
        // Go to next node
        current = (current -> child)[s];
    }
    current -> isend = true;
}

bool query(TrieNode * cur, int i, string & s, int flag, bool last) {
    bool ans = false;
    int n = s.size();
    if (i == n) {
        if (flag == 1 && last) {
            return true;
        }
        return false;
    }
    char c = s[i];
    // If the complete prefix is not present in the trie
    if (flag == 0) {
        for (auto x = (cur -> child).begin(); x != (cur -> child).end(); x++) {
            if (x -> first == c) {
                ans = ans | query(x -> second, i + 1, s, flag, x -> second -> isend);
            } else {
                ans = ans | query(x -> second, i + 1, s, 1 - flag, x -> second -> isend);
            }
        }
    } else {
        if ((cur -> child).find(c) != (cur -> child).end()) {
            ans = ans | query((cur -> child)[c], i + 1, s, flag, (cur -> child)[c] -> isend);
        }
    }
    return ans;
}

string Solution::solve(vector < string > & A, vector < string > & B) {
    TrieNode * root = getNewTrieNode();
    for (int i = 0; i < A.size(); i++) {
        insert(root, A[i]);
    }
    string ans = "";
    for (int i = 0; i < B.size(); i++) {
        int temp = query(root, 0, B[i], 0, false);
        ans += temp + '0';
    }
    return ans;
}
```

