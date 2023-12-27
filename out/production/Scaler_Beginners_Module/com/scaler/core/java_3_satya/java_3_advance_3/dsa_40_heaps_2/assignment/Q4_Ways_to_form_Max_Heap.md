### Q4. Ways to form Max Heap
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p><strong>Max Heap</strong> is a special kind of <strong>complete binary 
    tree</strong> in which, for every node, the value present in that node is greater 
    than the value present in its children nodes.</p>
    <p>Find the number of <strong>distinct Max Heap</strong> that can be made from 
    <strong>A </strong>distinct integers.</p>
    <p>In short, you have to ensure the following properties for the max heap :</p>
    <ul>
    <li>Heap has to be a complete binary tree ( A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible.)</li>
    <li>Every node is greater than all its children.</li>
    </ul>
    <p><strong>NOTE: </strong> If you want to know more about Heaps, please visit 
    this <a href="https://en.wikipedia.org/wiki/Heap_%28data_structure%29">link</a>. 
    Return your answer <strong>modulo 10<sup>9</sup> + 7</strong>.</p>
</div>

#### Problem Description
```text
Max Heap is a special kind of complete binary tree in which, for every node, the value 
present in that node is greater than the value present in its children nodes.

Find the number of distinct Max Heap that can be made from A distinct integers.

In short, you have to ensure the following properties for the max heap :

Heap has to be a complete binary tree ( A complete binary tree is a binary tree in which 
every level, except possibly the last, is completely filled, and all nodes are as far 
left as possible.)

Every node is greater than all its children.

NOTE: If you want to know more about Heaps, please visit this link. Return your 
answer modulo 10^9 + 7.
```
#### Problem Constraints
```text
1 <= A <= 100
```
#### Input Format
```text
The first and only argument is an integer A.
```
#### Output Format
```text
Return an integer denoting the number of distinct Max Heap.
```
#### Example Input
```text
Input 1:
 A = 4

Input 2:
 A = 10
```
#### Example Output
```text
Output 1:
 3

Output 2:
 3360
```
#### Example Explanation
```text
Explanation 1:
     Let us take 1, 2, 3, 4 as our 4 distinct integers
     Following are the 3 possible max heaps from these 4 numbers :
          4           4                     4
        /  \         / \                   / \ 
       3    2   ,   2   3      and        3   1
      /            /                     /    
     1            1                     2

Explanation 2:
    Number of distinct heaps possible with 10 distinct integers = 3360.
```
### Hints
* Hint 1
```text
Verify if the following is true:

    * The structure of the heap tree will be fixed.
    * Given the numbers in a subtree, the root value is going to be fixed.

Are the numbers in the left and right subtree independent of each other?
```
* Solution Approach
<div>
    <ul>
      <li>
        <p>Suppose there are <code class="highlighter-rouge">n</code> distinct elements to be used in the Max heap. Now it is for sure that the maximum element among this <code class="highlighter-rouge">n</code> distinct element will surely be placed on the root of the heap.</p>
      </li>
      <li>
        <p>Now, there will be remaining <code class="highlighter-rouge">(n-1)</code> elements to be arranged.</p>
      </li>
      <li>
        <p>Now point to be remembered here is that the structure of the heap will remain the same. That is, only the values within the node will change. However, the overall structure remains the same.</p>
      </li>
      <li>
        <p>As the structure of the heap remains the same, the number of elements that are present in the left sub-tree of the root (<code class="highlighter-rouge">L</code>) will be fixed. And similarly, the number of the elements on the right sub-tree (<code class="highlighter-rouge">R</code>) of the root. And also, following equality holds.</p>
      </li>
      <li>
        <p><strong> L + R = (n-1)</strong></p>
      </li>
      <li>
        <p>Now as all the remaining <code class="highlighter-rouge">(n-1)</code> elements are less than the element present at the root(The Max Element), whichever <code class="highlighter-rouge">L</code> elements among ‘n-1` elements we put in the left sub-tree, it doesn’t matter because it will satisfy the <strong>Max Heap property</strong>.</p>
      </li>
      <li>
        <p>So now there are <strong><sup>(n-1)</sup>C<sub>L</sub></strong> ways to pickup <code class="highlighter-rouge">L</code> elements from <code class="highlighter-rouge">(n-1)</code> elements. And then recurse the solution.</p>
      </li>
      <li>
        <p>So the final equation will be as follows :</p>
      </li>
      <li>
        <p><strong><sup>(n-1)</sup>C<sub>L</sub> * getNumberOfMaxHeaps(L) * getNumberOfMaxHeaps(R)</strong></p>
      </li>
      <li>
        <p>So now the question remains only of finding <code class="highlighter-rouge">L</code> for given <code class="highlighter-rouge">n</code>. It can be found as follows:</p>
      </li>
      <li>
        <p>Find the height of the heap <strong>h = log<sub>2</sub>(n)</strong></p>
      </li>
      <li>
        <p>Find the max number of elements that can be present in the h<sup>th</sup> level of any heap . Lets call it m. <strong>m = 2<sup>h</sup></strong></p>
      </li>
      <li>
        <p>Find the number of elements that are actually present in last level(h<sup>th</sup> level) in heap of size n. Lets call it p. <strong>p = n - (2<sup>h</sup> - 1)</strong></p>
      </li>
      <li>
        <p>Now, if the last level of the heap is more than or equal to exactly half-filled, then <code class="highlighter-rouge">L</code> would be <strong>2<sup>h</sup> - 1</strong></p>
      </li>
      <li>
        <p>However, if it is half-filled, then it will be reduced by the number of elements in the last level left to fill exactly half of the last level.</p>
      </li>
      <li>
        <p>So final equation for L will be as follows :</p>
      </li>
      <li>
        <p><strong>L = 2<sup>h</sup> - 1 if p &gt;= m/2</strong>  <br>
    <strong>    = 2<sup>h</sup> - 1 - (m/2 - p) if p&lt;(m/2)</strong></p>
      </li>
    </ul>
</div>

* Complete Solution
* * Solution in Java
```java
public class Solution {

