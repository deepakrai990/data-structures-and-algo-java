### Q2. Auto Complete
#### Problem Description
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>There is a dictionary <strong>A</strong> of <strong>N</strong> words, 
    and <strong>i<sup>th</sup></strong> word has a unique weight 
    <strong>W<sub>i</sub></strong>.</p>
    <p>Another string array <strong>B</strong> of size <strong>M</strong> 
    contains the prefixes. For every prefix <strong>B[i]</strong>, 
    output <strong>atmost 5</strong> words from the dictionary A that start 
    with the same prefix.</p>
    <p>Output the words in <strong>decreasing order</strong> of their weight.</p>
    <p><strong>NOTE:</strong> If there is no word that starts with the given prefix 
    output <strong>-1</strong>.</p>
></div>

```text
There is a dictionary A of N words, and i^th word has a unique weight Wi.

Another string array B of size M contains the prefixes. For every prefix B[i], 
output at most 5 words from the dictionary A that start with the same prefix.

Output the words in decreasing order of their weight.

NOTE: If there is no word that starts with the given prefix output -1.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= T &lt;= 5</p><p>
    <p>1 &lt;= N &lt;= 20000<br>
    1 &lt;= M &lt;= 10000</p>
    <p>1 &lt;= W<sub>i</sub> &lt;= 10<sup>6</sup></p>
    <p> 1 &lt;= length of any string either in A or B &lt;= 30 </p>
</div>

```text
1 <= T <= 5

1 <= N <= 20000
1 <= M <= 10000

1 <= Wi <= 10^6

1 <= length of any string either in A or B <= 30
```
#### Input Format
```text
First line is an integer T denoting the number of test cases.
For each test case,

    * First line denotes two space seperated integer N and M.
    * Second line denotes N space seperated strings denoting the words in dictionary.
    * Third line denotes N space seperated integers denoting the weight of each word in 
      the dictionary.
    * Fourth line denotes M space seperated integers denoting the prefixes.
```
#### Output Format
```text
For every prefix B[i], print the space seperated output on a new line.

NOTE: After every output there should be a space.
```
#### Example Input
```text
Input 1:
 1
 6 3
 abcd aecd abaa abef acdcc acbcc
 2 1 3 4 6 5
 ab abc a

Input 2:
 1
 5 3
 aaaa aacd abaa abaa aadcc
 3 4 1 2 6 
 aa aba abc
```
#### Example Output
```text
Output 1:
 abef abaa abcd 
 abcd 
 acdcc acbcc abef abaa abcd 

Output 2:
 aadcc aacd aaaa 
 abaa abaa 
 -1 
```
#### Example Explanation
```text
Explanation 1:
     For the prefix "ab" 3 words in the dictionary have same 
     prefix: ("abcd" : 2, "abaa" : 3, "abef" : 4). Output them in decreasing 
     order of weight.
     
     For the prefix "abc" only 1 word in the dictionary have same 
     prefix: ("abcd" : 2).
     
     For the prefix "a" all 6 words in the dictionary have same 
     prefix: ("abcd" : 2, "aecd" : 1, "abaa" : 3, "abef" : 4, "acdcc" : 6, "acbcc" : 5).
     
     Since we can output at most 5 words. Output top 5 weighted words in 
     decreasing order of weight.

Explanation 2:
     For the prefix "aa" 3 words in the dictionary have same 
     prefix: ("aaaa" : 3, "aacd" : 4, "aadcc" : 6). Output them in decreasing 
     order of weight.
     
     For the prefix "aba" 2 words in the dictionary have same 
     prefix: ("abaa" : 1, "abaa" : 2).
     
     For the prefix "abc" there is no word in the dictionary which have same 
     prefix. So print -1.
```
### Hints
* Hint 1
```text
Create a Prefix Trie.

Can you store the answer, i.e., the top 5 weighted words with each node, by 
maintaining an array?
```
* Solution Approach
```text
Create a prefix Trie, but the Node of a Trie will also contain an array that will 
denote the answer for each prefix B[i].

How?

Sort the given dictionary in decreasing order of its weight. Now insert the word in 
the Trie and update the answer array if its size is less than 5 (Since we need to 
output at most 5 words).

For each query, search for the prefix if no word exists in the trie with the given 
prefix output -1.

Else, the answer array at the end of the prefix will be the answer.

