### Q3. Shortest Unique Prefix

#### Problem Description

```text
Given a list of N words, find the shortest unique prefix to represent each word in the list.

NOTE: Assume that no word is the prefix of another. In other words, the 
representation is always possible
```

#### Problem Constraints

<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= Sum of length of all words &lt;= 10<sup>6</sup></p>
</div>

```text
1 <= Sum of length of all words <= 10^6
```

#### Input Format

```text
First and only argument is a string array of size N.
```

#### Output Format

```text
Return a string array B where B[i] denotes the shortest unique prefix to 
represent the i^th word.
```

#### Example Input

```text
Input 1:
 A = ["zebra", "dog", "duck", "dove"]

Input 2:
 A = ["apple", "ball", "cat"]
```

#### Example Output

```text
Output 1:
 ["z", "dog", "du", "dov"]

Output 2:
 ["a", "b", "c"]
```

#### Example Explanation

```text
Explanation 1:
    Shortest unique prefix of each word is:
    For word "zebra", we can only use "z" as "z" is not any prefix of any other word given.
    For word "dog", we have to use "dog" as "d" and "do" are prefixes of "dov".
    For word "du", we have to use "du" as "d" is prefix of "dov" and "dog".
    For word "dov", we have to use "dov" as "d" and do" are prefixes of "dog".  
 
Explanation 2:
    "a", "b" and c" are not prefixes of any other word. So, we can use of first 
    letter of each to represent.
```

### Hints

* Hint 1

```text
Use Prefix tree or 
Trie ( https://www.topcoder.com/community/data-science/data-science-tutorials/using-tries/ )

Assume you have all the prefixes of the word stored in the tree along with their 
frequencies. Is it possible to arrive at the solution now?
```

* Solution Approach

```text
Lets take an example:

input: ["zebra", "dog", "duck", "dot"]

Now we will build prefix tree and we will also store count of characters

                root
                /|
         (d, 3)/ |(z, 1)
              /  |
          Node1  Node2
           /|        \
     (o,2)/ |(u,1)    \(e,1)
         /  |          \
   Node1.1  Node1.2     Node2.1
      | \         \            \
(g,1) |  \ (t,1)   \(c,1)       \(b,1)
      |   \         \            \ 
    Leaf Leaf       Node1.2.1     Node2.1.1
    (dog)  (dot)        \                  \
                         \(k, 1)            \(r, 1)
                          \                  \   
                          Leaf               Node2.1.1.1
                          (duck)                       \
                                                        \(a,1)
                                                         \
                                                         Leaf
                                                         (zebra)

Now, for every leaf / word , we find the character nearest to the root with 
frequency as 1. 

The prefix that the path from root to this character corresponds to, is the 
representation of the word. 
```

* Complete Solution
*
    * Solution in Java

```java
public class Solution {
    private Node root;

    public ArrayList<String> prefix(ArrayList<String> A) {
        ArrayList<String> res = new ArrayList<>();
        for (String str : A) {
            put(str);
        }
        for (String str : A) {
            String prefix = getPrefix(str);
            res.add(prefix);
        }
        return res;
    }

    public String getPrefix(String str) {
        StringBuilder strB = new StringBuilder();
        return get(root, str, 0, strB);
    }

    public String get(Node node, String str, int index, StringBuilder strB) {
        char c = str.charAt(index);
        if (c < node.c) {
            return get(node.left, str, index, strB);
        } else if (c > node.c) {
            return get(node.right, str, index, strB);
        } else if (node.val == 1) {
            strB.append(node.c);
            return strB.toString();
        } else {
            strB.append(node.c);
            return get(node.mid, str, index + 1, strB);
        }
    }

    public void put(String str) {
        root = put(root, str, 0);
    }

    public Node put(Node node, String str, int index) {
        if (index == str.length())
            return node;
        if (node == null)
            node = new Node(str.charAt(index));
        char c = str.charAt(index);
        if (c < node.c) {
            node.left = put(node.left, str, index);
        } else if (c > node.c) {
            node.right = put(node.right, str, index);
        } else {
            node.mid = put(node.mid, str, index + 1);
            node.val += 1;
        }
        return node;
    }

    class Node {
        char c;
        int val;
        Node left, mid, right;

        public Node() {
        }

        public Node(char c) {
            this.c = c;
            this.val = 0;
        }
    }
}
```

*
    * Solution in Javascript

```javascript
class Node {
    constructor() {
        this.isEnd = false;
        this.next = new Array(26).fill(null);
        this.cnt = 0;
    }
}

let id = 0;
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
    cur.isEnd = id;
}

function freeTrie(cur) {
    if (cur == null) return;
    for (let i = 0; i < 26; i++) freeTrie(cur.next[i]), (cur.next[i] = null);
}

let now = new Map();

function dfs(cur, lvl, val) {
    if (cur.isEnd) {
        now.set(cur.isEnd, val);
        return;
    }
    for (let i = 0; i < 26; i++) {
        if (cur.next[i]) {
            let st = val;
            if (cur.cnt == 1) st = Math.min(st, lvl);
            dfs(cur.next[i], lvl + 1, st);
        }
    }
}

module.exports = {
    prefix: function (A) {
        now.clear();
        freeTrie(rot);
        rot = new Node();
        A.forEach((ele, idx) => {
            id = idx + 1;
            insert(ele);
        });
        dfs(rot, 0, 1000000);
        let ret = [];
        for (let i = 0; i < A.length; i++) {
            ret.push(A[i].slice(0, now.get(i + 1)));
        }
        return ret;
    },
};
```

*
    * Solution in C++

```cpp
int IDX; // denotes the number of nodes in the trie
vector < vector < int > > Cnt; // store the count of words having the same prefix upto a trie node.
vector < vector < int > > Trie;

void insert(string str) {
    int len = str.size();
    int root = 0;
    int i = 0;
    while (i < len) {
        int chr = str[i] - 'a';
        //if there is o node for str[i] character, increase the size of the trie and assign the last node at index IDX to Trie[root][chr].
        if (Trie[root][chr] == -1) {
            ++IDX;
            Trie[root][chr] = IDX;
            Cnt[root][chr] = 1;
        } else {
            Cnt[root][chr]++;
        }
        root = Trie[root][chr];
        i++;
    }
}

string Query(string str) {
    int root = 0;
    string ans = "";
    int i = 0;
    int len = str.size();
    // traverse in the trie untill we reach at a node where the cnt[node] = 1. 
    while (i < len) {
        int chr = str[i] - 'a';
        ans += str[i];
        if (Cnt[root][chr] == 1)
            return ans;
        root = Trie[root][chr];
        i++;
    }
    return "";
}

vector < string > Solution::prefix(vector < string > & Vec) {
    int mx_len = 0;
    int N = Vec.size();
    // find the maximum length of the word.
    for (int i = 0; i < N; ++i) {
        mx_len = max(mx_len, (int) Vec[i].size());
    }
    Trie.clear();
    Cnt.clear();
    // Set the size of trie = max length of a word * Number of words = Maximum number of nodes in the trie.
    Trie.resize(N * mx_len + 1, vector < int > (27, -1));
    Cnt.resize(N * mx_len + 1, vector < int > (27, -1));
    IDX = 0;
    // insert all words into trie
    for (int i = 0; i < N; ++i) {
        insert(Vec[i]);
    }
    vector < string > Ans;
    //For every word find the shortest unique prefix possible.
    for (int i = 0; i < N; ++i) {
        string ans = Query(Vec[i]);
        Ans.push_back(ans);
    }
    return Ans;
}
```

