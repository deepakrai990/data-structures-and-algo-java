### Q8. Divide by 2
#### Problem Description
```text
What is the number of times we need to divide N by 2 till it reaches 1 ?
```
#### Options
```text
1. ceil(log N)
2. floor(log N)
3. log N
4. N / 2
```

* Complete Solution
```text
Let N be the number (N > 1) that you want to divide. Say that you have 
to divide it k times. Then

1 <= N / 2^k < 2

Therefore, 

0 = log1 <= -k + logN < log2 = 1
k <= logN < k + 1
k = floor(logN)
```