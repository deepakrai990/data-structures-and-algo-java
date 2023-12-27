### Q6. Find Time Complexity - 7
#### Problem Description
```text
What is the time complexity of the following code snippet

for(int i = 0 ; i < n ; i++){
    for(int j = 0 ; j <= i ; j++){
        print(i+j);
    }
}
```
#### Options
```text
1. O(n^2)
2. O(n)
3. O(n log n)
4. O(n^3)
```

* Complete Solution
```text
The total number of times the print statement gets executed 
is (1+2+3+...n) = n*(n+1)/2

Thus the time complexity is O(n^2)
```