    long[] dp; /* dp[i] = number of max heaps for i distinct integers */
    long[][] nck; /* nck[i][j] = i choose j if i>=j else 0 */
    int[] log2; /* log2[i] = int(log base 2 of i) */

    final long MOD = 1000000007;

    public long choose(int n, int k) {
        if (k > n)
            return 0;
        if (n <= 1)
            return 1;
        if (k == 0)
            return 1;

        if (nck[n][k] != -1)
            return nck[n][k];
        long answer = choose(n - 1, k - 1) + choose(n - 1, k);
        answer %= MOD;
        nck[n][k] = answer;
        return answer;
    }

    public int getL(int n) {
        if (n == 1)
            return 0;

        int h = log2[n];
        int p = n - ((1 << (h)) - 1);
        int m = (1 << h);
        if (p >= (m / 2))
            return (1 << (h)) - 1;
        else
            return (1 << (h)) - 1 - ((m / 2) - p);
    }

    public int solve(int n) {
        dp = new long[n + 1];
        for (int i = 0; i <= n; i++)
            dp[i] = -1;

        nck = new long[n + 1][n + 1];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= n; j++)
                nck[i][j] = -1;

        log2 = new int[n + 1];
        int currLogAnswer = -1;
        int currPower2 = 1;
        for (int i = 1; i <= n; i++) {
            if (currPower2 == i) {
                currLogAnswer++;
                currPower2 *= 2;
            }
            log2[i] = currLogAnswer;
        }

