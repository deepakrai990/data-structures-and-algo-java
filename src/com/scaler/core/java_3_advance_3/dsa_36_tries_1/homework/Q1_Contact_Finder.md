### Q1. Contact Finder
#### Problem Description
```text
We want to make a custom contacts finder applications as part of 
our college project. The application must perform two types of operations:

Type 1: Add name B[i] ,denoted by 0 in vector A where B[i] is a string 
        in vector B denoting a contact name. This must store B[i] as a 
        new contact in the application.

Type 2: Find partial for B[i] ,denoted by 1 in vector A where B[i] is 
        a string in vector B denoting a partial name to search the 
        application for. It must count the number of contacts starting 
        with B[i].

You have been given sequential add and find operations. You need to 
perform each operation in order.

And return as an array of integers, answers for each query 
of type 2(denoted by 1 in A) .
```
#### Problem Constraints
```text
1 <= |A| <= 10000

1 <= |length of strings in B| <= 10
```
#### Input Format
```text
First argument is the vector A, which denotes the type of query.

Second argument is the vector B, which denotes the string for 
corresponding query.
```
#### Output Format
```text
Return an array of integers, denoting answers for each query of type 1.
```
#### Example Input
```text
Input 1:
 A = [0, 0, 1, 1]
 B = ["hack", "hacker", "hac", "hak"]

Input 2:
 A = [0, 1]
 B = ["abcde", "abc"]
```
#### Example Output
```text
Output 1:
 [2, 0]

Output 2:
 [1]
```
#### Example Explanation
```text
Explanation 1:
    We perform the following sequence of operations:
    
    Add a contact named "hack".
    
    Add a contact named "hacker".
    
    Find the number of contact names beginning with "hac". There are 
    currently two contact names in the application and both of them start 
    with "hac", so we have 2.
    
    Find the number of contact names beginning with "hak". There are 
    currently two contact names in the application but neither of them start 
    with "hak", so we get0.

Explanation 2:
    Add "abcde"
    Find words with prefix "abc". We have answer as 1.
```
### Hints
* Hint 1
```text
We will be maintaining a trie. Each node in the trie will contain the 
following information:

1.count : Number of times this node has been visited during insertion 
          of the strings.

2.next : An array of pointers that contains the pointer to the 
         next nodes. will contain the next node that is reachable 
         using ‘a’, will contain the next node that is reachable 
         using ‘b’ and so on. Initially, the pointers will be null.
```
* Solution Approach
```text
Handling operations:

Add : We will simply insert the string in the trie.
We will increase the value of the variable of the nodes that are 
visited in the process by .

Find : We need to find the number of strings which have been inserted 
into the trie and have as a prefix.

We will start from the root of the trie and traverse it using the string .

The value of the variable stored in the final node ( the node where 
the traversal ends) is the answer to this operation.

This is because all the strings that have as prefix must have visited 
this node and no other string can visit this node.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    static final int ALPHABET_SIZE = 26;
    static TrieNode root;
    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        int ct;
        TrieNode() {
            ct = 0;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }
    };
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
            pCrawl.ct++;
        }
    }
    static int search(String key) {
        int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;
        for (level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null)
                break;
            pCrawl = pCrawl.children[index];
        }
        if (level == key.length())
            return pCrawl.ct;
        return 0;

    }
    public int[] solve(int[] A, String[] B) {
        root = new TrieNode();
        int q = A.length;
        ArrayList < Integer > v = new ArrayList < Integer > ();
        for (int i = 0; i < q; i++) {
            if (A[i] == 0)
                insert(B[i]);
            else
                v.add(search(B[i]));
        }
        int[] res = new int[v.size()];
        int index = 0;
        for (int a: v)
            res[index++] = a;
        return res;
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

function getAns(word) {
  let cur = rot;
  for (let i = 0; i < word.length; i++) {
    let number = word[i].charCodeAt(0) - 97;
    if (cur.next[number] == null) return 0;
    cur = cur.next[number];
  }
  return cur.cnt;
}

module.exports = {
  solve: function (A, B) {
    freeTrie(rot);
    rot = new Node();
    let ret = [];

    A.forEach((ele, index) => {
      if (ele == 0) insert(B[index]);
      else ret.push(getAns(B[index]));
    });

    return ret;
  },
};
```
* * Solution in C++
```cpp
struct node {
    int count;
    node * next[26];
    node() {
        count = 0;
        for (int i = 0; i < 26; i++)
            next[i] = NULL;
    }
}* root;

void add(string name) {
    node * current = root;
    current -> count++;
    for (int i = 0; i < name.size(); i++) {
        char nw = name[i];
        if (current -> next[(int) nw - 'a'] == NULL)
            current -> next[(int) nw - 'a'] = new node();
        current = current -> next[(int) nw - 'a'];
        current -> count++;
    }
}

int solver(string partial) {
    node * current = root;
    for (int i = 0; i < partial.size(); i++) {
        char nw = partial[i];
        if (current -> next[(int) nw - 'a'] == NULL)
            return 0;
        current = current -> next[(int) nw - 'a'];
    }
    return current -> count;
}

vector < int > Solution::solve(vector < int > & A, vector < string > & B) {
    vector < int > ans;
    root = new node();
    for (int i = 0; i < A.size(); i++) {
        if (A[i] == 0)
            add(B[i]);
        else {
            string s;
            s = B[i];
            ans.push_back(solver(s));
        }
    }
    return ans;
}
```
