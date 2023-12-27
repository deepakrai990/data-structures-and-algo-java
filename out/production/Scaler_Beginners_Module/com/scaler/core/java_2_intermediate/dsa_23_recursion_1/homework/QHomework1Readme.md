### Q1. Print reverse string
#### Problem Description
```text
Write a recursive function that, given a string S, prints 
the characters of S in reverse order.
```
#### Problem Constraints
```text
1 <= |s| <= 1000
```
#### Input Format
```text
First line of input contains a string S.
```
#### Output Format
```text
Print the character of the string S in reverse order.
```
#### Example Input
```text
Input 1:
 scaleracademy

Input 2:
 cool
```
#### Example Output
```text
Output 1:
 ymedacarelacs

Output 2:
 looc
```
#### Example Explanation
```text
Explanation 1:
    Print the reverse of the string in a single line.
```
### Hints
* Hint 1
```text
Recursive function (reverse) takes string (S) as input and 
calls itself with next location to passed pointer (s+1).
```
* Solution Approach
```text
Recursive function (reverse) takes string (S) as input and 
calls itself with next location to passed pointer (s+1).

Recursion continues this way, when pointer reaches ‘\0’, all 
functions accumulated in stack print char at passed 
location (S) and print one by one.

Time Complexity: O(n)
```
* Complete Solution
* * Solution in Java
```java
import java.lang.*;
import java.util.*;

public class Main {
    public static void solve(String s) {
        if (s.length() == 0) {
            return;
        }
        solve(s.substring(1));
        System.out.print(s.charAt(0));
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String str = cin.nextLine();
        solve(str);
    }
}
```
* * Solution in Javascript
```javascript
'use strict';

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => {
    inputString += inputStdin;
});

process.stdin.on('end', _ => {
    inputString = inputString.trim().split('\n').map(string => {
        return string.trim();
    });
    main();    
});

function readline() {
    return inputString[currentLine++];
}

function solve(s) {
    if(s.length == 0)
        return ;
    
    let n = s.length;
    solve(s.substr(1,n));
    process.stdout.write(s[0]);
    
}
function main() {
    
    let s = readline();
    solve(s);
}
```
* * Solution in C++
```cpp
#include<iostream>

using namespace std;

void printreverse(string S){
    if(S.size() == 0) {
        return;
    }
    printreverse(S.substr(1));
    cout<<S[0];
}

int main()  {
    string s;
    cin>>s;
    printreverse(s);
    return 0;
}
```

