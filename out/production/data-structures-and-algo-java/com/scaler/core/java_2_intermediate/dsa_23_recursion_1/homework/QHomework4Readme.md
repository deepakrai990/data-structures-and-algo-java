### Q4. Output - 7
#### Problem Description
```text
Guess the output for the following program:
```
<ul>
    <li>C++</li>
    <li>Java</li>
    <li>Python</li>
</ul>
<pre>int fun(int x, int n) {
    if (n == 0)
        return 1;
    else if (n % 2 == 0)
        return fun(x * x, n / 2);
    else
        return x * fun(x * x, (n - 1) / 2);
}
int main() {
    int ans = fun(2, 10);
    printf("%d", ans);
    return 0;
}
</pre>
<pre>public int fun(int x, int n) {
    if (n == 0)
        return 1;
    else if (n % 2 == 0)
        return fun(x * x, n / 2);
    else
        return x * fun(x * x, (n - 1) / 2);
}
public void main() {
    int ans = fun(2, 10);
    System.out.println(ans);
}
</pre>
<pre>def fun(x, n):
    if (n == 0):
        return 1
    elif (n % 2 == 0):
        return fun(x * x, n //2)
    else:
        return x * fun(x * x, (n - 1) // 2)

ans = fun(2, 10)
print(ans)
</pre>

#### Options
```text
1. 1023
2. 2048
3. 1024
4. None of these
```

* Solution Approach
```text
The recursive function is using the binary representation of n.
```
* Complete Solution

<div style="background-color: #f9f9f9; padding: 5px 10px; ">
    <p>The above function performs binary exponentiation 
    which returns <b>x<sup>n</sup></b>, hence the answer 
    is <b>2<sup>10</sup> = 1024</b>.</p>
</div>