Print the answer in the given format.
```
* Complete Solution
* * Solution in Java
```java
import java.lang .*;
import java.util .*;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int t = inp.nextInt();
        inp.nextLine();
        while (t-- > 0) {
            int n, m;
            n = inp.nextInt();
            m = inp.nextInt();
            inp.nextLine();
            String s[] = inp.nextLine().split(" ");
            String temp[] = inp.nextLine().split(" ");
            int[] wt = new int[n];
            for (int i = 0; i < temp.length; i++)
                wt[i] = Integer.parseInt(temp[i]);
            String q[] = inp.nextLine().split(" ");
            solve(s, wt, q);
        }
        inp.close();
    }

    public static void solve(String[] A, int[] W, String[] B) {
        TrieNode root = new TrieNode();
        ArrayList<pair> v = new ArrayList<pair>();
        for (int i = 0; i < A.length; i++) {
            v.add(new pair(W[i], i));
        }
        Collections.sort(v);
        for (int i = v.size() - 1; i >= 0; i--) {
            insert(root, A[v.get(i).second], v.get(i).second, W);
        }
        for (int i = 0; i < B.length; i++) {
            ArrayList<pair> ans = new ArrayList<pair>(query(root, B[i], W));
            if (ans.size() == 0) {
                System.out.println(-1 + " ");
            } else {
                for (int j = 0; j < ans.size(); j++) {
                    System.out.print(A[ans.get(j).second] + " ");
                }
                System.out.println();
            }
        }
    }

    public static ArrayList<pair> query(TrieNode root, String prefix, int[] W) {
        TrieNode temp = root;
        ArrayList<pair> ans = new ArrayList<pair>();
        for (int i = 0; i < prefix.length(); i++) {
            int chr_val = prefix.charAt(i) - 'a';
            if (temp.child[chr_val] == null) {
                temp = temp.child[chr_val];
                break;
            }
            temp = temp.child[chr_val];
        }
        if (temp == null) {
            return ans;
        }
        return temp.idx_ans;
    }

    public static void insert(TrieNode root, String word, int idx, int[] W) {
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            int chr_val = word.charAt(i) - 'a';
            if (temp.child[chr_val] == null) {
                temp.child[chr_val] = new TrieNode();
            }
            temp = temp.child[chr_val];
            if (temp.idx_ans.size() < 5) {
                temp.idx_ans.add(new pair(W[idx], idx));
            }
        }
        temp.isend = true;
    }
}

class TrieNode {
    TrieNode[] child;
    ArrayList<pair> idx_ans;
    boolean isend;

    public TrieNode() {
        child = new TrieNode[26];
        for (int i = 0; i < 26; i++) child[i] = null;
        idx_ans = new ArrayList<pair>();
        isend = false;
    }
}

class pair implements Comparable<pair> {
    int first;
    int second;

    public pair(int a, int b) {
        this.first = a;
        this.second = b;
    }

    @Override
    public int compareTo(pair a) {
        return this.first - a.first;
    }
}
```
* * Solution in Javascript
```javascript
process.stdin.setEncoding("utf8");

var input_stdin = "";
var input_stdin_array = "";
var input_currentline = 0;

process.stdin.on("data", function (data) {
    input_stdin += data;
});

process.stdin.on("end", function () {
    input_stdin_array = input_stdin.split("\n");
    main();
});

function readLine() {
    return input_stdin_array[input_currentline++];
}

function input_int_array(array) {
    var input_array = readLine().trim().split(/\s+/);
    array.length = 0;
    for (var i = 0; i < input_array.length; i++) {
        if (input_array[i].trim().length != 0) array.push(Number(input_array[i]));
    }
}

function input_string_array(array) {
    var input_array = readLine().trim().split(/\s+/);
    array.length = 0;
    for (var i = 0; i < input_array.length; i++) {
        array.push(input_array[i]);
    }
}

const mx = 26;

class Node {
    constructor() {
        this.isEnd = false;
        this.next = new Array(mx).fill(null);
        this.idx_ans = new Array();
        this.cnt = 0;
    }
}

let rot = new Node();

function insert(s, idx, W) {
    let cur = rot;
    let number;
    [...s].forEach((ele) => {
        number = ele.charCodeAt(0) - 97;
        if (cur.next[number] == null) cur.next[number] = new Node();
        cur = cur.next[number];
        if (cur.idx_ans.length < 5) {
            cur.idx_ans.push([W[idx], idx]);
        }
        cur.cnt++;
    });
    cur.isEnd = true;
}