        return (int) getNumberOfMaxHeaps(n);
    }

    public long getNumberOfMaxHeaps(int n) {
        if (n <= 1)
            return 1;

        if (dp[n] != -1)
            return dp[n];

        int L = getL(n);
        long ans = (choose(n - 1, L) * getNumberOfMaxHeaps(L)) % MOD * (getNumberOfMaxHeaps(n - 1 - L));
        ans %= MOD;
        dp[n] = ans;
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
const MAXN = 105;
let dp = new Array(MAXN).fill(0);
let nck = new Array(MAXN).fill(0).map(() => new Array(MAXN).fill(0));
let log_2 = new Array(MAXN).fill(0);
const MOD = 1000000007;

function mult(a, b) {
	let val = a * b;
	if (val <= Number.MAX_SAFE_INTEGER && val >= Number.MIN_SAFE_INTEGER)
		return val % MOD;
	return Number((BigInt(a) * BigInt(b)) % BigInt(MOD));
}

function choose(n, k) {
	if (k > n) return 0;
	if (n <= 1) return 1;
	if (k == 0) return 1;

	if (nck[n][k] != -1) return nck[n][k];
	let answer = choose(n - 1, k - 1) + choose(n - 1, k);
	answer %= MOD;
	nck[n][k] = answer;
	return answer;
}

function getL(n) {
	if (n == 1) return 0;

	let h = log_2[n];
	let p = n - ((1 << h) - 1);
	let m = 1 << h;
	if (p >= Math.floor(m / 2)) return (1 << h) - 1;
	else return (1 << h) - 1 - (Math.floor(m / 2) - p);
}

function getNumberOfMaxHeaps(n) {
	if (n <= 1) return 1;

	if (dp[n] != -1) return dp[n];

	let L = getL(n);
	let ans = mult(
		mult(choose(n - 1, L), getNumberOfMaxHeaps(L)),
		getNumberOfMaxHeaps(n - 1 - L)
	);
	ans %= MOD;
	dp[n] = ans;
	return ans;
}

module.exports = {
	solve: function(n) {
		for (let i = 0; i <= n; i++) dp[i] = -1;

		for (let i = 0; i <= n; i++)
			for (let j = 0; j <= n; j++) nck[i][j] = -1;

		let currlog_2Answer = -1;
		let currPower2 = 1;
		for (let i = 1; i <= n; i++) {
			if (currPower2 == i) {
				currlog_2Answer++;
				currPower2 *= 2;
			}
			log_2[i] = currlog_2Answer;
		}
		return +getNumberOfMaxHeaps(n);
	},
};
```
* * Solution in C++
```cpp
#define MAXN 105

long long int dp[MAXN]; /* dp[i] = number of max heaps for i distinct integers */
long long int nck[MAXN][MAXN]; /* nck[i][j] = i choose j if i>=j else 0 */
int log_2[MAXN]; /* log_2[i] = int(log_2 base 2 of i) */
long long int MOD = 1000000007;

long long int choose(int n, int k) {
    if (k > n)
        return 0;
    if (n <= 1)
        return 1;
    if (k == 0)
        return 1;

    if (nck[n][k] != -1)
        return nck[n][k];
    long long int answer = choose(n - 1, k - 1) + choose(n - 1, k);
    answer %= MOD;
    nck[n][k] = answer;
    return answer;
}

int getL(int n) {
    if (n == 1)
        return 0;

    int h = log_2[n];
    int p = n - ((1 << (h)) - 1);
    int m = (1 << h);
    if (p >= (m / 2))
        return (1 << (h)) - 1;
    else
        return (1 << (h)) - 1 - ((m / 2) - p);
}

long long int getNumberOfMaxHeaps(int n) {
    if (n <= 1)
        return 1;

    if (dp[n] != -1)
        return dp[n];

    int L = getL(n);
    long long int ans = (choose(n - 1, L) * getNumberOfMaxHeaps(L)) % MOD * (getNumberOfMaxHeaps(n - 1 - L));
    ans %= MOD;
    dp[n] = ans;
    return ans;
}

int Solution::solve(int n) {
    for (int i = 0; i <= n; i++)
        dp[i] = -1;

    for (int i = 0; i <= n; i++)
        for (int j = 0; j <= n; j++)
            nck[i][j] = -1;

    int currlog_2Answer = -1;
    int currPower2 = 1;
    for (int i = 1; i <= n; i++) {
        if (currPower2 == i) {
            currlog_2Answer++;
            currPower2 *= 2;
        }
        log_2[i] = currlog_2Answer;
    }

    return (int) getNumberOfMaxHeaps(n);
}
```

