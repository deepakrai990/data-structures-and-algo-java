### Q2. Find Time Complexity - 2
#### Problem Description
```text
What is the time complexity of the following code snippet

void solve(int N, int M) {
    for(int i = 1 ; i <= N ; i++) {
        if(N % i == 0)
            print(i);
    }

    for(int i = 1 ; i <= M ; i++) {
        if(M % i == 0)
            print(i);
    }
}
```
#### Options
```text
1. O(N)
2. O(M)
3. O(N+M)
4. O(NM)
```

* Complete Solution
```text
The answer is O(N + M)
The first loop runs for N times and the second one runs for M times.
```

