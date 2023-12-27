### Q1. Spelling Checker
#### Problem Description
```text
Given an array of words A (dictionary) and another array B (which contain some words).

You have to return the binary array (of length |B|) as the answer where 1 denotes 
that the word is present in the dictionary and 0 denotes it is not present.

Formally, for each word in B, you need to return 1 if it is present in Dictionary 
and 0 if not.

Such problems can be seen in real life when we work on any online editor (like 
Google Documnet), if the word is not valid it is underlined by a red line.

NOTE: Try to do this in O(n) time complexity.
```
#### Problem Constraints
```text
1 <= |A| <= 1000

1 <= sum of all strings in A <= 50000

1 <= |B| <= 1000
```
#### Input Format
```text
First argument is array of strings A.

First argument is array of strings B.
```
#### Output Format
```text
Return the binary array of integers according to the given format.
```
#### Example Input
```text
Input 1:
 A = [ "hat", "cat", "rat" ]
 B = [ "cat", "ball" ]

Input 2:
 A = [ "tape", "bcci" ]
 B = [ "table", "cci" ]
```
#### Example Output
```text
Output 1:
 [1, 0]

Output 2:
 [0, 0]
```
#### Example Explanation
```text
Explanation 1:
    Only "cat" is present in the dictionary.

Explanation 2:
    None of the words are present in the dictionary.
```
### Hints
* Hint 1
```text
To this in O(n), you will need a different data structure called tries.
You can read about them first and then try to attempt this problem.
```
* Solution Approach
```text
To this in O(n), you will need a different data structure called tries.
You can insert all dictionary strings in a trie and then try finding all
given strings in the trie; each of those will take O(length) time.
Thus you can do this without the additional log factor you
get while working with sets.
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
    };
    public int[] solve(String[] A, String[] B) {
        root = new TrieNode();
        for (String temp: A)
            insert(temp);
        int[] ans = new int[B.length];
        for (int i = 0; i < B.length; i++) {
            if (search(B[i]) == true)
                ans[i] = 1;
            else ans[i] = 0;
        }
        return ans;
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
    static boolean search(String key) {
        int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;
        for (level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null)
                return false;
            pCrawl = pCrawl.children[index];
        }
        return (pCrawl != null && pCrawl.isEndOfWord);
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
    cur.isEnd = true;
}

function present(word) {
    let cur = rot;
    for (let i = 0; i < word.length; i++) {
        let num = word[i].charCodeAt(0) - 97;
        if (cur.next[num] == null) return false;
        cur = cur.next[num];
    }
    return cur.isEnd;
}

function freeTrie(cur) {
    if (cur == null) return;
    for (let i = 0; i < 26; i++) freeTrie(cur.next[i]), (cur.next[i] = null);
}

module.exports = {
    solve: function(A, B) {
        freeTrie(rot);
        rot = new Node();
        let ret = [];
        A.forEach((ele) => insert(ele));
        B.forEach((ele) => ret.push(present(ele) ? 1 : 0));
        return ret;
    },
};
```
* * Solution in C++
```cpp
const int ALPHABET_SIZE = 26;
struct trieNode {
    trieNode * t[ALPHABET_SIZE];
    bool isEnd;
};

// utility function to create a new node 
trieNode * getNode() {
    trieNode * temp = new(trieNode);
    // Initialize new node with null 
    for (int i = 0; i < ALPHABET_SIZE; i++)
        temp -> t[i] = NULL;
    temp -> isEnd = false;
    return temp;
}

// Function to insert new words in trie 
void insert(trieNode * root, string key) {
    trieNode * trail;
    trail = root;
    // Iterate for the length of a word 
    for (int i = 0; i < key.length(); i++) {
        // If the next key does not contains the character 
        if (trail -> t[key[i] - 'a'] == NULL) {
            trieNode * temp;
            temp = getNode();
            trail -> t[key[i] - 'a'] = temp;
        }
        trail = trail -> t[key[i] - 'a'];
    }
    // isEnd is made true signifying a word ends in this node
    (trail -> isEnd) = true;
}

// Search function to find a word of a sentence 
bool search_mod(trieNode * root, string word) {
    trieNode * trail;
    trail = root;
    // Iterate for the complete length of the word 
    for (int i = 0; i < word.length(); i++) {
        // If the character is not present then word 
        // is also not present 
        if (trail -> t[word[i] - 'a'] == NULL)
            return false;
        // If present move to next charater in Trie 
        trail = trail -> t[word[i] - 'a'];
    }
    // check if a word ends in the current node
    if (trail != NULL && trail -> isEnd)
        return true;
    else
        return false;
}

vector < int > Solution::solve(vector < string > & A, vector < string > & B) {
    trieNode * root;
    root = getNode();
    for (auto x: A)
        insert(root, x);
    vector < int > ans;
    for (auto x: B) {
        if (search_mod(root, x) == false)
            ans.push_back(0);
        else
            ans.push_back(1);
    }
    return ans;
}
```