function query(prefix, W) {
    let cur = rot;
    let ans = [];
    for (let i = 0; i < prefix.length; i++) {
        let code = prefix[i].charCodeAt(0) - 97;
        if (cur.next[code] == null) {
            cur = cur.next[code];
            break;
        }
        cur = cur.next[code];
    }
    if (cur == null) return ans;
    return cur.idx_ans;
}

function freeTrie(cur) {
    if (cur == null) return;
    for (let i = 0; i < 26; i++) freeTrie(cur.next[i]), (cur.next[i] = null);
}

function solve(A, W, B) {
    freeTrie(rot);
    rot = new Node();
    let v = [];
    let ret = [];
    W.forEach((ele, idx) => v.push([ele, idx]));
    v.sort((a, b) => {
        if (a[0] == b[0]) return a[1] - b[1];
        return a[0] - b[0];
    });
    v.reverse();
    for (let i = 0; i < v.length; i++) {
        insert(A[v[i][1]], v[i][1], W);
    }
    for (let i = 0; i < B.length; i++) {
        let ans = query(B[i], W);
        if (ans.length == 0) {
            console.log('-1 ');
        } else {
            let cur = "";
            for (let j = 0; j < ans.length; j++) {
                cur += A[ans[j][1]] + " ";
            }
            console.log(cur);
        }
    }
    return ret;
}

function main() {
    var T = Number(readLine());
    var C = [];
    var D = [];
    var E = [];
    for (var it = 0; it < T; it++) {
        var B = readLine().trim();
        input_string_array(C);
        input_int_array(D);
        input_string_array(E);
        D.forEach((ele) => (ele = Number(ele)));
        let ret = solve(C, D, E);
    }
}
```
* * Solution in C++
```cpp
#include<bits/stdc++.h>
using namespace std;

struct TrieNode {
    TrieNode * child[26];
    vector < pair < int, int >> idx_ans;
    bool isend;
};

TrieNode * getNode() {
    TrieNode * pNode = new TrieNode;
    pNode -> isend = false;
    for (int i = 0; i < 26; i++)
        pNode -> child[i] = NULL;
    return pNode;
}

void insert(TrieNode * root, string word, int idx, vector < int > & W) {
    TrieNode * temp = root;
    for (int i = 0; i < word.size(); i++) {
        int chr_val = word[i] - 'a';
        if (temp -> child[chr_val] == NULL) {
            temp -> child[chr_val] = getNode();
        }
        temp = temp -> child[chr_val];
        if (temp -> idx_ans.size() < 5) {
            temp -> idx_ans.push_back({
                W[idx],
                idx
            });
        }
    }
    temp -> isend = true;
}

vector < pair < int, int >> query(TrieNode * root, string prefix, vector < int > & W) {
    TrieNode * temp = root;
    vector < pair < int, int >> ans;
    for (int i = 0; i < prefix.size(); i++) {
        int chr_val = prefix[i] - 'a';
        if (temp -> child[chr_val] == NULL) {
            temp = temp -> child[chr_val];
            break;
        }
        temp = temp -> child[chr_val];
    }
    if (temp == NULL) {
        return ans;
    }
    return temp -> idx_ans;
}

void solve(vector < string > & A, vector < int > & W, vector < string > & B) {
    TrieNode * root = getNode();
    vector < pair < int, int > > v;
    for (int i = 0; i < A.size(); i++) {
        v.push_back({
            W[i],
            i
        });
    }
    sort(v.begin(), v.end());
    for (int i = v.size() - 1; i >= 0; i--) {
        insert(root, A[v[i].second], v[i].second, W);
    }
    for (int i = 0; i < B.size(); i++) {
        vector < pair < int, int >> ans = query(root, B[i], W);
        if (ans.size() == 0) {
            cout << "-1 " << endl;
        } else {
            for (int j = 0; j < ans.size(); j++) {
                cout << A[ans[j].second] << " ";
            }
            cout << endl;
        }
    }
}

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, m;
        cin >> n >> m;
        vector < string > A(n);
        vector < int > W(n);
        vector < string > B(m);
        for (int i = 0; i < n; i++) {
            cin >> A[i];
        }
        unordered_map < int, int > ump;
        for (int i = 0; i < n; i++) {

            cin >> W[i];
            ump[W[i]]++;
            assert(ump[W[i]] == 1);
        }
        for (int i = 0; i < m; i++) {
            cin >> B[i];
        }
        solve(A, W, B);
    }
}
```

