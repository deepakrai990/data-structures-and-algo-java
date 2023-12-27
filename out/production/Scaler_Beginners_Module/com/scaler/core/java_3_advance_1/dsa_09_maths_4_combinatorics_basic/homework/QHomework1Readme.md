### Q1. Sorted Permutation Rank with Repeats
#### Problem Description
```text
Given a string A, find the rank of the string amongst its 
permutations sorted lexicographically. Note that the 
characters might be repeated. If the characters are 
repeated, we need to look at the rank in unique 
permutations. Look at the example for more details.

NOTE:

    * The answer might not fit in an integer, so return your 
      answer % 1000003 where 1000003 is a prime number.

    * String A can consist of both lowercase and uppercase 
      letters. Characters with lesser ASCII values are 
      considered smaller, i.e., 'a' > 'Z'.
```
#### Problem Constraints
```text
1 <= len(A) <= 1000000
```
#### Input Format
```text
First argument is a string A.
```
#### Output Format
```text
Return an integer denoting the rank.
```
#### Example Input
```text
Input 1:
 A = "aba"

Input 2:
 A = "bca"
```
#### Example Output
```text
Output 1:
 2

Output 2:
 4
```
#### Example Explanation
```text
Explanation 1:
    The order permutations with letters 'a', 'a', and 'b' :
        aab
        aba 
        baa
    So, the rank is 2.

Explanation 2:
    The order permutations with letters 'a', 'b', and 'c' :
        abc
        acb 
        bac
        bca
        cab
        cba
    So, the rank is 4.
```
### Hints
* Hint 1
```text
If you have not solved the RANK problem, we advise you to take a 
look into that.
If you have, let’s move forward here.

Enumerating all permutations and matching them with the 
current one is going to be exponential.

Let’s start by looking at the first character.

If the first character is X, all permutations which had the 
first character less than X would come before this permutation 
when sorted lexicographically.

The number of permutations with a character C as the first 
character = number of permutations possible with 
remaining N-1 character = (N-1)! / (p1! * p2! * p3! ... ) 
where p1, p2, p3 are the number of occurrences of 
repeated characters.

For example, number of permutations possible with 3 ‘a’ 
and 3 ‘b’ is 6! / 3! 3! = 20

Can you use the above information to get the rank of the 
current permutation?
```
* Solution Approach
```text
Let’s start by looking at the first character.

If the first character is X, all permutations which had the first 
character less than X would come before this permutation when 
sorted lexicographically.

The number of permutations with a character C as the 
first character = number of permutations possible with 
remaining N-1 character = (N-1)! / (p1! * p2! * p3! ... ) 
where p1, p2, p3 are the number of occurrences of 
repeated characters.

For example, number of permutations possible with 3 ‘a’ 
and 3 ‘b’ is 6! / 3! 3! = 20

Hence,

rank = number of permutations possible with placing characters 
smaller than the current first character in the first 
position + rank of permutation of the string with the 
first character removed

So, we take a loop on the possibilities for the first 
character, and if that character is less than the 
current first character, we calculate the number of 
permutations using the formula given 
above (N-1)! / (p1! * p2! * p3! ... )

Now, there is a slight problem.
(N-1)! / (p1! * p2! * p3! ... ) does not necessarily fit 
in an integer. It is easy to calculate (N-1)! % MOD.

However, how do we handle divisions? 
Modular_multiplicative_inverse 
(https://en.wikipedia.org/wiki/Modular_multiplicative_inverse)
is what you are looking for.

In short,

(1/A) % MOD = A ^ (MOD - 2) % MOD
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    
    private int MOD = 1000003;
    public int findRank(String A) {
    
        // Initializations
        ArrayList<Integer> charCount = new ArrayList<Integer>(256);
        
        for(int i = 0; i < 256; i++) 
            charCount.add(0);
        for (int i = 0; i < A.length(); i++) {
            int ch = (int) A.charAt(i);
            charCount.set(ch, charCount.get(ch)+1);
        }
        
        ArrayList<Integer> fact = new ArrayList<Integer>(); // fact[i] will contain i! % MOD
        initializeFactorials(A.length() + 1, fact);
        
        long rank =  1;
        
        for (int i = 0; i < A.length(); i++) {
            // find number of permutations placing character smaller than A[i] at ith position 
            // among characters from i to A.length 
            long less = 0;
            int remaining = A.length() - i - 1;
            for (int ch = 0; ch < A.charAt(i); ch++) {
                if (charCount.get(ch) == 0) continue;
                // Lets try placing ch as the first character in remaining characters
                // and check the number of permutation possible.
                charCount.set(ch, charCount.get(ch)-1);
                long numPermutation = fact.get(remaining);
                
                for (int c = 0; c < 128; c++) {
                    if (charCount.get(c) <= 1) continue; 
                    numPermutation = (numPermutation * inverseNumber(fact.get(charCount.get(c)))) % MOD;
                }
    
                charCount.set(ch, charCount.get(ch)+1);
                less = (less + numPermutation) % MOD;
            }
            
            rank = (rank + less) % MOD;
            // remove the current character from the set. 
            charCount.set((int)A.charAt(i), charCount.get(A.charAt(i))-1);
        }
        return (int)rank;

    }
    
    public void initializeFactorials(int totalLen, ArrayList<Integer> fact) {
        // calculates factorial
        long factorial = 1;
        fact.add(1); // 0!= 1
        for (int curIndex = 1; curIndex < totalLen; curIndex++) {
            factorial = (factorial * curIndex) % MOD;
            fact.add((int)factorial);
        }
        return;
    }
    
    public long pow(long x, int y, int k){
        long result = 1;
        while(y > 0){
            if(y % 2 == 1) {
                result = (result * x) % k;
                y--;
            }
            y >>= 1;
            x = (x * x) % k;
        }
        return result;
    }
    long inverseNumber(int num) {
        // Find the modular multiplicative inverse
        // Calculates (num ^ (MOD - 2)) % MOD
        return pow(num, MOD-2 , MOD);
    }
}
```
* * Solution in Javascript
```javascript
const MOD = 1000003;
const maxn = 1000010;

let fact = new Array(maxn).fill(0);

let done = false;
function mult(a, b) {
    let val = a * b;
    if (val <= Number.MAX_SAFE_INTEGER && val >= Number.MIN_SAFE_INTEGER)
        return val % MOD;
    return Number((BigInt(a) * BigInt(b)) % BigInt(MOD));
}

function pw(a, b, m) {
    let res = 1;
    while (b > 0) {
        if (b & 1) 
            res = mult(res, a);
        a = mult(a, a);
        b >>= 1;
    }
    return res;
}

function precompute() {
    // calculates factorial
    fact[0] = 1;
    for (let i = 1; i < maxn; i++) fact[i] = (i * fact[i - 1]) % MOD;
}

function inv(val) {
    // Find the modular multiplicative inverse
    // Calculates (num ^ (MOD - 2)) % MOD
    return pw(fact[val], MOD - 2);
}

module.exports = {
    findRank: function (A) {
        if (!done) {
            done = true;
            precompute();
        }
        let mp = new Map();
        let curRank = 1;
        let now = A.length - 1;
        [...A].forEach((ele) => mp.set(ele, 1 + (mp.has(ele) ? mp.get(ele) : 0)));
        [...A].forEach((ele) => {
            // find number of permutations placing character smaller than ele at ith position 
            // among characters to the right of ele
            let code = ele.charCodeAt(0);
    
            for (let i = 0; i < 128; i++) {
                if (i >= code) break;
                let ch = String.fromCharCode(i);
                if (!mp.has(ch)) continue;
                
                // Lets try placing ch as the first character in remaining characters
                // and check the number of permutation possible.
                let coeff = fact[now];
                if (i < code && mp.get(ch) > 0) {
                    mp.set(ch, mp.get(ch) - 1);
                    for (let values of mp.values()) {
                        if(values <= 1)continue;
                        coeff = mult(coeff, inv(values));
                    }
                    curRank += coeff;
                    curRank %= MOD;
                    mp.set(ch, mp.get(ch) + 1);
                }
            }
            // remove the current character from the set. 
            mp.set(ele, mp.get(ele) - 1);
            now--;
        });
        return curRank;
    },
};
```
* * Solution in C++
```cpp
#define MOD 1000003

void initializeFactorials(int totalLen, vector<int> &fact) {
    // calculates factorial
    long long int factorial = 1;
    fact.push_back(1);
    for (int curIndex = 1; curIndex < totalLen; curIndex++) {
        factorial = (factorial * curIndex) % MOD;
        fact.push_back(factorial);
    }
    return;
}

long long int inverseNumber(int num) {
    // Find the modular multiplicative inverse
    // Calculates (num ^ (MOD - 2)) % MOD
    long long int ans = 1, base = (long long) num;
    int power = MOD - 2;
    while (power > 0) {
        if (power == 1) {
            return (ans * base) % MOD;
        }
        if (power % 2 == 0) {
            base = (base * base) % MOD;
            power /= 2;
        } else {
            ans = (ans * base) % MOD;
            power--;
        }
    }
    return ans;
}

int Solution::findRank(string A) {
    // Initializations
    int charCount[256]; // count of characters in A. 
    memset(charCount, 0, sizeof(charCount));
    for (int i = 0; i < A.length(); i++) {
        charCount[A[i]]++;
    }
    vector<int> fact; // fact[i] will contain i! % MOD
    initializeFactorials(A.length() + 1, fact);

    long long int rank =  1;
    for (int i = 0; i < A.length(); i++) {
        // find number of permutations placing character smaller than A[i] at ith position 
        // among characters from i to A.length 
        long long int less = 0;
        int remaining = A.length() - i - 1;
        for (int ch = 0; ch < A[i]; ch++) {
            if (charCount[ch] == 0) continue;
            // Lets try placing ch as the first character in remaining characters
            // and check the number of permutation possible.
            charCount[ch]--;
            long long int numPermutation = fact[remaining];
            for (int c = 0; c < 128; c++) {
                if (charCount[c] <= 1) continue; 
                numPermutation = (numPermutation * inverseNumber(fact[charCount[c]])) % MOD;
            }
            charCount[ch]++;
            less = (less + numPermutation) % MOD;
        }
        rank = (rank + less) % MOD;
        // remove the current character from the set. 
        charCount[A[i]]--;
    }
    return rank;
}
```

