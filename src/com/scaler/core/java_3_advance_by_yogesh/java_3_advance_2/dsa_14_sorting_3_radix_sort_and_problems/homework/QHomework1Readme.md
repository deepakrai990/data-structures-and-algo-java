### Q1. Largest Number
#### Problem Description
```text
Given an array A of non-negative integers, arrange them such 
that they form the largest number.

Note: The result may be very large, so you need to return a 
string instead of an integer.
```
#### Problem Constraints
* <p>1 &lt;= len(A) &lt;= 100000</p>
* <p>0 &lt;= A[i] &lt;= 2*10<sup>9</sup></p>
```text
1 <= len(A) <= 100000
0 <= A[i] <= 2*10^9
```
#### Input Format
```text
The first argument is an array of integers.
```
#### Output Format
```text
Return a string representing the largest number.
```
#### Example Input
```text
Input 1:
 A = [3, 30, 34, 5, 9]

Input 2:
 A = [2, 3, 9, 0]
```
#### Example Output
```text
Output 1:
 "9534330"

Output 2:
 "9320"

```
#### Example Explanation
```text
Explanation 1:
    Reorder the numbers to [9, 5, 34, 3, 30] to form the largest number.

Explanation 2:
    Reorder the numbers to [9, 3, 2, 0] to form the largest number 9320.
```
### Hints
* Hint 1
```text
**Hint: Sorting**

Think about what kind of sorting would be needed. We can't simply 
sort the numbers or strings.

Have you considered cases like 27, 271, or 12, 121?
```
* Solution Approach
```text
Sorting all numbers in descending order is the simplest solution 
that occurs to us. But this does not work. 

For example, 548 is greater than 60, but in the output, 60 comes 
before 548. As a second example, 98 is greater than 9, but 9 
comes before 98 in the output.

The solution is to use any comparison-based sorting 
algorithm. Thus, instead of using the default comparison, write 
a comparison function myCompare() and use it to sort numbers. 

Given two numbers, X and Y, how should myCompare() decide 
which number to put first – we compare two 
numbers XY (Y appended at the end of X) and 
YX (X appended at the end of Y). 

If XY is greater, then, in the output, X should come 
before Y, else Y should come before X. 

For example, let X and Y be 542 and 60. To compare X and Y, we 
compare 54260 and 60542. Since 60542 is greater 
than 54260, we put Y first.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    // DO NOT MODIFY THE LIST
    public String largestNumber(final List < Integer > A) {
        StringBuffer strBuf = new StringBuffer();
        Node num[];
        int i = 0;
        num = new Node[A.size()];
        for (int n: A) {
            num[i] = new Node(n);
            i++;
        }
        // sorts the array lexicographically
        Arrays.sort(num);
        for (Node n: num) {
            if (n.number == 0 && strBuf.length() != 0)
                continue;
            strBuf.append(n.number);
        }
        return strBuf.toString();
    }
    class Node implements Comparable < Node > {
        int number;
        public Node(int number) {
            this.number = number;
        }
        @Override
        public int compareTo(Node o) {
            String first = String.valueOf(this.number) + String.valueOf(o.number);
            String second = String.valueOf(o.number) + String.valueOf(this.number);
            return second.compareTo(first);
        }
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    largestNumber: function (A) {
        // sorts the array lexicographically
        A.sort((a, b) => {
            if (a + "" + b > b + "" + a) 
                return -1;
            else 
                return 1;
        });
    
        let ans = "";
        A.forEach((ele) => (ans += ele));
        if (ans[0] == "0") 
            return 0;
        return ans;
    },
};
```
* * Solution in C++
```cpp
bool compareNum(string a, string b) {
    return a + b > b + a;
}
string Solution::largestNumber(const vector < int > & num) {
    string result;
    vector < string > str;
    // convert the integers to strings
    for (int i = 0; i < num.size(); i++) {
        str.push_back(to_string(num[i]));
    }
    // sorts the array lexicographically
    sort(str.begin(), str.end(), compareNum);
    for (int i = 0; i < str.size(); i++) {
        result += str[i];
    }
    int pos = 0;
    while (result[pos] == '0' && pos + 1 < result.size()) 
        pos++;
    return result.substr(pos);
}
```

